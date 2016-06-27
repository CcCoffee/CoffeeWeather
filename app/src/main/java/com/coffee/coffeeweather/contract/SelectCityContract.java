package com.coffee.coffeeweather.contract;


import com.coffee.coffeeweather.models.City;
import com.coffee.library.presenter.BasePresenter;
import com.coffee.library.view.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2016/6/26.
 */
public interface SelectCityContract {
    interface View extends BaseView{
        void displayData(List<City> cities);
    }

    interface Presenter extends BasePresenter{
        void loadCities();
    }
}
