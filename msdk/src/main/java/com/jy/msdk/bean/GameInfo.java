package com.jy.msdk.bean;

public class GameInfo {

    //游戏key，用于识别哪个游戏
    private String gameKey;

    //渠道ID，用于识别哪个渠道，如应用宝，九游，百度多酷等
    private int channelId;

    //广告渠道ID，用于追踪广告买量渠道
    private int adChannelId;

    //发行商ID，同一游戏，同一渠道可能会有多个发行商来发行
    private int issueId;

    public String getGameKey() {
        return gameKey;
    }

    public GameInfo setGameId(String gameId) {
        this.gameKey = gameId;
        return this;
    }

    public int getChannelId() {
        return channelId;
    }

    public GameInfo setChannelId(int channelId) {
        this.channelId = channelId;
        return this;
    }

    public int getAdChannelId() {
        return adChannelId;
    }

    public GameInfo setAdChannelId(int adChannelId) {
        this.adChannelId = adChannelId;
        return this;
    }

    public int getIssueId() {
        return issueId;
    }

    public GameInfo setIssueId(int issueId) {
        this.issueId = issueId;
        return this;
    }
}
