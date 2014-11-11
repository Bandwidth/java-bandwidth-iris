package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.SipPeer;
import org.junit.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sbarstow on 11/11/14.
 */
public class SipPeerTests extends BaseModelTests {

    @Test
    public void testList() throws IrisClientException {
        String sitesUrl = "/v1.0/accounts/accountId/sites/1234/sippeers";
        stubFor(get(urlMatching(sitesUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSipPeersResponseXml)));

        List<SipPeer> result = SipPeer.list(getDefaultClient(), "1234");
        assertTrue(result != null);
        assertEquals(1, result.size());
        SipPeer s = result.get(0);
        assertEquals(s.getPeerName(), "SIP Peer 1");
        assertEquals(s.getPeerId(), "12345");
    }


}
