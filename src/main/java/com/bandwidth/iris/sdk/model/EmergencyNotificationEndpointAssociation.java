package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "EmergencyNotificationEndpointAssociation")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyNotificationEndpointAssociation {

    @XmlElement(name = "OrderId")
    private String orderId;

    @XmlElement(name = "OrderCreatedDate")
    private String crderCreatedDate;

    @XmlElement(name = "ProcessingStatus")
    private String processingStatus;

    @XmlElement(name = "CustomerOrderId")
    private String customerOrderId;

    @XmlElementWrapper(name = "EmergencyNotificationGroup")
    @XmlElement(name = "Identifier")
    private List<String> emergencyNotificationGroupId;

    @XmlElementWrapper(name = "AddedAssociations")
    @XmlElement(name = "EepToEngAssociations")
    private List<EepToEngAssociations> addedEepToEngAssociations;

    @XmlElementWrapper(name = "DeletedAssociations")
    @XmlElement(name = "EepToEngAssociations")
    private List<EepToEngAssociations> deletedEepToEngAssociations;

    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getEmergencyNotificationGroupId() {
        return emergencyNotificationGroupId.get(0);
    }

    public void setEmergencyNotificationGroupId(String emergencyNotificationGroupId) {
        List list = new ArrayList<String>();
        list.add(emergencyNotificationGroupId);
        this.emergencyNotificationGroupId = list;
    }

    public List<EepToEngAssociations> getAddedEepToEngAssociations() {
        return addedEepToEngAssociations;
    }

    public void setAddedEepToEngAssociations(List<EepToEngAssociations> addedEepToEngAssociations) {
        this.addedEepToEngAssociations = addedEepToEngAssociations;
    }

    public List<EepToEngAssociations> getDeletedEepToEngAssociations() {
        return deletedEepToEngAssociations;
    }

    public void setDeletedEepToEngAssociations(List<EepToEngAssociations> deletedEepToEngAssociations) {
        this.deletedEepToEngAssociations = deletedEepToEngAssociations;
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
}
