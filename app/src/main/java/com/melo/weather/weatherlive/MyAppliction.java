package com.melo.weather.weatherlive;

import android.app.Application;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.melo.weather.weatherlive.baidu.MyLocationListener;
import com.melo.weather.weatherlive.inter.LocationListener;

/**
 * Created by lixiukui on 16/3/17.
 */
public class MyAppliction extends Application {

    private LocationClient mLocationClient = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mLocationClient = new LocationClient(getApplicationContext());
        initLocation();
    }

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 1000;
        option.setScanSpan(span);
        option.setIsNeedAddress(true);
        option.setOpenGps(true);
        option.setLocationNotify(true);
        option.setIsNeedLocationDescribe(true);
        option.setIsNeedLocationPoiList(true);
        option.setIgnoreKillProcess(false);
        option.SetIgnoreCacheException(false);
        option.setEnableSimulateGps(false);
        mLocationClient.setLocOption(option);
    }

    public void startLocation(LocationListener listener){
        if(mLocationClient != null){
            MyLocationListener myLocationListener = new MyLocationListener(listener);
            mLocationClient.registerLocationListener(myLocationListener);
            mLocationClient.start();
        }
    }

    public void stopLocation(){
        if(mLocationClient != null){
            mLocationClient.stop();
        }
    }
}
