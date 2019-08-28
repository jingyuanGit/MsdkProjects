package com.jy.msdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;

import com.jy.msdk.bean.OrderInfo;
import com.jy.msdk.bean.RoleInfo;
import com.jy.msdk.bridge.core.IActivity;
import com.jy.msdk.bridge.core.IPay;
import com.jy.msdk.bridge.core.ISdk;
import com.jy.msdk.bridge.core.IUser;
import com.jy.msdk.builder.BridgeBuilder;
import com.jy.msdk.builder.IBuildBridge;
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
        LogUtils.i("msdk start init");
        //SdkConfig初始化
        SdkConfig.getInstance().init(context);
        //建造桥梁
        IBuildBridge buildBridge = new BridgeBuilder();
        ISdk sdkBridge = buildBridge.buildSdkBridge();
        IActivity activityBridge = buildBridge.buildActivityBridge();
        IUser userBridge = buildBridge.buildUserBridge();
        IPay payBridge = buildBridge.buildPayBridge();
        InitListener initListener = ListenerCache.getInstance().getInitListener();
        if (sdkBridge == null || activityBridge == null || userBridge == null || payBridge == null) {
            if (initListener != null)
                initListener.initFailed(100, "msdk bridge init error");
        }
        //设置适配器
        SdkFuns.getInstance().setSdkBridge(sdkBridge);
        ActivityFuns.getInstance().setActivityBridge(activityBridge);
        UserFuns.getInstance().setUserBridge(userBridge);
        PayFuns.getInstance().setPayBridge(payBridge);
        //调用初始化
        SdkFuns.getInstance().init(context);
        LogUtils.i("msdk end init");
        if (initListener != null)
            initListener.initSuccess();
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

    public static void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        ActivityFuns.getInstance().onRequestPermissionsResult(requestCode, permissions, grantResults);
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

    public static void setLogoutListener(LogoutListener logoutListener) {
        ListenerCache.getInstance().setLogoutListener(logoutListener);
    }

    public static void setPayListener(PayListener payListener) {
        ListenerCache.getInstance().setPayListener(payListener);
    }

}
