package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "DisconnectTelephoneNumberOrderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class DisconnectTelephoneNumberOrderResponse extends BaseResponse {
    @XmlElement(name = "orderRequest")
    private OrderRequest orderRequest;

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    private List<Error> errorList = new ArrayList<Error>();

    @XmlElement(name = "OrderStatus")
    private String orderStatus;

    public OrderRequest getorderRequest() {
        return orderRequest;
    }

    public void setorderRequest(OrderRequest orderRequest) {
        this.orderRequest = orderRequest;
    }

    public List<Error> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Error> errorList) {
        this.errorList = errorList;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}

