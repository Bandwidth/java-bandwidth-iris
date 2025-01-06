package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SipPeerTelephoneNumberResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SipPeerTelephoneNumberResponse extends BaseResponse {
    @XmlElement(name = "SipPeerTelephoneNumber")
    private SipPeerTelephoneNumber sipPeerTelephoneNumber;

    public SipPeerTelephoneNumber getSipPeerTelephoneNumber() {
        return sipPeerTelephoneNumber;
    }

    public void setSipPeerTelephoneNumber(SipPeerTelephoneNumber sipPeerTelephoneNumber) {
        this.sipPeerTelephoneNumber = sipPeerTelephoneNumber;
    }
}
