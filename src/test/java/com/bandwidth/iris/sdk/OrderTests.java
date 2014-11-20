package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.*;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;


/**
 * Created by sbarstow on 11/11/14.
 */
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
        assertEquals(createdOrder.getOrder().getExistingTelephoneNumberOrderType().getTelephoneNumberList().get(0), "2052865046");
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
        assertEquals(orderResponse.getOrder().getExistingTelephoneNumberOrderType().getTelephoneNumberList().get(0), "2052865046");
        assertEquals(orderResponse.getOrder().getName(), "A New Order");

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

}
