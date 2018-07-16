package com.itecheasy.osms.order;

import java.util.ArrayList;
import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.order.BaseOrderItem;
import com.itecheasy.core.order.IOrderSchedule;
import com.itecheasy.core.order.ModifyRecordOrder;
import com.itecheasy.core.order.ModifyRecordOrderForm;
import com.itecheasy.core.order.ModifyRecordOrderItem;
import com.itecheasy.core.order.ModifyRecordOrderVO;
import com.itecheasy.core.order.ModifyRecordService;
import com.itecheasy.core.order.OrderCancelResendService;
import com.itecheasy.core.order.OrderTracking;
import com.itecheasy.core.order.OrderTrackingItem;
import com.itecheasy.core.order.OrderTrackingLog;
import com.itecheasy.core.order.OrderTrackingProduct;
import com.itecheasy.core.order.OrderTrackingProductAttachment;
import com.itecheasy.core.order.OrderTrackingService;
import com.itecheasy.core.order.SearchOrderTrackingForm;
import com.itecheasy.core.product.CMSProduct;
import com.itecheasy.core.task.BaseOrderView;
import com.itecheasy.webservice.client.CMSClient;

/**
 * @author wanghw
 * @date 2017-1-11
 * @description TODO
 * @version 1.2.2
 */
public class OrderCorrelationWebServiceImpl implements OrderCorrelationWebService {
	private OrderCancelResendService orderCancelResendService;
	private ModifyRecordService modifyRecordService;
	private IOrderSchedule orderSchedule;
	private OrderTrackingService orderTrackingService;

	public void setOrderTrackingService(OrderTrackingService orderTrackingService) {
		this.orderTrackingService = orderTrackingService;
	}

	public void setOrderSchedule(IOrderSchedule orderSchedule) {
		this.orderSchedule = orderSchedule;
	}

	public void setModifyRecordService(ModifyRecordService modifyRecordService) {
		this.modifyRecordService = modifyRecordService;
	}

	public void setOrderCancelResendService(OrderCancelResendService orderCancelResendService) {
		this.orderCancelResendService = orderCancelResendService;
	}

	@Override
	public boolean existOrderCancelResendApply(String orderCode) {
		return orderCancelResendService.existOrderCancelResendApply(orderCode);
	}

	@Override
	public void confirmModifyRecordOrder(int modifyRecordOrderId, int operator, String remark) {
		modifyRecordService.confirmModifyRecordOrder(modifyRecordOrderId, operator, remark);
	}

	@Override
	public void enableProcessModifyRecord(int modifyRecordOrderId, int operator, String remark) {
		modifyRecordService.enableProcessModifyRecord(modifyRecordOrderId, operator, remark);
	}

	@Override
	public ModifyRecordOrder getModifyRecordOrder(int modifyRecordOrderId) {
		return modifyRecordService.getModifyRecordOrder(modifyRecordOrderId);
	}

	@Override
	public List<ModifyRecordOrderItem> getModifyRecordOrderItems(int modifyRecordOrderId) {
		List<ModifyRecordOrderItem> items=modifyRecordService.getModifyRecordOrderItems(modifyRecordOrderId);
		ModifyRecordOrder order=modifyRecordService.getModifyRecordOrder(modifyRecordOrderId);
		BaseOrderView view=orderSchedule.getOrderByCode(order.getOrderCode());
		if(view==null)
			return items;
		if(CollectionUtils.isNotEmpty(items)){
			for (ModifyRecordOrderItem item : items) {
				BaseOrderItem orderItem= orderSchedule.getInstance(view.getTableType()).getOrderItem(view.getId(), item.getProductId());
				if(orderItem!=null){
					item.setOrderItemStatus(orderItem.getStatus());
				}
				item.setNewValue(modifyRecordService.calcNewValue(view, item));
			}
		}
		return items;
	}

	@Override
	public ModifyRecordOrderVO findModifyRecordOrderVO(ModifyRecordOrderForm form) {
		return modifyRecordService.findModifyRecordOrderVO(form);
	}

	@Override
	public List<String> getModifyCreator() {
		return modifyRecordService.getModifyCreator();
	}

	@Override
	public void setOrderTracking(OrderTracking orderTracking, int operator) throws BussinessException {
		orderTrackingService.setOrderTracking(orderTracking, operator);
	}

	@Override
	public void updateOrderTracking(OrderTracking tacking, boolean isSave, int operatorId) {
		orderTrackingService.updateOrderTracking(tacking, isSave, operatorId);
	}

	@Override
	public void deleteOrderTracking(int[] orderTrackingIds, int operator) throws BussinessException {
		orderTrackingService.deleteOrderTracking(orderTrackingIds, operator);
	}

	@Override
	public void completeOrderTracking(int[] orderTrackingIds, int operator) throws BussinessException {
		orderTrackingService.completeOrderTracking(orderTrackingIds, operator);
	}

	@Override
	public void updateOrderTrackingConsultationUser(int[] orderTrackingIds, int orderTrackingConsultationUser,
			int operator) throws BussinessException {
		orderTrackingService.updateOrderTrackingConsultationUser(orderTrackingIds, orderTrackingConsultationUser, operator);
	}

	@Override
	public List<Integer> getOrderTrackingConsultationUsers() {
		return orderTrackingService.getOrderTrackingConsultationUsers();
	}

	@Override
	public void updateOrderTrackingReaded(int orderTrackingId, int operatorId) throws BussinessException {
		orderTrackingService.updateOrderTrackingReaded(orderTrackingId,operatorId);
	}

	@Override
	public PageList<OrderTracking> findOrderTracking(SearchOrderTrackingForm form, String operator) {
		return orderTrackingService.findOrderTracking(form);
	}

//	@Override
//	public List readOrderTracking(int orderTrackingId) {
//		return null;
//	}

	@Override
	public OrderTracking getOrderTrackingByCode(String code) {
		return orderTrackingService.getOrderTrackingByCode(code);
	}

	@Override
	public List<OrderTracking> getOrderTrackingByProductId(String productId) {
		return orderTrackingService.getOrderTrackingByProductId(productId);
	}

	@Override
	public OrderTracking getOrderTracking(int orderTrackingId) {
		return orderTrackingService.getOrderTracking(orderTrackingId);
	}

	@Override
	public OrderTracking getOrderTrackingDetail(int orderTrackingId) {
		OrderTracking o = getOrderTracking(orderTrackingId);
		if (o != null) {
			o.setProducts(getOrderTrackingProducts(orderTrackingId));
			o.setItems(getOrderTrackingItems(orderTrackingId));
		}
		return o;
	}

	@Override
	public List<OrderTrackingItem> getOrderTrackingItems(int orderTrackingId) {
		return orderTrackingService.getOrderTrackingItems(orderTrackingId);
	}

	@Override
	public List<OrderTrackingProduct> getOrderTrackingProducts(int orderTrackingId) {
		 List<OrderTrackingProduct>  ps=orderTrackingService.getOrderTrackingProducts(orderTrackingId);
		 if(CollectionUtils.isNotEmpty(ps)){
			 List<String> codes=new ArrayList<String>();
			 for (OrderTrackingProduct p : ps) {
				p.setAttachments(orderTrackingService.getOrderTrackingAttachments(p.getId()));
				codes.add(p.getCmsProductCode());
			}
			 
			 List<CMSProduct> cms= CMSClient.getCMSProductByCodes(codes);
			 if(CollectionUtils.isNotEmpty(cms)){
				 for (CMSProduct cmsProduct : cms) {
					 for (OrderTrackingProduct p : ps) {
						if(p.getCmsProductCode().endsWith(cmsProduct.getCode())){
							p.setOfflineStatus(cmsProduct.getOfflineStatus());
							p.setAvailableStock(cmsProduct.getAvailableStock());
							break;
						}
					}
				}
			 }
		 }
		 return ps;
	}

	@Override
	public List<OrderTrackingProductAttachment> getOrderTrackingAttachments(int orderTrackingProductId) {
		return orderTrackingService.getOrderTrackingAttachments(orderTrackingProductId);
	}

	@Override
	public List<OrderTrackingLog> getOrderTrackingLogs(int orderTrackingId) {
		return orderTrackingService.getOrderTrackingLogs(orderTrackingId);
	}

}
