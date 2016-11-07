package com.flydubai.dataservices.flight.server.service.impl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flydubai.dataservices.flight.common.exception.FlightDAOException;
import com.flydubai.dataservices.flight.common.vo.FlightDetails;
import com.flydubai.dataservices.flight.common.vo.FlightInformationRQParm;
import com.flydubai.dataservices.flight.server.dao.FlightDAO;
import com.flydubai.dataservices.flight.server.service.FlightService;

@Service("flightService")
public class FlightServiceImpl implements FlightService {

	org.slf4j.Logger logger = LoggerFactory.getLogger(FlightServiceImpl.class);

	@Autowired
	private FlightDAO flightDAO;

	/**
	 * This method is to get the data from FlightSeLeg table according to the
	 * input filter parameters
	 * 
	 * @param flightInformationRQParm
	 * @return List of flightDetails, only segment details are available
	 */
	@Override
	public List<FlightDetails> getFlightsSegLegDetailss(
			FlightInformationRQParm flightInformationRQParm)
			throws FlightDAOException {
		return flightDAO.fetchFlightSegLegDetails(flightInformationRQParm);
	}

	@Override
	public List<FlightDetails> getFlightODDetails(
			FlightInformationRQParm flightInformationRQParm)
			throws FlightDAOException {
		return flightDAO.fetchFlightODDetails(flightInformationRQParm);
	}
	
	/**
	 * This method is to get the data from FlightSeLeg table according to the
	 * input filter parameters
	 * 
	 * @param flightInformationRQParm
	 * @return List of flightDetails, only segment details are available
	 */
	@Override
	public List<FlightDetails> getCircularFlightLegDetails(
			FlightInformationRQParm flightInformationRQParm)
			throws FlightDAOException {
		return flightDAO.fetchCircularFlightLegDetails(flightInformationRQParm);
	}
}
