package com.example.ex4addsubmuldivonclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText StrEditA ;
    EditText StrEditB ;
    EditText StrKQ ;
    Button Cong ,Tru,Nhan ,Chia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DieuKien();
    }
    void DieuKien(){
        StrEditA = findViewById(R.id.EditA);
        StrEditB = findViewById(R.id.EditB);
        StrKQ = findViewById(R.id.EditKQ);
        Cong = findViewById(R.id.btnCong);
        Tru = findViewById(R.id.btnTru);
        Nhan = findViewById(R.id.btnNhan);
        Chia = findViewById(R.id.btnChia);
    }
    public void PhepTinhCong(View view){
        // Lay du lieu tu o nhap

        // đổi dữ liệu sang kiểu string
        String SoA = StrEditA.getText().toString();
        String SoB = StrEditB.getText().toString();
        // CHuyển dữ liệu sang số
        int So_A = Integer.parseInt(SoA);
        int So_B = Integer.parseInt(SoB);
        // Tinh Toan
        int Cong = So_A + So_B;
        // Chuyển DỮ liệu lại thành String
        String KQ = String.valueOf(Cong);
        StrKQ.setText(KQ);

    }
    public void PhepTinhTru(View view){
        // Lay du lieu tu o nhap

        // đổi dữ liệu sang kiểu string
        String SoA = StrEditA.getText().toString();
        String SoB = StrEditB.getText().toString();
        // CHuyển dữ liệu sang số
        int So_A = Integer.parseInt(SoA);
        int So_B = Integer.parseInt(SoB);
        // Tinh Toan
        int Cong = So_A - So_B;
        // Chuyển DỮ liệu lại thành String
        String KQ = String.valueOf(Cong);
        StrKQ.setText(KQ);

    }
    public void PhepTinhNhan(View view){
        // Lay du lieu tu o nhap

        // đổi dữ liệu sang kiểu string
        String SoA = StrEditA.getText().toString();
        String SoB = StrEditB.getText().toString();
        // CHuyển dữ liệu sang số
        int So_A = Integer.parseInt(SoA);
        int So_B = Integer.parseInt(SoB);
        // Tinh Toan
        int Cong = So_A * So_B;
        // Chuyển DỮ liệu lại thành String
        String KQ = String.valueOf(Cong);
        StrKQ.setText(KQ);

    }
    public void PhepTinhChia(View view){
        // Lay du lieu tu o nhap

        // đổi dữ liệu sang kiểu string
        String SoA = StrEditA.getText().toString();
        String SoB = StrEditB.getText().toString();
        // CHuyển dữ liệu sang số
        int So_A = Integer.parseInt(SoA);
        int So_B = Integer.parseInt(SoB);
        // Tinh Toan
        int Cong = So_A / So_B;
        // Chuyển DỮ liệu lại thành String
        String KQ = String.valueOf(Cong);
        StrKQ.setText(KQ);

    }
}