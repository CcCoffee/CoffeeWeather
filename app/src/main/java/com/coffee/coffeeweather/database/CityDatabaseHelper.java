package com.coffee.coffeeweather.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.coffee.coffeeweather.WeatherApplication;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/25.
 */
public class CityDatabaseHelper extends OrmLiteSqliteOpenHelper{

    private static final String CITYDB_NAME="city.db";
    private static final int DATABASE_VERSION = 1;
    private Map<String, Dao> daos = new HashMap<String, Dao>();

    public CityDatabaseHelper(Context context) {
        super(context, CITYDB_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
    private volatile static CityDatabaseHelper helper=null;
    public static CityDatabaseHelper getInstance(){
        if(helper==null){
            synchronized (CityDatabaseHelper.class){
                if(helper==null){
                    helper=new CityDatabaseHelper(WeatherApplication.getInstance());
                }
            }
        }
        return helper;
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


}
