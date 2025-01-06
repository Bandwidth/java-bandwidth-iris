package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SipPeerResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SipPeerResponse extends BaseResponse {

    @XmlElement(name = "SipPeer")
    private SipPeer sipPeer;

    public SipPeer getSipPeer() {
        return sipPeer;
    }

    public void setSipPeer(SipPeer sipPeer) {
        this.sipPeer = sipPeer;
    }
}
