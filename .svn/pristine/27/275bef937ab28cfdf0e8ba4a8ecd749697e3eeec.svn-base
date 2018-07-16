package com.itecheasy.webservice.client;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;

import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.util.StaticUtils;
import com.itecheasy.webservice.sw.BussinessException_Exception;
import com.itecheasy.webservice.sw.Notification;
import com.itecheasy.webservice.sw.Operator;
import com.itecheasy.webservice.sw.Order;
import com.itecheasy.webservice.sw.OrderProduct;
import com.itecheasy.webservice.sw.OsmsOrderWebService;
import com.itecheasy.webservice.sw.OsmsOrderWebServiceImplService;
import com.itecheasy.webservice.sw.Package;

/** 
 * @author whw
 * @date 2017-8-2 
 * @description TODO
 * @version 
 */
public class SwOrderClient {
	private static final String SW_EX = "SW系统异常：";
	private static OsmsOrderWebService osmsService;
	private final static Logger logger = Logger.getLogger(CMSClient.class.getName());
	private final static String module="/webService/OsmsOrderWebService?wsdl";
	
	
	private static void init(){
		URL baseUrl = OsmsOrderWebServiceImplService.class.getResource(".");
		OsmsOrderWebServiceImplService service;
		try {
			service = new OsmsOrderWebServiceImplService(new URL(baseUrl, DeployProperties.getInstance()
					.getSWURL()+module), new QName("http://osms.communication.itecheasy.com/",
							"OsmsOrderWebServiceImplService"));
			osmsService = service.getOsmsOrderWebServiceImplPort();
			Client client = ClientProxy.getClient(osmsService);
			Endpoint cxfEndpoint = client.getEndpoint();
			Map<String, Object> outProps = new HashMap<String, Object>();
			outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
			outProps.put(WSHandlerConstants.USER, DeployProperties.getInstance().getProperty("sw.webservice.username"));
			outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
			outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, SWClinetAuthHandler.class.getName());
			cxfEndpoint.getOutInterceptors().add(new WSS4JOutInterceptor(outProps));
			HTTPConduit http = (HTTPConduit) client.getConduit();
			HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
			httpClientPolicy.setConnectionTimeout(1000 * 60 * 5);
			httpClientPolicy.setAllowChunking(false);
			httpClientPolicy.setReceiveTimeout(1000 * 60 * 5);
			http.setClient(httpClientPolicy);
		} catch (Exception e) {
			osmsService=null;
			logger.warning("Failed to create URL for the wsdl Location: '"+DeployProperties.getInstance().getSWURL()+module+"', retrying as a local file");
			logger.warning(e.getMessage());
			StaticUtils.addEmail("OSMS系统:sw服务调用异常", e.getMessage()+"\r\n"+
					"Failed to create URL for the wsdl Location: '"+DeployProperties.getInstance().getSWURL()+module+"', retrying as a local file");
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static void addOrder(Order order,String email){
		if(osmsService==null)
			init();
		osmsService.placeOrder(order, email);
	}
	
	public static void cancelOrder(String orderCode,Operator operator) throws BussinessException_Exception{
		if(osmsService==null)
			init();
		
		osmsService.cancelOrder(orderCode, operator);
	}
	
	public static void cancelOrderItem(String orderCode,List<Integer> orderPrepareProductId) throws BussinessException_Exception{
		if(osmsService==null)
			init();
		osmsService.cancelProduct(orderCode, orderPrepareProductId, null);
	}
	
	public static void addOrderProduct(String orderCode,List<OrderProduct> orderProducts) throws BussinessException_Exception{
		if(osmsService==null)
			init();
		
		osmsService.addProduct(orderCode, orderProducts, -1, null);
	}
	
	
	public static void updateDemandQty(String orderCode, int orderPrepareProductId,BigDecimal purchasePrice, int orderedQty) throws BussinessException_Exception{
		if(osmsService==null)
			init();
		
		osmsService.updateDemandQty(orderCode, orderPrepareProductId, orderedQty,purchasePrice, null);
	}
	
	public static List<Notification> readMessage(int maxId){
		if(osmsService==null)
			init();
		
		return osmsService.readNotification(maxId);
	}
	
	
	public static void updateDeliveryInfo(Order order) throws BussinessException_Exception{
		if(osmsService==null)
			init();
		
		osmsService.updateDeliveryInfo(order,null);
	}
	
	public static void updateSendMark(String orderCode,boolean sendMark){
		if(osmsService==null)
			init();
		
		osmsService.updateSendMark(orderCode, sendMark);
	}
	
	public static List<Package> getPackagesByOrder(String orderCode){
		if(osmsService==null)
			init();
		
		return osmsService.getPackagesByOrder(orderCode);
	}
	
	public static  void updateRemark(String orderCode,String deliveryExplanation,String cpfCode,String customerServiceRemark
			,BigDecimal reimburseAmountRate){
		if(osmsService==null)
			init();
		
		try {
			osmsService.updateRemark(orderCode, deliveryExplanation, cpfCode, customerServiceRemark, reimburseAmountRate);
		} catch (BussinessException_Exception e) {
			throw new BussinessException(SW_EX+e.getMessage());
		}
	}
	
	public static Order getSwOrderByCode(String orderCode){
		if(osmsService==null)
			init();
		
		return osmsService.getOrderByCode(orderCode);
	}
	public static void setFBAFlag(String orderCode,Boolean flag){
		if(osmsService==null)
			init();
		osmsService.setFBAFlag(orderCode,flag);
	}
	
	
	
	public static void updateOrderAmont(String orderCode, BigDecimal orderAmout, BigDecimal shippingPrice){
		if(osmsService==null)
			init();
		
		osmsService.updateOrderAmont(orderCode, orderAmout, shippingPrice);
	}
	
	public static void updateOrderProductRemark(String orderCode,List<Integer> orderItemIds,List<String> remarks){
		if(osmsService==null)
			init();
		
		try {
			osmsService.updateOrderProductRemark(orderCode, orderItemIds, remarks, null);
		} catch (BussinessException_Exception e) {
			throw new BussinessException(SW_EX+e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		try {
			cancelOrder("WA171014853814", null);
		} catch (BussinessException_Exception e) {
			e.printStackTrace();
		}
	}
	
}
