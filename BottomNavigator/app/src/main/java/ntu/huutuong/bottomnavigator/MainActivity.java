package ntu.huutuong.bottomnavigator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    protected final int search = 1;
    protected final int home = 2;
    protected final int notification = 3;
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
        MeowBottomNavigation bottomNavigation = findViewById(R.id.MeowbottomNavigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(search, R.drawable.ic_search_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(home, R.drawable.ic_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(notification, R.drawable.ic_notifycation_24));

        // cài đặt hiển thị fragment hiện tại
        LoadFragment(new home_fragment());

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            // thay  đổi màu nền ,màu icon,...
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(MainActivity.this, "Clicked item : " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
//                String name;
//                switch (item.getId()) {
//
//                    case search:
//                        name = "Search";
//                        break;
//                    case home:
//                        name = "Home";
//                        break;
//                    case notification:
//                        name = "Notification";
//                        break;
//                    default:
//                        throw new IllegalStateException("Unexpected value: " + item.getId());
//                }



                switch (item.getId()) {
                    case search:
                        LoadFragment(new search_fragment());
                        break;
                    case home:
                        LoadFragment(new home_fragment());
                        break;
                    case notification:
                        LoadFragment(new notifycation_fragment());
                        break;
                    default:
                        LoadFragment(new home_fragment());
                        break;
                }
                bottomNavigation.setCount(home, "10");
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });


    }

    private void LoadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new home_fragment(),null).commit();
    }
}