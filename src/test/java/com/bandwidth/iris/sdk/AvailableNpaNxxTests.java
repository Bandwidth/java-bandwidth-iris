package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.AvailableNpaNxx;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by sbarstow on 11/17/14.
 */
public class AvailableNpaNxxTests extends BaseModelTests {
    @Test
    public void testSearchNpaNxx() throws Exception {
        String url = "/v1.0/accounts/accountId/availableNpaNxx.*";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.availableNpaNxxSearchResultXml)));

        Map<String, Object> query = new HashMap<String, Object>();
        query.put("areaCode", "919");


        List<AvailableNpaNxx> result = AvailableNpaNxx.list(getDefaultClient(), query);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("919", result.get(0).getNpa());
    }
}
