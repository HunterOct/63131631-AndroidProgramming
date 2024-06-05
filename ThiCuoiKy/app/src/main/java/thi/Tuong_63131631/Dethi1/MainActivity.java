package thi.Tuong_63131631.Dethi1;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_bottom);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                int itemid = menuItem.getItemId();
                if (itemid == R.id.navigation_bmi)
                    selectedFragment = new BMIFragment();
                else if (itemid == R.id.navigation_home)
                    selectedFragment = new HomeFragment();
                else if (itemid == R.id.navigation_city)
                    selectedFragment = new FamousCityFragment();
                else if (itemid == R.id.navigation_notes)
                    selectedFragment = new NotesFragment();
                else if (itemid == R.id.navigation_profile)
                    selectedFragment = new ProfileFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectedFragment).commit();
                return true;
            }
        });
    }
}