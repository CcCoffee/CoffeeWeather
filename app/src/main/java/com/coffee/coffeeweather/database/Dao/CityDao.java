package com.coffee.coffeeweather.database.Dao;

import android.content.Context;
import android.util.Log;

import com.coffee.coffeeweather.database.CityDatabaseHelper;
import com.coffee.coffeeweather.models.City;
import com.coffee.coffeeweather.models.HotCity;
import com.j256.ormlite.dao.Dao;

import java.util.List;

/**
 * Created by Administrator on 2016/6/25.
 */
public class CityDao {
    private Context context;
    private Dao<HotCity, Integer> hotCityDao;
    private Dao<City, Integer> cityDao;
    private CityDatabaseHelper mHelper;

    public CityDao(Context context) {
        this.context = context;
        try {
            mHelper = CityDatabaseHelper.getInstance();
            hotCityDao = mHelper.getDao(HotCity.class);
            cityDao =  mHelper.getDao(City.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<HotCity> queryAllHotCity() {
        try {
            List<HotCity> hotCities = hotCityDao.queryForAll();
            return hotCities;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<City> queryAllCity() {
        try {
            List<City> cities = cityDao.queryForAll();
            Log.e("Database",cities.toString());
            return cities;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
