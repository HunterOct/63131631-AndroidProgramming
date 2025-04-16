package huutuong_63131631.ungdungbanhang.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import huutuong_63131631.ungdungbanhang.R;
import huutuong_63131631.ungdungbanhang.adapter.GioHangAdapter;
import huutuong_63131631.ungdungbanhang.model.GioHang;
import huutuong_63131631.ungdungbanhang.utils.Utils;

public class GioHangActivity extends AppCompatActivity {
    TextView gioHangTrong,tongtien;
    Toolbar toolbarGioHang;
    RecyclerView recyclerViewGioHang;
    Button muahang;
    GioHangAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        Initview();
        InitControl();
    }
    private void InitControl(){
        setSupportActionBar(toolbarGioHang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarGioHang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recyclerViewGioHang.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewGioHang.setLayoutManager(layoutManager);
        if(Utils.listGioHang.size() == 0){
            gioHangTrong.setVisibility(View.VISIBLE);
        }else{
            adapter = new GioHangAdapter(getApplicationContext(), Utils.listGioHang);
            recyclerViewGioHang.setAdapter(adapter);
        }
    }
    private void Initview() {
        gioHangTrong = findViewById(R.id.txt_gioHangTrong);
        toolbarGioHang = findViewById(R.id.toolbar_gioHang);
        recyclerViewGioHang = findViewById(R.id.recyclerView_GioHang);
        tongtien = findViewById(R.id.txt_tongtien);
        muahang = findViewById(R.id.btn_muahang);
    }
}
