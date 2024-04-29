package ntu.huutuong.vidu2_manhinhdangnhap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
    public void XacNhan(View v){
        EditText edtUsername = ((EditText) findViewById(R.id.edtUsername));
        EditText edtPass = ((EditText) findViewById(R.id.edtPass));
        EditText edtEmail = ((EditText) findViewById(R.id.edtEmail));
        String userName = edtUsername.getText().toString();
        String userPass = edtPass.getText().toString();
        String userEmail = edtEmail.getText().toString();
        if(userName.equals("63CNTT2") && userPass.equals("ABCDEF")){
            Intent iHome = new Intent(this, HomeActivity.class);
            startActivity(iHome);
        }
        else{
            Toast.makeText(this, "Đăng Nhập Thất Bại", Toast.LENGTH_LONG).show();
        }
        finish();
    }
}