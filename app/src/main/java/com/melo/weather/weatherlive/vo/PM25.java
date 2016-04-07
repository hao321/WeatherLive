package com.melo.weather.weatherlive.vo;

import java.io.Serializable;

/**
 * Created by lixiukui on 16/4/3.
 */
public class PM25 implements Serializable{

    private String key;
    private String show_desc;
    private PM25Details pm25;
    private String dateTime;
    private String cityName;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getShow_desc() {
        return show_desc;
    }

    public void setShow_desc(String show_desc) {
        this.show_desc = show_desc;
    }

    public PM25Details getPm25() {
        return pm25;
    }

    public void setPm25(PM25Details pm25) {
        this.pm25 = pm25;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
