package com.jy.msdk.listeners;

public interface LoginListener {

    void onSuccess(String userId);

    void onCancel();

    void onFailed(int code, String message);
}
