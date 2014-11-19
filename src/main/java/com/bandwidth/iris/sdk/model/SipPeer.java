package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisClientException;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.IrisResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 10/13/14.
 */
@XmlRootElement(name = "SipPeer")
@XmlAccessorType(XmlAccessType.FIELD)
public class SipPeer extends BaseModel {

    private static final Logger LOG = Logger.getLogger(SipPeer.class);

    public static SipPeer create(IrisClient client, String siteId, SipPeer sipPeer) throws Exception {
        IrisResponse response = client.post(client.buildModelUri(new String[] { IrisConstants.SITES_URI_PATH, siteId,
                IrisConstants.SIPPEERS_URI_PATH }), sipPeer);
        String id = client.getIdFromLocationHeader(response.getHeaders().get("Location"));
        return get(client, siteId, id);
    }

    public static SipPeer get(IrisClient client, String siteId, String sipPeerId) throws Exception {
        IrisResponse response = client.get(client.buildModelUri(new String[] { IrisConstants.SITES_URI_PATH, siteId,
                IrisConstants.SIPPEERS_URI_PATH, sipPeerId }));
        SipPeerResponse sipPeerResponse = XmlUtils.fromXml(response.getResponseBody(),
                SipPeerResponse.class);
        client.checkResponse(sipPeerResponse);
        SipPeer peer = sipPeerResponse.getSipPeer();
        peer.setSiteId(siteId);
        peer.setClient(client);
        return peer;
    }


    public static List<SipPeer> list(IrisClient client, String siteId) throws Exception {
        List<SipPeer> sipPeers = new ArrayList<SipPeer>();
        IrisResponse irisResponse = client.get(client.buildModelUri(new String[] { IrisConstants.SITES_URI_PATH, siteId,
                IrisConstants.SIPPEERS_URI_PATH }));
        TNSipPeersResponse tnSipPeersResponse = XmlUtils.fromXml(irisResponse.getResponseBody(), TNSipPeersResponse.class);
        client.checkResponse(tnSipPeersResponse);
        sipPeers = tnSipPeersResponse.getSipPeers();
        for (SipPeer peer : sipPeers) {
            peer.setClient(client);
        }
        return sipPeers;
    }


    private String siteId;

    @XmlElement(name="PeerId")
    private String peerId;

    @XmlElement(name="PeerName")
    private String peerName;

    @XmlElement(name="Description")
    private String description;

    @XmlElement(name="IsDefaultPeer")
    private boolean isDefaultPeer;

    @XmlElement(name="ShortMessagingProtocol")
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

    @XmlElement(name="CallingName")
    private CallingName callingName;

    @XmlElementWrapper(name="VoiceHostGroups")
    @XmlElement(name="VoiceHostGroup")
    private List<VoiceHostGroup> voiceHostGroups = new ArrayList<VoiceHostGroup>();

    @XmlElement(name="FinalDestinationUri")
    private String finalDestinationUri;

    public SipPeer(IrisClient client){
        this.client = client;
    }

    public SipPeer(){}

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getPeerId() {
        return peerId;
    }

    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    public String getPeerName() {
        return peerName;
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

    public void delete()throws Exception {
        client.delete(client.buildModelUri(new String[] { IrisConstants.SITES_URI_PATH, siteId,
                IrisConstants.SIPPEERS_URI_PATH, peerId }));
    }

    public void updateTn(SipPeerTelephoneNumber number) throws Exception {
        client.put(buildTnUri(number.getFullNumber()), number);
    }

    public SipPeerTelephoneNumber getTn(String number) throws Exception {
        IrisResponse response = client.get(buildTnUri(number));
        SipPeerTelephoneNumberResponse sipPeerTelephoneNumberResponse =
                XmlUtils.fromXml(response.getResponseBody(), SipPeerTelephoneNumberResponse.class);
        client.checkResponse(sipPeerTelephoneNumberResponse);
        return sipPeerTelephoneNumberResponse.getSipPeerTelephoneNumber();
    }

    public void moveTns(SipPeerTelephoneNumbers numbers) throws Exception {
        IrisResponse response = client.post(client.buildModelUri(new String[] { IrisConstants.SITES_URI_PATH, siteId,
                IrisConstants.SIPPEERS_URI_PATH, peerId, "movetns" }), numbers);
    }

    private String buildTnUri(String number) throws URISyntaxException{
        return client.buildModelUri(new String[]{IrisConstants.SITES_URI_PATH, siteId,
                IrisConstants.SIPPEERS_URI_PATH, peerId, "tns", number});
    }
}
