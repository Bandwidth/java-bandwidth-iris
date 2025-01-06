package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DisconnectTelephoneNumberOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class DisconnectTelephoneNumberOrder extends BaseModel {

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "CustomerOrderId")
    private String customerOrderid;

    @XmlElement(name = "DisconnectTelephoneNumberOrderType")
    private DisconnectTelephoneNumberOrderType disconnectTelephoneNumberOrderType;

    public static DisconnectTelephoneNumberOrderResponse create(IrisClient client,
            DisconnectTelephoneNumberOrder disconnectTelephoneNumberOrder)
            throws Exception {
        return client.post(client.buildAccountModelUri(
                        new String[] { IrisPath.DISCONNECTS_URI_PATH }), disconnectTelephoneNumberOrder,
                DisconnectTelephoneNumberOrderResponse.class);
    }

    public static DisconnectTelephoneNumberOrderResponse get(IrisClient client, String orderId) throws Exception {
        return client.get(client.buildAccountModelUri(
                new String[] { IrisPath.DISCONNECTS_URI_PATH, orderId }), DisconnectTelephoneNumberOrderResponse.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerOrderid() {
        return customerOrderid;
    }

    public void setCustomerOrderid(String customerOrderid) {
        this.customerOrderid = customerOrderid;
    }

    public DisconnectTelephoneNumberOrderType getDisconnectTelephoneNumberOrderType() {
        return disconnectTelephoneNumberOrderType;
    }

    public void setDisconnectTelephoneNumberOrderType(DisconnectTelephoneNumberOrderType
            disconnectTelephoneNumberOrderType) {
        this.disconnectTelephoneNumberOrderType = disconnectTelephoneNumberOrderType;
    }
}
