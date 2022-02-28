package com.bandwidth.iris.sdk.utils;

import com.bandwidth.iris.sdk.model.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class XmlUtilsTest {

    @Test
    public void testSerializeExistingTelephoneNumberOrderToXml() throws Exception {
        String properXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Order><BackOrderRequested>false</BackOrderRequested><Name>A New Order</Name><SiteId>1234</SiteId><PartialAllowed>false</PartialAllowed><ExistingTelephoneNumberOrderType><TelephoneNumberList><TelephoneNumber>2055551212</TelephoneNumber></TelephoneNumberList><ReservationIdList/></ExistingTelephoneNumberOrderType></Order>";
        Order o = new Order();
        o.setName("A New Order");
        ExistingTelephoneNumberOrderType existingTelephoneNumberOrderType = new ExistingTelephoneNumberOrderType();
        existingTelephoneNumberOrderType.getTelephoneNumberList().add("2055551212");
        o.setSiteId("1234");
        o.setPeerId("abcd");
        o.setExistingTelephoneNumberOrderType(existingTelephoneNumberOrderType);
    }

    @Test
    public void testSerializeDisconnectTelephoneNumberOrderToXml() throws Exception {
        String properXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><DisconnectTelephoneNumberOrder><Name>Disconnect</Name><DisconnectTelephoneNumberOrderType><TelephoneNumberList><TelephoneNumber>2055551212</TelephoneNumber></TelephoneNumberList></DisconnectTelephoneNumberOrderType></DisconnectTelephoneNumberOrder>";
        DisconnectTelephoneNumberOrder order = new DisconnectTelephoneNumberOrder();
        order.setName("Disconnect");
        DisconnectTelephoneNumberOrderType disconnectTelephoneNumberOrderType = new DisconnectTelephoneNumberOrderType();
        disconnectTelephoneNumberOrderType.getTelephoneNumberList().add("2055551212");
        order.setDisconnectTelephoneNumberOrderType(disconnectTelephoneNumberOrderType);
    }

    @Test
    public void testDeserializeSipPeerTelephoneNumbers() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SipPeerTelephoneNumbers><FullNumber>2055551212</FullNumber><FullNumber>2055551213</FullNumber></SipPeerTelephoneNumbers>";
        SipPeerTelephoneNumbers numbers = (SipPeerTelephoneNumbers) XmlUtils.fromXml(xml, SipPeerTelephoneNumbers.class);
        assertNotNull(numbers);
        assertEquals("2055551212", numbers.getFullNumbers().get(0));
        assertEquals("2055551213", numbers.getFullNumbers().get(1));
    }

    @Test
    public void testDeserializeNotes() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Notes><Note><Id>178468</Id><UserId>bwlabs</UserId><Description>Adding a note</Description><LastDateModifier>2014-11-19T21:02:26.000Z</LastDateModifier></Note></Notes>";
        Notes notes = XmlUtils.fromXml(xml, Notes.class);
        assertEquals(1, notes.getNotes().size());
        assertEquals("178468", notes.getNotes().get(0).getId());
    }

}
