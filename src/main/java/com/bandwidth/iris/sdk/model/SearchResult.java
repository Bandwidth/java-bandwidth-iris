package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The root entity returned by IRIS for a local or toll-free number search.
 * <p>
 * If number details were desired (only works for local queries),
 * {@link #telephoneNumberDetailList} will be populated and
 * {@link #telephoneNumberList} will be empty.
 * <p>
 * If details were not desired, the plain list of numbers can be found in
 * {@link #telephoneNumberList} and {@link #telephoneNumberDetailList} will be
 * empty.
 */
@XmlRootElement(name = "SearchResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchResult {

    @XmlElement(name = "Error")
    private Error error;

    @XmlElement(name = "ResultCount")
    private Integer resultCount;

    @XmlElementWrapper(name = "TelephoneNumberList")
    @XmlElement(name = "TelephoneNumber")
    private List<String> telephoneNumberList = new ArrayList<String>();

    @XmlElementWrapper(name = "TelephoneNumberDetailList")
    @XmlElement(name = "TelephoneNumberDetail")
    private List<TelephoneNumberDetail> telephoneNumberDetailList = new ArrayList<TelephoneNumberDetail>();

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public List<String> getTelephoneNumberList() {
        return telephoneNumberList;
    }

    public void setTelephoneNumberList(List<String> telephoneNumberList) {
        this.telephoneNumberList = telephoneNumberList;
    }

    public List<TelephoneNumberDetail> getTelephoneNumberDetailList() {
        return telephoneNumberDetailList;
    }

    public void setTelephoneNumberDetailList(List<TelephoneNumberDetail> telephoneNumberDetailList) {
        this.telephoneNumberDetailList = telephoneNumberDetailList;
    }
}
