package ntu.huutuong.usingrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerviewData ;
    RecyclerView recyclerViewLandScape;
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
    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsDulieu = new ArrayList<>();
        LandScape landScape1 = new LandScape("16352112_v859-katie-19", "Ảnh 1");
        dsDulieu.add(landScape1);
        LandScape landScape2 = new LandScape("Notebook-bro", "Ảnh 2");
        dsDulieu.add(landScape2);
        LandScape landScape3 = new LandScape("Thiết kế chưa có tên (1)", "Ảnh 3");
        dsDulieu.add(landScape3);
        LandScape landScape4 = new LandScape("—Pngtree—flat design abstrak color soft_1912235", "Ảnh 4");
        dsDulieu.add(landScape4);
    }
}