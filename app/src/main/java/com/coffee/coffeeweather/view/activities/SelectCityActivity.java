package com.coffee.coffeeweather.view.activities;

import android.app.SearchManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;

import com.coffee.coffeeweather.R;
import com.coffee.coffeeweather.contract.SelectCityContract;
import com.coffee.coffeeweather.models.City;
import com.coffee.coffeeweather.preferences.Preferences;
import com.coffee.coffeeweather.preferences.WeatherSetting;
import com.coffee.coffeeweather.presenter.SelectCityPresenter;
import com.coffee.coffeeweather.utils.UiUtils;
import com.coffee.coffeeweather.view.adapters.SelectCityAdapter;
import com.coffee.library.activity.BaseActivity;
import com.jakewharton.rxbinding.support.v7.widget.RxSearchView;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Administrator on 2016/6/25.
 */
public class SelectCityActivity extends BaseActivity implements SelectCityContract.View{

    public static final int CURRENT_CITY=1;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.rv)
    RecyclerView mRv;
    private SelectCityPresenter mPresenter;
    private List<City> mCities;
    private SelectCityAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //采用跟主页面一样的布局
        setContentView(R.layout.app_bar_main);
        ButterKnife.bind(this);

        initToolBar();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(SearchManager.QUERY);
        UiUtils.toast(this,stringExtra);

        mPresenter = new SelectCityPresenter(this,this);

        mCities = new ArrayList<>();
        mAdapter = new SelectCityAdapter(this, mCities);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new SelectCityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                UiUtils.toast(SelectCityActivity.this,mAdapter.getCurrentCities().get(position).getName());

                try {
                    Preferences.savePreference(WeatherSetting.SETTINGS_CURRENT_CITY_ID,mAdapter.getCurrentCities().get(position).getPosID());

                } catch (InvalidClassException e) {
                    e.printStackTrace();
                }

//                SharedPreferences sPref = getSharedPreferences(Preferences.PREF_NAME, MODE_PRIVATE);
//                sPref.edit().putInt("current_city_id",mAdapter.getCurrentCities().get(position).getPosID())
//                   .putString("current_city_name",mAdapter.getCurrentCities().get(position).getCity())
//                   .commit();

                Intent resultIntent = new Intent();
                resultIntent.putExtra(WeatherSetting.SETTINGS_CURRENT_CITY_ID.getId(),mAdapter.getCurrentCities().get(position).getPosID());
//                resultIntent.putExtra("current_city_name",mAdapter.getCurrentCities().get(position).getCity());
                setResult(CURRENT_CITY,resultIntent);
                finish();
            }
        });
    }

    private void initToolBar() {
        mToolbar.setTitle("城市选择");
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
            RxSearchView.queryTextChanges(searchView)
                    .map(charSequence -> charSequence == null ? null : charSequence.toString().trim())
                    .throttleLast(100, TimeUnit.MILLISECONDS)
                    .debounce(100, TimeUnit.MILLISECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(searchText -> mAdapter.getFilter().filter(searchText));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mPresenter.start();

    }

    @Override
    public void displayData(List<City> cities) {
        mCities.clear();
        mCities.addAll(cities);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNetWorkError(String message) {

    }

    @Override
    public void showLoadError(String message) {

    }


}
