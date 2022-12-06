package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name="ImportTnCheckerPayload")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportTnCheckerPayload extends BaseModel {

    @XmlElement( name = "SiteId")
    private int siteId;

    @XmlElement( name = "SipPeer")
    private int sipPeer;

    @XmlElementWrapper(name = "TelephoneNumbers")
    @XmlElement(name = "TelephoneNumber")
    private List<String> telephoneNumberList;

    @XmlElementWrapper(name = "ImportTnErrors")
    @XmlElement(name ="ImportTnError")
    private List<ImportTnError> importTnErrorList;

    public List<String> getTelephoneNumberList() {
        return telephoneNumberList;
    }

    public void setTelephoneNumberList(List<String> telephoneNumberList) {
        this.telephoneNumberList = telephoneNumberList;
    }

    public List<ImportTnError> getImportTnErrorList() {
        return importTnErrorList;
    }

    public void setImportTnErrorList(List<ImportTnError> importTnErrorList) {
        this.importTnErrorList = importTnErrorList;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getSipPeer() {
        return sipPeer;
    }

    public void setSipPeer(int sipPeer) {
        this.sipPeer = sipPeer;
    }
}
