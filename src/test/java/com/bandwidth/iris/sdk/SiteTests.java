package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.Address;
import com.bandwidth.iris.sdk.model.Site;
import org.junit.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by sbarstow on 11/11/14.
 */
public class SiteTests extends BaseModelTests {

    @Test
    public void createNewSite() throws IrisClientException {
        String sitesUrl = "/v1.0/accounts/accountId/sites";
        stubFor(post(urlMatching(sitesUrl))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/xml")
                        .withHeader("Location", "https://someUrl.com/accounts/accountId/sites/1234")));

        Site s = new Site();
        s.setName("A Test Site");
        s.setDescription("A Test Site Description");
        Address a = new Address();
        a.setHouseNumber("123");
        a.setStreetName("EZ Street");
        a.setCity("Raleigh");
        a.setZip("27601");
        a.setState("NC");
        a.setCountry("US");
        s.setAddress(a);
        String siteId = Site.create(getDefaultClient(),s);
        assertNotNull(siteId);
        assertEquals("1234", siteId);
    }

    @Test(expected=IrisClientException.class)
    public void testInvalidSiteDelete() throws IrisClientException {
        String sitesUrl = "/v1.0/accounts/accountId/sites/5001";
        stubFor(delete(urlMatching(sitesUrl))
                .willReturn(aResponse()
                        .withStatus(404)
                        .withBody(IrisClientTestUtils.invalidSiteDeleteResponseXml)));

        Site.delete(getDefaultClient(), "5001");
        expectedEx.expect(IrisClientException.class);
        expectedEx.expectMessage(IrisClientTestUtils.invalidSiteDeleteResponseXml);
    }

    @Test
    public void testValidSiteResponse() throws IrisClientException {
        String sitesUrl = "/v1.0/accounts/accountId/sites/2858";
        stubFor(get(urlMatching(sitesUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSiteResponseXml)));

        Site result = Site.get(getDefaultClient(), "2858");
        assertTrue(result != null);
        assertEquals(result.getName(), "Test Site");
        assertEquals(result.getAddress().getAddressType(), "Service");
    }

    @Test
    public void testValidSitesResponse() throws IrisClientException {
        String sitesUrl = "/v1.0/accounts/accountId/sites";
        stubFor(get(urlMatching(sitesUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSitesResponseXml)));

        List<Site> result = Site.list(getDefaultClient());
        assertTrue(result != null);
        assertEquals(1, result.size());
        Site s = result.get(0);
        assertEquals(s.getName(), "Test Site");
    }




}
