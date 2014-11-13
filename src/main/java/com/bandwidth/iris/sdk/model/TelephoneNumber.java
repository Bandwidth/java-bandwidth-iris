package com.bandwidth.iris.sdk.model;


import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisClientException;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.IrisResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "TelephoneNumber")
@XmlAccessorType(XmlAccessType.FIELD)
public class TelephoneNumber {

    private static final Logger LOG = Logger.getLogger(TelephoneNumber.class);

    public static List<?> getAvailableNumbers(IrisClient client, Map<String,Object> query, boolean returnDetails) throws IrisClientException {
        List<?> numbersList = new ArrayList<TelephoneNumber>();
        SearchResult result = null;
        try {
            String searchUri = client.buildModelUri(new String[]{IrisConstants.AVAILABLE_NUMBERS_URI_PATH}, query);
            IrisResponse response = client.get(searchUri);
            result = (SearchResult) XmlUtils.fromXml(response.getResponseBody(), SearchResult.class);
            numbersList = returnDetails ? result.getTelephoneNumberDetailList() :
                    result.getTelephoneNumberList();
        }catch(Exception e){
            LOG.error("Error in getAvailableNumbers: " + e.getMessage());
            throw new IrisClientException(e);
        }
        return numbersList;
    }

//    private static String buildSearchUri(String searchUri, TelephoneNumberSearchFilters filters)throws URISyntaxException {
//        URIBuilder builder = new URIBuilder(searchUri);
//        if(!StringUtils.isEmpty(filters.getInAreaCode())){
//            builder.addParameter("areaCode", filters.getInAreaCode());
//        }
//        builder.addParameter("enableTNDetail", String.valueOf(filters.isReturnTelephoneNumberDetails()));
//        builder.addParameter("quantity", String.valueOf(filters.getQuantity()));
//
//        LOG.debug("building uri: " + builder.build().toString());
//        return builder.build().toString();
//    }



    @XmlElement(name = "FullNumber")
    protected String fullNumber;

    public TelephoneNumber() {
    }

    public String getFullNumber() {
        return fullNumber;
    }

    public void setFullNumber(String fullNumber) {
        this.fullNumber = fullNumber;
    }
}


