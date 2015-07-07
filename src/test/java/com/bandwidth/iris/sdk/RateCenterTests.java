package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.RateCenter;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class RateCenterTests extends BaseModelTests {

    @Test
    public void testList() throws Exception {
        String url = "/v1.0/rateCenters.*";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validRateCentersResponseXml)));

        Map<String, Object> query = new HashMap<String, Object>();
        query.put("state", "NC");
        List<RateCenter> rateCenters = RateCenter.list(getDefaultClient(), query);
        assertNotNull(rateCenters);
        assertEquals(2, rateCenters.size());
    }
}
