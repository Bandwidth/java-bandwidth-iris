package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "TNSipPeersResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class TNSipPeersResponse extends BaseResponse {
    @XmlElementWrapper(name = "SipPeers")
    @XmlElement(name = "SipPeer")
    private List<SipPeer> sipPeers = new ArrayList<SipPeer>();

    public List<SipPeer> getSipPeers() {
        return sipPeers;
    }

    public void setSipPeers(List<SipPeer> sipPeers) {
        this.sipPeers = sipPeers;
    }
}
