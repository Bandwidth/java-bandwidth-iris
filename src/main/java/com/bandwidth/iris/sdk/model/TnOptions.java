package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import java.util.Map;

public class TnOptions {

    public static TnOptionOrderResponse create(IrisClient client, TnOptionOrder order) throws Exception {
        return client.post( client.buildAccountModelUri( new String[] { IrisPath.TN_OPTIONS} ), order, TnOptionOrderResponse.class);
    }

    public static TnOptionOrders list(IrisClient client, Map<String, Object> query) throws Exception {
        return client.get(client.buildAccountModelUri(
                new String[] { IrisPath.TN_OPTIONS}, query), TnOptionOrders.class);
    }

    public static TnOptionOrder get(IrisClient client, String orderId) throws Exception {
        return client.get(client.buildAccountModelUri(new String[] { IrisPath.TN_OPTIONS, orderId}), TnOptionOrder.class);
    }

}
