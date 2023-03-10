package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class MainActivity3 extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);

        // Set up the tab layout with the view page
        tabLayout.setupWithViewPager(viewPager);

        // Create a new VPAdapter and add fragments to it
        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new Fragment1(), "Home");
        vpAdapter.addFragment(new Fragment2(), "Explore");
        vpAdapter.addFragment(new Fragment3(), "About");
        // Set the VPAdapter as the adapter for the view pager
        viewPager.setAdapter(vpAdapter);



    }
}
