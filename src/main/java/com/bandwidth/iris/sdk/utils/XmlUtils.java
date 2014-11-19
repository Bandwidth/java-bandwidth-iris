package com.bandwidth.iris.sdk.utils;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;

/**
 * Created by sbarstow on 10/14/14.
 */
public class XmlUtils {

    private static final Logger LOG = Logger.getLogger(XmlUtils.class);

    private static XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

    public static <T> T fromXml(String responseBody, Class<T> c) throws JAXBException, XMLStreamException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(responseBody.getBytes());
        JAXBContext jaxbContext = JAXBContext.newInstance(c);
        XMLStreamReader xsr = xmlInputFactory.createXMLStreamReader(inputStream);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (T) jaxbUnmarshaller.unmarshal(xsr);
    }

    public static <T> String toXml(T object) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(object, writer);
        return writer.toString();
    }
}
