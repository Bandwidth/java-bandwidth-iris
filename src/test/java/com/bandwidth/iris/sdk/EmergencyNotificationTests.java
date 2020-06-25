package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;

public class EmergencyNotificationTests extends BaseModelTests {

    @Test
    public void TestCreateRecipients() throws Exception {
        String url = "/v1.0/accounts/accountId/emergencyNotificationRecipients";
        stubFor(post(urlMatching(url))
                .withHeader("User-Agent", equalTo(IrisClient.USER_AGENT))
                .willReturn(aResponse()
                        .withStatus(201).withBody(IrisClientTestUtils.emergencyNotificationRecipientsResponse)));


        EmergencyNotificationRecipientsResponse response = EmergencyNotification.createRecipients(getDefaultClient(), new EmergencyNotificationRecipient());

        EmergencyNotificationRecipient enr = response.getEmergencyNotificationRecipient();
        assertEquals(" 63865500-0904-46b1-9b4f-7bd237a26363 ", enr.getIdentifer());
        assertEquals("2020-03-18T21:26:47.403Z", enr.getCreatedDate());
        assertEquals("2020-03-18T21:26:47.403Z", enr.getLastModifiedDate());
        assertEquals("jgilmore", enr.getModifiedByUser());
        assertEquals(" This is a description of the emergency notification recipient. ", enr.getDescription());
        assertEquals("CALLBACK", enr.getType());
        assertEquals("https://foo.bar/baz", enr.getCallback().getUrl());
        assertEquals("jgilmore", enr.getCallback().getCredentials().getUsername());
        assertNull(enr.getCallback().getCredentials().getPassword());

    }

    @Test
    public void TestListRecipients() throws Exception {

        String url = "/v1.0/accounts/accountId/emergencyNotificationRecipients";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.listEmergencyNotificationRecipientsResponse)));


        EmergencyNotificationRecipientsResponse response = EmergencyNotification.listRecipients(getDefaultClient(), new HashMap<String, Object>());

        List<EmergencyNotificationRecipient> enrs = response.getEmergencyNotificationRecipients();


        assertEquals(2, enrs.size());
        assertEquals(" 63865500-0904-46b1-9b4f-7bd237a26363 ", enrs.get(0).getIdentifer());
        assertEquals(" -- link to first page of results -- ", response.getLinks().getFirst());
        assertEquals(" -- link to next page of results -- ", response.getLinks().getNext());
    }

    @Test
    public void TestReplaceRecipients() throws Exception {

        String recipientsId = "12345";

        String url = "/v1.0/accounts/accountId/emergencyNotificationRecipients/" + recipientsId;
        stubFor(put(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.emergencyNotificationRecipientsResponse)));


        EmergencyNotificationRecipientsResponse response = EmergencyNotification.replaceRecipients(getDefaultClient(), new EmergencyNotificationRecipient(), recipientsId);

        EmergencyNotificationRecipient enr = response.getEmergencyNotificationRecipient();
        assertEquals(" 63865500-0904-46b1-9b4f-7bd237a26363 ", enr.getIdentifer());
        assertEquals("2020-03-18T21:26:47.403Z", enr.getCreatedDate());
        assertEquals("2020-03-18T21:26:47.403Z", enr.getLastModifiedDate());
        assertEquals("jgilmore", enr.getModifiedByUser());
        assertEquals(" This is a description of the emergency notification recipient. ", enr.getDescription());
        assertEquals("CALLBACK", enr.getType());
        assertEquals("https://foo.bar/baz", enr.getCallback().getUrl());
        assertEquals("jgilmore", enr.getCallback().getCredentials().getUsername());
        assertNull(enr.getCallback().getCredentials().getPassword());

    }

    @Test
    public void TestGetRecipients() throws Exception {
        String recipientsId = "12345";

        String url = "/v1.0/accounts/accountId/emergencyNotificationRecipients/" + recipientsId;
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.emergencyNotificationRecipientsResponse)));

        EmergencyNotificationRecipientsResponse response = EmergencyNotification.getRecipients(getDefaultClient(), recipientsId);

        EmergencyNotificationRecipient enr = response.getEmergencyNotificationRecipient();
        assertEquals(" 63865500-0904-46b1-9b4f-7bd237a26363 ", enr.getIdentifer());
        assertEquals("2020-03-18T21:26:47.403Z", enr.getCreatedDate());
        assertEquals("2020-03-18T21:26:47.403Z", enr.getLastModifiedDate());
        assertEquals("jgilmore", enr.getModifiedByUser());
        assertEquals(" This is a description of the emergency notification recipient. ", enr.getDescription());
        assertEquals("CALLBACK", enr.getType());
        assertEquals("https://foo.bar/baz", enr.getCallback().getUrl());
        assertEquals("jgilmore", enr.getCallback().getCredentials().getUsername());
        assertNull(enr.getCallback().getCredentials().getPassword());
    }

    @Test
    public void TestDeleteRecipients() throws Exception {
        String recipientsId = "12345";

        String url = "/v1.0/accounts/accountId/emergencyNotificationRecipients/" + recipientsId;
        stubFor(delete(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)));

        IrisResponse response = EmergencyNotification.deleteRecipients(getDefaultClient(), recipientsId);

        assertNotNull(response);
        assertTrue(response.isOK());
    }

    @Test
    public void TestCreateGroupOrders() throws Exception {

        String url = "/v1.0/accounts/accountId/emergencyNotificationGroupOrders";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.addedEmergencyNotificationGroupsResponse)));

        EmergencyNotificationGroupOrderResponse response = EmergencyNotification.createGroupOrders(getDefaultClient(), new EmergencyNotificationGroupOrder());

        assertEquals("900b3646-18df-4626-b237-3a8de648ebf6", response.getOrderId());
        assertEquals("2020-04-29T15:27:16.151", response.getOrderCreatedDate());
        assertEquals("systemUser", response.getCreatedBy());
        assertEquals("PROCESSING", response.getProcessingStatus());
        assertEquals("UbOxhMnp", response.getCustomerOrderId());
        assertEquals("52897b97-3592-43fe-aa3f-857cf96671ee", response.getAddedEmergencyNotificationGroup().getIdentifier());
        assertEquals("JgHzUzIchD", response.getAddedEmergencyNotificationGroup().getDescription());
        assertEquals(3, response.getAddedEmergencyNotificationGroup().getAddedEmergencyNotificationRecipients().size());
        assertEquals("c7f74671edd8410d9a4c0f8e985e0a", response.getAddedEmergencyNotificationGroup().getAddedEmergencyNotificationRecipients().get(0).getIdentifer());
    }

    @Test
    public void TestModifyGroupOrders() throws Exception {

        String url = "/v1.0/accounts/accountId/emergencyNotificationGroupOrders";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.modifiedEmergencyNotificationGroupOrdersResponse)));

        EmergencyNotificationGroupOrderResponse response = EmergencyNotification.createGroupOrders(getDefaultClient(), new EmergencyNotificationGroupOrder());

        assertEquals(1, response.getModifiedEmergencyNotificationGroup().getAddedEmergencyNotificationRecipients().size());
        assertEquals("f2eaa7be771241af9b031584875a60", response.getModifiedEmergencyNotificationGroup().getAddedEmergencyNotificationRecipients().get(0).getIdentifer());
    }

    @Test
    public void TestListGroupOrders() throws Exception {

        String url = "/v1.0/accounts/accountId/emergencyNotificationGroupOrders";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.listEmergencyNotificationGroupOrders)));

        EmergencyNotificationGroupOrderResponse response = EmergencyNotification.listGroupOrders(getDefaultClient(), null);

        assertNotNull(response.getLinks());
        assertEquals(3, response.getEmergencyNotificationGroupOrders().size());
    }

    @Test
    public void TestGetGroupOrders() throws Exception {

        String orderId = "123";
        String url = "/v1.0/accounts/accountId/emergencyNotificationGroupOrders/" + orderId;
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.addedEmergencyNotificationGroupsResponse)));

        EmergencyNotificationGroupOrderResponse response = EmergencyNotification.getGroupOrders(getDefaultClient(), orderId);

        assertNotNull(response);
    }

    @Test
    public void TestListGroups() throws Exception {

        String orderId = "123";
        String url = "/v1.0/accounts/accountId/emergencyNotificationGroups";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.getListEmergencyNotificationGroups)));

        EmergencyNotificationGroupsResponse response = EmergencyNotification.listGroups(getDefaultClient(), null);

        List<EmergencyNotificationGroup> groups = response.getEmergencyNotificationGroups();


        assertNotNull(response);
        assertNotNull(response.getLinks());
        assertEquals(2, groups.size());

        EmergencyNotificationGroup group = groups.get(0);
        assertEquals("63865500-0904-46b1-9b4f-7bd237a26363", group.getIdentifier());
        assertEquals("2020-01-23T18:34:17.284Z", group.getCreatedDate());
        assertEquals("jgilmore", group.getModifiedBy());
        assertEquals("2020-01-23T18:34:17.284Z", group.getModifiedDate());
        assertEquals("This is a description of the emergency notification group.", group.getDescription());

        assertEquals(2,group.getEmergencyNotificationRecipients().size());
        assertEquals("63865500-0904-46b1-9b4f-7bd237a26363", group.getEmergencyNotificationRecipients().get(0).getIdentifer());
    }

    @Test
    public void TestGetGroups() throws Exception {
        String orderId = "12345";

        String url = "/v1.0/accounts/accountId/emergencyNotificationGroups/" + orderId;
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.getEmNotGroup)));

        EmergencyNotificationGroupsResponse response = EmergencyNotification.getGroups(getDefaultClient(), orderId);

        assertNotNull(response);
        assertNotNull(response.getEmergencyNotificationGroup());
    }

    @Test
    public void TestCreateEndpointOrder() throws Exception {

        String url = "/v1.0/accounts/accountId/emergencyNotificationEndpointOrders";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.getEmNotEndpointOrderResponse)));

        EmergencyNotificationEndpointOrderResponse response = EmergencyNotification.createEndpointOrder(getDefaultClient(), new EmergencyNotificationEndpointOrder());

        EmergencyNotificationEndpointOrder order = response.getEmergencyNotificationEndpointOrder();

        assertNotNull(response);

        assertEquals("3e9a852e-2d1d-4e2d-84c3-87223a78cb70", order.getOrderId());
        assertEquals("2020-01-23T18:34:17.284Z", order.getCrderCreatedDate());
        assertEquals("jgilmore", order.getCreatedBy());
        assertEquals("COMPLETED", order.getProcessingStatus());
        assertEquals("ALG-31233884", order.getCustomerOrderId());
        assertEquals("3e9a852e-2d1d-4e2d-84c3-04595ba2eb93", order.getEmergencyNotificationEndpointAssociations().getEmergencyNotificationGroupId());
        assertEquals(1, order.getEmergencyNotificationEndpointAssociations().getAddedEepToEngAssociations().size());
        assertEquals(2, order.getEmergencyNotificationEndpointAssociations().getAddedEepToEngAssociations().get(0).getEepTns().size());
        assertEquals(2, order.getEmergencyNotificationEndpointAssociations().getAddedEepToEngAssociations().get(0).getEepAeuiIds().size());
        assertEquals("2248838829", order.getEmergencyNotificationEndpointAssociations().getAddedEepToEngAssociations().get(0).getEepTns().get(0));
        assertEquals("Fred992834", order.getEmergencyNotificationEndpointAssociations().getAddedEepToEngAssociations().get(0).getEepAeuiIds().get(0));




    }

    @Test
    public void TestListEndpointOrders() throws Exception {

        String url = "/v1.0/accounts/accountId/emergencyNotificationEndpointOrders";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.listEmNotEndpointOrders)));

        EmergencyNotificationEndpointOrderResponse response = EmergencyNotification.listEndpointOrders(getDefaultClient(), null);

        assertNotNull(response);
        assertNotNull(response.getEmergencyNotificationEndpointOrders());
        assertEquals(3, response.getEmergencyNotificationEndpointOrders().size());
    }

    @Test
    public void TestGetEndpointOrders() throws Exception {
        String orderId = "12345";

        String url = "/v1.0/accounts/accountId/emergencyNotificationEndpointOrders/" + orderId;
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.listEmNotEndpointOrders)));

        EmergencyNotificationEndpointOrderResponse response = EmergencyNotification.getEndpointOrder(getDefaultClient(), orderId);

        assertNotNull(response);
    }
}
