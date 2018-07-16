package com.itecheasy.osms.order;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.*;
import com.itecheasy.core.order.OrderOperateLog;
import com.itecheasy.core.order.SearchOrderForm;
import com.itecheasy.core.order.UpdateOrderProductForm;
/** 
 * @author wanghw
 * @date 2016-12-2 
 * @description TODO
 * @version 1.2.2
 */
@WebService
public interface ReplenishmentOrderWebService {
	/**
	 * 确认订单失败
	 */
	static final String EX_CONFIRM_ORDER="确认订单失败";
	
	/**
	 * 增加补货单
	 * @param order
	 * @param items
	 */
	int addReplenishmentOrder(@WebParam(name="order")ReplenishmentOrder order,
			@WebParam(name="items")List<ReplenishmentOrderItem> items,
			@WebParam(name="operator")int operator);
	
	/**
	 * 确认补货单
	 * @param orderId
	 */
	void confirmOrder(@WebParam(name="orderId")int orderId,
			@WebParam(name="operator")int operator,
			@WebParam(name="isSw")boolean isSw)throws BussinessException;
	
	/**
	 * 取消订单商品项<br>
	 * 更新备货信息中的商品状态为取消 ，同时通信给C3<br>
	 * 如果取消订单中所有商品项，则更新订单状态为取消，通信给C3<br>
	 * 小批量订单，生成下架单后，不能取消商品 <br>
	 * 取消商品项后,要更新订单金额
	 * 
	 * @param orderId
	 * @param orderProductIds
	 * @param operator
	 * @throws BussinessException
	 */
	public void cancelOrderProducts(@WebParam(name="orderId")int orderId, 
			@WebParam(name="orderProductIds")int[] orderProductIds, 
			@WebParam(name="operator")int operator) throws BussinessException;

	/**
	 * 批量修改备货商品 
	 * @see #updateOrderProduct
	 * @param orderId
	 * @param operator
	 * @param forms
	 * @throws BussinessException
	 */
	public void updateOrderProducts(@WebParam(name="orderId")int orderId,
			@WebParam(name="operator")int operator,
			@WebParam(name="forms")List<UpdateOrderProductForm> forms)throws BussinessException;
	

	void updateOrderProductInfos(@WebParam(name="updateOrdertProductInfos")List<UpdateOrdertProductInfo> updateOrdertProductInfos,
			@WebParam(name="operator")int operator);
	/**
	 * 增加商品项
	 * @param orderId
	 * @param orderProducts
	 * @param operator
	 * @throws BussinessException
	 */
	void addOrderProducts(int orderId, 
			@WebParam(name="orderProducts")List<UpdateOrderProductForm> orderProducts, 
			@WebParam(name="operator")int operator)
			throws BussinessException;
	
	
	/**
	 * 上传货运单
	 * @param orderId
	 * @param shippingList
	 */
	void setShippingList(@WebParam(name="orderId")int orderId,
			@WebParam(name="shippingList")List<ReplenishmentOrderShippingList> shippingList,
			@WebParam(name="operator")int operator);
	
	/**
	 * 审核货运单
	 * @param isAuditThrough
	 * @param orderId
	 * @param operator
	 */
	void auditShippingList(@WebParam(name="isAuditThrough")boolean isAuditThrough,
			@WebParam(name="orderId")int orderId,
			@WebParam(name="operator")int operator);
	
	
	void deleteShippingList(@WebParam(name="orderId")int orderId,
			@WebParam(name="replenishmentOrderShippingListId")int replenishmentOrderShippingListId,
			@WebParam(name="operator")int operator);
	
	/**
	 * 修改货运地址
	 * 
	 * @param address
	 * @param operator
	 */
	public void updateOrderAddress(
			@WebParam(name="orderId")int orderId,
			@WebParam(name="repositoryId")int repositoryId,
			@WebParam(name="allUpdate")boolean allUpdate,
			@WebParam(name="operator")int operator) throws BussinessException;

	/**
	 * 修改货运方式
	 * 
	 * @param orderId
	 * @param shippingMethod
	 * @param operator
	 */
	public void updateShippingMethod(@WebParam(name="orderId")int orderId,
			@WebParam(name="shippingMethod")int shippingMethod,
			@WebParam(name="allUpdate")boolean allUpdate,
			@WebParam(name="operator")int operator);

	/**
	 * 保存发货说明
	 * 
	 * @param orderId
	 * @param remark
	 * @param operator
	 */
	public void saveSendRemark(
			@WebParam(name="fbaShipmentMethod") String fbaShipmentMethod,
			@WebParam(name="orderId")int orderId, 
			@WebParam(name="remark")String remark,
			@WebParam(name="cpfCode")String cpfCode,
			@WebParam(name="cpfType")int cpfType, 
			@WebParam(name="operator")int operator);
	
	
	
	ReplenishmentOrderDetail getReplenishmentOrderDetail(@WebParam(name="orderId")int orderId);
	
	List<ReplenishmentOrderItem> getReplenishmentOrderItems(@WebParam(name="orderId")int orderId);
	
	/**
	 * fba补货列表
	 * @return
	 */
	PageList<ReplenishmentOrder> findReplenishmentOrder(@WebParam(name="form")SearchOrderForm form, 
			@WebParam(name="currentPage")int currentPage, @WebParam(name="pageSize")int pageSize);
	
	
	/**
	 * 请求校对，通讯cms，判断发货标识，订单状态
	 */
	public boolean orderCheck(@WebParam(name="orderId")int orderId,@WebParam(name="operator")int operator);
	
	void orderPutInStorage(@WebParam(name="orderIds")int[] orderIds,@WebParam(name="operator")int operator);

	/**
	 * 取消订单，通讯cms
	 * 
	 * @param orderId
	 */
	public void cancelOrder(@WebParam(name="orderId")int orderId, @WebParam(name="operator")int operator);
	
	public void addTicketGroup(@WebParam(name="orderIds")int[] orderIds, @WebParam(name="operator")int operator);
	
	public void cancelTicketGroup(@WebParam(name="orderId")int orderId, @WebParam(name="operator")int operator);
	
	public List<ReplenishmentOrder> getTicketGroup(@WebParam(name="orderId")int orderId);

	public List<ReplenishmentOrder> getTicketGrouypByGroupId(@WebParam(name="groupId")int groupId);
	
	public List<OrderOperateLog> getOrderOperateLogs(@WebParam(name="orderId")int orderId);
	
	public void updateOrder(
			@WebParam(name="orderId")int orderId, 
			@WebParam(name="remark")String remark, 
			@WebParam(name="sendTag")boolean sendTag, 
			@WebParam(name="isQualityInspection")int isQualityInspection,
			@WebParam(name="subTotalPercent")double subTotalPercent,
			@WebParam(name="isUpdateSubTotalPercent")boolean isUpdateSubTotalPercent,
			@WebParam(name="operator")int operator);
	
	public int prepareAgain(
			@WebParam(name="orderId")int orderId, 
			@WebParam(name="operator")int operator);
	
	void resendOrder(@WebParam(name="orderId")int orderId, 
			@WebParam(name="operator")int operator);
	
	public List<ReplenishmentOrderShippingList> getShippingList(@WebParam(name="orderId")int orderId);
	
	public boolean existOrderCancelResendApply(@WebParam(name="orderCode")String orderCode);
	
	public boolean isAllSwProduct(@WebParam(name="orderId")int orderId);


	/**
	 *
	 * 传入FBA补货单ID 	查找 am（fba） 补货计划是否存在
	 *
	 * @param orderId
	 * @return
	 */
	public FbaReplenishmentPlan getFbaReplenishmentPlanByOrderId(@WebParam(name="orderId")Integer orderId);



}
