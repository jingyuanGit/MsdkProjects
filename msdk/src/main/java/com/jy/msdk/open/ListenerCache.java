package com.jy.msdk.open;


import com.jy.msdk.listeners.ExitListener;
import com.jy.msdk.listeners.InitListener;
import com.jy.msdk.listeners.LoginListener;
import com.jy.msdk.listeners.LogoutListener;
import com.jy.msdk.listeners.PayListener;

public class ListenerCache {

    private ExitListener mExitListener;
    private InitListener mInitListener;
    private LoginListener mLoginListener;
    private LogoutListener mLogoutListener;
    private PayListener mPayListener;

    private ListenerCache() {

    }

    public static ListenerCache getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static ListenerCache INSTANCE = new ListenerCache();
    }

    public ExitListener getExitListener() {
        return mExitListener;
    }

    public ListenerCache setExitListener(ExitListener exitListener) {
        mExitListener = exitListener;
        return this;
    }

    public InitListener getInitListener() {
        return mInitListener;
    }

    public ListenerCache setInitListener(InitListener initListener) {
        mInitListener = initListener;
        return this;
    }

    public LoginListener getLoginListener() {
        return mLoginListener;
    }

    public ListenerCache setLoginListener(LoginListener loginListener) {
        mLoginListener = loginListener;
        return this;
    }

    public LogoutListener getLogoutListener() {
        return mLogoutListener;
    }

    public ListenerCache setLogoutListener(LogoutListener logoutListener) {
        mLogoutListener = logoutListener;
        return this;
    }

    public PayListener getPayListener() {
        return mPayListener;
    }

    public ListenerCache setPayListener(PayListener payListener) {
        mPayListener = payListener;
        return this;
    }
}
