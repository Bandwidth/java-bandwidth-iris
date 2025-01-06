package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RemoveImportedTnOrderSummary")
@XmlAccessorType(XmlAccessType.FIELD)
public class RemoveImportedTnOrderSummary {

    @XmlElement(name = "accountId")
    private int accountId;
    @XmlElement(name = "CountOfTNs")
    private int countOfTNs;
    @XmlElement(name = "userId")
    private String userId;
    @XmlElement(name = "lastModifiedDate")
    private String lastModifiedDate;
    @XmlElement(name = "OrderDate")
    private String orderDate;
    @XmlElement(name = "OrderStatus")
    private String orderStatus;
    @XmlElement(name = "OrderId")
    private String orderId;
    @XmlElement(name = "OrderType")
    private String orderType;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCountOfTNs() {
        return countOfTNs;
    }

    public void setCountOfTNs(int countOfTNs) {
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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
