package com.kdn.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4550264505350184724L;
	private int errCode = ErrorCode.GENERIC_ERROR;
	private HttpStatus httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	
	public ServiceException() {
		
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ServiceException(int errCode) {
		super();
		this.errCode = errCode;
	}

	public ServiceException(int errCode, HttpStatus httpStatusCode, String message) {
		super(message);
		this.errCode = errCode;
		this.httpStatusCode = httpStatusCode;
	}

	public ServiceException(int errCode, String message, Throwable throwable) {
		super(message, throwable);
		this.errCode = errCode;
	}

}
