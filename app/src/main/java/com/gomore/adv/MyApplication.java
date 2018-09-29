package com.gomore.adv;

import android.app.Application;

/**
 * Created by asus on 2018/7/30.
 */

public class MyApplication extends Application {
    private static MyApplication mInstance;

    public static MyApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
