package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LineOptionOrderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineOptionOrderResponse {
    @XmlElement(name = "LineOptions")
    private LineOptions lineOptions;

    public LineOptions getLineOptions() {
        return lineOptions;
    }

    public void setLineOptions(LineOptions lineOptions) {
        this.lineOptions = lineOptions;
    }
}
