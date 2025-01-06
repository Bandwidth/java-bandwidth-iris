package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;
import com.bandwidth.iris.sdk.IrisResponse;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "LidbOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class LidbOrder extends BaseModel {
    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "OrderCreatedDate")
    private Date orderCreatedDate;

    @XmlElement(name = "AccountId")
    private String accountId;

    @XmlElement(name = "OrderId")
    private String orderId;

    @XmlElement(name = "LastModifiedDate")
    private Date lastModifiedDate;

    @XmlElement(name = "ProcessingStatus")
    private String processingStatus;

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    private List<Error> errors = new ArrayList<Error>();

    @XmlElementWrapper(name = "LidbTnGroups")
    @XmlElement(name = "LidbTnGroup")
    private List<LidbTnGroup> lidbTnGroupList = new ArrayList<LidbTnGroup>();

    public static LidbOrder create(IrisClient client, LidbOrder order) throws Exception {
        IrisResponse response = client.post(client.buildAccountModelUri(new String[] { IrisPath.LIDB_ORDER_URI_PATH }), order);
        String id = client.getIdFromLocationHeader(response.getHeaders().get("Location"));
        return get(client, id);
    }

    public static LidbOrder get(IrisClient client, String orderId) throws Exception {
        LidbOrder order = client.get(client.buildAccountModelUri(
                new String[] { IrisPath.LIDB_ORDER_URI_PATH, orderId }), LidbOrder.class);
        order.setClient(client);
        return order;
    }

    public List<LidbTnGroup> getLidbTnGroupList() {
        return lidbTnGroupList;
    }

    public void setLidbTnGroupList(List<LidbTnGroup> lidbTnGroupList) {
        this.lidbTnGroupList = lidbTnGroupList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrderCreatedDate() {
        return orderCreatedDate;
    }

    public void setOrderCreatedDate(Date orderCreatedDate) {
        this.orderCreatedDate = orderCreatedDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
