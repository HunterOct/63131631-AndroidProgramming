package LeDoanHuuTuong.BaiKT1;

import static java.lang.System.exit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int newAttemps = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void dangnhap (View view){
        // Lấy Dữ liệu từ android app
        EditText User = findViewById(R.id.edit_user);
        EditText Pass = findViewById(R.id.edit_pass);
        EditText Attemps = findViewById(R.id.edit_Attemps);
        Button Login = findViewById(R.id.btn_login);
        // chuyển dữ liệu
        String strUser = String.valueOf(User.getText());
        String strPass = String.valueOf(Pass.getText());


         //check dữ liệu
        if (strUser.equals("maicuongtho") && strPass.equals("Cntt63ntu!"))
            Toast.makeText(this, "User and Password is correct", Toast.LENGTH_SHORT).show();
        else
        {
            Toast.makeText(this, "User and Password is wrong", Toast.LENGTH_SHORT).show();
            newAttemps--;
        }
        if(newAttemps == 0)
        {
            Toast.makeText(this, "Bạn đã vượt quá số lần thử. Ứng dụng sẽ thoát ngay sau khi đóng thông báo này.", Toast.LENGTH_LONG).show();
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            finishAffinity(); // Đóng tất cả các activity và thoát ứng dụng
                        }
                    },
                    5000 // Thời gian chờ trước khi thoát (đơn vị: milliseconds)
            );
            //System.exit(0);
        }
        String StrAttemps = String.valueOf(newAttemps);
        Attemps.setText(StrAttemps);
    }
}