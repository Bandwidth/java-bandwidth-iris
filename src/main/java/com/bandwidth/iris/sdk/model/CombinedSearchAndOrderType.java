package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CombinedSearchAndOrderType")
@XmlAccessorType(XmlAccessType.FIELD)
public class CombinedSearchAndOrderType extends BaseOrderType {
    @XmlElement(name = "AreaCode")
    private String areaCode;

    public String getAreaCode() {
        return areaCode;
    }

    @XmlElement(name = "City")
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement(name = "EnableLCA")
    private Boolean enableLCA;

    public Boolean isEnableLCA() {
        return enableLCA;
    }

    public void setEnableLCA(Boolean enableLCA) {
        this.enableLCA = enableLCA;
    }

    @XmlElement(name = "EndsIn")
    private Boolean endsIn;

    public Boolean isEndsIn() {
        return endsIn;
    }

    public void setEndsIn(Boolean endsIn) {
        this.endsIn = endsIn;
    }

    @XmlElement(name = "LATA")
    private String lata;

    public String getLata() {
        return lata;
    }

    public void setLata(String lata) {
        this.lata = lata;
    }

    @XmlElement(name = "LocalVanity")
    private String localVanity;

    public String getLocalVanity() {
        return localVanity;
    }

    public void setLocalVanity(String localVanity) {
        this.localVanity = localVanity;
    }

    @XmlElement(name = "NpaNxx")
    private String npaNxx;

    public String getNpaNxx() {
        return npaNxx;
    }

    public void setNpaNxx(String npaNxx) {
        this.npaNxx = npaNxx;
    }

    @XmlElement(name = "NpaNxxX")
    private String npaNxxX;

    public String getNpaNxxX() {
        return npaNxxX;
    }

    public void setNpaNxxX(String npaNxxX) {
        this.npaNxxX = npaNxxX;
    }

    @XmlElement(name = "Quantity")
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @XmlElement(name = "RateCenter")
    private String rateCenter;

    public String getRateCenter() {
        return rateCenter;
    }

    public void setRateCenter(String rateCenter) {
        this.rateCenter = rateCenter;
    }

    @XmlElement(name = "State")
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @XmlElement(name = "Zip")
    private String zip;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
