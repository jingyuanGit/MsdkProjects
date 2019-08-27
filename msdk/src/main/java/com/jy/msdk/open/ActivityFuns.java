package com.jy.msdk.open;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

import com.jy.msdk.apiadapter.core.IActivityAdapter;

public class ActivityFuns {

    private IActivityAdapter mActivityAdapter;

    private ActivityFuns() {

    }

    public static ActivityFuns getInstance() {
        return Holder.INSTANCE;
    }

    public IActivityAdapter getActivityAdapter() {
        return mActivityAdapter;
    }

    public ActivityFuns setActivityAdapter(IActivityAdapter activityAdapter) {
        mActivityAdapter = activityAdapter;
        return this;
    }


    public void onCreate(Activity activity) {
        if (mActivityAdapter != null)
            mActivityAdapter.onCreate(activity);
    }

    public void onStart(Activity activity) {
        if (mActivityAdapter != null)
            mActivityAdapter.onStart(activity);

    }

    public void onResume(Activity activity) {
        if (mActivityAdapter != null)
            mActivityAdapter.onResume(activity);

    }

    public void onPause(Activity activity) {
        if (mActivityAdapter != null)
            mActivityAdapter.onPause(activity);

    }

    public void onStop(Activity activity) {
        if (mActivityAdapter != null)
            mActivityAdapter.onStop(activity);

    }

    public void onDestroy(Activity activity) {
        if (mActivityAdapter != null)
            mActivityAdapter.onDestroy(activity);

    }

    public void onRestart(Activity activity) {
        if (mActivityAdapter != null)
            mActivityAdapter.onRestart(activity);

    }

    public void onNewIntent(Activity activity, Intent intent) {
        if (mActivityAdapter != null)
            mActivityAdapter.onNewIntent(activity, intent);

    }

    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent intent) {
        if (mActivityAdapter != null)
            mActivityAdapter.onActivityResult(activity, requestCode, resultCode, intent);

    }

    public void onConfigurationChanged(Configuration configuration, Activity activity) {
        if (mActivityAdapter != null)
            mActivityAdapter.onConfigurationChanged(activity, configuration);
    }

    private static class Holder {
        static ActivityFuns INSTANCE = new ActivityFuns();
    }
}
