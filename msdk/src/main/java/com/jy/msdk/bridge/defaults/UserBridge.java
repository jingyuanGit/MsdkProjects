package com.jy.msdk.bridge.defaults;

import android.content.Context;

import com.jy.msdk.listeners.LoginListener;
import com.jy.msdk.listeners.LogoutListener;
import com.jy.msdk.open.ListenerCache;
import com.jy.msdk.open.UserFuns;
import com.jy.msdk.bridge.core.IUser;
import com.jy.msdk.bean.RoleInfo;
import com.jy.msdk.bean.UserInfo;

import com.jy.msdk.model.login.LoginState;

public class UserBridge implements IUser {

    @Override
    public void login(Context context) {
        //TODO 执行登录，拉取登录界面
        //登录完成，拿到用户信息
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("13mne8sde2");
        UserFuns.getInstance().setUserInfo(userInfo);
        UserFuns.getInstance().setLoginState(LoginState.LOGINED);
        LoginListener loginListener = ListenerCache.getInstance().getLoginListener();
        //回调登录成功
        if (loginListener != null)
            loginListener.onSuccess(userInfo.getUserId());
    }

    @Override
    public void logout(Context context) {

        LogoutListener logoutListener = ListenerCache.getInstance().getLogoutListener();
        //回调登录成功
        if (logoutListener != null)
            logoutListener.onSuccess();
    }

    @Override
    public void submitRoleInfo(Context context, RoleInfo roleInfo) {

    }
}
