package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 10/9/14.
 */
@XmlRootElement(name = "Address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    @XmlElement(name="HouseNumber")
    private String houseNumber;

    @XmlElement(name="StreetName")
    private String streetName;

    @XmlElement(name="City")
    private String city;

    @XmlElement(name="StateCode")
    private String state;

    @XmlElement(name="Zip")
    private String zip;

    @XmlElement(name="Country")
    private String country;

    @XmlElement(name="AddressType")
    private String addressType;

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
}
