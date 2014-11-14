package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 11/14/14.
 */
@XmlRootElement(name="CitySearchAndOrderType")
@XmlAccessorType(XmlAccessType.FIELD)
public class CitySearchAndOrderType extends StateSearchAndOrderType {
    @XmlElement(name="City")
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
