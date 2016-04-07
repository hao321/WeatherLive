package com.melo.weather.weatherlive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.melo.weather.weatherlive.Utils.Constants;
import com.melo.weather.weatherlive.Utils.StringToJsonUtil;
import com.melo.weather.weatherlive.activity.CityWeatherActivity;
import com.melo.weather.weatherlive.adapter.WeatherViewPagerAdapter;
import com.melo.weather.weatherlive.fragment.LifeFragment;
import com.melo.weather.weatherlive.fragment.RealtimeFragment;
import com.melo.weather.weatherlive.fragment.SelectCityFragment;
import com.melo.weather.weatherlive.fragment.SetFragment;
import com.melo.weather.weatherlive.vo.WeatherData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private WeatherData weatherData;
    private ViewPager mViewPager;
    private List<Fragment> fragments;
    private WeatherViewPagerAdapter adapter;
    private LinearLayout weatherLinearLayout,lifeLinearLayout,otherWeatherLinearLayout,setLinearLayout;
    private ImageButton weatherIBtn,lifeIBtn,otherIBtn,setIBtn;
    private TextView weatherTv,lifeTv;
    private List<LinearLayout> linearLayouts;
    private TextView title;//页签标题

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherData = StringToJsonUtil.getWeatherVo(Constants.WeatherContent);
        initView();
        setEvent();

    }

    private void initView() {
        weatherLinearLayout = (LinearLayout) findViewById(R.id.footer_weather);
        lifeLinearLayout = (LinearLayout) findViewById(R.id.footer_life);
        otherWeatherLinearLayout = (LinearLayout) findViewById(R.id.footer_other_weather);
        setLinearLayout = (LinearLayout) findViewById(R.id.footer_set);
        linearLayouts = new ArrayList<>();
        linearLayouts.add(weatherLinearLayout);
        linearLayouts.add(lifeLinearLayout);
        linearLayouts.add(otherWeatherLinearLayout);
        linearLayouts.add(setLinearLayout);

        weatherIBtn = (ImageButton) findViewById(R.id.footer_ibtn_weather);
        lifeIBtn = (ImageButton) findViewById(R.id.footer_ibtn_life);
        otherIBtn = (ImageButton) findViewById(R.id.footer_ibtn_other);
        setIBtn = (ImageButton) findViewById(R.id.footer_ibtn_set);

        title = (TextView) findViewById(R.id.tv_title);

        mViewPager = (ViewPager) findViewById(R.id.main_content);
        fragments = new ArrayList<>();
        RealtimeFragment realtimeFragment = RealtimeFragment.newInstance(weatherData);
        LifeFragment  lifeFragment = LifeFragment.newInstance(weatherData.getLife());
        SelectCityFragment selectCityFragment = SelectCityFragment.newInstance("ss","sss");
        SetFragment setFragment = SetFragment.newInstance("sss","ss");
        fragments.add(realtimeFragment);
        fragments.add(lifeFragment);
        fragments.add(selectCityFragment);
        fragments.add(setFragment);
        adapter = new WeatherViewPagerAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);


    }
    public void setEvent(){
        weatherLinearLayout.setOnClickListener(myOnClickListener);
        lifeLinearLayout.setOnClickListener(myOnClickListener);
        otherWeatherLinearLayout.setOnClickListener(myOnClickListener);
        setLinearLayout.setOnClickListener(myOnClickListener);
        weatherIBtn.setOnClickListener(myOnClickListener);
        lifeIBtn.setOnClickListener(myOnClickListener);
        otherIBtn.setOnClickListener(myOnClickListener);
        setIBtn.setOnClickListener(myOnClickListener);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        setFooterBackColor(0);
                        title.setText(R.string.app_name);
                        break;
                    case 1:
                        setFooterBackColor(1);
                        title.setText(R.string.life);
                        break;
                    case 2:
                        setFooterBackColor(2);
                        title.setText(R.string.city);
                        break;
                    case 3:
                        setFooterBackColor(3);
                        title.setText(R.string.set);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private View.OnClickListener myOnClickListener =  new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.footer_ibtn_weather:
                    mViewPager.setCurrentItem(0);
                    title.setText(R.string.app_name);
                    setFooterBackColor(0);
                    break;
                case R.id.footer_ibtn_life:
                    mViewPager.setCurrentItem(1);
                    title.setText(R.string.life);
                    setFooterBackColor(1);
                    break;
                case R.id.footer_ibtn_other:
                   // mViewPager.setCurrentItem(2);
                    startActivity(new Intent(MainActivity.this, CityWeatherActivity.class));
                    title.setText(R.string.city);
                    setFooterBackColor(2);
                    break;
                case R.id.footer_ibtn_set:
                    mViewPager.setCurrentItem(3);
                    title.setText(R.string.set);
                    setFooterBackColor(3);
                    break;
            }

        }
    };

    private void setFooterBackColor(int index){
        for(int i=0;i<linearLayouts.size();i++){
            if(i==index){
                linearLayouts.get(i).setBackgroundResource(R.color.toolbar_background);
            }else {
                linearLayouts.get(i).setBackgroundResource(R.color.white);
            }
        }
    }

}
