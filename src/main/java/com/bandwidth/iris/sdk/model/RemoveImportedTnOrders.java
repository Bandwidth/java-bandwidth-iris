package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="RemoveImportedTnOrders")
@XmlAccessorType(XmlAccessType.FIELD)
public class RemoveImportedTnOrders {

    @XmlElement(name = "TotalCount")
    private int totalCount;
    @XmlElement(name = "RemoveImportedTnOrderSummary")
    private List<RemoveImportedTnOrderSummary> removeImportedTnOrderSummaryList;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<RemoveImportedTnOrderSummary> getRemoveImportedTnOrderSummaryList() {
        return removeImportedTnOrderSummaryList;
    }

    public void setRemoveImportedTnOrderSummaryList(List<RemoveImportedTnOrderSummary> removeImportedTnOrderSummaryList) {
        this.removeImportedTnOrderSummaryList = removeImportedTnOrderSummaryList;
    }
}
