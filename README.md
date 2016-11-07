# smartrez-data-flight
The SmartRez Data modules

1) Service returns flight schedules from smartrez
How to call from your project
------------------------------
FlightDataServiceClient flightDataServiceClient = new FlightDataServiceClient();
FlightInformationRQParm reqParm = new FlightInformationRQParm();
reqParm.setDepartureStartDateUTC(LocalDateTime.now());
reqParm.setDepartureEndDateUTC(LocalDateTime.now().plusHours(1).plusMinutes(10));
FlightInformationRS response = flightDataServiceClient.getFlightInformationResponse(reqParm);

OR

FlightDataServiceClient flightDataServiceClient = new FlightDataServiceClient();
FlightInformationRQParm reqParm = new FlightInformationRQParm();
reqParm.setFlightNumber(440);
reqParm.setDepartureDate(LocalDate.now());
reqParm.setBoardAirportCode("DXB");
reqParm.setOffAirportCode("DOH");
FlightInformationRS response = flightDataServiceClient.getFlightInformationResponse(reqParm);

Note: Set the required filter parameter in FlightInformationRQParm.

Rest URLs
---------
http://localhost:8080/smartrez-data-flight-server/flightService/flights?departureStartDateUTC=2014-12-2116:09:21&departureEndDateUTC=2014-12-2321:49:21
http://localhost:8080/smartrez-data-flight-server/flightService/flights?departureDate=2015-05-10&boardAirportCode=DXB&offAirportCode=DOH&flightNumber=441
	
2) Circular flight schedules
	
http://localhost:8080/smartrez-data-flight-server/flightService/circularFlights?&oandDNumber=551&boardAirportCode=DXB&departureDate=2015-05-05

Input ::
oandDNumber         ::   If it is multi-leg flights, it should be 551/552 or else you can give with 551 alone.
boardAirportCode  ::  Board point 
departureDate        ::  Departure Date  

Output ::  
Output with error::
{"InfoGroup":{"Error":[{"Source":"Mandatory data missing- Departure Date"}]}}

Output with success::
{"InfoGroup":{},"FlightDetails":[{"Flight":{"Route":"DXB-CMB-HRI-DXB","Date":"2015-05-05"},"Leg":[
{"BoardAirportCode":"DXB","OffAirportCode":"CMB","LegOrder":0,"FlightNumber":551,"DepTimeLTC":"2015-05-05T22:55:00","ArrivalTimeLTC":"2015-05-06T05:05:00","DayChange":0},
{"BoardAirportCode":"CMB","OffAirportCode":"HRI","LegOrder":0,"FlightNumber":551,"DepTimeLTC":"2015-05-06T06:00:00","ArrivalTimeLTC":"2015-05-06T06:40:00","DayChange":0},

{"BoardAirportCode":"HRI","OffAirportCode":"DXB","LegOrder":0,"FlightNumber":551,"DepTimeLTC":"2015-05-06T07:35:00","ArrivalTimeLTC":"2015-05-06T10:55:00","DayChange":0}]}]}
