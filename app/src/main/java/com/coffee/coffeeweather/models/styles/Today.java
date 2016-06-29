package com.coffee.coffeeweather.models.styles;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2016/6/28.
 */

@DatabaseTable(tableName = "Today")
public class Today {

    public static final String ID_FIELD_NAME = "_id";
    public static final String CITY_NAME_FIELD_NAME = "cityName";
    public static final String DATE_FIELD_NAME = "date";
    public static final String DATE_OF_WEEK_FIELD_NAME = "dateOfWeek";
    public static final String TYPE_FIELD_NAME = "type";
    public static final String HIGH_FIELD_NAME = "high";
    public static final String LOW_FIELD_NAME = "low";
    public static final String FENG_XIANG_FIELD_NAME = "fengxiang";
    public static final String FENG_LI_FIELD_NAME = "fengli";

    @DatabaseField(columnName = ID_FIELD_NAME, generatedId = true)
    private int id;
    @DatabaseField(columnName = CITY_NAME_FIELD_NAME)
    private String city;
    @DatabaseField(columnName = DATE_FIELD_NAME)
    private String date;
    @DatabaseField(columnName = DATE_OF_WEEK_FIELD_NAME)
    private String dateOfWeek;
    @DatabaseField(columnName = TYPE_FIELD_NAME)
    private String type;
    @DatabaseField(columnName = HIGH_FIELD_NAME)
    private String high;
    @DatabaseField(columnName = LOW_FIELD_NAME)
    private String low;
    @DatabaseField(columnName = FENG_XIANG_FIELD_NAME)
    private String fengxiang;
    @DatabaseField(columnName = FENG_LI_FIELD_NAME)
    private String fengli;

    public Today(String city, String date, String dateOfWeek, String type, String high, String low, String fengxiang, String fengli) {
        this.city = city;
        this.date = date;
        this.dateOfWeek = dateOfWeek;
        this.type = type;
        this.high = high;
        this.low = low;
        this.fengxiang = fengxiang;
        this.fengli = fengli;
    }

    public Today() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDateOfWeek() {
        return dateOfWeek;
    }

    public void setDateOfWeek(String dateOfWeek) {
        this.dateOfWeek = dateOfWeek;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }
    public String getFengxiang() {
        return fengxiang;
    }


    public void setFengli(String fengli) {
        this.fengli = fengli;
    }
    public String getFengli() {
        return fengli;
    }


    public void setHigh(String high) {
        this.high = high;
    }
    public String getHigh() {
        return high;
    }


    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }


    public void setLow(String low) {
        this.low = low;
    }
    public String getLow() {
        return low;
    }


    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Today{" +
                "city='" + city + '\'' +
                ", date='" + date + '\'' +
                ", dateOfWeek='" + dateOfWeek + '\'' +
                ", type='" + type + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", fengxiang='" + fengxiang + '\'' +
                ", fengli='" + fengli + '\'' +
                '}';
    }
}