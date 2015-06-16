package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.IrisResponse;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sbarstow on 6/16/15.
 */
@XmlRootElement(name="LidbOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class LidbOrder extends BaseModel{
    @XmlElement(name="id")
    private String id;

    @XmlElement(name="OrderCreatedDate")
    private Date orderCreatedDate;

    @XmlElement(name="AccountId")
    private String accountId;

    @XmlElement(name="OrderId")
    private String orderId;

    @XmlElement(name="LastModifiedDate")
    private Date lastModifiedDate;

    @XmlElement(name="ProcessingStatus")
    private String processingStatus;

    @XmlElementWrapper(name="ErrorList")
    @XmlElement(name="Error")
    private List<Error> errors = new ArrayList<Error>();


    @XmlElementWrapper(name="LidbTnGroups")
    @XmlElement(name="LidbTnGroup")
    private List<LidbTnGroup> lidbTnGroupList = new ArrayList<LidbTnGroup>();

    public static LidbOrder create(IrisClient client, LidbOrder order) throws Exception {
        IrisResponse response = client.post(client.buildUserModelUri(new String[] { IrisConstants.LIDB_ORDER_PATH }), order);
        String id = client.getIdFromLocationHeader(response.getHeaders().get("Location"));
        return get(client, id);
    }

    public static LidbOrder get(IrisClient client, String orderId) throws Exception {
        LidbOrderResponse orderResponse = client.get(client.buildUserModelUri(
                new String[] { IrisConstants.LIDB_ORDER_PATH, orderId }), LidbOrderResponse.class);
        LidbOrder order = orderResponse.getOrder();
        order.setClient(client);
        return order;
    }


    public List<LidbTnGroup> getLidbTnGroupList() {
        return lidbTnGroupList;
    }

    public void setLidbTnGroupList(List<LidbTnGroup> lidbTnGroupList) {
        this.lidbTnGroupList = lidbTnGroupList;
    }
}
