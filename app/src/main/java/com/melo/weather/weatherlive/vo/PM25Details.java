package com.melo.weather.weatherlive.vo;

import java.io.Serializable;

/**
 * Created by lixiukui on 16/4/3.
 *  "curPm": "93",
 "pm25": "32",
 "pm10": "93",
 "level": 2,
 "quality": "良",
 "des": "今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。"
 */
public class PM25Details implements Serializable{

    private String curPm;
    private String pm25;
    private String pm10;
    private String level;
    private String quality;
    private String des;

    public String getCurPm() {
        return curPm;
    }

    public void setCurPm(String curPm) {
        this.curPm = curPm;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
