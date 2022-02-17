package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
