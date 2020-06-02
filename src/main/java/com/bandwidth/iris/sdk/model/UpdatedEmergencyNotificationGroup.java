package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
