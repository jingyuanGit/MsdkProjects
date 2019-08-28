package com.jy.msdk.builder;

import android.text.TextUtils;

import com.jy.msdk.bridge.core.IActivity;
import com.jy.msdk.bridge.core.IPay;
import com.jy.msdk.bridge.core.ISdk;
import com.jy.msdk.bridge.core.IUser;
import com.jy.msdk.model.config.SdkConfig;
import com.jy.msdk.uils.LogUtils;

public class BridgeBuilder implements IBuildBridge {

    @Override
    public IActivity buildActivityBridge() {
        return (IActivity) buildBridge("ActivityBridge");
    }

    @Override
    public IPay buildPayBridge() {
        return (IPay) buildBridge("PayBridge");
    }

    @Override
    public ISdk buildSdkBridge() {
        return (ISdk) buildBridge("SdkBridge");
    }

    @Override
    public IUser buildUserBridge() {
        return (IUser) buildBridge("UserBridge");
    }

    private Object buildBridge(String BridgeName) {
        Object bridge = null;
        SdkConfig sdkConfig = SdkConfig.getInstance();
        String platformClass = sdkConfig.get(SdkConfig.CHANNEL_CLASS);
        if (TextUtils.isEmpty(platformClass))
            platformClass = "defaults";
        String bridgeClass = "com.jy.msdk.bridge." + platformClass + "." + BridgeName;
        Class clazz;
        try {
            clazz = Class.forName(bridgeClass);
            bridge = clazz.newInstance();
        } catch (Exception e) {
            LogUtils.e("builder bridge error:" + e.getMessage());
        }
        return bridge;
    }
}
