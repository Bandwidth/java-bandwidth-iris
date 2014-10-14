package com.bandwidth.iris.sdk.utils;

import com.bandwidth.iris.sdk.model.ExistingTelephoneNumberOrderType;
import com.bandwidth.iris.sdk.model.Order;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sbarstow on 10/14/14.
 */
public class XmlUtilsTest {
    @Before
    public void setUp() throws ConfigurationException {
        org.apache.log4j.BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.DEBUG);
        ConsoleAppender a = (ConsoleAppender) Logger.getRootLogger().getAllAppenders().nextElement();
        a.setLayout(new PatternLayout("%d{ABSOLUTE} %5p %c{1}:%L - [%t] %m%n"));

    }

    @Test
    public void testSerializeExistingTelephoneNumberOrderToXml()throws Exception {

        Order o = new Order();
        o.setName("A New Order");
        ExistingTelephoneNumberOrderType existingTelephoneNumberOrderType = new ExistingTelephoneNumberOrderType();
        existingTelephoneNumberOrderType.getTelephoneNumberList().add("2055551212");
        o.setSiteId("1234");
        o.setExistingTelephoneNumberOrderType(existingTelephoneNumberOrderType);

        System.out.println(XmlUtils.toXml(o));
        assertEquals(XmlUtils.toXml(o), "Test");

    }

}
