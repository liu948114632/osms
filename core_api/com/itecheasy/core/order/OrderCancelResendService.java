package com.itecheasy.core.order;
/** 
 * @author wanghw
 * @date 2016-12-1 
 * @description 订单取消重发操作
 * @version 1.2.2
 */
public interface OrderCancelResendService {
	/**
	 * 记录订单操作
	 * @param orderCode
	 * @param type
	 * @param orderApplyType {@link #OrderApplyType}
	 */
	int applyOrderOperating(String orderCode,int orderApplyType);
	
	/**
	 * 同步消息状态
	 * @param orderCode
	 * @param status
	 */
	void updateOrderApplyOperatingFromMessage(String orderCode,int status, int orderApplyType);
	
	/**
	 * 完成订单操作
	 * @param orderCode
	 * @param type
	 */
	@Deprecated
	void complateOrderOperating(String orderCode);
	
	/**
	 * 确认处理
	 * @param orderCode
	 */
	@Deprecated
	void confirmOrderOperating(String orderCode);
	
	@Deprecated
	OrderCancelResendApply getOrderCancelResendApply(String orderCode,OrderApplyType type);
	
	boolean existOrderCancelResendApply(String orderCode);
	
	/**
	 * 取消、重发操作类型
	 * @author wanghw
	 * @Date 2016-12-1 
	 * @Description 1.取消 2.重发, 3.打回,4.上架
	 * @see {@linkplain OrderApplyType}
	 */
	@Deprecated
	public enum OrderCancelResendType{
		取消(1),重发(2),打回(3),上架(4);
		private int val;

		public int getVal() {
			return val;
		}
		
		private OrderCancelResendType(int val) {
			this.val=val;
		}
	}
	
	
	/**
	 * 取消、重发操作类型
	 * @author wanghw
	 * @Date 2016-12-1 
	 * @Description 确认中=1，处理中=2，完成=3
	 */
	public enum OrderCancelResendProcessedStatus{
		确认中(1),处理中(2),完成(3);
		private int val;

		public int getVal() {
			return val;
		}
		
		private OrderCancelResendProcessedStatus(int val) {
			this.val=val;
		}
	}
}
