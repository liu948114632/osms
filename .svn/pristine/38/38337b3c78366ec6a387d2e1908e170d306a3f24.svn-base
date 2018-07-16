package com.itecheasy.webservice.client;

import java.net.URL;
import java.text.MessageFormat;
import java.util.Date;
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
import com.itecheasy.core.CommunicationException;
import com.itecheasy.core.user.User;
import com.itecheasy.core.util.StaticUtils;
import com.itecheasy.webservice.cms.order.BussinessException_Exception;
import com.itecheasy.webservice.cms.order.CommunicationLog;
import com.itecheasy.webservice.cms.order.Order;
import com.itecheasy.webservice.cms.order.OrderCancleResendApplay;
import com.itecheasy.webservice.cms.order.OrderCancleResendApplayItem;
import com.itecheasy.webservice.cms.order.OrderItem;
import com.itecheasy.webservice.cms.order.OrderItemDetail;
import com.itecheasy.webservice.cms.order.OrderModifyOperatorLog;
import com.itecheasy.webservice.cms.order.OrderModifyRecord;
import com.itecheasy.webservice.cms.order.OrderModifyRecordItem;
import com.itecheasy.webservice.cms.order.OrderTracking;
import com.itecheasy.webservice.cms.order.OrderWeighingRecordInfo;
import com.itecheasy.webservice.cms.order.OsmsCommunicationOrderService;
import com.itecheasy.webservice.cms.order.OsmsCommunicationOrderServiceImplService;

/**
 * @author wanghw
 * @date 2015-5-21
 * @description cms订单
 * @version
 */
public class CMSOrderClient {
	private final static Logger logger = Logger.getLogger(CMSOrderClient.class.getName());
	private static OsmsCommunicationOrderService service = null;

	private static void init() {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = com.itecheasy.webservice.cms.order.OsmsCommunicationOrderServiceImplService.class
					.getResource(".");
			url = new URL(baseUrl, DeployProperties.getInstance().getProperty("cms.order.webservice.url"));

			service = new OsmsCommunicationOrderServiceImplService(url, new QName(
					"http://osms.communication.itecheasy.com/", "OsmsCommunicationOrderServiceImplService"))
					.getOsmsCommunicationOrderServiceImplPort();
			Client client = ClientProxy.getClient(service);
			Endpoint cxfEndpoint = client.getEndpoint();
			Map<String, Object> outProps = new HashMap<String, Object>();
			outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
			outProps.put(WSHandlerConstants.USER, DeployProperties.getInstance().getProperty("cms.webservice.username"));
			outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
			outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, WsClinetAuthHandler.class.getName());
			cxfEndpoint.getOutInterceptors().add(new WSS4JOutInterceptor(outProps));
			HTTPConduit http = (HTTPConduit) client.getConduit();
			HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
			httpClientPolicy.setConnectionTimeout(1000 * 60 * 5);
			httpClientPolicy.setAllowChunking(false);
			httpClientPolicy.setReceiveTimeout(1000 * 60 * 5);
			http.setClient(httpClientPolicy);
		} catch (Exception e) {
			service = null;
			logger.warning("Failed to create URL for the wsdl Location: '"
					+ DeployProperties.getInstance().getProperty("cms.order.webservice.url")
					+ "', retrying as a local file");
			StaticUtils.addEmail("OSMS系统:CMS订单服务调用异常",
					e.getMessage() + "\r\n" + "Failed to create URL for the wsdl Location: '"
							+ DeployProperties.getInstance().getProperty("cms.order.webservice.url")
							+ "', retrying as a local file");
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * cms称重记录
	 * 
	 * @param orderCode
	 * @return
	 */
	public static OrderWeighingRecordInfo getLastOrderWeighingRecordByOrderCode(String orderCode) {
		if (service == null) {
			init();
		}
		try {
			return service.getLastOrderWeighingRecordByOrderCode(orderCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

	/**
	 * 获取cms订单操作日志 操作状态：1 INSERT,2 UPDATE,3 DELETE
	 * 
	 * @param startDate
	 */
	public static List<CommunicationLog> getOrderOperatorLog(String startDate) {
		if (service == null) {
			init();
		}
		return service.getOrderOperatorLog(startDate);
	}

	public static Order getOrderById(int cmsOrderId) {
		if (service == null) {
			init();
		}
		return service.getOrderById(cmsOrderId);
	}

	public static Order getOrderByCode(String orderCode) {
		if (service == null) {
			init();
		}
		return service.getOrderByCode(orderCode);
	}

	public static List<OrderItemDetail> getOrderItemByOrderId(int cmsOrderId) {
		if (service == null) {
			init();
		}
		return service.getOrderItemByOrderId(cmsOrderId);
	}

	/**
	 * 订单项操作日志
	 * 
	 * @param startDate
	 * @return
	 */
	public static List<CommunicationLog> getOrderItemOperatorLog(String startDate) {
		if (service == null) {
			init();
		}
		return service.getOrderItemOperatorLog(startDate);
	}

	public static OrderItem getOrderItemById(int orderItemId) {
		if (service == null) {
			init();
		}
		return service.getOrderItemById(orderItemId);
	}

	public static List<CommunicationLog> getOrderApplayOperatorLog(String startTime) {
		if (service == null) {
			init();
		}
		return service.getOrderApplayOperatorLog(startTime);
	}

	public static OrderCancleResendApplay getApplayById(Integer applayId) {
		if (service == null) {
			init();
		}
		return service.getApplayById(applayId);
	}

	public static List<OrderCancleResendApplayItem> getApplayItemsByApplayId(Integer applayId) {
		if (service == null) {
			init();
		}
		return service.getApplayItemsByApplayId(applayId);
	}

	public static List<OrderModifyOperatorLog> getOrderModifyOperatorLog(long maxId) {
		if (service == null) {
			init();
		}
		return service.getOrderModifyRecordOperatorLogsById((int) maxId);
	}

	public static OrderModifyRecord getOrderModifyRecordById(int id) {
		if (service == null) {
			init();
		}
		return service.getOrderModifyRecordById(id);
	}

	public static List<OrderModifyRecordItem> getOrderModifyRecords(int cmsOrderModifyRecordId) {
		if (service == null) {
			init();
		}
		return service.getOrderModifyRecords(cmsOrderModifyRecordId);
	}

	/**
	 * 传ID表示更新，不传表示新增
	 * 
	 * @param orderTrace
	 * @param user
	 * @throws BussinessException
	 */
	public static void setOrderTracking(OrderTracking orderTracking, User user) {
		try {
			if (service == null) {
				init();
			}
			long start = (new Date()).getTime();
			service.setOrderTracking(orderTracking, user.getCode(), user.getName(), user.getEmail());
			long end = (new Date()).getTime();
			logger.info(MessageFormat.format("执行CMS_Order接口方法setOrderTracking使用时长:{0}", end - start));
		} catch (BussinessException_Exception e) {
			logger.info("注意，cms系统抛了异常:" + e.getMessage());
			throw new BussinessException("注意，cms系统抛了异常:" + e.getMessage());
		} catch (Exception ex) {
			logger.info("注意，cms系统抛了异常:" + ex.getMessage());
			throw new BussinessException("注意，cms系统抛了异常:" + ex.getMessage());
		}
	}

	public static String uploadAttachment(byte[] attachment, String ext) {
		if (service == null) {
			init();
		}

		return service.addAttachmentFile(attachment, ext);
	}

	public static void setOrderTrackingRemark(String code, int operator, String remark) {
		if (service == null) {
			init();
		}

		service.setOrderTrackingRemark(code, operator, remark);
	}
	
	public static void completeOrderTrackingToCMS(List<String> code){
		if (service == null) {
			init();
		}
		
		try {
			service.completeOrderTracking(code);
		} catch (BussinessException_Exception e) {
			logger.info("注意，cms系统抛了异常:" + e.getMessage());
			throw new BussinessException("注意，cms系统抛了异常:" + e.getMessage());
		}
	}
	
	public static List<CommunicationLog>  getOrderTrackingOperatorLogById(int maxId){
		if (service == null) {
			init();
		}
		
		return service.getOrderTrackingOperatorLogById(maxId);
	}

	// 修改咨询人 setConsultationUser
	public static void setConsultationUser(List<String> orderTrackingCodes, User cmsUser) throws BussinessException {
		try {
			if (service == null) {
				init();
			}
			long start = (new Date()).getTime();
			service.setConsultationUser(orderTrackingCodes, cmsUser.getCode(), cmsUser.getName(), cmsUser.getEmail());
			long end = (new Date()).getTime();
			logger.info(MessageFormat.format("执行CMS_Order接口方法setConsultationUser使用时长:{0}", end - start));
		} catch (BussinessException_Exception e) {
			logger.info("注意，cms系统抛了异常:" + e.getMessage());
			throw new BussinessException("注意，cms系统抛了异常:" + e.getMessage());
		}
	}

	// 修改处理人 setLastReplyUser
	/*
	 * public static void setLastReplyUser(List<String> orderTrackingCodes, User
	 * user)throws CommunicationException{ try { if(service==null){ init(); }
	 * long start = (new Date()).getTime();
	 * 
	 * long end = (new Date()).getTime(); } catch (BussinessException_Exception
	 * e) { logger.error("注意，cms系统抛了异常:"+e.getMessage()); throw new
	 * CommunicationException("注意，cms系统抛了异常:"+e.getMessage()); }
	 * 
	 * }
	 */

	// 删除订单跟踪 delOrderTracking
	public static void delOrderTracking(List<String> orderTrackingCodes) throws BussinessException {
		try {
			if (service == null) {
				init();
			}
			long start = (new Date()).getTime();
			service.delOrderTracking(orderTrackingCodes);
			long end = (new Date()).getTime();
			logger.info(MessageFormat.format("执行CMS_Order接口方法delOrderTracking使用时长:{0}", end - start));
		} catch (BussinessException_Exception e) {
			logger.info("注意，cms系统抛了异常:" + e.getMessage());
			throw new BussinessException("注意，cms系统抛了异常:" + e.getMessage());
		}

	}

	/**
	 * 回复订单跟踪，C3发起的订单跟踪
	 * 
	 * @param camsOrderTrac
	 * @param ordertraceItem
	 * @param operatorId
	 *            这个是CMS里对应的用户ID
	 * @throws CommunicationException
	 */
	public static void replyOrderTrackingToCMS(OrderTracking orderTracking, int userId) throws CommunicationException {
		try {
			if (service == null) {
				init();
			}
			long start = (new Date()).getTime();
			service.replyOrderTracking(orderTracking, userId);
			long end = (new Date()).getTime();
			logger.info(MessageFormat.format("执行CMS_Order接口方法replyOrderTracking使用时长:{0}", end - start));
		} catch (BussinessException_Exception e) {
			logger.info("注意，cms系统抛了异常:" + e.getMessage());
			throw new CommunicationException("注意，cms系统抛了异常:" + e.getMessage());
		}
	}

	public static List<CommunicationLog> getOrderTrackingOperatorLog(String startTime) throws CommunicationException {
		if (service == null) {
			init();
		}
		long start = (new Date()).getTime();
		List<CommunicationLog> result = service.getOrderTrackingOperatorLog(startTime);
		long end = (new Date()).getTime();
		logger.info(MessageFormat.format("执行CMS_Order接口方法getOrderTrackingOperatorLog使用时长:{0}", end - start));
		return result;
	}

	public static byte[] getAttachmentByCode(String attachmentCode) {
		if (service == null) {
			init();
		}
		long start = (new Date()).getTime();
		byte[] result = service.getAttachmentByCode(attachmentCode);
		long end = (new Date()).getTime();
		logger.info(MessageFormat.format("执行CMS_Order接口方法getAttachmentByCode使用时长:{0}", end - start));
		return result;
	}

	public static OrderTracking getOrderTrackingById(int cmsOrderTraceId) {
		if (service == null) {
			init();
		}
		long start = (new Date()).getTime();
		OrderTracking result = service.getOrderTrackingById(cmsOrderTraceId);
		long end = (new Date()).getTime();
		logger.info(MessageFormat.format("执行CMS_Order接口方法getOrderTrackingById使用时长:{0}", end - start));

		return result;
	}

	public static void main(String[] args) {
		// Order o= getOrderByCode("WA160914560120");
		// System.out.println(new BigDecimal(o.getWebsiteWeight()).divide(new
		// BigDecimal(1000), 3, 4));

		List<OrderModifyRecordItem> item = getOrderModifyRecords(3754);
		System.out.println();
	}
}
