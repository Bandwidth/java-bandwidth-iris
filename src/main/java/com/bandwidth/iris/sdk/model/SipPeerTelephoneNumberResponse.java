package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 11/13/14.
 */
@XmlRootElement(name="SipPeerTelephoneNumberResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SipPeerTelephoneNumberResponse extends BaseResponse {
    @XmlElement(name="SipPeerTelephoneNumber")
    private SipPeerTelephoneNumber sipPeerTelephoneNumber;

    public SipPeerTelephoneNumber getSipPeerTelephoneNumber() {
        return sipPeerTelephoneNumber;
    }

    public void setSipPeerTelephoneNumber(SipPeerTelephoneNumber sipPeerTelephoneNumber) {
        this.sipPeerTelephoneNumber = sipPeerTelephoneNumber;
    }
}
