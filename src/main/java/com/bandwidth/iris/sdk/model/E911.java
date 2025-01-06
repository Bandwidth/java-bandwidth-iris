package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "E911")
@XmlAccessorType(XmlAccessType.FIELD)
public class E911 {

    @XmlElement(name = "LastE911OrderOutcome")
    private String lastE911OrderOutcome;

    @XmlElement(name = "SipPeerAddress")
    private String sipPeerAddress;

    @XmlElement(name = "CallerName")
    private String callerName;

    @XmlElement(name = "Address")
    private Address address;

    @XmlElement(name = "EmergencyNotificationGroup")
    private EmergencyNotificationGroup emergencyNotificationGroup;

    public String getLastE911OrderOutcome() {
        return lastE911OrderOutcome;
    }

    public void setLastE911OrderOutcome(String lastE911OrderOutcome) {
        this.lastE911OrderOutcome = lastE911OrderOutcome;
    }

    public String getSipPeerAddress() {
        return sipPeerAddress;
    }

    public void setSipPeerAddress(String sipPeerAddress) {
        this.sipPeerAddress = sipPeerAddress;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public EmergencyNotificationGroup getEmergencyNotificationGroup() {
        return emergencyNotificationGroup;
    }

    public void setEmergencyNotificationGroup(EmergencyNotificationGroup emergencyNotificationGroup) {
        this.emergencyNotificationGroup = emergencyNotificationGroup;
    }
}
