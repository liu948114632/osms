package com.itecheasy.core.order;

import java.util.Date;

/** 
 * @author whw
 * @date 2017-5-18 
 * @description TODO
 * @version 
 */
public interface SmtOrderService extends OrderService{
	/**
	 * 等待买家付款
	 */
	final static String SMT_ORDER_STATUS_PLACE_ORDER_SUCCESS="PLACE_ORDER_SUCCESS";
	
	/**
	 * 买家申请取消
	 */
	final static String SMT_ORDER_STATUS_IN_CANCEL="IN_CANCEL";
	
	/**
	 * 等待您发货
	 */
	final static String SMT_ORDER_STATUS_WAIT_SELLER_SEND_GOODS="WAIT_SELLER_SEND_GOODS";
	
	/**
	 * 部分发货
	 */
	final static String SMT_ORDER_STATUS_SELLER_PART_SEND_GOODS="SELLER_PART_SEND_GOODS";
	
	/**
	 * 等待买家收货
	 */
	final static String SMT_ORDER_STATUS_WAIT_BUYER_ACCEPT_GOODS="WAIT_BUYER_ACCEPT_GOODS";
	
	/**
	 * 买家确认收货后，等待退放款处理的状态
	 */
	final static String SMT_ORDER_STATUS_FUND_PROCESSING="FUND_PROCESSING";
	
	/**
	 * 已结束的订单
	 */
	final static String SMT_ORDER_STATUS_FINISH="FINISH";
	
	/**
	 * 含纠纷的订单
	 */
	final static String SMT_ORDER_STATUS_IN_ISSUE="IN_ISSUE";
	
	/**
	 * 冻结中的订单
	 */
	final static String SMT_ORDER_STATUS_IN_FROZEN="IN_FROZEN";
	
	/**
	 * 等待您确认金额
	 */
	final static String SMT_ORDER_STATUS_WAIT_SELLER_EXAMINE_MONEY="WAIT_SELLER_EXAMINE_MONEY";
	
	/**
	 * 订单处于风控24小时中，从买家在线支付完成后开始，持续24小时
	 */
	final static String SMT_ORDER_STATUS_RISK_CONTROL="RISK_CONTROL";
	
	
	void listOrder();
	
	void downloadOrder();
	
	void addOrderCommunicationLog(int shopId,String smtOrderCode,String remark,String smtStatus,Date timeoutLeftTime);
	
	/**
	 * 提供测试
	 * @param shopId
	 * @param json
	 */
	void downloadOrderTest(int shopId,String json,int leftDays);
}
