package com.example.vdulistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtThongTin ;
    ListView lvten ;
    // Luu trữ Danh Sách Tên
    ArrayList<String> dsten ;
    ArrayAdapter<String> nguonDuLieu;
    // Hàm lấy Tham CHiếu
    void getControls (){
        edtThongTin = (EditText) findViewById(R.id.Edthongtin);
        lvten = (ListView) findViewById(R.id.lvTen);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControls();
        dsten = new ArrayList<String>();
        dsten.add("Tường");
        dsten.add("Hạnh");
        dsten.add("Phương Anh");
        // Tạo adapter và gắn vào nguồn dữ liệu
        nguonDuLieu = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dsten);
        // Gắn bộ nguồn vào list
        lvten.setAdapter(nguonDuLieu);
    }
    public void ThemPhanTu(View view){
        EditText edtThemTen = findViewById(R.id.edtThemTen);
        String tenNhap = edtThemTen.getText().toString();
        dsten.add(tenNhap);
        nguonDuLieu.notifyDataSetChanged();
    }
}