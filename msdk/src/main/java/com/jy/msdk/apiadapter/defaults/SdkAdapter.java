package com.jy.msdk.apiadapter.defaults;

import android.content.Context;

import com.jy.msdk.apiadapter.core.ISdkAdapter;

public class SdkAdapter implements ISdkAdapter {


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
}
