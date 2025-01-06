package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "LineOptionOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineOptionOrder extends BaseModel {
    @XmlElement(name = "TnLineOptions")
    private List<TnLineOptions> lineOptions = new ArrayList<TnLineOptions>();

    public static LineOptionOrderResponse create(IrisClient client, LineOptionOrder order) throws Exception {
        LineOptionOrderResponse orderResponse = client
                .post(client.buildAccountModelUri(new String[] { IrisPath.LINE_OPTION_ORDER_URI_PATH }), order,
                        LineOptionOrderResponse.class);
        return orderResponse;
    }

    public List<TnLineOptions> getLineOptions() {
        return lineOptions;
    }

    public void setLineOptions(List<TnLineOptions> lineOptions) {
        this.lineOptions = lineOptions;
    }
}


