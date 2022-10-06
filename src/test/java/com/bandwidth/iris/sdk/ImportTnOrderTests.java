package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.*;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ImportTnOrderTests extends BaseModelTests {

    @Test
    public void TestCreate()  throws Exception  {

        String url = "/v1.0/accounts/accountId/importTnOrders";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.importTnOrdersResponse)));


        ImportTnOrder order = new ImportTnOrder();

        ServiceAddress address = new ServiceAddress();
        address.setHouseNumber("123");
        address.setStreetName("Main st");
        address.setCity("Raleigh");
        address.setStateCode("NC");
        address.setZip("27606");

        Subscriber sub = new Subscriber();
        sub.setBusinessName("test business llc");
        sub.setName("Bandwidth");
        sub.setFirstName("Band");
        sub.setLastName("Width");
        sub.setServiceAddress(address);

        List<String> telephoneNumberList = new ArrayList<String>();
        telephoneNumberList.add("9195551234");

        order.setSiteId(14480);
        order.setSipPeer(522211);
        order.setTelephoneNumberList(telephoneNumberList);
        order.setSubscriber(sub);
        order.setLoaAuthorizingPerson("Bandwidth");

        ImportTnOrdersResponse response = ImportTnOrder.Create(getDefaultClient(), order );
        ImportTnOrder tnOrder = response.getImportTnOrder();

        assertEquals("id", tnOrder.getCustomerOrderId());
        assertEquals("2020-02-04T14:09:07.824Z", tnOrder.getOrderCreateDate());
        assertEquals("jmulford-api", tnOrder.getCreatedByUser());
        assertEquals("fbd17609-be44-48e7-a301-90bd6cf42248", tnOrder.getOrderId());
        assertEquals("2020-02-04T14:09:08.937Z", tnOrder.getLastModifiedDate());
        assertEquals(12345, tnOrder.getSiteId());
        assertEquals("Test Person", tnOrder.getLoaAuthorizingPerson());
        assertEquals("FAILED", tnOrder.getProcessingStatus());
        assertEquals(1, tnOrder.getErrors().size());
        assertEquals(1, tnOrder.getTelephoneNumberList().size());

        assertNotNull(tnOrder.getSubscriber());

    }
    @Test
    public void TestList() throws Exception {

        String url = "/v1.0/accounts/accountId/importTnOrders";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.importTnOrders)));


        ImportTnOrder order = new ImportTnOrder();

        ImportTnOrders response = ImportTnOrder.List(getDefaultClient(), null );
        List<ImportTnOrderSummary> list = response.getImportTnOrderSummaryList();
        ImportTnOrderSummary first = list.get(0);

        assertEquals(9900778, first.getAccountId());
        assertEquals(1, first.getCountOfTNs());
        assertEquals("dtolb-API", first.getUserId() );
        assertEquals("2020-02-04T17:58:41.033Z",first.getLastModifiedDate());
        assertEquals("2020-02-04T17:58:39.980Z", first.getOrderDate() );
        assertEquals("import_tn_orders", first.getOrderType() );
        assertEquals("COMPLETE", first.getOrderStatus() );
        assertEquals("021a94f5-5c55-401f-9cdc-8dca059ad7c1", first.getOrderId() );

    }


    @Test
    public void TestGet() throws Exception  {

        String orderId = "orderId";

        String url = "/v1.0/accounts/accountId/importTnOrders/" + orderId;
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.importTnOrder)));

        ImportTnOrder response = ImportTnOrder.Get(getDefaultClient(), orderId );

        assertEquals("id", response.getCustomerOrderId());
        assertEquals("2020-02-04T14:09:07.824Z", response.getOrderCreateDate());
        assertEquals("jmulford-api", response.getCreatedByUser());
        assertEquals("fbd17609-be44-48e7-a301-90bd6cf42248", response.getOrderId());
        assertEquals("2020-02-04T14:09:08.937Z", response.getLastModifiedDate());
        assertEquals(12345, response.getSiteId());
        assertEquals("Test Person", response.getLoaAuthorizingPerson());
        assertEquals("FAILED", response.getProcessingStatus());
        assertEquals(1, response.getErrors().size());
        assertEquals(1, response.getTelephoneNumberList().size());

        assertNotNull(response.getSubscriber());

    }


    @Test
    public void TestGetHistory() throws Exception {

        String orderId = "orderId";

        String url = "/v1.0/accounts/accountId/importTnOrders/" + orderId + "/history";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.importTnOrderHistory)));

        OrderHistoryWrapper response = ImportTnOrder.GetHistory(getDefaultClient(), orderId );

        assertEquals(2, response.getOrderHistoryList().size());

        OrderHistory first = response.getOrderHistoryList().get(0);

        assertEquals("2020-02-04T14:09:07.824Z", first.getOrderDate());
        assertEquals("Import TN order has been received by the system.", first.getNote());
        assertEquals("jmulford-api", first.getAuthor());
        assertEquals("received", first.getStatus());

    }

    @Test
    public void TestGetLoas() throws Exception {
        String orderId = "orderId";

        String url = "/v1.0/accounts/accountId/importTnOrders/" + orderId + "/loas";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.fileListLoas)));

        FileListResponse response = ImportTnOrder.GetLoas(getDefaultClient(), orderId );

        assertEquals(2, response.getFileCount());
        assertEquals("LOA file list successfully returned", response.getResultMessage());
        assertEquals(0, response.getResultCode());
        assertEquals(2, response.getFileNames().length);

        assertEquals("803f3cc5-beae-469e-bd65-e9891ccdffb9-1092874634747.pdf", response.getFileNames()[0]);
        assertEquals("803f3cc5-beae-469e-bd65-e9891ccdffb9-1430814967669.pdf", response.getFileNames()[1]);

    }

    @Test
    public void TestPostLoas() throws Exception {
        String orderId = "orderId";

        String url = "/v1.0/accounts/accountId/importTnOrders/" + orderId + "/loas";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.fileListLoas)));

        ImportTnOrder.UploadLoasFile(getDefaultClient(), orderId , new File("pom.xml"), "application/xml");

    }

    @Test
    public void TestGetLoasFile() throws Exception {
        String orderId = "orderId";
        String fileId = "id";

        byte[] data = new byte[100];
        data[1] = 1;

        String url = "/v1.0/accounts/accountId/importTnOrders/" + orderId + "/loas/" + fileId;
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(data)));

        byte[] fileData = ImportTnOrder.GetLoasFile(getDefaultClient(), orderId , fileId);

        assertEquals(fileData.length, data.length);
        assertEquals(fileData[1], data[1]);

    }

    @Test
    public void TestPutLoasFile() throws Exception {
        String orderId = "orderId";
        String fileId = "id";

        byte[] data = new byte[100];
        data[1] = 1;

        String url = "/v1.0/accounts/accountId/importTnOrders/" + orderId + "/loas/" + fileId;
        stubFor(put(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)));

        ImportTnOrder.ReplaceLoasFile(getDefaultClient(), orderId , fileId, new File("pom.xml"), "application/xml");


    }

    @Test
    public void TestDeleteLoasFile() throws Exception {
        String orderId = "orderId";
        String fileId = "id";

        byte[] data = new byte[100];
        data[1] = 1;

        String url = "/v1.0/accounts/accountId/importTnOrders/" + orderId + "/loas/" + fileId;
        stubFor(delete(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)));

        ImportTnOrder.DeleteLoasFile(getDefaultClient(), orderId , fileId);


    }

    @Test
    public void TestDeleteLoasFileMetadata() throws Exception {
        String orderId = "orderId";
        String fileId = "id";

        byte[] data = new byte[100];
        data[1] = 1;

        String url = "/v1.0/accounts/accountId/importTnOrders/" + orderId + "/loas/" + fileId + "/metadata";
        stubFor(delete(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)));

        ImportTnOrder.DeleteLoasFileMetadata(getDefaultClient(), orderId , fileId);


    }

    @Test
    public void TestGetLoasFileMetadata() throws Exception {
        String orderId = "orderId";
        String fileId = "id";

        String url = "/v1.0/accounts/accountId/importTnOrders/" + orderId + "/loas/" + fileId + "/metadata";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validFileMetaDataResponseXml)));

        FileMetaData fileMetaData = ImportTnOrder.GetLoasFileMetadata(getDefaultClient(), orderId , fileId);

        assertNotNull(fileMetaData);
        assertEquals("file.pdf", fileMetaData.getDocumentName());
    }

    @Test
    public void TestPutLoasFileMetadata() throws Exception {
        String orderId = "orderId";
        String fileId = "id";

        String url = "/v1.0/accounts/accountId/importTnOrders/" + orderId + "/loas/" + fileId + "/metadata";
        stubFor(put(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)));

        ImportTnOrder.CreateLoasFileMetadata(getDefaultClient(), orderId , fileId, new FileMetaData());

    }

}
