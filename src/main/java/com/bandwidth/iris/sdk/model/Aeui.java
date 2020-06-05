package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import java.util.Map;

public class Aeui {

    public static AlternateEndUserIdentifiersResponse list(IrisClient client, Map<String, Object> query) throws Exception {
        return client.get(client.buildAccountModelUri(
                new String[] { IrisPath.AEUI }, query), AlternateEndUserIdentifiersResponse.class);
    }

    public static AlternateEndUserIdentifierResponse get(IrisClient client, String id) throws Exception {
        return client.get(client.buildAccountModelUri(
                new String[] { IrisPath.AEUI, id }), AlternateEndUserIdentifierResponse.class);
    }
}
