package com.melo.weather.weatherlive.vo;

import java.io.Serializable;

/**
 * Created by lixiukui on 16/3/19.
 */
public class Wind implements Serializable{

    private String windspeed;//风速
    private String direct;//风向
    private String power;
    private String offset;

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }
}
