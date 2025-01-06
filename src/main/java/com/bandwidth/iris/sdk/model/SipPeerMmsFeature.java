package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MmsFeature")
@XmlAccessorType(XmlAccessType.FIELD)
public class SipPeerMmsFeature extends BaseModel {
    @XmlElement(name = "MmsSettings")
    MmsSettings mmsSettings;
    @XmlElement(name = "Protocols")
    Protocols protocols;

    public SipPeerMmsFeature()
    {
        this.mmsSettings = new MmsSettings();
        this.protocols = new Protocols();
        this.protocols.http = new Http();
        this.protocols.http.httpSettings = new HttpSettings();
    }

    private static class MmsSettings extends BaseModel {
        @XmlElement(name = "Protocol")
        private final String protocol = "HTTP";
    }

    private static class Protocols extends BaseModel {
        @XmlElement(name = "HTTP")
        Http http;
    }

    private static class Http extends BaseModel {
        @XmlElement(name = "HttpSettings")
        HttpSettings httpSettings = new HttpSettings();
    }

    private static class HttpSettings extends BaseModel {
        @XmlElement(name = "ProxyPeerId")
        String proxyPeerId = "";
    }
}
