package com.jy.msdk.open;

import android.content.Context;

import com.jy.msdk.apiadapter.core.IUserAdapter;
import com.jy.msdk.bean.RoleInfo;
import com.jy.msdk.bean.UserInfo;
import com.jy.msdk.model.login.LoginState;


/**
 * 保存用户状态
 */
public class UserFuns {

    private UserInfo mUserInfo;

    private LoginState mState;

    private IUserAdapter mUserAdapter;

    private UserFuns() {
    }

    public IUserAdapter getUserAdapter() {
        return mUserAdapter;
    }

    public UserFuns setUserAdapter(IUserAdapter userAdapter) {
        mUserAdapter = userAdapter;
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
        if (mUserAdapter != null)
            mUserAdapter.login(context);
    }

    public void logout(Context context) {
        setLoginState(LoginState.LOGOUT);
        setUserInfo(null);
        if (mUserAdapter != null)
            mUserAdapter.logout(context);
    }

    public void submitRoleInfo(Context context, RoleInfo roleInfo) {
        if (mUserAdapter != null)
            mUserAdapter.submitRoleInfo(context, roleInfo);
    }

    private static class Holder {
        static UserFuns INSTANCE = new UserFuns();
    }

}
