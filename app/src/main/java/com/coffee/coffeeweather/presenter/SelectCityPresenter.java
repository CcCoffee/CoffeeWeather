package com.coffee.coffeeweather.presenter;

import android.content.Context;

import com.coffee.coffeeweather.contract.SelectCityContract;
import com.coffee.coffeeweather.database.Dao.CityDao;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/6/26.
 */
public class SelectCityPresenter implements SelectCityContract.Presenter {

    private Context mContext;
    private SelectCityContract.View mView;

    public SelectCityPresenter(Context context,SelectCityContract.View view) {
        mContext = context;
        mView = view;
    }

    @Override
    public void loadCities() {

        Observable.just(new CityDao(mContext).queryAllCity())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mView::displayData);

//        CityDao cityDao = new CityDao(mContext);
//        List<City> cities = cityDao.queryAllCity();
//
//        mView.displayData(cities);

    }

    @Override
    public void start() {
        loadCities();
    }
}
