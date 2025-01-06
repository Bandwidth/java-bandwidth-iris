package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.Address;
import com.bandwidth.iris.sdk.model.Site;
import org.junit.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;

public class SiteTests extends BaseModelTests {

    @Test
    public void createNewSite() throws Exception {
        String sitesUrl = "/v1.0/accounts/accountId/sites";
        stubFor(post(urlMatching(sitesUrl))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/xml")
                        .withHeader("Location", "https://someUrl.com/accounts/accountId/sites/2858")));

        String sitesGetUrl = "/v1.0/accounts/accountId/sites/2858";

        stubFor(get(urlMatching(sitesGetUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSiteResponseXml)));

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
        Site createdSite = Site.create(getDefaultClient(), s);
        assertNotNull(createdSite);
        assertEquals("2858", createdSite.getId());
    }

    @Test(expected = IrisClientException.class)
    public void testInvalidSiteDelete() throws Exception {
        String sitesUrl = "/v1.0/accounts/accountId/sites/2858";
        stubFor(delete(urlMatching(sitesUrl))
                .willReturn(aResponse()
                        .withStatus(404)
                        .withBody(IrisClientTestUtils.invalidSiteDeleteResponseXml)));

        stubFor(get(urlMatching(sitesUrl))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(IrisClientTestUtils.validSiteResponseXml)));

        Site s = Site.get(getDefaultClient(), "2858");
        s.delete();

        expectedEx.expect(IrisClientException.class);
        expectedEx.expectMessage(IrisClientTestUtils.invalidSiteDeleteResponseXml);
    }

    @Test
    public void testValidSiteResponse() throws Exception {
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
    public void testValidSitesResponse() throws Exception {
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
