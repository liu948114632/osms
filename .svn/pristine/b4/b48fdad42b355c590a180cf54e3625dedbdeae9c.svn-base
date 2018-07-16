package com.itecheasy.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.order.AmazonOrderService;
import com.itecheasy.core.order.FBAStoreOrderService;
import com.itecheasy.core.order.FirstWayFreightSetting;
import com.itecheasy.core.order.OrderMessageService;
import com.itecheasy.core.order.OrderReportService;
import com.itecheasy.core.order.OrderService;
import com.itecheasy.core.order.OrderService.OrderProblemType;
import com.itecheasy.core.order.PackageProblem;
import com.itecheasy.core.order.PackageProblemService;
import com.itecheasy.core.order.PackageProblemStatus;
import com.itecheasy.core.order.PackageProblemType;
import com.itecheasy.core.order.PackageProblemTypeTag;
import com.itecheasy.core.order.dao.PackageProblemDao;
import com.itecheasy.core.product.BaseProductCostPriceService;
import com.itecheasy.core.system.SalesTarget;
import com.itecheasy.core.system.SettingReimbursePercent;
import com.itecheasy.core.system.ShopService;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.task.AmazonUploadFileTaskService;
import com.itecheasy.core.task.ListOrderTaskService;
import com.itecheasy.core.task.MessageTaskService;
import com.itecheasy.core.task.ReportTaskService;
import com.itecheasy.core.user.User;
import com.itecheasy.core.user.dao.UserDAO;
import com.itecheasy.webservice.amazon.OrderAmazon;

/**
 * @author wanghw
 * @date 2016-1-7
 * @description TODO
 * @version
 */
public class Test extends SprintTest {

	private BaseProductCostPriceService baseProductCostPriceService;
	private ListOrderTaskService listOrderTaskService;
	private OrderReportService orderReportService;
	private ShopService shopService;
	private MessageTaskService messageTaskService;
	private PackageProblemService packageProblemService;
	private FBAStoreOrderService fbaStoreOrderService;
	private AmazonOrderService amazonOrderService;
	private UserDAO userDAO;
	private OrderService orderService;
	private OrderMessageService orderMessageService;
	
	public void setOrderMessageService(OrderMessageService orderMessageService) {
		this.orderMessageService = orderMessageService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setAmazonOrderService(AmazonOrderService amazonOrderService) {
		this.amazonOrderService = amazonOrderService;
	}

	public void setFbaStoreOrderService(FBAStoreOrderService fbaStoreOrderService) {
		this.fbaStoreOrderService = fbaStoreOrderService;
	}

	public void setPackageProblemService(PackageProblemService packageProblemService) {
		this.packageProblemService = packageProblemService;
	}

	public void setMessageTaskService(MessageTaskService messageTaskService) {
		this.messageTaskService = messageTaskService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public void setOrderReportService(OrderReportService orderReportService) {
		this.orderReportService = orderReportService;
	}

	public void setListOrderTaskService(ListOrderTaskService listOrderTaskService) {
		this.listOrderTaskService = listOrderTaskService;
	}

	public void setBaseProductCostPriceService(BaseProductCostPriceService baseProductCostPriceService) {
		this.baseProductCostPriceService = baseProductCostPriceService;
	}

	public void getAllBaseProductCostPriceConfigs() {
		System.out.println(JSONArray.fromObject(baseProductCostPriceService.getBaseProductCostPriceConfigs())
				.toString());
	}

	public void listOrder() {
		List<String> amazonOrderIds = new ArrayList<String>();
		amazonOrderIds.add("106-8521411-1985856");// Amazon_ES
		// amazonOrderIds.add("202-1918350-2172342");//Amazon_UK
		// amazonOrderIds.add("404-2490034-9363511");//Amazon_IT
		// amazonOrderIds.add("403-2689022-7765906");//Amazon_FR

		try {
//			List<OrderAmazon> a = AmazonClient.getOrder(1, amazonOrderIds);
			
			amazonOrderService.addOrderByLog();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Date date=new Date();
		// com.itecheasy.webservice.amazon.ListOrdersResultAmazon
		// result=AmazonClient.listOrders(2, DateUtils.addDays(date, -1),
		// null);
		System.out.println();
	}

	public void orderReportCount() {
		System.out.println(OrderProblemType.sort(10));
	}
	
	public static void main(String[] args) {
		System.out.println(OrderProblemType.sort(6));
	}

	public void order() {
//		listOrderTaskService.listOrder();
		OrderAmazon order=new OrderAmazon();
		order.setFulfillmentChannel("AFN");
		order.setOrderStatus("Shipped");
		amazonOrderService.addOrderSimple(1,null,order);
	}

	public void send() {
	}

	public void salesTarget() {
		List<SalesTarget> resut = shopService.getSalesTargetByShopId("201602", new int[] { 1, 2, 3, 4, 5, 6, 7 });
		System.out.println(resut);
	}

	private PackageProblemDao packageProblemDao;

	public void setPackageProblemDao(PackageProblemDao packageProblemDao) {
		this.packageProblemDao = packageProblemDao;
	}

	public void dms() {
		try {
			messageTaskService.processingDMSMessage();
		} catch (BussinessException e) {
			e.printStackTrace();
		}
	}

	public void createPackageProblemTest(){
		String json=
				"{\"createTime\":\"2016-07-13 09:41:13\",\"operatorUser\":\"ite02132\",\"operatorName\":\"袁小凡\",\"orderCode\":\"WA160713834740\",\"status\":\"处理中\",\"orderGroup\":\"WA160713834740\",\"serviceCustomerName\":\"陈雪盈\",\"operator\":\"ite02132\",\"serviceCustomerCode\":\"ite02077\"}" ;
		
		JSONObject jo=JSONObject.fromObject(json);
		PackageProblem packageProblem=new PackageProblem();
		packageProblem.setStatus(PackageProblemStatus.getVal( jo.getString("status")));
		packageProblem.setCreateDate(DateUtils.convertDate(jo.getString("createTime"), 
				"yyyy-MM-dd HH:mm:ss"));
		packageProblem.setOrderCode(jo.getString("orderCode"));
		packageProblem.setCreateUser(jo.getString("operatorName"));
		packageProblem.setType(PackageProblemType.问题件.getVal());
		packageProblem.setDeliveryCustomerService(jo.getString("serviceCustomerName"));
		packageProblem.setStatus(PackageProblemStatus.处理中.getVal());
		packageProblem.setTypeTag(PackageProblemTypeTag.DMS_问题件_未妥投件.getVal());
		packageProblemService.createPackageProblem(packageProblem);
	}
	
	public void syncPackageProblem(){
		String json=
				"{\"content\":\"11\",\"processResult\":-1,\"createTime\":\"2016-07-09 15:31:43\",\"operatorUser\":\"ite01473\",\"operatorName\":\"刘欢\",\"orderCode\":\"WA160518406430\",\"downloadName\":\"\",\"orderGroup\":\"WA160518406430\",\"fileName\":\"\",\"operator\":\"ite01473\"}" ;
		
		JSONObject jo=JSONObject.fromObject(json);
		String orderCode=jo.getString("orderCode");
		
		String[] files=null;
		String[] downloads=null;
		Integer processResult=null;
		if(jo.containsKey("fileName")){
			files=jo.getString("fileName").split(",");
		}
		
		if(jo.containsKey("downloadName")){
			downloads=jo.getString("downloadName").split(",");
		}
		if(jo.containsKey("processResult")){//未妥投件处理意见
			processResult=jo.getInt("processResult");
		}
		packageProblemService.applyPackageProblem(
				orderCode, 
				jo.getString("operatorName"),
				jo.getString("content"), 
				DateUtils.convertDate(jo.getString("createTime"), 
						"yyyy-MM-dd HH:mm:ss"),downloads,files
						,processResult);
				
	}
	//{"content":"dms确认上架","processType":0,"createTime":"2016-07-01 14:11:55","operatorUser":"ite02132","operatorName":"袁小凡","orderCode":"WA160118801542","downloadName":"","orderGroup":"WA160118801542","fileName":"","operator":"ite02132"}
	
	
	public void back(){
		String json="{\"orderCode\":\"WA150713561480\",\"orderGroup\":\"WA150713561480\",\"operator\":\"ite01987\",\"operatorUser\":\"杨晓兰\",\"status\":\"\"}";
		JSONObject jo=JSONObject.fromObject(json);
		String orderCode=jo.getString("orderCode");
		PackageProblem back=new PackageProblem();
		back.setCreateUser(jo.getString("operatorUser"));
		back.setType(PackageProblemType.退件.getVal());
		back.setCreateDate(new Date());
		back.setOrderCode(orderCode);
		back.setStatus(PackageProblemStatus.处理中.getVal());
		back.setTypeTag(PackageProblemTypeTag.DMS_退件.getVal());
		packageProblemService.createPackageProblem(back);
		
	}
	
	public void syncPackageProblemAttachment(){
		String json=
				"{\"content\":\"sdsdf\",\"createTime\":\"2016-02-27 14:27:08\",\"operatorUser\":\"ite00332\",\"operatorName\":\"瞿灵敏\",\"orderCode\":\"WA160227728650\",\"downloadName\":\"201602271403cc567938415697f17b647c5a7d70.jpg,\",\"orderGroup\":\"WA160227728650\",\"fileName\":\"1.jpg,\",\"operator\":\"ite00332\"}" ;
		
		JSONObject jo=JSONObject.fromObject(json);
		String[] files=null;
		String[] downloads=null;
		if(jo.containsKey("fileName")){
			files=jo.getString("fileName").split(",");
		}
		
		if(jo.containsKey("downloadName")){
			downloads=jo.getString("downloadName").split(",");
		}
//		packageProblemService.applyPackageProblem(
//				jo.getString("orderCode"), 
//				jo.getString("operatorName"),
//				jo.getString("content"), 
//				DateUtils.convertDate(jo.getString("createTime"), 
//						"yyyy-MM-dd HH:mm:ss"),downloads,files);
//		
		
	}
	


	public  void syncFirstWayOrder() {
		messageTaskService.syncFirstWayOrder();
	}
	
	public void syncCMS(){
		try {
			messageTaskService.processingCMSMeseeage();
		} catch (BussinessException e) {
			e.printStackTrace();
		}
	}
	
	public void refuseResendOrder(){
		try {
			orderMessageService.refuseResendOrder("WA160229203534(1)", "无法追回", 6, "sss");
		} catch (BussinessException e) {
			e.printStackTrace();
		}
	}
	
	public void getValues() {
		String sql = "SELECT code FROM dbo.[user]";
		List<String> res = packageProblemDao.getSimpleColumnBySql(sql, null);
		System.out.println(res);
	}
	
	public void firstWay(){
		List<FirstWayFreightSetting>  setting=fbaStoreOrderService.getFirstWayFreightSettings("201604");
		System.out.println();
	}
	
	public void getShop(){
		shopService.getAvailableShops();
	}
	
	private ReportTaskService reportTaskService;
	
	public void setReportTaskService(ReportTaskService reportTaskService) {
		this.reportTaskService = reportTaskService;
	}

	public void fbaSales(){
		reportTaskService.autoCountFBASales();
	}
	
	public void setNotCMSprepare(){
		try {
			orderService.setOrderItem2NotCMSPrepare(42651, "王宏伟");
		} catch (BussinessException e) {
			e.printStackTrace();
		}
	}
	
	private AmazonUploadFileTaskService amazonUploadFileTaskService;
	
	public void setAmazonUploadFileTaskService(AmazonUploadFileTaskService amazonUploadFileTaskService) {
		this.amazonUploadFileTaskService = amazonUploadFileTaskService;
	}

	public void autoOrderDeliveryTask(){
		amazonUploadFileTaskService.autoOrderDeliveryTask();
	}
	
	private SystemService systemService;
	
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public void getShopInfo(){
		systemService.getCacheShopInfo(1);
	}
	
	public void testUser(){
		userDAO.findPageListByStoredProcedure(20, 1, "select * from user ", null, User.class);
	}
	
	public void cancelOrder(){
		List<Integer> orderId=Arrays.asList(new Integer[]{
				58450
		});
		
		for (Integer integer : orderId) {
			orderService.cancelOrder(integer, "王宏伟");
		}
		
	}
	
	public void getSettingReimbursePercent(){
		SettingReimbursePercent set=systemService.getCacheSettingReimbursePercentByShippingMethod(133);
		System.out.println(set.getOutOfThresholdToCalcForPercent());
	}
	
	public void getEbayShippingMethod(){
		systemService.getEbayShippingMethod(38);
	}
	
	public void getUser(){
		String hql=" from UserPO where id=?";
		
		List<Integer> ids=new ArrayList<Integer>();
		
		userDAO.findListByHql(hql, ids);
	}
}
