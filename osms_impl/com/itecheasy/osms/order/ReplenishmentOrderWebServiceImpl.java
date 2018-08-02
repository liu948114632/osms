package com.itecheasy.osms.order;

import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.*;
import com.itecheasy.core.order.OrderCancelResendService;
import com.itecheasy.core.order.OrderOperateLog;
import com.itecheasy.core.order.SearchOrderForm;
import com.itecheasy.core.order.UpdateOrderProductForm;
import com.itecheasy.core.user.ProfileService;

/** 
 * @author wanghw
 * @date 2016-12-2 
 * @description TODO
 * @version 1.2.2
 */
public class ReplenishmentOrderWebServiceImpl implements ReplenishmentOrderWebService {
	private ReplenishmentOrderService replenishmentOrderService;
	private ProfileService profileService;
	private OrderCancelResendService orderCancelResendService;
	

	public void setOrderCancelResendService(OrderCancelResendService orderCancelResendService) {
		this.orderCancelResendService = orderCancelResendService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setReplenishmentOrderService(ReplenishmentOrderService replenishmentOrderService) {
		this.replenishmentOrderService = replenishmentOrderService;
	}

	@Override
	public int addReplenishmentOrder(ReplenishmentOrder order, List<ReplenishmentOrderItem> items, int operator) {
		return replenishmentOrderService.addReplenishmentOrder(order, items, profileService.getUserNameById(operator));
	}

	@Override
	public void confirmOrder(int orderId, int operator,boolean isSw) throws BussinessException {
		replenishmentOrderService.confirmOrder(orderId, profileService.getUserNameById(operator),isSw);
	}

	@Override
	public void cancelOrderProducts(int orderId, int[] orderProductIds, int operator) throws BussinessException {
		replenishmentOrderService.cancelOrderProducts(orderId, orderProductIds, profileService.getUserNameById(operator));
	}

	@Override
	public void updateOrderProducts(int orderId, int operator, List<UpdateOrderProductForm> forms)
			throws BussinessException {
		if(CollectionUtils.isEmpty(forms))
			return;
		replenishmentOrderService.updateOrderProducts(orderId, profileService.getUserNameById(operator), forms);
	}

	@Override
	public void addOrderProducts(int orderId, List<UpdateOrderProductForm> orderProducts, int operator)
			throws BussinessException {
		replenishmentOrderService.addOrderProducts(orderId, orderProducts, profileService.getUserNameById(operator));
	}

	@Override
	public void addAndUpdateOrderProductList(int orderId, List<UpdateOrderProductForm> orderProducts, String operator) throws BussinessException{
		replenishmentOrderService.addAndUpdateOrderProductList(orderId,orderProducts,operator);
	}

	@Override
	public void setShippingList(int orderId, List<ReplenishmentOrderShippingList> shippingList, int operator) {
		replenishmentOrderService.setShippingList(orderId, shippingList, profileService.getUserNameById(operator));
	}

	@Override
	public void auditShippingList(boolean isAuditThrough, int orderId, int operator) {
		replenishmentOrderService.auditShippingList(isAuditThrough, orderId, profileService.getUserNameById(operator));
	}

	@Override
	public void deleteShippingList(int orderId, int replenishmentOrderShippingListId, int operator) {
		replenishmentOrderService.deleteShippingList(orderId, replenishmentOrderShippingListId, profileService.getUserNameById(operator));
	}
	
	@Override
	public void updateOrderAddress(int orderId, int repositoryId,boolean allUpdate, int operator) throws BussinessException {
		replenishmentOrderService.updateOrderAddress(orderId, repositoryId, allUpdate, profileService.getUserNameById(operator));
	}

	@Override
	public void updateShippingMethod(int orderId, int shippingMethod,boolean allUpdate, int operator) {
		replenishmentOrderService.updateShippingMethod(orderId, shippingMethod, allUpdate, profileService.getUserNameById(operator));
	}

	@Override
	public void saveSendRemark(String fbaShipmentMethod, int orderId, String remark, String cpfCode, int cpfType, int operator) {
		replenishmentOrderService.saveSendRemark(fbaShipmentMethod,orderId, remark, cpfCode, cpfType, profileService.getUserNameById(operator));
	}

	@Override
	public ReplenishmentOrderDetail getReplenishmentOrderDetail(int orderId) {
		return replenishmentOrderService.getReplenishmentOrderDetail(orderId);
	}

	@Override
	public PageList<ReplenishmentOrder> findReplenishmentOrder(SearchOrderForm form, int currentPage, int pageSize) {
		return replenishmentOrderService.findReplenishmentOrder(form, currentPage, pageSize);
	}

	@Override
	public boolean orderCheck(int orderId, int operator) {
		return replenishmentOrderService.orderCheck(orderId, profileService.getUserNameById(operator));
	}

	@Override
	public void cancelOrder(int orderId, int operator) {
		replenishmentOrderService.cancelOrder(orderId, operator);
	}

	@Override
	public void addTicketGroup(int[] orderIds, int operator) {
		replenishmentOrderService.addTicketGroup(orderIds, profileService.getUserNameById(operator));
	}

	@Override
	public void cancelTicketGroup(int orderId, int operator) {
		replenishmentOrderService.cancelTicketGroup(orderId, profileService.getUserNameById(operator));
	}

	@Override
	public List<ReplenishmentOrder> getTicketGroup(int orderId) {
		return replenishmentOrderService.getTicketGroup(orderId);
	}

	@Override
	public List<ReplenishmentOrder> getTicketGrouypByGroupId(int groupId) {
		return replenishmentOrderService.getTicketGrouypByGroupId(groupId);
	}

	@Override
	public List<OrderOperateLog> getOrderOperateLogs(int orderId) {
		return replenishmentOrderService.getOrderOperateLogs(orderId);
	}

	@Override
	public void updateOrder(int orderId, String remark, boolean sendTag, int isQualityInspection,
			double subTotalPercent, boolean isUpdateSubTotalPercent, int operator) {
		replenishmentOrderService.updateOrder(orderId, remark, sendTag, isQualityInspection, subTotalPercent, isUpdateSubTotalPercent, profileService.getUserNameById(operator));
	}

	@Override
	public int prepareAgain(int orderId, int operator) throws BussinessException {
		return replenishmentOrderService.copyOrder(orderId, profileService.getUserNameById(operator));
	}

	@Override
	public void resendOrder(int orderId, int operator) {
		replenishmentOrderService.resendOrder(orderId, operator);
	}
	
	@Override
	public List<ReplenishmentOrderShippingList> getShippingList(int orderId) {
		return replenishmentOrderService.getShippingList(orderId);
	}
	
	@Override
	public List<ReplenishmentOrderItem> getReplenishmentOrderItems(int orderId) {
		return replenishmentOrderService.getOrderProduct(orderId);
	}

	@Override
	public void orderPutInStorage(int[] orderIds, int operator) {
		for (int orderId : orderIds) {
			replenishmentOrderService.orderPutInStorage(orderId, profileService.getUserNameById(operator));
		}
	}
	
	@Override
	public boolean existOrderCancelResendApply(String orderCode) {
		return orderCancelResendService.existOrderCancelResendApply(orderCode);
	}
	
	
	@Override
	public void updateOrderProductInfos(List<UpdateOrdertProductInfo> updateOrdertProductInfos, int operator) {
		replenishmentOrderService.updateOrderProductInfos(updateOrdertProductInfos, profileService.getUserNameById(operator));
	}
	
	@Override
	public boolean isAllSwProduct(int orderId) {
		return replenishmentOrderService.isAllSwProduct(orderId);
	}

	@Override
	public FbaReplenishmentPlan getFbaReplenishmentPlanByOrderId(Integer orderId) {
		return replenishmentOrderService.getFbaReplenishmentPlanByOrderId(orderId);
	}
}
