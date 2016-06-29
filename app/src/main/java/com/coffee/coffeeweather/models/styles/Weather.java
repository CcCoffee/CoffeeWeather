package com.coffee.coffeeweather.models.styles;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28.
 */
@DatabaseTable(tableName = "Weather")
public class Weather {

    public static final String ID_FIELD_NAME = "_id";
    public static final String CITY_NAME_FIELD_NAME = "cityName";
    public static final String CURRENT_TMP_FIELD_NAME = "currentTmp";
    public static final String TIPS_FIELD_NAME = "tips";

    @DatabaseField(columnName = ID_FIELD_NAME, generatedId = true)
    private int id;
    @DatabaseField(columnName = CITY_NAME_FIELD_NAME,canBeNull = false)
    private String cityName;
    @DatabaseField(columnName = CURRENT_TMP_FIELD_NAME)
    private String currentTmp;
    @DatabaseField(columnName = TIPS_FIELD_NAME)
    private String tips;

    private List<Forecast> forecast;
    private Today today;


    public Weather() {

    }

    public Weather(String cityName, String currentTmp, String tips, List<Forecast> forecast, Today today) {
        this.cityName = cityName;
        this.currentTmp = currentTmp;
        this.tips = tips;
        this.forecast = forecast;
        this.today = today;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCurrentTmp() {
        return currentTmp;
    }

    public void setCurrentTmp(String currentTmp) {
        this.currentTmp = currentTmp;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public Today getToday() {
        return today;
    }

    public void setToday(Today today) {
        this.today = today;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", currentTmp='" + currentTmp + '\'' +
                ", tips='" + tips + '\'' +
                ", forecast=" + forecast +
                ", today=" + today +
                '}';
    }
}
