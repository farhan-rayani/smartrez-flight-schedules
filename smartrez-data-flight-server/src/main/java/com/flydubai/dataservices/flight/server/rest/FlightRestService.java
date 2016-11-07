package com.flydubai.dataservices.flight.server.rest;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flydubai.dataservices.flight.common.exception.FlightDAOException;
import com.flydubai.dataservices.flight.common.utils.Constants;
import com.flydubai.dataservices.flight.common.vo.Error;
import com.flydubai.dataservices.flight.common.vo.FlightDetails;
import com.flydubai.dataservices.flight.common.vo.FlightInformationRQParm;
import com.flydubai.dataservices.flight.common.vo.FlightInformationRS;
import com.flydubai.dataservices.flight.common.vo.InfoGroup;
import com.flydubai.dataservices.flight.server.service.FlightService;

@Component
@Path("/flightService")
public class FlightRestService {

	@Autowired
	FlightService flightService;

	Logger logger = LoggerFactory.getLogger(FlightRestService.class);


	@Path("/resource")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public void asyncGet(@Suspended final AsyncResponse asyncResponse) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				String result = veryExpensiveOperation();
				asyncResponse.resume(result);
			}

			private String veryExpensiveOperation() {
				return "hello";
			}
		}).start();
	}

	@GET
	@Path("/flights")
	@Produces(MediaType.APPLICATION_JSON)
	public FlightInformationRS fetchFlightsDetailsForPreseating(
			@BeanParam FlightInformationRQParm flightInformationRQParm) {
		logger.info("Flight data service Invoked : ENTRY");
		FlightInformationRS flightInfoRS = new FlightInformationRS();
		InfoGroup infoGroup = new InfoGroup();
		com.flydubai.dataservices.flight.common.vo.Error error = new Error();
		infoGroup.getError().add(error);
		flightInfoRS.setInfoGroup(infoGroup);
		try {
			List<FlightDetails> listOfFlightDetails = flightService
					.getFlightsSegLegDetailss(flightInformationRQParm);
			flightInfoRS.getFlightDetails().addAll(listOfFlightDetails);
			error.setCode(Constants.SUCCESS_ERROR_CODE);
			error.setErrorType(Constants.ERROR_TYPE_SUCCESS);
		} catch (FlightDAOException flightDAOException) {
			error.setErrorType(Constants.ERROR_TYPE_ERROR);
			error.setCode(flightDAOException.getErrorCode());
			error.setSource(flightDAOException.getMessage());
		} catch (Exception e) {
			error.setErrorType(Constants.ERROR_TYPE_ERROR);
			error.setCode(Constants.DAO_ERROR_SYSTEM_ERROR);
			error.setSource("fetchFlightsDetailsForPreseating");
		}
		logger.info("Flight data service Invoked : EXIT");
		return flightInfoRS;
	}
	
	@GET
	@Path("/flightsOD")
	@Produces(MediaType.APPLICATION_JSON)
	public FlightInformationRS fetchFlightsDetailsForOD(
			@BeanParam FlightInformationRQParm flightInformationRQParm) {
		logger.info("Flight data service Invoked : ENTRY");
		FlightInformationRS flightInfoRS = new FlightInformationRS();
		InfoGroup infoGroup = new InfoGroup();
		com.flydubai.dataservices.flight.common.vo.Error error = new Error();
		infoGroup.getError().add(error);
		flightInfoRS.setInfoGroup(infoGroup);
		try {
			List<FlightDetails> listOfFlightDetails = flightService
					.getFlightODDetails(flightInformationRQParm);
			flightInfoRS.getFlightDetails().addAll(listOfFlightDetails);
			error.setCode(Constants.SUCCESS_ERROR_CODE);
			error.setErrorType(Constants.ERROR_TYPE_SUCCESS);
		} catch (FlightDAOException flightDAOException) {
			error.setErrorType(Constants.ERROR_TYPE_ERROR);
			error.setCode(flightDAOException.getErrorCode());
			error.setSource(flightDAOException.getMessage());
		} catch (Exception e) {
			error.setErrorType(Constants.ERROR_TYPE_ERROR);
			error.setCode(Constants.DAO_ERROR_SYSTEM_ERROR);
			error.setSource("fetchFlightsDetailsForOD");
		}
		logger.info("Flight data service Invoked : EXIT");
		return flightInfoRS;
	}
	
	@GET
	@Path("/circularFlights")
	@Produces(MediaType.APPLICATION_JSON)
	public FlightInformationRS fetchCircularDetails(
			@BeanParam FlightInformationRQParm flightInformationRQParm) {
		logger.info("Flight data service Invoked : ENTRY");
		FlightInformationRS flightInfoRS = new FlightInformationRS();
		InfoGroup infoGroup = new InfoGroup();
		com.flydubai.dataservices.flight.common.vo.Error error = new Error();
		infoGroup.getError().add(error);
		flightInfoRS.setInfoGroup(infoGroup);
		try {
			if(flightInformationRQParm.getBoardAirportCode() == null){
				throw new FlightDAOException("Mandatory data missing- Board Airpot Code");
			}
			
			if(flightInformationRQParm.getDepartureDateString() == null){
				throw new FlightDAOException("Mandatory data missing- Departure Date");
			}
			
			if(flightInformationRQParm.getOandDNumber() == null){
				throw new FlightDAOException("Mandatory data missing- OandDNumber");
			}
			
			List<FlightDetails> listOfFlightDetails = flightService
					.getCircularFlightLegDetails(flightInformationRQParm);
			flightInfoRS.getFlightDetails().addAll(listOfFlightDetails);
			error.setCode(Constants.SUCCESS_ERROR_CODE);
			error.setErrorType(Constants.ERROR_TYPE_SUCCESS);
		} catch (FlightDAOException flightDAOException) {
			error.setErrorType(Constants.ERROR_TYPE_ERROR);
			error.setCode(flightDAOException.getErrorCode());
			error.setSource(flightDAOException.getMessage());
		} catch (Exception e) {
			error.setErrorType(Constants.ERROR_TYPE_ERROR);
			error.setCode(Constants.DAO_ERROR_SYSTEM_ERROR);
			error.setSource("fetchFlightsDetailsForPreseating");
		}
		logger.info("Flight data service Invoked : EXIT");
		return flightInfoRS;
	}

}
