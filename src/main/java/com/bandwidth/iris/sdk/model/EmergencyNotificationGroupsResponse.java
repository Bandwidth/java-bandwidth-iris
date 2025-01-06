package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "EmergencyNotificationGroupsResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyNotificationGroupsResponse {

    @XmlElementWrapper(name = "EmergencyNotificationGroups")
    @XmlElement(name = "EmergencyNotificationGroup")
    private List<EmergencyNotificationGroup> emergencyNotificationGroups;

    @XmlElement(name = "EmergencyNotificationGroup")
    private EmergencyNotificationGroup emergencyNotificationGroup;

    @XmlElement(name = "Links")
    private Links links;

    public List<EmergencyNotificationGroup> getEmergencyNotificationGroups() {
        return emergencyNotificationGroups;
    }

    public void setEmergencyNotificationGroups(List<EmergencyNotificationGroup> emergencyNotificationGroups) {
        this.emergencyNotificationGroups = emergencyNotificationGroups;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public EmergencyNotificationGroup getEmergencyNotificationGroup() {
        return emergencyNotificationGroup;
    }

    public void setEmergencyNotificationGroup(EmergencyNotificationGroup emergencyNotificationGroup) {
        this.emergencyNotificationGroup = emergencyNotificationGroup;
    }
}
