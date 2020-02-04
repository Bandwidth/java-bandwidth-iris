package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

@XmlRootElement(name="ImportTnOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportTnOrder extends BaseModel {

    @XmlElement(name = "CustomerOrderId")
    private String customerOrderId;

    @XmlElement(name = "OrderCreateDate")
    private String orderCreateDate;

    @XmlElement(name = "AccountId")
    private String accountId;

    @XmlElement(name = "CreatedByUser")
    private String createdByUser;

    @XmlElement(name = "OrderId")
    private String orderId;

    @XmlElement(name = "LastModifiedDate")
    private String lastModifiedDate;

    @XmlElement( name = "SiteId")
    private int siteId;

    @XmlElement(name = "Subscriber")
    private Subscriber subscriber;

    @XmlElement(name = "LoaAuthorizingPerson")
    private String loaAuthorizingPerson;

    @XmlElement(name = "TelephoneNumbers")
    private List<TelephoneNumber> telephoneNumberList;

    @XmlElement(name="ProcessingStatus")
    private String processingStatus;

    @XmlElementWrapper(name = "Errors")
    @XmlElement(name = "Error")
    private List<Error> errors;

    public static ImportTnOrderResponse Create(IrisClient client, ImportTnOrder order) throws Exception {
        return client.post( client.buildAccountModelUri( new String[] { IrisPath.IMPORT_TN_ORDERS } ), order, ImportTnOrderResponse.class);
    }

    public static ImportTnOrders List(IrisClient client, Map<String, Object> query)  throws Exception {
        return client.get( client.buildAccountModelUri( new String[] { IrisPath.IMPORT_TN_ORDERS }, query), ImportTnOrders.class);
    }

    public static ImportTnOrder Get(IrisClient client, String orderId) throws Exception {
        return client.get( client.buildAccountModelUri( new String[] {IrisPath.IMPORT_TN_ORDERS, orderId } ), ImportTnOrder.class);
    }

    public static OrderHistoryWrapper GetHistory( IrisClient client, String orderId ) throws Exception {
        return client.get( client.buildAccountModelUri( new String[] {IrisPath.IMPORT_TN_ORDERS, orderId, "history" } ), OrderHistoryWrapper.class);
    }

    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(String orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
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

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
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

    public List<TelephoneNumber> getTelephoneNumberList() {
        return telephoneNumberList;
    }

    public void setTelephoneNumberList(List<TelephoneNumber> telephoneNumberList) {
        this.telephoneNumberList = telephoneNumberList;
    }

    public String getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}