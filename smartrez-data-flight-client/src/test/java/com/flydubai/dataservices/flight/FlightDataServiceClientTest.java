package com.flydubai.dataservices.flight;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import com.flydubai.dataservices.flight.client.FlightDataServiceClient;
import com.flydubai.dataservices.flight.common.vo.FlightInformationRQParm;
import com.flydubai.dataservices.flight.common.vo.FlightInformationRS;


public class FlightDataServiceClientTest {

	@Test
	public void testClient1() {
		FlightDataServiceClient flightClient = new FlightDataServiceClient();
		FlightInformationRQParm flightInformationRQParm = new FlightInformationRQParm();
		//flightInformationRQParm.setFlightNumber(551);
		//flightInformationRQParm.setDepartureDate(LocalDate.of(2015, 5, 6));
		flightInformationRQParm.setDepartureStartDateUTC(LocalDateTime.of(2015, 8, 24,0,0));
		flightInformationRQParm.setDepartureEndDateUTC(LocalDateTime.of(2015, 8, 24,23,0));
		//flightInformationRQParm.setOandDNumber("441/442"); 
		//flightInformationRQParm.setBoardAirportCode("COK"); 
		//FlightInformationRS flightInformationRS = flightClient.getCircularFlightDetails(flightInformationRQParm);
		FlightInformationRS flightInformationRS = flightClient.getFlightInformationResponse(flightInformationRQParm);
	}
	
	@Test
	public void testClient2() {
		FlightDataServiceClient flightClient = new FlightDataServiceClient();
		FlightInformationRQParm flightInformationRQParm = new FlightInformationRQParm();
		//flightInformationRQParm.setFlightNumber(551);
		//flightInformationRQParm.setDepartureDate(LocalDate.of(2015, 5, 6));
		flightInformationRQParm.setDepartureStartDateUTC(LocalDateTime.of(2015, 8, 24,0,0));
		flightInformationRQParm.setDepartureEndDateUTC(LocalDateTime.of(2015, 8, 24,23,0));
		//flightInformationRQParm.setOandDNumber("441/442"); 
		//flightInformationRQParm.setBoardAirportCode("COK"); 
		//FlightInformationRS flightInformationRS = flightClient.getCircularFlightDetails(flightInformationRQParm);
		FlightInformationRS flightInformationRS = flightClient.getCircularFlightDetails(flightInformationRQParm);
	}
	
	@Test
	public void testClient3() {
		FlightDataServiceClient flightClient = new FlightDataServiceClient();
		FlightInformationRQParm flightInformationRQParm = new FlightInformationRQParm();
		//flightInformationRQParm.setFlightNumber(551);
		//flightInformationRQParm.setDepartureDate(LocalDate.of(2015, 5, 6));
		flightInformationRQParm.setDepartureStartDateUTC(LocalDateTime.of(2015, 8, 24,0,0));
		flightInformationRQParm.setDepartureEndDateUTC(LocalDateTime.of(2015, 8, 24,23,0));
		//flightInformationRQParm.setOandDNumber("441/442"); 
		//flightInformationRQParm.setBoardAirportCode("COK"); 
		//FlightInformationRS flightInformationRS = flightClient.getCircularFlightDetails(flightInformationRQParm);
		FlightInformationRS flightInformationRS = flightClient.getFlightInformationResponseForOD(flightInformationRQParm);
	}

}
