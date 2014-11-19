package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.SipPeer;
import com.bandwidth.iris.sdk.model.SipPeerTelephoneNumber;
import com.bandwidth.iris.sdk.model.SipPeerTelephoneNumbers;
import org.junit.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by sbarstow on 11/11/14.
 */
public class SipPeerTests extends BaseModelTests {

    @Test
    public void testList() throws Exception {
        String url = "/v1.0/accounts/accountId/sites/1234/sippeers";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSipPeersResponseXml)));

        List<SipPeer> result = SipPeer.list(getDefaultClient(), "1234");
        assertNotNull(result != null);
        assertEquals(1, result.size());
        SipPeer s = result.get(0);
        assertEquals(s.getPeerName(), "SIP Peer 1");
        assertEquals(s.getPeerId(), "12345");
    }

    @Test
    public void testGet() throws Exception{
        String url = "/v1.0/accounts/accountId/sites/1234/sippeers/5678";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSipPeerResponseXml)));

        SipPeer result = SipPeer.get(getDefaultClient(),"1234","5678");
        assertNotNull(result != null);
        assertEquals("5678", result.getPeerId());
        assertEquals("SIP Peer 1", result.getPeerName());

    }

    @Test(expected=IrisClientException.class)
    public void testGetWithInvalidId() throws Exception {
        String url = "/v1.0/accounts/accountId/sites/1234/sippeers/5555";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.invalidIdSipPeerResponseXml)));
        SipPeer result = SipPeer.get(getDefaultClient(), "1234", "5555");
        expectedEx.expect(IrisClientException.class);
        expectedEx.expectMessage("Sip Peer '5555' account 'accountId' and site '1234' does not exist");
    }

    @Test
    public void testCreate() throws Exception {
        String url = "/v1.0/accounts/accountId/sites/1234/sippeers";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/xml")
                        .withHeader("Location", "5678")));

        String getUrl = "/v1.0/accounts/accountId/sites/1234/sippeers/5678";
        stubFor(get(urlMatching(getUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSipPeerResponseXml)));


        SipPeer sipPeer = new SipPeer();
        sipPeer.setPeerName("A Test Peer");
        sipPeer.setDescription("Description");

        SipPeer createdPeer  = SipPeer.create(getDefaultClient(), "1234", sipPeer);
        assertEquals("5678", createdPeer.getPeerId());
        assertEquals("1234", createdPeer.getSiteId());
    }

    @Test
    public void testDelete() throws Exception {
        String getUrl = "/v1.0/accounts/accountId/sites/1234/sippeers/5678";
        stubFor(get(urlMatching(getUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSipPeerResponseXml)));

        String deleteUrl = "/v1.0/accounts/accountId/sites/1234/sippeers/5678";
        stubFor(delete(urlMatching(deleteUrl))
                .willReturn(aResponse()
                        .withStatus(200)));

        SipPeer peer = SipPeer.get(getDefaultClient(), "1234", "5678");
        peer.delete();
    }

    @Test
    public void testGetTn() throws Exception {
        String sipPeerUrl =  "/v1.0/accounts/accountId/sites/1234/sippeers/5678";
        stubFor(get(urlMatching(sipPeerUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSipPeerResponseXml)));

        String sipPeerTnUrl = "/v1.0/accounts/accountId/sites/1234/sippeers/5678/tns/9195551212";
        stubFor(get(urlMatching(sipPeerTnUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSipPeerTnResponseXml)));


        SipPeer peer = SipPeer.get(getDefaultClient(), "1234", "5678");
        SipPeerTelephoneNumber number = peer.getTn("9195551212");
        assertNotNull(number);
        assertEquals(number.getFullNumber(), "9195551212");
    }

    @Test(expected=IrisClientException.class)
    public void testGetInvalidTn() throws Exception {
        String sipPeerUrl =  "/v1.0/accounts/accountId/sites/1234/sippeers/5678";
        stubFor(get(urlMatching(sipPeerUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSipPeerResponseXml)));

        String sipPeerTnUrl = "/v1.0/accounts/accountId/sites/1234/sippeers/5678/tns/9195551213";
        stubFor(get(urlMatching(sipPeerTnUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.invalidSipPeerTnResponseXml)));


        SipPeer peer = SipPeer.get(getDefaultClient(), "1234", "5678");
        SipPeerTelephoneNumber number = peer.getTn("9195551213");
        assertNull(number);
        expectedEx.expect(IrisClientException.class);
        expectedEx.expectMessage("Telephone number 9195551213 does not exist on Account accountId, Site 1234, and Sip Peer 5678");

    }

    @Test
    public void testUpdateTn() throws Exception {
        String sipPeerUrl =  "/v1.0/accounts/accountId/sites/1234/sippeers/5678";
        stubFor(get(urlMatching(sipPeerUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSipPeerResponseXml)));

        String sipPeerTnUrl = "/v1.0/accounts/accountId/sites/1234/sippeers/5678/tns/9195551212";
        stubFor(put(urlMatching(sipPeerTnUrl))
                .willReturn(aResponse()
                        .withStatus(200)));

        SipPeer peer = SipPeer.get(getDefaultClient(), "1234", "5678");
        SipPeerTelephoneNumber number = new SipPeerTelephoneNumber();
        number.setFullNumber("9195551212");
        number.setCallForward("9195551213");
        peer.updateTn(number);
    }

    @Test
    public void testMoveTns() throws Exception {
        String sipPeerUrl =  "/v1.0/accounts/accountId/sites/1234/sippeers/5678";
        stubFor(get(urlMatching(sipPeerUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSipPeerResponseXml)));
        SipPeer peer = SipPeer.get(getDefaultClient(), "1234", "5678");

        SipPeerTelephoneNumbers numbers = new SipPeerTelephoneNumbers();
        numbers.getFullNumbers().add("9195551212");

        String moveUrl = sipPeerUrl + "/movetns";
        stubFor(post(urlMatching(moveUrl))
                .willReturn(aResponse()
                        .withStatus(200)));

        peer.moveTns(numbers);
    }
}
