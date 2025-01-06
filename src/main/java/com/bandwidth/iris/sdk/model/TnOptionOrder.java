package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "TnOptionOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class TnOptionOrder extends BaseModel {

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

    @XmlElement(name = "ProcessingStatus")
    private String processingStatus;

    @XmlElementWrapper(name = "TnOptionGroups")
    @XmlElement(name = "TnOptionGroup")
    private List<TnOptionGroup> tnOptionGroups;

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    private List<Error> errors;

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

    public String getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }

    public List<TnOptionGroup> getTnOptionGroups() {
        return tnOptionGroups;
    }

    public void setTnOptionGroups(List<TnOptionGroup> tnOptionGroups) {
        this.tnOptionGroups = tnOptionGroups;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
