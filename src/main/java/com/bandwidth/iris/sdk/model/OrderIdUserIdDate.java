package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "OrderIdUserIdDate")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderIdUserIdDate {

    @XmlElement(name = "accountId")
    private String accountId;

    @XmlElement(name = "CountOfTNs")
    private int countOfTns;

    @XmlElement(name = "userId")
    private String userId;

    @XmlElement(name = "lastModifiedDate")
    private Date lastModifiedDte;

    @XmlElement(name = "OrderType")
    private String orderType;

    @XmlElement(name = "OrderDate")
    private Date orderDate;

    @XmlElement(name = "orderId")
    private String orderId;

    @XmlElement(name = "OrderStatus")
    private String orderStatus;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getCountOfTns() {
        return countOfTns;
    }

    public void setCountOfTns(int countOfTns) {
        this.countOfTns = countOfTns;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLastModifiedDte() {
        return lastModifiedDte;
    }

    public void setLastModifiedDte(Date lastModifiedDte) {
        this.lastModifiedDte = lastModifiedDte;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

}
