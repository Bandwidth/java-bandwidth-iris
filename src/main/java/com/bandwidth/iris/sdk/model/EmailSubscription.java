package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "EmailSubscription")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmailSubscription {
    @XmlElement(name = "Email")
    private String email;

    @XmlElement(name = "DigestRequested")
    private String digestRequested;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDigestRequested() {
        return digestRequested;
    }

    public void setDigestRequested(String digestRequested) {
        this.digestRequested = digestRequested;
    }
}
