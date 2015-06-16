package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.IrisResponse;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sbarstow on 6/16/15.
 */
@XmlRootElement(name="DldaOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class DldaOrder extends BaseModel {
    @XmlElement(name="CustomerOrderId")
    private String customerOrderId;

    @XmlElement(name="OrderCreatedDate")
    private Date orderCreatedDate;

    @XmlElement(name="AccountId")
    private String accountId;

    @XmlElement(name="CreatedByUser")
    private String createdByUser;


    @XmlElement(name="OrderId")
    private String orderId;

    @XmlElement(name="LastModifiedDate")
    private Date lastModifiedDate;

    @XmlElement(name="ProcessingStatus")
    private String processingStatus;

    @XmlElementWrapper(name="ErrorList")
    @XmlElement(name="Error")
    private List<Error> errors = new ArrayList<Error>();

    @XmlElementWrapper(name="DldaTnGroups")
    @XmlElement(name="DldaTnGroup")
    private DldaTnGroup dldaTnGroup;

    public static DldaOrder create(IrisClient client, DldaOrder order) throws Exception {
        IrisResponse response = client.post(client.buildUserModelUri(new String[] { IrisConstants.DLDA_ORDER_PATH }), order);
        String id = client.getIdFromLocationHeader(response.getHeaders().get("Location"));
        return get(client, id);
    }

    public static DldaOrder get(IrisClient client, String orderId) throws Exception {
        DldaOrderResponse orderResponse = client.get(client.buildUserModelUri(
                new String[] { IrisConstants.DLDA_ORDER_PATH, orderId }), DldaOrderResponse.class);
        DldaOrder order = orderResponse.getOrder();
        order.setClient(client);
        return order;
    }


    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
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

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
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

    public DldaTnGroup getDldaTnGroup() {
        return dldaTnGroup;
    }

    public void setDldaTnGroup(DldaTnGroup dldaTnGroup) {
        this.dldaTnGroup = dldaTnGroup;
    }
}
