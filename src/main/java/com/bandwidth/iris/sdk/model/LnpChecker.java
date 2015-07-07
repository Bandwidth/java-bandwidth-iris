package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import java.util.HashMap;
import java.util.Map;

public class LnpChecker {

    public static NumberPortabilityResponse checkLnp(IrisClient client,
            NumberPortabilityRequest request, String fullCheck) throws Exception {

        Map<String, Object> query = new HashMap<String, Object>();
        query.put("fullCheck", fullCheck);
        NumberPortabilityResponse numberPortabilityResponse = client.post(client.buildAccountModelUri(
                IrisPath.LNPCHECKER_URI_PATH, query), request, NumberPortabilityResponse.class);
        return numberPortabilityResponse;
    }

}
