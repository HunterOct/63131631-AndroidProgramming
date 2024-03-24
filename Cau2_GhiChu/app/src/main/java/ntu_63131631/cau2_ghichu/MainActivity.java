package ntu_63131631.cau2_ghichu;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Ẩn thanh tiêu đề
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);

        btnNote = findViewById(R.id.btn_add_note);
        lv_Notes = (ListView) findViewById(R.id.list_view_notes);
        dsNote = new ArrayList<String>();
        //custom adapter
        nguonDuLieu = new NotesAdapter(this,dsNote);
        lv_Notes.setAdapter(nguonDuLieu);
    }
}