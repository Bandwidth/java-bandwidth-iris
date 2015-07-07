package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.LnpChecker;
import com.bandwidth.iris.sdk.model.NumberPortabilityRequest;
import com.bandwidth.iris.sdk.model.NumberPortabilityResponse;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;

public class LnpCheckerTests extends BaseModelTests {
    @Test
    public void testLnpCheckNoErrors() throws Exception {
        String url = "/v1.0/accounts/accountId/lnpchecker.*";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/xml")
                        .withBody(IrisClientTestUtils.validNumberPortabilityResponseXml)));

        NumberPortabilityRequest request = new NumberPortabilityRequest();
        request.getTnList().add("9195551212");
        NumberPortabilityResponse response = LnpChecker.checkLnp(getDefaultClient(), request, "true");

        assertNotNull(response);
        assertEquals("9195551212", response.getPortableNumbers().get(0));
    }

    @Test
    public void testLnpCheckWithErrors() throws Exception {
        String url = "/v1.0/accounts/accountId/lnpchecker.*";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/xml")
                        .withBody(IrisClientTestUtils.validNumberPortabilityResponseXmlWithErrors)));

        NumberPortabilityRequest request = new NumberPortabilityRequest();
        request.getTnList().add("9195551212");
        NumberPortabilityResponse response = LnpChecker.checkLnp(getDefaultClient(), request, "true");

        assertNotNull(response);
        assertTrue(response.getErrors().size() > 0);
        assertEquals("7201", response.getErrors().get(0).getCode());
    }

}
