package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.AvailableNumbers;
import com.bandwidth.iris.sdk.model.TelephoneNumber;
import com.bandwidth.iris.sdk.model.TelephoneNumberDetail;
import com.bandwidth.iris.sdk.model.TelephoneNumberSearchFilters;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sbarstow on 11/11/14.
 */
public class AvailableNumbersTests extends BaseModelTests {

    @Test
    public void testSearchNumbers() throws Exception {
        String queryUrl = "/v1.0/accounts/accountId/availableNumbers.*";

        stubFor(get(urlMatching(queryUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.localAreaSearchResultXml)));
        Map<String, Object> query = new HashMap<String, Object>();
        query.put("areaCode", "201");
        query.put("enableTNDetail", true);
        List<TelephoneNumberDetail> result = (List<TelephoneNumberDetail>)
                AvailableNumbers.search(getDefaultClient(), query);
        assertTrue(result != null);
        assertEquals(result.size(), 2);
    }

}
