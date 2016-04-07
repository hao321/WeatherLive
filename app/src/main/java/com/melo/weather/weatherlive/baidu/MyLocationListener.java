package com.melo.weather.weatherlive.baidu;

import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.Poi;
import com.melo.weather.weatherlive.inter.LocationListener;

import java.util.List;

/**
 * Created by lixiukui on 16/3/17.
 */
public class MyLocationListener implements BDLocationListener {
    private static final String TAG = "Location";
    private LocationListener listener;

    public MyLocationListener(LocationListener listener){
        this.listener = listener;
    }
    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        StringBuilder sb = new StringBuilder(1024);
        Log.i(TAG, bdLocation.getCountry());
        Log.i(TAG,  bdLocation.getCity());
        Log.i(TAG,bdLocation.getAddrStr());
        Log.i(TAG,String.valueOf(bdLocation.getLocType()));
        Log.i(TAG,bdLocation.getLocationDescribe());
        // Log.i(TAG,bdLocation.getFloor());
        Log.i(TAG, bdLocation.getStreet());
        //sb.append(bdLocation.getLocationDescribe());// 位置语义化信息
        List<Poi> list = bdLocation.getPoiList();// POI数据
        if (list != null) {
            sb.append("\npoilist size = : ");
            sb.append(list.size());
            for (Poi p : list) {
                sb.append("\npoi= : ");
                sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
            }
        }
        Log.i(TAG, sb.toString());
        listener.onSuccess(bdLocation.getDistrict());
    }
}
