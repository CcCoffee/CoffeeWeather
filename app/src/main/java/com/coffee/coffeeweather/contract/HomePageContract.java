package com.coffee.coffeeweather.contract;

import com.coffee.coffeeweather.API.entities.WeatherInfo;
import com.coffee.library.presenter.BasePresenter;
import com.coffee.library.view.BaseView;

/**
 * Created by Administrator on 2016/6/23.
 */
public interface HomePageContract {
    interface View extends BaseView{
        /**
         * 根据后台返回数据更新UI
         * @param info Json转化的Bean对象
         */
        void setWeatherData(WeatherInfo info);
    }

    interface Presenter extends BasePresenter{
        /**
         * 加载网络数据
         */
        void loadData(String cityName);
    }

}
