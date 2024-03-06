package com.example.ex3_simplesumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void Xulycong(View view){
        // tham chiếu điều khiển trên tệp xml
        EditText edittextA = findViewById(R.id.editA);
        EditText edittextB = findViewById(R.id.editB);
        EditText edittextKQ = findViewById(R.id.editKQ);
        // lấy dữ liêu từ ô chuyển sang string
        String soA = edittextA.getText().toString();
        String soB = edittextB.getText().toString();
        // chuyển dữ liêu sang số
        int so_a = Integer.parseInt(soA);
        int so_b = Integer.parseInt(soB);
        // Tính toán
        int tong = so_a + so_b;
        // hiện kq ra màn hình
        // Đổi số sang chuôi
        String strKQ = String.valueOf(tong);
        edittextKQ.setText(strKQ);

    }
}