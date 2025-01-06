package com.bandwidth.iris.sdk.utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;

public class XmlUtils {

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
