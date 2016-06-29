package com.coffee.coffeeweather.models.adapters;

import com.coffee.coffeeweather.models.styles.Forecast;
import com.coffee.coffeeweather.models.styles.Today;
import com.coffee.coffeeweather.models.styles.Weather;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28.
 */
public interface WeatherAdapter {

    Weather getWeather();
    List<Forecast> getForecast();
    Today getToday();
    String getCurrentTmp();
    String getTips();

}
