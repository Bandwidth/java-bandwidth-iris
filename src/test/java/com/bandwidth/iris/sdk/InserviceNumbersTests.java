package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.InserviceNumber;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by sbarstow on 6/18/15.
 */
public class InserviceNumbersTests extends BaseModelTests {
    @Test
    public void testList() throws Exception {
        String url = "/v1.0/accounts/accountId/inserviceNumbers.*";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validInserviceTnsResponseXml)));

        Map<String, Object> query = new HashMap<String, Object>();
        query.put("state", "NC");

        TNs tns = InserviceNumber.list(getDefaultClient(), query);
        assertEquals(tns.getTelephoneNumbers().size(), 1);

    }
}
