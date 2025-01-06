package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "EmergencyNotificationRecipient")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyNotificationRecipient extends BaseModel {

    @XmlElement(name = "Description")
    private String description;

    @XmlElement(name = "Type")
    private String type;

    @XmlElement(name = "EmailAddress")
    private String emailAddress;

    @XmlElementWrapper(name = "Sms")
    @XmlElement(name = "TelephoneNumber")
    private List<String> smsTelephoneNumbers;

    @XmlElementWrapper(name = "Tts")
    @XmlElement(name = "TelephoneNumber")
    private List<String> ttsTelephoneNumbers;

    @XmlElement(name = "Callback")
    private EmergencyNotificationCallback callback;

    @XmlElement( name = "Identifier")
    private String identifer;

    @XmlElement( name = "CreatedDate")
    private String createdDate;

    @XmlElement( name = "LastModifiedDate")
    private String lastModifiedDate;

    @XmlElement( name = "ModifiedByUser")
    private String modifiedByUser;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<String> getSmsTelephoneNumbers() {
        return smsTelephoneNumbers;
    }

    public void setSmsTelephoneNumbers(List<String> smsTelephoneNumbers) {
        this.smsTelephoneNumbers = smsTelephoneNumbers;
    }

    public List<String> getTtsTelephoneNumbers() {
        return ttsTelephoneNumbers;
    }

    public void setTtsTelephoneNumbers(List<String> ttsTelephoneNumbers) {
        this.ttsTelephoneNumbers = ttsTelephoneNumbers;
    }

    public EmergencyNotificationCallback getCallback() {
        return callback;
    }

    public void setCallback(EmergencyNotificationCallback callback) {
        this.callback = callback;
    }

    public String getIdentifer() {
        return identifer;
    }

    public void setIdentifer(String identifer) {
        this.identifer = identifer;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getModifiedByUser() {
        return modifiedByUser;
    }

    public void setModifiedByUser(String modifiedByUser) {
        this.modifiedByUser = modifiedByUser;
    }
}
