package com.coffee.coffeeweather.view.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.coffee.coffeeweather.API.entities.Forecast;
import com.coffee.coffeeweather.R;
import com.coffee.coffeeweather.view.bases.BaseRvHolder;
import com.coffee.coffeeweather.API.entities.WeatherInfo;


import butterknife.BindView;

/**
 * Created by Administrator on 2016/6/25.
 */
public class MyRvHolder extends BaseRvHolder<WeatherInfo.Data> {


    @BindView(R.id.weather_image)
    ImageView mWeatherImage;
    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.date)
    TextView mDate;
    @BindView(R.id.type)
    TextView mType;
    @BindView(R.id.low_hign)
    TextView mLowHign;
    @BindView(R.id.fengxiang)
    TextView mFengxiang;
    @BindView(R.id.fengli)
    TextView mFengli;

    public MyRvHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int position, WeatherInfo.Data datas) {
        Forecast forecast = datas.getForecast().get(position);
        mDate.setText(forecast.getDate());
        mType.setText(forecast.getType());
        mFengli.setText(forecast.getFengli());
        mFengxiang.setText(forecast.getFengxiang());
        mLowHign.setText(forecast.getLow()+"-"+forecast.getHigh());
        mName.setText(datas.getCity());
    }
}