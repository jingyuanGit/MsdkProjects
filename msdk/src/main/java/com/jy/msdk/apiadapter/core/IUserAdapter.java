package com.jy.msdk.apiadapter.core;

import android.content.Context;

import com.jy.msdk.bean.RoleInfo;


public interface IUserAdapter {

    void login(Context context);

    void logout(Context context);

    void submitRoleInfo(Context context, RoleInfo roleInfo);
}
