package com.jy.msdk.apiadapter.defaults;

import android.content.Context;

import com.jy.msdk.open.UserFuns;
import com.jy.msdk.apiadapter.core.IUserAdapter;
import com.jy.msdk.bean.RoleInfo;
import com.jy.msdk.bean.UserInfo;

import com.jy.msdk.listeners.LoginListener;
import com.jy.msdk.listeners.LogoutListener;
import com.jy.msdk.model.login.LoginState;

public class UserAdapter implements IUserAdapter {

    @Override
    public void login(Context context) {
        //TODO 执行登录，拉取登录界面

        //登录完成，拿到用户信息
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("123");
        UserFuns.getInstance().setUserInfo(userInfo);
        UserFuns.getInstance().setLoginState(LoginState.LOGINED);


//        //回调登录成功
//        if (loginListener != null)
//            loginListener.onSuccess(userInfo.getUserId());
    }

    @Override
    public void logout(Context context) {

    }

    @Override
    public void submitRoleInfo(Context context, RoleInfo roleInfo) {

    }
}
