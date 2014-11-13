package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 11/13/14.
 */
@XmlRootElement(name = "SipPeerResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SipPeerResponse extends BaseResponse {

    @XmlElement(name="SipPeer")
    private SipPeer sipPeer;

    public SipPeer getSipPeer() {
        return sipPeer;
    }

    public void setSipPeer(SipPeer sipPeer) {
        this.sipPeer = sipPeer;
    }
}
