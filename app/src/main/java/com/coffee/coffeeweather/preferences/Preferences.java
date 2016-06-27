package com.coffee.coffeeweather.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.coffee.coffeeweather.WeatherApplication;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/6/28.
 */
public class Preferences {
    public static final String PREF_NAME = "PREF_NAME";
    private static final String TAG = "CoffeeWeather";
    //保存观察者
    private static List<ConfigurationListener> mListeners = Collections.synchronizedList(new ArrayList<>());



    public static void savePreference(WeatherSetting pref , Object value) throws InvalidClassException {
        HashMap<WeatherSetting, Object> prefs = new HashMap<>();
        prefs.put(pref,value);
        savePreferences(prefs,false);
    }

    public static void savePreferences(Map<WeatherSetting, Object> prefs) throws InvalidClassException {

        savePreferences(prefs, false);
    }

    private static void savePreferences(Map<WeatherSetting, Object> prefs, boolean noSaveIfExists) throws InvalidClassException {
        SharedPreferences sp = getSharedPreferences();
        SharedPreferences.Editor editor = sp.edit();
        for (WeatherSetting pref : prefs.keySet()) {
            Object value = prefs.get(pref);
            if (noSaveIfExists && sp.contains(pref.getId())) {
                continue;
            }
            if (value instanceof Boolean && pref.getDefValue() instanceof Boolean) {
                editor.putBoolean(pref.getId(), (Boolean) value);
            } else if (value instanceof String && pref.getDefValue() instanceof String) {
                editor.putString(pref.getId(), (String) value);
            } else if (value instanceof Integer && pref.getDefValue() instanceof Integer) {
                editor.putInt(pref.getId(), (Integer) value);
            } else if (value instanceof Float && pref.getDefValue() instanceof Float) {
                editor.putFloat(pref.getId(), (Float) value);
            } else if (value instanceof Long && pref.getDefValue() instanceof Long) {
                editor.putLong(pref.getId(), (Long) value);
            } else if (value instanceof Set && pref.getDefValue() instanceof Set) {
                editor.putStringSet(pref.getId(), (Set<String>) value);
            } else {
                String msg = String.format("%s: %s", pref.getId(), value.getClass().getName());
                Log.e(TAG, String.format("Configuration error. InvalidClassException: %s", msg));
                throw new InvalidClassException(msg);
            }


        }
        editor.apply();

        //观察者模式
        if (mListeners != null && mListeners.size() > 0) {
            for (WeatherSetting pref : prefs.keySet()) {
                Object value = prefs.get(pref);
                for (ConfigurationListener listener : mListeners) {
                    listener.onConfigurationChanged(pref,value);
                }
            }
        }
    }

    public void addConfigurationListener(ConfigurationListener listener) {
        if (listener != null) {
            mListeners.add(listener);
        }
    }

    public void removeConfigurationListener(ConfigurationListener listener) {
        if (listener != null) {
            mListeners.remove(listener);
        }
    }

    public static SharedPreferences getSharedPreferences() {
        SharedPreferences sharedPreferences = WeatherApplication
                .getInstance().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences;
    }

}
