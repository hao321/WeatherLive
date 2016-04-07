package com.melo.weather.weatherlive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lixiukui on 16/4/6.
 */
public class WeatherViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public WeatherViewPagerAdapter(FragmentManager fm, List list){
        super(fm);
        this.list = list;

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

}
