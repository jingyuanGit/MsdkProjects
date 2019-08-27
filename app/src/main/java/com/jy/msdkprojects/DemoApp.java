package com.jy.msdkprojects;

import android.app.Application;

import com.jy.msdk.MSdk;

public class DemoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MSdk.init(this);
    }
}
