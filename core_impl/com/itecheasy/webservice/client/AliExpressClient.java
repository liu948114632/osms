package com.itecheasy.webservice.client;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.openapi.sdk.aeopenapi.ApiFacade;
import com.alibaba.openapi.sdk.aeopenapi.param.AeopLogisticsServiceResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiListLogisticsServiceResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiSellerModifiedShipmentParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiSellerModifiedShipmentResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiSellerShipmentParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiSellerShipmentResult;
import com.alibaba.openapi.sdk.aeopenapi.param.FundLoanListVO;
import com.alibaba.openapi.sdk.aeopenapi.param.OrderBaseInfo;
import com.alibaba.openapi.sdk.aeopenapi.param.OrderItemVO;
import com.alibaba.openapi.sdk.aeopenapi.param.OrderListVO;
import com.alibaba.openapi.sdk.aeopenapi.param.OrderTradeInfo;
import com.alibaba.openapi.sdk.aeopenapi.param.SimpleOrderItemVO;
import com.alibaba.openapi.sdk.aeopenapi.param.SimpleOrderListVO;
import com.alibaba.openapi.sdk.aeopenapi.param.TpOpenAddressDTO;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.core.order.SmtOrderService;
import com.itecheasy.core.util.StaticUtils;
import com.itecheasy.webservice.aliexpress.AliexpressConfigInfo;
import com.itecheasy.webservice.aliexpress.ApiCallService;
import com.itecheasy.webservice.aliexpress.AuthService;
import com.itecheasy.webservice.aliexpress.TpOpenLogisticInfoDTO;
import com.itecheasy.webservice.aliexpress.TpOpenOrderDetailDTO;

 
public class AliExpressClient {
	private static final Logger logger = Logger.getLogger(AliExpressClient.class);
	private static final String SERVICENAME_OTHER = "Other";
	private static ApiFacade apiFacade = null;
	public final static String[] dateFormats = new String[] {"yyyyMMddHHmmssSSSZ","yyyy-MM-dd HH:mm:ss"};   

	public static void init(AliexpressConfigInfo api) {
		apiFacade= new ApiFacade();
	 
		apiFacade.setAppKey(api.getAppKey());
		apiFacade.setSigningKey(api.getAppSecret());
		apiFacade.setServerHost(DeployProperties.getInstance().getAliExpressHost());//server.host
		apiFacade.setHttpPort(Integer.parseInt(DeployProperties.getInstance().getAliExpressPort()));//server.port
	}

	/**
	 * 获取临时凭证方法
	 * @param api
	 * @return
	 */
	public static String getAccessToken(AliexpressConfigInfo api) {
		init(api);
		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id", api.getAppKey());
		params.put("redirect_uri",DeployProperties.getInstance().getAliExpressRedirectUri());
		params.put("client_secret", api.getAppSecret());
		params.put("refresh_token", api.getRefreshToken());
		
		String refreshTokenResult = AuthService.refreshToken(DeployProperties.getInstance().getAliExpressHost(), params);

		logger.info("用长时令牌换取授权令牌的返回结果：" + refreshTokenResult);
		JSONObject jsonObject1 = JSONObject.fromObject(refreshTokenResult);
		logger.info("accessToken:"
				+ jsonObject1.getString("access_token"));// accessToken

		String accessToken = jsonObject1.getString("access_token");
		return accessToken;
	}
	
	public static AliexpressConfigInfo againAuth(AliexpressConfigInfo api) {
		init(api);
		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id", api.getAppKey());
		params.put("redirect_uri",DeployProperties.getInstance().getAliExpressRedirectUri());
		params.put("client_secret", api.getAppSecret());
		params.put("refresh_token", api.getRefreshToken());
		params.put("access_token", getAccessToken(api));
		
		try {
			String refreshTokenResult = AuthService.postponeToken(DeployProperties.getInstance().getAliExpressHost(), params);

			JSONObject jsObject = JSONObject.fromObject(refreshTokenResult);
			String refreshToken = jsObject.getString("refresh_token");
			Date currentDate = DateUtils.getFullMillisecondDate();
			
			api.setRefreshToken(refreshToken);
			api.setRefreshTokenTimeOut(org.apache.commons.lang.time.DateUtils.addMonths(currentDate, 6));
			
			logger.info("刷新refreshToken返回结果：" + refreshTokenResult);
			logger.info("refresh_token:"
					+ jsObject.getString("access_token"));
			return api;
		} catch (Exception e) {
			logger.info("刷新refreshToken失败");
			StaticUtils.addEmail("重新授权失败", api.getDevId()+" "+e.getMessage());
		}
		return null;
	}
	
	/**
	 * 通过地址调用API获取JSON格式的结果
	 * @param apiName API名称
	 * @param api API信息
	 * @param param 需要传的参数
	 * @return
	 */
	public static JSONObject getApiResultByJson(String apiName, AliexpressConfigInfo api, Map<String, String> param){
	 
		String host=DeployProperties.getInstance().getAliExpressHost();
		String port=DeployProperties.getInstance().getAliExpressPort();
		
		String urlPath = "param2/1/aliexpress.open/"+ apiName +"/" + api.getAppKey(); // "param2/1/system/currentTime/1000000"
		String urlHead = "http://" + host + ":" + port + "/openapi/";
		
		param.put("access_token", getAccessToken(api));
		param.put("_aop_datePattern", "yyyy-MM-dd HH:mm:ss");
//		param.put("_aop_timeZone", "+8");
	
		String result = ApiCallService.callApiTest(urlHead, urlPath, api.getAppSecret(), param);
		JSONObject json = JSONObject.fromObject(result);
		
		return json;
	}
	
	public static Object updateRefreshToken2(String appKey, String secretKey,
			String refreshToken,String accessToken ){
		String url = MessageFormat.format(DeployProperties.getInstance().getProperty("updateRefreshToken2"), 
				appKey
				,secretKey, refreshToken, accessToken);
		System.out.println("getAliData url="+url);
		String result = null;
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Content-type", "application/octet-stream");
		try {

			HttpResponse response = client.execute(httpPost);
			result = EntityUtils.toString(response.getEntity());
			if (null == response || response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				logger.error("刷新refreshToken失败!");
				logger.error(result);
			}
			return result;
		} catch (IOException e) {
			logger.error(e.getMessage());
			logger.error("刷新refreshToken失败!");
		} finally {
			if (null != client) {
				client.getConnectionManager().shutdown();
			}
		}
		return null;
	}
	
	/**
	 * 列出平台所支持的物流服务列表
	 * 此接口返回的物流服务于线上发货物流服务不同。此接口返回的物流服务用语卖家设置运费模板和声明发货，不能用于线上发货。请注意！
	 */
	public static AeopLogisticsServiceResult[] getListLogisticsService(AliexpressConfigInfo api){
	
		String accessToken = getAccessToken(api);
		ApiListLogisticsServiceResult result = apiFacade.apiListLogisticsService(accessToken);
		
		if(result.getSuccess())
		{
			AeopLogisticsServiceResult[] list = result.getResult();
			 return list;
		} 
		
		return null;
	}
	
	/**
	 * 订单上传跟踪号
	 * @param api 平台API信息
	 * @param orderId 平台订单号
	 * @param serviceName 物流承运商
	 * @param trackingNO 运单号
	 * @param remark 备注
	 * @throws Exception 错误信息
	 */
	public static void delivery(AliexpressConfigInfo api, Long orderId, String serviceName, String trackingNO, String remark, String url) throws Exception {
		
		TpOpenOrderDetailDTO orderDetail = getOrderById(api,orderId);
		
		//订单货运信息不为空则修改发货通知，单货运信息为空，则填写发货通知
		if (orderDetail != null && orderDetail.getLogisticInfoList() != null && orderDetail.getLogisticInfoList().length > 0){
			TpOpenLogisticInfoDTO logisticsWarehouseOrder = orderDetail.getLogisticInfoList()[0] ;
			if(!logisticsWarehouseOrder.getLogisticsNo().equals(trackingNO))
				apiSellerModifiedShipment(api, orderId, logisticsWarehouseOrder.getLogisticsTypeCode(), logisticsWarehouseOrder.getLogisticsNo(), serviceName, trackingNO, remark, url);
		}else 
			apiSellerShipment(api, orderId, serviceName, trackingNO, remark, url);
	}

	/**
	 * 填写发货通知
	 */
	public static void apiSellerShipment(AliexpressConfigInfo api, Long orderId, String serviceName, String trackingNO, String remark, String url) throws Exception {
		String accessToken = getAccessToken(api);
		ApiSellerShipmentParam request = new ApiSellerShipmentParam();
		request.setServiceName(serviceName);// 用户选择的实际发货物流服务（物流服务key：该接口根据api.listLogisticsService列出平台所支持的物流服务
										// 进行获取目前所支持的物流。)
		request.setLogisticsNo(trackingNO);// 物流追踪号
		request.setSendType("all");// 状态包括：全部发货(all)、部分发货(part)
		request.setOutRef(orderId.toString());// 用户需要发货的订单id
		request.setDescription(remark);// 备注(只能输入英文，且长度限制在512个字符。）
		
		//当serviceName=Other的情况时，需要填写对应的追踪网址
		if(serviceName.equals(SERVICENAME_OTHER))
			request.setTrackingWebsite(url);
		
		ApiSellerShipmentResult result = apiFacade.apiSellerShipment(request, accessToken);
		if (result.getSuccess()) {
			logger.info("操作成功");
		} else {
			logger.error("调用接口发生错误，上传跟踪号失败！");
			throw new Exception("调用接口发生错误，上传跟踪号失败！");
		}

	}
	
	/**
	 * 修改发货通知(一个订单只能修改2次，只能修改发货通知后5日内的订单，请注意！)
	 */
	public static void  apiSellerModifiedShipment(AliexpressConfigInfo api, Long orderId, String oldServiceName, String oldwTrackingNO, String newServiceName, String newTrackingNO, String remark, String url)throws Exception{
		String accessToken = getAccessToken(api);
		ApiSellerModifiedShipmentParam request = new ApiSellerModifiedShipmentParam();
		request.setOldLogisticsNo(oldwTrackingNO);//用户需要修改的老的物流追踪号
		request.setOldServiceName(oldServiceName);//用户需要修改的的老的发货物流服务（物流服务key：该接口根据api.listLogisticsService列出平台所支持的物流服务 进行获取目前所支持的物流。）
		
		request.setNewLogisticsNo(newTrackingNO);//用户需要修改的新的物流追踪号
		request.setNewServiceName(newServiceName);//用户需要修改的的新的发货物流服务（物流服务key：该接口根据api.listLogisticsService列出平台所支持的物流服务 进行获取目前所支持的物流。）
		
		request.setSendType("all");//状态包括：全部发货(all)、部分发货(part)
		request.setOutRef(orderId.toString());//用户需要发货的订单id （如：60769040695804）
		request.setDescription(remark);//备注(只能输入英文，且长度限制在512个字符。）
		
		//当serviceName=Other的情况时，需要填写对应的追踪网址
		if(newServiceName.equals(SERVICENAME_OTHER))
			request.setTrackingWebsite(url);
		
		ApiSellerModifiedShipmentResult result = apiFacade.apiSellerModifiedShipment(request, accessToken);
		
		if(result.getSuccess())
		{
			logger.info("操作成功");
		}else
		{
			logger.error("调用接口发生错误，上传跟踪号失败！");
			throw new Exception("调用接口发生错误，上传跟踪号失败！");
		}
	}
	
	/**
	 * 批量获取 订单状态为 WAIT_SELLER_SEND_GOODS 的订单详细信息 
	 * @param api
	 * @return
	 */
	public static List<TpOpenOrderDetailDTO> getTpOrderList(AliexpressConfigInfo api){
		Integer page = 1;
		Integer pageSize = 50;
		List<TpOpenOrderDetailDTO> tpOpenOrderDetailDTOList = new ArrayList<TpOpenOrderDetailDTO>();
		SimpleOrderListVO orderList = getOrderListSimpleQuery(api,page.toString(),pageSize.toString());
		if(orderList != null){
			if(orderList.getOrderList() != null && orderList.getOrderList().length > 0){
				for(SimpleOrderItemVO vo:orderList.getOrderList()){
					tpOpenOrderDetailDTOList.add(getOrderById(api,vo.getOrderId()));
				}
			}
			
			Integer totalItem = orderList.getTotalItem();
			if(totalItem > 50){
				Integer totalPage = totalItem/50 + 1;
				for(int i=2;i<=totalPage;i++){
					SimpleOrderListVO simpleOrderListVO = getOrderListSimpleQuery(api,String.valueOf(i),pageSize.toString());
					if(simpleOrderListVO != null && simpleOrderListVO.getOrderList() != null && simpleOrderListVO.getOrderList().length > 0){
						for(SimpleOrderItemVO vo:simpleOrderListVO.getOrderList()){
							tpOpenOrderDetailDTOList.add(getOrderById(api,vo.getOrderId()));
						}
					}
				}
			}
		}
		
		return tpOpenOrderDetailDTOList;
	
	}
	
	/**
	 * 简单查询订单
	 * @param api
	 * @return
	 */
	public static List<SimpleOrderItemVO> findOrderListSimpleQuery(AliexpressConfigInfo api){
		Integer page = 1;
		Integer pageSize = 50;
		List<SimpleOrderItemVO> tpOpenOrderDetailDTOList = new ArrayList<SimpleOrderItemVO>();
		SimpleOrderListVO orderList = getOrderListSimpleQuery(api,page.toString(),pageSize.toString());
		if(orderList != null){
			if(orderList.getOrderList() != null && orderList.getOrderList().length > 0){
				tpOpenOrderDetailDTOList.addAll(Arrays.asList(orderList.getOrderList()));
			}
			
			Integer totalItem = orderList.getTotalItem();
			if(totalItem > 50){
				Integer totalPage = totalItem/50 + 1;
				for(int i=2;i<=totalPage;i++){
					SimpleOrderListVO simpleOrderListVO = getOrderListSimpleQuery(api,String.valueOf(i),pageSize.toString());
					if(simpleOrderListVO != null && simpleOrderListVO.getOrderList() != null && simpleOrderListVO.getOrderList().length > 0){
						tpOpenOrderDetailDTOList.addAll(Arrays.asList(simpleOrderListVO.getOrderList() ));
					}
				}
			}
		}
		
		return tpOpenOrderDetailDTOList;
	
	}

	/**
	 * 批量获取 订单状态为 WAIT_SELLER_SEND_GOODS 的订单基础信息信息 
	 * @param api
	 * @return
	 */
	public static List<OrderItemVO> getOrderList(AliexpressConfigInfo api){
		Integer page = 1;
		Integer pageSize = 50;
		
		List<OrderItemVO> orderItemVOList = new ArrayList<OrderItemVO>();
		
		OrderListVO orderList = getOrderListQuery(api,page.toString(),pageSize.toString());
		if(orderList != null){
			if(orderList.getOrderList() != null && orderList.getOrderList().length > 0){
				for(OrderItemVO vo:orderList.getOrderList()){
					orderItemVOList.add(vo);
				}
			}
			
			Integer totalItem = orderList.getTotalItem();
			if(totalItem > 50){
				Integer totalPage = totalItem/50 + 1;
				for(int i=2;i<=totalPage;i++){
					OrderListVO orderListVO = getOrderListQuery(api,String.valueOf(i),pageSize.toString());
					if(orderListVO != null && orderListVO.getOrderList() != null && orderListVO.getOrderList().length > 0){
						for(OrderItemVO vo:orderListVO.getOrderList()){
							orderItemVOList.add(vo);
						}
					}
				}
			}
		}
		
		return orderItemVOList;
	
	}
	
	/**
	 * 订单列表简化查询（试用）
	 * @param api
	 * @param accessToken
	 * @param page
	 * @param pageSize
	 * @return
	 */
	private static SimpleOrderListVO getOrderListSimpleQuery(AliexpressConfigInfo api,String page, String pageSize){
		String apiName = "api.findOrderListSimpleQuery"; 
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("page", page);
		param.put("pageSize", pageSize);
		param.put("orderStatus", SmtOrderService.SMT_ORDER_STATUS_WAIT_SELLER_SEND_GOODS);
		
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));   
		JSONObject json = getApiResultByJson(apiName,api,param);
		SimpleOrderListVO vo = (SimpleOrderListVO) JSONObject.toBean(json, SimpleOrderListVO.class);

		return vo;
	}
	
	/**
	 * 交易订单列表查询。订单状态会多一个全新的值RISK_CONTROL 该值的含义是订单处于风控24小时中，从买家在线支付完成后开始，持续24小时。
	 * @param api
	 * @param accessToken
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public static OrderListVO getOrderListQuery(AliexpressConfigInfo api,String page, String pageSize){
		String apiName = "api.findOrderListQuery"; 
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("page", page);
		param.put("pageSize", pageSize);
		param.put("orderStatus", SmtOrderService.SMT_ORDER_STATUS_WAIT_SELLER_SEND_GOODS);
		
		JSONObject json = getApiResultByJson(apiName,api,param);
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats)); 
		OrderListVO vo = (OrderListVO) JSONObject.toBean(json, OrderListVO.class);

		return vo;
	}
	
	/**
	 * 交易订单详情查询。订单状态会多一个全新的值RISK_CONTROL 该值的含义是订单处于风控24小时中，从买家在线支付完成后开始，持续24小时。
	 * @param api
	 * @param orderId
	 * @param accessToken
	 * @return
	 */
	public static TpOpenOrderDetailDTO getOrderById(AliexpressConfigInfo api,Long orderId){
		String apiName = "api.findOrderById"; 
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("orderId", orderId.toString());
		
		JSONObject json = getApiResultByJson(apiName,api,param);
		System.out.println(json);
		
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));   
		TpOpenOrderDetailDTO tpOpenOrderDetailDTO = (TpOpenOrderDetailDTO) JSONObject.toBean(json, TpOpenOrderDetailDTO.class);
		return tpOpenOrderDetailDTO;
	}
	
	/**
	 * 订api
	 * @param orderId
	 * @return
	 */
	public static OrderTradeInfo getOrderTradeInfo(AliexpressConfigInfo api, Long orderId){
		String accessToken = getAccessToken(api);
		String apiName = "api.findOrderTradeInfo"; 
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("access_token", accessToken);
		param.put("orderId", orderId.toString());
		
		JSONObject json = getApiResultByJson(apiName,api,param);
		OrderTradeInfo orderTradeInfo = (OrderTradeInfo) JSONObject.toBean(json, OrderTradeInfo.class);
		 
		return orderTradeInfo;
	}
	
	/**
	 * 订单收货信息查询（试用）
	 * @param api
	 * @param orderId
	 * @return
	 */
	public static TpOpenAddressDTO getOrderReceiptInfo(AliexpressConfigInfo api, Long orderId){
		String accessToken = getAccessToken(api);
		String apiName = "api.findOrderReceiptInfo"; 
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("access_token", accessToken);
		param.put("orderId", orderId.toString());
		
		JSONObject json = getApiResultByJson(apiName,api,param);
		TpOpenAddressDTO tpOpenAddressDTO = (TpOpenAddressDTO) JSONObject.toBean(json, TpOpenAddressDTO.class);
		
		return tpOpenAddressDTO;
	}
	
	/**
	 * 订单基础信息查询（试用）
	 * @param api
	 * @param orderId
	 * @return
	 */
	public static OrderBaseInfo getOrderBaseInfo(AliexpressConfigInfo api, Long orderId){
		String accessToken = getAccessToken(api);
		String apiName = "api.findOrderBaseInfo"; 
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("access_token", accessToken);
		param.put("orderId", orderId.toString());
		
		JSONObject json = getApiResultByJson(apiName,api,param);
		OrderBaseInfo orderBaseInfo = (OrderBaseInfo) JSONObject.toBean(json, OrderBaseInfo.class);
		 
		return orderBaseInfo;
	}
	
	/**
	 * 查询订单放款信息(请注意：目前只查询进入放款中的订单信息状态，未进入放款中订单暂未做内容兼容。）
	 *  目前的放款信息查询接口，主要为订单的资金分配和处理列表，非严格意义上的放款数据查询，故目前查询会包含放款和退款状态信息查询。
	 * @param api
	 * @param orderId
	 * @return
	 */
	public static FundLoanListVO getLoanListQuery(AliexpressConfigInfo api, Long orderId){
		String accessToken = getAccessToken(api);
		String apiName = "api.findLoanListQuery"; 
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("access_token", accessToken);
		param.put("orderId", orderId.toString());
		param.put("page", "1");
		param.put("pageSize", "50");
		
		JSONObject json = getApiResultByJson(apiName,api,param);
		FundLoanListVO fundLoanListVO = (FundLoanListVO)JSONObject.toBean(json, FundLoanListVO.class);
		
		return fundLoanListVO;
	}
	
	public static void main(String[] args) {
		AliexpressConfigInfo api=new AliexpressConfigInfo();
		api.setAppKey("21422630");
		api.setAppSecret("kjuuafMirt02");
		api.setRefreshToken("961e5e2d-b187-4f95-8427-f81b91213215");
		//84109314759682 3
		TpOpenOrderDetailDTO dto=getOrderById(api, 84343459893654L);
//		findOrderListSimpleQuery(api);
//		getOrderList(api);
		System.out.println();
	}
	 
}
