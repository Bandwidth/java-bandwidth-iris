package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RateCenterSearchAndOrderType")
@XmlAccessorType(XmlAccessType.FIELD)
public class RateCenterSearchAndOrderType extends BaseOrderType {
    @XmlElement(name = "RateCenter")
    private String rateCenter;

    @XmlElement(name = "State")
    private String state;

    @XmlElement(name = "EnableLCA")
    private boolean enableLCA;

    public String getRateCenter() {
        return rateCenter;
    }

    public void setRateCenter(String rateCenter) {
        this.rateCenter = rateCenter;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getEnableLCA() {
        return enableLCA;
    }

    public void setEnableLCA(Boolean enableLCA) {
        this.enableLCA = enableLCA;
    }
}
