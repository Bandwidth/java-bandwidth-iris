package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;

public class TnOptionsTests extends BaseModelTests {

    @Test
    public void TestCreate() throws Exception {
        String url = "/v1.0/accounts/accountId/tnoptions";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(201).withBody(IrisClientTestUtils.createTnOptionResponse)));


        TnOptionOrderResponse response = TnOptions.create(getDefaultClient(), new TnOptionOrder());

        TnOptionOrder option = response.getTnOptionOrder();
        List<TnOptionGroup> list = option.getTnOptionGroups();

        assertEquals("2016-01-15T12:01:14.324Z", option.getOrderCreateDate());
        assertEquals("14", option.getAccountId());
        assertEquals("jbm", option.getCreatedByUser());
        assertEquals("ddbdc72e-dc27-490c-904e-d0c11291b095", option.getOrderId());
        assertEquals("2016-01-15T12:01:14.324Z", option.getLastModifiedDate());
        assertEquals("RECEIVED", option.getProcessingStatus());
        assertEquals(2, option.getTnOptionGroups().size());
        assertEquals("10digit", list.get(0).getNumberFormat());
        assertEquals("10digit", list.get(0).getRPIDFormat());
        assertEquals("testUser1", list.get(0).getRewriteUser());
        assertEquals("6042661720", list.get(0).getCallForward());
        assertEquals("on", list.get(0).getCallingNameDisplay());
        assertEquals("true", list.get(0).getProtectedOpt());
        assertEquals("on", list.get(0).getSms());
        assertEquals("2018551020", list.get(0).getTelephoneNumbers().get(0));



    }

    @Test
    public void TestList() throws Exception {

        String url = "/v1.0/accounts/accountId/tnoptions?.*";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.listTnOptions)));

        HashMap<String, Object> query = new HashMap<>();
        query.put("tn", "9199918388");

        TnOptionOrders response = TnOptions.list(getDefaultClient(), query);
        TnOptionOrder first = response.getTnOptionOrders().get(0);

        assertEquals(new Integer(2), response.getTotalCount());
        assertEquals(2, response.getTnOptionOrders().size());
        assertEquals("2016-01-15T12:01:14.324Z", first.getOrderCreateDate());
        assertEquals("14", first.getAccountId());
        assertEquals("jbm", first.getCreatedByUser());
        assertEquals("ddbdc72e-dc27-490c-904e-d0c11291b095", first.getOrderId());
        assertEquals("2016-01-15T12:01:14.363Z", first.getLastModifiedDate());
        assertEquals("FAILED", first.getProcessingStatus());

        assertEquals(2, first.getTnOptionGroups().size());
        assertEquals("sip:+12345678901@1.2.3.4:5060", first.getTnOptionGroups().get(0).getFinalDestinationURI());

    }

    @Test
    public void TestListWithSummary() throws Exception {

        String url = "/v1.0/accounts/accountId/tnoptions?.*";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.listTnOptionsWithSummary)));


        HashMap<String, Object> query = new HashMap<>();
        query.put("tn", "9199918388");

        TnOptionOrders response = TnOptions.list(getDefaultClient(), query);

        TnOptionOrderSummary first = response.getTnOptionOrderSummarys().get(0);

        assertEquals(new Integer(2), response.getTotalCount());
        assertEquals(2, response.getTnOptionOrderSummarys().size());
        assertEquals("14", first.getAccountId());
        assertEquals(new Integer(2), first.getCountOfTNs());
        assertEquals("jbm", first.getUserId());
        assertEquals("2016-01-15T12:01:14.363Z", first.getLastModifiedDate());
        assertEquals("2016-01-15T12:01:14.324Z", first.getOrderDate());
        assertEquals("tn_option", first.getOrderType());
        assertEquals("FAILED", first.getOrderStatus());
        assertEquals("ddbdc72e-dc27-490c-904e-d0c11291b095", first.getOrderId());
    }

    @Test
    public void TestGet() throws Exception {

        String orderId = "12345";

        String url = "/v1.0/accounts/accountId/tnoptions/" + orderId;
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.getTnOption)));


        TnOptionOrder response = TnOptions.get(getDefaultClient(), orderId);

        assertEquals("2016-01-15T11:22:58.789Z", response.getOrderCreateDate());
        assertEquals("14", response.getAccountId());
        assertEquals("jbm", response.getCreatedByUser());
        assertEquals("409033ee-88ec-43e3-85f3-538f30733963", response.getOrderId());
        assertEquals("2016-01-15T11:22:58.969Z", response.getLastModifiedDate());
        assertEquals("COMPLETE", response.getProcessingStatus());
        assertEquals(3, response.getTnOptionGroups().size());

        assertEquals("sip:+12345678901@1.2.3.4:5060", response.getTnOptionGroups().get(2).getFinalDestinationURI());


    }

    @Test
    public void TestGetWithError() throws Exception {

        String orderId = "12345";

        String url = "/v1.0/accounts/accountId/tnoptions/" + orderId;
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.getTnOptionsWithError)));


        TnOptionOrder response = TnOptions.get(getDefaultClient(), orderId);

        assertEquals(2, response.getErrors().size());
        assertEquals("5076", response.getErrors().get(0).getCode());
        assertEquals("Telephone number is not available.", response.getErrors().get(0).getDescription());
        assertEquals("2018551025", response.getErrors().get(0).getTelephoneNumber());

    }

}
