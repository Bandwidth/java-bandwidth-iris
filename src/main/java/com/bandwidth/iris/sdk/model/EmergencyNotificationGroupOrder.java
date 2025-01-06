package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "EmergencyNotificationRecipientsResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyNotificationGroupOrder extends BaseModel {

    @XmlElement(name = "CustomerOrderId")
    private String customerOrderId;

    @XmlElement(name = "AddedEmergencyNotificationGroup")
    private AddedEmergencyNotificationGroup addedEmergencyNotificationGroup;

    @XmlElement(name = "DeletedEmergencyNotificationGroup")
    private DeletedEmergencyNotificationGroup deletedEmergencyNotificationGroup;

    @XmlElement(name = "ModifiedEmergencyNotificationGroup")
    private ModifiedEmergencyNotificationGroup modifiedEmergencyNotificationGroup;

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

    public ModifiedEmergencyNotificationGroup getModifiedEmergencyNotificationGroup() {
        return modifiedEmergencyNotificationGroup;
    }

    public void setModifiedEmergencyNotificationGroup(ModifiedEmergencyNotificationGroup modifiedEmergencyNotificationGroup) {
        this.modifiedEmergencyNotificationGroup = modifiedEmergencyNotificationGroup;
    }
}
