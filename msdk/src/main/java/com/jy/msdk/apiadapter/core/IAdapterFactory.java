package com.jy.msdk.apiadapter.core;

public interface IAdapterFactory {

    ISdkAdapter getSdkAdapter();

    IActivityAdapter getActivityAdapter();

    IUserAdapter getUserAdapter();

    IPayAdapter getPayAdapter();

}
