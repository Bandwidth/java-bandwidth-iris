package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.*;
import org.junit.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RemoveImportedTnOrderTests  extends BaseModelTests {


    @Test
    public void TestCreate()  throws Exception  {

        String url = "/v1.0/accounts/accountId/removeImportedTnOrders";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.removeImportedTnOrderResponse)));


        RemoveImportedTnOrder order = new RemoveImportedTnOrder();

        RemoveImportedTnOrderResponse response = RemoveImportedTnOrder.Create(getDefaultClient(), order );
        RemoveImportedTnOrder removeTnOrder = response.getRemoveImportedTnOrder();

        assertEquals("custom string", removeTnOrder.getCustomerOrderId());
        assertEquals("2020-02-03T18:08:44.199Z", removeTnOrder.getOrderCreateDate());
        assertEquals("jmulford-api", removeTnOrder.getCreatedByUser());
        assertEquals("5bb3b642-cbbb-4438-9a44-56069550d603", removeTnOrder.getOrderId());
        assertEquals("2020-02-03T18:08:44.256Z", removeTnOrder.getLastModifiedDate());
        assertEquals("9900778", removeTnOrder.getAccountId());
        assertEquals("FAILED", removeTnOrder.getProcessingStatus());
        assertEquals(1, removeTnOrder.getErrors().size());
        assertEquals(2, removeTnOrder.getTelephoneNumberList().size());

    }
    @Test
    public void TestList() throws Exception {

        String url = "/v1.0/accounts/accountId/removeImportedTnOrders";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.removeImportedTnorders)));


        RemoveImportedTnOrders response = RemoveImportedTnOrder.List(getDefaultClient(), null );
        List<RemoveImportedTnOrderSummary> list = response.getRemoveImportedTnOrderSummaryList();
        RemoveImportedTnOrderSummary first = list.get(0);

        assertEquals(9, response.getTotalCount());

        assertEquals(9900778, first.getAccountId());
        assertEquals(1, first.getCountOfTNs());
        assertEquals("dtolb", first.getUserId() );
        assertEquals("2020-02-04T18:01:54.786Z",first.getLastModifiedDate());
        assertEquals("2020-02-04T18:01:54.434Z", first.getOrderDate() );
        assertEquals("remove_imported_tn_orders", first.getOrderType() );
        assertEquals("COMPLETE", first.getOrderStatus() );
        assertEquals("7a992c85-d164-46df-97c4-dac6030ec952", first.getOrderId() );

    }


    @Test
    public void TestGet() throws Exception  {

        String orderId = "orderId";

        String url = "/v1.0/accounts/accountId/removeImportedTnOrders/" + orderId;
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.removeImportedTnOrder)));

        RemoveImportedTnOrder removeTnOrder = RemoveImportedTnOrder.Get(getDefaultClient(), orderId );

        assertEquals("custom string", removeTnOrder.getCustomerOrderId());
        assertEquals("2020-02-03T18:08:44.199Z", removeTnOrder.getOrderCreateDate());
        assertEquals("jmulford-api", removeTnOrder.getCreatedByUser());
        assertEquals("5bb3b642-cbbb-4438-9a44-56069550d603", removeTnOrder.getOrderId());
        assertEquals("2020-02-03T18:08:44.256Z", removeTnOrder.getLastModifiedDate());
        assertEquals("9900778", removeTnOrder.getAccountId());
        assertEquals("FAILED", removeTnOrder.getProcessingStatus());
        assertEquals(1, removeTnOrder.getErrors().size());
        assertEquals(2, removeTnOrder.getTelephoneNumberList().size());

    }


    @Test
    public void TestGetHistory() throws Exception {

        String orderId = "orderId";

        String url = "/v1.0/accounts/accountId/removeImportedTnOrders/" + orderId + "/history";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.removeTnOrderHistory)));

        OrderHistoryWrapper response = RemoveImportedTnOrder.GetHistory(getDefaultClient(), orderId );

        assertEquals(2, response.getOrderHistoryList().size());

        OrderHistory first = response.getOrderHistoryList().get(0);

        assertEquals("2020-02-04T14:09:07.824Z", first.getOrderDate());
        assertEquals("Import TN order has been received by the system.", first.getNote());
        assertEquals("jmulford-api", first.getAuthor());
        assertEquals("received", first.getStatus());

    }
}
