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
            NumberPortabilityRequest request, boolean fullCheck) throws Exception {

        Map<String, Object> query = new HashMap<String, Object>();
        query.put("fullCheck", fullCheck);

        IrisResponse irisResponse = client.post(client.buildModelUri(IrisConstants.LNPCHECKER_URI_PATH, query), request);
        NumberPortabilityResponse numberPortabilityResponse = (NumberPortabilityResponse) XmlUtils.fromXml(
                irisResponse.getResponseBody(),NumberPortabilityResponse.class);
        client.checkResponse(numberPortabilityResponse);
        return numberPortabilityResponse;
    }

}
