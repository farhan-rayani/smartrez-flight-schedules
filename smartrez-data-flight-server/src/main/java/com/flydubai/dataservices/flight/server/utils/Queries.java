package com.flydubai.dataservices.flight.server.utils;

public class Queries {

	
	public static final String FETCH_FLIGHTS_SEGMENTS = "SELECT  FT.CARRIER_CODE, FT.FLIGHT_DATE, FT.FLIGHT_NUMBER, FT.FLIGHT_SUFFIX, FT.OPERATING_CARRIER_CODE, FT.OPERATING_FLIGHT_NUMBER, FT.ROUTE, FT.FLIGHT_STATUS, FT.REMARKS, FT.MODIFY_ACTION, FT.MODIFY_REASON, FT.LAST_MODIFIED_DATE, FT.LAST_MODIFIED_DATE_LTC, FT.LAST_UPDATED_DATE, SEG.BD_AIRPORT_CODE, SEG.OFF_AIRPORT_CODE, SEG.BD_POINT_ORDER, SEG.OFF_POINT_ORDER, SEG.DEP_METRO_GROUP_CODE, SEG.ARR_METRO_GROUP_CODE, SEG.DEP_TIME_UTC, SEG.DEP_TIME_LTC, SEG.ARR_TIME_UTC, SEG.ARR_TIME_LTC, SEG.JOURNEY_TIME, SEG.TRAFFIC_RESTRICTION_CODE, SEG.TOTAL_ADULT_COUNT, SEG.TOTAL_CHILD_COUNT, SEG.TOTAL_INFANT_COUNT, SEG.LOGICAL_FLIGHT_ID, SEG.PRESEAT_STATUS, SEG.LID_OPEN_STATUS, SEG.LAST_MODIFIED_DATE, SEG.LAST_MODIFIED_DATE_LTC FROM FZ_FLT_SEG SEG JOIN FZ_FLT_FLIGHT FT on (FT.CARRIER_CODE = SEG.CARRIER_CODE and FT.FLIGHT_DATE = SEG.FLIGHT_DATE AND FT.FLIGHT_NUMBER = SEG.FLIGHT_NUMBER) WHERE  SEG.DEP_TIME_UTC BETWEEN TO_DATE(?, 'YYYY-MM-DDHH24:MI:SS') AND TO_DATE(?, 'YYYY-MM-DDHH24:MI:SS')";
	public static final String FETCH_FLIGHTS_LEGS = "SELECT  FT.CARRIER_CODE, FT.FLIGHT_DATE, FT.FLIGHT_NUMBER, FT.FLIGHT_SUFFIX, FT.OPERATING_CARRIER_CODE, FT.OPERATING_FLIGHT_NUMBER, FT.ROUTE, FT.FLIGHT_STATUS, FT.REMARKS, FT.LAST_MODIFIED_DATE, FT.LAST_MODIFIED_DATE_LTC, FT.LAST_UPDATED_DATE, LEG.BD_AIRPORT_CODE, LEG.OFF_AIRPORT_CODE, LEG.LEG_ORDER, LEG.DEP_CITY_CODE, LEG.ARR_CITY_CODE, LEG.DEP_METRO_GROUP_CODE, LEG.ARR_METRO_GROUP_CODE, LEG.DEP_TIME_UTC, LEG.DEP_TIME_LTC, LEG.ARR_TIME_UTC, LEG.ARR_TIME_LTC, LEG.ESTIMATED_DEP_TIME_LTC, LEG.ESTIMATED_ARR_TIME_LTC, LEG.ACTUAL_DEP_TIME_LTC, LEG.ACTUAL_ARR_TIME_LTC, LEG.DEP_TERMINAL, LEG.ARR_TERMINAL, LEG.DEP_GATE, LEG.ARR_GATE, LEG.AIRPORT_COMMENTS, LEG.CLOSED_TIME, LEG.STATUS, LEG.DAY_CHANGE, LEG.EQUIPMENT_CODE, LEG.VERSION_CODE, LEG.SEAT_TEMPLATE_CODE, LEG.TAIL_NUMBER, LEG.DELAY_CODE,LEG.LAST_MODIFIED_DATE, LEG.LAST_MODIFIED_DATE_LTC FROM FZ_FLT_FLIGHT FT JOIN FZ_FLT_LEG LEG on (FT.CARRIER_CODE = LEG.CARRIER_CODE and FT.FLIGHT_DATE = LEG.FLIGHT_DATE AND FT.FLIGHT_NUMBER = LEG.FLIGHT_NUMBER) WHERE  LEG.DEP_TIME_UTC BETWEEN TO_DATE(?, 'YYYY-MM-DDHH24:MI:SS') AND TO_DATE(?, 'YYYY-MM-DDHH24:MI:SS')";
	/**
	 * Select query to retrieve data from the table FZ_FLT_SEG_LEG with departure
	 * time range as parameter.
	 */
	public static final String FETCH_FZ_FLT_SEG_LEG = "SELECT "
			+"SEGLEG.FLT_SEG_LEG_ID,SEGLEG.CARRIER_CODE,SEGLEG.FLIGHT_NUMBER,SEGLEG.BD_AIRPORT_CODE,SEGLEG.OFF_AIRPORT_CODE, "
			+"SEGLEG.DEP_TIME_UTC,SEGLEG.DEP_TIME_LTC,SEGLEG.ARR_TIME_UTC,SEGLEG.ARR_TIME_LTC,SEGLEG.LOGICAL_FLIGHT_ID,SEGLEG.EQUIPMENT_CODE, "
			+"SEGLEG.VERSION_CODE,SEGLEG.SEAT_TEMPLATE_CODE,SEGLEG.TAIL_NUMBER,SEGLEG.STATUS,SEGLEG.PRESEAT_STATUS, "
			+"SEGLEG.OPEN_LID_STATUS,SEGLEG.PNL_STATUS,SEGLEG.LAST_MODIFIED_DATE,SEGLEG.LAST_MODIFIED_DATE_LTC,SEGLEG.LAST_UPDATED_DATE "
			+"FROM FZ_FLT_SEG_LEG SEGLEG "
			+"WHERE SEGLEG.CARRIER_CODE = 'FZ' "
			+"AND SEGLEG.STATUS = 'OPEN' "
			+"#DEP_DATE_RANGE# "
			+"#DEP_DATE# "
			+"#FLIGHT_NUM# "
			+"#BD_AIRPORT# "
			+"#OFF_AIRPORT# "
			+"ORDER BY SEGLEG.DEP_TIME_UTC ";
	
	
	public static final String FETCH_CIRCULAR_FLIGHT_DETAILS_RADIX = "SELECT distinct" +
			"  FLIGHT_NUM, " +
			  " FROM_AIRPORT," +
			  " TO_AIRPORT," +
			  " SCH_DEPARTURE," +
			  "  SCH_ARRIVAL" +
			  " FROM schedules s," +
			  "  physical_flights pf" +
			  " WHERE s.physical_flight_id = pf.physical_flight_id" +
			  " #DEP_DATE_RANGE#" +
			  " AND s.schedule_active      = 1" +
			  " #FLIGHT_NUM# " +
			  " and pf.actual_depart_date between S.EFFECTIVE_DATE and S.EXPIRATION_DATE" +
			  " and pf.flight_status = 'OPEN'" +
			  " order by  sch_departure" ;
	
	
	public static final String FETCH_CIRCULAR_FLIGHT_DETAILS = "SELECT distinct"+
   " flight_number , "+
   " BD_AIRPORT_CODE ,"+
   " OFF_AIRPORT_CODE ,"+
   " dep_time_LTC ,"+
   " ARR_TIME_LTC "+
   " FROM FZ_FLT_SEG_LEG" +
			  " WHERE #DEP_DATE_RANGE# " +
			  " AND VERSION_CODE is not null " +
			  " #FLIGHT_NUM# " +
			  " and status = 'OPEN' " +
			  " order by  dep_time_LTC" ;
	

}