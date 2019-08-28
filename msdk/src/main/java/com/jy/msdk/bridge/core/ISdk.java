package com.jy.msdk.bridge.core;

import android.content.Context;
import android.widget.ImageView;

public interface ISdk {

    void init(Context context);

    boolean isHaveExitDialog();

    void exit(Context context);

    boolean isSupportSplash();

    void startSplash(Context context, ImageView imageView);

}
