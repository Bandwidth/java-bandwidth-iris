package com.bandwidth.iris.sdk;


import com.bandwidth.iris.sdk.model.ImportTnChecker;
import com.bandwidth.iris.sdk.model.ImportTnCheckerPayload;
import com.bandwidth.iris.sdk.model.ImportTnCheckerResponse;
import com.bandwidth.iris.sdk.model.ImportTnError;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.junit.Assert.assertEquals;

public class ImportTnCheckerTests extends BaseModelTests  {


    @Test
    public void TestCheck() throws Exception {
        String url = "/v1.0/accounts/accountId/importTnChecker";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.importTnCheckerResponse)));

        List<String> numbers = new ArrayList<String>();
        numbers.add("9192345678");


        ImportTnCheckerPayload payload = new ImportTnCheckerPayload();
        payload.setTelephoneNumberList(numbers);

        ImportTnCheckerResponse response = ImportTnChecker.Check(getDefaultClient(), payload );
        ImportTnCheckerPayload resPayload = response.getImportTnCheckerPayload();

        assertEquals(1, resPayload.getTelephoneNumberList().size());
        assertEquals(1, resPayload.getImportTnErrorList().size());
        assertEquals(2, resPayload.getImportTnErrorList().get(0).getTelephoneNumberList().size());

        ImportTnError firstError = resPayload.getImportTnErrorList().get(0);

        assertEquals("19006", firstError.getCode());
        assertEquals("Bandwidth numbers cannot be imported by this account at this time.", firstError.getDescription());

    }
}
