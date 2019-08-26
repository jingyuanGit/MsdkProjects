package com.jy.msdk.listeners;

import com.jy.msdk.bean.UserInfo;

public interface LoginListener {

    void onSuccess(String userId);

    void onCancel();

    void onFailed(String message, String trace);
}
