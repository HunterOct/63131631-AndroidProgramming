package ntu.huutuong.viewpager2recycerviewadapter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerviewData ;
    ViewPager2 vỉewPager2Land;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3
        recyclerviewData = getDataForRecyclerView();
        //4
        recyclerViewLandScape = findViewById(R.id.viewpager2);
        //5

//        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
//        recyclerViewLandScape.setLayoutManager(layoutLinear);

        RecyclerView.LayoutManager layoutLinearHorizonal = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewLandScape.setLayoutManager(layoutLinearHorizonal);

//        RecyclerView.LayoutManager layoutLinearGrid = new GridLayoutManager(this,2);
//        recyclerViewLandScape.setLayoutManager(layoutLinearGrid);


        //6
        landScapeAdapter = new LandScapeAdapter(this, recyclerviewData);
        //7
        recyclerViewLandScape.setAdapter(landScapeAdapter);
    }
    ArrayList<LandScape> getDataForViewPager(){
        ArrayList<LandScape> dsDulieu = new ArrayList<>();
        LandScape landScape1 = new LandScape("image2", "Ảnh 1");
        dsDulieu.add(landScape1);
        LandScape landScape2 = new LandScape("image2", "Ảnh 2");
        dsDulieu.add(landScape2);
        LandScape landScape3 = new LandScape("image2", "Ảnh 3");
        dsDulieu.add(landScape3);
        LandScape landScape4 = new LandScape("image2", "Ảnh 4");
        dsDulieu.add(landScape4);
        return dsDulieu;
    }
}