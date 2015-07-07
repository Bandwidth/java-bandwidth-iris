package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;

public abstract class BaseModel {

    protected IrisClient client;

    protected IrisClient getClient() {
        return client;
    }

    protected void setClient(IrisClient client) {
        this.client = client;
    }
}
