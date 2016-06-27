package com.coffee.coffeeweather.API.services;

import com.coffee.coffeeweather.API.entities.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/6/24.
 */
public interface WeatherService {

    @GET("weather_mini")
    Call<WeatherInfo> getCurCityWeatherInfo(@Query("city") String city);

    //http://wthrcdn.etouch.cn/weather_mini?citykey=101010100
    @GET("weather_mini")
    Call<WeatherInfo> getCurCityWeatherInfoById(@Query("citykey") String cityID);

}
