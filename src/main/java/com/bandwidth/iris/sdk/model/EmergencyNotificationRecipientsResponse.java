package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "EmergencyNotificationRecipientsResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyNotificationRecipientsResponse {

    @XmlElement(name = "EmergencyNotificationRecipient")
    private EmergencyNotificationRecipient emergencyNotificationRecipient;

    @XmlElement(name = "Links")
    private Links links;

    @XmlElementWrapper(name = "EmergencyNotificationRecipients")
    @XmlElement(name = "EmergencyNotificationRecipient")
    private List<EmergencyNotificationRecipient> emergencyNotificationRecipients;

    public EmergencyNotificationRecipient getEmergencyNotificationRecipient() {
        return emergencyNotificationRecipient;
    }

    public void setEmergencyNotificationRecipient(EmergencyNotificationRecipient emergencyNotificationRecipient) {
        this.emergencyNotificationRecipient = emergencyNotificationRecipient;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<EmergencyNotificationRecipient> getEmergencyNotificationRecipients() {
        return emergencyNotificationRecipients;
    }

    public void setEmergencyNotificationRecipients(List<EmergencyNotificationRecipient> emergencyNotificationRecipients) {
        this.emergencyNotificationRecipients = emergencyNotificationRecipients;
    }
}
