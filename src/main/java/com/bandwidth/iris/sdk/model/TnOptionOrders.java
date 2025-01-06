package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "TnOptionOrders")
@XmlAccessorType(XmlAccessType.FIELD)
public class TnOptionOrders extends BaseModel {

    @XmlElement(name = "TotalCount")
    private Integer totalCount;

    @XmlElement(name = "TnOptionOrder")
    private List<TnOptionOrder> TnOptionOrders;

    @XmlElement(name = "TnOptionOrderSummary")
    private List<TnOptionOrderSummary> TnOptionOrderSummarys;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<TnOptionOrder> getTnOptionOrders() {
        return TnOptionOrders;
    }

    public void setTnOptionOrders(List<TnOptionOrder> tnOptionOrders) {
        TnOptionOrders = tnOptionOrders;
    }

    public List<TnOptionOrderSummary> getTnOptionOrderSummarys() {
        return TnOptionOrderSummarys;
    }

    public void setTnOptionOrderSummarys(List<TnOptionOrderSummary> tnOptionOrderSummarys) {
        TnOptionOrderSummarys = tnOptionOrderSummarys;
    }
}
