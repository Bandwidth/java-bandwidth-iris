package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 11/19/14.
 */
@XmlRootElement(name = "SipPeerTelephoneNumbersResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SipPeerTelephoneNumbersResponse extends BaseResponse {
    @XmlElementWrapper(name = "SipPeerTelephoneNumbers")
    @XmlElement(name = "SipPeerTelephoneNumber")
    private List<SipPeerTelephoneNumber> sipPeerTelephoneNumbers = new ArrayList<SipPeerTelephoneNumber>();

    public List<SipPeerTelephoneNumber> getSipPeerTelephoneNumbers() {
        return sipPeerTelephoneNumbers;
    }

    public void setSipPeerTelephoneNumbers(List<SipPeerTelephoneNumber> sipPeerTelephoneNumbers) {
        this.sipPeerTelephoneNumbers = sipPeerTelephoneNumbers;
    }
}
