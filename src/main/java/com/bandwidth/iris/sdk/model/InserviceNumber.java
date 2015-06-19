package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.TNs;

import java.util.Map;

/**
 * Created by sbarstow on 6/18/15.
 */
public class InserviceNumber {
    public static TNs list(IrisClient client, Map<String, Object> query) throws Exception{
        return client.get(client.buildUserModelUri(new String[] {
                IrisConstants.INSERVICE_NUMBERS_URI_PATH }, query), TNs.class);
    }
}
