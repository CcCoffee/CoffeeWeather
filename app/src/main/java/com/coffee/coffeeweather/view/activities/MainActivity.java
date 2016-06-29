package com.coffee.coffeeweather.view.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.coffee.coffeeweather.API.entities.Forecast;
import com.coffee.coffeeweather.R;
import com.coffee.coffeeweather.WeatherApplication;
import com.coffee.coffeeweather.database.Dao.CityDao;
import com.coffee.coffeeweather.models.HotCity;
import com.coffee.coffeeweather.preferences.Preferences;
import com.coffee.coffeeweather.preferences.WeatherSetting;
import com.coffee.coffeeweather.utils.UiUtils;
import com.coffee.coffeeweather.view.adapters.MyRvAdapter;
import com.coffee.coffeeweather.contract.HomePageContract;
import com.coffee.coffeeweather.API.entities.WeatherInfo;
import com.coffee.coffeeweather.presenter.HomePagePresenter;
import com.coffee.library.activity.BaseActivity;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, HomePageContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.header_navigation)
    NavigationView mHeaderNavigation;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.rv)
    RecyclerView mRv;

    private ActionBarDrawerToggle mToggle;
    private HomePagePresenter mHomePagePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initToolBarAndDrawerLayout();
        File databaseFile = WeatherApplication.getInstance().getDatabasePath("city.db");
        if(databaseFile.exists()){
            UiUtils.toast(this,"文件大小:"+databaseFile.length());
        }

        int currentCity = Preferences.getSharedPreferences().getInt(WeatherSetting.SETTINGS_CURRENT_CITY_ID.getId(), 101010100);

//        SharedPreferences sharedPreferences = getSharedPreferences(Preferences.PREF_NAME, MODE_PRIVATE);
//        String currentCity = sharedPreferences.getString("current_city_name", "汕头");
//        String currentCity = sharedPreferences.getInt("current_city_id",101010100)+"";

        //拿到presenter实例
        mHomePagePresenter = new HomePagePresenter(this);
        mHomePagePresenter.loadData(currentCity+"");

//        List<HotCity> hotCities = new CityDao(this).queryAllHotCity();
//        Log.e("DataBase",hotCities.toString());

    }

    private void initToolBarAndDrawerLayout() {
        mToolbar.setTitle("Toolbar");//设置Toolbar标题
        mToolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open_drawer, R.string.open_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                UiUtils.toast(MainActivity.this,"抽屉打开");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                UiUtils.toast(MainActivity.this,"抽屉关闭");
            }
        };
        mToggle.syncState();

        mHeaderNavigation.setNavigationItemSelectedListener(this);
        mDrawerLayout.addDrawerListener(mToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //通过ID来响应菜单项

        switch (id) {
            case R.id.setting_menu:
                UiUtils.toast(this,"设置");
                return true;
            case R.id.city_setting_menu:
                Intent intent=new Intent(this,SelectCityActivity.class);
                startActivityForResult(intent,1);
                return true;
            case R.id.city_manage_menu:
                UiUtils.toast(this,"城市管理");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==SelectCityActivity.CURRENT_CITY){
            int cityId = data.getIntExtra(WeatherSetting.SETTINGS_CURRENT_CITY_ID.getId(),101010100);
            mHomePagePresenter.loadData(cityId+"");
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {


        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.navigation_camera:
                UiUtils.toast(this,"拍照");
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.navigation_gallery:
                UiUtils.toast(this,"图库");
                return true;
            case R.id.navigation_manage:
                UiUtils.toast(this,"设置");
                return true;
            case R.id.navigation_slideshow:
                UiUtils.toast(this,"幻灯片");
                return true;
            case R.id.navigation_send:
                UiUtils.toast(this,"发送");
                return true;
            case R.id.navigation_share:
                UiUtils.toast(this,"分享");
                return true;
        }
        return false;
    }

    @Override
    public void setWeatherData(WeatherInfo info) {

        List<Forecast> forecasts = info.getData().getForecast();

        MyRvAdapter adapter = new MyRvAdapter(this, info.getData());
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(adapter);

        Log.e("TAG", Thread.currentThread().getName() + "  " + forecasts.get(0).toString());
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
