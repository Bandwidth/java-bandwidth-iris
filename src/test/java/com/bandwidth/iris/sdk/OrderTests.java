package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.ExistingTelephoneNumberOrderType;
import com.bandwidth.iris.sdk.model.Order;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by sbarstow on 11/11/14.
 */
public class OrderTests extends BaseModelTests {

    @Test
    public void testCreate() throws IrisClientException {
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

        Order createdOrder = Order.create(getDefaultClient(), o);
        assertEquals(createdOrder.getid(), "someid");
        assertEquals(createdOrder.getExistingTelephoneNumberOrderType().getTelephoneNumberList().get(0), "2052865046");
        assertEquals(createdOrder.getName(), "A New Order");

    }

}
