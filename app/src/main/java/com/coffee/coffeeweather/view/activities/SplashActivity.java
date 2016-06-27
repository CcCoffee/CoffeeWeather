package com.coffee.coffeeweather.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;

import com.coffee.coffeeweather.R;
import com.coffee.coffeeweather.utils.CommonUtils;
import com.coffee.library.activity.BaseActivity;

import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/6/23.
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        CommonUtils.importDataBase();

        loadData();
    }

    private void loadData() {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext(loadFromNet());
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(s -> startNewActivity());
    }

    private void startNewActivity() {
        Toast.makeText(SplashActivity.this, "当前线程:"+Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    private String loadFromNet() {
        SystemClock.sleep(500);
        return "网络好慢，加载成功！";
    }


}
