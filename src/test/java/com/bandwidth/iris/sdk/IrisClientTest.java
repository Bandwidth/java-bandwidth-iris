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
import org.junit.rules.ExpectedException;


import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.junit.Assert.*;


public class IrisClientTest {


    private String message;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8090); // No-args constructor defaults to port 8080

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();


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

    @Test
    public void testCreateNewSite() throws IrisClientException {
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
        String siteId = getDefaultClient().createSite(s);
        System.out.println("site id: " + siteId);
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

        getDefaultClient().deleteSite("5001");

        expectedEx.expect(IrisClientException.class);
        expectedEx.expectMessage(IrisClientTestUtils.invalidSiteDeleteResponseXml);

    }


    @Test
    public void testValidSipPeersResponse() throws IrisClientException {
        String sitesUrl = "/v1.0/accounts/accountId/sites/1234/sippeers";
        stubFor(get(urlMatching(sitesUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSipPeersResponseXml)));

        IrisClient irisClient = getDefaultClient();
        List<SipPeer> result = irisClient.getSipPeers("1234");
        assertTrue(result != null);
        assertEquals(1, result.size());
        SipPeer s = result.get(0);
        assertEquals(s.getPeerName(), "SIP Peer 1");
        assertEquals(s.getPeerId(), "12345");
    }

    @Test
    public void testCreateOrder() throws IrisClientException {
        String ordersUrl = "/v1.0/accounts/accountId/orders";
        stubFor(post(urlMatching(ordersUrl))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/xml")
                        .withBody(IrisClientTestUtils.validOrderResponseXml)));

        Order o = new Order();
        o.setName("A New Order");
        ExistingTelephoneNumberOrderType existingTelephoneNumberOrderType = new ExistingTelephoneNumberOrderType();
        existingTelephoneNumberOrderType.getTelephoneNumberList().add("2052865046");
        o.setExistingTelephoneNumberOrderType(existingTelephoneNumberOrderType);

        Order createdOrder = getDefaultClient().createOrder(o);
        assertEquals(createdOrder.getid(), "someid");
        assertEquals(createdOrder.getExistingTelephoneNumberOrderType().getTelephoneNumberList().get(0), "2052865046");
        assertEquals(createdOrder.getName(), "A New Order");

    }

    @Test
    public void testCreateDisconnectOrder() throws Exception {
        String disconnectOrdersUrl = "/v1.0/accounts/accountId/disconnects";
        stubFor(post(urlMatching(disconnectOrdersUrl))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/xml")
                        .withBody(IrisClientTestUtils.validCreateDisconnectTelephoneNumberOrderResponseXml)));

        DisconnectTelephoneNumberOrder order = new DisconnectTelephoneNumberOrder();
        order.setName("Disconnect");
        DisconnectTelephoneNumberOrderType disconnectTelephoneNumberOrderType = new DisconnectTelephoneNumberOrderType();
        disconnectTelephoneNumberOrderType.getTelephoneNumberList().add("2055551212");
        order.setDisconnectTelephoneNumberOrderType(disconnectTelephoneNumberOrderType);

        DisconnectTelephoneNumberOrderResponse createdOrder =
                getDefaultClient().createDisconnectOrder(order);
        assertEquals(createdOrder.getorderRequest().getid(), "disconnectId");
        assertEquals(createdOrder.getorderRequest().getDisconnectTelephoneNumberOrderType().
                getTelephoneNumberList().get(0), "2055551212");
        assertEquals(createdOrder.getorderRequest().getName(), "Disconnect");
        assertEquals(createdOrder.getErrorList().size(), 0);

    }

    @Test
    public void testGetDisconnectOrderStatusWithErrors() throws Exception {
        String disconnectOrdersUrl = "/v1.0/accounts/accountId/disconnects.*";
        stubFor(get(urlMatching(disconnectOrdersUrl))
            .willReturn(aResponse()
                .withStatus(200).withBody(IrisClientTestUtils.
                            validCreateDisconnectTelephoneNumberOrderResponseWithErrorsXml)));

        DisconnectTelephoneNumberOrderResponse response = getDefaultClient().getDisconnectOrder("disconnectId");
        assertEquals(response.getErrorList().size(), 1);
        assertEquals(response.getOrderStatus(), "FAILED");

    }



}