package com.coffee.coffeeweather.API.entities;

/**
 * Created by Administrator on 2016/6/27.
 */
public class Forecast {
    private String fengxiang;
    private String fengli;
    private String high;
    private String type;
    private String low;
    private String date;

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
        return "Forecast{" +
                "fengxiang='" + fengxiang + '\'' +
                ", fengli='" + fengli + '\'' +
                ", high='" + high + '\'' +
                ", type='" + type + '\'' +
                ", low='" + low + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
