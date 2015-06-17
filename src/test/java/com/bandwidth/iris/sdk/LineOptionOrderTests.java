package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.LnpOrder;
import com.bandwidth.iris.sdk.model.LnpOrderResponse;
import com.bandwidth.iris.sdk.model.ServiceAddress;
import com.bandwidth.iris.sdk.model.Subscriber;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by sbarstow on 6/17/15.
 */
public class LineOptionOrderTests extends BaseModelTests{
    @Test
    public void testCreate() throws Exception {
        String url = "/v1.0/accounts/accountId/lineOptionOrders";
        stubFor(post(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/xml")
                .withBody(IrisClientTestUtils.validLineOptionOrderResponseXml)));

        LnpOrder lnpOrder = new LnpOrder();
        lnpOrder.setBillingTelephoneNumber("9195551212");
        Subscriber subscriber = new Subscriber();
        subscriber.setBusinessName("TestCo");
        subscriber.setSubscriberType("BUSINESS");

        ServiceAddress serviceAddress = new ServiceAddress();
        serviceAddress.setHouseNumber("1623");
        serviceAddress.setStreetName("Brockton Ave #1");
        serviceAddress.setCity("Los Angeles");
        serviceAddress.setZip("90025");
        serviceAddress.setCountry("USA");
        subscriber.setServiceAddress(serviceAddress);
        lnpOrder.setSubscriber(subscriber);
        lnpOrder.setLoaAuthorizingPerson("John Doe");
        lnpOrder.getListOfPhoneNumbers().add("6882015025");
        lnpOrder.getListOfPhoneNumbers().add("6882015026");
        lnpOrder.setSiteId("385");

        LnpOrderResponse response = LnpOrder.create(getDefaultClient(), lnpOrder);
        assertNotNull(response);
        assertEquals("1234", response.getOrderId());
        assertEquals("PENDING_DOCUMENTS", response.getProcessingStatus());

    }

}
