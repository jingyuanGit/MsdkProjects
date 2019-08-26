package com.jy.msdk.apiadapter.defaults;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

import com.jy.msdk.apiadapter.core.IActivityAdapter;


/**
 * @author yuan
 */
public class ActivityAdapter implements IActivityAdapter {


    @Override
    public void onApplicationInit(Context context) {

    }

    @Override
    public void onCreate(Activity activity) {
    }

    @Override
    public void onDestroy(Activity activity) {

    }

    @Override
    public void onStart(Activity activity) {

    }

    @Override
    public void onStop(Activity activity) {

    }

    @Override
    public void onResume(Activity activity) {
    }

    @Override
    public void onPause(Activity activity) {


    }

    @Override
    public void onRestart(Activity activity) {

    }


    @Override
    public void onNewIntent(Activity activity, Intent intent) {

    }

    @Override
    public void onActivityResult(Activity activity, int requestCode,
                                 int resultCode, Intent data) {

    }

    @Override
    public void onConfigurationChanged(Configuration paramConfiguration, Activity activity) {

    }

}
