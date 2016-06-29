package com.coffee.coffeeweather.models.adapters;

import com.coffee.coffeeweather.API.entities.WeatherInfo;
import com.coffee.coffeeweather.models.styles.Forecast;
import com.coffee.coffeeweather.models.styles.Today;
import com.coffee.coffeeweather.models.styles.Weather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/28.
 */
public class ETouchWeatherAdapter implements WeatherAdapter {

    private final WeatherInfo mInfo;
    private final String mCity;
    private final String mCurrentTmp;
    private final String mTips;

    public ETouchWeatherAdapter(WeatherInfo info) {
        mInfo = info;
        mCity = mInfo.getData().getCity();
        mCurrentTmp = mInfo.getData().getWendu();
        mTips = mInfo.getData().getGanmao();
    }

    @Override
    public Weather getWeather() {
        Weather weather = new Weather();

        weather.setCityName(mCity);
        weather.setForecast(getForecast());
        weather.setToday(getToday());
        weather.setTips(getTips());
        weather.setCurrentTmp(getCurrentTmp());
        return weather;
    }


    @Override
    public List<Forecast> getForecast() {
        List<com.coffee.coffeeweather.API.entities.Forecast> forecasts = mInfo.getData().getForecast();
        List<Forecast> forecastsList=new ArrayList<>();
        for (com.coffee.coffeeweather.API.entities.Forecast forecast:forecasts) {
            Forecast dailyWeather = new Forecast(mCity, forecast.getDate(), forecast.getDate(),
                    forecast.getType(), forecast.getHigh(), forecast.getLow(),
                    forecast.getFengxiang(), forecast.getFengli());
            forecastsList.add(dailyWeather);
        }
        return forecastsList;
    }


    @Override
    public Today getToday() {
        com.coffee.coffeeweather.API.entities.Forecast forecast = mInfo.getData().getForecast().get(0);
        return new Today(mCity,forecast.getDate(),forecast.getDate(),
                forecast.getType(),forecast.getHigh(),forecast.getLow(),
                forecast.getFengxiang(),forecast.getFengli());
    }

    @Override
    public String getCurrentTmp() {
        return mCurrentTmp;
    }

    @Override
    public String getTips() {
        return mTips;
    }
}
