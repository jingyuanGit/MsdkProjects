package com.jy.msdk.open;

import android.content.Context;

import com.jy.msdk.bridge.core.IUser;
import com.jy.msdk.bean.RoleInfo;
import com.jy.msdk.bean.UserInfo;
import com.jy.msdk.model.login.LoginState;


/**
 * 保存用户状态
 */
public class UserFuns {

    private UserInfo mUserInfo;

    private LoginState mState;

    private IUser mUserBridge;

    private UserFuns() {
    }

    public IUser getUserBridge() {
        return mUserBridge;
    }

    public UserFuns setUserBridge(IUser userBridge) {
        mUserBridge = userBridge;
        return this;
    }

    public static UserFuns getInstance() {
        return Holder.INSTANCE;
    }

    public UserInfo getUserInfo() {
        return mUserInfo;
    }

    public UserFuns setUserInfo(UserInfo userInfo) {
        mUserInfo = userInfo;
        return this;
    }

    public LoginState getState() {
        return mState;
    }

    public UserFuns setLoginState(LoginState state) {
        mState = state;
        return this;
    }

    public void login(Context context) {
        if (mUserBridge != null)
            mUserBridge.login(context);
    }

    public void logout(Context context) {
        setLoginState(LoginState.LOGOUT);
        setUserInfo(null);
        if (mUserBridge != null)
            mUserBridge.logout(context);
    }

    public void submitRoleInfo(Context context, RoleInfo roleInfo) {
        if (mUserBridge != null)
            mUserBridge.submitRoleInfo(context, roleInfo);
    }

    private static class Holder {
        static UserFuns INSTANCE = new UserFuns();
    }

}
