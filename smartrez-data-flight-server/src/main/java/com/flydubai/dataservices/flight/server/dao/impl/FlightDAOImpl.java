package com.flydubai.dataservices.flight.server.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.flydubai.dataservices.flight.common.exception.FlightDAOException;
import com.flydubai.dataservices.flight.common.utils.Constants;
import com.flydubai.dataservices.flight.common.utils.DateUtil;
import com.flydubai.dataservices.flight.common.vo.Flight;
import com.flydubai.dataservices.flight.common.vo.Flight.OperatingCarrier;
import com.flydubai.dataservices.flight.common.vo.FlightDetails;
import com.flydubai.dataservices.flight.common.vo.FlightInformationRQParm;
import com.flydubai.dataservices.flight.common.vo.FlightNumberWithSuffixType;
import com.flydubai.dataservices.flight.common.vo.Leg;
import com.flydubai.dataservices.flight.common.vo.Segment;
import com.flydubai.dataservices.flight.server.dao.FlightDAO;
import com.flydubai.dataservices.flight.server.utils.Queries;

@Repository
public class FlightDAOImpl implements FlightDAO{

	/**
	 * Default Constructor
	 */
	public FlightDAOImpl() {

	}

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplateResODS;

	Logger logger = LoggerFactory.getLogger(FlightDAOImpl.class);

	/**
	 * This method is to create OperatingCarrier object from rowSet
	 * 
	 * @param rowSet
	 *            as SqlRowSet
	 * @return OperatingCarrier
	 */
	private OperatingCarrier getOperatingLegCarrier(SqlRowSet rowSet) {
		OperatingCarrier operatingCarrier = new OperatingCarrier();
		operatingCarrier.setAirlineCode(rowSet.getString(Constants.FZ_FLT_SEG_LEG_CARRIER_CODE));
		//operatingCarrier.setFlightNumber(getFlightNumberWithSuffixType(rowSet));
		return operatingCarrier;
	}
	
	/**
	 * 
	 */
	@Override
	public List<FlightDetails> fetchFlightODDetails(
			FlightInformationRQParm flightInformationRQParm)
			throws FlightDAOException {
		List<FlightDetails> listOfFlightDetails = new ArrayList<FlightDetails>();
		try{
			StringBuilder query = new StringBuilder();
			query.append("SELECT  ");
			query.append(" (SELECT FLIGHT_NUM FROM LOGICAL_SCHEDULES LS1 WHERE PF.PHYSICAL_FLIGHT_ID = LS1.FIRST_LEG_PFID AND LS1.FIRST_LEG_PFID = LS1.LAST_LEG_PFID) leg_flight_num, ");
			query.append(" FS.FROM_AIRPORT,FS.TO_AIRPORT,FM.FLIGHT_ORDER,Pf.Sch_Departure,Pf.Sch_Arrival ");
			query.append(" FROM  ");
			query.append(" LOGICAL_FLIGHTS LF, ");
			query.append(" LOGICAL_SCHEDULES LS, ");
			query.append(" FLIGHT_MAP FM, ");
			query.append(" PHYSICAL_FLIGHTS PF, ");
			query.append(" FLIGHT_SCHEDULES FS ");
			query.append(" WHERE  ");
			query.append(" LF.LOGICAL_FLIGHT_ID = LS.LOGICAL_FLIGHT_ID ");
			query.append(" AND LF.LOGICAL_FLIGHT_ID = FM.LOGICAL_FLIGHT_ID ");
			query.append(" AND FM.PHYSICAL_FLIGHT_ID = PF.PHYSICAL_FLIGHT_ID ");
			query.append(" AND LF.DEPARTURE_DATE + FM.TIME_ADJUSTOR = PF.ACTUAL_DEPART_DATE ");
			query.append(" AND PF.PHYSICAL_FLIGHT_ID = FS.PHYSICAL_FLIGHT_ID ");
			query.append(" AND LS.From_Airport=RPAD(?,4) ");
			query.append(" AND LS.To_Airport=RPAD(?,4) ");
			query.append(" AND LS.Flight_Num=? ");
			query.append(" AND LF.DEPARTURE_DATE = TO_DATE(?,'YYYY-MM-DD') order by Fm.Flight_Order ");
					
			List<Object> paramList = new ArrayList<Object>();
			paramList.add(flightInformationRQParm.getBoardAirportCode().trim().toUpperCase());
			paramList.add(flightInformationRQParm.getOffAirportCode().trim().toUpperCase());
			paramList.add(String.valueOf(flightInformationRQParm.getFlightNumber()));
			paramList.add(flightInformationRQParm.getDepartureDateString());
			Object[] params = paramList.toArray();
			SqlRowSet rowSet = jdbcTemplateResODS.queryForRowSet(query.toString(), params);
			FlightDetails flightDetails = new FlightDetails();
			Flight flight = new Flight();
			FlightNumberWithSuffixType fn = new FlightNumberWithSuffixType();
			fn.setValue(flightInformationRQParm.getFlightNumber());
			flight.setFlightNumber(fn);
			OperatingCarrier oc = new OperatingCarrier();
			oc.setAirlineCode("FZ");
			//flight.setDate(DateUtil.getXmlGregorianCalendar(flightInformationRQParm.getDepartureDate()));
			flight.setOperatingCarrier(oc);
			while(rowSet.next()){
				Leg leg = new Leg();
				leg.setBoardAirportCode(rowSet.getString(2));
				leg.setOffAirportCode(rowSet.getString(3));
				leg.setLegOrder(rowSet.getInt(4));
				leg.setDepTimeLTC(DateUtil.getXMLGregorianCalendarVal(rowSet.getTimestamp(5)));
				leg.setArrivalTimeLTC(DateUtil.getXMLGregorianCalendarVal(rowSet.getTimestamp(6)));
				flightDetails.getLeg().add(leg);
			}
			flightDetails.setFlight(flight);
			listOfFlightDetails.add(flightDetails);
			
		}catch(Exception e){
			e.printStackTrace();
			listOfFlightDetails = null;
			throw new FlightDAOException(
					"Exception in fetchFlightODDetails", e,
					Constants.DAO_ERROR_SYSTEM_ERROR);
		}
		return listOfFlightDetails;
	}
	
	/**
	 * 
	 * @param fltInfoparam
	 * @return
	 * @throws DataAccessException
	 */
	@Override
	public List<FlightDetails> fetchFlightSegLegDetails (FlightInformationRQParm fltInfoparam) throws FlightDAOException {
		List<FlightDetails> listOfFlightDetails = new ArrayList<FlightDetails>();
		logger.debug("fetchFlightSegLegDetails :ENTRY {}", fltInfoparam);
		try {
			String query = Queries.FETCH_FZ_FLT_SEG_LEG;
			List<Object> paramList = new ArrayList<Object>();
			
			if (fltInfoparam.getDepartureStartDateStringUTC() != null
					&& !fltInfoparam.getDepartureStartDateStringUTC().trim().isEmpty()
					&& fltInfoparam.getDepartureEndDateStringUTC() != null
					&& !fltInfoparam.getDepartureEndDateStringUTC().trim().isEmpty()) {
				query = query.replace("#DEP_DATE_RANGE#",
						"AND SEGLEG.DEP_TIME_UTC BETWEEN TO_DATE(?, 'YYYY-MM-DDHH24:MI:SS') "
								+ "AND TO_DATE(?, 'YYYY-MM-DDHH24:MI:SS') ");
				paramList.add(fltInfoparam.getDepartureStartDateStringUTC());
				paramList.add(fltInfoparam.getDepartureEndDateStringUTC());
			} else {
				query = query.replace("#DEP_DATE_RANGE#", "");
			}

			if (fltInfoparam.getDepartureDateString() != null
					&& !fltInfoparam.getDepartureDateString().trim().isEmpty()) {
				query = query.replace("#DEP_DATE#", "AND SEGLEG.DEPARTURE_DATE = TO_DATE(?,'YYYY-MM-DD') ");
				paramList.add(fltInfoparam.getDepartureDateString());
			} else {
				query = query.replace("#DEP_DATE#", "");
			}

			if (fltInfoparam.getFlightNumber() > 0) {
				query = query.replace("#FLIGHT_NUM#", "AND SEGLEG.FLIGHT_NUMBER = ? ");
				paramList.add(fltInfoparam.getFlightNumber());
			} else {
				query = query.replace("#FLIGHT_NUM#", "");
			}

			if (fltInfoparam.getBoardAirportCode() != null
					&& !fltInfoparam.getBoardAirportCode().trim().isEmpty()) {
				query = query.replace("#BD_AIRPORT#", "AND SEGLEG.BD_AIRPORT_CODE = ? ");
				paramList.add(fltInfoparam.getBoardAirportCode().trim());
			} else {
				query = query.replace("#BD_AIRPORT#", "");
			}
			if (fltInfoparam.getOffAirportCode() != null
					&& !fltInfoparam.getOffAirportCode().trim().isEmpty()) {
				query = query.replace("#OFF_AIRPORT#", "AND SEGLEG.OFF_AIRPORT_CODE = ? ");
				paramList.add(fltInfoparam.getOffAirportCode().trim());
			} else {
				query = query.replace("#OFF_AIRPORT#", "");
			}
			
			Object[] parms = paramList.toArray();
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, parms );
			while (rowSet.next()) {
				FlightDetails flightDetails = new FlightDetails();
				Flight flight = new Flight();
				flight.setOperatingCarrier(getOperatingLegCarrier(rowSet));
				flight.setDate(DateUtil.getXMLGregorianCalendarVal(rowSet.getTimestamp(Constants.FZ_FLT_SEG_LEG_DEP_TIME_LTC)));;
				Segment flightSegment = new Segment();
				flightSegment.setFlightNumberDetails(rowSet.getString(Constants.FZ_FLT_SEG_LEG_FLIGHT_NUMBER));
				flightSegment.setBoardAirportCode(rowSet.getString(Constants.FZ_FLT_SEG_LEG_BD_AIRPORT_CODE));
				flightSegment.setOffAirportCode(rowSet.getString(Constants.FZ_FLT_SEG_LEG_OFF_AIRPORT_CODE));
				flightSegment.setDepTimeUTC(DateUtil.getXMLGregorianCalendarVal(rowSet.getTimestamp(Constants.FZ_FLT_SEG_LEG_DEP_TIME_UTC)));
				flightSegment.setDepTimeLTC(DateUtil.getXMLGregorianCalendarVal(rowSet.getTimestamp(Constants.FZ_FLT_SEG_LEG_DEP_TIME_LTC)));
				flightSegment.setArrivalTimeUTC(DateUtil.getXMLGregorianCalendarVal(rowSet.getTimestamp(Constants.FZ_FLT_SEG_LEG_ARR_TIME_UTC)));
				flightSegment.setArrivalTimeLTC(DateUtil.getXMLGregorianCalendarVal(rowSet.getTimestamp(Constants.FZ_FLT_SEG_LEG_ARR_TIME_LTC)));
				flightSegment.setLogicalFlightId(rowSet.getLong(Constants.FZ_FLT_SEG_LEG_LOGICAL_FLIGHT_ID));
				flightSegment.setEquipmentCode(rowSet.getString(Constants.FZ_FLT_SEG_LEG_EQUIPMENT_CODE));
				flightSegment.setEquipmentVersionCode(rowSet.getString(Constants.FZ_FLT_SEG_LEG_VERSION_CODE));
				flightSegment.setSeatTemplateCode(rowSet.getString(Constants.FZ_FLT_SEG_LEG_SEAT_TEMPLATE_CODE));
				flightSegment.setTailNumber(rowSet.getString(Constants.FZ_FLT_SEG_LEG_TAIL_NUMBER));
				flightSegment.setPreSeatStatus(rowSet.getString(Constants.FZ_FLT_SEG_LEG_PRESEAT_STATUS));
				flightSegment.setLIDOpenStatus(rowSet.getString(Constants.FZ_FLT_SEG_LEG_OPEN_LID_STATUS));
				flightSegment.setPNLStatus(rowSet.getString(Constants.FZ_FLT_SEG_LEG_PNL_STATUS));
				flightDetails.getSegment().add(flightSegment);
				flightDetails.setFlight(flight);
				listOfFlightDetails.add(flightDetails);
			}
			
		} catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			logger.error("EmptyResultDataAccessException in fetchFlightSegLegDetails ", emptyResultDataAccessException);
			listOfFlightDetails = null;
			throw new FlightDAOException(
					"EmptyResultDataAccessException in fetchFlightSegLegDetails",
					emptyResultDataAccessException,
					Constants.DAO_ERROR_CODE_EMPTY_RESULT);
		} catch (DataAccessException dataAccessException) {
			logger.error("DataAccessException in fetchFlightSegLegDetails ", dataAccessException);
			listOfFlightDetails = null;
			throw new FlightDAOException(
					"DataAccessException in fetchFlightSegLegDetails",
					dataAccessException, Constants.DAO_ERROR_CODE_DATA_ACCESS);
		} catch (Exception e) {
			logger.error("Exception in fetchFlightSegLegDetails ", e);
			listOfFlightDetails = null;
			throw new FlightDAOException(
					"Exception in fetchFlightSegLegDetails", e,
					Constants.DAO_ERROR_SYSTEM_ERROR);
		}
		logger.debug("fetchFlightSegLegDetails :EXIT {}", fltInfoparam);
		return listOfFlightDetails;
	}
	
	/**
	 * 
	 * @param fltInfoparam
	 * @return
	 * @throws DataAccessException
	 */
	@Override
	public List<FlightDetails> fetchCircularFlightLegDetails (FlightInformationRQParm fltInfoparam) throws FlightDAOException {
		List<FlightDetails> listOfFlightDetails = new ArrayList<FlightDetails>();
		logger.debug("fetchFlightSegLegDetails :ENTRY {}", fltInfoparam);
		try {
			//String query = Queries.FETCH_CIRCULAR_FLIGHT_DETAILS_RADIX;
			String query = Queries.FETCH_CIRCULAR_FLIGHT_DETAILS;
			List<Object> paramList = new ArrayList<Object>();
			
			if(fltInfoparam.getDepartureDateString() != null){
				String[] depDate = fltInfoparam.getDepartureDateString().split("-");
				int year = Integer.parseInt(depDate[0]);
				int month = Integer.parseInt(depDate[1]);
				int day = Integer.parseInt(depDate[2]);
				fltInfoparam.setDepartureDate(LocalDate.of(year, month, day));
			}
			if(fltInfoparam.getDepartureDate() != null){
			   LocalDate startDate =  fltInfoparam.getDepartureDate();
			   fltInfoparam.setDepartureStartDateStringUTC(startDate.plusDays(-4).toString());
			   
			   LocalDate endDate =  fltInfoparam.getDepartureDate();
			   fltInfoparam.setDepartureEndDateStringUTC(endDate.plusDays(4).toString());
			}
			
			if (fltInfoparam.getDepartureStartDateStringUTC() != null
					&& !fltInfoparam.getDepartureStartDateStringUTC().trim().isEmpty()
					&& fltInfoparam.getDepartureEndDateStringUTC() != null
					&& !fltInfoparam.getDepartureEndDateStringUTC().trim().isEmpty()) {
				//radixx
				/*query = query.replace("#DEP_DATE_RANGE#",
						"AND pf.actual_depart_date BETWEEN TO_DATE(?, 'YYYY-MM-DD') "
								+ "AND TO_DATE(?, 'YYYY-MM-DD') ");*/
				
				query = query.replace("#DEP_DATE_RANGE#",
						" trunc(dep_time_LTC) BETWEEN TO_DATE(?, 'YYYY-MM-DD') "
								+ "AND TO_DATE(?, 'YYYY-MM-DD') ");
				
				paramList.add(fltInfoparam.getDepartureStartDateStringUTC());
				paramList.add(fltInfoparam.getDepartureEndDateStringUTC());
				/*paramList.add("05May2015");
				paramList.add("09May2015");*/
				
			} else {
				query = query.replace("#DEP_DATE_RANGE#", "");
			}

			/*if (fltInfoparam.getFlightNumber() > 0) {
				query = query.replace("#FLIGHT_NUM#", "AND flight_num = ? ");
				paramList.add(fltInfoparam.getFlightNumber());
			} else {
				query = query.replace("#FLIGHT_NUM#", "");
			}*/
			
			if (fltInfoparam.getOandDNumber() != null) {
				String[] flightNumbers = fltInfoparam.getOandDNumber().split("/");
				int length = flightNumbers.length;
				StringBuffer flightNumber = new StringBuffer();
				for(int i=0;i <length ;i++){
					flightNumber.append("'").append(flightNumbers[i]).append("'"); 
					if(i!= length-1){
						flightNumber.append(",");
					}
				}
				//radixx
				//String flightNumberQuery = "AND flight_num in (" + flightNumber + ")";
				String flightNumberQuery = "AND flight_number in (" + flightNumber + ")";
				query = query.replace("#FLIGHT_NUM#",flightNumberQuery);
				//paramList.add(fltInfoparam.getFlightNumber());
			} else {
				query = query.replace("#FLIGHT_NUM#", "");
			}

			
			Object[] parms = paramList.toArray();
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, parms );
			FlightDetails flightDetails = null;
			Flight flight = null;
			while (rowSet.next()) {
				if(flightDetails == null){
					flightDetails = new FlightDetails();
					flight = new Flight();
				}
				
				Leg leg = new Leg();
				//radixx
				/*leg.setBoardAirportCode(rowSet.getString(Constants.FROM_AIRPORT).trim());
				leg.setOffAirportCode(rowSet.getString(Constants.TO_AIRPORT).trim());
				leg.setDepTimeLTC(DateUtil.getXMLGregorianCalendarVal(rowSet.getTimestamp(Constants.SCH_DEPARTURE)));
				leg.setArrivalTimeLTC(DateUtil.getXMLGregorianCalendarVal(rowSet.getTimestamp(Constants.SCH_ARRIVAL)));
				leg.setFlightNumber(rowSet.getInt(Constants.FLIGHT_NUM));*/
				
				leg.setBoardAirportCode(rowSet.getString(Constants.FZ_FLT_LEG_BD_AIRPORT_CODE).trim());
				leg.setOffAirportCode(rowSet.getString(Constants.FZ_FLT_LEG_OFF_AIRPORT_CODE).trim());
				leg.setDepTimeLTC(DateUtil.getXMLGregorianCalendarVal(rowSet.getTimestamp(Constants.FZ_FLT_LEG_DEP_TIME_LTC)));
				leg.setArrivalTimeLTC(DateUtil.getXMLGregorianCalendarVal(rowSet.getTimestamp(Constants.FZ_FLT_LEG_ARR_TIME_LTC)));
				FlightNumberWithSuffixType  flightNumberWithSuffixType = new FlightNumberWithSuffixType();
				flightNumberWithSuffixType.setValue(rowSet.getInt(Constants.FZ_FLT_SEG_LEG_FLIGHT_NUMBER));
				leg.setFlightNumber(flightNumberWithSuffixType);
				
				flightDetails.getLeg().add(leg);
				flightDetails.setFlight(flight);
			}
			listOfFlightDetails.add(flightDetails);
			
		} catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			logger.error("EmptyResultDataAccessException in fetchFlightSegLegDetails ", emptyResultDataAccessException);
			listOfFlightDetails = null;
			throw new FlightDAOException(
					"EmptyResultDataAccessException in fetchFlightSegLegDetails",
					emptyResultDataAccessException,
					Constants.DAO_ERROR_CODE_EMPTY_RESULT);
		} catch (DataAccessException dataAccessException) {
			logger.error("DataAccessException in fetchFlightSegLegDetails ", dataAccessException);
			listOfFlightDetails = null;
			throw new FlightDAOException(
					"DataAccessException in fetchFlightSegLegDetails",
					dataAccessException, Constants.DAO_ERROR_CODE_DATA_ACCESS);
		} catch (Exception e) {
			logger.error("Exception in fetchFlightSegLegDetails ", e);
			listOfFlightDetails = null;
			throw new FlightDAOException(
					"Exception in fetchFlightSegLegDetails", e,
					Constants.DAO_ERROR_SYSTEM_ERROR);
		}
		logger.debug("fetchFlightSegLegDetails :EXIT {}", fltInfoparam);
		
		if(listOfFlightDetails != null && listOfFlightDetails.get(0) != null){
			List<Leg> legs = listOfFlightDetails.get(0).getLeg();
			Leg[] legArray = new Leg[legs.size()];
			int searchIndex = -1;
			if(legs != null){
				int size = legs.size();
				for(int i=0;i <size;i++){
					Leg leg = legs.get(i);
					legArray[i] = leg;
					if(leg.getBoardAirportCode().equals(fltInfoparam.getBoardAirportCode())
							&& DateUtil.getDateString(leg.getDepTimeLTC(),Constants.DEP_DATE_FORMAT).equals(
									DateUtil.getDateString(fltInfoparam.getDepartureDate(),Constants.DEP_DATE_FORMAT) )){
						searchIndex = i;
					}
					
					/*if(leg.getBoardAirportCode().equals(fltInfoparam.getBoardAirportCode())
					&& DateUtil.getDateString(leg.getDepTimeLTC(),Constants.DEP_DATE_FORMAT).equals(
							"09May2015") ){
				             searchIndex = i;
			             }*/
				}
			}
			if(searchIndex != -1){
				List<Leg> newLegs = new ArrayList<Leg>();
				List<String> boardAirportCodes= new ArrayList<String>();
				List<String> offAirportCodes= new ArrayList<String>();
				if(fltInfoparam.getRoute() != null ){
					String[] routeArray = fltInfoparam.getRoute().split("-");
					boardAirportCodes.add(routeArray[0]);
					offAirportCodes.add(routeArray[routeArray.length-1]);
				}else{
					boardAirportCodes.add("DXB");
					boardAirportCodes.add("DWC");
					offAirportCodes.add("DXB");
					offAirportCodes.add("DWC");
				}
				int arrayLength = legArray.length;
				for(int index =searchIndex ; index<arrayLength; index++){
					Leg leg = legArray[index];
					if(offAirportCodes.contains(leg.getOffAirportCode())){
						newLegs.add(leg);
						break;
					}
					newLegs.add(leg);
				}
				Leg searchLeg = legArray[searchIndex];
				if(!boardAirportCodes.contains(searchLeg.getBoardAirportCode())){
					for(int index =searchIndex-1 ; index>=0; index--){
						Leg leg = legArray[index];
						if(boardAirportCodes.contains(leg.getBoardAirportCode())){
							newLegs.add(leg);
							break;
						}
						newLegs.add(leg);
					}
				}
				Collections.sort(newLegs, new Comparator<Leg>() {
		            public int compare(Leg o1, Leg o2) {
		                return ((DateUtil.getCalendar((o1.getDepTimeLTC()))).getTime().compareTo((DateUtil.getCalendar((o2.getDepTimeLTC())).getTime())));
		            }
		          });
				listOfFlightDetails.get(0).getLeg().removeAll(legs);
				listOfFlightDetails.get(0).getLeg().addAll(newLegs);
				StringBuffer route = new StringBuffer();
				boolean isFirstTime = true;
				for(Leg leg: newLegs ){
					if(isFirstTime){
						route.append(leg.getBoardAirportCode()).append("-").append(leg.getOffAirportCode());
					}else{
						route.append("-").append(leg.getOffAirportCode()); 
					}
					isFirstTime = false;
				}
				listOfFlightDetails.get(0).getFlight().setDate(newLegs.get(0).getDepTimeLTC());
				listOfFlightDetails.get(0).getFlight().setRoute(route.toString());
			}else{
				listOfFlightDetails.get(0).getLeg().removeAll(legs);
			}
		}
		return listOfFlightDetails;
	}

}
