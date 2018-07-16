package com.itecheasy.core.order;

import java.util.List;

import com.itecheasy.core.BussinessException;


/** 
 * @author wanghw
 * @date 2016-7-26 
 * @description ebay订单服务
 * @version 1.2.0
 */
public interface EbayOrderService extends OrderService{
	/**
	 * 导入订单
	 * @param datas
	 * @param shopId
	 * @param operator
	 * @return
	 */
	String importEbayOrder(List<EbayOrderData> datas, int shopId, int operator)throws BussinessException;
	
	
	public void syncOrders();
	
	public void downloadSimpleOrder(String shopOrderItemLineId,int shopId)throws Exception;
	
	public void cancelOrderTest(String shopOrderCode)throws BussinessException;

	void updateOrderStatusTest(String shopOrderCode) throws BussinessException;

}
