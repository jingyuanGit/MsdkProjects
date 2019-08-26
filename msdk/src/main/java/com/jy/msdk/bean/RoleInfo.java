package com.jy.msdk.bean;

public class RoleInfo {

    private String serverId;// 服务器Id
    private String serverName;// 服务器名称
    private String roleName;// 角色名称
    private String roleId;// 角色Id
    private int roleLevel;// 等级
    private String roleBalance;// 角色现有金额
    private int roleCreateTime;// UC与1881渠道必传，值为10位数时间戳

    private int vipLevel;// 设置当前用户vip等级，必须为整型字符串

    private String partyName; // 设置帮派，公会名称
    private String roleGender;// 360渠道参数
    private String partyId;// 360渠道参数，设置帮派id，必须为整型字符串
    private String rolePower;// 360渠道参数，设置角色战力，必须为整型字符串
    private String professionId;// 360渠道参数，设置角色职业id，必须为整型字符串
    private String profession;// 360渠道参数，设置角色职业名称
    private String partyRoleId;// 360渠道参数，设置角色在帮派中的id
    private String partyRoleName;// 360渠道参数，设置角色在帮派中的名称
    private String friendList;// 360渠道参数，设置好友关系列表，格式请参考

    public String getServerId() {
        return serverId;
    }

    public RoleInfo setServerId(String serverId) {
        this.serverId = serverId;
        return this;
    }

    public String getServerName() {
        return serverName;
    }

    public RoleInfo setServerName(String serverName) {
        this.serverName = serverName;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public RoleInfo setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getRoleId() {
        return roleId;
    }

    public RoleInfo setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public int getRoleLevel() {
        return roleLevel;
    }

    public RoleInfo setRoleLevel(int roleLevel) {
        this.roleLevel = roleLevel;
        return this;
    }

    public String getRoleBalance() {
        return roleBalance;
    }

    public RoleInfo setRoleBalance(String roleBalance) {
        this.roleBalance = roleBalance;
        return this;
    }

    public int getRoleCreateTime() {
        return roleCreateTime;
    }

    public RoleInfo setRoleCreateTime(int roleCreateTime) {
        this.roleCreateTime = roleCreateTime;
        return this;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public RoleInfo setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
        return this;
    }

    public String getPartyName() {
        return partyName;
    }

    public RoleInfo setPartyName(String partyName) {
        this.partyName = partyName;
        return this;
    }

    public String getRoleGender() {
        return roleGender;
    }

    public RoleInfo setRoleGender(String roleGender) {
        this.roleGender = roleGender;
        return this;
    }

    public String getPartyId() {
        return partyId;
    }

    public RoleInfo setPartyId(String partyId) {
        this.partyId = partyId;
        return this;
    }

    public String getRolePower() {
        return rolePower;
    }

    public RoleInfo setRolePower(String rolePower) {
        this.rolePower = rolePower;
        return this;
    }

    public String getProfessionId() {
        return professionId;
    }

    public RoleInfo setProfessionId(String professionId) {
        this.professionId = professionId;
        return this;
    }

    public String getProfession() {
        return profession;
    }

    public RoleInfo setProfession(String profession) {
        this.profession = profession;
        return this;
    }

    public String getPartyRoleId() {
        return partyRoleId;
    }

    public RoleInfo setPartyRoleId(String partyRoleId) {
        this.partyRoleId = partyRoleId;
        return this;
    }

    public String getPartyRoleName() {
        return partyRoleName;
    }

    public RoleInfo setPartyRoleName(String partyRoleName) {
        this.partyRoleName = partyRoleName;
        return this;
    }

    public String getFriendList() {
        return friendList;
    }

    public RoleInfo setFriendList(String friendList) {
        this.friendList = friendList;
        return this;
    }
}
