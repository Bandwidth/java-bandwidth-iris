package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "LnpOrderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class LnpOrderResponse extends LnpOrder {
    @XmlElement(name = "OrderId")
    private String orderId;

    @XmlElement(name = "ProcessingStatus")
    private String processingStatus;

    @XmlElement(name = "Status")
    private Status status;

    @XmlElement(name = "Errors")
    private List<Error> errors = new ArrayList<Error>();

    @XmlElement(name = "LosingCarrierName")
    private String losingCarrierName;

    @XmlElement(name = "LastModifiedDate")
    private Date lastModifiedDate;

    @XmlElement(name = "userId")
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

}


