package com.bandwidth.iris.sdk.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CallbackSubscription")
@XmlAccessorType(XmlAccessType.FIELD)
public class CallbackSubscription {

    @XmlElement(name = "URL")
    private String URL;
    @XmlElement(name = "User")
    private String user;
    @XmlElement(name = "Expiry")
    private String expiry;
    @XmlElement(name = "CallbackCredentials")
    private CallbackCredentials callbackCredentials;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public CallbackCredentials getCallbackCredentials() {
        return callbackCredentials;
    }

    public void setCallbackCredentials(CallbackCredentials callbackCredentials) {
        this.callbackCredentials = callbackCredentials;
    }
}
