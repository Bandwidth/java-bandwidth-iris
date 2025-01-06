package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ServiceAddress")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceAddress {
    @XmlElement(name = "HouseNumber")
    private String houseNumber;

    @XmlElement(name = "HousePrefix")
    private String housePrefix;

    @XmlElement(name = "HouseSuffix")
    private String houseSuffix;

    @XmlElement(name = "PreDirectional")
    private String preDirectional;

    @XmlElement(name = "StreetName")
    private String streetName;

    @XmlElement(name = "StreetSuffix")
    private String streetSuffix;

    @XmlElement(name = "PostDirectional")
    private String postDirectional;

    @XmlElement(name = "AddressLine2")
    private String addressLine2;

    @XmlElement(name = "City")
    private String city;

    @XmlElement(name = "StateCode")
    private String stateCode;

    @XmlElement(name = "Zip")
    private String zip;

    @XmlElement(name = "Country")
    private String country = "USA";

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHousePrefix() {
        return housePrefix;
    }

    public void setHousePrefix(String housePrefix) {
        this.housePrefix = housePrefix;
    }

    public String getHouseSuffix() {
        return houseSuffix;
    }

    public void setHouseSuffix(String houseSuffix) {
        this.houseSuffix = houseSuffix;
    }

    public String getPreDirectional() {
        return preDirectional;
    }

    public void setPreDirectional(String preDirectional) {
        this.preDirectional = preDirectional;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetSuffix() {
        return streetSuffix;
    }

    public void setStreetSuffix(String streetSuffix) {
        this.streetSuffix = streetSuffix;
    }

    public String getPostDirectional() {
        return postDirectional;
    }

    public void setPostDirectional(String postDirectional) {
        this.postDirectional = postDirectional;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
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
}
