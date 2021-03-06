package com.itecheasy.webservice.sw;

import java.math.BigDecimal;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * 
 */
@WebService(name = "OsmsOrderWebService", targetNamespace = "http://osms.communication.itecheasy.com/")
public interface OsmsOrderWebService {

	/**
	 * 
	 * @param orderProduct
	 * @param email
	 * @param packageId
	 * @param operator
	 * @throws BussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "addProduct", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.AddProduct")
	@ResponseWrapper(localName = "addProductResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.AddProductResponse")
	public void addProduct(@WebParam(name = "email", targetNamespace = "") String email,
			@WebParam(name = "orderProduct", targetNamespace = "") List<OrderProduct> orderProduct,
			@WebParam(name = "packageId", targetNamespace = "") int packageId,
			@WebParam(name = "operator", targetNamespace = "") Operator operator) throws BussinessException_Exception;

	/**
	 * 
	 * @param maxId
	 * @return returns java.util.List<com.itecheasy.webservice.sw.Notification>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "readNotification", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.ReadNotification")
	@ResponseWrapper(localName = "readNotificationResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.ReadNotificationResponse")
	public List<Notification> readNotification(@WebParam(name = "maxId", targetNamespace = "") Integer maxId);

	/**
	 * 
	 * @param orderCode
	 * @param businessIds
	 * @param operator
	 * @throws BussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "cancelProduct", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.CancelProduct")
	@ResponseWrapper(localName = "cancelProductResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.CancelProductResponse")
	public void cancelProduct(@WebParam(name = "orderCode", targetNamespace = "") String orderCode,
			@WebParam(name = "businessIds", targetNamespace = "") List<Integer> businessIds,
			@WebParam(name = "operator", targetNamespace = "") Operator operator) throws BussinessException_Exception;

	/**
	 * 
	 * @param orderCode
	 * @param shippingPrice
	 * @param orderAmout
	 */
	@WebMethod
	@RequestWrapper(localName = "updateOrderAmont", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.UpdateOrderAmont")
	@ResponseWrapper(localName = "updateOrderAmontResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.UpdateOrderAmontResponse")
	public void updateOrderAmont(@WebParam(name = "orderCode", targetNamespace = "") String orderCode,
			@WebParam(name = "orderAmout", targetNamespace = "") BigDecimal orderAmout,
			@WebParam(name = "shippingPrice", targetNamespace = "") BigDecimal shippingPrice);

	/**
	 * 
	 * @param orderCode
	 * @return returns com.itecheasy.webservice.sw.Order
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getOrderByCode", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.GetOrderByCode")
	@ResponseWrapper(localName = "getOrderByCodeResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.GetOrderByCodeResponse")
	public Order getOrderByCode(@WebParam(name = "orderCode", targetNamespace = "") String orderCode);

	/**
	 * 
	 * @param order
	 * @param email
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "placeOrder", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.PlaceOrder")
	@ResponseWrapper(localName = "placeOrderResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.PlaceOrderResponse")
	public String placeOrder(@WebParam(name = "order", targetNamespace = "") Order order,
			@WebParam(name = "email", targetNamespace = "") String email);

	/**
	 * 
	 * @param orderCode
	 * @return returns java.util.List<com.itecheasy.webservice.sw.Package>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getPackagesByOrder", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.GetPackagesByOrder")
	@ResponseWrapper(localName = "getPackagesByOrderResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.GetPackagesByOrderResponse")
	public List<Package> getPackagesByOrder(@WebParam(name = "orderCode", targetNamespace = "") String orderCode);

	/**
	 * 
	 * @param orderCode
	 * @param qty
	 * @param businessId
	 * @param operator
	 * @param purchasePrice
	 * @throws BussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "updateDemandQty", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.UpdateDemandQty")
	@ResponseWrapper(localName = "updateDemandQtyResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.UpdateDemandQtyResponse")
	public void updateDemandQty(@WebParam(name = "orderCode", targetNamespace = "") String orderCode,
			@WebParam(name = "businessId", targetNamespace = "") int businessId,
			@WebParam(name = "qty", targetNamespace = "") int qty,
			@WebParam(name = "purchasePrice", targetNamespace = "") BigDecimal purchasePrice,
			@WebParam(name = "operator", targetNamespace = "") Operator operator) throws BussinessException_Exception;

	/**
	 * 
	 * @param cpfCode
	 * @param customerServiceRemark
	 * @param orderCode
	 * @param reimburseAmountRate
	 * @param deliveryExplanation
	 * @throws BussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "updateRemark", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.UpdateRemark")
	@ResponseWrapper(localName = "updateRemarkResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.UpdateRemarkResponse")
	public void updateRemark(@WebParam(name = "orderCode", targetNamespace = "") String orderCode,
			@WebParam(name = "deliveryExplanation", targetNamespace = "") String deliveryExplanation,
			@WebParam(name = "cpfCode", targetNamespace = "") String cpfCode,
			@WebParam(name = "customerServiceRemark", targetNamespace = "") String customerServiceRemark,
			@WebParam(name = "reimburseAmountRate", targetNamespace = "") BigDecimal reimburseAmountRate)
			throws BussinessException_Exception;

	/**
	 * 
	 * @param order
	 * @param operator
	 * @throws BussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "updateDeliveryInfo", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.UpdateDeliveryInfo")
	@ResponseWrapper(localName = "updateDeliveryInfoResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.UpdateDeliveryInfoResponse")
	public void updateDeliveryInfo(@WebParam(name = "order", targetNamespace = "") Order order,
			@WebParam(name = "operator", targetNamespace = "") Operator operator) throws BussinessException_Exception;

	/**
	 * 
	 * @param flag
	 * @param orderCode
	 */
	@WebMethod
	@RequestWrapper(localName = "setFBAFlag", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.SetFBAFlag")
	@ResponseWrapper(localName = "setFBAFlagResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.SetFBAFlagResponse")
	public void setFBAFlag(@WebParam(name = "orderCode", targetNamespace = "") String orderCode,
			@WebParam(name = "flag", targetNamespace = "") Boolean flag);

	/**
	 * 
	 * @param sendMark
	 * @param orderCode
	 */
	@WebMethod
	@RequestWrapper(localName = "updateSendMark", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.UpdateSendMark")
	@ResponseWrapper(localName = "updateSendMarkResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.UpdateSendMarkResponse")
	public void updateSendMark(@WebParam(name = "orderCode", targetNamespace = "") String orderCode,
			@WebParam(name = "sendMark", targetNamespace = "") boolean sendMark);

	/**
	 * 
	 * @param orderCode
	 * @param operator
	 * @throws BussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "cancelOrder", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.CancelOrder")
	@ResponseWrapper(localName = "cancelOrderResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.CancelOrderResponse")
	public void cancelOrder(@WebParam(name = "orderCode", targetNamespace = "") String orderCode,
			@WebParam(name = "operator", targetNamespace = "") Operator operator) throws BussinessException_Exception;

	/**
	 * 
	 * @param orderCode
	 * @return returns com.itecheasy.webservice.sw.OrderVO
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getOrderVO", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.GetOrderVO")
	@ResponseWrapper(localName = "getOrderVOResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.GetOrderVOResponse")
	public OrderVO getOrderVO(@WebParam(name = "orderCode", targetNamespace = "") String orderCode);

	/**
	 * 
	 * @param orderCode
	 * @param remarks
	 * @param businessIds
	 * @param operator
	 * @throws BussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "updateOrderProductRemark", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.UpdateOrderProductRemark")
	@ResponseWrapper(localName = "updateOrderProductRemarkResponse", targetNamespace = "http://osms.communication.itecheasy.com/", className = "com.itecheasy.webservice.sw.UpdateOrderProductRemarkResponse")
	public void updateOrderProductRemark(@WebParam(name = "orderCode", targetNamespace = "") String orderCode,
			@WebParam(name = "businessIds", targetNamespace = "") List<Integer> businessIds,
			@WebParam(name = "remarks", targetNamespace = "") List<String> remarks,
			@WebParam(name = "operator", targetNamespace = "") Operator operator) throws BussinessException_Exception;

}
