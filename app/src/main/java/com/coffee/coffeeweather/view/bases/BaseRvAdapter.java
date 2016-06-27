package com.coffee.coffeeweather.view.bases;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/6/25.
 */
public abstract class BaseRvAdapter<T> extends RecyclerView.Adapter {



    private final LayoutInflater mInflater;
    private T mDatas;

    public BaseRvAdapter(Context context, T datas) {
        mDatas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(getLayoutRes(), parent, false);
        BaseRvHolder<T> holder = getHolder(view);
        ButterKnife.bind(holder,view);
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseRvHolder mBaseHolder = (BaseRvHolder) holder;
        mBaseHolder.setData(position,mDatas);
    }

    @Override
    public abstract int getItemCount();
    public abstract int getLayoutRes();
    public abstract BaseRvHolder<T> getHolder(View view);
}