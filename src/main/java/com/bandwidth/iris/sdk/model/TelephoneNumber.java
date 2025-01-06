package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Date;

@XmlRootElement(name = "TelephoneNumber")
@XmlAccessorType(XmlAccessType.FIELD)
public class TelephoneNumber {

    @XmlElement(name = "FullNumber")
    protected String fullNumber;

    @XmlElement(name = "TelephoneNumber")
    protected String telephoneNumber;

    @XmlElement(name = "City")
    protected String city;

    @XmlElement(name = "LATA")
    protected String lata;

    @XmlElement(name = "State")
    protected String state;

    @XmlElement(name = "RateCenter")
    protected String rateCenter;

    @XmlElement(name = "Tier")
    private String tier;

    @XmlElement(name = "VendorId")
    private String vendorId;

    @XmlElement(name = "VendorName")
    private String vendorName;

    @XmlElement(name = "Status")
    private String status;

    @XmlElement(name = "AccountId")
    private String accountId;

    @XmlElement(name = "LastModifiedDate")
    private Date lastModifiedDate;

    public TelephoneNumber() {
    }

    public String getFullNumber() {
        return fullNumber;
    }

    public void setFullNumber(String fullNumber) {
        this.fullNumber = fullNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLata() {
        return lata;
    }

    public void setLata(String lata) {
        this.lata = lata;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getRateCenter() {
        return rateCenter;
    }

    public void setRateCenter(String rateCenter) {
        this.rateCenter = rateCenter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}


