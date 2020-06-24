package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "TnOptionOrderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class TnOptionOrderResponse extends BaseModel {

    @XmlElement(name = "TnOptionOrder")
    private TnOptionOrder tnOptionOrder;

    public TnOptionOrder getTnOptionOrder() {
        return tnOptionOrder;
    }

    public void setTnOptionOrder(TnOptionOrder tnOptionOrder) {
        this.tnOptionOrder = tnOptionOrder;
    }
}
