package com.jy.msdkprojects;

import android.app.Application;
import android.util.Log;

import com.jy.msdk.MSdk;
import com.jy.msdk.listeners.InitListener;

public class DemoApp extends Application {

    private static final String TAG = "MSDKLOG";

    @Override
    public void onCreate() {
        super.onCreate();
        MSdk.setInitListener(new InitListener() {
            @Override
            public void initSuccess() {
                Log.d(TAG, "initSuccess: ok");
            }

            @Override
            public void initFailed(int code, String message) {
                Log.d(TAG, "initFailed: " + message);
            }
        });
        MSdk.init(this);
    }
}
