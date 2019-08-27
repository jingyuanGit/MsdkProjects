package com.jy.msdk.open;


import android.content.Context;
import android.widget.Toast;

import com.jy.msdk.apiadapter.core.IPayAdapter;
import com.jy.msdk.bean.OrderInfo;
import com.jy.msdk.bean.RoleInfo;
import com.jy.msdk.bean.UserInfo;
import com.jy.msdk.listeners.PayListener;
import com.jy.msdk.model.login.LoginState;

public class PayFuns {

    private IPayAdapter mPayAdapter;

    private PayFuns() {
    }

    public static PayFuns getInstance() {
        return Holder.INSTANCE;
    }

    public void pay(Context context, OrderInfo orderInfo, RoleInfo roleInfo) {
        if (UserFuns.getInstance().getState() != LoginState.LOGINED) {
            Toast toast = Toast.makeText(context, "请登录!", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        UserInfo userInfo = UserFuns.getInstance().getUserInfo();
        //TODO 需要去SDK服务器拉取订单号，记录每一个渠道的订单
        // /pay/order
        // ...
        // orderInfo.setOrderId("123456");
        if (mPayAdapter != null)
            mPayAdapter.pay(context, orderInfo, roleInfo, userInfo);
    }

    public IPayAdapter getPayAdapter() {
        return mPayAdapter;
    }

    public PayFuns setPayAdapter(IPayAdapter payAdapter) {
        mPayAdapter = payAdapter;
        return this;
    }

    private static class Holder {
        static PayFuns INSTANCE = new PayFuns();
    }

}
