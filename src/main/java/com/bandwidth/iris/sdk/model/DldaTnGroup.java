package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "DLDATnGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class DldaTnGroup {
    @XmlElementWrapper(name = "TelephoneNumbers")
    @XmlElement(name = "TelephoneNumber")
    private List<String> telephoneNumberList = new ArrayList<String>();

    @XmlElement(name = "AccountType")
    private String accountType;

    @XmlElement(name = "ListingType")
    private String listingType;

    @XmlElement(name = "ListingName")
    private ListingName listingName;

    @XmlElement(name = "ListAddress")
    private boolean listAddress;

    @XmlElement(name = "Address")
    private Address address;

    @XmlElement(name = "SubscriberType")
    private String subscriberType;

    public List<String> getTelephoneNumberList() {
        return telephoneNumberList;
    }

    public void setTelephoneNumberList(List<String> telephoneNumberList) {
        this.telephoneNumberList = telephoneNumberList;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getListingType() {
        return listingType;
    }

    public void setListingType(String listingType) {
        this.listingType = listingType;
    }

    public ListingName getListingName() {
        return listingName;
    }

    public void setListingName(ListingName listingName) {
        this.listingName = listingName;
    }

    public boolean isListAddress() {
        return listAddress;
    }

    public void setListAddress(boolean listAddress) {
        this.listAddress = listAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSubscriberType() {
        return subscriberType;
    }

    public void setSubscriberType(String subscriberType) {
        this.subscriberType = subscriberType;
    }
}
