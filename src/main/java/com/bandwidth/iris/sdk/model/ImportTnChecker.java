package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

public class ImportTnChecker extends BaseModel {

    public static ImportTnCheckerResponse Check(IrisClient client, ImportTnCheckerPayload payload) throws Exception{
        return client.post( client.buildAccountModelUri(new String[] {IrisPath.IMPORT_TN_CHECKER} ), payload, ImportTnCheckerResponse.class);
    }

}
