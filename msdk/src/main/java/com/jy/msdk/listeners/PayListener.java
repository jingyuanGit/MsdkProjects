package com.jy.msdk.listeners;

public interface PayListener {

    void onSuccess(String orderId, String cpOrderId, String extraInfo);

    void onCancel(String cpOrderId);

    void onFailed(String cpOrderId, String message, String trace);

    void onCompleted();
}
