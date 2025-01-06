package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "TelephoneNumberResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class TelephoneNumberResponse extends BaseResponse {
    @XmlElement(name = "TelephoneNumberDetails")
    private TelephoneNumberDetails telephoneNumberDetails;

    @XmlElement(name = "TelephoneNumber")
    private String telephoneNumber;

    @XmlElement(name = "Status")
    private String status;

    @XmlElement(name = "LastModifiedDate")
    private Date lastModifiedDate;

    @XmlElement(name = "OrderCreatedDate")
    private Date orderCreatedDate;

    @XmlElement(name = "OrderId")
    private String orderId;

    @XmlElement(name = "OrderType")
    private String orderType;

    @XmlElement(name = "SiteId")
    private String siteId;

    @XmlElement(name = "AccountId")
    private String accountId;

    public TelephoneNumberDetails getTelephoneNumberDetails() {
        return telephoneNumberDetails;
    }

    public void setTelephoneNumberDetails(TelephoneNumberDetails telephoneNumberDetails) {
        this.telephoneNumberDetails = telephoneNumberDetails;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getOrderCreatedDate() {
        return orderCreatedDate;
    }

    public void setOrderCreatedDate(Date orderCreatedDate) {
        this.orderCreatedDate = orderCreatedDate;
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

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
