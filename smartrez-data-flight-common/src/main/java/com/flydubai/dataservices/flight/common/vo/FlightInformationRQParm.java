package com.flydubai.dataservices.flight.common.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.ws.rs.QueryParam;

import com.flydubai.dataservices.flight.common.utils.Constants;
import com.flydubai.dataservices.flight.common.utils.DateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class FlightInformationRQParm.
 */
public class FlightInformationRQParm {

    /** The airline code. */
    @QueryParam("airlineCode")
    protected String airlineCode;
    
    /** The flight number. */
    @QueryParam("flightNumber")
    protected int flightNumber;
    
    /** The departure start date string utc. */
    @QueryParam("departureStartDateUTC")
    protected String departureStartDateStringUTC;
    
    /** The departure end date string utc. */
    @QueryParam("departureEndDateUTC")
    protected String departureEndDateStringUTC;
    
    /** The departure date string. */
    @QueryParam("departureDate")
    protected String departureDateString;
    
    /** The board airport code. */
    @QueryParam("boardAirportCode")
    protected String boardAirportCode;
    
    /** The off airport code. */
    @QueryParam("offAirportCode")
    protected String offAirportCode;
    
    /** The search for circular. */
    @QueryParam("searchForCircular")
    protected String searchForCircular;
    
    /** The oand d number. */
    @QueryParam("oandDNumber")
    protected String oandDNumber;
    
    /** Route */
    @QueryParam("route")
    protected String route;
    
    /** The departure start date utc. */
    protected LocalDateTime departureStartDateUTC;
    
    /** The departure end date utc. */
    protected LocalDateTime departureEndDateUTC;
    
    /** The departure date. */
    protected LocalDate departureDate;
    
    /** The last modified date utc. */
    protected LocalDateTime lastModifiedDateUTC;
    
	/**
	 * Gets the departure start date string utc.
	 *
	 * @return the departureStartDateStringUTC
	 */
	public String getDepartureStartDateStringUTC() {
		return departureStartDateStringUTC;
	}
	
	/**
	 * Sets the departure start date string utc.
	 *
	 * @param departureStartDateStringUTC the departureStartDateStringUTC to set
	 */
	public void setDepartureStartDateStringUTC(String departureStartDateStringUTC) {
		this.departureStartDateStringUTC = departureStartDateStringUTC;
	}
	
	/**
	 * Gets the departure end date string utc.
	 *
	 * @return the departureEndDateStringUTC
	 */
	public String getDepartureEndDateStringUTC() {
		return departureEndDateStringUTC;
	}
	
	/**
	 * Sets the departure end date string utc.
	 *
	 * @param departureEndDateStringUTC the departureEndDateStringUTC to set
	 */
	public void setDepartureEndDateStringUTC(String departureEndDateStringUTC) {
		this.departureEndDateStringUTC = departureEndDateStringUTC;
	}
	
	/**
	 * Gets the airline code.
	 *
	 * @return the airlineCode
	 */
	public String getAirlineCode() {
		return airlineCode;
	}
	
	/**
	 * Sets the airline code.
	 *
	 * @param airlineCode the airlineCode to set
	 */
	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}
	
	/**
	 * Gets the flight number.
	 *
	 * @return the flightNumber
	 */
	public int getFlightNumber() {
		return flightNumber;
	}
	
	/**
	 * Sets the flight number.
	 *
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	/**
	 * Gets the departure start date utc.
	 *
	 * @return the departureStartDateUTC
	 */
	public LocalDateTime getDepartureStartDateUTC() {
		return departureStartDateUTC;
	}
	
	/**
	 * Sets the departure start date utc.
	 *
	 * @param departureStartDateUTC the departureStartDateUTC to set
	 */
	public void setDepartureStartDateUTC(LocalDateTime departureStartDateUTC) {
		setDepartureStartDateStringUTC(DateUtil.getDateString(departureStartDateUTC, Constants.FLIGHT_PICK_DATE_FORMAT));
		this.departureStartDateUTC = departureStartDateUTC;
	}
	
	/**
	 * Gets the departure end date utc.
	 *
	 * @return the departureEndDateUTC
	 */
	public LocalDateTime getDepartureEndDateUTC() {
		return departureEndDateUTC;
	}
	
	/**
	 * Sets the departure end date utc.
	 *
	 * @param departureEndDateUTC the departureEndDateUTC to set
	 */
	public void setDepartureEndDateUTC(LocalDateTime departureEndDateUTC) {
		setDepartureEndDateStringUTC(DateUtil.getDateString(departureEndDateUTC, Constants.FLIGHT_PICK_DATE_FORMAT));
		this.departureEndDateUTC = departureEndDateUTC;
	}
	
	/**
	 * Gets the last modified date utc.
	 *
	 * @return the last modified date utc
	 */
	public LocalDateTime getLastModifiedDateUTC() {
		return lastModifiedDateUTC;
	}
	
	/**
	 * Sets the last modified date utc.
	 *
	 * @param lastModifiedDateUTC the new last modified date utc
	 */
	public void setLastModifiedDateUTC(LocalDateTime lastModifiedDateUTC) {
		this.lastModifiedDateUTC = lastModifiedDateUTC;
	}
	
	/**
	 * Gets the departure date string.
	 *
	 * @return the departureDateString
	 */
	public String getDepartureDateString() {
		return departureDateString;
	}
	
	/**
	 * Sets the departure date string.
	 *
	 * @param departureDateString the departureDateString to set
	 */
	public void setDepartureDateString(String departureDateString) {
		this.departureDateString = departureDateString;
	}
	
	/**
	 * Gets the departure date.
	 *
	 * @return the departureDate
	 */
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	
	/**
	 * Sets the departure date.
	 *
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(LocalDate departureDate) {
		setDepartureDateString(DateUtil.getDateString(departureDate));
		this.departureDate = departureDate;
	}
	
	/**
	 * Gets the board airport code.
	 *
	 * @return the boardAirportCode
	 */
	public String getBoardAirportCode() {
		return boardAirportCode;
	}
	
	/**
	 * Sets the board airport code.
	 *
	 * @param boardAirportCode the boardAirportCode to set
	 */
	public void setBoardAirportCode(String boardAirportCode) {
		this.boardAirportCode = boardAirportCode;
	}
	
	/**
	 * Gets the off airport code.
	 *
	 * @return the offAirportCode
	 */
	public String getOffAirportCode() {
		return offAirportCode;
	}
	
	/**
	 * Sets the off airport code.
	 *
	 * @param offAirportCode the offAirportCode to set
	 */
	public void setOffAirportCode(String offAirportCode) {
		this.offAirportCode = offAirportCode;
	}
	
	/**
	 * Gets the search for circular.
	 *
	 * @return the search for circular
	 */
	public String getSearchForCircular() {
		return searchForCircular;
	}
	
	/**
	 * Sets the search for circular.
	 *
	 * @param searchForCircular the new search for circular
	 */
	public void setSearchForCircular(String searchForCircular) {
		this.searchForCircular = searchForCircular;
	}
	
	/**
	 * Gets the oand d number.
	 *
	 * @return the oand d number
	 */
	public String getOandDNumber() {
		return oandDNumber;
	}
	
	/**
	 * Sets the oand d number.
	 *
	 * @param oandDNumber the new oand d number
	 */
	public void setOandDNumber(String oandDNumber) {
		this.oandDNumber = oandDNumber;
	}
	
	/**
	 * Gets the route
	 *
	 * @return the route
	 */
	public String getRoute() { 
		return route;
	}
	
	/**
	 * Sets the route.
	 *
	 * @param 
	 */
	public void setRoute(String route) {
		this.route = route;
	}
    
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("");
		if (this.airlineCode != null) {
			builder.append("airlineCode=").append(this.airlineCode);
		}
		if (this.flightNumber > 0) {
			builder.append("|flightNumber=").append(this.flightNumber);
		}
		if (this.departureStartDateUTC != null) { 
			builder.append("|departureStartDateUTC=").append(this.departureStartDateUTC);
		}
		if (this.departureEndDateUTC != null) {
			builder.append("|departureEndDateUTC=").append(this.departureEndDateUTC);
		}
		if (this.departureDate != null) {
			builder.append("|departureDate=").append(this.departureDate);
		}
		if (this.boardAirportCode != null) {
			builder.append("|boardAirportCode=").append(this.boardAirportCode);
		}
		if (this.offAirportCode != null) {
			builder.append("|offAirportCode=").append(this.offAirportCode);
		}
		return builder.toString();
	}
	
}
