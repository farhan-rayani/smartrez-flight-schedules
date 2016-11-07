package com.flydubai.dataservices.flight.common.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
	
	public static DatatypeFactory datatypeFactory;


	private static Logger logger = LoggerFactory.getLogger(DateUtil.class);
	
	  static {
		    try {
		      datatypeFactory = DatatypeFactory.newInstance();
		    } catch (DatatypeConfigurationException e) {
		      // Try again?
		      try {
		        datatypeFactory = DatatypeFactory.newInstance();
		      } catch (DatatypeConfigurationException ex) {
		        logger.error("Error creating instance of DataTypeFactory(xml)",ex);
		    }
		  }
	  }

	/**
	 * This method is to convert java.sql.Timestamp to
	 * javax.xml.datatype.XMLGregorianCalendar
	 * 
	 * @param timestamp
	 *            as Timestamp
	 * @return XMLGregorianCalendar
	 */
	public static XMLGregorianCalendar getXMLGregorianCalendarVal(
			Timestamp timestamp) {

		if (timestamp == null) {
			return null;
		}
		XMLGregorianCalendar calendar = null;
		try {
			Date date = timestamp;
			GregorianCalendar gc = (GregorianCalendar) GregorianCalendar
					.getInstance();
			gc.setTime(date);
			calendar = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(gc);
			calendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
		} catch (DatatypeConfigurationException dce) {
			logger.error("Error converting to XML date timestamp = "
					+ timestamp + dce.getMessage());
		}
		return calendar;
	}

	/**
	 * This method is to convert Date object to string as given format.
	 * if date is null returns null
	 * 
	 * @param date
	 *            Date
	 * @param format
	 *            String
	 * @return String
	 */
	public static String getDateString(Date date, String format) {
		String dateString = null;
		try {
			if(date != null){
				SimpleDateFormat dateFormat = new SimpleDateFormat(format);
				dateString = dateFormat.format(date);
			}
		} catch (Exception e) {
			logger.error("Exception in dateToString date :: " + date, e);
		}
		return dateString;
	}
	
	/**
	 * Formats this date-time to the specified format.
	 * if date is null returns null
	 * 
	 * @param dateTime
	 * @param dateFormat
	 * @return
	 */
	public static String getDateString(LocalDateTime dateTime, String dateFormat) {
		String dateTimeString = null;
		if (dateTime != null) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern(dateFormat);
			dateTimeString = dateTime.format(format);
		}
		return dateTimeString;
	}
	/**
	 * Formats this date-time to the specified format.
	 * if date is null returns null
	 * 
	 * @param dateTime
	 * @param dateFormat
	 * @return
	 */
	public static String getDateString(XMLGregorianCalendar dateTime, String dateFormat) {
		String dateTimeString = null;
		if (dateTime != null) {
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			dateTimeString = format.format(dateTime.toGregorianCalendar().getTime());
		}
		return dateTimeString;
	}
	
	/**
	 * Formats this date to the specified format.
	 * if date is null returns null
	 * 
	 * @param dateTime
	 * @param dateFormat
	 * @return
	 */
	public static String getDateString(LocalDate date, String dateFormat) {
		String dateString = null;
		if (date != null) {
			if(dateFormat == null || dateFormat.isEmpty()){
				dateString = getDateString(date);
			} else {
				DateTimeFormatter format = DateTimeFormatter.ofPattern(dateFormat);
				dateString = date.format(format);
			}
			
		}
		return dateString;
	}
	
	public static XMLGregorianCalendar getXmlGregorianCalendar(LocalDate localDate){
		return datatypeFactory.newXMLGregorianCalendarDate(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(), DatatypeConstants.FIELD_UNDEFINED);
	}
	
	/**
	 * Formats this date to the specified format.
	 * if date is null returns null
	 * 
	 * @param dateTime
	 * @param dateFormat
	 * @return
	 */
	public static String getDateString(LocalDate date) {
		String dateString = null;
		if (date != null) {
			dateString = date.toString();
		}
		return dateString;
	}
	/**
	 * 
	 * @param calendar
	 * @return
	 */
	public static LocalDate getLocalDate(XMLGregorianCalendar calendar) {
		LocalDate localDate = null;
		if (calendar != null) {
			localDate = LocalDate.of(calendar.getYear(),
					calendar.getMonth(), calendar.getDay());
		}
		return localDate;
	}
	/**
	 * 
	 * @param xmlCalendar
	 * @return
	 */
	public static Calendar getCalendar(XMLGregorianCalendar xmlCalendar){
	    TimeZone timeZone = xmlCalendar.getTimeZone(xmlCalendar.getTimezone());        
	    Calendar calendar = Calendar.getInstance(timeZone);
	    calendar.set(Calendar.YEAR,xmlCalendar.getYear());
	    calendar.set(Calendar.MONTH,xmlCalendar.getMonth()-1);
	    calendar.set(Calendar.DATE,xmlCalendar.getDay());
	    calendar.set(Calendar.HOUR_OF_DAY,xmlCalendar.getHour());
	    calendar.set(Calendar.MINUTE,xmlCalendar.getMinute());
	    calendar.set(Calendar.SECOND,xmlCalendar.getSecond());  
	    return calendar;
	}
}
