//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.16 at 12:06:22 PM GST 
//


package com.flydubai.dataservices.flight.common.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * A flight number with optional suffix letter. Flight numbers are integer values within the range of [0,9999]. 
 * 
 * Example: 1234
 * 
 * <p>Java class for FlightNumberWithSuffixType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FlightNumberWithSuffixType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>FlightNumberType">
 *       &lt;attribute name="Suffix">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="A"/>
 *             &lt;enumeration value="B"/>
 *             &lt;enumeration value="C"/>
 *             &lt;enumeration value="D"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlightNumberWithSuffixType", propOrder = {
    "value"
})
public class FlightNumberWithSuffixType {

    @XmlValue
    protected int value;
    @XmlAttribute(name = "Suffix")
    protected String suffix;

    /**
     * A flight number. Flight numbers are integer values within the range of [0-9999]. Example: 1234
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Gets the value of the suffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Sets the value of the suffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuffix(String value) {
        this.suffix = value;
    }

}
