package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;
import com.bandwidth.iris.sdk.IrisResponse;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Csr")
@XmlAccessorType(XmlAccessType.FIELD)
public class Csr extends BaseModel {

    @XmlElement(name = "AccountId ")
    private String accountId ;

    @XmlElement(name = "CustomerOrderId")
    private String customerOrderId;

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

    @XmlElement(name = "endUserPassword")
    private String EndUserPassword;

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

    @XmlElement(name = "Status")
    private String status;





    public static CsrResponse Create(IrisClient client, Csr order) throws Exception {
        return client.post( client.buildAccountModelUri( new String[] { IrisPath.CSRS } ), order, CsrResponse.class);
    }

    public static CsrResponse Get(IrisClient client, String orderId) throws Exception {
        return client.get( client.buildAccountModelUri( new String[] { IrisPath.CSRS, orderId } ), CsrResponse.class);
    }

    public static CsrResponse Replace(IrisClient client, String orderId, Csr csr) throws Exception {
        return client.put( client.buildAccountModelUri( new String[] { IrisPath.CSRS, orderId } ), csr, CsrResponse.class);
    }

    public static Notes GetNotes(IrisClient client, String orderId) throws Exception {
        return client.get( client.buildAccountModelUri( new String[] { IrisPath.CSRS, orderId, IrisPath.NOTES } ), Notes.class);
    }

    public static IrisResponse AddNote(IrisClient client, String orderId, Note note) throws Exception {
        return client.post( client.buildAccountModelUri( new String[] { IrisPath.CSRS, orderId, IrisPath.NOTES } ), note);
    }

    public static IrisResponse UpdateNote(IrisClient client, String orderId, String noteId, Note note) throws Exception {
        return client.post( client.buildAccountModelUri( new String[] { IrisPath.CSRS, orderId, IrisPath.NOTES, noteId } ), note);
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
        return EndUserPassword;
    }

    public void setEndUserPassword(String endUserPassword) {
        EndUserPassword = endUserPassword;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getzIPCode() {
        return zIPCode;
    }

    public void setzIPCode(String zIPCode) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
