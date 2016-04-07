package com.melo.weather.weatherlive.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.melo.weather.weatherlive.R;
import com.melo.weather.weatherlive.Utils.Constants;
import com.melo.weather.weatherlive.adapter.DayWeatherAdapter;
import com.melo.weather.weatherlive.vo.Realtime;
import com.melo.weather.weatherlive.vo.Weather;
import com.melo.weather.weatherlive.vo.WeatherData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RealtimeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RealtimeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RealtimeFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String WEATHER_DATA = "weatherdata";

    private WeatherData weatherData;
    private ListView mlistview;
    private DayWeatherAdapter mdayweatherAdapter;

    //private OnFragmentInteractionListener mListener;

    public RealtimeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment RealtimeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RealtimeFragment newInstance(WeatherData weather) {
        RealtimeFragment fragment = new RealtimeFragment();
        Bundle args = new Bundle();
        args.putSerializable(WEATHER_DATA,weather);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.weatherData =(WeatherData) getArguments().getSerializable(WEATHER_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_realtime, container, false);
        TextView city = (TextView) view.findViewById(R.id.tv_cityname);
        TextView temperature = (TextView) view.findViewById(R.id.tv_temperature);
        TextView weathercontent = (TextView) view.findViewById(R.id.tv_weather);

        List daysWeather = weatherData.getWeather();
        List<Weather> weathers = new ArrayList<>();
        for(int i=0;i<daysWeather.size();i++){
            Weather weather = JSON.parseObject( daysWeather.get(i).toString(),Weather.class);
            weathers.add(weather);
        }
        mlistview = (ListView)view.findViewById(R.id.afterdaylist);
        mdayweatherAdapter = new DayWeatherAdapter(getActivity(),weathers);
        mlistview.setAdapter(mdayweatherAdapter);
        city.setText(weatherData.getRealtime().getCity_name());
        temperature.setText(weatherData.getRealtime().getWeather().getTemperature()+"℃");
        weathercontent.setText(weatherData.getRealtime().getWeather().getInfo());
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
////    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
