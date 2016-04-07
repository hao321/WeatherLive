package com.melo.weather.weatherlive.vo;

import java.io.Serializable;

/**
 * Created by lixiukui on 16/4/3.
 * 实时的 生活信息（如 穿衣指数， 运动指数等）
 */
public class Life implements Serializable{
    private String date;
    private LifeInfo info;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LifeInfo getInfo() {
        return info;
    }

    public void setInfo(LifeInfo info) {
        this.info = info;
    }
}
