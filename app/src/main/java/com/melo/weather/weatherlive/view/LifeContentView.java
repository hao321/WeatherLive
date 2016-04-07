package com.melo.weather.weatherlive.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.melo.weather.weatherlive.R;

import static com.melo.weather.weatherlive.R.color.life_font_blue;

/**
 * Created by lixiukui on 16/4/4.
 */
public class LifeContentView extends LinearLayout {

    private Context context;
    private AttributeSet attrs;
    private TextView itemTitle;
    private TextView itemSummary;
    private TextView itemContent;
    private LinearLayout itemBorder;
    private RelativeLayout relativeLayout;

    public LifeContentView(Context context) {
        this(context, null);
    }

    public LifeContentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LifeContentView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public LifeContentView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        this.attrs = attrs;
        initView();
    }

    private void initView() {
        setBackgroundResource(R.drawable.item_life_back);
        LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 10, 0, 10);
        setLayoutParams(params);
        setOrientation(LinearLayout.VERTICAL);
        relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams rlParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        relativeLayout.setLayoutParams(rlParams);

        itemTitle = new TextView(context);
        itemTitle.setTextSize(15);
        itemTitle.setTextColor(Color.BLACK);
        RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        itemTitle.setPadding(10, 5, 10, 5);
        relativeLayout.addView(itemTitle, titleParams);

        itemSummary = new TextView(context);
        itemSummary.setTextSize(15);
        itemSummary.setTextColor(Color.BLACK);
        RelativeLayout.LayoutParams summaryParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        summaryParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        itemSummary.setPadding(10, 5, 10, 5);
        relativeLayout.addView(itemSummary, 1, summaryParams);
        //addView(itemSummary);

        itemBorder = new LinearLayout(context);
        itemBorder.setBackgroundColor(Color.BLACK);
        LinearLayout.LayoutParams boderParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 1);
        boderParams.setMargins(10,0,10,0);
        itemBorder.setLayoutParams(boderParams);

        itemContent = new TextView(context);
        itemContent.setTextSize(15);
        itemContent.setTextColor(Color.BLACK);
        ViewGroup.LayoutParams contentParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        itemContent.setPadding(10,5,10,5);
        itemContent.setLayoutParams(contentParams);

        addView(relativeLayout);
        addView(itemBorder);
        addView(itemContent);
    }

    public void setText(String title,String summary,String content){
        itemTitle.setText(title);
        itemSummary.setText(summary);
        itemContent.setText(content);
    }
}
