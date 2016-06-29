package com.coffee.coffeeweather.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;



import com.coffee.coffeeweather.WeatherApplication;
import com.coffee.coffeeweather.models.styles.Forecast;
import com.coffee.coffeeweather.models.styles.Today;
import com.coffee.coffeeweather.models.styles.Weather;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/28.
 */
public class WeatherDatabaseHelper extends OrmLiteSqliteOpenHelper{
    private static final String WEATHER_DB_NAME="weather.db";
    private static final int DATABASE_VERSION = 1;
    private Map<String, Dao> daos = new HashMap<String, Dao>();

    public WeatherDatabaseHelper(Context context) {
        super(context, WEATHER_DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Weather.class);
            TableUtils.createTable(connectionSource, Forecast.class);
            TableUtils.createTable(connectionSource, Today.class);

            String weatherTrigger ="CREATE TRIGGER weather_delete_trigger AFTER DELETE " +
                    "ON Weather" +
                    "BEGIN" +
                    "delete from Forecast where cityName = old.cityName; " +
                    "delete from Today where cityName = old.cityName; " +
                    "END;";
//            database.execSQL(weatherTrigger);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,Weather.class,true);
            TableUtils.dropTable(connectionSource,Forecast.class,true);
            TableUtils.dropTable(connectionSource,Today.class,true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 释放资源
     */
    @Override
    public void close()
    {
        super.close();

        for (String key : daos.keySet())
        {
            Dao dao = daos.get(key);
            dao = null;
        }
    }

    public synchronized Dao getDao(Class clazz) throws SQLException {
        Dao dao = null;
        String className = clazz.getSimpleName();

        if (daos.containsKey(className))
        {
            dao = daos.get(className);
        }
        if (dao == null)
        {
            dao = super.getDao(clazz);
            daos.put(className, dao);
        }
        return dao;
    }

    private volatile static WeatherDatabaseHelper helper=null;
    public static WeatherDatabaseHelper getInstance(){
        if(helper==null){
            synchronized (WeatherDatabaseHelper.class){
                if(helper==null){
                    helper=new WeatherDatabaseHelper(WeatherApplication.getInstance());
                }
            }
        }
        return helper;
    }
}
