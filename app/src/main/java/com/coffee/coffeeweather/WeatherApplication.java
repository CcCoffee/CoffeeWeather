package com.coffee.coffeeweather;

import android.app.Application;

import com.coffee.coffeeweather.API.ApiClient;
import com.facebook.stetho.Stetho;

/**
 * Created by Administrator on 2016/6/24.
 */
public class WeatherApplication extends Application {
    private static WeatherApplication mApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        initRetrofit();
        mApplication = this;

        //添加Stetho框架，之后可以用chrome浏览器调试网络
        Stetho.initialize(Stetho
                .newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(
                        Stetho.defaultInspectorModulesProvider(this)).build());
    }

    private void initRetrofit() {
        ApiClient.init();
    }

    public static WeatherApplication getInstance(){
        return mApplication;
    }
}
