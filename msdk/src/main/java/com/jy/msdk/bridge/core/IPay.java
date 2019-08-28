package com.jy.msdk.bridge.core;

import android.content.Context;

import com.jy.msdk.bean.OrderInfo;
import com.jy.msdk.bean.RoleInfo;
import com.jy.msdk.bean.UserInfo;

public interface IPay {

    void pay(Context context, OrderInfo orderInfo, RoleInfo gameRoleInfo, UserInfo userInfo);

}
