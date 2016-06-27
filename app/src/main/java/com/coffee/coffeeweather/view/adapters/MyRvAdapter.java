package com.coffee.coffeeweather.view.adapters;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.view.View;

import com.coffee.coffeeweather.R;
import com.coffee.coffeeweather.view.bases.BaseRvHolder;
import com.coffee.coffeeweather.view.bases.BaseRvAdapter;
import com.coffee.coffeeweather.view.holders.MyRvHolder;
import com.coffee.coffeeweather.API.entities.WeatherInfo;

/**
 * Created by Administrator on 2016/6/25.
 */
public class MyRvAdapter extends BaseRvAdapter<WeatherInfo.Data> {

    private Context mContext;
    private WeatherInfo.Data mDatas;

    public MyRvAdapter(Context context, WeatherInfo.Data datas) {
        super(context, datas);
        mContext = context;
        mDatas = datas;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_card_main;
    }

    @Override
    public BaseRvHolder<WeatherInfo.Data> getHolder(View view) {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            StateListAnimator stateListAnimator = AnimatorInflater.loadStateListAnimator(mContext, R.drawable.touch_animstated_rawable);
            view.setStateListAnimator(stateListAnimator);
        }

        MyRvHolder holder = new MyRvHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return mDatas.getForecast().size();
    }


}
