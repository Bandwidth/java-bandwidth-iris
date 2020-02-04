package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class ImportTnOrders {

    @XmlElement(name = "TotalCount")
    private int totalCount;
    @XmlElement(name = "ImportTnOrderSummary")
    private List<ImportTnOrderSummary> importTnOrderSummaryList;

}
