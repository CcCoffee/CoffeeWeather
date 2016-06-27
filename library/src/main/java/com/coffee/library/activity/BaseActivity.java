package com.coffee.library.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/23.
 */
public class BaseActivity extends AppCompatActivity {
    private List<BaseActivity> mActivities=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivities.add(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivities.remove(this);
    }

    public void exitApp(){
        if(null!=mActivities&&!mActivities.isEmpty()){
            try {
                for (BaseActivity activity :
                        mActivities) {
                    activity.finish();
                }
            } catch (Exception e) {
                System.exit(0);
            }
        }
    }
}
