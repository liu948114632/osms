package com.itecheasy.communication.bbc;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itecheasy.core.product.OsmsStock;

/** 
 * @author whw
 * @date 2018-4-12 
 * @description TODO
 * @version 
 */
@WebService
public interface BBCOrderWebService {
	public String placeOrder(@WebParam(name="order")BBCOrderDetail order);
	
	public List<OsmsStock> getStock(@WebParam(name="productCodes")List<String> productCodes);
}
