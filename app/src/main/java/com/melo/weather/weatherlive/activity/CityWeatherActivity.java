package com.melo.weather.weatherlive.activity;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.melo.weather.weatherlive.R;
import com.melo.weather.weatherlive.adapter.CityWeatherAdapter;

import java.util.ArrayList;
import java.util.List;

public class CityWeatherActivity extends AppCompatActivity {
    private int[] images = {R.drawable.day,R.drawable.night};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager_city);
        List<View> lists = new ArrayList<>();
        // View mView = inflater.inflate(R.layout.city_imageview,null);

        for(int i=0; i<images.length;i++){
            View mView = inflater.inflate(R.layout.city_imageview,null);
            ImageView imageView = (ImageView) mView.findViewById(R.id.image_city);
            imageView.setBackgroundResource(images[i]);
            lists.add(mView);
        }
        viewPager.setAdapter(new CityWeatherAdapter(lists));
        viewPager.setCurrentItem(0);
    }
}
