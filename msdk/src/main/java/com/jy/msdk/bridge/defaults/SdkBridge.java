package com.jy.msdk.bridge.defaults;

import android.content.Context;
import android.widget.ImageView;

import com.jy.msdk.bridge.core.ISdk;

public class SdkBridge implements ISdk {

    @Override
    public void init(Context context) {

    }

    @Override
    public boolean isHaveExitDialog() {
        return false;
    }

    @Override
    public void exit(Context context) {

    }

    @Override
    public boolean isSupportSplash() {
        return false;
    }

    @Override
    public void startSplash(Context context, ImageView imageView) {

    }
}
