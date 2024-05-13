package ntu.huutuong.bottomnavigator2;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                int itemid = menuItem.getItemId();
                if (itemid == R.id.nav_home) {
                    selectedFragment = new HomeFragment();
                } else if (itemid == R.id.nav_search) {
                    selectedFragment = new SearchFragment();
                } else if (itemid == R.id.nav_notify) {
                    selectedFragment = new NotifyFragment();
                }
//                switch (menuItem.getItemId()) {
//                    case R.id.nav_home:
//                        selectedFragment = new HomeFragment();
//                        break;
//                    case R.id.nav_search:
//                        selectedFragment = new SearchFragment();
//                        break;
//                    case R.id.nav_notify:
//                        selectedFragment = new NotifyFragment();
//                        break;
//                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, selectedFragment).commit();
                return true;
            }
        });
    }
}