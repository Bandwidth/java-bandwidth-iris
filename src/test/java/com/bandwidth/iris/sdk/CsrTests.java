package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.*;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.junit.Assert.*;

public class CsrTests extends BaseModelTests {


    @Test
    public void TestCreate() throws Exception {
        String url = "/v1.0/accounts/accountId/csrs";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.csrResponse)));


        Csr csr = new Csr();

        CsrResponse response = Csr.Create(getDefaultClient(), csr);

        assertEquals("someValue", response.getCustomerOrderId());
        assertEquals("systemUser", response.getLastModifiedBy());
        assertEquals("2019-10-25T09:51:17Z", response.getOrderCreateDate());
        assertEquals("1", response.getAccountId());
        assertEquals("a2f55ebe-782a-4242-983b-6ae6cfa97833", response.getOrderId());
        assertEquals("2019-10-25T12:51:22.139Z", response.getLastModifiedDate());
        assertEquals("COMPLETE", response.getStatus());
        assertEquals("987654321", response.getAccountNumber());
        assertEquals("9196194444", response.getAccountTelephoneNumber());
        assertEquals("bandwidthGuy", response.getEndUserName());
        assertEquals("importantAuthGuy", response.getAuthorizingUserName());
        assertEquals("123", response.getCustomerCode());
        assertEquals("12345", response.getEndUserPIN());
        assertEquals("enduserpassword123", response.getEndUserPassword());
        assertEquals("900 Main Campus Dr", response.getAddressLine1());
        assertEquals("Raleigh", response.getCity());
        assertEquals("NC", response.getState());
        assertEquals("27612", response.getZIPCode());
        assertEquals("residential", response.getTypeOfService());

        assertNotNull( response.getCsrData());
        assertEquals("123456789", response.getCsrData().getAccountNumber());
        assertEquals("JOHN SMITH", response.getCsrData().getCustomerName());
        assertNotNull( response.getCsrData().getServiceAddress());
        assertEquals("9196191211", response.getCsrData().getWorkingTelephoneNumber());
        assertEquals(1, response.getCsrData().getWorkingTelephoneNumbersOnAccount().length);
        assertEquals("9196191211", response.getCsrData().getWorkingTelephoneNumbersOnAccount()[0]);

    }

    @Test
    public void TestGet() throws Exception {

        String orderId = "12345";

        String url = "/v1.0/accounts/accountId/csrs/" + orderId;
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.csrResponse)));


        Csr csr = new Csr();

        CsrResponse response = Csr.Get(getDefaultClient(), orderId);

        assertEquals("someValue", response.getCustomerOrderId());
        assertEquals("systemUser", response.getLastModifiedBy());
        assertEquals("2019-10-25T09:51:17Z", response.getOrderCreateDate());
        assertEquals("1", response.getAccountId());
        assertEquals("a2f55ebe-782a-4242-983b-6ae6cfa97833", response.getOrderId());
        assertEquals("2019-10-25T12:51:22.139Z", response.getLastModifiedDate());
        assertEquals("COMPLETE", response.getStatus());
        assertEquals("987654321", response.getAccountNumber());
        assertEquals("9196194444", response.getAccountTelephoneNumber());
        assertEquals("bandwidthGuy", response.getEndUserName());
        assertEquals("importantAuthGuy", response.getAuthorizingUserName());
        assertEquals("123", response.getCustomerCode());
        assertEquals("12345", response.getEndUserPIN());
        assertEquals("enduserpassword123", response.getEndUserPassword());
        assertEquals("900 Main Campus Dr", response.getAddressLine1());
        assertEquals("Raleigh", response.getCity());
        assertEquals("NC", response.getState());
        assertEquals("27612", response.getZIPCode());
        assertEquals("residential", response.getTypeOfService());

        assertNotNull( response.getCsrData());
        assertEquals("123456789", response.getCsrData().getAccountNumber());
        assertEquals("JOHN SMITH", response.getCsrData().getCustomerName());
        assertNotNull( response.getCsrData().getServiceAddress());
        assertEquals("9196191211", response.getCsrData().getWorkingTelephoneNumber());
        assertEquals(1, response.getCsrData().getWorkingTelephoneNumbersOnAccount().length);
        assertEquals("9196191211", response.getCsrData().getWorkingTelephoneNumbersOnAccount()[0]);
    }

    @Test
    public void TestReplace() throws Exception {

        String orderId = "12345";

        String url = "/v1.0/accounts/accountId/csrs/" + orderId;
        stubFor(put(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.csrResponse)));


        Csr csr = new Csr();

        CsrResponse response = Csr.Replace(getDefaultClient(), orderId, csr);

        assertEquals("someValue", response.getCustomerOrderId());
        assertEquals("systemUser", response.getLastModifiedBy());
        assertEquals("2019-10-25T09:51:17Z", response.getOrderCreateDate());
        assertEquals("1", response.getAccountId());
        assertEquals("a2f55ebe-782a-4242-983b-6ae6cfa97833", response.getOrderId());
        assertEquals("2019-10-25T12:51:22.139Z", response.getLastModifiedDate());
        assertEquals("COMPLETE", response.getStatus());
        assertEquals("987654321", response.getAccountNumber());
        assertEquals("9196194444", response.getAccountTelephoneNumber());
        assertEquals("bandwidthGuy", response.getEndUserName());
        assertEquals("importantAuthGuy", response.getAuthorizingUserName());
        assertEquals("123", response.getCustomerCode());
        assertEquals("12345", response.getEndUserPIN());
        assertEquals("enduserpassword123", response.getEndUserPassword());
        assertEquals("900 Main Campus Dr", response.getAddressLine1());
        assertEquals("Raleigh", response.getCity());
        assertEquals("NC", response.getState());
        assertEquals("27612", response.getZIPCode());
        assertEquals("residential", response.getTypeOfService());

        assertNotNull( response.getCsrData());
        assertEquals("123456789", response.getCsrData().getAccountNumber());
        assertEquals("JOHN SMITH", response.getCsrData().getCustomerName());
        assertNotNull( response.getCsrData().getServiceAddress());
        assertEquals("9196191211", response.getCsrData().getWorkingTelephoneNumber());
        assertEquals(1, response.getCsrData().getWorkingTelephoneNumbersOnAccount().length);
        assertEquals("9196191211", response.getCsrData().getWorkingTelephoneNumbersOnAccount()[0]);

    }

    @Test
    public void TestGetNotes() throws Exception {
        String orderId = "12345";

        String url = "/v1.0/accounts/accountId/csrs/" + orderId + "/notes";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validOrderNotesResponseXml)));

        Notes response = Csr.GetNotes(getDefaultClient(), orderId);

       assertNotNull(response);
       assertNotNull(response.getNotes());
       assertTrue(response.getNotes().size() > 0);
    }

    @Test
    public void TestAddNote() throws Exception {
        String orderId = "12345";

        String url = "/v1.0/accounts/accountId/csrs/" + orderId + "/notes";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)));

        IrisResponse response = Csr.AddNote(getDefaultClient(), orderId, new Note() );

        assertNotNull(response);
        assertTrue(response.isOK());
    }

    @Test
    public void TestUpdateNote() throws Exception {
        String orderId = "12345";
        String noteId = "123";

        String url = "/v1.0/accounts/accountId/csrs/" + orderId + "/notes/" + noteId;
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)));

        IrisResponse response = Csr.UpdateNote(getDefaultClient(), orderId, noteId, new Note() );

        assertNotNull(response);
        assertTrue(response.isOK());
    }
}
