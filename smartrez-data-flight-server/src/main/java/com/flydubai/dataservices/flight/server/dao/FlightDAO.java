package com.flydubai.dataservices.flight.server.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.flydubai.dataservices.flight.common.exception.FlightDAOException;
import com.flydubai.dataservices.flight.common.vo.FlightDetails;
import com.flydubai.dataservices.flight.common.vo.FlightInformationRQParm;

public interface FlightDAO {

	/**
	 * 
	 * @param flightInformationRQParm
	 * @return
	 * @throws DataAccessException
	 */
	public List<FlightDetails> fetchFlightSegLegDetails(
			FlightInformationRQParm flightInformationRQParm)
			throws FlightDAOException;
	
	public List<FlightDetails> fetchFlightODDetails(FlightInformationRQParm flightInformationRQParm) throws FlightDAOException;
	/**
	 * 
	 * @param fltInfoparam
	 * @return
	 * @throws FlightDAOException
	 */
	public List<FlightDetails> fetchCircularFlightLegDetails (FlightInformationRQParm fltInfoparam) throws FlightDAOException;
}
