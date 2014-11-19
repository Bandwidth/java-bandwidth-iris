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
public class LnpOrderResponse extends BaseResponse {
    @XmlElement(name="OrderId")
    private String orderId;

    @XmlElement(name="BillingTelephoneNumber")
    private String billingTelephoneNumber;

    @XmlElement(name="Subscriber")
    private Subscriber subscriber;

    @XmlElement(name="LoaAuthorizingPerson")
    private String loaAuthorizingPerson;

    @XmlElementWrapper(name="ListOfPhoneNumbers")
    @XmlElement(name="PhoneNumber")
    private List<String> listOfPhoneNumbers = new ArrayList<String>();

    @XmlElement(name="SiteId")
    private String siteId;

    @XmlElement(name="CustomerOrderId")
    private String customerOrderId;

    @XmlElement(name="RequestedFocDate")
    private Date requestedFocDate;

    @XmlElement(name="AlternateSpid")
    private String alternateSpid;

    @XmlElement(name="PeerId")
    private String peerId;

    @XmlElement(name="PartialPort")
    private boolean partialPort;

    @XmlElement(name="WirelessInfo")
    private String wirelessInfo;


    @XmlElement(name="ProcessingStatus")
    private String processingStatus;

    @XmlElement(name="Status")
    private Status status;

    @XmlElement(name="Errors")
    private List<Error> errors = new ArrayList<Error>();


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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBillingTelephoneNumber() {
        return billingTelephoneNumber;
    }

    public void setBillingTelephoneNumber(String billingTelephoneNumber) {
        this.billingTelephoneNumber = billingTelephoneNumber;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public String getLoaAuthorizingPerson() {
        return loaAuthorizingPerson;
    }

    public void setLoaAuthorizingPerson(String loaAuthorizingPerson) {
        this.loaAuthorizingPerson = loaAuthorizingPerson;
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

    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Date getRequestedFocDate() {
        return requestedFocDate;
    }

    public void setRequestedFocDate(Date requestedFocDate) {
        this.requestedFocDate = requestedFocDate;
    }

    public String getAlternateSpid() {
        return alternateSpid;
    }

    public void setAlternateSpid(String alternateSpid) {
        this.alternateSpid = alternateSpid;
    }

    public String getPeerId() {
        return peerId;
    }

    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    public boolean isPartialPort() {
        return partialPort;
    }

    public void setPartialPort(boolean partialPort) {
        this.partialPort = partialPort;
    }

    public String getWirelessInfo() {
        return wirelessInfo;
    }

    public void setWirelessInfo(String wirelessInfo) {
        this.wirelessInfo = wirelessInfo;
    }
}


