//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.05 at 12:16:45 PM GST 
//


package com.flydubai.dataservices.flight.common.vo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}BoardAirportCode"/>
 *         &lt;element ref="{}OffAirportCode"/>
 *         &lt;element ref="{}LegOrder"/>
 *         &lt;element ref="{}FlightNumber"/>
 *         &lt;element ref="{}DepartureCityCode" minOccurs="0"/>
 *         &lt;element ref="{}ArrivalCityCode" minOccurs="0"/>
 *         &lt;element ref="{}DepartureMetroGroupCode" minOccurs="0"/>
 *         &lt;element ref="{}ArrivalMetroGroupCode" minOccurs="0"/>
 *         &lt;element ref="{}EquipmentCode" minOccurs="0"/>
 *         &lt;element ref="{}EquipmentVersionCode" minOccurs="0"/>
 *         &lt;element ref="{}SeatTemplateCode" minOccurs="0"/>
 *         &lt;element name="TailNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DelayCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}DepTimeLTC"/>
 *         &lt;element ref="{}DepTimeUTC"/>
 *         &lt;element ref="{}ArrivalTimeLTC"/>
 *         &lt;element ref="{}ArrivalTimeUTC"/>
 *         &lt;element ref="{}EstimatedDepTimeLTC"/>
 *         &lt;element ref="{}EstimatedArrivalTimeLTC"/>
 *         &lt;element ref="{}ActualDepTimeLTC"/>
 *         &lt;element ref="{}ActualArrivalTimeLTC"/>
 *         &lt;element ref="{}DayChange"/>
 *         &lt;element name="DepartureTerminal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ArrivalTerminal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DepartureGate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ArrivalGate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AirportComments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClosedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element ref="{}LastModifedDateLTC"/>
 *         &lt;element ref="{}LastModifedDateUTC"/>
 *         &lt;element ref="{}RestrictedSSR" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "boardAirportCode",
    "offAirportCode",
    "legOrder",
    "flightNumber",
    "departureCityCode",
    "arrivalCityCode",
    "departureMetroGroupCode",
    "arrivalMetroGroupCode",
    "equipmentCode",
    "equipmentVersionCode",
    "seatTemplateCode",
    "tailNumber",
    "delayCode",
    "status",
    "depTimeLTC",
    "depTimeUTC",
    "arrivalTimeLTC",
    "arrivalTimeUTC",
    "estimatedDepTimeLTC",
    "estimatedArrivalTimeLTC",
    "actualDepTimeLTC",
    "actualArrivalTimeLTC",
    "dayChange",
    "departureTerminal",
    "arrivalTerminal",
    "departureGate",
    "arrivalGate",
    "airportComments",
    "closedTime",
    "lastModifedDateLTC",
    "lastModifedDateUTC",
    "restrictedSSR"
})
@XmlRootElement(name = "Leg")
public class Leg {

    @XmlElement(name = "BoardAirportCode", required = true)
    protected String boardAirportCode;
    @XmlElement(name = "OffAirportCode", required = true)
    protected String offAirportCode;
    @XmlElement(name = "LegOrder")
    protected int legOrder;
    @XmlElement(name = "FlightNumber", required = true)
    protected FlightNumberWithSuffixType flightNumber;
    @XmlElement(name = "DepartureCityCode")
    protected String departureCityCode;
    @XmlElement(name = "ArrivalCityCode")
    protected String arrivalCityCode;
    @XmlElement(name = "DepartureMetroGroupCode")
    protected String departureMetroGroupCode;
    @XmlElement(name = "ArrivalMetroGroupCode")
    protected String arrivalMetroGroupCode;
    @XmlElement(name = "EquipmentCode")
    protected String equipmentCode;
    @XmlElement(name = "EquipmentVersionCode")
    protected String equipmentVersionCode;
    @XmlElement(name = "SeatTemplateCode")
    protected String seatTemplateCode;
    @XmlElement(name = "TailNumber", required = true)
    protected String tailNumber;
    @XmlElement(name = "DelayCode", required = true)
    protected String delayCode;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "DepTimeLTC", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar depTimeLTC;
    @XmlElement(name = "DepTimeUTC", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar depTimeUTC;
    @XmlElement(name = "ArrivalTimeLTC", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar arrivalTimeLTC;
    @XmlElement(name = "ArrivalTimeUTC", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar arrivalTimeUTC;
    @XmlElement(name = "EstimatedDepTimeLTC", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar estimatedDepTimeLTC;
    @XmlElement(name = "EstimatedArrivalTimeLTC", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar estimatedArrivalTimeLTC;
    @XmlElement(name = "ActualDepTimeLTC", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar actualDepTimeLTC;
    @XmlElement(name = "ActualArrivalTimeLTC", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar actualArrivalTimeLTC;
    @XmlElement(name = "DayChange")
    protected int dayChange;
    @XmlElement(name = "DepartureTerminal", required = true)
    protected String departureTerminal;
    @XmlElement(name = "ArrivalTerminal", required = true)
    protected String arrivalTerminal;
    @XmlElement(name = "DepartureGate", required = true)
    protected String departureGate;
    @XmlElement(name = "ArrivalGate", required = true)
    protected String arrivalGate;
    @XmlElement(name = "AirportComments", required = true)
    protected String airportComments;
    @XmlElement(name = "ClosedTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar closedTime;
    @XmlElement(name = "LastModifedDateLTC", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastModifedDateLTC;
    @XmlElement(name = "LastModifedDateUTC", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastModifedDateUTC;
    @XmlElement(name = "RestrictedSSR", required = true)
    protected List<RestrictedSSR> restrictedSSR;

    /**
     * Gets the value of the boardAirportCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoardAirportCode() {
        return boardAirportCode;
    }

    /**
     * Sets the value of the boardAirportCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoardAirportCode(String value) {
        this.boardAirportCode = value;
    }

    /**
     * Gets the value of the offAirportCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffAirportCode() {
        return offAirportCode;
    }

    /**
     * Sets the value of the offAirportCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffAirportCode(String value) {
        this.offAirportCode = value;
    }

    /**
     * Gets the value of the legOrder property.
     * 
     */
    public int getLegOrder() {
        return legOrder;
    }

    /**
     * Sets the value of the legOrder property.
     * 
     */
    public void setLegOrder(int value) {
        this.legOrder = value;
    }

    /**
     * Gets the value of the flightNumber property.
     * 
     * @return
     *     possible object is
     *     {@link FlightNumberWithSuffixType }
     *     
     */
    public FlightNumberWithSuffixType getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets the value of the flightNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlightNumberWithSuffixType }
     *     
     */
    public void setFlightNumber(FlightNumberWithSuffixType value) {
        this.flightNumber = value;
    }

    /**
     * Gets the value of the departureCityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartureCityCode() {
        return departureCityCode;
    }

    /**
     * Sets the value of the departureCityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartureCityCode(String value) {
        this.departureCityCode = value;
    }

    /**
     * Gets the value of the arrivalCityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalCityCode() {
        return arrivalCityCode;
    }

    /**
     * Sets the value of the arrivalCityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalCityCode(String value) {
        this.arrivalCityCode = value;
    }

    /**
     * Gets the value of the departureMetroGroupCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartureMetroGroupCode() {
        return departureMetroGroupCode;
    }

    /**
     * Sets the value of the departureMetroGroupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartureMetroGroupCode(String value) {
        this.departureMetroGroupCode = value;
    }

    /**
     * Gets the value of the arrivalMetroGroupCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalMetroGroupCode() {
        return arrivalMetroGroupCode;
    }

    /**
     * Sets the value of the arrivalMetroGroupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalMetroGroupCode(String value) {
        this.arrivalMetroGroupCode = value;
    }

    /**
     * Gets the value of the equipmentCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquipmentCode() {
        return equipmentCode;
    }

    /**
     * Sets the value of the equipmentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquipmentCode(String value) {
        this.equipmentCode = value;
    }

    /**
     * Gets the value of the equipmentVersionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquipmentVersionCode() {
        return equipmentVersionCode;
    }

    /**
     * Sets the value of the equipmentVersionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquipmentVersionCode(String value) {
        this.equipmentVersionCode = value;
    }

    /**
     * Gets the value of the seatTemplateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatTemplateCode() {
        return seatTemplateCode;
    }

    /**
     * Sets the value of the seatTemplateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatTemplateCode(String value) {
        this.seatTemplateCode = value;
    }

    /**
     * Gets the value of the tailNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTailNumber() {
        return tailNumber;
    }

    /**
     * Sets the value of the tailNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTailNumber(String value) {
        this.tailNumber = value;
    }

    /**
     * Gets the value of the delayCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelayCode() {
        return delayCode;
    }

    /**
     * Sets the value of the delayCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelayCode(String value) {
        this.delayCode = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the depTimeLTC property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDepTimeLTC() {
        return depTimeLTC;
    }

    /**
     * Sets the value of the depTimeLTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDepTimeLTC(XMLGregorianCalendar value) {
        this.depTimeLTC = value;
    }

    /**
     * Gets the value of the depTimeUTC property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDepTimeUTC() {
        return depTimeUTC;
    }

    /**
     * Sets the value of the depTimeUTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDepTimeUTC(XMLGregorianCalendar value) {
        this.depTimeUTC = value;
    }

    /**
     * Gets the value of the arrivalTimeLTC property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArrivalTimeLTC() {
        return arrivalTimeLTC;
    }

    /**
     * Sets the value of the arrivalTimeLTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArrivalTimeLTC(XMLGregorianCalendar value) {
        this.arrivalTimeLTC = value;
    }

    /**
     * Gets the value of the arrivalTimeUTC property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArrivalTimeUTC() {
        return arrivalTimeUTC;
    }

    /**
     * Sets the value of the arrivalTimeUTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArrivalTimeUTC(XMLGregorianCalendar value) {
        this.arrivalTimeUTC = value;
    }

    /**
     * Gets the value of the estimatedDepTimeLTC property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEstimatedDepTimeLTC() {
        return estimatedDepTimeLTC;
    }

    /**
     * Sets the value of the estimatedDepTimeLTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEstimatedDepTimeLTC(XMLGregorianCalendar value) {
        this.estimatedDepTimeLTC = value;
    }

    /**
     * Gets the value of the estimatedArrivalTimeLTC property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEstimatedArrivalTimeLTC() {
        return estimatedArrivalTimeLTC;
    }

    /**
     * Sets the value of the estimatedArrivalTimeLTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEstimatedArrivalTimeLTC(XMLGregorianCalendar value) {
        this.estimatedArrivalTimeLTC = value;
    }

    /**
     * Gets the value of the actualDepTimeLTC property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActualDepTimeLTC() {
        return actualDepTimeLTC;
    }

    /**
     * Sets the value of the actualDepTimeLTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActualDepTimeLTC(XMLGregorianCalendar value) {
        this.actualDepTimeLTC = value;
    }

    /**
     * Gets the value of the actualArrivalTimeLTC property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActualArrivalTimeLTC() {
        return actualArrivalTimeLTC;
    }

    /**
     * Sets the value of the actualArrivalTimeLTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActualArrivalTimeLTC(XMLGregorianCalendar value) {
        this.actualArrivalTimeLTC = value;
    }

    /**
     * Gets the value of the dayChange property.
     * 
     */
    public int getDayChange() {
        return dayChange;
    }

    /**
     * Sets the value of the dayChange property.
     * 
     */
    public void setDayChange(int value) {
        this.dayChange = value;
    }

    /**
     * Gets the value of the departureTerminal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartureTerminal() {
        return departureTerminal;
    }

    /**
     * Sets the value of the departureTerminal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartureTerminal(String value) {
        this.departureTerminal = value;
    }

    /**
     * Gets the value of the arrivalTerminal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalTerminal() {
        return arrivalTerminal;
    }

    /**
     * Sets the value of the arrivalTerminal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalTerminal(String value) {
        this.arrivalTerminal = value;
    }

    /**
     * Gets the value of the departureGate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartureGate() {
        return departureGate;
    }

    /**
     * Sets the value of the departureGate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartureGate(String value) {
        this.departureGate = value;
    }

    /**
     * Gets the value of the arrivalGate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalGate() {
        return arrivalGate;
    }

    /**
     * Sets the value of the arrivalGate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalGate(String value) {
        this.arrivalGate = value;
    }

    /**
     * Gets the value of the airportComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirportComments() {
        return airportComments;
    }

    /**
     * Sets the value of the airportComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirportComments(String value) {
        this.airportComments = value;
    }

    /**
     * Gets the value of the closedTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClosedTime() {
        return closedTime;
    }

    /**
     * Sets the value of the closedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClosedTime(XMLGregorianCalendar value) {
        this.closedTime = value;
    }

    /**
     * Gets the value of the lastModifedDateLTC property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastModifedDateLTC() {
        return lastModifedDateLTC;
    }

    /**
     * Sets the value of the lastModifedDateLTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastModifedDateLTC(XMLGregorianCalendar value) {
        this.lastModifedDateLTC = value;
    }

    /**
     * Gets the value of the lastModifedDateUTC property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastModifedDateUTC() {
        return lastModifedDateUTC;
    }

    /**
     * Sets the value of the lastModifedDateUTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastModifedDateUTC(XMLGregorianCalendar value) {
        this.lastModifedDateUTC = value;
    }

    /**
     * Gets the value of the restrictedSSR property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the restrictedSSR property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRestrictedSSR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RestrictedSSR }
     * 
     * 
     */
    public List<RestrictedSSR> getRestrictedSSR() {
        if (restrictedSSR == null) {
            restrictedSSR = new ArrayList<RestrictedSSR>();
        }
        return this.restrictedSSR;
    }

}
