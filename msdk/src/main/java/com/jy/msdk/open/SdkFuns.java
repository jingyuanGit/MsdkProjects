package com.jy.msdk.open;

import android.content.Context;

import com.jy.msdk.apiadapter.core.ISdkAdapter;

public class SdkFuns {

    private ISdkAdapter mISdkAdapter;


    private void SdkFuns() {

    }

    public static SdkFuns getInstance() {
        return Holder.INSTANCE;
    }

    public void init(Context context) {
        if (mISdkAdapter != null)
            mISdkAdapter.init(context);
    }

    public boolean isHaveExitDialog() {
        if (mISdkAdapter != null)
            return mISdkAdapter.isHaveExitDialog();
        return false;
    }

    public void exit(Context context) {
        if (mISdkAdapter != null)
            mISdkAdapter.exit(context);
    }


    public ISdkAdapter getISdkAdapter() {
        return mISdkAdapter;
    }

    public SdkFuns setISdkAdapter(ISdkAdapter ISdkAdapter) {
        mISdkAdapter = ISdkAdapter;
        return this;
    }

    private static class Holder {
        static SdkFuns INSTANCE = new SdkFuns();
    }
}
