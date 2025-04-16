package huutuong_63131631.ungdungbanhang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.nex3z.notificationbadge.NotificationBadge;

import java.text.DecimalFormat;

import huutuong_63131631.ungdungbanhang.R;
import huutuong_63131631.ungdungbanhang.model.GioHang;
import huutuong_63131631.ungdungbanhang.model.SanPham;
import huutuong_63131631.ungdungbanhang.utils.Utils;
import okhttp3.internal.Util;

public class ChiTietActivity extends AppCompatActivity {
    TextView tenSp, giaSp, moTaSp;
    Button btnThemVaoGio;
    ImageView imgHinhSp;
    Spinner spinner;
    Toolbar toolbar;
    SanPham sanPham;
    NotificationBadge badge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chi_tiet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Initview();
        ActionToolBar();
        InitData();
        InitControl();
    }
    private void InitControl() {
        btnThemVaoGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themGioHang();

            }
        });
    }
    private void themGioHang() {
        if(Utils.listGioHang.size() > 0){
            boolean flag = false;
            int soLuong = Integer.parseInt(spinner.getSelectedItem().toString());
            for(int i = 0;i<Utils.listGioHang.size();i++) {
                if (Utils.listGioHang.get(i).getMa_sp() == sanPham.getMa_sp()) {
                    Utils.listGioHang.get(i).setSoluong(soLuong + Utils.listGioHang.get(i).getSoluong());
                    float gia = sanPham.getGia_sp() * Utils.listGioHang.get(i).getSoluong();
                    Utils.listGioHang.get(i).setGia_sp(gia);
                    flag = true;
                }
            }
            if(flag == false){
                float gia = sanPham.getGia_sp() * soLuong;
                GioHang gioHang = new GioHang();
                gioHang.setGia_sp(gia);
                gioHang.setSoluong(soLuong);
                gioHang.setMa_sp(sanPham.getMa_sp());
                gioHang.setTen_sp(sanPham.getTen_sp());
                gioHang.setAnh_sp(sanPham.getAnh_sp());
                Utils.listGioHang.add(gioHang);
            }
        }else{
            int soLuong = Integer.parseInt(spinner.getSelectedItem().toString());
            float gia = sanPham.getGia_sp() * soLuong;
            GioHang gioHang = new GioHang();
            gioHang.setGia_sp(gia);
            gioHang.setSoluong(soLuong);
            gioHang.setMa_sp(sanPham.getMa_sp());
            gioHang.setTen_sp(sanPham.getTen_sp());
            gioHang.setAnh_sp(sanPham.getAnh_sp());
            Utils.listGioHang.add(gioHang);
        }
        int totalItem = 0;
        for (int i = 0; i < Utils.listGioHang.size(); i++) {
            totalItem += Utils.listGioHang.get(i).getSoluong();
        }
        badge.setText(String.valueOf(totalItem));
    }
    private void InitData(){
        sanPham = (SanPham) getIntent().getSerializableExtra("chitiet");
        if (sanPham != null) {
            tenSp.setText(sanPham.getTen_sp());
            moTaSp.setText(sanPham.get_Mota());
            Glide.with(getApplicationContext()).load(sanPham.getAnh_sp()).into(imgHinhSp);
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            giaSp.setText("Giá: " + decimalFormat.format(sanPham.getGia_sp()) + " Đ");
            Integer[] sl = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            ArrayAdapter<Integer> adapterspin = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sl);
            spinner.setAdapter(adapterspin);
        }
    }
    private void Initview() {
        tenSp = findViewById(R.id.txt_tensanphamchitiet);
        giaSp = findViewById(R.id.txt_giabanchitiet);
        moTaSp = findViewById(R.id.txt_motachitiet);
        btnThemVaoGio = findViewById(R.id.btn_themgiohangchitet);
        imgHinhSp = findViewById(R.id.img_anhspchitiet);
        spinner = findViewById(R.id.spinner_chitiet);
        toolbar = findViewById(R.id.toolbar_chitiet);
        badge = findViewById(R.id.badge_soLuongGioHang);
        FrameLayout frameLayoutGioHang = findViewById(R.id.frame_giohang);
        frameLayoutGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent giohang = new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(giohang);
            }
        });
        if(Utils.listGioHang != null){
            int totalItem = 0;
            for (int i = 0; i < Utils.listGioHang.size(); i++) {
                totalItem += Utils.listGioHang.get(i).getSoluong();
            }
            badge.setText(String.valueOf(totalItem));
        }
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

}