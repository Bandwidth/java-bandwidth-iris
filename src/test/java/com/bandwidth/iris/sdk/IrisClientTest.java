package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.*;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.junit.WireMockRule;


import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.junit.Assert.*;


public class IrisClientTest {


    private String message;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8090); // No-args constructor defaults to port 8080


    private IrisClient getDefaultClient(){
        return new IrisClient("http://localhost:8090", "accountId", "siteId", "username", "password", "v1.0");
    }


    @Before
    public void setUp() throws ConfigurationException {
        org.apache.log4j.BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.DEBUG);
        ConsoleAppender a = (ConsoleAppender) Logger.getRootLogger().getAllAppenders().nextElement();
        a.setLayout(new PatternLayout("%d{ABSOLUTE} %5p %c{1}:%L - [%t] %m%n"));

    }


    public void setMessage(String s){
        this.message = s;
    }

    @Test
    public void testSearchNumbers() throws IrisClientException{
        String queryUrl = "/v1.0/accounts/accountId/availableNumbers.*";

        stubFor(get(urlMatching(queryUrl))
            .willReturn(aResponse()
                .withStatus(200).withBody(IrisClientTestUtils.localAreaSearchResultXml)));

        IrisClient irisClient = getDefaultClient();
        TelephoneNumberSearchFilters filters = new TelephoneNumberSearchFilters();
        filters.setInAreaCode("201");
        List<TelephoneNumberDetail> result = (List<TelephoneNumberDetail>) irisClient.getAvailableNumbers(filters);
        assertTrue(result != null);
        assertEquals(result.size(), 2);
    }

    @Test
    public void testValidSitesResponse() throws IrisClientException {
        String sitesUrl = "/v1.0/accounts/accountId/sites";
        stubFor(get(urlMatching(sitesUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSitesResponseXml)));

        IrisClient irisClient = getDefaultClient();
        List<Site> result = irisClient.getSites();
        assertTrue(result != null);
        assertEquals(1, result.size());
        Site s = result.get(0);
        assertEquals(s.getName(), "Test Site");
    }

    @Test
    public void testValidSiteResponse() throws IrisClientException {
        String sitesUrl = "/v1.0/accounts/accountId/sites/2858";
        stubFor(get(urlMatching(sitesUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSiteResponseXml)));

        IrisClient irisClient = getDefaultClient();
        Site result = irisClient.getSite("2858");
        assertTrue(result != null);
        assertEquals(result.getName(), "Test Site");
        assertEquals(result.getAddress().getAddressType(), "Service");
    }

}