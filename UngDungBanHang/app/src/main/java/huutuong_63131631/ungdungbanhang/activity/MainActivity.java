package huutuong_63131631.ungdungbanhang.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import huutuong_63131631.ungdungbanhang.R;
import huutuong_63131631.ungdungbanhang.adapter.LoaiSpAdapter;
import huutuong_63131631.ungdungbanhang.adapter.SanPhamAdapter;
import huutuong_63131631.ungdungbanhang.model.LoaiSp;
import huutuong_63131631.ungdungbanhang.model.LoaiSpModel;
import huutuong_63131631.ungdungbanhang.model.SanPham;
import huutuong_63131631.ungdungbanhang.model.SanPhamModel;
import huutuong_63131631.ungdungbanhang.retrofit.APIBanHang;
import huutuong_63131631.ungdungbanhang.retrofit.RetrofitClient;
import huutuong_63131631.ungdungbanhang.utils.Utils;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewManHinhChinh;
    ListView listViewManHinhChinh;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    LoaiSpAdapter loaiSpAdapter;
    List<LoaiSp> mangLoaiSp;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    APIBanHang apiBanHang;
    List<SanPham> mangSanPham;
    SanPhamAdapter sanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(APIBanHang.class);
        AnhXa();
        ActionBar();
        if(isConnected(this)){
            //Toast.makeText(this, "Đã kết nối", Toast.LENGTH_LONG).show();
            ActionViewFlipper();
            getLoaiSp();
            getSanPham();
            getEvenClick();
        }
        else {
            Toast.makeText(this, "không có internet", Toast.LENGTH_LONG).show();
        }
    }
    private void getEvenClick(){
        listViewManHinhChinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                switch (i){
                    case 0:
                        Intent trangChu = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(trangChu);
                        break;
                    case 1:
                        Intent banhKem = new Intent(getApplicationContext(), BanhKemActivity.class);
                        banhKem.putExtra("ma_loaisp",1);
                        startActivity(banhKem);
                        break;
                    case 2:
                        Intent banhMi = new Intent(getApplicationContext(), BanhMiActivity.class);
                        banhMi.putExtra("ma_loaisp",2);
                        startActivity(banhMi);
                        break;
                    case 3:
                        Intent banhNgot = new Intent(getApplicationContext(), BanhNgotActivity.class);
                        startActivity(banhNgot);
                        break;

                }
            }
        });
    }
    private void getSanPham() {
        compositeDisposable.add(apiBanHang.getSanPham()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sanPhamModel -> {
                            if (sanPhamModel.isSuccess()) {
                                mangSanPham = sanPhamModel.getResult();
                                sanPhamAdapter = new SanPhamAdapter(getApplicationContext(),mangSanPham);
                                recyclerViewManHinhChinh.setAdapter(sanPhamAdapter);
                            }
                        },
                        throwable -> {
                            Toast.makeText(getApplicationContext(), "Không có kết nối" + throwable.getMessage(), Toast.LENGTH_LONG).show();
                        }
                ));
    }
    private void getLoaiSp() {
        compositeDisposable.add(apiBanHang.getLoaiSp()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        loaiSpModel -> {
                            if (loaiSpModel.isSuccess()) {
                                //Toast.makeText(getApplicationContext(), loaiSpModel.getResult().get(0).getTenloaisp(), Toast.LENGTH_LONG).show();
                                mangLoaiSp = loaiSpModel.getResult();
                                loaiSpAdapter = new LoaiSpAdapter(mangLoaiSp,getApplicationContext());
                                listViewManHinhChinh.setAdapter(loaiSpAdapter);
                            }
                        }
                ));

    }

    private void ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    private void ActionViewFlipper(){
        List<String> mangQuangCao = new ArrayList<>();
        mangQuangCao.add("https://file.hstatic.net/200000665395/article/content-ve-banh-ngot-9_20d6334a75644f6caf3db603213f71bf.jpg");
        mangQuangCao.add("https://file.hstatic.net/200000665395/article/content-ve-banh-ngot-9_20d6334a75644f6caf3db603213f71bf.jpg");
        mangQuangCao.add("https://file.hstatic.net/200000665395/article/content-ve-banh-ngot-9_20d6334a75644f6caf3db603213f71bf.jpg");
        for(int i = 0; i < mangQuangCao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(mangQuangCao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation slider_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slider_in_right);
        Animation slider_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slider_out_right);
        viewFlipper.setInAnimation(slider_in);
        viewFlipper.setOutAnimation(slider_out);
    }
    private void AnhXa(){
        toolbar = findViewById(R.id.toolbarManHinhChinh);
        viewFlipper = findViewById(R.id.viewFlipper);
        recyclerViewManHinhChinh = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerViewManHinhChinh.setLayoutManager(layoutManager);
        recyclerViewManHinhChinh.setHasFixedSize(true);
        listViewManHinhChinh = findViewById(R.id.listViewManHinhChinh);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);
        // khoi tao list
        mangLoaiSp = new ArrayList<>();
        mangSanPham = new ArrayList<>();

    }
    private boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if(wifi != null && wifi.isConnected() || (mobile != null && mobile.isConnected())){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}