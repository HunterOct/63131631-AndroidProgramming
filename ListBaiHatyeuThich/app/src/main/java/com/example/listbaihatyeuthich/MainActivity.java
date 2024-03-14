package com.example.listbaihatyeuthich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hiển Thị dữ liệu lên listview
        //B1. Chuẩn bị nguồn dữ liệu
        ArrayList<String> nguonDuLieu = new ArrayList<String>();
        nguonDuLieu.add("Từng Là");
        nguonDuLieu.add("Vết Mưa");
        nguonDuLieu.add("Casablenca");
        //B2.tham chiếu đến listview
        ListView danhSach = (ListView) findViewById(R.id.DanhSachBaiHat);
        //B3.1 Tạo adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                nguonDuLieu);
        //B4 Gắn/Nạp Dữ liệu từ nguồn vào ListView
        danhSach.setAdapter(adapter);
        //Xử lý sự kiện
        danhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // i là vị trí của item được click trên listview
                // Lấy giá trij của item vừa click
                String value = adapter.getItem(i);
                Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();
            }
        });

    }
}