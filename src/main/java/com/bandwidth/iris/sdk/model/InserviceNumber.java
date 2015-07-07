package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import java.util.Map;

public class InserviceNumber {
    public static TNss list(IrisClient client, Map<String, Object> query) throws Exception {
        return client.get(client.buildAccountModelUri(new String[] {
                IrisPath.INSERVICE_NUMBERS_URI_PATH }, query), TNss.class);
    }
}
