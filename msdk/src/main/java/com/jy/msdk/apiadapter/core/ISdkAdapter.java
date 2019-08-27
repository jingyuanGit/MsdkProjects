package com.jy.msdk.apiadapter.core;

import android.content.Context;

public interface ISdkAdapter {

    void init(Context context);

    boolean isHaveExitDialog();

    void exit(Context context);




}
