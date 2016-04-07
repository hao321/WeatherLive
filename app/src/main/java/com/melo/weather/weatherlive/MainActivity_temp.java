package com.melo.weather.weatherlive;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.melo.weather.weatherlive.inter.LocationListener;
import com.melo.weather.weatherlive.vo.Realtime;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class MainActivity_temp extends ActionBarActivity {
//    public LocationClient mLocationClient = null;
//    public BDLocationListener myLocationListener = new MyLocationListener();
    private TextView textView,cityTV,weatherTV,temperatureTV;
    private String[] datas = new String[]{"1111","2222","3333","4444",
            "1111","2222","3333","4444",
            "1111","2222","3333","4444",
            "1111","2222","3333","4444"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        ViewAnimator viewAnimator = new ViewAnimator<>(MainActivity_temp.this,
//                new ArrayList<Resourceble>(),
//                (LinearLayout) findViewById(R.id.left_drawer),
//                contentFragment, drawerLayout);
        //to open menu you have to override ActionBarDrawerToggle method
//        @Override
//        public void onDrawerSlide(View drawerView, float slideOffset) {
//            super.onDrawerSlide(drawerView, slideOffset);
//            if (slideOffset > 0.6 && viewAnimator.getLinearLayout().getChildCount() == 0)
//                viewAnimator.showMenuContent();
//        }
//        public void onDrawerClosed(View view) {
//            super.onDrawerClosed(view);
//            viewAnimator.getLinearLayout().removeAllViews();
//            viewAnimator.getLinearLayout().invalidate();
//        }}
       // init();
    // initData();
    }

//    private void init() {
//        textView = (TextView) findViewById(R.id.textView);
//        cityTV = (TextView)findViewById(R.id.tv_city);
//        weatherTV = (TextView)findViewById(R.id.tv_weather);
//        temperatureTV = (TextView)findViewById(R.id.tv_temperature);
//        findViewById(R.id.btn_location).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((MyAppliction)getApplication()).startLocation(new LocationListener() {
//                    @Override
//                    public void onSuccess(String locale) {
//                        Log.i("Location", "**********" + locale + "***********");
//                        ((MyAppliction) getApplication()).stopLocation();
//                        new MyAsyncTask().execute(locale.replace("区", ""));
//                    }
//
//                    @Override
//                    public void onFailed(String errormsg) {
//
//                    }
//                });
//            }
//        });
//        findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((MyAppliction)getApplication()).stopLocation();
//            }
//        });
//
//        ( (ListView)findViewById(R.id.lv_weather)).setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas));
//    }
//
//    @Override
//    public ScreenShotable onSwitch(Resourceble slideMenuItem, ScreenShotable screenShotable, int position) {
//        return null;
//    }
//
//    @Override
//    public void disableHomeButton() {
//
//    }
//
//    @Override
//    public void enableHomeButton() {
//
//    }
//
//    @Override
//    public void addViewToContainer(View view) {
//
//    }
//
////    public void initData(){
////        ((MyAppliction)getApplication()).startLocation(new LocationListener() {
////            @Override
////            public void onSuccess(String locale) {
////                Log.i("Location", "**********" + locale + "***********");
////                ((MyAppliction) getApplication()).stopLocation();
////                new MyAsyncTask().execute(locale.replace("区", ""));
////            }
////        });
////    }

    class MyAsyncTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... params) {
            String result = null;
            String locale = params[0];
            String key = "85ea5dcd6bba97f7b9b30d0c7b3d00ef";
            String weatherUrl = "http://op.juhe.cn/onebox/weather/query?cityname="+locale+"&key="+key;
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(weatherUrl);
            try {
                HttpResponse response = client.execute(request);
                if(response.getStatusLine().getStatusCode() == 200){
                    HttpEntity  entity = response.getEntity();
                    byte[] responseDate = EntityUtils.toByteArray(entity);
                    result = new String(responseDate,"utf-8");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            JSONObject json = JSON.parseObject(s);
            JSONObject resultJsonObject = (JSONObject) json.get("result");
            JSONObject dataJsonObject = resultJsonObject.getJSONObject("data");
            JSONObject real = dataJsonObject.getJSONObject("realtime");
            Realtime realtime = JSON.parseObject(real.toJSONString(), Realtime.class);
//            System.out.println("realtime: " + realtime.getWind());
//            System.out.println(real.getJSONObject("wind").get("direct"));
            cityTV.setText(realtime.getCity_name());
           // JSONObject weather = JSON.parseObject(realtime.getWeather());
          //  weatherTV.setText(weather.get("info").toString());
           // temperatureTV.setText(weather.get("temperature").toString());
           // textView.setText(realtime.getWind());
        }
    }

}
