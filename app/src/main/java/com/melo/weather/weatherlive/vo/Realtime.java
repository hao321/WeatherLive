package com.melo.weather.weatherlive.vo;

import java.io.Serializable;

/**
 * Created by lixiukui on 16/3/19.
 */
public class Realtime implements Serializable{

    private Wind wind;//风速
    private String time;//更新时间 当前时间 hh:MM:ss
    private WeatherDetails weather;//当前天气状况
    private long dataUptime;//
    private String date;// yyyy-mm-dd
    private String city_code;// 城市／区／县 编码
    private String city_name;//城市／区／县 名称
    private String week;//星期
    private String moon;//农历（阴历）

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public WeatherDetails getWeather() {
        return weather;
    }

    public void setWeather(WeatherDetails weather) {
        this.weather = weather;
    }

    public long getDataUptime() {
        return dataUptime;
    }

    public void setDataUptime(long dataUptime) {
        this.dataUptime = dataUptime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getMoon() {
        return moon;
    }

    public void setMoon(String moon) {
        this.moon = moon;
    }
}
