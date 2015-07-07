package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.*;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class TnTests extends BaseModelTests {

    @Test
    public void testGetTnDetails() throws Exception {
        String url = "/v1.0/tns/9195551212/tndetails";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validTnDetailsResponseXml)));

        TelephoneNumberDetails details = Tns.getTnDetails(getDefaultClient(), "9195551212");
        assertNotNull(details);
        assertEquals("9195551212", details.getFullNumber());
    }

    @Test
    public void testList() throws Exception {
        String url = "/v1.0/tns";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validTnListResponseXml)));

        TelephoneNumbersResponse response = Tns.list(getDefaultClient(), null);
        assertNotNull(response);

    }

    @Test
    public void testGetTnRateCenter() throws Exception {
        String url = "/v1.0/tns/9195551212/ratecenter";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validTnRateCenterResponseXml)));

        TelephoneNumberDetails details = Tns.getRateCenter(getDefaultClient(), "9195551212");
        assertNotNull(details);
        assertEquals("MOUNTOLIVE", details.getRateCenter());
        assertEquals("NC", details.getState());
    }

    @Test
    public void testGetTnLata() throws Exception {
        String url = "/v1.0/tns/9195551212/lata";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validTnLataResponseXml)));

        TelephoneNumberDetails details = Tns.getLata(getDefaultClient(), "9195551212");
        assertNotNull(details);
        assertEquals("426", details.getLata());

    }

    @Test
    public void testGetTnSite() throws Exception {
        String url = "/v1.0/tns/9195551212/sites";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validTnSiteResponseXml)));

        Site site = Tns.getSite(getDefaultClient(), "9195551212");
        assertNotNull(site);
        assertEquals("Test Site", site.getName());
        assertEquals("2858", site.getId());
    }

    @Test
    public void testGetTnSipPeer() throws Exception {
        String url = "/v1.0/tns/9195551212/sippeers";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validTnSipPeerResponseXml)));

        SipPeer sipPeer = Tns.getSipPeer(getDefaultClient(), "9195551212");
        assertNotNull(sipPeer);
        assertEquals("SIP Peer 1", sipPeer.getPeerName());
        assertEquals("507567", sipPeer.getPeerId());
    }

}
