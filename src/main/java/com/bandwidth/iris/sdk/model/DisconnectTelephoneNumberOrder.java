package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.IrisResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 10/17/14.
 */
@XmlRootElement(name = "DisconnectTelephoneNumberOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class DisconnectTelephoneNumberOrder extends BaseModel {

    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "DisconnectTelephoneNumberOrderType")
    private DisconnectTelephoneNumberOrderType disconnectTelephoneNumberOrderType;

    public static DisconnectTelephoneNumberOrderResponse create(IrisClient client,
            DisconnectTelephoneNumberOrder disconnectTelephoneNumberOrder)
            throws Exception {
        IrisResponse response = client.post(client.buildUserModelUri(
                new String[] { IrisConstants.DISCONNECTS_URI_PATH }), disconnectTelephoneNumberOrder);
        DisconnectTelephoneNumberOrderResponse orderResponse = XmlUtils.fromXml(response.getResponseBody(),
                DisconnectTelephoneNumberOrderResponse.class);
        client.checkResponse(orderResponse);
        return orderResponse;
    }

    public static DisconnectTelephoneNumberOrderResponse get(IrisClient client, String orderId) throws Exception {
        IrisResponse response = client.get(client.buildUserModelUri(
                new String[] { IrisConstants.DISCONNECTS_URI_PATH, orderId }));
        DisconnectTelephoneNumberOrderResponse orderResponse = XmlUtils.fromXml(response.getResponseBody(),
                DisconnectTelephoneNumberOrderResponse.class);
        client.checkResponse(orderResponse);
        return orderResponse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DisconnectTelephoneNumberOrderType getDisconnectTelephoneNumberOrderType() {
        return disconnectTelephoneNumberOrderType;
    }

    public void setDisconnectTelephoneNumberOrderType(DisconnectTelephoneNumberOrderType
            disconnectTelephoneNumberOrderType) {
        this.disconnectTelephoneNumberOrderType = disconnectTelephoneNumberOrderType;
    }
}
