package com.jy.msdk.bridge.defaults;

import android.content.Context;
import android.widget.Toast;

import com.jy.msdk.bridge.core.IPay;
import com.jy.msdk.bean.OrderInfo;
import com.jy.msdk.bean.RoleInfo;
import com.jy.msdk.bean.UserInfo;


public class PayBridge implements IPay {

    @Override
    public void pay(Context context, OrderInfo orderInfo, RoleInfo gameRoleInfo, UserInfo userInfo) {
        //TODO 拉取支付界面
        Toast.makeText(context, "拉取支付", Toast.LENGTH_LONG).show();
    }

}
