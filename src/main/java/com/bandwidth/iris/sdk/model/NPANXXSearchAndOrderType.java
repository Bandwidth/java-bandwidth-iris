package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "NPANXXSearchAndOrderType")
@XmlAccessorType(XmlAccessType.FIELD)
public class NPANXXSearchAndOrderType extends BaseOrderType {
    @XmlElement(name = "NpaNxx")
    private String npaNxx;

    @XmlElement(name = "EnableTNDetail")
    private boolean enableTNDetail;

    @XmlElement(name = "EnableLCA")
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
