package com.flydubai.dataservices.flight.server.service;

import java.util.List;

import com.flydubai.dataservices.flight.common.exception.FlightDAOException;
import com.flydubai.dataservices.flight.common.vo.FlightDetails;
import com.flydubai.dataservices.flight.common.vo.FlightInformationRQParm;

public interface FlightService {

	/**
	 * This method is to get the data from FlightSeLeg table according to the
	 * input filter parameters
	 * 
	 * @param flightInformationRQParm
	 * @return List of flightDetails, only segment details are available
	 */
	public List<FlightDetails> getFlightsSegLegDetailss(
			FlightInformationRQParm flightInformationRQParm)
			throws FlightDAOException;
	
	public List<FlightDetails> getFlightODDetails(FlightInformationRQParm flightInformationRQParm) throws FlightDAOException;
	
	/**
	 * This method is to get the data from FlightSeLeg table according to the
	 * input filter parameters
	 * 
	 * @param flightInformationRQParm
	 * @return List of flightDetails, only segment details are available
	 */
	public List<FlightDetails> getCircularFlightLegDetails(
			FlightInformationRQParm flightInformationRQParm)
			throws FlightDAOException;

}
