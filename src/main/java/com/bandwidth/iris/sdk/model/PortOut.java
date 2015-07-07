package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@XmlRootElement(name = "PortOut")
@XmlAccessorType(XmlAccessType.FIELD)
public class PortOut {

    //TODO: NEED DOCUMENTATION
    public static PortOut list(IrisClient client, Map<String, Object> query) throws Exception {
        throw new NotImplementedException();
        //        return client.get(client.buildAccountModelUri(
        //                new String[] { IrisConstants.PORTOUT_URI_PATH }, query), PortOut.class);
    }

    //TODO: NEED DOCUMENTATION
    public static PortOut get(IrisClient client, String orderId) throws Exception {
        throw new NotImplementedException();
    }

    //TODO: NEED DOCUMENTATION
    public static int totals(IrisClient client) throws Exception {
        throw new NotImplementedException();
    }
}
