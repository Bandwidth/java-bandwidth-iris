package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import jakarta.xml.bind.annotation.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "LnpOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class LnpOrder extends BaseModel {

    @XmlElement(name = "OrderId")
    private String orderId;
    @XmlElement(name = "BillingTelephoneNumber")
    private String billingTelephoneNumber;
    @XmlElement(name = "Subscriber")
    private Subscriber subscriber;
    @XmlElement(name = "LoaAuthorizingPerson")
    private String loaAuthorizingPerson;
    @XmlElementWrapper(name = "ListOfPhoneNumbers")
    @XmlElement(name = "PhoneNumber")
    private List<String> listOfPhoneNumbers = new ArrayList<String>();
    @XmlElement(name = "SiteId")
    private String siteId;
    @XmlElement(name = "CustomerOrderId")
    private String customerOrderId;
    @XmlElement(name = "RequestedFocDate")
    private Date requestedFocDate;
    @XmlElement(name = "AlternateSpid")
    private String alternateSpid;
    @XmlElement(name = "PeerId")
    private String peerId;
    @XmlElement(name = "PartialPort")
    private boolean partialPort;
    @XmlElement(name = "WirelessInfo")
    private WirelessInfo wirelessInfo;

    public static LnpOrderResponse create(IrisClient client, LnpOrder order) throws Exception {
        LnpOrderResponse lnpOrderResponse = client.post(client.buildAccountModelUri(new String[] { IrisPath.LNP_URI_PATH }),
                order, LnpOrderResponse.class);
        lnpOrderResponse.setClient(client);
        return lnpOrderResponse;
    }

    public static LnpOrderResponse get(IrisClient client, String orderId) throws Exception {
        LnpOrderResponse lnpOrderResponse = client.get(client.buildAccountModelUri(new String[] { IrisPath.LNP_URI_PATH,
                orderId }), LnpOrderResponse.class);
        lnpOrderResponse.setClient(client);
        lnpOrderResponse.setOrderId(orderId);
        return lnpOrderResponse;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBillingTelephoneNumber() {
        return billingTelephoneNumber;
    }

    public void setBillingTelephoneNumber(String billingTelephoneNumber) {
        this.billingTelephoneNumber = billingTelephoneNumber;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public String getLoaAuthorizingPerson() {
        return loaAuthorizingPerson;
    }

    public void setLoaAuthorizingPerson(String loaAuthorizingPerson) {
        this.loaAuthorizingPerson = loaAuthorizingPerson;
    }

    public List<String> getListOfPhoneNumbers() {
        return listOfPhoneNumbers;
    }

    public void setListOfPhoneNumbers(List<String> listOfPhoneNumbers) {
        this.listOfPhoneNumbers = listOfPhoneNumbers;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Date getRequestedFocDate() {
        return requestedFocDate;
    }

    public void setRequestedFocDate(Date requestedFocDate) {
        this.requestedFocDate = requestedFocDate;
    }

    public String getAlternateSpid() {
        return alternateSpid;
    }

    public void setAlternateSpid(String alternateSpid) {
        this.alternateSpid = alternateSpid;
    }

    public String getPeerId() {
        return peerId;
    }

    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    public boolean isPartialPort() {
        return partialPort;
    }

    public void setPartialPort(boolean partialPort) {
        this.partialPort = partialPort;
    }

    public WirelessInfo getWirelessInfo() {
        return wirelessInfo;
    }

    public void setWirelessInfo(WirelessInfo wirelessInfo) {
        this.wirelessInfo = wirelessInfo;
    }

    public void uploadLoa(File file, LoaFileType fileType) throws Exception {
        client.postFile(client.buildAccountModelUri(new String[] { IrisPath.LNP_URI_PATH, orderId, "loas" }),
                file, fileType.toString());
    }

    public void updateLoa(File file, LoaFileType fileType) throws Exception {
        client.putFile(client.buildAccountModelUri(new String[] { IrisPath.LNP_URI_PATH,
                orderId, "loas", file.getName() }), file, fileType.toString());
    }

    public void deleteLoa(String fileName) throws Exception {
        client.delete(client.buildAccountModelUri(new String[] { IrisPath.LNP_URI_PATH, orderId, "loas", fileName }));
    }

    public FileMetaData getLoaMetaData(String fileName) throws Exception {
        return client.get(client.buildAccountModelUri(new String[] { IrisPath.LNP_URI_PATH, orderId,
                "loas", fileName, "metadata" }), FileMetaData.class);
    }

    public void updateLoaMetaData(String fileName, FileMetaData metaData) throws Exception {
        client.put(client.buildAccountModelUri(new String[] { IrisPath.LNP_URI_PATH, orderId,
                "loas", fileName, "metadata" }), metaData);
    }

    public void deleteLoaMetaData(String fileName) throws Exception {
        client.delete(client.buildAccountModelUri(
                new String[] { IrisPath.LNP_URI_PATH, orderId, "loas", fileName, "metadata" }));
    }

    public LnpOrderResponse update(LnpOrderSupp orderSupp) throws Exception {
        return client.put(client.buildAccountModelUri(new String[] { IrisPath.LNP_URI_PATH, orderId }),
                orderSupp, LnpOrderResponse.class);
    }

    public void delete() throws Exception {
        client.delete(client.buildAccountModelUri(new String[] { IrisPath.LNP_URI_PATH, orderId }));
    }

    public ActivationStatusResponse getActivationStatus() throws Exception {
        return client.get(client.buildAccountModelUri(new String[]
                { IrisPath.LNP_URI_PATH, orderId, "activationStatus" }), ActivationStatusResponse.class);
    }

    public ActivationStatusResponse setActivationStatus(ActivationStatus status) throws Exception {
        return client.put(client.buildAccountModelUri(new String[]
                { IrisPath.LNP_URI_PATH, orderId, "activationStatus" }), status, ActivationStatusResponse.class);
    }
}
