--------------------------------------------------------
--  File created - Tuesday-January-06-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table FZ_FLT_CODESHARE_MAPPING
--------------------------------------------------------

  CREATE TABLE "FZ_FLT_CODESHARE_MAPPING" 
   (	"MKT_CARRIER_CODE" VARCHAR2(6 BYTE), 
	"MKT_FLIGHT_DATE" DATE, 
	"MKT_FLIGHT_NUMBER" NUMBER(5,0), 
	"FLIGHT_SUFFIX" VARCHAR2(1 BYTE), 
	"OPERATING_CARRIER_CODE" VARCHAR2(6 BYTE), 
	"OPERATING_FLIGHT_DATE" DATE, 
	"OPERATING_FLIGHT_NUMBER" NUMBER(5,0), 
	"LAST_MODIFIED_DATE" TIMESTAMP (6), 
	"LAST_MODIFIED_DATE_LTC" TIMESTAMP (6), 
	"LAST_UPDATED_DATE" TIMESTAMP (6)
   ) ;

   COMMENT ON COLUMN "FZ_FLT_CODESHARE_MAPPING"."MKT_CARRIER_CODE" IS 'Marketing carrier code';
   COMMENT ON COLUMN "FZ_FLT_CODESHARE_MAPPING"."MKT_FLIGHT_DATE" IS 'Marketing Flights Date';
   COMMENT ON COLUMN "FZ_FLT_CODESHARE_MAPPING"."MKT_FLIGHT_NUMBER" IS 'Marketing Flight Number';
   COMMENT ON COLUMN "FZ_FLT_CODESHARE_MAPPING"."FLIGHT_SUFFIX" IS 'To be removed from the actual table';
   COMMENT ON COLUMN "FZ_FLT_CODESHARE_MAPPING"."OPERATING_CARRIER_CODE" IS 'Operating carrier code';
   COMMENT ON COLUMN "FZ_FLT_CODESHARE_MAPPING"."OPERATING_FLIGHT_DATE" IS 'Operating Flight Date';
   COMMENT ON COLUMN "FZ_FLT_CODESHARE_MAPPING"."OPERATING_FLIGHT_NUMBER" IS 'Operating Flight Number';
   COMMENT ON COLUMN "FZ_FLT_CODESHARE_MAPPING"."LAST_MODIFIED_DATE" IS 'Last modified date in the source in GMT';
   COMMENT ON COLUMN "FZ_FLT_CODESHARE_MAPPING"."LAST_MODIFIED_DATE_LTC" IS 'Last modified date in the source in GST';
   COMMENT ON COLUMN "FZ_FLT_CODESHARE_MAPPING"."LAST_UPDATED_DATE" IS 'Last Updated time in the ODS';
   COMMENT ON TABLE "FZ_FLT_CODESHARE_MAPPING"  IS 'Marketing Code share Flight mapping with Operating Flights';
--------------------------------------------------------
--  DDL for Table FZ_FLT_CONNECTIONS
--------------------------------------------------------

  CREATE TABLE "FZ_FLT_CONNECTIONS" 
   (	"CARRIER_CODE" VARCHAR2(6 BYTE), 
	"FLIGHT_DATE" DATE, 
	"FLIGHT_NUMBER" NUMBER(5,0), 
	"FLIGHT_SUFFIX" VARCHAR2(1 BYTE), 
	"CONN_GROUP_ID" NUMBER(15,0), 
	"SCHEDULE_ID" NUMBER(15,0), 
	"CONNECTION_ORDER" NUMBER(4,0), 
	"ORIGIN" VARCHAR2(5 BYTE), 
	"DESTINATION" VARCHAR2(5 BYTE), 
	"BD_AIRPORT_CODE" VARCHAR2(5 BYTE), 
	"OFF_AIRPORT_CODE" VARCHAR2(5 BYTE), 
	"FLIGHT_NUMBERS" VARCHAR2(15 BYTE), 
	"ROUTE_DETAILS" VARCHAR2(30 BYTE), 
	"JOURNEY_TIME" NUMBER(15,0), 
	"DAY_CHANGE" NUMBER(2,0), 
	"STATUS" VARCHAR2(20 BYTE), 
	"LAST_MODIFIED_DATE" TIMESTAMP (6), 
	"LAST_MODIFIED_DATE_LTC" TIMESTAMP (6), 
	"LAST_UPDATED_DATE" TIMESTAMP (6)
   ) ;

   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."CARRIER_CODE" IS 'Eg : FZ, EK';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."FLIGHT_NUMBER" IS 'Flight Number';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."FLIGHT_SUFFIX" IS 'In case of delays/ changes, the same flight will be flown with a different suffix like A. Flight Number will be then identified as 100A instead of 100.';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."CONN_GROUP_ID" IS 'Id to represent the connection flights within a group.';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."SCHEDULE_ID" IS 'Refers to fz_sch_schedule.schedule_id';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."CONNECTION_ORDER" IS 'Order of Flights';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."ORIGIN" IS 'Origin airport of the first flight';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."DESTINATION" IS 'Destination airport of the last flight';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."BD_AIRPORT_CODE" IS 'Board airport code of the schedule leg.';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."OFF_AIRPORT_CODE" IS 'Off airport code of the schedule leg';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."FLIGHT_NUMBERS" IS 'FLight numbers in the connection appended with "/". Eg : 1758 / 3004';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."ROUTE_DETAILS" IS 'Route of the connection FLight . Eg : DOH-DXB/DXB-CMB';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."JOURNEY_TIME" IS 'Journey Time in Seconds';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."DAY_CHANGE" IS 'Day changes in case the departure and the arrival dates are different.';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."STATUS" IS 'Indicates whether the connection is NOOP, CANCELLED or ACTIVE';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."LAST_MODIFIED_DATE" IS 'Last modified date in the source in GMT';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."LAST_MODIFIED_DATE_LTC" IS 'Last modified date in the source in GST';
   COMMENT ON COLUMN "FZ_FLT_CONNECTIONS"."LAST_UPDATED_DATE" IS 'Last Updated time in the ODS';
   COMMENT ON TABLE "FZ_FLT_CONNECTIONS"  IS 'Define the connection flights';
--------------------------------------------------------
--  DDL for Table FZ_FLT_FLIGHT
--------------------------------------------------------

  CREATE TABLE "FZ_FLT_FLIGHT" 
   (	"CARRIER_CODE" VARCHAR2(6 BYTE), 
	"FLIGHT_DATE" DATE, 
	"FLIGHT_NUMBER" NUMBER(5,0), 
	"FLIGHT_SUFFIX" VARCHAR2(1 BYTE), 
	"OPERATING_CARRIER_CODE" VARCHAR2(6 BYTE), 
	"OPERATING_FLIGHT_NUMBER" NUMBER(5,0), 
	"ROUTE" VARCHAR2(20 BYTE), 
	"SCHEDULE_ID" NUMBER(15,0), 
	"FLIGHT_STATUS" VARCHAR2(20 BYTE), 
	"REMARKS" VARCHAR2(4000 BYTE), 
	"MODIFY_ACTION" VARCHAR2(255 BYTE), 
	"MODIFY_REASON" VARCHAR2(50 BYTE), 
	"LAST_MODIFIED_DATE" TIMESTAMP (6), 
	"LAST_MODIFIED_DATE_LTC" TIMESTAMP (6), 
	"LAST_UPDATED_DATE" TIMESTAMP (6)
   ) ;

   COMMENT ON COLUMN "FZ_FLT_FLIGHT"."CARRIER_CODE" IS 'Eg : FZ, EK';
   COMMENT ON COLUMN "FZ_FLT_FLIGHT"."FLIGHT_DATE" IS 'Flight Date';
   COMMENT ON COLUMN "FZ_FLT_FLIGHT"."FLIGHT_NUMBER" IS 'Flight Number';
   COMMENT ON COLUMN "FZ_FLT_FLIGHT"."FLIGHT_SUFFIX" IS 'In case of delays/ changes, the same flight will be flown with a different suffix like A. Flight Number will be then identified as 100A instead of 100.';
   COMMENT ON COLUMN "FZ_FLT_FLIGHT"."OPERATING_CARRIER_CODE" IS 'Operating Carrier Code in case of code share flights';
   COMMENT ON COLUMN "FZ_FLT_FLIGHT"."OPERATING_FLIGHT_NUMBER" IS 'Operating Flight Number in case of code share flights';
   COMMENT ON COLUMN "FZ_FLT_FLIGHT"."ROUTE" IS 'Flight Route. The airports appended using the delimiter "-"/ Eg: CMB-HRI-DXB';
   COMMENT ON COLUMN "FZ_FLT_FLIGHT"."SCHEDULE_ID" IS 'Refers to fz_sch_schedule.schedule_id';
   COMMENT ON COLUMN "FZ_FLT_FLIGHT"."FLIGHT_STATUS" IS 'Flight Status. Eg: CANCELLED, OPEN';
   COMMENT ON COLUMN "FZ_FLT_FLIGHT"."MODIFY_ACTION" IS 'Last modified action - TIME_CHANGE, STATUS_CHANGE';
   COMMENT ON COLUMN "FZ_FLT_FLIGHT"."MODIFY_REASON" IS 'Reason for the status modification.
Eg: Technical Problems, de-icing';
   COMMENT ON COLUMN "FZ_FLT_FLIGHT"."LAST_MODIFIED_DATE" IS 'Last modified date in the source in GMT';
   COMMENT ON COLUMN "FZ_FLT_FLIGHT"."LAST_MODIFIED_DATE_LTC" IS 'Last modified date in the source in GST';
   COMMENT ON COLUMN "FZ_FLT_FLIGHT"."LAST_UPDATED_DATE" IS 'Last Updated time in the ODS';
   COMMENT ON TABLE "FZ_FLT_FLIGHT"  IS 'Stores the Flights information';
--------------------------------------------------------
--  DDL for Table FZ_FLT_LEG
--------------------------------------------------------

  CREATE TABLE "FZ_FLT_LEG" 
   (	"CARRIER_CODE" VARCHAR2(6 BYTE), 
	"FLIGHT_DATE" DATE, 
	"FLIGHT_NUMBER" NUMBER(5,0), 
	"FLIGHT_SUFFIX" VARCHAR2(1 BYTE), 
	"BD_AIRPORT_CODE" VARCHAR2(5 BYTE), 
	"OFF_AIRPORT_CODE" VARCHAR2(5 BYTE), 
	"LEG_ORDER" NUMBER(4,0), 
	"DEP_CITY_CODE" VARCHAR2(5 BYTE), 
	"ARR_CITY_CODE" VARCHAR2(5 BYTE), 
	"DEP_METRO_GROUP_CODE" VARCHAR2(5 BYTE), 
	"ARR_METRO_GROUP_CODE" VARCHAR2(5 BYTE), 
	"DEP_TIME_UTC" DATE, 
	"DEP_TIME_LTC" DATE, 
	"ARR_TIME_UTC" DATE, 
	"ARR_TIME_LTC" DATE, 
	"SCHEDULE_ID" NUMBER(15,0), 
	"ESTIMATED_DEP_TIME_LTC" DATE, 
	"ESTIMATED_ARR_TIME_LTC" DATE, 
	"ACTUAL_DEP_TIME_LTC" DATE, 
	"ACTUAL_ARR_TIME_LTC" DATE, 
	"DEP_TERMINAL" VARCHAR2(5 BYTE), 
	"ARR_TERMINAL" VARCHAR2(5 BYTE), 
	"DEP_GATE" VARCHAR2(5 BYTE), 
	"ARR_GATE" VARCHAR2(5 BYTE), 
	"AIRPORT_COMMENTS" VARCHAR2(4000 BYTE), 
	"CLOSED_TIME" DATE, 
	"STATUS" VARCHAR2(20 BYTE), 
	"DAY_CHANGE" NUMBER(2,0), 
	"EQUIPMENT_CODE" VARCHAR2(15 BYTE), 
	"VERSION_CODE" VARCHAR2(15 BYTE), 
	"SEAT_TEMPLATE_CODE" VARCHAR2(50 BYTE), 
	"TAIL_NUMBER" VARCHAR2(30 BYTE), 
	"DELAY_CODE" VARCHAR2(30 BYTE), 
	"LAST_MODIFIED_DATE" TIMESTAMP (6), 
	"LAST_MODIFIED_DATE_LTC" TIMESTAMP (6), 
	"LAST_UPDATED_DATE" TIMESTAMP (6)
   ) ;

   COMMENT ON COLUMN "FZ_FLT_LEG"."CARRIER_CODE" IS 'Eg : FZ, EK';
   COMMENT ON COLUMN "FZ_FLT_LEG"."FLIGHT_NUMBER" IS 'Flight Number';
   COMMENT ON COLUMN "FZ_FLT_LEG"."FLIGHT_SUFFIX" IS 'In case of delays/ changes, the same flight will be flown with a different suffix like A. Flight Number will be then identified as 100A instead of 100.';
   COMMENT ON COLUMN "FZ_FLT_LEG"."BD_AIRPORT_CODE" IS 'Board airport code of the schedule leg.';
   COMMENT ON COLUMN "FZ_FLT_LEG"."OFF_AIRPORT_CODE" IS 'Off airport code of the schedule leg';
   COMMENT ON COLUMN "FZ_FLT_LEG"."LEG_ORDER" IS 'For the first leg, this will be 1, for the second leg, this will be 2 and so on';
   COMMENT ON COLUMN "FZ_FLT_LEG"."DEP_CITY_CODE" IS 'Departure City Code';
   COMMENT ON COLUMN "FZ_FLT_LEG"."ARR_CITY_CODE" IS 'Arrival City Code';
   COMMENT ON COLUMN "FZ_FLT_LEG"."DEP_METRO_GROUP_CODE" IS 'Departure Metro Group';
   COMMENT ON COLUMN "FZ_FLT_LEG"."ARR_METRO_GROUP_CODE" IS 'Arrival airport Metro Group';
   COMMENT ON COLUMN "FZ_FLT_LEG"."DEP_TIME_UTC" IS 'Departure time of the flight from the airport in GMT';
   COMMENT ON COLUMN "FZ_FLT_LEG"."DEP_TIME_LTC" IS 'Departure time of the flight in local departing airport time zone';
   COMMENT ON COLUMN "FZ_FLT_LEG"."ARR_TIME_UTC" IS 'Arrival time in GMT';
   COMMENT ON COLUMN "FZ_FLT_LEG"."ARR_TIME_LTC" IS 'Arrival time of the flight in local arrival airport time zone';
   COMMENT ON COLUMN "FZ_FLT_LEG"."SCHEDULE_ID" IS 'Refers to fz_sch_schedule.schedule_id';
   COMMENT ON COLUMN "FZ_FLT_LEG"."ESTIMATED_DEP_TIME_LTC" IS 'Estimated Departure Time in Local time of the airport';
   COMMENT ON COLUMN "FZ_FLT_LEG"."ESTIMATED_ARR_TIME_LTC" IS 'Estimated Arrival Time in Local time of the airport';
   COMMENT ON COLUMN "FZ_FLT_LEG"."ACTUAL_DEP_TIME_LTC" IS 'Actual Departure Time in Local time of the airport';
   COMMENT ON COLUMN "FZ_FLT_LEG"."ACTUAL_ARR_TIME_LTC" IS 'Actual Arrival Time in Local time of the airport';
   COMMENT ON COLUMN "FZ_FLT_LEG"."DEP_TERMINAL" IS 'Departure Terminal code';
   COMMENT ON COLUMN "FZ_FLT_LEG"."ARR_TERMINAL" IS 'Arrival Terminal Code';
   COMMENT ON COLUMN "FZ_FLT_LEG"."DEP_GATE" IS 'Departure gate';
   COMMENT ON COLUMN "FZ_FLT_LEG"."ARR_GATE" IS 'Arrival Gate';
   COMMENT ON COLUMN "FZ_FLT_LEG"."CLOSED_TIME" IS 'Flight Close Time in GMT';
   COMMENT ON COLUMN "FZ_FLT_LEG"."STATUS" IS 'status of the flight';
   COMMENT ON COLUMN "FZ_FLT_LEG"."DAY_CHANGE" IS 'Day changes in case the departure and the arrival dates are different.';
   COMMENT ON COLUMN "FZ_FLT_LEG"."EQUIPMENT_CODE" IS 'Aircraft type';
   COMMENT ON COLUMN "FZ_FLT_LEG"."VERSION_CODE" IS 'Eg : 73B, 73H';
   COMMENT ON COLUMN "FZ_FLT_LEG"."SEAT_TEMPLATE_CODE" IS 'Refers to the seat map template code';
   COMMENT ON COLUMN "FZ_FLT_LEG"."TAIL_NUMBER" IS 'Tail Number of the flight';
   COMMENT ON COLUMN "FZ_FLT_LEG"."DELAY_CODE" IS 'Flight Delay Code';
   COMMENT ON COLUMN "FZ_FLT_LEG"."LAST_MODIFIED_DATE" IS 'Last modified date in the source in GMT';
   COMMENT ON COLUMN "FZ_FLT_LEG"."LAST_MODIFIED_DATE_LTC" IS 'Last modified date in the source in GST';
   COMMENT ON COLUMN "FZ_FLT_LEG"."LAST_UPDATED_DATE" IS 'Last Updated time in the ODS';
   COMMENT ON TABLE "FZ_FLT_LEG"  IS 'Stores the flight leg details';
--------------------------------------------------------
--  DDL for Table FZ_FLT_RESTRICTED_SSR
--------------------------------------------------------

  CREATE TABLE "FZ_FLT_RESTRICTED_SSR" 
   (	"CARRIER_CODE" VARCHAR2(6 BYTE), 
	"FLIGHT_DATE" DATE, 
	"FLIGHT_NUMBER" NUMBER(5,0), 
	"FLIGHT_SUFFIX" VARCHAR2(1 BYTE), 
	"BD_AIRPORT_CODE" VARCHAR2(5 BYTE), 
	"OFF_AIRPORT_CODE" VARCHAR2(5 BYTE), 
	"SSR_CODE" VARCHAR2(15 BYTE), 
	"LAST_MODIFIED_DATE_LTC" TIMESTAMP (6), 
	"LAST_MODIFIED_DATE" TIMESTAMP (6), 
	"LAST_UPDATED_DATE" TIMESTAMP (6)
   ) ;

   COMMENT ON COLUMN "FZ_FLT_RESTRICTED_SSR"."CARRIER_CODE" IS 'Eg : FZ, EK';
   COMMENT ON COLUMN "FZ_FLT_RESTRICTED_SSR"."FLIGHT_NUMBER" IS 'Flight Number';
   COMMENT ON COLUMN "FZ_FLT_RESTRICTED_SSR"."FLIGHT_SUFFIX" IS 'In case of delays/ changes, the same flight will be flown with a different suffix like A. Flight Number will be then identified as 100A instead of 100.';
   COMMENT ON COLUMN "FZ_FLT_RESTRICTED_SSR"."BD_AIRPORT_CODE" IS 'Board airport code of the schedule leg.';
   COMMENT ON COLUMN "FZ_FLT_RESTRICTED_SSR"."OFF_AIRPORT_CODE" IS 'Off airport code of the schedule leg';
   COMMENT ON COLUMN "FZ_FLT_RESTRICTED_SSR"."SSR_CODE" IS 'Restricted SSR Codes';
   COMMENT ON COLUMN "FZ_FLT_RESTRICTED_SSR"."LAST_MODIFIED_DATE_LTC" IS 'Last modified date in the source in GST';
   COMMENT ON COLUMN "FZ_FLT_RESTRICTED_SSR"."LAST_MODIFIED_DATE" IS 'Last modified date in the source in GMT';
   COMMENT ON COLUMN "FZ_FLT_RESTRICTED_SSR"."LAST_UPDATED_DATE" IS 'Last Updated time in the ODS';
   COMMENT ON TABLE "FZ_FLT_RESTRICTED_SSR"  IS 'Restricted SSRs for the Flight';
--------------------------------------------------------
--  DDL for Table FZ_FLT_SEG
--------------------------------------------------------

  CREATE TABLE "FZ_FLT_SEG" 
   (	"CARRIER_CODE" VARCHAR2(6 BYTE), 
	"FLIGHT_DATE" DATE, 
	"FLIGHT_NUMBER" NUMBER(5,0), 
	"FLIGHT_SUFFIX" VARCHAR2(1 BYTE), 
	"BD_AIRPORT_CODE" VARCHAR2(5 BYTE), 
	"OFF_AIRPORT_CODE" VARCHAR2(5 BYTE), 
	"BD_POINT_ORDER" NUMBER(4,0), 
	"OFF_POINT_ORDER" NUMBER(4,0), 
	"DEP_METRO_GROUP_CODE" VARCHAR2(5 BYTE), 
	"ARR_METRO_GROUP_CODE" VARCHAR2(5 BYTE), 
	"SCHEDULE_ID" NUMBER(15,0), 
	"DEP_TIME_UTC" DATE, 
	"DEP_TIME_LTC" DATE, 
	"ARR_TIME_UTC" DATE, 
	"ARR_TIME_LTC" DATE, 
	"JOURNEY_TIME" NUMBER(15,0), 
	"TRAFFIC_RESTRICTION_CODE" VARCHAR2(1 BYTE), 
	"TOTAL_ADULT_COUNT" NUMBER(4,0), 
	"TOTAL_CHILD_COUNT" NUMBER(4,0), 
	"TOTAL_INFANT_COUNT" NUMBER(4,0), 
	"LAST_MODIFIED_DATE" TIMESTAMP (6), 
	"LAST_MODIFIED_DATE_LTC" TIMESTAMP (6), 
	"LAST_UPDATED_DATE" TIMESTAMP (6), 
	"LOGICAL_FLIGHT_ID" NUMBER(15,0), 
	"PRESEAT_STATUS" VARCHAR2(10 BYTE), 
	"LID_OPEN_STATUS" VARCHAR2(10 BYTE)
   ) ;

   COMMENT ON COLUMN "FZ_FLT_SEG"."CARRIER_CODE" IS 'Eg : FZ, EK';
   COMMENT ON COLUMN "FZ_FLT_SEG"."FLIGHT_NUMBER" IS 'Flight Number';
   COMMENT ON COLUMN "FZ_FLT_SEG"."FLIGHT_SUFFIX" IS 'In case of delays/ changes, the same flight will be flown with a different suffix like A. Flight Number will be then identified as 100A instead of 100.';
   COMMENT ON COLUMN "FZ_FLT_SEG"."BD_AIRPORT_CODE" IS 'Board airport code of the schedule leg.';
   COMMENT ON COLUMN "FZ_FLT_SEG"."OFF_AIRPORT_CODE" IS 'Off airport code of the schedule leg';
   COMMENT ON COLUMN "FZ_FLT_SEG"."BD_POINT_ORDER" IS 'For the first airport in the route, this will be 1, for the second it will be 2 and so on';
   COMMENT ON COLUMN "FZ_FLT_SEG"."OFF_POINT_ORDER" IS 'Will be the airport order in the route. For the first segment, the order will be 2 as the airport order will be 2 in the route for the corresponding off airport code';
   COMMENT ON COLUMN "FZ_FLT_SEG"."DEP_METRO_GROUP_CODE" IS 'Departure Metro Group';
   COMMENT ON COLUMN "FZ_FLT_SEG"."ARR_METRO_GROUP_CODE" IS 'Arrival airport Metro Group';
   COMMENT ON COLUMN "FZ_FLT_SEG"."SCHEDULE_ID" IS 'Refers to fz_sch_schedule.schedule_id';
   COMMENT ON COLUMN "FZ_FLT_SEG"."DEP_TIME_UTC" IS 'Departure time of the flight from the airport in GMT';
   COMMENT ON COLUMN "FZ_FLT_SEG"."DEP_TIME_LTC" IS 'Departure time of the flight in local departing airport time zone';
   COMMENT ON COLUMN "FZ_FLT_SEG"."ARR_TIME_UTC" IS 'Arrival time in GMT';
   COMMENT ON COLUMN "FZ_FLT_SEG"."ARR_TIME_LTC" IS 'Arrival time of the flight in local arrival airport time zone';
   COMMENT ON COLUMN "FZ_FLT_SEG"."JOURNEY_TIME" IS 'Journey Time in Seconds';
   COMMENT ON COLUMN "FZ_FLT_SEG"."TRAFFIC_RESTRICTION_CODE" IS 'Traffic Restriction Codes. - A / B.
A - indicates whether to be shown in the availability
B - indicates whether the segment can be used for connection flights';
   COMMENT ON COLUMN "FZ_FLT_SEG"."TOTAL_ADULT_COUNT" IS 'Total adult passenger flown for the segme nt';
   COMMENT ON COLUMN "FZ_FLT_SEG"."TOTAL_CHILD_COUNT" IS 'Total child passengers flown in the segment';
   COMMENT ON COLUMN "FZ_FLT_SEG"."TOTAL_INFANT_COUNT" IS 'Total infant passengers flown in the segment';
   COMMENT ON COLUMN "FZ_FLT_SEG"."LAST_MODIFIED_DATE" IS 'Last modified date in the source in GMT';
   COMMENT ON COLUMN "FZ_FLT_SEG"."LAST_MODIFIED_DATE_LTC" IS 'Last modified date in the source in GST';
   COMMENT ON COLUMN "FZ_FLT_SEG"."LAST_UPDATED_DATE" IS 'Last Updated time in the ODS';
   COMMENT ON TABLE "FZ_FLT_SEG"  IS 'Flight segments';
--------------------------------------------------------
--  DDL for Table FZ_FLT_SEG_LEG
--------------------------------------------------------

  CREATE TABLE "FZ_FLT_SEG_LEG" 
   (	"FLT_SEG_LEG_ID" NUMBER(15,0), 
	"CARRIER_CODE" VARCHAR2(6 BYTE), 
	"FLIGHT_NUMBER" VARCHAR2(50 BYTE), 
	"BD_AIRPORT_CODE" VARCHAR2(15 BYTE), 
	"OFF_AIRPORT_CODE" VARCHAR2(15 BYTE), 
	"DEP_TIME_UTC" TIMESTAMP (6), 
	"DEP_TIME_LTC" TIMESTAMP (6), 
	"ARR_TIME_UTC" TIMESTAMP (6), 
	"ARR_TIME_LTC" TIMESTAMP (6), 
	"LOGICAL_FLIGHT_ID" NUMBER(15,0), 
	"EQUIPMENT_CODE" VARCHAR2(15 BYTE), 
	"VERSION_CODE" VARCHAR2(15 BYTE), 
	"SEAT_TEMPLATE_CODE" VARCHAR2(50 BYTE), 
	"TAIL_NUMBER" VARCHAR2(30 BYTE), 
	"STATUS" VARCHAR2(20 BYTE), 
	"LAST_MODIFIED_DATE" TIMESTAMP (6), 
	"LAST_MODIFIED_DATE_LTC" TIMESTAMP (6), 
	"LAST_UPDATED_DATE" TIMESTAMP (6), 
	"PRESEAT_STATUS" VARCHAR2(10 BYTE), 
	"DEPARTURE_DATE" DATE, 
	"PNL_STATUS" VARCHAR2(10 BYTE), 
	"OPEN_LID_STATUS" VARCHAR2(10 BYTE), 
	"OLD_STATUS" VARCHAR2(20 BYTE), 
	"OLD_DEP_TIME_LTC" TIMESTAMP (6), 
	"OLD_DEP_TIME_UTC" TIMESTAMP (6), 
	"OLD_ARR_TIME_UTC" TIMESTAMP (6), 
	"OLD_ARR_TIME_LTC" TIMESTAMP (6), 
	"PNL_SENT" VARCHAR2(20 BYTE), 
	"NONAME_SENT" VARCHAR2(20 BYTE)
   ) ;

   COMMENT ON COLUMN "FZ_FLT_SEG_LEG"."CARRIER_CODE" IS 'Eg : FZ, EK';
   COMMENT ON COLUMN "FZ_FLT_SEG_LEG"."FLIGHT_NUMBER" IS 'Flight Number';
   COMMENT ON COLUMN "FZ_FLT_SEG_LEG"."BD_AIRPORT_CODE" IS 'Board airport code of the schedule leg.';
   COMMENT ON COLUMN "FZ_FLT_SEG_LEG"."OFF_AIRPORT_CODE" IS 'Off airport code of the schedule leg';
   COMMENT ON COLUMN "FZ_FLT_SEG_LEG"."DEP_TIME_UTC" IS 'Departure time of the flight from the airport in GMT';
   COMMENT ON COLUMN "FZ_FLT_SEG_LEG"."DEP_TIME_LTC" IS 'Departure time of the flight in local departing airport time zone';
   COMMENT ON COLUMN "FZ_FLT_SEG_LEG"."ARR_TIME_UTC" IS 'Arrival time in GMT';
   COMMENT ON COLUMN "FZ_FLT_SEG_LEG"."ARR_TIME_LTC" IS 'Arrival time of the flight in local arrival airport time zone';
   COMMENT ON COLUMN "FZ_FLT_SEG_LEG"."LOGICAL_FLIGHT_ID" IS 'Logical flight id of the flight';
   COMMENT ON COLUMN "FZ_FLT_SEG_LEG"."LAST_MODIFIED_DATE" IS 'Last modified date in the source in GMT';
   COMMENT ON COLUMN "FZ_FLT_SEG_LEG"."LAST_MODIFIED_DATE_LTC" IS 'Last modified date in the source in GST';
   COMMENT ON COLUMN "FZ_FLT_SEG_LEG"."LAST_UPDATED_DATE" IS 'Last Updated time in the ODS';
   COMMENT ON TABLE "FZ_FLT_SEG_LEG"  IS 'Flight segments';
--------------------------------------------------------
--  DDL for Index FZ_FLT_CODESHARE_MAPPING_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FZ_FLT_CODESHARE_MAPPING_PK" ON "FZ_FLT_CODESHARE_MAPPING" ("MKT_CARRIER_CODE", "MKT_FLIGHT_DATE", "MKT_FLIGHT_NUMBER", "FLIGHT_SUFFIX") 
  ;
--------------------------------------------------------
--  DDL for Index FZ_FLT_CONNECTIONS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FZ_FLT_CONNECTIONS_PK" ON "FZ_FLT_CONNECTIONS" ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX", "CONN_GROUP_ID") 
  ;
--------------------------------------------------------
--  DDL for Index FZ_FLT_FLIGHT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FZ_FLT_FLIGHT_PK" ON "FZ_FLT_FLIGHT" ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX") 
  ;
--------------------------------------------------------
--  DDL for Index FZ_FLT_LEG_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FZ_FLT_LEG_PK" ON "FZ_FLT_LEG" ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX", "BD_AIRPORT_CODE", "OFF_AIRPORT_CODE") 
  ;
--------------------------------------------------------
--  DDL for Index FZ_FLT_RESTRICTED_SSR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FZ_FLT_RESTRICTED_SSR_PK" ON "FZ_FLT_RESTRICTED_SSR" ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX", "BD_AIRPORT_CODE", "OFF_AIRPORT_CODE", "SSR_CODE") 
  ;
--------------------------------------------------------
--  DDL for Index FZ_FLT_SEG_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FZ_FLT_SEG_PK" ON "FZ_FLT_SEG" ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX", "BD_AIRPORT_CODE", "OFF_AIRPORT_CODE") 
  ;
--------------------------------------------------------
--  DDL for Index FZ_FLT_SEG_LEG_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "FZ_FLT_SEG_LEG_PK" ON "FZ_FLT_SEG_LEG" ("FLT_SEG_LEG_ID") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_SEG_LEG_LOG_FLT_ID
--------------------------------------------------------

  CREATE INDEX "IDX_SEG_LEG_LOG_FLT_ID" ON "FZ_FLT_SEG_LEG" ("LOGICAL_FLIGHT_ID") 
  ;
--------------------------------------------------------
--  DDL for Index FZ_FLT_SEG_LEG_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "FZ_FLT_SEG_LEG_UK1" ON "FZ_FLT_SEG_LEG" ("FLIGHT_NUMBER", "BD_AIRPORT_CODE", "OFF_AIRPORT_CODE", "DEPARTURE_DATE", "LOGICAL_FLIGHT_ID") 
  ;
--------------------------------------------------------
--  Constraints for Table FZ_FLT_CODESHARE_MAPPING
--------------------------------------------------------

  ALTER TABLE "FZ_FLT_CODESHARE_MAPPING" MODIFY ("MKT_CARRIER_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_CODESHARE_MAPPING" MODIFY ("MKT_FLIGHT_DATE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_CODESHARE_MAPPING" MODIFY ("MKT_FLIGHT_NUMBER" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_CODESHARE_MAPPING" MODIFY ("FLIGHT_SUFFIX" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_CODESHARE_MAPPING" ADD CONSTRAINT "FZ_FLT_CODESHARE_MAPPING_PK" PRIMARY KEY ("MKT_CARRIER_CODE", "MKT_FLIGHT_DATE", "MKT_FLIGHT_NUMBER", "FLIGHT_SUFFIX") ENABLE;
--------------------------------------------------------
--  Constraints for Table FZ_FLT_CONNECTIONS
--------------------------------------------------------

  ALTER TABLE "FZ_FLT_CONNECTIONS" MODIFY ("CARRIER_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_CONNECTIONS" MODIFY ("FLIGHT_DATE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_CONNECTIONS" MODIFY ("FLIGHT_NUMBER" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_CONNECTIONS" MODIFY ("FLIGHT_SUFFIX" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_CONNECTIONS" MODIFY ("CONN_GROUP_ID" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_CONNECTIONS" MODIFY ("LAST_MODIFIED_DATE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_CONNECTIONS" MODIFY ("LAST_MODIFIED_DATE_LTC" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_CONNECTIONS" MODIFY ("LAST_UPDATED_DATE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_CONNECTIONS" ADD CONSTRAINT "FZ_FLT_CONNECTIONS_PK" PRIMARY KEY ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX", "CONN_GROUP_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table FZ_FLT_FLIGHT
--------------------------------------------------------

  ALTER TABLE "FZ_FLT_FLIGHT" MODIFY ("CARRIER_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_FLIGHT" MODIFY ("FLIGHT_DATE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_FLIGHT" MODIFY ("FLIGHT_NUMBER" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_FLIGHT" MODIFY ("FLIGHT_SUFFIX" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_FLIGHT" ADD CONSTRAINT "FZ_FLT_FLIGHT_PK" PRIMARY KEY ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX") ENABLE;
--------------------------------------------------------
--  Constraints for Table FZ_FLT_LEG
--------------------------------------------------------

  ALTER TABLE "FZ_FLT_LEG" MODIFY ("CARRIER_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_LEG" MODIFY ("FLIGHT_DATE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_LEG" MODIFY ("FLIGHT_NUMBER" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_LEG" MODIFY ("FLIGHT_SUFFIX" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_LEG" MODIFY ("BD_AIRPORT_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_LEG" MODIFY ("OFF_AIRPORT_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_LEG" ADD CONSTRAINT "FZ_FLT_LEG_PK" PRIMARY KEY ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX", "BD_AIRPORT_CODE", "OFF_AIRPORT_CODE") ENABLE;
--------------------------------------------------------
--  Constraints for Table FZ_FLT_RESTRICTED_SSR
--------------------------------------------------------

  ALTER TABLE "FZ_FLT_RESTRICTED_SSR" MODIFY ("CARRIER_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_RESTRICTED_SSR" MODIFY ("FLIGHT_DATE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_RESTRICTED_SSR" MODIFY ("FLIGHT_NUMBER" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_RESTRICTED_SSR" MODIFY ("FLIGHT_SUFFIX" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_RESTRICTED_SSR" MODIFY ("BD_AIRPORT_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_RESTRICTED_SSR" MODIFY ("OFF_AIRPORT_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_RESTRICTED_SSR" MODIFY ("SSR_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_RESTRICTED_SSR" ADD CONSTRAINT "FZ_FLT_RESTRICTED_SSR_PK" PRIMARY KEY ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX", "BD_AIRPORT_CODE", "OFF_AIRPORT_CODE", "SSR_CODE") ENABLE;
--------------------------------------------------------
--  Constraints for Table FZ_FLT_SEG
--------------------------------------------------------

  ALTER TABLE "FZ_FLT_SEG" MODIFY ("CARRIER_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_SEG" MODIFY ("FLIGHT_DATE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_SEG" MODIFY ("FLIGHT_NUMBER" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_SEG" MODIFY ("FLIGHT_SUFFIX" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_SEG" MODIFY ("BD_AIRPORT_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_SEG" MODIFY ("OFF_AIRPORT_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_SEG" ADD CONSTRAINT "FZ_FLT_SEG_PK" PRIMARY KEY ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX", "BD_AIRPORT_CODE", "OFF_AIRPORT_CODE") ENABLE;
--------------------------------------------------------
--  Constraints for Table FZ_FLT_SEG_LEG
--------------------------------------------------------

  ALTER TABLE "FZ_FLT_SEG_LEG" MODIFY ("FLT_SEG_LEG_ID" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_SEG_LEG" MODIFY ("CARRIER_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_SEG_LEG" MODIFY ("FLIGHT_NUMBER" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_SEG_LEG" MODIFY ("BD_AIRPORT_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_SEG_LEG" MODIFY ("OFF_AIRPORT_CODE" NOT NULL ENABLE);
  ALTER TABLE "FZ_FLT_SEG_LEG" ADD CONSTRAINT "FZ_FLT_SEG_LEG_PK" PRIMARY KEY ("FLT_SEG_LEG_ID") ENABLE;
  ALTER TABLE "FZ_FLT_SEG_LEG" ADD CONSTRAINT "FZ_FLT_SEG_LEG_UK1" UNIQUE ("FLIGHT_NUMBER", "BD_AIRPORT_CODE", "OFF_AIRPORT_CODE", "DEPARTURE_DATE", "LOGICAL_FLIGHT_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table FZ_FLT_CODESHARE_MAPPING
--------------------------------------------------------

  ALTER TABLE "FZ_FLT_CODESHARE_MAPPING" ADD CONSTRAINT "FZ_FLT_FLIGHT_CODESHARE_FK" FOREIGN KEY ("MKT_CARRIER_CODE", "MKT_FLIGHT_DATE", "MKT_FLIGHT_NUMBER", "FLIGHT_SUFFIX")
	  REFERENCES "FZ_FLT_FLIGHT" ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table FZ_FLT_CONNECTIONS
--------------------------------------------------------

  ALTER TABLE "FZ_FLT_CONNECTIONS" ADD CONSTRAINT "FZ_FLT_FLIGHT_CONNECTIONS_FK" FOREIGN KEY ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX")
	  REFERENCES "FZ_FLT_FLIGHT" ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table FZ_FLT_LEG
--------------------------------------------------------

  ALTER TABLE "FZ_FLT_LEG" ADD CONSTRAINT "FZ_FLT_FLIGHT_LEG_FK" FOREIGN KEY ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX")
	  REFERENCES "FZ_FLT_FLIGHT" ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table FZ_FLT_RESTRICTED_SSR
--------------------------------------------------------

  ALTER TABLE "FZ_FLT_RESTRICTED_SSR" ADD CONSTRAINT "FZ_FLT_LEG_RESTRICTED_SSR_FK" FOREIGN KEY ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX", "BD_AIRPORT_CODE", "OFF_AIRPORT_CODE")
	  REFERENCES "FZ_FLT_LEG" ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX", "BD_AIRPORT_CODE", "OFF_AIRPORT_CODE") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table FZ_FLT_SEG
--------------------------------------------------------

  ALTER TABLE "FZ_FLT_SEG" ADD CONSTRAINT "FZ_FLT_FLIGHT_SEG_FK" FOREIGN KEY ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX")
	  REFERENCES "FZ_FLT_FLIGHT" ("CARRIER_CODE", "FLIGHT_DATE", "FLIGHT_NUMBER", "FLIGHT_SUFFIX") ENABLE;
