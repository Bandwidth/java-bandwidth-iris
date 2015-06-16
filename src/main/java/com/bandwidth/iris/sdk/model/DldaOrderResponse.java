package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sbarstow on 6/16/15.
 */
@XmlRootElement(name="DldaOrderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class DldaOrderResponse extends BaseResponse {
    @XmlElement(name="DldaOrder")
    private DldaOrder order;

    public DldaOrder getOrder() {
        return order;
    }

    public void setOrder(DldaOrder dldaOrder) {
        this.order = dldaOrder;
    }
}
