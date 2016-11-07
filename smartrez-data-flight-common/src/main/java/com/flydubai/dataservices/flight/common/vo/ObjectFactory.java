//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.16 at 12:06:22 PM GST 
//


package com.flydubai.dataservices.flight.common.vo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Text_QNAME = new QName("", "Text");
    private final static QName _FlightNumber_QNAME = new QName("", "FlightNumber");
    private final static QName _Code_QNAME = new QName("", "Code");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ForInfo }
     * 
     */
    public ForInfo createForInfo() {
        return new ForInfo();
    }

    /**
     * Create an instance of {@link InfoGroup }
     * 
     */
    public InfoGroup createInfoGroup() {
        return new InfoGroup();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link FlightNumberWithSuffixType }
     * 
     */
    public FlightNumberWithSuffixType createFlightNumberWithSuffixType() {
        return new FlightNumberWithSuffixType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Text")
    public JAXBElement<String> createText(String value) {
        return new JAXBElement<String>(_Text_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FlightNumberWithSuffixType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FlightNumber")
    public JAXBElement<FlightNumberWithSuffixType> createFlightNumber(FlightNumberWithSuffixType value) {
        return new JAXBElement<FlightNumberWithSuffixType>(_FlightNumber_QNAME, FlightNumberWithSuffixType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Code")
    public JAXBElement<String> createCode(String value) {
        return new JAXBElement<String>(_Code_QNAME, String.class, null, value);
    }

}