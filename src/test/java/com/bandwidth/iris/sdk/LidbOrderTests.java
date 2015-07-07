package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.LidbOrder;
import com.bandwidth.iris.sdk.model.LidbOrderResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

public class LidbOrderTests extends BaseModelTests {
    @Test
    public void testCreate() throws Exception {
        String url = "/v1.0/accounts/accountId/lidbs";
        stubFor(post(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/xml")
                .withHeader("Location", "https://someUrl.com/accounts/accountId/lidbs/1234")
                .withBody(IrisClientTestUtils.validLidbOrderResponseXml)));

        String getUrl = "/v1.0/accounts/accountId/lidbs/1234";
        stubFor(get(urlMatching(getUrl)).willReturn((aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/xml")
                .withBody(IrisClientTestUtils.validLidbOrderResponseXml))));

        LidbOrder order = XmlUtils.fromXml(IrisClientTestUtils.validLidbOrderRequestXml, LidbOrder.class);
        LidbOrder theOrder = LidbOrder.create(getDefaultClient(), order);
        assertEquals(theOrder.getLidbTnGroupList().size(), 2);
        assertEquals(theOrder.getProcessingStatus(), "RECEIVED");
        assertEquals(theOrder.getAccountId(), "12346099");
        assertEquals(theOrder.getErrors().size(), 0);
    }
}
