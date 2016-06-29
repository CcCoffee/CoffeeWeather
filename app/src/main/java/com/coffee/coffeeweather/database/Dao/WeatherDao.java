package com.coffee.coffeeweather.database.Dao;

import android.text.TextUtils;

import com.coffee.coffeeweather.WeatherApplication;
import com.coffee.coffeeweather.database.WeatherDatabaseHelper;
import com.coffee.coffeeweather.models.styles.Forecast;
import com.coffee.coffeeweather.models.styles.Today;
import com.coffee.coffeeweather.models.styles.Weather;
import com.coffee.coffeeweather.utils.UiUtils;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2016/6/28.
 */
public class WeatherDao {

    private Dao mWeatherDao;
    private Dao mForecastDao;
    private Dao mTodayDao;

    public WeatherDao() {
        WeatherDatabaseHelper helper = new WeatherDatabaseHelper(WeatherApplication.getInstance());
        try {
            mWeatherDao = helper.getDao(Weather.class);
            mForecastDao = helper.getDao(Forecast.class);
            mTodayDao = helper.getDao(Today.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入天气到数据库
     *
     * @param weather 经过适配后返回的weather对象
     * @throws SQLException 工具方法让外界来捕获异常
     */
    public void insertWeather(Weather weather) throws SQLException {
        TransactionManager.callInTransaction(WeatherDatabaseHelper.getInstance().getConnectionSource(), (Callable<Void>) () -> {
            if (mWeatherDao.queryForEq(Weather.CITY_NAME_FIELD_NAME, weather.getCityName()) != null) {
                if (deleteWeather(weather) > 0) {
                    UiUtils.toast(WeatherApplication.getInstance(), weather.getCityName() + " 从删除数据库成功");
                }
            }
            mWeatherDao.create(weather);
            for (Forecast forecast : weather.getForecast()) {
                mForecastDao.create(forecast);
            }
            mTodayDao.create(weather.getToday());
            return null;
        });
    }

    public List<Weather> queryAllSaveCity() throws SQLException {
        List<Weather> weathers = mWeatherDao.queryForAll();
        for (Weather weather : weathers){
            List<Forecast> forecasts = mForecastDao.queryForEq(Forecast.CITY_NAME_FIELD_NAME, weather.getCityName());
            weather.setForecast(forecasts);
            List<Today> todays = mTodayDao.queryForEq(Today.CITY_NAME_FIELD_NAME, weather.getCityName());
            for(Today today:todays){
                weather.setToday(today);
            }
        }
        return weathers;
    }

    public int deleteWeather(Weather weather) {
        if (!TextUtils.isEmpty(weather.getCityName())) {
            try {
                DeleteBuilder builder = mWeatherDao.deleteBuilder();
                builder.where().eq(weather.CITY_NAME_FIELD_NAME, weather.getCityName());
                return builder.delete();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
