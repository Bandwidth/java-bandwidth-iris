package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.IrisResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sbarstow on 11/17/14.
 */
public class LnpChecker {

    public static NumberPortabilityResponse checkLnp(IrisClient client,
            NumberPortabilityRequest request, String fullCheck) throws Exception {

        Map<String, Object> query = new HashMap<String, Object>();
        query.put("fullCheck", fullCheck);
        NumberPortabilityResponse numberPortabilityResponse = client.post(client.buildUserModelUri(
                IrisConstants.LNPCHECKER_URI_PATH, query), request, NumberPortabilityResponse.class);
        return numberPortabilityResponse;
    }

}
