package com.coffee.api.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016/6/24.
 */
public interface WeatherService {

    @GET("{cityId}")
    Call<String> getCurCityWeatherInfo(@Path("cityId") String cityId);

}
