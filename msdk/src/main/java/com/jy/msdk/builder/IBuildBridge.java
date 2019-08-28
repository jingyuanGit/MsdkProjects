package com.jy.msdk.builder;

import com.jy.msdk.bridge.core.IActivity;
import com.jy.msdk.bridge.core.IPay;
import com.jy.msdk.bridge.core.ISdk;
import com.jy.msdk.bridge.core.IUser;

public interface IBuildBridge {

    IActivity buildActivityBridge();

    IPay buildPayBridge();

    ISdk buildSdkBridge();

    IUser buildUserBridge();
}
