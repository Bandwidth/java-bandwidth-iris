package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Warning")
@XmlAccessorType(XmlAccessType.FIELD)
public class Warning extends BaseModel {

    @XmlElement(name = "TelephoneNumber")
    private String telephoneNumber;

    @XmlElement(name = "Description")
    private String description;

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
