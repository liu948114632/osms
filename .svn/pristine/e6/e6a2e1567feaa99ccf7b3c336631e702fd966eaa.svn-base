package com.itecheasy.osms.order;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.order.ModifyRecordOrder;
import com.itecheasy.core.order.ModifyRecordOrderForm;
import com.itecheasy.core.order.ModifyRecordOrderItem;
import com.itecheasy.core.order.ModifyRecordOrderVO;
import com.itecheasy.core.order.OrderTracking;
import com.itecheasy.core.order.OrderTrackingLog;
import com.itecheasy.core.order.OrderTrackingProduct;
import com.itecheasy.core.order.OrderTrackingProductAttachment;
import com.itecheasy.core.order.OrderTrackingItem;
import com.itecheasy.core.order.SearchOrderTrackingForm;
/** 
 * @author wanghw
 * @date 2017-1-11 
 * @description TODO
 * @version 1.2.2
 */
@WebService
public interface OrderCorrelationWebService {
	boolean existOrderCancelResendApply(@WebParam(name="orderCode")String orderCode);
	
	void confirmModifyRecordOrder(@WebParam(name="modifyRecordOrderId")int modifyRecordOrderId,
			@WebParam(name="operator")int operator,@WebParam(name="remark")String remark);
	
	void enableProcessModifyRecord(@WebParam(name="modifyRecordOrderId")int modifyRecordOrderId,
			@WebParam(name="operator")int operator,@WebParam(name="remark")String remark);
	
	ModifyRecordOrder getModifyRecordOrder(@WebParam(name="orderCode")int modifyRecordOrderId);

	List<ModifyRecordOrderItem> getModifyRecordOrderItems(@WebParam(name="modifyRecordOrderId")int modifyRecordOrderId);
	
	ModifyRecordOrderVO findModifyRecordOrderVO(@WebParam(name="form")ModifyRecordOrderForm form);
	
	@WebMethod
	List<String> getModifyCreator();
	

	/**
	 * 增加订单跟踪
	 * @param orderTracking
	 */
	public void setOrderTracking(@WebParam(name="orderTracking")OrderTracking orderTracking, 
			@WebParam(name="operator")int operator)throws BussinessException;
	
	/**
	 * 只有C3创建的订单跟踪才可以操作， 回复订单跟踪或者修改备注
	 * @param tacking
	 * @param isSave
	 * @param operatorId
	 */
	public void updateOrderTracking(@WebParam(name="tacking")OrderTracking tacking,
			@WebParam(name="isSave")boolean isSave,
			@WebParam(name="operatorId")int operatorId);
	
	/**
	 * 删除订单跟踪
	 * @param orderTrackingId
	 * @param operator
	 */
	public void deleteOrderTracking(@WebParam(name="orderTrackingIds")int[] orderTrackingIds,
			@WebParam(name="operator")int operator)throws BussinessException;
	
	
	/**
	 * 完成订单跟踪
	 * @param orderTrackingId
	 * @param operator
	 */
	public void completeOrderTracking(@WebParam(name="orderTrackingIds")int[] orderTrackingIds,
			@WebParam(name="operator")int operator)throws BussinessException;
	
	
	/**
	 * 更新订单跟踪咨询人
	 * @param orderTrackingId
	 * @param Author
	 * @param operator
	 * @throws BussinessException
	 */
	public void updateOrderTrackingConsultationUser(
			@WebParam(name="orderTrackingIds")int[] orderTrackingIds,
			@WebParam(name="orderTrackingConsultationUser")int orderTrackingConsultationUser,
			@WebParam(name="operator")int operator)throws BussinessException;

	/**
	 * 获取所有咨询人，CAMS操作用户+C3过来的咨询人
	 * @return
	 */
	public List<Integer> getOrderTrackingConsultationUsers();
	
	/**
	 * 标读当前用户是否已读	after user click this button change having read
	 * @param orderTrackingId
	 * @param operatorId
	 * @throws BussinessException
	 */
	public void updateOrderTrackingReaded(@WebParam(name="orderTrackingId")int orderTrackingId,
			@WebParam(name="operator")int operatorId) throws BussinessException;
	
	/**
	 * 分页查询订单跟踪
	 * @param form
	 * @return
	 */
	public PageList<OrderTracking> findOrderTracking(@WebParam(name="form")SearchOrderTrackingForm form, 
			@WebParam(name="operator")String operator);


	/**
	 * 阅读订单跟踪信息
	 * @param packageProblemId
	 */
//	List readOrderTracking(int orderTrackingId);


	/**
	 * 根据订单跟踪号获取订单跟踪信息
	 * @param code
	 * @return
	 */
	public OrderTracking getOrderTrackingByCode(@WebParam(name="code")String code);

	/**
	 * 根据全部有改产品id的订单跟踪信息	商品编号cmsProductCode
	 * @param productCode   产品id
	 * @return
	 */
	public List<OrderTracking> getOrderTrackingByProductId(@WebParam(name="ProductCode")String productCode);



	/**
	 * 获取订单跟踪信息
	 * @param orderTrackingId
	 * @return
	 */
	public OrderTracking getOrderTracking(@WebParam(name="orderTrackingId")int orderTrackingId);
	
	public OrderTracking getOrderTrackingDetail(@WebParam(name="orderTrackingId")int orderTrackingId);
	
	/**
	 * 订单跟踪回复
	 * @return
	 */
	public List<OrderTrackingItem> getOrderTrackingItems(@WebParam(name="orderTrackingId")int orderTrackingId);
	
	/**
	 * 订单跟踪详细
	 * @param orderTrackingId
	 * @return
	 */
	List<OrderTrackingProduct> getOrderTrackingProducts(@WebParam(name="orderTrackingId")int orderTrackingId);
	
	/**
	 * 订单附件
	 * @param orderTrackingProductId
	 * @return
	 */
	public List<OrderTrackingProductAttachment> getOrderTrackingAttachments(@WebParam(name="orderTrackingProductId")int orderTrackingProductId);
	
	public List<OrderTrackingLog> getOrderTrackingLogs(@WebParam(name="orderTrackingId")int orderTrackingId);	
}
