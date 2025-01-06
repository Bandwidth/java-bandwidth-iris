package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "DldaOrderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class DldaOrderResponse extends BaseResponse {
    @XmlElement(name = "DldaOrder")
    private DldaOrder order;

    public DldaOrder getOrder() {
        return order;
    }

    public void setOrder(DldaOrder dldaOrder) {
        this.order = dldaOrder;
    }
}
