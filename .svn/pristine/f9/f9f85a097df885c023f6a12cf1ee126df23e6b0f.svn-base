package com.itecheasy.core.fba;

import java.io.File;
import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.order.IBaseOrder;
import com.itecheasy.core.order.SearchOrderForm;
import com.itecheasy.core.order.UpdateOrderProductForm;

/** 
 * @author wanghw
 * @date 2016-11-29 
 * @description fba补货单业务
 * @version 1.2.2
 */
public interface ReplenishmentOrderService extends IBaseOrder{
	
	/**
	 * 增加补货单
	 * @param order
	 * @param items
	 */
	int  addReplenishmentOrder(ReplenishmentOrder order,List<ReplenishmentOrderItem> items,String operator);
	
	/**
	 * 复制订单
	 * @param orderId
	 * @param operator
	 * @return
	 */
	public int copyOrder(int orderId, String operator);
	
	/**
	 * 确认补货单
	 * @param orderId
	 * @throws BussinessException {@link #EX_CONFIRM_ORDER} 
	 */
	void confirmOrder(int orderId,String operator,boolean isSw)throws BussinessException;
	
	
	/**
	 * 订单入仓
	 * @param orderId
	 * @param operator
	 */
	void orderPutInStorage(int orderId,String operator);
	
	/**
	 * 取消订单，通讯cms
	 * 
	 * @param orderId
	 */
	public void cancelOrder(int orderId, int operator);
	
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
	public void cancelOrderProducts(int orderId, int[] orderProductIds, String operator) throws BussinessException;

	
	/**
	 * 批量修改备货商品 
	 * @see #updateOrderProduct
	 * @param orderId
	 * @param operator
	 * @param forms
	 * @throws BussinessException 
	 */
	public void updateOrderProducts(int orderId,String operator,List<UpdateOrderProductForm> forms)throws BussinessException;
	
	/**
	 * 增加商品项
	 * @param orderId
	 * @param orderProducts
	 * @param operator
	 * @throws BussinessException
	 */
	void addOrderProducts(int orderId, List<UpdateOrderProductForm> orderProducts, String operator)
			throws BussinessException;

	 void addAndUpdateOrderProductList(int orderId, List<UpdateOrderProductForm> orderProducts, String operator);


		/**
         * 上传货运单
         * @param orderId
         * @param shippingList
         */
	void setShippingList(int orderId,List<ReplenishmentOrderShippingList> shippingList,String operator)throws BussinessException;
	
	/**
	 * 删除货运单
	 * @param orderId
	 * @param replenishmentOrderShippingListId
	 * @param operator
	 */
	void deleteShippingList(int orderId,int replenishmentOrderShippingListId,String operator);
	
	/**
	 * 审核货运单
	 * @param isAuditThrough
	 * @param orderId
	 * @param operator
	 */
	void auditShippingList(boolean isAuditThrough,int orderId,String operator);
	
	/**
	 * 货运单通过审核后，通知其他系统
	 * @param orderId
	 * @param operator
	 */
	void notifyShippingList2OthenSystem(int orderId,String operator);
	
	/**
	 * 修改货运地址
	 * 
	 * @param address
	 * @param operator
	 */
	public void updateOrderAddress(int orderId,int repositoryId,boolean allUpdate, String operator);

	/**
	 * 修改货运方式
	 * 
	 * @param orderId
	 * @param shippingMethod
	 * @param operator
	 */
	public void updateShippingMethod(int orderId, int shippingMethod,boolean allUpdate, String operator);

	/**
	 * 保存发货说明
	 * 
	 * @param orderId
	 * @param remark
	 * @param operator
	 */
	public void saveSendRemark(String fbaShipmentMethod, int orderId, String remark,String cpfCode,int cpfType, String operator);
	
	
	
	ReplenishmentOrderDetail getReplenishmentOrderDetail(int orderId);
	
	/**
	 * 获取货运清单
	 * @param orderId
	 * @return
	 */
	List<ReplenishmentOrderShippingList> getShippingList(int orderId);
	
	
	List<File> getShippingList2BussinessLine(String orderCode);
	
	/**
	 * fba补货列表
	 * @return
	 */
	PageList<ReplenishmentOrder> findReplenishmentOrder(SearchOrderForm form, int currentPage, int pageSize);

	void cancelTicketGroup(int orderId, String operator);
	
	
	/**
	 * 增加同票订单<br>
	 * 通信cms
	 * 
	 * @param orderIds
	 * @param operator
	 * @throws BussinessException
	 */
	public void addTicketGroup(int[] orderIds, String operator);
	
	public void updateOrder(int orderId, String remark, boolean sendTag,int isQualityInspection,
			double subTotalPercent, boolean isUpdateSubTotalPercent,String operator);
	
	void updateOrderProductInfos(List<UpdateOrdertProductInfo> updateOrdertProductInfos,String operator);

	List<ReplenishmentOrderItem> getOrderProduct(int orderId);
	
	ReplenishmentOrderItem getOrderProduct(int orderId,int cmsProductId);

	List<ReplenishmentOrder> getTicketGroup(int orderId);
	

	List<ReplenishmentOrder> getTicketGrouypByGroupId(int groupId);
	
	ReplenishmentOrder getReplenishmentOrderByCode(String code);
	
	/**
	 * 是否sw备货
	 * @param orderId
	 * @return
	 */
	public boolean isAllSwProduct(int orderId) ;

	/**
	 *
	 * 通过4.3.2中创建的FBA补货计划,要submit为已提交，这样才是创建了补货订单
	 *
	 * @param orderId
	 * @return
	 */
	public FbaReplenishmentPlan getFbaReplenishmentPlanByOrderId(Integer orderId);

}
