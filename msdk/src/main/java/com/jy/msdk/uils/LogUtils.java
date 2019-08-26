package com.jy.msdk.uils;

import android.util.Log;

/**
 * Created by yuan on 2017/5/3.
 * 日志工具
 */
public class LogUtils {

    private static String TAG = "MSDKLOG";

    private static boolean logSwitch = false; //日志开关,默认打开

    private static void setTAG(String tag) {
        TAG = tag;
    }

    public static void setLogSwitch(boolean flag) {
        logSwitch = flag;
    }

    public static void v(String log) {
        if (logSwitch) {
            if (log != null && log.length() > 4000) {
                for (int i = 0; i < log.length(); i += 4000) {
                    if (i + 4000 < log.length())
                        Log.v(TAG + i, log.substring(i, i + 4000));
                    else
                        Log.v(TAG + i, log.substring(i, log.length()));
                }
            } else
                Log.v(TAG, log);
        }
    }

    public static void d(String log) {
        if (logSwitch) {
            if (log != null && log.length() > 4000) {
                for (int i = 0; i < log.length(); i += 4000) {
                    if (i + 4000 < log.length())
                        Log.d(TAG + i, log.substring(i, i + 4000));
                    else
                        Log.d(TAG + i, log.substring(i, log.length()));
                }
            } else
                Log.d(TAG, log);
        }
    }

    public static void i(String log) {
        if (logSwitch) {
            if (log != null && log.length() > 4000) {
                for (int i = 0; i < log.length(); i += 4000) {
                    if (i + 4000 < log.length())
                        Log.i(TAG + i, log.substring(i, i + 4000));
                    else
                        Log.i(TAG + i, log.substring(i, log.length()));
                }
            } else
                Log.i(TAG, log);
        }
    }

    public static void w(String log) {
        if (logSwitch) {
            if (log != null && log.length() > 4000) {
                for (int i = 0; i < log.length(); i += 4000) {
                    if (i + 4000 < log.length())
                        Log.w(TAG + i, log.substring(i, i + 4000));
                    else
                        Log.w(TAG + i, log.substring(i, log.length()));
                }
            } else
                Log.w(TAG, log);
        }
    }

    public static void e(String log) {
        if (logSwitch) {
            if (log != null && log.length() > 4000) {
                for (int i = 0; i < log.length(); i += 4000) {
                    if (i + 4000 < log.length())
                        Log.e(TAG + i, log.substring(i, i + 4000));
                    else
                        Log.e(TAG + i, log.substring(i, log.length()));
                }
            } else
                Log.e(TAG, log);
        }
    }

}
