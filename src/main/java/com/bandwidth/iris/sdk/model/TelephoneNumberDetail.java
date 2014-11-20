package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Describes a telephone number with details.
 */
@XmlRootElement(name = "TelephoneNumberDetail")
@XmlAccessorType(XmlAccessType.FIELD)
public class TelephoneNumberDetail extends TelephoneNumber {
    @XmlElement(name = "City")
    private String city;

    @XmlElement(name = "Lata")
    private String lata;

    @XmlElement(name = "RateCenter")
    private String rateCenter;

    @XmlElement(name = "State")
    private String state;

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

}
