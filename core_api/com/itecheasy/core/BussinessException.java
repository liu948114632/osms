package com.itecheasy.core;


public class BussinessException extends RuntimeException {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5023467394987352081L;

	private String errorCode;
	
	private String errorData;

	public String getErrorData() {
		return errorData;
	}

	public void setErrorData(String errorData) {
		this.errorData = errorData;
	}

	public BussinessException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	
}
