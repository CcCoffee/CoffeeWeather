package com.coffee.coffeeweather.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2016/6/25.
 */
@DatabaseTable(tableName = "HotCity")
public class HotCity {

    @DatabaseField(columnName = "_id", generatedId = true)
    private int id;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "posID")
    private int posID;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosID() {
        return posID;
    }

    public void setPosID(int posID) {
        this.posID = posID;
    }

    @Override
    public String toString() {
        return "HotCity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", posID=" + posID +
                '}';
    }
}
