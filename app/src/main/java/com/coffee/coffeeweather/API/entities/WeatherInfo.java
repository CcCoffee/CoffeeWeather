package com.coffee.coffeeweather.API.entities;


import java.util.List;

public class WeatherInfo {

    private String desc;
    private int status;
    private Data data;


    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }


    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }


    public void setData(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }




    public class Yesterday {

        private String fl;
        private String fx;
        private String high;
        private String type;
        private String low;
        private String date;


        public void setFl(String fl) {
            this.fl = fl;
        }
        public String getFl() {
            return fl;
        }


        public void setFx(String fx) {
            this.fx = fx;
        }
        public String getFx() {
            return fx;
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
            return "Yesterday{" +
                    "fl='" + fl + '\'' +
                    ", fx='" + fx + '\'' +
                    ", high='" + high + '\'' +
                    ", type='" + type + '\'' +
                    ", low='" + low + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }
    }


    public class Data {

        private String wendu;
        private String ganmao;
        private List<Forecast> forecast;
        private Yesterday yesterday;
        private String aqi;
        private String city;


        public void setWendu(String wendu) {
            this.wendu = wendu;
        }
        public String getWendu() {
            return wendu;
        }


        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }
        public String getGanmao() {
            return ganmao;
        }


        public void setForecast(List<Forecast> forecast) {
            this.forecast = forecast;
        }
        public List<Forecast> getForecast() {
            return forecast;
        }


        public void setYesterday(Yesterday yesterday) {
            this.yesterday = yesterday;
        }
        public Yesterday getYesterday() {
            return yesterday;
        }


        public void setAqi(String aqi) {
            this.aqi = aqi;
        }
        public String getAqi() {
            return aqi;
        }


        public void setCity(String city) {
            this.city = city;
        }
        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "wendu='" + wendu + '\'' +
                    ", ganmao='" + ganmao + '\'' +
                    ", forecast=" + forecast +
                    ", yesterday=" + yesterday +
                    ", aqi='" + aqi + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "desc='" + desc + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }
}