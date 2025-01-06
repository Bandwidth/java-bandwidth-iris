package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "TnOptionOrderSummary")
@XmlAccessorType(XmlAccessType.FIELD)
public class TnOptionOrderSummary extends BaseModel {

    @XmlElement(name = "accountId")
    private String accountId;

    @XmlElement(name = "CountOfTNs")
    private Integer countOfTNs;

    @XmlElement(name = "userId")
    private String userId;

    @XmlElement(name = "lastModifiedDate")
    private String lastModifiedDate;

    @XmlElement(name = "OrderDate")
    private String orderDate;

    @XmlElement(name = "OrderType")
    private String orderType;

    @XmlElement(name = "OrderStatus")
    private String orderStatus;

    @XmlElement(name = "OrderId")
    private String orderId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getCountOfTNs() {
        return countOfTNs;
    }

    public void setCountOfTNs(Integer countOfTNs) {
        this.countOfTNs = countOfTNs;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
