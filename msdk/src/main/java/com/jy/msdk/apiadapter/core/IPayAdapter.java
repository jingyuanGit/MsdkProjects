package com.jy.msdk.apiadapter.core;

import android.content.Context;

import com.jy.msdk.bean.OrderInfo;
import com.jy.msdk.bean.RoleInfo;
import com.jy.msdk.bean.UserInfo;

public interface IPayAdapter {

    void pay(Context context, OrderInfo orderInfo, RoleInfo gameRoleInfo, UserInfo userInfo);

}
