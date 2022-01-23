package com.example.footballcalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.footballcalendar.Fragment.HomeFragment;
import com.example.footballcalendar.Fragment.NotificationFragment;
import com.example.footballcalendar.Fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnv = findViewById(R.id.bnv);
        loadFragment(new HomeFragment());
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.action_Home:
                        fragment = new HomeFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.action_Notification:
                        fragment = new NotificationFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.action_Setting:
                        fragment = new SettingFragment();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            }
        });





    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}