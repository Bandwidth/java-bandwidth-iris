package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "RateCenterGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class RateCenterGroup {
    @XmlElement(name = "RateCenter")
    private String rateCenter;

    @XmlElement(name = "City")
    private String city;

    @XmlElement(name = "State")
    private String state;

    @XmlElement(name = "LATA")
    private String LATA;

    @XmlElementWrapper(name = "Tiers")
    @XmlElement(name = "Tier")
    private List<String> tiers = new ArrayList<String>();

    @XmlElementWrapper(name = "TnList")
    @XmlElement(name = "Tn")
    private List<String> tnList = new ArrayList<String>();

    public String getRateCenter() {
        return rateCenter;
    }

    public void setRateCenter(String rateCenter) {
        this.rateCenter = rateCenter;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLATA() {
        return LATA;
    }

    public void setLATA(String LATA) {
        this.LATA = LATA;
    }

    public List<String> getTiers() {
        return tiers;
    }

    public void setTiers(List<String> tiers) {
        this.tiers = tiers;
    }

    public List<String> getTnList() {
        return tnList;
    }

    public void setTnList(List<String> tnList) {
        this.tnList = tnList;
    }
}
