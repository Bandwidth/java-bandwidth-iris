package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order extends BaseModel {

    @XmlElement(name = "id")
    private String id;
    @XmlElement(name = "BackOrderRequested")
    private boolean backOrderRequested;
    @XmlElement(name = "OrderCreateDate")
    private Date orderCreateDate;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "SiteId")
    private String siteId;
    @XmlElement(name = "PeerId")
    private String peerId;
    @XmlElement(name = "CustomerOrderId")
    private String customerOrderId;
    @XmlElement(name = "PartialAllowed")
    private boolean partialAllowed = false;
    @XmlElement(name = "ExistingTelephoneNumberOrderType")
    private ExistingTelephoneNumberOrderType existingTelephoneNumberOrderType;
    @XmlElement(name = "AreaCodeSearchAndOrderType")
    private AreaCodeSearchAndOrderType areaCodeSearchAndOrderType;
    @XmlElement(name = "CitySearchAndOrderType")
    private CitySearchAndOrderType citySearchAndOrderType;
    @XmlElement(name = "LATASearchAndOrderType")
    private LATASearchAndOrderType lataSearchAndOrderType;
    @XmlElement(name = "NPANXXSearchAndOrderType")
    private NPANXXSearchAndOrderType npanxxSearchAndOrderType;
    @XmlElement(name = "RateCenterSearchAndOrderType")
    private RateCenterSearchAndOrderType rateCenterSearchAndOrderType;
    @XmlElement(name = "StateSearchAndOrderType")
    private StateSearchAndOrderType stateSearchAndOrderType;
    @XmlElement(name = "TollFreeVanitySearchAndOrderType")
    private TollFreeVanitySearchAndOrderType tollFreeVanitySearchAndOrderType;
    @XmlElement(name = "TollFreeWildCharSearchAndOrderType")
    private TollFreeWildCharSearchAndOrderType tollFreeWildCharSearchAndOrderType;
    @XmlElement(name = "ZIPSearchAndOrderType")
    private ZIPSearchAndOrderType zipSearchAndOrderType;
    @XmlElement(name = "CombinedSearchAndOrderType")
    private CombinedSearchAndOrderType combinedSearchAndOrderType;


    public static OrderResponse create(IrisClient client, Order order) throws Exception {
        OrderResponse orderResponse = client
                .post(client.buildAccountModelUri(new String[] { IrisPath.ORDERS_URI_PATH }), order, OrderResponse.class);
        orderResponse.getOrder().setClient(client);
        return orderResponse;
    }

    public static OrderResponse get(IrisClient client, String orderId) throws Exception {
        OrderResponse orderResponse = client
                .get(client.buildAccountModelUri(new String[] { IrisPath.ORDERS_URI_PATH, orderId }), OrderResponse.class);
        orderResponse.getOrder().setClient(client);
        return orderResponse;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public boolean isBackOrderRequested() {
        return backOrderRequested;
    }

    public void setBackOrderRequested(boolean backOrderRequested) {
        this.backOrderRequested = backOrderRequested;
    }

    public Date getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(Date orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getPeerId() {
        return peerId;
    }

    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public boolean isPartialAllowed() {
        return partialAllowed;
    }

    public void setPartialAllowed(boolean partialAllowed) {
        this.partialAllowed = partialAllowed;
    }

    public ExistingTelephoneNumberOrderType getExistingTelephoneNumberOrderType() {
        return existingTelephoneNumberOrderType;
    }

    public void setExistingTelephoneNumberOrderType(ExistingTelephoneNumberOrderType existingTelephoneNumberOrderType) {
        this.existingTelephoneNumberOrderType = existingTelephoneNumberOrderType;
    }

    public AreaCodeSearchAndOrderType getAreaCodeSearchAndOrderType() {
        return areaCodeSearchAndOrderType;
    }

    public void setAreaCodeSearchAndOrderType(AreaCodeSearchAndOrderType areaCodeSearchAndOrderType) {
        this.areaCodeSearchAndOrderType = areaCodeSearchAndOrderType;
    }

    public CitySearchAndOrderType getCitySearchAndOrderType() {
        return citySearchAndOrderType;
    }

    public void setCitySearchAndOrderType(CitySearchAndOrderType citySearchAndOrderType) {
        this.citySearchAndOrderType = citySearchAndOrderType;
    }

    public LATASearchAndOrderType getLataSearchAndOrderType() {
        return lataSearchAndOrderType;
    }

    public void setLataSearchAndOrderType(LATASearchAndOrderType lataSearchAndOrderType) {
        this.lataSearchAndOrderType = lataSearchAndOrderType;
    }

    public NPANXXSearchAndOrderType getNpanxxSearchAndOrderType() {
        return npanxxSearchAndOrderType;
    }

    public void setNpanxxSearchAndOrderType(NPANXXSearchAndOrderType npanxxSearchAndOrderType) {
        this.npanxxSearchAndOrderType = npanxxSearchAndOrderType;
    }

    public RateCenterSearchAndOrderType getRateCenterSearchAndOrderType() {
        return rateCenterSearchAndOrderType;
    }

    public void setRateCenterSearchAndOrderType(RateCenterSearchAndOrderType rateCenterSearchAndOrderType) {
        this.rateCenterSearchAndOrderType = rateCenterSearchAndOrderType;
    }

    public StateSearchAndOrderType getStateSearchAndOrderType() {
        return stateSearchAndOrderType;
    }

    public void setStateSearchAndOrderType(StateSearchAndOrderType stateSearchAndOrderType) {
        this.stateSearchAndOrderType = stateSearchAndOrderType;
    }

    public TollFreeVanitySearchAndOrderType getTollFreeVanitySearchAndOrderType() {
        return tollFreeVanitySearchAndOrderType;
    }

    public void setTollFreeVanitySearchAndOrderType(TollFreeVanitySearchAndOrderType tollFreeVanitySearchAndOrderType) {
        this.tollFreeVanitySearchAndOrderType = tollFreeVanitySearchAndOrderType;
    }

    public TollFreeWildCharSearchAndOrderType getTollFreeWildCharSearchAndOrderType() {
        return tollFreeWildCharSearchAndOrderType;
    }

    public void setTollFreeWildCharSearchAndOrderType(TollFreeWildCharSearchAndOrderType tollFreeWildCharSearchAndOrderType) {
        this.tollFreeWildCharSearchAndOrderType = tollFreeWildCharSearchAndOrderType;
    }

    public ZIPSearchAndOrderType getZipSearchAndOrderType() {
        return zipSearchAndOrderType;
    }

    public void setZipSearchAndOrderType(ZIPSearchAndOrderType zipSearchAndOrderType) {
        this.zipSearchAndOrderType = zipSearchAndOrderType;
    }

    public CombinedSearchAndOrderType getCombinedSearchAndOrderType() {
        return combinedSearchAndOrderType;
    }

    public void setCombinedSearchAndOrderType(CombinedSearchAndOrderType combinedSearchAndOrderType) {
        this.combinedSearchAndOrderType = combinedSearchAndOrderType;
    }

    public void addNote(Note note) throws Exception {
        client.put(client.buildAccountModelUri(new String[] { IrisPath.ORDERS_URI_PATH, id, "notes" }), note);
    }

    public Notes getNotes() throws Exception {
        return client.get(client.buildAccountModelUri(new String[] { IrisPath.ORDERS_URI_PATH, id, "notes" }), Notes.class);
    }
}
