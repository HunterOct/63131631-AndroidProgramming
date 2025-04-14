package huutuong_63131631.ungdungbanhang.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import huutuong_63131631.ungdungbanhang.R;
import huutuong_63131631.ungdungbanhang.adapter.BanhKemAdapter;
import huutuong_63131631.ungdungbanhang.model.SanPham;
import huutuong_63131631.ungdungbanhang.retrofit.APIBanHang;
import huutuong_63131631.ungdungbanhang.retrofit.RetrofitClient;
import huutuong_63131631.ungdungbanhang.utils.Utils;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BanhKemActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    APIBanHang apiBanHang;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    int page = 1;
    String loai_sp;
    BanhKemAdapter banhKemAdapter;
    List<SanPham> listSanPham;
    LinearLayoutManager linearLayoutManager;
    Handler handler = new Handler();
    boolean isLoading = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_banh_kem);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(APIBanHang.class);
        loai_sp = String.valueOf(getIntent().getIntExtra("ma_loaisp", 1));
        AnhXa();
        ActionToolBar();
        getData(page);
        addEventLoad();
    }

    private void addEventLoad() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isLoading == false) {
                    if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == listSanPham.size() - 1) {
                        isLoading = true;
                        loadMore();
                    }

                }
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }

    private void loadMore() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                listSanPham.add(null);
                banhKemAdapter.notifyItemInserted(listSanPham.size() - 1);
            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                listSanPham.remove(listSanPham.size() - 1);
                banhKemAdapter.notifyItemRemoved(listSanPham.size());
                page++;
                getData(page);
            }
        }, 2000);
    }

    private void getData(int page) {
        compositeDisposable.add(apiBanHang.getChiTietSanPham(page, loai_sp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(sanPhamModel -> {
                    if (sanPhamModel.isSuccess()) {
                        if (banhKemAdapter == null) {
                            listSanPham = sanPhamModel.getResult();
                            banhKemAdapter = new BanhKemAdapter(this, listSanPham);
                            recyclerView.setAdapter(banhKemAdapter);
                        } else {
                            int viTri = listSanPham.size();
                            int soLuongadd = sanPhamModel.getResult().size();
                            listSanPham.addAll(sanPhamModel.getResult());
                            banhKemAdapter.notifyItemRangeInserted(viTri, soLuongadd);
                        }
                        isLoading = false;
                    } else {
                        Toast.makeText(getApplicationContext(), "Hết dữ liệu", Toast.LENGTH_LONG).show();
                        isLoading = true;
                    }
                }, throwable -> {
                    Toast.makeText(this, "Lỗi: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    isLoading = false;
                }));
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void AnhXa() {
        toolbar = findViewById(R.id.toolbar_chitiet);
        recyclerView = findViewById(R.id.recyclerView_banhkem);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        listSanPham = new ArrayList<>();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}