package com.coffee.coffeeweather;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.coffee.coffeeweather.API.ApiClient;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void test1(){
        ApiClient.mWeatherService.getCurCityWeatherInfo("北京");
//        System.out.println("打印");
//        assertEquals(1,2);

    }
}