package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

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

    @XmlElement(name = "Features")
    private Features features;

    @XmlElement(name = "Lata")
    private String lata;

    @XmlElement(name = "MessagingSettings")
    private MessagingSettings messagingSettings;

    @XmlElementWrapper(name = "ServiceTypes")
    @XmlElement(name = "ServiceType")
    private List<String> serviceTypes = new ArrayList<>();

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

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    public String getLata() {
        return lata;
    }

    public void setLata(String lata) {
        this.lata = lata;
    }

    public MessagingSettings getMessagingSettings() {
        return messagingSettings;
    }

    public void setMessagingSettings(MessagingSettings messagingSettings) {
        this.messagingSettings = messagingSettings;
    }

    public List<String> getServiceTypes() { return serviceTypes; }

    public void setServiceTypes(List<String> serviceTypes) { this.serviceTypes = serviceTypes; }
}
