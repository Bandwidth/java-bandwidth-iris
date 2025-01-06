package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import jakarta.xml.bind.annotation.*;

import java.io.File;
import java.util.List;
import java.util.Map;

@XmlRootElement(name="ImportTnOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportTnOrder extends BaseModel {

    @XmlElement(name = "CustomerOrderId")
    private String customerOrderId;

    @XmlElement(name = "OrderCreateDate")
    private String orderCreateDate;

    @XmlElement(name = "AccountId")
    private String accountId;

    @XmlElement(name = "CreatedByUser")
    private String createdByUser;

    @XmlElement(name = "OrderId")
    private String orderId;

    @XmlElement(name = "LastModifiedDate")
    private String lastModifiedDate;

    @XmlElement( name = "SiteId")
    private int siteId;

    @XmlElement( name = "SipPeer")
    private int sipPeer;

    @XmlElement(name = "Subscriber")
    private Subscriber subscriber;

    @XmlElement(name = "LoaAuthorizingPerson")
    private String loaAuthorizingPerson;

    @XmlElementWrapper(name = "TelephoneNumbers")
    @XmlElement(name = "TelephoneNumber")
    private List<String> telephoneNumberList;

    @XmlElement(name="ProcessingStatus")
    private String processingStatus;

    @XmlElementWrapper(name = "Errors")
    @XmlElement(name = "Error")
    private List<Error> errors;

    public static ImportTnOrdersResponse Create(IrisClient client, ImportTnOrder order) throws Exception {
        return client.post( client.buildAccountModelUri( new String[] { IrisPath.IMPORT_TN_ORDERS } ), order, ImportTnOrdersResponse.class);
    }

    public static ImportTnOrders List(IrisClient client, Map<String, Object> query)  throws Exception {
        return client.get( client.buildAccountModelUri( new String[] { IrisPath.IMPORT_TN_ORDERS }, query), ImportTnOrders.class);
    }

    public static ImportTnOrder Get(IrisClient client, String orderId) throws Exception {
        return client.get( client.buildAccountModelUri( new String[] {IrisPath.IMPORT_TN_ORDERS, orderId } ), ImportTnOrder.class);
    }

    public static OrderHistoryWrapper GetHistory( IrisClient client, String orderId ) throws Exception {
        return client.get( client.buildAccountModelUri( new String[] {IrisPath.IMPORT_TN_ORDERS, orderId, "history" } ), OrderHistoryWrapper.class);
    }

    public static FileListResponse GetLoas( IrisClient client, String orderId ) throws Exception {
        return client.get( client.buildAccountModelUri( new String[] {IrisPath.IMPORT_TN_ORDERS, orderId, IrisPath.LOAS } ), FileListResponse.class);
    }

    public static void UploadLoasFile(IrisClient client, String orderId, File file, String contentType ) throws Exception {
        client.postFile( client.buildAccountModelUri( new String[] {IrisPath.IMPORT_TN_ORDERS, orderId, IrisPath.LOAS } ), file, contentType);
    }

    public static byte[] GetLoasFile(IrisClient client, String orderId, String loasId ) throws Exception {
        return client.getFile( client.buildAccountModelUri( new String[] {IrisPath.IMPORT_TN_ORDERS, orderId, IrisPath.LOAS, loasId } ) );
    }

    public static void ReplaceLoasFile(IrisClient client, String orderId, String fileid, File file, String contentType ) throws Exception {
        client.putFile( client.buildAccountModelUri( new String[] {IrisPath.IMPORT_TN_ORDERS, orderId, IrisPath.LOAS, fileid } ), file, contentType);
    }

    public static void DeleteLoasFile( IrisClient client, String orderId, String fileid ) throws Exception {
        client.delete( client.buildAccountModelUri( new String[] {IrisPath.IMPORT_TN_ORDERS, orderId, IrisPath.LOAS, fileid } ));
    }

    public static FileMetaData GetLoasFileMetadata( IrisClient client, String orderId, String fileid) throws Exception {
        return client.get( client.buildAccountModelUri( new String[] {IrisPath.IMPORT_TN_ORDERS, orderId, IrisPath.LOAS, fileid, "metadata" } ), FileMetaData.class);
    }

    public static void CreateLoasFileMetadata( IrisClient client, String orderId, String fileId, FileMetaData metadata) throws Exception {
        client.put( client.buildAccountModelUri( new String[] {IrisPath.IMPORT_TN_ORDERS, orderId, IrisPath.LOAS, fileId, "metadata" } ), metadata );
    }

    public static void DeleteLoasFileMetadata( IrisClient client, String orderId, String fileId) throws Exception {
        client.delete( client.buildAccountModelUri( new String[] {IrisPath.IMPORT_TN_ORDERS, orderId, IrisPath.LOAS, fileId, "metadata" } ));
    }

    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(String orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
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

    public List<String> getTelephoneNumberList() {
        return telephoneNumberList;
    }

    public void setTelephoneNumberList(List<String> telephoneNumberList) {
        this.telephoneNumberList = telephoneNumberList;
    }

    public String getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public int getSipPeer() {
        return sipPeer;
    }

    public void setSipPeer(int sipPeer) {
        this.sipPeer = sipPeer;
    }
}
