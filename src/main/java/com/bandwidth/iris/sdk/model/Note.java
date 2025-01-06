package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "Note")
@XmlAccessorType(XmlAccessType.FIELD)
public class Note extends BaseModel {
    @XmlElement(name = "UserId")
    private String userId;

    @XmlElement(name = "Id")
    private String id;

    @XmlElement(name = "Description")
    private String description;

    @XmlElement(name = "LastDateModifier")
    private Date lastDateModifier;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastDateModifier() {
        return lastDateModifier;
    }

    public void setLastDateModifier(Date lastDateModifier) {
        this.lastDateModifier = lastDateModifier;
    }
}
