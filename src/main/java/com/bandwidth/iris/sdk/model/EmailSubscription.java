package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 11/19/14.
 */
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
