package com.jy.msdk.open;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;

import com.jy.msdk.bridge.core.IActivity;

public class ActivityFuns {

    private IActivity mActivityBridge;

    private ActivityFuns() {

    }

    public static ActivityFuns getInstance() {
        return Holder.INSTANCE;
    }

    public IActivity getActivityBridge() {
        return mActivityBridge;
    }

    public ActivityFuns setActivityBridge(IActivity activityBridge) {
        mActivityBridge = activityBridge;
        return this;
    }

    public void onCreate(Activity activity) {
        if (mActivityBridge != null)
            mActivityBridge.onCreate(activity);
    }

    public void onStart(Activity activity) {
        if (mActivityBridge != null)
            mActivityBridge.onStart(activity);

    }

    public void onResume(Activity activity) {
        if (mActivityBridge != null)
            mActivityBridge.onResume(activity);

    }

    public void onPause(Activity activity) {
        if (mActivityBridge != null)
            mActivityBridge.onPause(activity);

    }

    public void onStop(Activity activity) {
        if (mActivityBridge != null)
            mActivityBridge.onStop(activity);

    }

    public void onDestroy(Activity activity) {
        if (mActivityBridge != null)
            mActivityBridge.onDestroy(activity);

    }

    public void onRestart(Activity activity) {
        if (mActivityBridge != null)
            mActivityBridge.onRestart(activity);

    }

    public void onNewIntent(Activity activity, Intent intent) {
        if (mActivityBridge != null)
            mActivityBridge.onNewIntent(activity, intent);

    }

    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent intent) {
        if (mActivityBridge != null)
            mActivityBridge.onActivityResult(activity, requestCode, resultCode, intent);

    }

    public void onConfigurationChanged(Configuration configuration, Activity activity) {
        if (mActivityBridge != null)
            mActivityBridge.onConfigurationChanged(activity, configuration);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (mActivityBridge != null)
            mActivityBridge.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private static class Holder {
        static ActivityFuns INSTANCE = new ActivityFuns();
    }
}
