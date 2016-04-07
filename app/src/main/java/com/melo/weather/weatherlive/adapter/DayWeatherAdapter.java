package com.melo.weather.weatherlive.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.melo.weather.weatherlive.R;
import com.melo.weather.weatherlive.vo.Weather;

import java.util.List;

/**
 * Created by lixiukui on 16/4/4.
 */
public class DayWeatherAdapter extends BaseAdapter {

    private List<Weather> dayweatherList;
    private Context context;
    public DayWeatherAdapter(Context context,List list){
        this.context = context;
        this.dayweatherList = list;
    }

    @Override
    public int getCount() {
        return dayweatherList.size();
    }

    @Override
    public Object getItem(int position) {
        return dayweatherList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Holder viewHolder;
        if(convertView == null){
            viewHolder = new Holder();
            convertView = inflater.inflate(R.layout.item_day_weather,null);
            viewHolder.dateTV = (TextView) convertView.findViewById(R.id.tv_day_date);
            viewHolder.tempertureTV = (TextView) convertView.findViewById(R.id.tv_day_temperature);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (Holder) convertView.getTag();
        }
        viewHolder.dateTV.setText(dayweatherList.get(position).getDate());
        viewHolder.tempertureTV.setText(dayweatherList.get(position).getInfo().toString());
        return convertView;
    }

    class Holder{
        TextView dateTV;
        TextView tempertureTV;
    }
}
