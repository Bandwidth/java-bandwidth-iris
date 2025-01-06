package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;


@XmlRootElement(name="CsrResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class CsrResponse {

    @XmlElement(name = "AccountId")
    private String accountId ;

    @XmlElement(name = "LastModifiedBy")
    private String lastModifiedBy;

    @XmlElement(name = "OrderId")
    private String orderId;

    @XmlElement(name = "LastModifiedDate")
    private String lastModifiedDate;

    @XmlElement(name = "Status")
    private String status;

    @XmlElement(name = "OrderCreateDate")
    private String orderCreateDate;

    @XmlElement(name = "CustomerOrderId")
    private String customerOrderId;

    @XmlElement(name = "CustomerName")
    private String customerName;

    @XmlElement(name = "WorkingOrBillingTelephoneNumber ")
    private String workingOrBillingTelephoneNumber;

    @XmlElement(name = "AccountNumber")
    private String accountNumber;

    @XmlElement(name = "AccountTelephoneNumber")
    private String accountTelephoneNumber;

    @XmlElement(name = "EndUserName")
    private String endUserName;

    @XmlElement(name = "AuthorizingUserName")
    private String authorizingUserName;

    @XmlElement(name = "CustomerCode")
    private String customerCode;

    @XmlElement(name = "EndUserPIN")
    private String endUserPIN;

    @XmlElement(name = "EndUserPassword")
    private String endUserPassword;

    @XmlElement(name = "AddressLine1")
    private String addressLine1;

    @XmlElement(name = "ZIPCode")
    private String zIPCode;

    @XmlElement(name = "City")
    private String city;

    @XmlElement(name = "State")
    private String state;

    @XmlElement(name = "TypeOfService")
    private String typeOfService;

    @XmlElement(name = "CsrData")
    private CsrData csrData;

    @XmlElementWrapper(name = "Errors")
    @XmlElement(name = "Error")
    private Error[] errors;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public String getOrderCreateDate() {
        return orderCreateDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderCreateDate(String orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getWorkingOrBillingTelephoneNumber() {
        return workingOrBillingTelephoneNumber;
    }

    public void setWorkingOrBillingTelephoneNumber(String workingOrBillingTelephoneNumber) {
        this.workingOrBillingTelephoneNumber = workingOrBillingTelephoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountTelephoneNumber() {
        return accountTelephoneNumber;
    }

    public void setAccountTelephoneNumber(String accountTelephoneNumber) {
        this.accountTelephoneNumber = accountTelephoneNumber;
    }

    public String getEndUserName() {
        return endUserName;
    }

    public void setEndUserName(String endUserName) {
        this.endUserName = endUserName;
    }

    public String getAuthorizingUserName() {
        return authorizingUserName;
    }

    public void setAuthorizingUserName(String authorizingUserName) {
        this.authorizingUserName = authorizingUserName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getEndUserPIN() {
        return endUserPIN;
    }

    public void setEndUserPIN(String endUserPIN) {
        this.endUserPIN = endUserPIN;
    }

    public String getEndUserPassword() {
        return endUserPassword;
    }

    public void setEndUserPassword(String endUserPassword) {
        this.endUserPassword = endUserPassword;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getZIPCode() {
        return zIPCode;
    }

    public void setZIPCode(String zIPCode) {
        this.zIPCode = zIPCode;
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

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public CsrData getCsrData() {
        return csrData;
    }

    public void setCsrData(CsrData csrData) {
        this.csrData = csrData;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Error[] getErrors() {
        return errors;
    }

    public void setErrors(Error[] errors) {
        this.errors = errors;
    }
}
