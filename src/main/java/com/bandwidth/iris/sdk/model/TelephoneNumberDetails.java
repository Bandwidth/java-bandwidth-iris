package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 11/20/14.
 */
@XmlRootElement(name = "TelephoneNumberDetails")
@XmlAccessorType(XmlAccessType.FIELD)
public class TelephoneNumberDetails extends TelephoneNumberDetail {
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

    @XmlElement(name = "LastModified")
    private String lastModified;

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

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }
}
