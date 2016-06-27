package com.coffee.library.view;

/**
 * Created by Administrator on 2016/6/23.
 */
public interface BaseView {
    void showLoading();
    void hideLoading();
    void showNetWorkError(String message);
    void showLoadError(String message);
}
