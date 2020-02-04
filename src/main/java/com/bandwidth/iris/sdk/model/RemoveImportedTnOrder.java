package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;
import java.util.Map;

public class RemoveImportedTnOrder extends BaseModel{

    @XmlElement(name = "CustomerOrderId")
    private String customerOrderId;
    @XmlElement(name = "OrderCreateDate")
    private String orderCreateDate;
    @XmlElement(name= "AccountId")
    private String accountId;
    @XmlElement(name = "CreateByUser")
    private String createByUser;
    @XmlElement(name = "OrderId")
    private String orderId;
    @XmlElement(name = "LastModifiedDate")
    private String lastModifiedDate;
    @XmlElementWrapper(name = "TelephoneNumbers")
    private List<TelephoneNumber> telephoneNumberList;
    @XmlElement(name = "ProcessingStatus")
    private String processingStatus;

    public static RemoveImportedTnOrderResponse Create(IrisClient client, RemoveImportedTnOrder order) throws  Exception{
        return client.post( client.buildAccountModelUri(new String[] {IrisPath.REMOVE_IMPORTED_TN_ORDERS} ), order, RemoveImportedTnOrderResponse.class);
    }

    public static RemoveImportedTnOrders List(IrisClient client, Map<String, Object> query) throws Exception {
        return client.get( client.buildAccountModelUri(new String[] {IrisPath.REMOVE_IMPORTED_TN_ORDERS} , query), RemoveImportedTnOrders.class);
    }

    public static RemoveImportedTnOrder Get(IrisClient client, String orderId) throws Exception {
        return client.get( client.buildAccountModelUri(new String[] {IrisPath.REMOVE_IMPORTED_TN_ORDERS, orderId} ), RemoveImportedTnOrder.class);
    }

    public static OrderHistoryWrapper GetHistory(IrisClient client, String orderId) throws Exception {
        return client.get( client.buildAccountModelUri(new String[] {IrisPath.REMOVE_IMPORTED_TN_ORDERS, orderId, "history"} ), OrderHistoryWrapper.class);
    }



}
