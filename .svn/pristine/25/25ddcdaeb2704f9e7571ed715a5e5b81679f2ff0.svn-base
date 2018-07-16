package com.itecheasy.core.order;

import java.util.Date;
import java.util.List;

import com.itecheasy.core.BussinessException;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.webservice.amazon.OrderAmazon;

/** 
 * @author wanghw
 * @date 2015-5-9 
 * @description amazon订单服务
 * @version
 */
public interface AmazonOrderService extends OrderService{
	static final String AMAZON_STATUS_PARTIALLY_SHIPPED = "PartiallyShipped";

	static final String AMAZON_STATUS_UNSHIPPED = "Unshipped";

	static final String AMAZON_STATUS_SHIPPED = "Shipped";

	static final String AMAZON_STATUS_CANCELED = "Canceled";
	
	
	public Date listOrders(int devId,Date lastUpdatedAfter,Date lastUpdatedBefore)throws Exception;
	
	/**
	 * 读订单下载日志新增订单
	 */
	public void addOrderByLog();
	
	/**
	 * 增加单个amazon订单
	 * @param shopId
	 * @param info
	 * @param order
	 */
	public void addOrderSimple(int shopId, ShopInfo info, com.itecheasy.webservice.amazon.OrderAmazon order);
	/**
	 *调用该方法，增加日志
	 * @param shopId
	 * @param amazonOrderCode
	 */
	public void addOrderCommunicationLog(int shopId,String amazonOrderCode,String remark,boolean delay);
	
	
	void autoCheckOrders();
	
	/*************提供web测试******************/
	
	public void addOrderAmazon(List<OrderAmazon> amazon,String shopId);

	public void cancelOrderTest(String shopOrderCode,int shopId)throws BussinessException;

	void updateOrderStatusTest(String shopOrderCode) throws BussinessException;
}
