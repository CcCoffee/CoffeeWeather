package com.coffee.coffeeweather.preferences;

/**
 * Created by Administrator on 2016/6/28.
 */
public enum WeatherSetting {

    SETTINGS_FIRST_USE("first_use",Boolean.TRUE),
    SETTINGS_CURRENT_CITY_ID("current_city_id",101011400);

    private final String mId;
    private final Object mDefValue;

    WeatherSetting(String id, Object defValue) {

        mId = id;
        mDefValue = defValue;
    }

    public String getId() {
        return mId;
    }

    public Object getDefValue() {
        return mDefValue;
    }

    public static WeatherSetting fromId(String id){
        WeatherSetting[] values = values();
        for (WeatherSetting value : values) {
            if(value.getId().equals(id)) return value;
        }
        return null;
    }
}
