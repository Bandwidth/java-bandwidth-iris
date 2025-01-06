package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;
import com.bandwidth.iris.sdk.IrisResponse;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "DldaOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class DldaOrder extends BaseModel {
    @XmlElement(name = "CustomerOrderId")
    private String customerOrderId;

    @XmlElement(name = "OrderCreatedDate")
    private Date orderCreatedDate;

    @XmlElement(name = "AccountId")
    private String accountId;

    @XmlElement(name = "CreatedByUser")
    private String createdByUser;

    @XmlElement(name = "OrderId")
    private String orderId;

    @XmlElement(name = "LastModifiedDate")
    private Date lastModifiedDate;

    @XmlElement(name = "ProcessingStatus")
    private String processingStatus;

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    private List<Error> errors = new ArrayList<Error>();

    @XmlElementWrapper(name = "DldaTnGroups")
    @XmlElement(name = "DldaTnGroup")
    private List<DldaTnGroup> dldaTnGroups = new ArrayList<DldaTnGroup>();

    public static DldaOrder create(IrisClient client, DldaOrder order) throws Exception {
        IrisResponse response = client.post(client.buildAccountModelUri(new String[] { IrisPath.DLDA_ORDER_URI_PATH }), order);
        String id = client.getIdFromLocationHeader(response.getHeaders().get("Location"));
        return get(client, id);
    }

    public static DldaOrder get(IrisClient client, String orderId) throws Exception {
        DldaOrder order = client.get(client.buildAccountModelUri(
                new String[] { IrisPath.DLDA_ORDER_URI_PATH, orderId }), DldaOrder.class);
        order.setClient(client);
        return order;
    }

    public static ResponseSelectWrapper list(IrisClient client, Map<String, Object> query) throws Exception {
        ResponseSelectWrapper response = client.get(client.buildAccountModelUri(
                new String[] { IrisPath.DLDA_ORDER_URI_PATH }, query), ResponseSelectWrapper.class);
        return response;
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

    public List<DldaTnGroup> getDldaTnGroups() {
        return dldaTnGroups;
    }

    public void setDldaTnGroups(List<DldaTnGroup> dldaTnGroups) {
        this.dldaTnGroups = dldaTnGroups;
    }
}
