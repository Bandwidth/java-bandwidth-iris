package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UpdatedEmergencyNotificationGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdatedEmergencyNotificationGroup {

    @XmlElement(name = "Identifier")
    private String identifier;

    @XmlElement(name = "Description")
    private String description;

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
}
