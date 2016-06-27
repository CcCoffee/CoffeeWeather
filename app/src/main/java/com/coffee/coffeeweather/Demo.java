package com.coffee.coffeeweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.coffee.coffeeweather.utils.UiUtils;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxCompoundButton;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.functions.Action1;

public class Demo extends AppCompatActivity {

    @BindView(R.id.send)
    Button mSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);



        RxView.clicks(mSend).throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(aVoid -> UiUtils.toast(this, ""+Log.e("TAG","我点")));
    }
}
