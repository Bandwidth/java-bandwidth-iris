package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.*;
import com.bandwidth.iris.sdk.utils.XmlUtils;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LineOptionOrderTests extends BaseModelTests{
    @Test
    public void testCreate() throws Exception {
        String url = "/v1.0/accounts/accountId/lineOptionOrders";
        stubFor(post(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/xml")
                .withBody(IrisClientTestUtils.validLineOptionOrderResponseXml)));

        LineOptionOrder order = XmlUtils.fromXml(IrisClientTestUtils.validLineOptionOrderRequestXml, LineOptionOrder.class);

        LineOptionOrderResponse response = LineOptionOrder.create(getDefaultClient(), order);
        assert(response != null);
        assertEquals(response.getLineOptions().getCompletedNumbers().get(0), "2013223685");
        assertEquals(response.getLineOptions().getErrors().size(), 2);


    }

}
