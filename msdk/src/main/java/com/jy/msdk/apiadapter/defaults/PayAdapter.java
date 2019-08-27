package com.jy.msdk.apiadapter.defaults;

import android.content.Context;

import com.jy.msdk.apiadapter.core.IPayAdapter;
import com.jy.msdk.bean.OrderInfo;
import com.jy.msdk.bean.RoleInfo;
import com.jy.msdk.bean.UserInfo;
import com.jy.msdk.listeners.PayListener;


public class PayAdapter implements IPayAdapter {

    @Override
    public void pay(Context context, OrderInfo orderInfo, RoleInfo gameRoleInfo, UserInfo userInfo) {
        //TODO 拉取支付界面

    }

}
