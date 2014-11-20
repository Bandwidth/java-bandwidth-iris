package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.Reservation;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by sbarstow on 11/14/14.
 */
public class ReservationTests extends BaseModelTests {
    @Test
    public void testGet() throws Exception {
        String url = "/v1.0/accounts/accountId/tnreservation/1234";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validReservationResponseXml)));

        Reservation r = Reservation.get(getDefaultClient(), "1234");
        assertNotNull(r);
        assertEquals("1234", r.getReservationId());
        assertEquals("30", r.getReservationExpires());
    }

    @Test
    public void testCreate() throws Exception {
        String url = "/v1.0/accounts/accountId/tnreservation";

        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/xml")
                        .withHeader("Location", "https://someUrl.com/accounts/accountId/tnreservation/1234")));

        String getUrl = "/v1.0/accounts/accountId/tnreservation/1234";
        stubFor(get(urlMatching(getUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validReservationResponseXml)));

        Reservation r = new Reservation();
        r.getReservedTn().add("9195551212");
        r = Reservation.create(getDefaultClient(), r);
        assertEquals("1234", r.getReservationId());
    }

    @Test
    public void testDelete() throws Exception {
        String url = "/v1.0/accounts/accountId/tnreservation/1234";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validReservationResponseXml)));

        stubFor(delete(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)));

        Reservation r = Reservation.get(getDefaultClient(), "1234");
        r.delete();
    }
}

