package com.example.lockit.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.lockit.R;
import com.example.lockit.fragments.CharmsFragment;
import com.example.lockit.fragments.HomeFragment;
import com.example.lockit.fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;

                switch (menuItem.getItemId()) {
                    case R.id.miHome:
                        fragment = new HomeFragment();
                        break;
                    case R.id.miLock:
                        fragment = new CharmsFragment();
                        break;
                    case R.id.miSettings:
                        fragment = new SettingsFragment();
                        break;
                    default:
                        fragment = new HomeFragment();
                }

                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });

        // Set default selection to home
        bottomNavigationView.setSelectedItemId(R.id.miHome);
    }
}