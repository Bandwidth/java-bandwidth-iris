package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ListingName")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListingName {
    @XmlElement(name = "FirstName")
    private String firstName;

    @XmlElement(name = "FirstName2")
    private String firstName2;

    @XmlElement(name = "LastName")
    private String lastName;

    @XmlElement(name = "Designation")
    private String designation;

    @XmlElement(name = "TitleOfLineage")
    private String titleOfLineage;

    @XmlElement(name = "TitleOfAddress")
    private String titleOfAddress;

    @XmlElement(name = "TitleOfAddress2")
    private String titleOfAddress2;

    @XmlElement(name = "TitleOfLineageName2")
    private String titleOfLineageName2;

    @XmlElement(name = "TitleOfAddressName2")
    private String titleOfAddressName2;

    @XmlElement(name = "TitleOfAddress2Name2")
    private String titleOfAddress2Name2;

    @XmlElement(name = "PlaceListingAs")
    private String placeListingAs;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName2() {
        return firstName2;
    }

    public void setFirstName2(String firstName2) {
        this.firstName2 = firstName2;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getTitleOfLineage() {
        return titleOfLineage;
    }

    public void setTitleOfLineage(String titleOfLineage) {
        this.titleOfLineage = titleOfLineage;
    }

    public String getTitleOfAddress() {
        return titleOfAddress;
    }

    public void setTitleOfAddress(String titleOfAddress) {
        this.titleOfAddress = titleOfAddress;
    }

    public String getTitleOfAddress2() {
        return titleOfAddress2;
    }

    public void setTitleOfAddress2(String titleOfAddress2) {
        this.titleOfAddress2 = titleOfAddress2;
    }

    public String getTitleOfLineageName2() {
        return titleOfLineageName2;
    }

    public void setTitleOfLineageName2(String titleOfLineageName2) {
        this.titleOfLineageName2 = titleOfLineageName2;
    }

    public String getTitleOfAddressName2() {
        return titleOfAddressName2;
    }

    public void setTitleOfAddressName2(String titleOfAddressName2) {
        this.titleOfAddressName2 = titleOfAddressName2;
    }

    public String getTitleOfAddress2Name2() {
        return titleOfAddress2Name2;
    }

    public void setTitleOfAddress2Name2(String titleOfAddress2Name2) {
        this.titleOfAddress2Name2 = titleOfAddress2Name2;
    }

    public String getPlaceListingAs() {
        return placeListingAs;
    }

    public void setPlaceListingAs(String placeListingAs) {
        this.placeListingAs = placeListingAs;
    }

}
