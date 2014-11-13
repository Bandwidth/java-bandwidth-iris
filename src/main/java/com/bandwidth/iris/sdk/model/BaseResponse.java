package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by sbarstow on 11/13/14.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseResponse {

    @XmlElement(name="ResponseStatus")
    private ResponseStatus responseStatus;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    protected boolean hasErrors(){
        return responseStatus != null;
    }
}
