package com.coffee.api.entities;

import java.util.HashMap;
import java.util.Map;

public class CurCityWeatherInfo {

    /*
    {"weatherinfo":{"city":"汕头","cityid":"101280501","temp1":"11℃","temp2":"20℃","weather":"晴","img1":"n0.gif","img2":"d0.gif","ptime":"18:00"}}
 */


    private Weatherinfo weatherinfo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The weatherinfo
     */
    public Weatherinfo getWeatherinfo() {
        return weatherinfo;
    }

    /**
     *
     * @param weatherinfo
     * The weatherinfo
     */
    public void setWeatherinfo(Weatherinfo weatherinfo) {
        this.weatherinfo = weatherinfo;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    class Weatherinfo {

        private String city;
        private String cityid;
        private String temp1;
        private String temp2;
        private String weather;
        private String img1;
        private String img2;
        private String ptime;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         *
         * @return
         * The city
         */
        public String getCity() {
            return city;
        }

        /**
         *
         * @param city
         * The city
         */
        public void setCity(String city) {
            this.city = city;
        }

        /**
         *
         * @return
         * The cityid
         */
        public String getCityid() {
            return cityid;
        }

        /**
         *
         * @param cityid
         * The cityid
         */
        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        /**
         *
         * @return
         * The temp1
         */
        public String getTemp1() {
            return temp1;
        }

        /**
         *
         * @param temp1
         * The temp1
         */
        public void setTemp1(String temp1) {
            this.temp1 = temp1;
        }

        /**
         *
         * @return
         * The temp2
         */
        public String getTemp2() {
            return temp2;
        }

        /**
         *
         * @param temp2
         * The temp2
         */
        public void setTemp2(String temp2) {
            this.temp2 = temp2;
        }

        /**
         *
         * @return
         * The weather
         */
        public String getWeather() {
            return weather;
        }

        /**
         *
         * @param weather
         * The weather
         */
        public void setWeather(String weather) {
            this.weather = weather;
        }

        /**
         *
         * @return
         * The img1
         */
        public String getImg1() {
            return img1;
        }

        /**
         *
         * @param img1
         * The img1
         */
        public void setImg1(String img1) {
            this.img1 = img1;
        }

        /**
         *
         * @return
         * The img2
         */
        public String getImg2() {
            return img2;
        }

        /**
         *
         * @param img2
         * The img2
         */
        public void setImg2(String img2) {
            this.img2 = img2;
        }

        /**
         *
         * @return
         * The ptime
         */
        public String getPtime() {
            return ptime;
        }

        /**
         *
         * @param ptime
         * The ptime
         */
        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

}



