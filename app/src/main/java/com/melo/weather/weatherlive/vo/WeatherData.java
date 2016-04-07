package com.melo.weather.weatherlive.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lixiukui on 16/4/3.
 */
public class WeatherData implements Serializable{

    private Realtime realtime;
    private Life life;
    private List weather;
    private PM25 pm25;
    private String date;
    private String isForeign;

    public Realtime getRealtime() {
        return realtime;
    }

    public void setRealtime(Realtime realtime) {
        this.realtime = realtime;
    }

    public Life getLife() {
        return life;
    }

    public void setLife(Life life) {
        this.life = life;
    }

    public List getWeather() {
        return weather;
    }

    public void setWeather(List weather) {
        this.weather = weather;
    }

    public PM25 getPm25() {
        return pm25;
    }

    public void setPm25(PM25 pm25) {
        this.pm25 = pm25;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsForeign() {
        return isForeign;
    }

    public void setIsForeign(String isForeign) {
        this.isForeign = isForeign;
    }
}
