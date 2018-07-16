package com.itecheasy.core;
/** 
 * @author wanghw
 * @date 2015-5-27 
 * @description TODO
 * @version
 */
public class TransactionException extends Exception{

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 1L;

private String errorCode;
	
	private String errorData;

	public String getErrorData() {
		return errorData;
	}

	public void setErrorData(String errorData) {
		this.errorData = errorData;
	}

	public TransactionException(String errorCode) {
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
