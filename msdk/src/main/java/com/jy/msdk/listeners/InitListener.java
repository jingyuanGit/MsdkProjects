package com.jy.msdk.listeners;

public interface InitListener {

    void initSuccess();

    void initFailed(int code, String message);
}
