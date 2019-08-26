package com.jy.msdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

import com.jy.msdk.config.SdkConfig;

public class MSdk {

    //初始化
    public static void init(Context context) {
        //SdkConfig初始化
        SdkConfig.getInstance().init(context);

        //初始化游戏参数，设备参数







        //生成各种适配器




    }

    //登录
    public static void login() {

    }

    //登出
    public static void logout() {

    }

    //登录角色
    public static void loginRole() {

    }

    //支付
    public static void pay() {

    }

    //Activity生命周期函数
    public static void onCreate(Activity activity) {

    }

    public static void onStart(Activity activity) {

    }

    public static void onResume(Activity activity) {

    }

    public static void onPause(Activity activity) {

    }

    public static void onStop(Activity activity) {

    }

    public static void onDestroy(Activity activity) {

    }

    public static void onRestart(Activity activity) {

    }

    public static void onNewIntent(Activity activity, Intent intent) {

    }

    public static void onActivityResult(Activity activity, int requestCode, int resultCode, Intent intent) {

    }

    public static void onConfigurationChanged(Configuration configuration, Activity activity) {

    }

}
