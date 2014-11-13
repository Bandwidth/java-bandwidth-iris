package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;

/**
 * Created by sbarstow on 11/11/14.
 */
public abstract class BaseModel {

    protected IrisClient client;

    protected IrisClient getClient() {
        return client;
    }

    protected void setClient(IrisClient client) {
        this.client = client;
    }
}
