package com.jy.msdk.apiadapter.defaults;

import com.jy.msdk.apiadapter.core.IActivityAdapter;
import com.jy.msdk.apiadapter.core.IAdapterFactory;
import com.jy.msdk.apiadapter.core.IPayAdapter;
import com.jy.msdk.apiadapter.core.ISdkAdapter;
import com.jy.msdk.apiadapter.core.IUserAdapter;

public class AdapterFactory implements IAdapterFactory {

    @Override
    public ISdkAdapter getSdkAdapter() {
        return null;
    }

    @Override
    public IActivityAdapter getActivityAdapter() {
        return new ActivityAdapter();
    }

    @Override
    public IUserAdapter getUserAdapter() {
        return new UserAdapter();
    }

    @Override
    public IPayAdapter getPayAdapter() {
        return new PayAdapter();
    }
}
