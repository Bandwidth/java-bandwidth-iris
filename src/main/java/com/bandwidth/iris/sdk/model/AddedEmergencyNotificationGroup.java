package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "AddedEmergencyNotificationGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddedEmergencyNotificationGroup {

    @XmlElement(name = "Description")
    private String description;

    @XmlElement(name = "Identifier")
    private String identifier;

    @XmlElementWrapper(name = "AddedEmergencyNotificationRecipients")
    @XmlElement(name = "EmergencyNotificationRecipient")
    private List<EmergencyNotificationRecipient> addedEmergencyNotificationRecipients;

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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
