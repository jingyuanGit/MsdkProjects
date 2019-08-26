package com.jy.msdk.bean;

public class UserInfo {
    //唯一用户Id
    private String userId;
    //用户注册时间
    private int userCreateTime;
    //用户注册游戏Id
    private int userCreateGameId;
    //用户注册渠道Id
    private int userCreateChannelId;

    public String getUserId() {
        return userId;
    }

    public UserInfo setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public int getUserCreateTime() {
        return userCreateTime;
    }

    public UserInfo setUserCreateTime(int userCreateTime) {
        this.userCreateTime = userCreateTime;
        return this;
    }

    public int getUserCreateGameId() {
        return userCreateGameId;
    }

    public UserInfo setUserCreateGameId(int userCreateGameId) {
        this.userCreateGameId = userCreateGameId;
        return this;
    }

    public int getUserCreateChannelId() {
        return userCreateChannelId;
    }

    public UserInfo setUserCreateChannelId(int userCreateChannelId) {
        this.userCreateChannelId = userCreateChannelId;
        return this;
    }
}
