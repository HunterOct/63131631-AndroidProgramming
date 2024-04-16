package ntu.huutuong.viewpager2recycerviewadapter;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

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
        recyclerviewData = getDataForViewPager();
        //4
        vỉewPager2Land = findViewById(R.id.viewpager2);
        //6
        landScapeAdapter = new LandScapeAdapter(this, recyclerviewData);
        //7
        vỉewPager2Land.setAdapter(landScapeAdapter);
        vỉewPager2Land.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

            }
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
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