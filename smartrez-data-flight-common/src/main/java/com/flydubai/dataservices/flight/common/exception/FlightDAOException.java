package com.flydubai.dataservices.flight.common.exception;

public class FlightDAOException extends Exception {

	private static final long serialVersionUID = -3294055142372791295L;

	private String errorCode;

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public FlightDAOException() {
	}

	public FlightDAOException(String message) {
		super(message);
	}

	public FlightDAOException(String message, String errorCode) {
		super(message);
		setErrorCode(errorCode);
	}

	public FlightDAOException(Throwable cause) {
		super(cause);
	}

	public FlightDAOException(Throwable cause, String errorCode) {
		super(cause);
		setErrorCode(errorCode);
	}

	public FlightDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public FlightDAOException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		setErrorCode(errorCode);

	}

	public FlightDAOException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
