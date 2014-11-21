package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.IrisResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sbarstow on 11/19/14.
 */
public class AvailableNumbers {
    public static List<?> search(IrisClient client, Map<String, Object> query) throws Exception {
        List<?> numbersList = new ArrayList<TelephoneNumber>();
        boolean returnDetails = query.get("enableTNDetail") != null ?
                Boolean.valueOf(query.get("enableTNDetail").toString()) : false;
        String searchUri = client.buildUserModelUri(new String[] { IrisConstants.AVAILABLE_NUMBERS_URI_PATH }, query);
        SearchResult result = client.get(searchUri, SearchResult.class);
        numbersList = returnDetails ? result.getTelephoneNumberDetailList() :
                result.getTelephoneNumberList();
        return numbersList;
    }

}
