package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="ImportTnOrders")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportTnOrders {

    @XmlElement(name = "TotalCount")
    private int totalCount;
    @XmlElement(name = "ImportTnOrderSummary")
    private List<ImportTnOrderSummary> importTnOrderSummaryList;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<ImportTnOrderSummary> getImportTnOrderSummaryList() {
        return importTnOrderSummaryList;
    }

    public void setImportTnOrderSummaryList(List<ImportTnOrderSummary> importTnOrderSummaryList) {
        this.importTnOrderSummaryList = importTnOrderSummaryList;
    }
}
