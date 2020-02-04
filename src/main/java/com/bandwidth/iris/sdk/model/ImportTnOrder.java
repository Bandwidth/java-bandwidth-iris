package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.Map;

public class ImportTnOrder extends BaseModel {

    @XmlElement(name = "CustomerOrderId")
    private String customerOrderId;
    @XmlElement( name = "SiteId")
    private int siteId;
    @XmlElement( name = "SipPeer")
    private int sipPeer;
    @XmlElement(name = "Subscriber")
    private Subscriber subscriber;
    @XmlElement(name = "LoaAuthorizingPerson")
    private String loaAuthorizingPerson;
    @XmlElement(name = "TelephoneNumbers")
    private List<TelephoneNumber> telephoneNumberList;

    public static ImportTnOrderResponse Create(IrisClient client, ImportTnOrder order) throws Exception {
        return client.post( client.buildAccountModelUri( new String[] { IrisPath.IMPORT_TN_ORDERS } ), order, ImportTnOrderResponse.class);
    }

    public static ImportTnOrders List(IrisClient client, Map<String, Object> query)  throws Exception {
        return client.get( client.buildAccountModelUri( new String[] { IrisPath.IMPORT_TN_ORDERS }, query), ImportTnOrders.class);
    }

    public static ImportTnOrder Get(IrisClient client, String orderId) throws Exception {
        return client.get( client.buildAccountModelUri( new String[] {IrisPath.IMPORT_TN_ORDERS, orderId } ), ImportTnOrder.class);
    }

    public static OrderHistoryWrapper GetHistory( IrisClient client, String orderId ) throws Exception {
        return client.get( client.buildAccountModelUri( new String[] {IrisPath.IMPORT_TN_ORDERS, orderId, "history" } ), OrderHistoryWrapper.class);
    }
}
