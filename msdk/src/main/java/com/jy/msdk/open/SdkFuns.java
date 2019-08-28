package com.jy.msdk.open;

import android.content.Context;
import android.widget.ImageView;

import com.jy.msdk.bridge.core.ISdk;

public class SdkFuns {

    private ISdk mSdkBridge;

    private void SdkFuns() {

    }

    public static SdkFuns getInstance() {
        return Holder.INSTANCE;
    }

    public void init(Context context) {
        if (mSdkBridge != null)
            mSdkBridge.init(context);
    }

    public boolean isHaveExitDialog() {
        if (mSdkBridge != null)
            return mSdkBridge.isHaveExitDialog();
        return false;
    }

    public void exit(Context context) {
        if (mSdkBridge != null)
            mSdkBridge.exit(context);
    }


    public ISdk getSdkBridge() {
        return mSdkBridge;
    }

    public SdkFuns setSdkBridge(ISdk ISdkBridge) {
        mSdkBridge = ISdkBridge;
        return this;
    }

    public boolean isSupportSplash() {
        return mSdkBridge.isSupportSplash();
    }

    public void startSplash(Context context, ImageView imageView) {
        mSdkBridge.startSplash(context, imageView);
    }


    private static class Holder {
        static SdkFuns INSTANCE = new SdkFuns();
    }
}
