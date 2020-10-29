package com.example.eatingyou.Splash;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.eatingyou.Splash.FragmentA;
import com.example.eatingyou.Splash.FragmentB;
import com.example.eatingyou.Splash.FragmentC;

public class ViewPager extends FragmentPagerAdapter {
    public ViewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentA tab1 = new FragmentA();
                return tab1;
            case 1:
                FragmentB tab2=  new FragmentB();
                return  tab2;
            case 2:
                FragmentC tab3=  new FragmentC();
                return tab3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
