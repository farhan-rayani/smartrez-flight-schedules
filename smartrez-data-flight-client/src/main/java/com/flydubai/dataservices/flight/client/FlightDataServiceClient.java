package com.flydubai.dataservices.flight.client;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flydubai.dataservices.flight.common.utils.Constants;
import com.flydubai.dataservices.flight.common.utils.DateUtil;
import com.flydubai.dataservices.flight.common.vo.Error;
import com.flydubai.dataservices.flight.common.vo.FlightInformationRQParm;
import com.flydubai.dataservices.flight.common.vo.FlightInformationRS;
import com.flydubai.dataservices.flight.common.vo.InfoGroup;
import com.flydubai.restclient.ClientRequest;
import com.flydubai.restclient.LoadBalancedClient;
import com.flydubai.util.configurator.client.ConfiguratorServiceClient;
import com.flydubai.util.configurator.data.ConfigurationContext;
import com.flydubai.util.configurator.data.FZConfiguration;
import com.flydubai.util.configurator.exception.ConfiguratorException;

public class FlightDataServiceClient {
	private static Logger logger = LoggerFactory.getLogger(FlightDataServiceClient.class);

	private FZConfiguration flightDataserviceConfigurations = null;

	public FlightDataServiceClient() {
		flightDataserviceConfigurations = getFlightDataServiceConfigurations();
	}
	
    public static void main(String arg[]){
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
		logger.info("success");
	}
    /**
	 * This method is to invoke the flight data-service and return an object of
	 * FlightInformationRS
	 * 
	 * @param flightInformationRQParm
	 *            FlightInformationRQParm
	 * @return FlightInformationRS
	 */
	public FlightInformationRS getCircularFlightDetails(
			FlightInformationRQParm requestParm) {
		logger.debug("Inside Flight data service client : getFlightInformationResponse : ENTRY");
		FlightInformationRS result = null;
		try {
			URI uri = getURI(requestParm,Constants.RESOURCE_CIRCULAR_FLIGHTS);
			WebTarget webTarget = createTarget(uri);
			result = webTarget.request(MediaType.APPLICATION_JSON).get(
					FlightInformationRS.class);
		} catch (Exception e) {
			logger.error("Exception occured while invoking the flight data service "
					, e);
			if (result == null) {
				result = createFlightInformationRSWithError(e);
			}
		}
		logger.debug("getFlightInformationResponse : EXIT");
		return result;
	}

	/**
	 * This method is to invoke the flight data-service and return an object of
	 * FlightInformationRS
	 * 
	 * @param flightInformationRQParm
	 *            FlightInformationRQParm
	 * @return FlightInformationRS
	 */
	public FlightInformationRS getFlightInformationResponse(
			FlightInformationRQParm requestParm) {
		logger.debug("Inside Flight data service client : getFlightInformationResponse : ENTRY");
		FlightInformationRS result = null;
		try {
			URI uri = getURI(requestParm, Constants.RESOURCE_FLIGHTS);
			WebTarget webTarget = createTarget(uri);
			result = webTarget.request(MediaType.APPLICATION_JSON).get(
					FlightInformationRS.class);
		} catch (Exception e) {
			logger.error("Exception occured while invoking the flight data service "
					, e);
			if (result == null) {
				result = createFlightInformationRSWithError(e);
			}
		}
		logger.debug("getFlightInformationResponse : EXIT");
		return result;
	}
	
	public FlightInformationRS getFlightInformationResponseForOD(
			FlightInformationRQParm requestParm) {
		logger.debug("Inside Flight data service client : getFlightInformationResponseForOD : ENTRY");
		FlightInformationRS result = null;
		try {
			URI uri = getURI(requestParm, Constants.RESOURCE_FLIGHTS_OD);
			WebTarget webTarget = createTarget(uri);
			result = webTarget.request(MediaType.APPLICATION_JSON).get(
					FlightInformationRS.class);
		} catch (Exception e) {
			logger.error("Exception occured while invoking the flight data service "
					, e);
			if (result == null) {
				result = createFlightInformationRSWithError(e);
			}
		}
		logger.debug("getFlightInformationResponseForOD : EXIT");
		return result;
	}

	/**
	 * This method is to create the URI to call the flight data service The
	 * flight data service server url is taking from the configuration service
	 * 
	 * @param flightInformationRQParm
	 *            as FlightInformationRQParm
	 * @return URI
	 */
	private URI getURI(FlightInformationRQParm flightInformationRQParm, String resource) {
		URI uri = null;
		StringBuilder urlBuilder = null;
		if (flightDataserviceConfigurations != null) {
			String flightDataserviceUrl = flightDataserviceConfigurations
					.getString(Constants.CONFIGURATION_FLIGHT_DATA_SERVICE_SERVER_URL);
		//String flightDataserviceUrl = "http://localhost:8081/smartrez-data-flight-server/flightService/circularFlights?";
			 
			logger.info(" Flight data service server URL ::  "
					+ flightDataserviceUrl);
			urlBuilder = new StringBuilder("")
					.append(flightDataserviceUrl);
			urlBuilder.append(Constants.SERVICE_URI);
			urlBuilder.append(resource);
			if (flightInformationRQParm.getAirlineCode() != null
					&& !flightInformationRQParm.getAirlineCode().trim().isEmpty()) {
				urlBuilder.append("airlineCode=").append(
						flightInformationRQParm.getAirlineCode());
			}
			if (flightInformationRQParm.getFlightNumber() > 0) {
				urlBuilder.append("&flightNumber=").append(
						flightInformationRQParm.getFlightNumber());
			}
			if (flightInformationRQParm.getOandDNumber() != null
					&& !flightInformationRQParm.getOandDNumber().trim().isEmpty()) {
				urlBuilder.append("&oandDNumber=").append(
						flightInformationRQParm.getOandDNumber());
			}
			if (flightInformationRQParm.getRoute() != null
					&& !flightInformationRQParm.getRoute().trim().isEmpty()) {
				urlBuilder.append("&route=").append(
						flightInformationRQParm.getRoute());
			}
			if (flightInformationRQParm.getDepartureStartDateUTC() != null) {
				urlBuilder.append("&departureStartDateUTC=").append(
						DateUtil.getDateString(flightInformationRQParm
								.getDepartureStartDateUTC(),
								Constants.FLIGHT_PICK_DATE_FORMAT));
			}
			if (flightInformationRQParm.getDepartureEndDateUTC() != null) {
				urlBuilder.append("&departureEndDateUTC=").append(
						DateUtil.getDateString(flightInformationRQParm
								.getDepartureEndDateUTC(),
								Constants.FLIGHT_PICK_DATE_FORMAT));
			}
			if (flightInformationRQParm.getDepartureDate() != null) {
				urlBuilder.append("&departureDate=").append(
						DateUtil.getDateString(flightInformationRQParm
								.getDepartureDate()));
			}
			if (flightInformationRQParm.getBoardAirportCode() != null
					&& !flightInformationRQParm.getBoardAirportCode().trim().isEmpty()) {
				urlBuilder.append("&boardAirportCode=").append(
						flightInformationRQParm.getBoardAirportCode());
			}
			if (flightInformationRQParm.getOffAirportCode() != null
					&& !flightInformationRQParm.getOffAirportCode().trim().isEmpty()) {
				urlBuilder.append("&offAirportCode=").append(
						flightInformationRQParm.getOffAirportCode());
			}

			uri = UriBuilder.fromUri(urlBuilder.toString()).build();
		}
		logger.info("Flight data service URL with request parameters = {}",
				urlBuilder != null ? urlBuilder.toString() : null);
		return uri;
	}
	
	/**
	 * This method is to get the configuration details
	 * 
	 * @return Properties
	 */
	/*
	 * private Properties getConfiguration() { Properties config = new
	 * Properties(); try { config.load(FlightDataServiceClient.class
	 * .getResourceAsStream("/config.properties")); } catch (IOException e) {
	 * logger.error("Exception in getConfiguration " + e.getMessage()); } return
	 * config; }
	 */

	/**
	 * This method is to take all the configurations required for flight data
	 * service client server for configuration service should be started before
	 * invoking this method
	 * 
	 * If more configurations is required, then add the configuration parameter
	 * name to the variable "List<String> parameterNames"
	 * 
	 * @return FZConfiguration
	 */
	private FZConfiguration getFlightDataServiceConfigurations() {
		FZConfiguration fzConfiguration = null;
		List<String> parameterNames = new ArrayList<String>();
		parameterNames
				.add(Constants.CONFIGURATION_FLIGHT_DATA_SERVICE_SERVER_URL);
		try {
			ConfiguratorServiceClient client = ConfiguratorServiceClient
					.getInstance();
			ConfigurationContext context = new ConfigurationContext.Builder(
					Constants.CONFIGURATOR_CONFIG_GROUP_FLIGHT_DATA_SERVICE)
					.addParameterNames(parameterNames).build();
			fzConfiguration = client.getConfiguration(context);
		} catch (ConfiguratorException e) {
			logger.error(
					"Exception while retrieving configurations for Flight data service ",
					e);
		}
		return fzConfiguration;
	}

	/**
	 * This method is to create a FlightInformationRS with error code if any
	 * error occurred
	 * 
	 * @param exeption
	 *            as Exception
	 * @return FlightInformationRS with error message
	 */
	private FlightInformationRS createFlightInformationRSWithError(
			Exception exeption) {
		FlightInformationRS flightInformationRS = new FlightInformationRS();
		InfoGroup infoGroup = new InfoGroup();
		com.flydubai.dataservices.flight.common.vo.Error error = new Error();
		if (exeption != null) {
			error.setSource(exeption.getMessage());
			error.setCode(Constants.DAO_ERROR_SYSTEM_ERROR);
		} else {
			error.setSource("flight data service url is null");
			error.setCode(Constants.DAO_ERROR_SYSTEM_ERROR);
		}
		infoGroup.getError().add(error);
		flightInformationRS.setInfoGroup(infoGroup);
		return flightInformationRS;
	}

	/**
	 * Method creates the client with the give url
	 * 
	 * @param url
	 *            , not null
	 * @return
	 */
	public WebTarget createTarget(URI uri) {
		//LB change
		ClientRequest clientRequest = new ClientRequest.Builder("Flight-Data-Client").
				 withUri(uri.toString()).
				 build();
		LoadBalancedClient lb = LoadBalancedClient.getInstance();

		Client client = ClientBuilder.newClient(new ClientConfig());
		WebTarget target = client.target(lb.getURI(clientRequest));
		return target;
	}
	
}
