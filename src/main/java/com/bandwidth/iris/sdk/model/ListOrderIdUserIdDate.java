package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ListOrderIdUserIdDate")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListOrderIdUserIdDate {
    @XmlElement(name = "OrderIdUserIdDate")
    private List<OrderIdUserIdDate> orderIdUserIdDateList = new ArrayList<OrderIdUserIdDate>();

    @XmlElement(name = "TotalCount")
    private int totalCount;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<OrderIdUserIdDate> getOrderIdUserIdDateList() {
        return orderIdUserIdDateList;
    }

    public void setOrderIdUserIdDateList(List<OrderIdUserIdDate> orderIdUserIdDateList) {
        this.orderIdUserIdDateList = orderIdUserIdDateList;
    }
}
