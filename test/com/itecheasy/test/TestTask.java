package com.itecheasy.test;

import java.util.ArrayList;
import java.util.List;

import com.itecheasy.communication.order.CommandOrderUtils;
import com.itecheasy.core.fba.IFbaShopProductComparableElement;
import com.itecheasy.core.order.AmazonOrderService;
import com.itecheasy.core.order.ModifyRecordService;
import com.itecheasy.core.order.Order;
import com.itecheasy.core.order.OrderService;
import com.itecheasy.core.order.OrderSwMessageService;
import com.itecheasy.core.order.OrderTrackingMessageService;
import com.itecheasy.core.order.dao.OrderDao;
import com.itecheasy.core.product.ShopProductCmsInfoService;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.task.AmazonUploadFileTaskService;
import com.itecheasy.core.task.ListOrderTaskService;
import com.itecheasy.core.task.MessageTaskService;
import com.itecheasy.core.task.ProductInfoSyncTask;
import com.itecheasy.core.task.ReportTaskService;
import com.itecheasy.core.user.ProfileService;
import com.itecheasy.core.user.dao.UserDAO;

/**
 * @author wanghw
 * @date 2016-9-26
 * @description TODO
 * @version 3.9.33
 */
public class TestTask extends SprintTest {
	private UserDAO userDAO;
	private ProductInfoSyncTask productInfoSyncTask;
	private MessageTaskService messageTaskService;
	private IFbaShopProductComparableElement fbaShopProductComparableElement;
	private ReportTaskService reportTaskService;
	private AmazonUploadFileTaskService amazonUploadFileTaskService;
	private ListOrderTaskService listOrderTaskService;
	private SystemService systemService;
	private ModifyRecordService modifyRecordService;
	private OrderSwMessageService orderSwMessageService;
	private ShopProductCmsInfoService shopProductCmsInfoService;
	private OrderTrackingMessageService orderTrackingMessageService;
	private ProfileService profileService;
	
	

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setOrderTrackingMessageService(OrderTrackingMessageService orderTrackingMessageService) {
		this.orderTrackingMessageService = orderTrackingMessageService;
	}

	public void setShopProductCmsInfoService(ShopProductCmsInfoService shopProductCmsInfoService) {
		this.shopProductCmsInfoService = shopProductCmsInfoService;
	}

	public void setOrderSwMessageService(OrderSwMessageService orderSwMessageService) {
		this.orderSwMessageService = orderSwMessageService;
	}

	public void setModifyRecordService(ModifyRecordService modifyRecordService) {
		this.modifyRecordService = modifyRecordService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public void setListOrderTaskService(ListOrderTaskService listOrderTaskService) {
		this.listOrderTaskService = listOrderTaskService;
	}

	public void setAmazonUploadFileTaskService(AmazonUploadFileTaskService amazonUploadFileTaskService) {
		this.amazonUploadFileTaskService = amazonUploadFileTaskService;
	}

	public void setReportTaskService(ReportTaskService reportTaskService) {
		this.reportTaskService = reportTaskService;
	}

	public void setFbaShopProductComparableElement(IFbaShopProductComparableElement fbaShopProductComparableElement) {
		this.fbaShopProductComparableElement = fbaShopProductComparableElement;
	}


	public void setMessageTaskService(MessageTaskService messageTaskService) {
		this.messageTaskService = messageTaskService;
	}

	public void setProductInfoSyncTask(ProductInfoSyncTask productInfoSyncTask) {
		this.productInfoSyncTask = productInfoSyncTask;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void getUser() {

		List<Integer> departmentIds = new ArrayList<Integer>();
		departmentIds.add(1);
		departmentIds.add(1);
		departmentIds.add(1);
		String departs = departmentIds.toString();

		String hql = " SELECT * FROM dbo.[user] where id in (" + departs.substring(1, departs.length() - 1) + ")";
		userDAO.findListBySql(hql, null);
	}

	public void syncFBA() {
		productInfoSyncTask.syncFbaRepositoryStock();
	}
	
	public void syncReplenishmentTask() {
		productInfoSyncTask.syncReplenishmentTask();
	}

	public void syncCMS() {
//		messageTaskService.processingModifyOrder();
		messageTaskService.processingCMSMeseeage();
//		amazonUploadFileTaskService.autoOrderDeliveryTask();
	}
	
	public void syncCmsProductInfo(){
		productInfoSyncTask.syncCmsProductInfo();
//		productInfoSyncTask.cancelFreezeStock();
	}
	
	public void getCmsTheReplenishment(){
		int r=fbaShopProductComparableElement.getFbaTheReplenishment(45);
		System.out.println(r);
	}
	
	public void autoStatisticOrder(){
		reportTaskService.autoSetSumInventorySercurityLine();
	}
	
	
	public void getCountry(){
		systemService.getCountryByCode("MNE");
	}
	
	public void syncModify(){
		modifyRecordService.syncModifyRecordOrder(3762, 1);
	}
	
	public void syncSW(){
		orderSwMessageService.readMessage(1137);
	}
	
	public void updateAwaitReplenishment(){
		System.out.println(Thread.currentThread().getId());
		shopProductCmsInfoService.updateAwaitReplenishment(2131186);
	}
	
	public void processingOrderTracking(){
		orderTrackingMessageService.processingOrderTracking();
	}
	
	private OrderDao orderDao;
	private AmazonOrderService amazonOrderService;
	
	
	
	public void setAmazonOrderService(AmazonOrderService amazonOrderService) {
		this.amazonOrderService = amazonOrderService;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void addOrder(){
		String[] orders=new String[]{
//				"WA171001212537",
//				"WA171001393100",
//				"WA171001618591",
//				"WA171001342125",
//				"WA171001937830",
//				"WA171001791574",
//				"WA171001769182",
//				"WA171001380785",
//				"WA171001132931",
//				"WA170930619960",
//				"WA171001344721",
//				"WA171002810867",
//				"WA171002831241",
//				"WA171002124567",
//				"WA171002268215",
//				"WA171002483782",
//				"WA171002489567",
//				"WA171002234446",
//				"WA171002536543",
	
//				"WA171002853623",
//				"WA171002431754",
//				"WA171002566417",
//				"WA171003739764"
				
				"WA171003544903",
				"WA171003607106",
				"WA171003589738",
				"WA171003607137",
				"WA171005835209",
				"WA171005458987",
				"WA171005414992",
				"WA171005495871",
				"WA171005944410",
				"WA171005748870",
				"WA171005827709",
				"WA171005819175",
				"WA171005896270",
				"WA171005103075",
				"WA171005954532",
				"WA171005668390",
				"WA171005601843",
				"WA171005610312",
				"WA171005276409",
				"WA171006686650"
				
		};
		
		for (String code : orders) {
			Order o= amazonOrderService.getOrderByCode(code);
			try {
				CommandOrderUtils.addOrder(amazonOrderService.getOrderDeatil(o.getId()), 
						systemService.getShopInfo(o.getShopId()),true);
//				CommandOrderUtils.cancleOrder(code, null, 2);
			} catch (Exception e) {
				e.printStackTrace();
//				logger.debug(o.getCode());
			}
		}
	}
	
	public void addUser(){
		profileService.addUser("ite02715");
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
}
