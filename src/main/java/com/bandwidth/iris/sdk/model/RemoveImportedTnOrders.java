package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class RemoveImportedTnOrders {

    @XmlElement(name = "TotalCount")
    private int totalCount;
    @XmlElement(name = "RemoveImportedTnOrderSummary")
    private List<RemoveImportedTnOrderSummary> removeImportedTnOrderSummaryList;
}
