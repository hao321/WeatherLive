package com.melo.weather.weatherlive.inter;

import java.util.List;
import java.util.Map;

/**
 * Created by lixiukui on 16/3/17.
 */
public interface LocationListener {

    void onSuccess(String locale);
    void onFailed(String error);
}
