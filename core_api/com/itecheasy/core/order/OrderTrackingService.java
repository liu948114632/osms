package com.itecheasy.core.order;

import java.util.List;
import java.util.Map;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;

/** 
 * @author whw
 * @date 2017-8-17 
 * @description TODO
 * @version 
 */
public interface OrderTrackingService {
	
	
	/**
	 * 增加订单跟踪
	 * @param orderTracking
	 */
	public void setOrderTracking(OrderTracking orderTracking, int operator)throws BussinessException;
	
	/**
	 * 只有C3创建的订单跟踪才可以操作， 回复订单跟踪或者修改备注
	 * @param tacking
	 * @param isSave
	 * @param operatorId
	 */
	public void updateOrderTracking(OrderTracking tacking, boolean isSave, int operatorId);
	
	/**
	 * 删除订单跟踪
	 * @param orderTrackingId
	 * @param operator
	 */
	public void deleteOrderTracking(int[] orderTrackingIds,int operator)throws BussinessException;
	
	
	/**
	 * 完成订单跟踪
	 * @param orderTrackingId
	 * @param operator
	 */
	public void completeOrderTracking(int[] orderTrackingIds,int operator)throws BussinessException;
	
	
	/**
	 * 更新订单跟踪咨询人
	 * @param orderTrackingId
	 * @param Author
	 * @param operator
	 * @throws BussinessException
	 */
	public void updateOrderTrackingConsultationUser(int[] orderTrackingIds,int orderTrackingConsultationUser,int operator)throws BussinessException;

	/**
	 * 获取所有咨询人，CAMS操作用户+C3过来的咨询人
	 * @return
	 */
	public List<Integer> getOrderTrackingConsultationUsers();
	
	/**
	 * 标读当前用户是否已读
	 * @param orderTrackingId
	 * @param operator
	 * @throws BussinessException
	 */
	public void updateOrderTrackingReaded(int orderTrackingId, int operatorId) throws BussinessException;
	
	/**
	 * 分页查询订单跟踪
	 * @param form
	 * @return
	 */
	public PageList<OrderTracking> findOrderTracking(SearchOrderTrackingForm form);


	/**
	 * 阅读订单跟踪信息   todo
	 * @param packageProblemId
	 */
	public OrderTracking readOrderTracking(int orderTrackingId);


	/**
	 * 根据订单跟踪号获取订单跟踪信息
	 * @param code
	 * @return
	 */
	public OrderTracking getOrderTrackingByCode(String code);

	/**
	 * 根据全部有改产品id的订单跟踪信息	商品编号cmsProductCode
	 * @param productCode   产品id
	 * @return
	 */
	public List<OrderTracking> getOrderTrackingByProductId(String productCode);


	/**
	 * 获取订单跟踪信息
	 * @param orderTrackingId
	 * @return
	 */
	public OrderTracking getOrderTracking(int orderTrackingId);
	
	public OrderTracking getOrderTrackingDetail(int orderTrackingId);
	
	/**
	 * 订单跟踪回复
	 * @return
	 */
	public List<OrderTrackingItem> getOrderTrackingItems(int orderTrackingId);
	
	/**
	 * 订单跟踪详细
	 * @param orderTrackingId
	 * @return
	 */
	List<OrderTrackingProduct> getOrderTrackingProducts(int orderTrackingId);
	
	/**
	 * 订单附件
	 * @param orderTrackingProductId
	 * @return
	 */
	public List<OrderTrackingProductAttachment> getOrderTrackingAttachments(int orderTrackingProductId);
	
	public List<OrderTrackingLog> getOrderTrackingLogs(int orderTrackingId);
}
