package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name="CsrData")
@XmlAccessorType(XmlAccessType.FIELD)
public class CsrData {

    @XmlElement(name = "AccountNumber")
    private String accountNumber;

    @XmlElement(name = "CustomerName")
    private String customerName;

    @XmlElement(name = "ServiceAddress")
    private Address serviceAddress;

    @XmlElement(name = "WorkingTelephoneNumber")
    private String workingTelephoneNumber;

    @XmlElementWrapper(name = "WorkingTelephoneNumbersOnAccount")
    @XmlElement(name = "TelephoneNumber")
    private String[] WorkingTelephoneNumbersOnAccount;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Address getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(Address serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getWorkingTelephoneNumber() {
        return workingTelephoneNumber;
    }

    public void setWorkingTelephoneNumber(String workingTelephoneNumber) {
        this.workingTelephoneNumber = workingTelephoneNumber;
    }

    public String[] getWorkingTelephoneNumbersOnAccount() {
        return WorkingTelephoneNumbersOnAccount;
    }

    public void setWorkingTelephoneNumbersOnAccount(String[] workingTelephoneNumbersOnAccount) {
        WorkingTelephoneNumbersOnAccount = workingTelephoneNumbersOnAccount;
    }
}
