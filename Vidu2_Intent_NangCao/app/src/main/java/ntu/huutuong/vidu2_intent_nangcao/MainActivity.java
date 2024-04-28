package ntu.huutuong.vidu2_intent_nangcao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void MoNhapLieu(View v){
        Intent iNhapLieu = new Intent(this,NhapLieuActivity.class);
        startActivityForResult(iNhapLieu, 8000);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 8000) {
            if(resultCode == RESULT_OK) {
                String hoTenNhanDuoc = data.getStringExtra("HT");
                int namSinhNhanDuoc = data.getIntExtra("NS",200);
                TextView tvHT = (TextView) findViewById(R.id.tvHoten);
                TextView tvNs = (TextView) findViewById(R.id.tvNamSinh);
                tvHT.setText(hoTenNhanDuoc);
                tvNs.setText(String.valueOf(namSinhNhanDuoc));
            }
            else {
                Toast.makeText(this, "Trả Về Thất Bại", Toast.LENGTH_LONG).show();
            }
        }
        else
            super.onActivityResult(requestCode, resultCode, data);
    }
}