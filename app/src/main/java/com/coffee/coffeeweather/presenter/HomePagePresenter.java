package com.coffee.coffeeweather.presenter;


import android.util.Log;

import com.coffee.coffeeweather.contract.HomePageContract;
import com.coffee.coffeeweather.API.entities.WeatherInfo;
import com.coffee.coffeeweather.API.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/6/24.
 */
public class HomePagePresenter implements HomePageContract.Presenter {


    private HomePageContract.View mView;
    private Call<WeatherInfo> mCall;

    @Override
    public void loadData(String cityName) {


        if(cityName.contains("0")){
            Log.e("TAG","-----------------"+cityName);
            mCall=ApiClient.mWeatherService.getCurCityWeatherInfoById(cityName);
        }else{
            mCall = ApiClient.mWeatherService.getCurCityWeatherInfo(cityName);
        }

        mCall.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {

                WeatherInfo body = response.body();
                //利用view的引用来更新UI
                mView.setWeatherData(body);
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                Log.e("TAG","----------------------------"+t.toString());
            }
        });
    }

    @Override
    public void start() {

    }

    private HomePagePresenter() {
    }

    public HomePagePresenter(HomePageContract.View view) {
        mView = view;
    }
}
