package com.coffee.coffeeweather.preferences;

/**
 * Created by Administrator on 2016/6/28.
 */
public interface ConfigurationListener {
    void onConfigurationChanged(WeatherSetting pref, Object newValue);
}
