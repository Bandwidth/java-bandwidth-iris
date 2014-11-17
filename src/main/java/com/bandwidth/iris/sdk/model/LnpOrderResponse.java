package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sbarstow on 11/17/14.
 */
@XmlRootElement(name="LnpOrderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class LnpOrderResponse {
    @XmlElement(name="ProcessingStatus")
    private String processingStatus;

    @XmlElement(name="Status")
    private Status status;

    @XmlElement(name="Errors")
    private List<Error> errors = new ArrayList<Error>();

    @XmlElement(name="RequestedFocDate")
    private Date requestedFocDate;

    @XmlElement(name="LoaAuthorizingPerson")
    private String loaAuthorizingPerson;

    @XmlElement(name="Subscriber")
    private String subscriber;

    @XmlElement(name="WirelessInfo")
    private WirelessInfo wirelessInfo;

    @XmlElement(name="BillingTelephoneNumber")
    private String billingTelephoneNumber;

    @XmlElementWrapper(name="ListOfPhoneNumbers")
    @XmlElement(name="PhoneNumber")
    private List<String> listOfPhoneNumbers = new ArrayList<String>();

    @XmlElement(name="SiteId")
    private String siteId;

    @XmlElement(name="LosingCarrierName")
    private String losingCarrierName;

    @XmlElement(name="LastModifiedDate")
    private Date lastModifiedDate;

    @XmlElement(name="userId")
    private String userId;

    public String getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public Date getRequestedFocDate() {
        return requestedFocDate;
    }

    public void setRequestedFocDate(Date requestedFocDate) {
        this.requestedFocDate = requestedFocDate;
    }

    public String getLoaAuthorizingPerson() {
        return loaAuthorizingPerson;
    }

    public void setLoaAuthorizingPerson(String loaAuthorizingPerson) {
        this.loaAuthorizingPerson = loaAuthorizingPerson;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    public WirelessInfo getWirelessInfo() {
        return wirelessInfo;
    }

    public void setWirelessInfo(WirelessInfo wirelessInfo) {
        this.wirelessInfo = wirelessInfo;
    }

    public String getBillingTelephoneNumber() {
        return billingTelephoneNumber;
    }

    public void setBillingTelephoneNumber(String billingTelephoneNumber) {
        this.billingTelephoneNumber = billingTelephoneNumber;
    }

    public List<String> getListOfPhoneNumbers() {
        return listOfPhoneNumbers;
    }

    public void setListOfPhoneNumbers(List<String> listOfPhoneNumbers) {
        this.listOfPhoneNumbers = listOfPhoneNumbers;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getLosingCarrierName() {
        return losingCarrierName;
    }

    public void setLosingCarrierName(String losingCarrierName) {
        this.losingCarrierName = losingCarrierName;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}


