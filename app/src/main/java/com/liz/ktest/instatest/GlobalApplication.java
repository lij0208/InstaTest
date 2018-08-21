package com.liz.ktest.instatest;

import android.app.Application;

public class GlobalApplication extends Application {

    private static volatile GlobalApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static GlobalApplication getInstance() {
        return instance;
    }
}
