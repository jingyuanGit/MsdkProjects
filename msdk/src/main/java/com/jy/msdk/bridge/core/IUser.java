package com.jy.msdk.bridge.core;

import android.content.Context;

import com.jy.msdk.bean.RoleInfo;


public interface IUser {

    void login(Context context);

    void logout(Context context);

    void submitRoleInfo(Context context, RoleInfo roleInfo);
}
