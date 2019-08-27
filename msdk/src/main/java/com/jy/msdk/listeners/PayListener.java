package com.jy.msdk.listeners;

public interface PayListener {

    void onSuccess(String orderId, String cpOrderId, String extraInfo);

    void onCancel(String cpOrderId);

    void onFailed(int code, String cpOrderId, String message);
}
