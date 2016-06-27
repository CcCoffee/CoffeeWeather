package com.coffee.coffeeweather.utils;

import android.util.Log;

import com.coffee.coffeeweather.R;
import com.coffee.coffeeweather.WeatherApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/6/25.
 */
public class CommonUtils {
    public static void importDataBase() {
        new Thread(()->{
            File file = new File(WeatherApplication.getInstance().getDatabasePath("city.db").getAbsolutePath());
            if (!file.exists()) {
                File databaseFile = WeatherApplication.getInstance().getDatabasePath("city.db");
                if (!databaseFile.getParentFile().exists()) {
                    try {
                        databaseFile.getParentFile().mkdirs();
                        databaseFile.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                InputStream in = null;
                FileOutputStream out = null;
                try {
                    out = new FileOutputStream(databaseFile);
                    in = WeatherApplication.getInstance().getResources().openRawResource(R.raw.city);
                    byte[] buffer = new byte[1024];
                    try {

                        while (in.read(buffer) != -1) {
                            Log.e("TAG","-------------------------------------------------------------------");
                            out.write(buffer, 0, buffer.length);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (out != null) {
                            out.close();
                        }
                        if (in != null) {
                            in.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
