//package com.example.study;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.core.view.GravityCompat;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//
//import com.example.study.databinding.ActivityHomeBinding;
//import com.google.android.material.navigation.NavigationView;
//
//public class HomeActivity extends AppCompatActivity {
//    NavigationView navigationView;
//    DrawerLayout drawerLayout;
//    ActionBarDrawerToggle toggle;
//    Toolbar toolbar;
//
//    ActivityHomeBinding activityHomeBinding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        activityHomeBinding=ActivityHomeBinding.inflate(getLayoutInflater());
//
//
//        setContentView(activityHomeBinding.getRoot());
//
//        activityHomeBinding.bottomnav.setBackground(null);
//
//        activityHomeBinding.bottomnav.setOnItemSelectedListener(item -> {
//
//            if(item.getItemId()==R.id.login)
//            {
//                replaceFragment(new LogInFragment());
//            } else if (item.getItemId()==R.id.logout) {
//                replaceFragment(new LogOutFragment());
//            } else if (item.getItemId()==R.id.subcription) {
//                replaceFragment(new SubcriptionFragment());
//            }else if(item.getItemId()==R.id.video)
//            {
//                replaceFragment(new VideoFragment());
//            }else
//            {
//                replaceFragment(new StatusFragment());
//            }
//            return true;
//        });
//
//        toolbar = (Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        navigationView = findViewById(R.id.nav);
//        drawerLayout=findViewById(R.id.drawer);
//
//        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.Open , R.string.Close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                if(item.getItemId()==R.id.home)
//                {
//                    Intent intent = new Intent(HomeActivity.this , HomoActivity.class);
//                    startActivity(intent);
//                    drawerLayout.closeDrawer(GravityCompat.START);
//                }
//                else if(item.getItemId()==R.id.call)
//                {
//                    Intent intent = new Intent(HomeActivity.this , CallActivity.class);
//                    startActivity(intent);
//                    drawerLayout.closeDrawer(GravityCompat.START);
//                }
//                else
//                {
//                    Intent intent = new Intent(HomeActivity.this , InfoActivity.class);
//                    startActivity(intent);
//                    drawerLayout.closeDrawer(GravityCompat.START);
//                }
//
//                return true;
//            }
//        });
//
//    }
//
//    private void replaceFragment(Fragment fragment)
//    {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame , fragment);
//        fragmentTransaction.commit();
//    }
//
//}