package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;
import com.bandwidth.iris.sdk.IrisResponse;

import jakarta.xml.bind.annotation.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "SipPeer")
@XmlAccessorType(XmlAccessType.FIELD)
public class SipPeer extends BaseModel {

    private String siteId;
    // Helper property for tns/sippeer
    @XmlElement(name = "Id")
    private String id;
    // Helper property for tns/sippeer
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "PeerId")
    private String peerId;
    @XmlElement(name = "PeerName")
    private String peerName;
    @XmlElement(name = "Description")
    private String description;
    @XmlElement(name = "IsDefaultPeer")
    private boolean isDefaultPeer;
    @XmlElement(name = "ShortMessagingProtocol")
    private String shortMessagingProtocol;
    @XmlElementWrapper(name = "VoiceHosts")
    @XmlElement(name = "Host")
    private List<Host> voiceHosts = new ArrayList<Host>();
    @XmlElementWrapper(name = "SmsHosts")
    @XmlElement(name = "Host")
    private List<Host> smsHosts = new ArrayList<Host>();
    @XmlElementWrapper(name = "TerminationHosts")
    @XmlElement(name = "TerminationHost")
    private List<Host> terminationHosts = new ArrayList<Host>();
    @XmlElement(name = "CallingName")
    private CallingName callingName;
    @XmlElementWrapper(name = "VoiceHostGroups")
    @XmlElement(name = "VoiceHostGroup")
    private List<VoiceHostGroup> voiceHostGroups = new ArrayList<VoiceHostGroup>();
    @XmlElement(name = "FinalDestinationUri")
    private String finalDestinationUri;

    public SipPeer(IrisClient client) {
        this.client = client;
    }

    public SipPeer() {
    }

    public static SipPeer create(IrisClient client, String siteId, SipPeer sipPeer) throws Exception {

        IrisResponse response = client.post(client.buildAccountModelUri(new String[] { IrisPath.SITES_URI_PATH, siteId,
                IrisPath.SIPPEERS_URI_PATH }), sipPeer);
        String id = client.getIdFromLocationHeader(response.getHeaders().get("Location"));
        return get(client, siteId, id);
    }

    public static SipPeer get(IrisClient client, String siteId, String sipPeerId) throws Exception {
        SipPeerResponse sipPeerResponse = client.get(client.buildAccountModelUri(new String[] { IrisPath.SITES_URI_PATH,
                siteId, IrisPath.SIPPEERS_URI_PATH, sipPeerId }), SipPeerResponse.class);
        SipPeer peer = sipPeerResponse.getSipPeer();
        peer.setSiteId(siteId);
        peer.setClient(client);
        return peer;
    }

    public static List<SipPeer> list(IrisClient client, String siteId) throws Exception {
        List<SipPeer> sipPeers = new ArrayList<SipPeer>();
        TNSipPeersResponse tnSipPeersResponse = client.get(client.buildAccountModelUri(
                new String[] { IrisPath.SITES_URI_PATH, siteId, IrisPath.SIPPEERS_URI_PATH }), TNSipPeersResponse.class);
        sipPeers = tnSipPeersResponse.getSipPeers();
        for (SipPeer peer : sipPeers) {
            peer.setClient(client);
        }
        return sipPeers;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getPeerId() {

        return peerId != null ? peerId : id;
    }

    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    public String getPeerName() {
        return peerName != null ? peerName : name;
    }

    public void setPeerName(String peerName) {
        this.peerName = peerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDefaultPeer() {
        return isDefaultPeer;
    }

    public void setDefaultPeer(boolean isDefaultPeer) {
        this.isDefaultPeer = isDefaultPeer;
    }

    public String getShortMessagingProtocol() {
        return shortMessagingProtocol;
    }

    public void setShortMessagingProtocol(String shortMessagingProtocol) {
        this.shortMessagingProtocol = shortMessagingProtocol;
    }

    public List<Host> getVoiceHosts() {
        return voiceHosts;
    }

    public void setVoiceHosts(List<Host> voiceHosts) {
        this.voiceHosts = voiceHosts;
    }

    public List<Host> getSmsHosts() {
        return smsHosts;
    }

    public void setSmsHosts(List<Host> smsHosts) {
        this.smsHosts = smsHosts;
    }

    public List<Host> getTerminationHosts() {
        return terminationHosts;
    }

    public void setTerminationHosts(List<Host> terminationHosts) {
        this.terminationHosts = terminationHosts;
    }

    public CallingName getCallingName() {
        return callingName;
    }

    public void setCallingName(CallingName callingName) {
        this.callingName = callingName;
    }

    public List<VoiceHostGroup> getVoiceHostGroups() {
        return voiceHostGroups;
    }

    public void setVoiceHostGroups(List<VoiceHostGroup> voiceHostGroups) {
        this.voiceHostGroups = voiceHostGroups;
    }

    public String getFinalDestinationUri() {
        return finalDestinationUri;
    }

    public void setFinalDestinationUri(String finalDestinationUri) {
        this.finalDestinationUri = finalDestinationUri;
    }

    public void delete() throws Exception {
        client.delete(client.buildAccountModelUri(new String[] { IrisPath.SITES_URI_PATH, siteId,
                IrisPath.SIPPEERS_URI_PATH, peerId }));
    }

    public void updateTn(SipPeerTelephoneNumber number) throws Exception {
        client.put(buildTnUri(number.getFullNumber()), number);
    }

    public SipPeerTelephoneNumber getTn(String number) throws Exception {
        return client.get(buildTnUri(number),
                SipPeerTelephoneNumberResponse.class).getSipPeerTelephoneNumber();
    }

    public void moveTns(SipPeerTelephoneNumbers numbers) throws Exception {
        IrisResponse response = client.post(client.buildAccountModelUri(new String[] { IrisPath.SITES_URI_PATH, siteId,
                IrisPath.SIPPEERS_URI_PATH, peerId, "movetns" }), numbers);
    }

    private String buildTnUri(String number) throws URISyntaxException {
        return client.buildAccountModelUri(new String[] { IrisPath.SITES_URI_PATH, siteId,
                IrisPath.SIPPEERS_URI_PATH, peerId, "tns", number });
    }

    public List<SipPeerTelephoneNumber> getTns() throws Exception {
        return client.get(client.buildAccountModelUri(new String[] { IrisPath.SITES_URI_PATH, siteId,
                        IrisPath.SIPPEERS_URI_PATH, peerId, "tns" }),
                SipPeerTelephoneNumbersResponse.class).getSipPeerTelephoneNumbers();
    }

    public void enableSms(SipPeerSmsFeature smsSettings) throws Exception {
        client.post(client.buildAccountModelUri(new String[] { IrisPath.SITES_URI_PATH, siteId,
                IrisPath.SIPPEERS_URI_PATH, peerId, "products", "messaging", "features", "sms" }), smsSettings);
    }

    public void enableMms() throws Exception {
        SipPeerMmsFeature mmsSettings = new SipPeerMmsFeature();
        client.post(client.buildAccountModelUri(new String[] { IrisPath.SITES_URI_PATH, siteId,
                IrisPath.SIPPEERS_URI_PATH, peerId, "products", "messaging", "features", "mms" }), mmsSettings);
    }

    public void updateMessagingApplicationSettings (SipPeerMessagingApplicationsSettings settings) throws Exception {
        client.post(client.buildAccountModelUri(new String[] { IrisPath.SITES_URI_PATH, siteId,
                IrisPath.SIPPEERS_URI_PATH, peerId, "products", "messaging","applicationSettings" }), settings);
    }
}
