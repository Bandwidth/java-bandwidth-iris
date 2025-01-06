package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SipPeerSmsFeature")
@XmlAccessorType(XmlAccessType.FIELD)
public class SipPeerSmsFeature extends BaseModel {
    @XmlElement(name = "HttpSettings")
    HttpSettings httpSettings;
    @XmlElement(name = "SipPeerSmsFeatureSettings")
    SipPeerSmsFeatureSettings sipPeerSmsFeatureSettings;

    public SipPeerSmsFeature() {
        httpSettings = new HttpSettings();
        sipPeerSmsFeatureSettings = new SipPeerSmsFeatureSettings();
    }

    private static class HttpSettings{
        Integer proxyPeerId = null;
    }

    private static class SipPeerSmsFeatureSettings extends BaseModel {
        @XmlElement(name = "A2pLongCode")
        String a2pLongCode;
        @XmlElement(name = "A2pMessageClass")
        String a2pMessageClass;
        @XmlElement(name = "A2pCampaignId")
        String a2pCampaignId;
        @XmlElement(name = "Protocol")
        String protocol = "HTTP";
        @XmlElement(name = "TollFree")
        boolean tollFree = false;
        @XmlElement(name = "ShortCode")
        boolean shortCode = false;
        @XmlElement(name = "Zone1")
        boolean zone1 = true;
        @XmlElement(name = "Zone2")
        boolean zone2 = false;
        @XmlElement(name = "Zone3")
        boolean zone3 = false;
        @XmlElement(name = "Zone4")
        boolean zone4 = false;
        @XmlElement(name = "Zone5")
        boolean zone5 = false;

    }
    public String getA2pLongCode() {
        return this.sipPeerSmsFeatureSettings.a2pLongCode;
    }

    public void setA2pLongCode(String a2pLongCode) {
        this.sipPeerSmsFeatureSettings.a2pLongCode = a2pLongCode;
    }

    public String getA2pMessageClass() {
        return this.sipPeerSmsFeatureSettings.a2pMessageClass;
    }

    public void setA2pMessageClass(String a2pMessageClass) {
        this.sipPeerSmsFeatureSettings.a2pMessageClass = a2pMessageClass;
    }

    public String getA2pCampaignId() {
        return this.sipPeerSmsFeatureSettings.a2pCampaignId;
    }

    public void setA2pCampaignId(String a2pCampaignId) {
        this.sipPeerSmsFeatureSettings.a2pCampaignId = a2pCampaignId;
    }

    public String getProtocol() {
        return this.sipPeerSmsFeatureSettings.protocol;
    }

    public void setProtocol(String protocol) {
        this.sipPeerSmsFeatureSettings.protocol = protocol;
    }

    public boolean isTollFree() {
        return this.sipPeerSmsFeatureSettings.tollFree;
    }

    public void setTollFree(boolean tollFree) {
        this.sipPeerSmsFeatureSettings.tollFree = tollFree;
    }

    public boolean isShortCode() {
        return this.sipPeerSmsFeatureSettings.shortCode;
    }

    public void setShortCode(boolean shortCode) {
        this.sipPeerSmsFeatureSettings.shortCode = shortCode;
    }

    public boolean isZone1() {
        return this.sipPeerSmsFeatureSettings.zone1;
    }

    public void setZone1(boolean zone1) {
        this.sipPeerSmsFeatureSettings.zone1 = zone1;
    }

    public boolean isZone2() {
        return this.sipPeerSmsFeatureSettings.zone2;
    }

    public void setZone2(boolean zone2) {
        this.sipPeerSmsFeatureSettings.zone2 = zone2;
    }

    public boolean isZone3() {
        return this.sipPeerSmsFeatureSettings.zone3;
    }

    public void setZone3(boolean zone3) {
        this.sipPeerSmsFeatureSettings.zone3 = zone3;
    }

    public boolean isZone4() {
        return this.sipPeerSmsFeatureSettings.zone4;
    }

    public void setZone4(boolean zone4) {
        this.sipPeerSmsFeatureSettings.zone4 = zone4;
    }

    public boolean isZone5() {
        return this.sipPeerSmsFeatureSettings.zone5;
    }

    public void setZone5(boolean zone5) {
        this.sipPeerSmsFeatureSettings.zone5 = zone5;
    }

}
