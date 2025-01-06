package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;

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

    @XmlElement(name = "ResponseStatus")
    private ResponseStatus responseStatus;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
