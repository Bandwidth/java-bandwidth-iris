package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sbarstow on 6/18/15.
 */
@XmlRootElement(name="ListOrderIdUserIdDate")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListOrderIdUserIdDate {
    @XmlElement(name="OrderIdUserIdDate")
    private List<OrderIdUserIdDate> orderIdUserIdDateList = new ArrayList<OrderIdUserIdDate>();

    @XmlElement(name="TotalCount")
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
