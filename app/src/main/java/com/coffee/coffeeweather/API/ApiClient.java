package com.coffee.coffeeweather.API;

import com.coffee.coffeeweather.API.services.WeatherService;
import com.coffee.coffeeweather.BuildConfig;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/6/24.
 */
public class ApiClient {


    public static WeatherService mWeatherService;

    public static void init(){
        mWeatherService=createApiService();
    }





    public static Retrofit initRetrofit(){
        OkHttpClient httpClient = new OkHttpClient();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient = new OkHttpClient.Builder()
//                    .addInterceptor(logging)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();
        }
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();//使用 gson coverter，统一日期请求格式
        return new Retrofit.Builder()
                .baseUrl(ApiConstants.BASEURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build();
    }

    /**
     * 创建 RetrofitManage 服务
     *
     * @return ApiService
     */
    public static WeatherService createApiService() {
        return initRetrofit().create(WeatherService.class);
    }
}
