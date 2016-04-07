package com.melo.weather.weatherlive.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.melo.weather.weatherlive.vo.WeatherData;

/**
 * Created by lixiukui on 16/4/3.
 */
public class StringToJsonUtil {

    public static String getWeatherDataStr(String weatherJson){
        JSONObject resultJson = JSON.parseObject(weatherJson);
        String reason = resultJson.getString("reason");
        String error_code = resultJson.getString("error_code");
        System.out.println(reason);
        String result = resultJson.getString("result");
        JSONObject data = JSON.parseObject(result);
        String weatherData = data.getString("data");

        return weatherData;
    }


    public static WeatherData getWeatherVo(String jsonStr){
        String weatherVoData = getWeatherDataStr(jsonStr);
        WeatherData weatherData = JSON.parseObject(weatherVoData,WeatherData.class);
        return weatherData;
    }
}
