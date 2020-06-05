package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.*;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;

public class AeuiTests extends BaseModelTests {


    @Test
    public void TestGet() throws Exception {
        String acid = "123";
        String url = "/v1.0/accounts/accountId/aeuis/" + acid;
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.getAeuis)));

        AlternateEndUserIdentifierResponse response = Aeui.get(getDefaultClient(), acid);

        assertNotNull(response);
        assertEquals("DavidAcid", response.getAlternateEndUserIdentifier().getIdentifier());
        assertEquals("8042105760", response.getAlternateEndUserIdentifier().getCllbackNumber());
        assertEquals("David", response.getAlternateEndUserIdentifier().getE911().getCallerName());
        assertNotNull( response.getAlternateEndUserIdentifier().getE911().getAddress());
        assertNotNull(response.getAlternateEndUserIdentifier().getE911().getEmergencyNotificationGroup());




    }

    @Test
    public void TestList() throws Exception {

        String url = "/v1.0/accounts/accountId/aeuis";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.listAeuis)));

        AlternateEndUserIdentifiersResponse response = Aeui.list(getDefaultClient(), null);

        assertNotNull(response);
        assertEquals(2, response.getTotalCount());
        assertNotNull(response.getLinks());
        assertEquals(2, response.getAlternateEndUserIdentifiers().size());

    }
}
