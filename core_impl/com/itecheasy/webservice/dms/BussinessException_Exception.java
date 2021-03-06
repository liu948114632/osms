package com.itecheasy.webservice.dms;

import javax.xml.ws.WebFault;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * 
 */
@WebFault(name = "BussinessException", targetNamespace = "http://out.webservice.dms.itecheasy.com/")
public class BussinessException_Exception extends Exception {

	/**
	 * Java type that goes as soapenv:Fault detail element.
	 * 
	 */
	private BussinessException faultInfo;

	/**
	 * 
	 * @param message
	 * @param faultInfo
	 */
	public BussinessException_Exception(String message, BussinessException faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}

	/**
	 * 
	 * @param message
	 * @param faultInfo
	 * @param cause
	 */
	public BussinessException_Exception(String message, BussinessException faultInfo, Throwable cause) {
		super(message, cause);
		this.faultInfo = faultInfo;
	}

	/**
	 * 
	 * @return returns fault bean:
	 *         com.itecheasy.webservice.dms.BussinessException
	 */
	public BussinessException getFaultInfo() {
		return faultInfo;
	}

}
