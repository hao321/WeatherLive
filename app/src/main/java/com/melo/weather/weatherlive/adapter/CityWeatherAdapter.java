package com.melo.weather.weatherlive.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lixiukui on 16/4/6.
 */
public class CityWeatherAdapter extends PagerAdapter {
    private List<View> list;

    public CityWeatherAdapter(List<View> list){
        this.list = list;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position), 0);
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
