package ntu.huutuong.bottomnavigator;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private MeowBottomNavigation meowBottomNavigation;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        meowBottomNavigation = findViewById(R.id.nav_bottom);

        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_notify));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_home));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_search));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_profile));

        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                switch (item.getId()){
                    case 1 :
                        fragment = new NotifyFragment();
                        break;
                    case 2 :
                        fragment = new HomeFragment();
                        break;
                    case 3 :
                        fragment = new SearchFragment();
                        break;
                    case 4 :
                        fragment = new ProfileFragment();
                        break;
                }
                loadFragment(fragment);
            }
        });
        //set nofication count
//        meowBottomNavigation.setCount(1, "10");
        //set default
        meowBottomNavigation.show(2, true);
        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext(), "You Clicked " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.nav_home:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
//                break;
//            case R.id.nav_profile:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
//                break;
//            case R.id.nav_search:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SearchFragment()).commit();
//                break;
//            case R.id.nav_notify:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NotifyFragment()).commit();
//                break;
//            case R.id.nav_facebook:
//                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.nav_github:
//                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        drawerLayout.closeDrawer(GravityCompat.START);
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
        } else if (id == R.id.nav_search) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new SearchFragment()).commit();
        } else if (id == R.id.nav_notify) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new NotifyFragment()).commit();
        } else if (id == R.id.nav_profile) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ProfileFragment()).commit();
        } else if (id == R.id.nav_facebook) {
            Toast.makeText(this, "Facebook", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_github) {
            Toast.makeText(this, "Github", Toast.LENGTH_SHORT).show();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}