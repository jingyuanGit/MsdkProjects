package com.jy.msdk.listeners;

public interface ExitListener {
    void onSuccess();

    void onFailed(String message, String trace);
}
