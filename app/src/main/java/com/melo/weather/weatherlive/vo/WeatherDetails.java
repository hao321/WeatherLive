package com.melo.weather.weatherlive.vo;

import java.io.Serializable;

/**
 * Created by lixiukui on 16/4/3.
 */
public class WeatherDetails implements Serializable{

    private String humidity;//湿度
    private String img;
    private String info;
    private String temperature;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
