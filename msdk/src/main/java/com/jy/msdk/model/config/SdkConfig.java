package com.jy.msdk.model.config;

import android.content.Context;
import android.util.ArrayMap;

import com.jy.msdk.uils.LogUtils;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class SdkConfig {

    //配置文件名
    public static final String PROPERTIES_NAME = "MSdkConfig.properties";
    //游戏名
    public static final String GAME_ID = "gameId";
    //渠道名
    public static final String CHANNEL_NAME = "channelName";
    //渠道实现类
    public static final String CHANNEL_CLASS = "channelClass";
    //渠道号
    public static final String CHANNEL_ID = "channelId";
    //是否自动拉取登录界面
    public static final String AUTO_LOGIN = "autoLogin";
    //后台地址
    public static final String HOST = "host";
    //是否显示浮标
    public static final String ICON_SWITCH = "iconSwitch";

    public static final String IS_LANDSCAPE = "isLandscape";

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
            LogUtils.i("sdkconfig init success");
        } catch (Exception e) {
            LogUtils.i("sdkconfig init error: " + e.getMessage());
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

    private static class Holder {
        static SdkConfig INSTANCE = new SdkConfig();
    }

}
