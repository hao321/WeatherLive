package com.melo.weather.weatherlive.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by lixiukui on 16/4/6.
 */
public class CityWeatherListView extends ListView {
    public CityWeatherListView(Context context) {
        this(context,null);
    }

    public CityWeatherListView(Context context, AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public CityWeatherListView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public CityWeatherListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
