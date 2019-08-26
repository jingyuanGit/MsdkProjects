package com.jy.msdk.listeners;


/**
 * Created by yuan on 2017/4/10.
 * 登出回调接口
 */

public interface LogoutListener {

    void onSuccess(String userId);

    void onFailed(String message, String trace);
}
