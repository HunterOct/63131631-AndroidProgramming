package ntu.huutuong.drawerbottom;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment()).commit();
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                int itemid = item.getItemId();
                if (itemid == R.id.drawer_home) {
                    selectedFragment = new HomeFragment();
                    bottomNavigationView.setSelectedItemId(R.id.navigation_home);
                } else if (itemid == R.id.drawer_dashboard) {
                    selectedFragment = new RecycerviewFragment();
                    bottomNavigationView.setSelectedItemId(R.id.navigation_dashboard);
                } else if (itemid == R.id.drawer_notifications) {
                    selectedFragment = new ProfileFragment();
                    bottomNavigationView.setSelectedItemId(R.id.navigation_notifications);
                } else if (itemid == R.id.drawer_bmi) {
                    selectedFragment = new BMIFragment();
                    bottomNavigationView.setSelectedItemId(R.id.navigation_bmi);
                } else if (itemid == R.id.drawer_caculator) {
                    selectedFragment = new CaculatorFragment();
                    bottomNavigationView.setSelectedItemId(R.id.navigation_caculator);
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
                }
                toolbar.setTitle(item.getTitle());
                drawerLayout.closeDrawers();
                return true;
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                int itemid = item.getItemId();
                if (itemid == R.id.navigation_home) {
                    selectedFragment = new HomeFragment();
                    navigationView.setCheckedItem(R.id.drawer_home);
                } else if (itemid == R.id.navigation_dashboard) {
                    selectedFragment = new RecycerviewFragment();
                    navigationView.setCheckedItem(R.id.drawer_dashboard);
                } else if (itemid == R.id.navigation_notifications) {
                    selectedFragment = new ProfileFragment();
                    navigationView.setCheckedItem(R.id.drawer_notifications);
                } else if (itemid == R.id.navigation_bmi) {
                    selectedFragment = new BMIFragment();
                    navigationView.setCheckedItem(R.id.drawer_bmi);
                }   else if (itemid == R.id.navigation_caculator) {
                    selectedFragment = new CaculatorFragment();
                    navigationView.setCheckedItem(R.id.drawer_caculator);
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
                }
                toolbar.setTitle(item.getTitle());
                return true;
            }
        });
    }
}
