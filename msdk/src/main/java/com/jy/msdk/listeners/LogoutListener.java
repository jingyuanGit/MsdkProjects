package com.jy.msdk.listeners;

public interface LogoutListener {

    void onSuccess();

    void onFailed(int code, String message);
}
