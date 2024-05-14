package ntu.huutuong.bottomnavigator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation meowBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}