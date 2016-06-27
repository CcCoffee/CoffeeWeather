package com.coffee.coffeeweather.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2016/6/25.
 */
@DatabaseTable(tableName = "City")
public class City {

    @DatabaseField(columnName = "_id", generatedId = true)
    private int id;
    @DatabaseField(columnName = "root")
    private String province;
    @DatabaseField(columnName = "parent")
    private String city;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "pinyin")
    private String pinyin;
    @DatabaseField(columnName = "x")
    private String x;
    @DatabaseField(columnName = "y")
    private String y;
    @DatabaseField(columnName = "posID")
    private int posID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public int getPosID() {
        return posID;
    }

    public void setPosID(int posID) {
        this.posID = posID;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", posID=" + posID +
                '}';
    }
}
