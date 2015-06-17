package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.BaseModel;
import com.bandwidth.iris.sdk.model.CoveredRateCenter;
import com.bandwidth.iris.sdk.model.RateCenter;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by sbarstow on 6/17/15.
 */
public class CoveredRateCenterTests extends BaseModelTests{

    @Test
    public void testList() throws Exception {
        String url = "/v1.0/coveredRateCenters.*";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validCoveredRateCentersResponseXml)));

        Map<String, Object> query = new HashMap<String, Object>();
        query.put("state", "NC");
        List<CoveredRateCenter> rateCenters = CoveredRateCenter.list(getDefaultClient(), query);
        assertNotNull(rateCenters);
        assertEquals(2, rateCenters.size());
    }
}
