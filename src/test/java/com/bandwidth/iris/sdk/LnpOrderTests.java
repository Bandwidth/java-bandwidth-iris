package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.*;
import org.junit.Test;

import java.io.File;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LnpOrderTests extends BaseModelTests {
    @Test
    public void testCreate() throws Exception {
        String url = "/v1.0/accounts/accountId/portins";
        stubFor(post(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/xml")
                .withBody(IrisClientTestUtils.validLnpOrderResponseXml)));

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

    @Test
    public void testGet() throws Exception {
        String url = "/v1.0/accounts/accountId/portins/1234";
        stubFor(get(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)
                .withBody(IrisClientTestUtils.validLnpOrderResponseXml)));

        LnpOrderResponse response = LnpOrder.get(getDefaultClient(), "1234");
        assertEquals("1234", response.getOrderId());
        assertEquals("PENDING_DOCUMENTS", response.getProcessingStatus());
    }

    @Test
    public void testDelete() throws Exception {
        String url = "/v1.0/accounts/accountId/portins/1234";
        stubFor(delete(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)));

        stubFor(get(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)
                .withBody(IrisClientTestUtils.validLnpOrderResponseXml)));
        LnpOrderResponse response = LnpOrder.get(getDefaultClient(), "1234");
        response.delete();
    }

    @Test
    public void testUpdate() throws Exception {
        String url = "/v1.0/accounts/accountId/portins/1234";
        stubFor(put(urlMatching(url)).willReturn(aResponse()
                        .withStatus(200)
                        .withBody(IrisClientTestUtils.validLnpSuppOrderResponseXml)
        ));

        stubFor(get(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)
                .withBody(IrisClientTestUtils.validLnpOrderResponseXml)));

        LnpOrderSupp orderSupp = new LnpOrderSupp();
        orderSupp.setLoaAuthorizingPerson("Jane Doe");
        orderSupp.setOrderId("1234");

        LnpOrderResponse order = LnpOrder.get(getDefaultClient(), "1234");

        LnpOrderResponse response = order.update(orderSupp);

        assertEquals("1234", response.getOrderId());
        assertEquals("REQUESTED_SUPP", response.getProcessingStatus());
        assertEquals("Jane Doe", response.getLoaAuthorizingPerson());
    }

    @Test
    public void testGetActivationStatus() throws Exception {
        String url = "/v1.0/accounts/accountId/portins/1234/activationStatus";
        stubFor(get(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)
                .withBody(IrisClientTestUtils.validActivationStatusResponseXml)));

        String orderUrl = "/v1.0/accounts/accountId/portins/1234";
        stubFor(get(urlMatching(orderUrl)).willReturn(aResponse()
                .withStatus(200)
                .withBody(IrisClientTestUtils.validLnpOrderResponseXml)));


        LnpOrderResponse order = LnpOrder.get(getDefaultClient(), "1234");
        ActivationStatusResponse response = order.getActivationStatus();
        assertEquals(response.getActivationStatus().getNotYetActivatedTelephoneNumberList().size(),0);
        assertEquals(response.getActivationStatus().getActivatedTelephoneNumberList().size(),1);
        assertEquals(response.getActivationStatus().getActivatedTelephoneNumberList().get(0),"9199918388");



    }

    @Test
    public void testUploadLoa() throws Exception {
        String url = "/v1.0/accounts/accountId/portins/1234/loas";
        stubFor(post(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)));

        String orderUrl = "/v1.0/accounts/accountId/portins/1234";
        stubFor(get(urlMatching(orderUrl)).willReturn(aResponse()
                .withStatus(200)
                .withBody(IrisClientTestUtils.validLnpOrderResponseXml)));

        LnpOrderResponse order = LnpOrder.get(getDefaultClient(), "1234");
        File file = File.createTempFile("file", "pdf");
        order.uploadLoa(file, LoaFileType.PDF);
        file.delete();
    }

    @Test
    public void testUpdateLoa() throws Exception {
        String url = "/v1.0/accounts/accountId/portins/1234/loas";
        stubFor(post(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)));

        String orderUrl = "/v1.0/accounts/accountId/portins/1234";
        stubFor(get(urlMatching(orderUrl)).willReturn(aResponse()
                .withStatus(200)
                .withBody(IrisClientTestUtils.validLnpOrderResponseXml)));

        File file = File.createTempFile("file", "pdf");
        String putUrl = "/v1.0/accounts/accountId/portins/1234/loas/" + file.getName();
        stubFor(put(urlMatching(putUrl)).willReturn(aResponse()
                .withStatus(200)));

        LnpOrderResponse order = LnpOrder.get(getDefaultClient(), "1234");
        order.updateLoa(file, LoaFileType.PDF);
        order.updateLoa(file, LoaFileType.PDF);
        file.delete();
    }

    @Test
    public void testDeleteLoa() throws Exception {
        String url = "/v1.0/accounts/accountId/portins/1234/loas/file.pdf";
        stubFor(delete(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)));

        String orderUrl = "/v1.0/accounts/accountId/portins/1234";
        stubFor(get(urlMatching(orderUrl)).willReturn(aResponse()
                .withStatus(200)
                .withBody(IrisClientTestUtils.validLnpOrderResponseXml)));

        LnpOrderResponse order = LnpOrder.get(getDefaultClient(), "1234");
        order.deleteLoa("file.pdf");
    }

    @Test
    public void testGetLoaMetaData() throws Exception {
        String url = "/v1.0/accounts/accountId/portins/1234/loas/file.pdf/metadata";
        stubFor(get(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)
                .withBody(IrisClientTestUtils.validFileMetaDataResponseXml)));

        String orderUrl = "/v1.0/accounts/accountId/portins/1234";
        stubFor(get(urlMatching(orderUrl)).willReturn(aResponse()
                .withStatus(200)
                .withBody(IrisClientTestUtils.validLnpOrderResponseXml)));

        LnpOrderResponse order = LnpOrder.get(getDefaultClient(), "1234");
        FileMetaData response = order.getLoaMetaData("file.pdf");
        assertNotNull(response);
        assertEquals("file.pdf", response.getDocumentName());
        assertEquals("PDF", response.getDocumentType());
    }

    @Test
    public void testUpdateLoaMetaData() throws Exception {
        String url = "/v1.0/accounts/accountId/portins/1234/loas/file.pdf/metadata";
        stubFor(put(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)));

        String orderUrl = "/v1.0/accounts/accountId/portins/1234";
        stubFor(get(urlMatching(orderUrl)).willReturn(aResponse()
                .withStatus(200)
                .withBody(IrisClientTestUtils.validLnpOrderResponseXml)));

        LnpOrderResponse order = LnpOrder.get(getDefaultClient(), "1234");
        FileMetaData data = new FileMetaData();
        data.setDocumentName("file2.pdf");
        data.setDocumentType("PDF");
        order.updateLoaMetaData("file.pdf", data);
    }

    @Test
    public void testDeleteLoaMetaData() throws Exception {
        String url = "/v1.0/accounts/accountId/portins/1234/loas/file.pdf/metadata";
        stubFor(delete(urlMatching(url)).willReturn(aResponse()
                .withStatus(200)));

        String orderUrl = "/v1.0/accounts/accountId/portins/1234";
        stubFor(get(urlMatching(orderUrl)).willReturn(aResponse()
                .withStatus(200)
                .withBody(IrisClientTestUtils.validLnpOrderResponseXml)));

        LnpOrderResponse order = LnpOrder.get(getDefaultClient(), "1234");
        order.deleteLoaMetaData("file.pdf");
    }

}
