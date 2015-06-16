package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 6/16/15.
 */
@XmlRootElement(name="LineOptionOrderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineOptionOrderResponse {
    @XmlElement(name="LineOptions")
    private LineOptions lineOptions;

    public LineOptions getLineOptions() {
        return lineOptions;
    }

    public void setLineOptions(LineOptions lineOptions) {
        this.lineOptions = lineOptions;
    }
}
