package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "EmergencyNotificationGroupOrderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyNotificationGroupOrderResponse {

    @XmlElement(name = "Links")
    private Links links;

    @XmlElement(name = "OrderId")
    private String orderId;

    @XmlElement(name = "CreatedBy")
    private String createdBy;

    @XmlElement(name = "OrderCreatedDate")
    private String orderCreatedDate;

    @XmlElement(name = "ProcessingStatus")
    private String processingStatus;

    @XmlElement(name = "CustomerOrderId")
    private String customerOrderId;

    @XmlElement(name = "AddedEmergencyNotificationGroup")
    private AddedEmergencyNotificationGroup addedEmergencyNotificationGroup;

    @XmlElement(name = "DeletedEmergencyNotificationGroup")
    private DeletedEmergencyNotificationGroup deletedEmergencyNotificationGroup;

    @XmlElement(name = "UpdatedEmergencyNotificationGroup")
    private UpdatedEmergencyNotificationGroup updatedEmergencyNotificationGroup;

    @XmlElement(name = "ModifiedEmergencyNotificationGroup")
    private ModifiedEmergencyNotificationGroup modifiedEmergencyNotificationGroup;

    @XmlElementWrapper(name = "EmergencyNotificationGroupOrders" )
    @XmlElement(name = "EmergencyNotificationGroupOrder" )
    private List<EmergencyNotificationGroupOrder> emergencyNotificationGroupOrders;

    public List<EmergencyNotificationGroupOrder> getEmergencyNotificationGroupOrders() {
        return emergencyNotificationGroupOrders;
    }

    public void setEmergencyNotificationGroupOrders(List<EmergencyNotificationGroupOrder> emergencyNotificationGroupOrders) {
        this.emergencyNotificationGroupOrders = emergencyNotificationGroupOrders;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCreatedDate() {
        return orderCreatedDate;
    }

    public void setOrderCreatedDate(String orderCreatedDate) {
        this.orderCreatedDate = orderCreatedDate;
    }

    public String getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }

    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public AddedEmergencyNotificationGroup getAddedEmergencyNotificationGroup() {
        return addedEmergencyNotificationGroup;
    }

    public void setAddedEmergencyNotificationGroup(AddedEmergencyNotificationGroup addedEmergencyNotificationGroup) {
        this.addedEmergencyNotificationGroup = addedEmergencyNotificationGroup;
    }

    public DeletedEmergencyNotificationGroup getDeletedEmergencyNotificationGroup() {
        return deletedEmergencyNotificationGroup;
    }

    public void setDeletedEmergencyNotificationGroup(DeletedEmergencyNotificationGroup deletedEmergencyNotificationGroup) {
        this.deletedEmergencyNotificationGroup = deletedEmergencyNotificationGroup;
    }

    public UpdatedEmergencyNotificationGroup getUpdatedEmergencyNotificationGroup() {
        return updatedEmergencyNotificationGroup;
    }

    public void setUpdatedEmergencyNotificationGroup(UpdatedEmergencyNotificationGroup updatedEmergencyNotificationGroup) {
        this.updatedEmergencyNotificationGroup = updatedEmergencyNotificationGroup;
    }

    public ModifiedEmergencyNotificationGroup getModifiedEmergencyNotificationGroup() {
        return modifiedEmergencyNotificationGroup;
    }

    public void setModifiedEmergencyNotificationGroup(ModifiedEmergencyNotificationGroup modifiedEmergencyNotificationGroup) {
        this.modifiedEmergencyNotificationGroup = modifiedEmergencyNotificationGroup;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
