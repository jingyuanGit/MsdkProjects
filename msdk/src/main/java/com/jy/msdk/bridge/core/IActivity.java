package com.jy.msdk.bridge.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

public interface IActivity {

    void onCreate(Activity activity);

    void onDestroy(Activity activity);

    void onStart(Activity activity);

    void onStop(Activity activity);

    void onResume(Activity activity);

    void onPause(Activity activity);

    void onRestart(Activity activity);

    void onNewIntent(Activity activity, Intent intent);

    void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data);

    void onConfigurationChanged(Activity activity, Configuration paramConfiguration);

    void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults);
}
