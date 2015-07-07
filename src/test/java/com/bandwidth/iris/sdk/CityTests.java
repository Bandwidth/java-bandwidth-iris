package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.City;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class CityTests extends BaseModelTests {

    @Test
    public void testList() throws Exception {
        String url = "/v1.0/cities.*";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validCitiesReponseXml)));

        Map<String, Object> query = new HashMap<String, Object>();
        query.put("state", "NC");
        List<City> cities = City.list(getDefaultClient(), query);
        assertNotNull(cities);
        assertEquals(2, cities.size());
    }
}
