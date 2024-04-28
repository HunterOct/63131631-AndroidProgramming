package ntu.huutuong.vidu2_intent_nangcao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NhapLieuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nhap_lieu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void Thoat(View v){
        System.exit(0);
    }
    public void XacNhanDuLieu(View v){
        EditText edtHoTen = ((EditText) findViewById(R.id.edtHoTen));
        EditText edtNamSinh = ((EditText) findViewById(R.id.edtNamSinh));
        String hoTen = edtHoTen.getText().toString();
        int namSinh = Integer.parseInt(edtNamSinh.getText().toString());
        Intent iKetQua = new Intent();
        iKetQua.putExtra("HT", hoTen);
        iKetQua.putExtra("NS", namSinh);
        setResult(RESULT_OK, iKetQua);
        finish();
    }
}