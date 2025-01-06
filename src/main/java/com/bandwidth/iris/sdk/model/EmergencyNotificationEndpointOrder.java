package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "EmergencyNotificationEndpointOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyNotificationEndpointOrder extends BaseModel {

    @XmlElement(name = "OrderId")
    private String orderId;

    @XmlElement(name = "OrderCreatedDate")
    private String crderCreatedDate;

    @XmlElement(name = "CreatedBy")
    private String CreatedBy;

    @XmlElement(name = "ProcessingStatus")
    private String processingStatus;

    @XmlElement(name = "CustomerOrderId")
    private String customerOrderId;

    @XmlElement(name = "EmergencyNotificationEndpointAssociations")
    private EmergencyNotificationEndpointAssociation emergencyNotificationEndpointAssociations;

    @XmlElement(name = "EmergencyNotificationEndpointAssociation")
    private EmergencyNotificationEndpointAssociation emergencyNotificationEndpointAssociation;

    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public EmergencyNotificationEndpointAssociation getEmergencyNotificationEndpointAssociations() {
        return emergencyNotificationEndpointAssociations;
    }

    public void setEmergencyNotificationEndpointAssociations(EmergencyNotificationEndpointAssociation emergencyNotificationEndpointAssociations) {
        this.emergencyNotificationEndpointAssociations = emergencyNotificationEndpointAssociations;
    }

    public EmergencyNotificationEndpointAssociation getEmergencyNotificationEndpointAssociation() {
        return emergencyNotificationEndpointAssociation;
    }

    public void setEmergencyNotificationEndpointAssociation(EmergencyNotificationEndpointAssociation emergencyNotificationEndpointAssociation) {
        this.emergencyNotificationEndpointAssociation = emergencyNotificationEndpointAssociation;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCrderCreatedDate() {
        return crderCreatedDate;
    }

    public void setCrderCreatedDate(String crderCreatedDate) {
        this.crderCreatedDate = crderCreatedDate;
    }

    public String getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }
}
