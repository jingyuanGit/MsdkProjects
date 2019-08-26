package com.jy.msdk.config;

import android.content.Context;
import android.util.ArrayMap;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class SdkConfig {

    //
    public static final String ACCESS_KEY = "accessKey";
    //配置文件名
    public static final String PROPERTIES_NAME = "TSdkConfig.properties";
    //平台名
    public static final String PLATFORM_NAME = "platformName";
    //平台实现类
    public static final String PLATFORM_CLASS = "platformClass";
    //平台号
    public static final String PLATFORM_ID = "platformId";
    //是否自动拉取登录界面
    public static final String AUTO_LOGIN = "autoLogin";
    //后台地址
    public static final String HOST = "host";
    //是否显示浮标
    public static final String ICON_SWITCH = "iconSwitch";

    private static Map<String, String> save = new ArrayMap<>();

    private SdkConfig() {

    }

    public static SdkConfig getInstance() {
        return Holder.INSTANCE;
    }

    public void init(Context context) {
        String fileName = PROPERTIES_NAME;
        InputStream in = null;
        try {
            in = context.getAssets().open(fileName);
            Properties properties = new Properties();
            properties.load(in);
            Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Object, Object> entry = iterator.next();
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                save.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String get(String key) {
        return save.get(key);
    }

    public void put(String key, String value) {
        save.put(key, value);
    }

    static class Holder {
        static SdkConfig INSTANCE = new SdkConfig();
    }


}
