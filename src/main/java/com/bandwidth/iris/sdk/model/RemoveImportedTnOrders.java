package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
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
