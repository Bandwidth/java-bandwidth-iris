package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;
import com.bandwidth.iris.sdk.IrisResponse;

import java.util.Map;

public class EmergencyNotification {

    public static EmergencyNotificationRecipientsResponse createRecipients(IrisClient client, EmergencyNotificationRecipient enr) throws Exception {
        return client.post( client.buildAccountModelUri( new String[] { IrisPath.EMERGENCY_NOTIFICATION_RECIPIENTS } ), enr, EmergencyNotificationRecipientsResponse.class);
    }

    public static EmergencyNotificationRecipientsResponse listRecipients(IrisClient client, Map<String, Object> query) throws Exception {
        return client.get(client.buildAccountModelUri(
                new String[] { IrisPath.EMERGENCY_NOTIFICATION_RECIPIENTS }, query), EmergencyNotificationRecipientsResponse.class);
    }

    public static EmergencyNotificationRecipientsResponse replaceRecipients(IrisClient client, EmergencyNotificationRecipient enr, String enrId) throws Exception {
        return client.put(client.buildAccountModelUri(new String[] { IrisPath.EMERGENCY_NOTIFICATION_RECIPIENTS, enrId}), enr, EmergencyNotificationRecipientsResponse.class);
    }

    public static EmergencyNotificationRecipientsResponse getRecipients(IrisClient client, String enrId) throws Exception {
        return client.get(client.buildAccountModelUri(new String[] { IrisPath.EMERGENCY_NOTIFICATION_RECIPIENTS, enrId}), EmergencyNotificationRecipientsResponse.class);
    }

    public static IrisResponse deleteRecipients(IrisClient client, String enrId) throws Exception {
        return client.delete(client.buildAccountModelUri(new String[] { IrisPath.EMERGENCY_NOTIFICATION_RECIPIENTS, enrId}));
    }

    public static EmergencyNotificationGroupOrderResponse createGroupOrders(IrisClient client, EmergencyNotificationGroupOrder engo) throws Exception {
        return client.post( client.buildAccountModelUri( new String[] { IrisPath.EMERGENCY_NOTIFICATION_GROUP_ORDERS } ), engo, EmergencyNotificationGroupOrderResponse.class);
    }

    public static EmergencyNotificationGroupOrderResponse listGroupOrders(IrisClient client, Map<String, Object> query) throws Exception {
        return client.get(client.buildAccountModelUri(
                new String[] { IrisPath.EMERGENCY_NOTIFICATION_GROUP_ORDERS }, query), EmergencyNotificationGroupOrderResponse.class);
    }

    public static EmergencyNotificationGroupOrderResponse getGroupOrders(IrisClient client, String engoId) throws Exception {
        return client.get(client.buildAccountModelUri(new String[] { IrisPath.EMERGENCY_NOTIFICATION_GROUP_ORDERS, engoId}), EmergencyNotificationGroupOrderResponse.class);
    }

    public static EmergencyNotificationGroupsResponse listGroups(IrisClient client, Map<String, Object> query) throws Exception {
        return client.get(client.buildAccountModelUri(
                new String[] { IrisPath.EMERGENCY_NOTIFICATION_GROUPS }, query), EmergencyNotificationGroupsResponse.class);
    }

    public static EmergencyNotificationGroupsResponse getGroups(IrisClient client, String engId) throws Exception {
        return client.get(client.buildAccountModelUri(new String[] { IrisPath.EMERGENCY_NOTIFICATION_GROUPS, engId}), EmergencyNotificationGroupsResponse.class);
    }

    public static EmergencyNotificationEndpointOrderResponse createEndpointOrder(IrisClient client, EmergencyNotificationEndpointOrder eneo) throws Exception {
        return client.post( client.buildAccountModelUri( new String[] { IrisPath.EMERGENCY_NOTIFICATION_ENDPOINT_ORDERS } ), eneo, EmergencyNotificationEndpointOrderResponse.class);
    }

    public static EmergencyNotificationEndpointOrderResponse listEndpointOrders(IrisClient client, Map<String, Object> query) throws Exception {
        return client.get(client.buildAccountModelUri(
                new String[] { IrisPath.EMERGENCY_NOTIFICATION_ENDPOINT_ORDERS }, query), EmergencyNotificationEndpointOrderResponse.class);
    }

    public static EmergencyNotificationEndpointOrderResponse getEndpointOrder(IrisClient client, String eneoId) throws Exception {
        return client.get(client.buildAccountModelUri(new String[] { IrisPath.EMERGENCY_NOTIFICATION_ENDPOINT_ORDERS, eneoId}), EmergencyNotificationEndpointOrderResponse.class);
    }

}
