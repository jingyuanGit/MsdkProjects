package com.jy.msdk.bean;

public class OrderInfo {

    private String orderId;

    private String cpOrderId;

    private int amount;

    private String notifyUrl;

    private String extraInfo;

    private String productName;

    private String productDesc;

    public String getOrderId() {
        return orderId;
    }

    public OrderInfo setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getCpOrderId() {
        return cpOrderId;
    }

    public OrderInfo setCpOrderId(String cpOrderId) {
        this.cpOrderId = cpOrderId;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public OrderInfo setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public OrderInfo setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public OrderInfo setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public OrderInfo setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public OrderInfo setProductDesc(String productDesc) {
        this.productDesc = productDesc;
        return this;
    }
}
