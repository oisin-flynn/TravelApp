package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
// VPAdapter is an adapter class that is responsible for managing the fragments that are displayed in the ViewPager.

// The ArrayList<Fragment> fragmentArrayList stores the fragments that will be displayed in the ViewPager.
// The ArrayList<String> fragmentTitle stores the titles of the fragments that will be displayed in the tabs of the TabLayout.

// The addFragment() method adds a new fragment and its corresponding title to the fragmentArrayList and fragmentTitle ArrayLists, respectively.

// The getItem() method returns the fragment at the specified position in the fragmentArrayList.
// The getCount() method returns the number of fragments in the fragmentArrayList.

// The getPageTitle() method returns the title of the fragment at the specified position in the fragmentTitle ArrayList. This is used to set the title of the tabs in the TabLayout.
public class VPAdapter extends FragmentPagerAdapter {
    private final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private final ArrayList<String> fragmentTitle = new ArrayList<>();

    public VPAdapter(@NonNull FragmentManager fm, int behaviorResumeOnlyCurrentFragment) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    public void addFragment(Fragment fragment, String title){
        fragmentArrayList.add(fragment);
        fragmentTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
}
