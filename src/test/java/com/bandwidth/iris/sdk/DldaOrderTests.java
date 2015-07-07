package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.DldaOrder;
import com.bandwidth.iris.sdk.model.DldaOrderResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.junit.Assert.assertEquals;

public class DldaOrderTests extends BaseModelTests {
    @Test
    public void testCreate() throws Exception {
        String url = "/v1.0/accounts/accountId/dldas";
        stubFor(post(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/xml")
                .withHeader("Location", "https://someUrl.com/accounts/accountId/dldas/1234")));

        String getUrl = "/v1.0/accounts/accountId/dldas/1234";
        stubFor(get(urlMatching(getUrl)).willReturn((aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/xml")
                .withBody(IrisClientTestUtils.validDldaOrderResponseXml))));

        DldaOrder order = XmlUtils.fromXml(IrisClientTestUtils.validDldaOrderRequestXml, DldaOrder.class);
        DldaOrder theOrder = DldaOrder.create(getDefaultClient(), order);
        assertEquals(theOrder.getDldaTnGroups().size(), 1);
        assertEquals(theOrder.getDldaTnGroups().get(0).getTelephoneNumberList().get(0), "5202217754");
        assertEquals(theOrder.getProcessingStatus(), "RECEIVED");
    }
}
