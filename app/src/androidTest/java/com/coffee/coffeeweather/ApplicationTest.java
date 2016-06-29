package com.coffee.coffeeweather;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;


import com.coffee.coffeeweather.database.Dao.WeatherDao;
import com.coffee.coffeeweather.models.styles.Forecast;
import com.coffee.coffeeweather.models.styles.Today;
import com.coffee.coffeeweather.models.styles.Weather;
import com.coffee.coffeeweather.utils.UiUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void test(){
        WeatherDao weatherDao = new WeatherDao();
        List<Forecast> forecasts = new ArrayList<>();
        for(int i=0;i<5;i++){
            forecasts.add(new Forecast("汕头","062"+i,"周一","晴","高温 32℃","低温 21℃","无持续风向","微风"));
        }
        Today today = new Today("汕头", "0620", "周一", "晴", "高温 32℃", "低温 21℃", "无持续风向", "微风");
        //   public Weather(String cityName, String currentTmp, String tips, List<Forecast> forecast, Today today) {
        Weather weather = new Weather("汕头","45℃","相对今天出现了较大幅度降温，较易发生感冒，体质较弱的朋友请注意适当防护。",forecasts,today);
        System.out.println(weather);
        try {
            weatherDao.insertWeather(weather);
            Log.e("TAG","插入成功");
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e("TAG","插入失败");
        }

//        int i=10;
//        int b=10;
//        assertEquals(i,b);
    }
}