package com.jy.msdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;

import com.jy.msdk.apiadapter.core.IActivityAdapter;
import com.jy.msdk.apiadapter.core.IAdapterFactory;
import com.jy.msdk.apiadapter.core.IPayAdapter;
import com.jy.msdk.apiadapter.core.ISdkAdapter;
import com.jy.msdk.apiadapter.core.IUserAdapter;
import com.jy.msdk.bean.OrderInfo;
import com.jy.msdk.bean.RoleInfo;
import com.jy.msdk.builder.AdapterFactoryBuilder;
import com.jy.msdk.listeners.ExitListener;
import com.jy.msdk.listeners.InitListener;
import com.jy.msdk.listeners.LoginListener;
import com.jy.msdk.listeners.LogoutListener;
import com.jy.msdk.listeners.PayListener;
import com.jy.msdk.model.config.SdkConfig;
import com.jy.msdk.open.ActivityFuns;
import com.jy.msdk.open.ListenerCache;
import com.jy.msdk.open.PayFuns;
import com.jy.msdk.open.SdkFuns;
import com.jy.msdk.open.UserFuns;
import com.jy.msdk.uils.LogUtils;


public class MSdk {

    //初始化
    public static void init(Context context) {
        //SdkConfig初始化
        SdkConfig.getInstance().init(context);
        //生成适配器工厂
        IAdapterFactory iAdapterFactory = new AdapterFactoryBuilder().buildAdapterFactory();
        if (iAdapterFactory == null) {
            LogUtils.e("MSdk init error! Please check config.");
            return;
        }
        //创建各种适配器
        ISdkAdapter sdkAdapter = iAdapterFactory.getSdkAdapter();
        IActivityAdapter activityAdapter = iAdapterFactory.getActivityAdapter();
        IUserAdapter userAdapter = iAdapterFactory.getUserAdapter();
        IPayAdapter payAdapter = iAdapterFactory.getPayAdapter();

        //设置适配器
        SdkFuns.getInstance().setISdkAdapter(sdkAdapter);
        ActivityFuns.getInstance().setActivityAdapter(activityAdapter);
        UserFuns.getInstance().setUserAdapter(userAdapter);
        PayFuns.getInstance().setPayAdapter(payAdapter);
        //调用初始化
        SdkFuns.getInstance().init(context);
    }

    public static boolean isLandscape() {
        String isLandscape = SdkConfig.getInstance().get(SdkConfig.IS_LANDSCAPE);
        return !TextUtils.isEmpty(isLandscape) && "1".equals(isLandscape);
    }

    public static boolean isHaveExitDialog() {
        return SdkFuns.getInstance().isHaveExitDialog();
    }

    public static void exit(Context context) {
        SdkFuns.getInstance().exit(context);
    }

    //登录
    public static void login(Context context) {
        UserFuns.getInstance().login(context);
    }

    //登出
    public static void logout(Context context) {
        UserFuns.getInstance().logout(context);
    }

    //登录角色
    public static void submitRoleInfo(Context context, RoleInfo roleInfo) {
        UserFuns.getInstance().submitRoleInfo(context, roleInfo);
    }

    //支付
    public static void pay(Context context, OrderInfo orderInfo, RoleInfo roleInfo) {
        PayFuns.getInstance().pay(context, orderInfo, roleInfo);
    }

    //Activity生命周期函数
    public static void onCreate(Activity activity) {
        ActivityFuns.getInstance().onCreate(activity);
    }

    public static void onStart(Activity activity) {
        ActivityFuns.getInstance().onStart(activity);
    }

    public static void onResume(Activity activity) {
        ActivityFuns.getInstance().onResume(activity);
    }

    public static void onPause(Activity activity) {
        ActivityFuns.getInstance().onPause(activity);
    }

    public static void onStop(Activity activity) {
        ActivityFuns.getInstance().onStop(activity);
    }

    public static void onDestroy(Activity activity) {
        ActivityFuns.getInstance().onDestroy(activity);
    }

    public static void onRestart(Activity activity) {
        ActivityFuns.getInstance().onRestart(activity);
    }

    public static void onNewIntent(Activity activity, Intent intent) {
        ActivityFuns.getInstance().onNewIntent(activity, intent);
    }

    public static void onActivityResult(Activity activity, int requestCode, int resultCode, Intent intent) {
        ActivityFuns.getInstance().onActivityResult(activity, requestCode, resultCode, intent);
    }

    public static void onConfigurationChanged(Configuration configuration, Activity activity) {
        ActivityFuns.getInstance().onConfigurationChanged(configuration, activity);
    }

    public static void setExitListener(ExitListener exitListener) {
        ListenerCache.getInstance().setExitListener(exitListener);
    }

    public static void setInitListener(InitListener initListener) {
        ListenerCache.getInstance().setInitListener(initListener);

    }

    public static void setLoginListener(LoginListener loginListener) {
        ListenerCache.getInstance().setLoginListener(loginListener);
    }

    public static void setPayListener(PayListener payListener) {
        ListenerCache.getInstance().setPayListener(payListener);
    }
}
