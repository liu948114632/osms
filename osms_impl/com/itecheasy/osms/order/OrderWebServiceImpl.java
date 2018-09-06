package com.itecheasy.osms.order;

import java.util.Date;
import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.ConstantUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.UpdateOrdertProductInfo;
import com.itecheasy.core.order.CountOrderProfitVO;
import com.itecheasy.core.order.EbayOrderData;
import com.itecheasy.core.order.EbayOrderService;
import com.itecheasy.core.order.FBAStoreOrderService;
import com.itecheasy.core.order.FBAStoreProduct;
import com.itecheasy.core.order.FBAStoreProductLog;
import com.itecheasy.core.order.FBAStoreProductVO;
import com.itecheasy.core.order.IOrderSchedule;
import com.itecheasy.core.order.Order;
import com.itecheasy.core.order.OrderAddress;
import com.itecheasy.core.order.OrderCountReport;
import com.itecheasy.core.order.OrderDetail;
import com.itecheasy.core.order.OrderOperateLog;
import com.itecheasy.core.order.OrderPaymentDataType;
import com.itecheasy.core.order.OrderPaymentDataTypeAmountCount;
import com.itecheasy.core.order.OrderPaymentReport;
import com.itecheasy.core.order.OrderReportSearchForm;
import com.itecheasy.core.order.OrderReportService;
import com.itecheasy.core.order.OrderService;
import com.itecheasy.core.order.PackageProblemHistory;
import com.itecheasy.core.order.PackageProblemSerchForm;
import com.itecheasy.core.order.PackageProblemService;
import com.itecheasy.core.order.PackageProblemVO;
import com.itecheasy.core.order.SearchFBAStorageCountForm;
import com.itecheasy.core.order.SearchOrderForm;
import com.itecheasy.core.order.UpdateOrderProductForm;
import com.itecheasy.core.task.BaseOrderView;
import com.itecheasy.core.user.ProfileService;
import com.itecheasy.core.util.SystemEnumDicts.ShopType;
import com.itecheasy.webservice.client.CMSClient;

/**
 * @author wanghw
 * @date 2015-5-9
 * @description
 * @version
 */
public class OrderWebServiceImpl implements OrderWebService {
	private OrderService orderService;
	private ProfileService profileService;
	private EbayOrderService ebayOrderService;
	private IOrderSchedule orderSchedule;
	

	public void setOrderSchedule(IOrderSchedule orderSchedule) {
		this.orderSchedule = orderSchedule;
	}

	public void setEbayOrderService(EbayOrderService ebayOrderService) {
		this.ebayOrderService = ebayOrderService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public void updateOrder(int orderId, String remark, boolean sendTag, int isQualityInspection, int operator) throws BussinessException {

		orderService.updateOrder(orderId, remark, sendTag, isQualityInspection, profileService.getUserNameById(operator));
	}

	@Override
	public void addTicketGroup(int[] orderIds, int operator) throws BussinessException {
		orderService.addTicketGroup(orderIds, profileService.getUserNameById(operator));
	}

	@Override
	public void cancelTicketGroup(int orderId, int operator) throws BussinessException {
		orderService.cancelTicketGroup(orderId, profileService.getUserNameById(operator));
	}

	@Override
	public int prepareAgain(int orderId, int operator) throws BussinessException {
		return orderService.copyOrder(orderId, profileService.getUserNameById(operator));
	}

	@Override
	public void cancelOrderProducts(int orderId, int[] orderProductIds, int operator) throws BussinessException {
		orderService.cancelOrderProducts(orderId, orderProductIds, profileService.getUserNameById(operator));
	}

	@Override
	public void updateOrderProducts(int orderId, int operator, List<UpdateOrderProductForm> forms) throws BussinessException {
		orderService.updateOrderProducts(orderId, profileService.getUserNameById(operator), forms);
	}

	@Override
	public void updateOrderProduct(int orderId, int orderProductId, String updateProductCode, double qty, int operator)
			throws BussinessException {

	}

	@Override
	public void updateOrderAddress(OrderAddress address, int operator, boolean tag) throws BussinessException {
		orderService.updateOrderAddress(address, profileService.getUserNameById(operator), tag);
	}

	@Override
	public void updateShippingMethod(int orderId, int shippingMethod, int operator, boolean tag) {
		orderService.updateShippingMethod(orderId, shippingMethod, profileService.getUserNameById(operator), tag);
	}

	@Override
	public void saveSendRemark(int orderId, String remark, String cpfCode, int cpfType, int operator) {
		orderService.saveSendRemark(orderId, remark, cpfCode, cpfType, profileService.getUserNameById(operator));
	}

	@Override
	public OrderDetail getOrderDeatil(int orderId) {
		OrderDetail orderDetail = orderService.getOrderDeatil$remote(orderId);
//		orderService.updateOrderShippingMethod(orderDetail);
		return orderDetail;
	}


	@Override
	public List<Order> getTicketGroup(int orderId) {
		return orderService.getTicketGroup(orderId);
	}

	@Override
	public PageList<Order> findOrders(SearchOrderForm form, int currentPage, int pageSize) {
		PageList<Order> pageList = orderService.findOrders(form, currentPage, pageSize);

//		for (Order order : pageList.getData() ) {
//			OrderDetail orderDetail = orderService.getOrderDeatil$remote(order.getId());
//			order.setShippingMethod(orderDetail.getShippingMethod());
//		}

		return pageList;
	}

	@Override
	public List<OrderOperateLog> getOrderOperateLogs(int orderId) {
		return orderService.getOrderOperateLogs(orderId);
	}

	@Override
	public int getCustomerTotalOrderNum(String customerAccount, int shopId, String fulfillmentChannel) {
		return orderService.getCustomerTotalOrderNum(customerAccount, shopId, fulfillmentChannel);
	}

	@Override
	public void quickShip(int orderId, String traceCode, double deliveryCost, Date deliveryDate, Double costPrice,
			int operator) {
		orderService.quickShip(orderId, traceCode, deliveryCost, deliveryDate, costPrice,
				profileService.getUserNameById(operator));
	}

	@Override
	public void beforeShip(int orderId, String traceCode, Date deliveryDate, int operator) {
		orderService.beforeShip(orderId, traceCode, deliveryDate, profileService.getUserNameById(operator));
	}

	@Override
	public void setOrderItem2NotCMSPrepare(int orderPrepareProductId, int operator) throws BussinessException {
		orderService.setOrderItem2NotCMSPrepare(orderPrepareProductId, profileService.getUserNameById(operator));
	}

	private OrderReportService orderReportService;

	public void setOrderReportService(OrderReportService orderReportService) {
		this.orderReportService = orderReportService;
	}

	@Override
	public void orderOut(int orderId, int operator) throws BussinessException {
		orderService.orderOut(orderId, profileService.getUserNameById(operator));
	}

	@Override
	public void addOrderProducts(int orderId, List<UpdateOrderProductForm> orderProducts, int operator)
			throws BussinessException {
		orderService.addOrderProducts(orderId, orderProducts, profileService.getUserNameById(operator));
	}

	@Override
	public String addOrderPayments(List<OrderPaymentReport> report, int shopId) throws BussinessException {
		return orderReportService.addOrderPayments(report, shopId);
	}

	@Override
	public List<OrderPaymentReport> findOrderPayments(OrderReportSearchForm form) {
		form.setCurrentPage(1);
		form.setPageSize(10000);
		PageList<OrderPaymentReport> page = orderReportService.findOrderPayments(form);
		if (page != null) {
			return page.getData();
		}
		return null;
	}

	@Override
	public List<OrderPaymentDataTypeAmountCount> countOrderPaymentAmountByDataType(OrderReportSearchForm form) {
		return null;
	}

	@Override
	public List<OrderCountReport> findOrderCountReport(OrderReportSearchForm form) {
		return orderReportService.findOrderCountReport(form);
	}

	@Override
	public CountOrderProfitVO countOrderProfit(OrderReportSearchForm from) throws BussinessException {
		return orderReportService.countOrderProfit(from);
	}

	@Override
	public List<OrderCountReport> countOrderReport(OrderReportSearchForm form) {
		return null;
	}

	@Override
	public List<OrderPaymentDataType> getOrderPaymentDataTypes() {
		return orderReportService.getOrderPaymentDataTypes();
	}

	private PackageProblemService packageProblemService;

	public void setPackageProblemService(PackageProblemService packageProblemService) {
		this.packageProblemService = packageProblemService;
	}

	@Override
	public void applyPackageProblem(PackageProblemHistory history, int packageProblemId, int processResultType,String operator)
			throws BussinessException {
		packageProblemService.applyPackageProblem(history, packageProblemId, processResultType,operator);
	}

	@Override
	public void closePackageProblem(int packageProblemId, int operator) throws BussinessException {
		packageProblemService.closePackageProblem(packageProblemId, profileService.getUserNameById(operator));
	}

	@Override
	public void reopenPackageProblem(int packageProblemId, int operator) throws BussinessException {
		packageProblemService.reopenPackageProblem(packageProblemId, operator);
	}

	@Override
	public PageList<PackageProblemVO> findPackageProblems(PackageProblemSerchForm form) {
		return packageProblemService.findPackageProblems(form);
	}

	@Override
	public List<PackageProblemHistory> getPackageProblemHistories(int packageProblemId) {
		return packageProblemService.getPackageProblemHistories(packageProblemId);
	}

	@Override
	public List<PackageProblemHistory> readPackageProblem(int packageProblemId) {
		packageProblemService.readPackageProblem(packageProblemId);
		return packageProblemService.getPackageProblemHistories(packageProblemId);
	}

	@Override
	public List<String> getPackageProblemCreateUser() {
		return packageProblemService.getPackageProblemCreateUser();
	}

	@Override
	public List<String> getDeliveryCustomerService() {
		return packageProblemService.getDeliveryCustomerService();
	}

	@Override
	public CountOrderProfitVO countAllOrderProfitByDay(OrderReportSearchForm form) throws BussinessException {
		return orderReportService.countAllOrderProfitByDay(form);
	}

	@Override
	public CountOrderProfitVO countFBAOrderAmount(OrderReportSearchForm form) throws BussinessException {
		return orderReportService.countFBAOrderAmount(form);
	}

	@Override
	public List<OrderCountReport> countOrderAmount(OrderReportSearchForm form) throws BussinessException {
		return orderReportService.countOrderAmount(form);
	}

	@Override
	public void orderCheck(int orderId, int operator) {
		if(!orderService.orderCheck(orderId, profileService.getUserNameById(operator))){
			throw new RuntimeException("订单正在质检，请质检完后再请求校对！");
		}
	}

	@Override
	public void resendOrder(int orderId, int operator) throws BussinessException {
		orderService.resendOrder(orderId, operator);
	}

	@Override
	public void confirmPackage(int orderId, int operator) throws BussinessException {
		orderService.confirmPackage(orderId, profileService.getUserNameById(operator));
	}

	@Override
	public void importFBAStoreProducts(List<FBAStoreProduct> fbaStoreProducts, int operator) {
		fbaStoreOrderService.importFBAStoreProducts(fbaStoreProducts, operator);
	}

	private FBAStoreOrderService fbaStoreOrderService;
	
	
	public void setFbaStoreOrderService(FBAStoreOrderService fbaStoreOrderService) {
		this.fbaStoreOrderService = fbaStoreOrderService;
	}

	@Override
	public PageList<FBAStoreProductVO> countFBAStoreProducts(SearchFBAStorageCountForm form, int currentPage,
			int pageSize) {
		return fbaStoreOrderService.countFBAStoreProducts(form, currentPage, pageSize);
	}

	@Override
	public FBAStoreProductVO getFBAStoreProductCountDetail(int fbaStoreProductId) {
		return fbaStoreOrderService.getFBAStoreProductCountDetail(fbaStoreProductId);
	}

	@Override
	public List<OrderCountReport> FBAStoreProductSales(OrderReportSearchForm form) {
		return fbaStoreOrderService.FBAStoreProductSales(form);
	}

	@Override
	public List<FBAStoreProductLog> getFBAStoreProductLogs(int fbaStoreProductId) {
		return fbaStoreOrderService.getFBAStoreProductLogs(fbaStoreProductId);
	}
	
	@Override
	public void updateFBAStoreProductStatus(List<Integer> fbaStoreProductId,List<Integer> status) {
		if(CollectionUtils.isNotEmpty(fbaStoreProductId)){
			for (int i = 0; i < fbaStoreProductId.size(); i++) {
				fbaStoreOrderService.updateFBAStoreProductStatus(fbaStoreProductId.get(i), status.get(i));
			}
		}
	}
	
	@Override
	public void confirmOrderQuestion(int packageProblemId,String operator)
			throws BussinessException{
		packageProblemService.confirmOrderQuestion(packageProblemId, operator);
	}

	@Override
	public String importEbayOrder(List<EbayOrderData> datas, int shopId, int operator)throws BussinessException {
		//合并数据
		return ebayOrderService.importEbayOrder(datas, shopId, operator);
	}
	
	@Override
	public void set2NotCMSPrepare(int orderId, int operator) throws BussinessException {
		orderService.set2NotCMSPrepare(orderId, profileService.getUserNameById(operator));
	}
	
	@Override
	public void updateOrderProductInfos(List<UpdateOrdertProductInfo> updateOrdertProductInfos, int operator) {
		orderService.updateOrderProductInfos(updateOrdertProductInfos, profileService.getUserNameById(operator));
	}
	
	@Override
	public int getPackageProblemHasNotReadMessageQty(int userId) {
		return packageProblemService.getPackageProblemHasNotReadMessageQty(userId);
	}
	
	@Override
	public BaseOrderView getBaseOrderView(String orderCode){
		return orderSchedule.getOrderByCode(orderCode);
	}
	
	@Override
	public OrderDetail getOrder(String orderCode) {
		Order order=orderService.getOrderByCode(orderCode);
		if(order!=null)
			return getOrderDeatil(order.getId());
		return null;
	}
	
	@Override
	public void addOrder(OrderDetail order, ShopType type, String operator) {
		orderService.addOrderByManual(order, type.getVal(), operator);
	}


	@Override
	public void addOrderToDms(OrderDetail order, String operator) throws BussinessException {

	}
}
