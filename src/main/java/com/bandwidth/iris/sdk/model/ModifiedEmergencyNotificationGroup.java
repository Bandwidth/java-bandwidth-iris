package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "ModifiedEmergencyNotificationGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class ModifiedEmergencyNotificationGroup {

    @XmlElement(name = "Identifier")
    private String identifier;

    @XmlElement(name = "Description")
    private String description;

    @XmlElementWrapper(name = "AddedEmergencyNotificationRecipients")
    @XmlElement(name = "EmergencyNotificationRecipient")
    private List<EmergencyNotificationRecipient> addedEmergencyNotificationRecipients;

    @XmlElementWrapper(name = "DeletedEmergencyNotificationRecipients")
    @XmlElement(name = "EmergencyNotificationRecipient")
    private List<EmergencyNotificationRecipient> deletedEmergencyNotificationRecipients;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EmergencyNotificationRecipient> getAddedEmergencyNotificationRecipients() {
        return addedEmergencyNotificationRecipients;
    }

    public void setAddedEmergencyNotificationRecipients(List<EmergencyNotificationRecipient> addedEmergencyNotificationRecipients) {
        this.addedEmergencyNotificationRecipients = addedEmergencyNotificationRecipients;
    }

    public List<EmergencyNotificationRecipient> getDeletedEmergencyNotificationRecipients() {
        return deletedEmergencyNotificationRecipients;
    }

    public void setDeletedEmergencyNotificationRecipients(List<EmergencyNotificationRecipient> deletedEmergencyNotificationRecipients) {
        this.deletedEmergencyNotificationRecipients = deletedEmergencyNotificationRecipients;
    }
}
