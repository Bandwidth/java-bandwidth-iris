package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "OrderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderResponse {
    @XmlElement(name = "Order")
    private Order order;

    @XmlElement(name = "CompletedQuantity")
    private int completedQuantity;

    @XmlElement(name = "CreatedByUser")
    private String createdByUser;

    @XmlElement(name = "FailedQuantity")
    private int failedQuantity;

    @XmlElement(name = "PendingQuantity")
    private int pendingQuantity;

    @XmlElement(name = "OrderCompleteDate")
    private Date orderCompletedDate;

    @XmlElement(name = "LastModifiedDate")
    private Date lastModifiedDate;

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    private List<Error> errorList = new ArrayList<Error>();

    @XmlElement(name = "OrderStatus")
    private String orderStatus;

    @XmlElementWrapper(name = "CompletedNumbers")
    @XmlElement(name = "TelephoneNumber")
    private List<TelephoneNumber> telephoneNumbers = new ArrayList<TelephoneNumber>();

    @XmlElement(name = "FailedNumbers")
    private List<TelephoneNumber> failedNumbers = new ArrayList<TelephoneNumber>();
    
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getCompletedQuantity() {
        return completedQuantity;
    }

    public void setCompletedQuantity(int completedQuantity) {
        this.completedQuantity = completedQuantity;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public int getFailedQuantity() {
        return failedQuantity;
    }

    public void setFailedQuantity(int failedQuantity) {
        this.failedQuantity = failedQuantity;
    }

    public int getPendingQuantity() {
        return pendingQuantity;
    }

    public void setPendingQuantity(int pendingQuantity) {
        this.pendingQuantity = pendingQuantity;
    }

    public Date getOrderCompletedDate() {
        return orderCompletedDate;
    }

    public void setOrderCompletedDate(Date orderCompletedDate) {
        this.orderCompletedDate = orderCompletedDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public List<Error> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Error> errorList) {
        this.errorList = errorList;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<TelephoneNumber> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setTelephoneNumbers(List<TelephoneNumber> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public List<TelephoneNumber> getFailedNumbers() {
      return failedNumbers;
    }

    public void setFailedNumbers(List<TelephoneNumber> failedNumbers) {
      this.failedNumbers = failedNumbers;
    }
}
