package com.jy.msdk.builder;

import android.text.TextUtils;

import com.jy.msdk.apiadapter.core.IAdapterFactory;
import com.jy.msdk.model.config.SdkConfig;

public class AdapterFactoryBuilder {

    private IAdapterFactory mAdapterFactory;

    public IAdapterFactory buildAdapterFactory() {
        SdkConfig sdkConfig = SdkConfig.getInstance();
        if (mAdapterFactory == null) {
            String platformClass = sdkConfig.get(SdkConfig.PLATFORM_CLASS);
            if (TextUtils.isEmpty(platformClass))
                platformClass = "defaults";
            String adapterFactoryClass = "com.jy.msdk." + platformClass + ".AdapterFactory";
            Class<?> clazz = null;
            try {
                clazz = Class.forName(adapterFactoryClass);
                mAdapterFactory = (IAdapterFactory) clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return mAdapterFactory;
    }


}
