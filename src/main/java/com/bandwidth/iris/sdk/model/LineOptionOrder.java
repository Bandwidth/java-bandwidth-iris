package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 6/16/15.
 */
@XmlRootElement(name="LineOptionOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineOptionOrder {
    @XmlElement(name="TnLineOptions")
    private List<TnLineOptions> lineOptions = new ArrayList<TnLineOptions>();

    public List<TnLineOptions> getLineOptions() {
        return lineOptions;
    }

    public void setLineOptions(List<TnLineOptions> lineOptions) {
        this.lineOptions = lineOptions;
    }
}


