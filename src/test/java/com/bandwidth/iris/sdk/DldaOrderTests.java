package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.DldaOrder;
import com.bandwidth.iris.sdk.model.DldaTnGroup;
import com.bandwidth.iris.sdk.model.DldaOrderResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;
import org.junit.Test;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.junit.Assert.assertEquals;



public class DldaOrderTests extends BaseModelTests {
    @Test
    public void testCreate() throws Exception {

    DldaTnGroup dldaTnGroup = new DldaTnGroup();
	dldaTnGroup.getTelephoneNumberList().add("9195551212");
	dldaTnGroup.setAccountType("RESIDENTIAL");
	dldaTnGroup.setListingType("LISTED");
	dldaTnGroup.setSubscriberType("BUSINESS");
        assertEquals(dldaTnGroup.getSubscriberType(), "BUSINESS");
 }


}
