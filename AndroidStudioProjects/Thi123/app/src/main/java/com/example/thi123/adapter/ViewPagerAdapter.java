package com.example.thi123.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.thi123.fragment.FragmentLoaimon;
import com.example.thi123.fragment.FragmentMonan;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FragmentMonan();
            case 1: return new FragmentLoaimon();
            default: return  new FragmentMonan();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
