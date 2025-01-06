package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "EmergencyNotificationGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyNotificationGroup {

    @XmlElement(name = "Identifier")
    private String identifier;

    @XmlElement(name = "Description")
    private String description;

    @XmlElement(name = "CreatedDate")
    private String createdDate;

    @XmlElement(name = "ModifiedBy")
    private String modifiedBy;

    @XmlElement(name = "ModifiedDate")
    private String modifiedDate;

    @XmlElementWrapper(name = "EmergencyNotificationRecipients")
    @XmlElement(name = "EmergencyNotificationRecipient")
    private List<EmergencyNotificationRecipient> emergencyNotificationRecipients;

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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<EmergencyNotificationRecipient> getEmergencyNotificationRecipients() {
        return emergencyNotificationRecipients;
    }

    public void setEmergencyNotificationRecipients(List<EmergencyNotificationRecipient> emergencyNotificationRecipients) {
        this.emergencyNotificationRecipients = emergencyNotificationRecipients;
    }
}
