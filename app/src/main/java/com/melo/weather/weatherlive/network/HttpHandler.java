package com.melo.weather.weatherlive.network;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lixiukui on 16/3/17.
 */
public class HttpHandler extends Thread{

    private final String url;
    private Context context;
    private String data;

    public HttpHandler(Context context , String url , String data){
        this.context = context;
        this.url = url;
        this.data = data;
    }

    @Override
    public void run() {

        try {
            URL httpUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("post");
            connection.setRequestProperty("cityname", "昌平");
            connection.connect();
            //InputStream is = connection.getInputStream();
            int responseState = connection.getResponseCode();
            if(responseState == 200){

            }else{

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public interface HttpRequestListener{
        void httpOk();
        void httpFial();
    }
}
