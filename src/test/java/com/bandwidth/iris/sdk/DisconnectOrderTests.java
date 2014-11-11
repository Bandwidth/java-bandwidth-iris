package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.DisconnectTelephoneNumberOrder;
import com.bandwidth.iris.sdk.model.DisconnectTelephoneNumberOrderResponse;
import com.bandwidth.iris.sdk.model.DisconnectTelephoneNumberOrderType;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by sbarstow on 11/11/14.
 */
public class DisconnectOrderTests extends BaseModelTests {

    @Test
    public void testCreate() throws Exception {
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

        DisconnectTelephoneNumberOrderResponse createdOrder = DisconnectTelephoneNumberOrder.create(getDefaultClient(), order);
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

        DisconnectTelephoneNumberOrderResponse response = DisconnectTelephoneNumberOrder.get(
                getDefaultClient(), "disconnectId");
        assertEquals(response.getErrorList().size(), 1);
        assertEquals(response.getOrderStatus(), "FAILED");

    }


}
