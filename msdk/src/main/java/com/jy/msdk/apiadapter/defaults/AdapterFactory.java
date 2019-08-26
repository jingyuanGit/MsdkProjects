package com.jy.msdk.apiadapter.defaults;

import com.jy.msdk.apiadapter.core.IActivityAdapter;
import com.jy.msdk.apiadapter.core.IAdapterFactory;

public class AdapterFactory implements IAdapterFactory {

    @Override
    public IActivityAdapter getActivityAdapter() {
        return new ActivityAdapter();
    }
}
