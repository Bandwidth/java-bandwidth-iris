package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisClientException;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.IrisResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;

/**
 * Created by sbarstow on 11/20/14.
 */
public class Tns {

    /**
     * @param client
     * @param tn
     * @return Fully populated TelephoneNumberDetails
     * @throws Exception
     */
    public static TelephoneNumberDetails getTnDetails(IrisClient client, String tn) throws Exception {
        IrisResponse irisResponse = client
                .get(client.buildModelUri(new String[] { IrisConstants.TNS_URI_PATH, tn, "tndetails" }));
        TelephoneNumberResponse telephoneNumberResponse = XmlUtils.fromXml(irisResponse.getResponseBody(),
                TelephoneNumberResponse.class);
        client.checkResponse(telephoneNumberResponse);
        return telephoneNumberResponse.getTelephoneNumberDetails();
    }

    /**
     * Status check for TN
     *
     * @param client
     * @param tn
     * @return
     * @throws Exception
     */
    public static TelephoneNumberResponse checkStatus(IrisClient client, String tn) throws Exception {
        IrisResponse irisResponse = client.get(client.buildModelUri(new String[] { IrisConstants.TNS_URI_PATH, tn }));
        //Have to manually parse for this error because of how it's returned
        if (irisResponse.getResponseBody().indexOf("ErrorResponse") != -1) {
            ErrorResponse errorResponse = XmlUtils.fromXml(irisResponse.getResponseBody(), ErrorResponse.class);
            throw new IrisClientException(errorResponse.getIrisStatus().getCode(),
                    errorResponse.getIrisStatus().getDescription());
        } else {
            return XmlUtils.fromXml(irisResponse.getResponseBody(), TelephoneNumberResponse.class);
        }
    }

    /**
     * @param client
     * @param tn
     * @return The associated site.  As of now assuming this is a single site as there is nothing in the response
     * to indicate that this could be an array
     * @throws Exception
     */
    public static Site getSite(IrisClient client, String tn) throws Exception {
        IrisResponse irisResponse = client.get(client.buildModelUri(new String[] { IrisConstants.TNS_URI_PATH, tn, "sites" }));
        return XmlUtils.fromXml(irisResponse.getResponseBody(), Site.class);
    }

    /**
     * @param client
     * @param tn
     * @return The associated SipPeer.  As of now assuming this is a single sip peer as there is nothing in the response
     * to indicate that this could be an array
     * @throws Exception
     */
    public static SipPeer getSipPeer(IrisClient client, String tn) throws Exception {
        IrisResponse irisResponse = client
                .get(client.buildModelUri(new String[] { IrisConstants.TNS_URI_PATH, tn, "sippeers" }));
        return XmlUtils.fromXml(irisResponse.getResponseBody(), SipPeer.class);
    }

    /**
     * @param client
     * @param tn
     * @return TelephoneNumberDetails with RateCenter and State elements populated ONLY
     * @throws Exception
     */
    public static TelephoneNumberDetails getRateCenter(IrisClient client, String tn) throws Exception {
        IrisResponse irisResponse = client
                .get(client.buildModelUri(new String[] { IrisConstants.TNS_URI_PATH, tn, "ratecenter" }));
        TelephoneNumberResponse telephoneNumberResponse = XmlUtils.fromXml(irisResponse.getResponseBody(),
                TelephoneNumberResponse.class);
        client.checkResponse(telephoneNumberResponse);
        return telephoneNumberResponse.getTelephoneNumberDetails();
    }

    /**
     * @param client
     * @param tn
     * @return TelephoneNumberDetails with Lata populated ONLY
     * @throws Exception
     */
    public static TelephoneNumberDetails getLata(IrisClient client, String tn) throws Exception {
        IrisResponse irisResponse = client.get(client.buildModelUri(new String[] { IrisConstants.TNS_URI_PATH, tn, "lata" }));
        TelephoneNumberResponse telephoneNumberResponse = XmlUtils.fromXml(irisResponse.getResponseBody(),
                TelephoneNumberResponse.class);
        client.checkResponse(telephoneNumberResponse);
        return telephoneNumberResponse.getTelephoneNumberDetails();
    }

}
