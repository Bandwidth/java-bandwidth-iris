package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.*;
import com.bandwidth.iris.sdk.utils.XmlUtils;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class OrderTests extends BaseModelTests {

    @Test
    public void testCreate() throws Exception {
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

        OrderResponse createdOrder = Order.create(getDefaultClient(), o);
        assertEquals(createdOrder.getOrder().getid(), "someid");
        assertEquals(createdOrder.getOrder().getExistingTelephoneNumberOrderType().getTelephoneNumberList().get(0),
                "2052865046");
        assertEquals(createdOrder.getOrder().getName(), "A New Order");

    }

    @Test
    public void testGet() throws Exception {
        String url = "/v1.0/accounts/accountId/orders/someid";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(IrisClientTestUtils.validOrderResponseXml)));

        OrderResponse orderResponse = Order.get(getDefaultClient(), "someid");
        assertEquals(orderResponse.getOrder().getid(), "someid");
        assertEquals(orderResponse.getOrder().getExistingTelephoneNumberOrderType().getTelephoneNumberList().get(0),
                "2052865046");
        assertEquals(orderResponse.getOrder().getName(), "A New Order");

    }

    @Test
    public void testGetError() throws Exception {
        String url = "/v1.0/accounts/accountId/orders/errorid";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(IrisClientTestUtils.validOrderResponseErrorXml)));

        OrderResponse orderResponse = Order.get(getDefaultClient(), "errorid");
        assertEquals(orderResponse.getErrorList().get(0).getCode(), "5018");
    }
    
    @Test
    public void testPartialOrderStatusCheck() throws Exception {
      String url = "/v1.0/accounts/accountId/orders/someid";
      stubFor(get(urlMatching(url))
              .willReturn(aResponse()
                      .withStatus(200)
                      .withBody(IrisClientTestUtils.validPartialOrderStatusXml)));

      OrderResponse orderResponse = Order.get(getDefaultClient(), "someid");
      assertEquals("2055551212", orderResponse.getOrder().getExistingTelephoneNumberOrderType().getTelephoneNumberList().get(0));
      assertNotNull(orderResponse.getOrderCompletedDate());
      assertEquals(0, orderResponse.getPendingQuantity());
      assertEquals(1, orderResponse.getFailedNumbers().size());
      assertEquals("2055551212", orderResponse.getFailedNumbers().get(0).getFullNumber());
    }

    @Test
    public void testAddNote() throws Exception {
        String url = "/v1.0/accounts/accountId/orders/someid";
        String notesUrl = url + "/notes";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(IrisClientTestUtils.validOrderResponseXml)));

        stubFor(put(urlMatching(notesUrl))
                .willReturn(aResponse()
                        .withStatus(200)));

        OrderResponse orderResponse = Order.get(getDefaultClient(), "someid");
        Order order = orderResponse.getOrder();
        Note note = new Note();
        note.setDescription("This is a new note");
        order.addNote(note);
    }

    @Test
    public void testGetNotes() throws Exception {
        String url = "/v1.0/accounts/accountId/orders/someid";
        String notesUrl = url + "/notes";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(IrisClientTestUtils.validOrderResponseXml)));

        stubFor(get(urlMatching(notesUrl))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(IrisClientTestUtils.validOrderNotesResponseXml)));

        OrderResponse orderResponse = Order.get(getDefaultClient(), "someid");
        Order order = orderResponse.getOrder();

        Notes notes = order.getNotes();
        assertNotNull(notes);
        assertEquals(1, notes.getNotes().size());
        assertEquals("Adding a note", notes.getNotes().get(0).getDescription());

    }

    @Test
    public void testParseErrorXml() throws Exception {
        OrderResponse response = XmlUtils.fromXml("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><OrderResponse><Order><Name>A New Order</Name><OrderCreateDate>2015-06-19T13:21:56.677Z</OrderCreateDate><BackOrderRequested>false</BackOrderRequested><id>cc5a89ab-19bd-4e62-b8c7-eabe914191e9</id><ExistingTelephoneNumberOrderType><ReservationIdList/><TelephoneNumberList><TelephoneNumber>2052865046</TelephoneNumber></TelephoneNumberList></ExistingTelephoneNumberOrderType><PartialAllowed>false</PartialAllowed><SiteId>2297</SiteId></Order><OrderStatus>RECEIVED</OrderStatus></OrderResponse>", OrderResponse.class);
        assertEquals("RECEIVED", response.getOrderStatus());
    }

    @Test
    public void rateCenterSearchAndOrderTypeTestCreate() throws Exception {
        String ordersUrl = "/v1.0/accounts/accountId/orders";
        stubFor(post(urlMatching(ordersUrl))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/xml")
                        .withBody(IrisClientTestUtils.validRateCenterOrderResponseXml)));

        Order order = new Order();
        order.setName("Test RateCenterSearchAndOrderType Order");

        RateCenterSearchAndOrderType rateCenterSearchAndOrderType = new RateCenterSearchAndOrderType();
        rateCenterSearchAndOrderType.setEnableLCA(false);
        rateCenterSearchAndOrderType.setQuantity(1);
        rateCenterSearchAndOrderType.setRateCenter("DOVER");    // No inventory available here 
        rateCenterSearchAndOrderType.setState("NH");

        order.setRateCenterSearchAndOrderType(rateCenterSearchAndOrderType);

        OrderResponse createdOrder = Order.create(getDefaultClient(), order);
        assertEquals(createdOrder.getOrder().getName(), "Test RateCenterSearchAndOrderType Order");
        assertEquals(createdOrder.getOrder().getRateCenterSearchAndOrderType().getRateCenter(), "DOVER");
    }

}
