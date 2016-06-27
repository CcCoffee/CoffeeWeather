package com.coffee.coffeeweather.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/25.
 */
public class UiUtils {

    private volatile static Toast mToast;

    /**
     * 单例吐司
     * @param mContext
     * @param message
     */
    public static void toast(Context mContext,String message){
        //其实这里没有必要用到双检锁
        if(mToast==null){
            synchronized (Toast.class){
                if(mToast==null){
                    mToast = Toast.makeText(mContext,message,Toast.LENGTH_SHORT);
                }
            }
        }else{
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
