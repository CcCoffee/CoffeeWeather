package com.coffee.api.services;

import retrofit2.Retrofit;

/**
 * Created by Administrator on 2016/6/24.
 */
public class ApiClient {


    public static WeatherService mWeatherService;

    public static void init(){
        mWeatherService=getWeatherService(ApiConstants.BASEURL,WeatherService.class);
    }

    public static <T> T getWeatherService(String baseUrl,Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).build();
        return retrofit.create(clazz);
    }
}
