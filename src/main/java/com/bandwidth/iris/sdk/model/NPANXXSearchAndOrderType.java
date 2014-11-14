package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 11/14/14.
 */
@XmlRootElement(name="NPANXXSearchAndOrderType")
@XmlAccessorType(XmlAccessType.FIELD)
public class NPANXXSearchAndOrderType extends BaseOrderType {
    @XmlElement(name="NpaNxx")
    private String npaNxx;

    @XmlElement(name="EnableTNDetail")
    private boolean enableTNDetail;

    @XmlElement(name="EnableLCA")
    private boolean enableLCA;

    public String getNpaNxx() {
        return npaNxx;
    }

    public void setNpaNxx(String npaNxx) {
        this.npaNxx = npaNxx;
    }

    public boolean isEnableTNDetail() {
        return enableTNDetail;
    }

    public void setEnableTNDetail(boolean enableTNDetail) {
        this.enableTNDetail = enableTNDetail;
    }

    public boolean isEnableLCA() {
        return enableLCA;
    }

    public void setEnableLCA(boolean enableLCA) {
        this.enableLCA = enableLCA;
    }
}
