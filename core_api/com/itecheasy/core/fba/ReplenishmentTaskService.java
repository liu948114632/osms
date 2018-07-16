package com.itecheasy.core.fba;

import java.util.List;

import com.itecheasy.common.PageList;

/** 
 * @author wanghw
 * @date 2016-11-30 
 * @description cms补货任务
 * @version 1.2.2
 */
public interface ReplenishmentTaskService {
	static final String EX_STATUS="状态不对，无法操作！";
	
	/**
	 * 补货商品生成cms补货单
	 * @param cmsProductCodes
	 * @param operator
	 */
	int createReplenishmentTask(List<String> cmsProductCodes,int operator);

	/**
	 * 设置已下单
	 * @param replenishmentTaskId
	 * @param operator
	 */
	@Deprecated
	void orderedReplenishmentTask(int replenishmentTaskId,int operator);
	
	/**
	 * 更新补货单商品
	 * @param products
	 * @param operator
	 */
	void saveReplenishmentProducts(ReplenishmentTask task,List<ReplenishmentTaskProduct> products,int operator);
	
	/**
	 * 完成补货单
	 * @param replenishmentTaskId
	 * @param operator
	 */
	@Deprecated
	void complatedReplenishmentTask(int replenishmentTaskId,int operator);
	
	/**
	 * 完成补货单商品
	 * @param replenishmentTaskProductId
	 * @param operator
	 */
	void complatedReplenishmentTaskProduct(int replenishmentTaskProductId,int operator);
	
	/**
	 * 删除补货任务
	 */
	public void deleteReplenishmentTask(int replenishmentTaskId,int operator);
	
	/**
	 * 删除补货单 商品
	 * @param replenishmentTaskProductId
	 * @param operator
	 */
	void deleteReplenishmentTaskProduct(int replenishmentTaskProductId,int operator);
	
	/**
	 * 从cms同步补货单的相关信息（cms采管任务）
	 */
	@Deprecated
	int syncReplenishmentTask(int pageSize, int currentPage);
	
	/**
	 * cms补货产品列表
	 * @return
	 */
	PageList<FbaRelatedCMSProduct> findCMSReplenishmentProducts(SearchFbaRelatedCMSProduct search);



	//根据id查询是否有c3补货订单这个订单对象
	ReplenishmentTask getReplenishmentTask(int replenishmentTaskId);



	List<ReplenishmentTaskProduct> getReplenishmentTaskDetail(int replenishmentTaskId);
	
	public List<ReplenishmentTaskProduct> getReplenishmentTaskDetail(int replenishmentTaskId,String productCode,
			List<String> productCodes) ;
	
	PageList<ReplenishmentTask> findReplenishmentTasks(SearchReplenishmentTask search);

	ReplenishmentTaskProduct getReplenishmentTaskProduct(int replenishmentTaskId, int cmsProductId);
	
	
	/**
	 * 获取月份的淡旺季
	 * @return
	 */
	List<MonthlyPeakOrLow> getMonthlyPeakOrLow();
	
	/**
	 * 设置淡旺季
	 * @param PeakOrLow
	 */
	void setMonthlyPeakOrLow(List<MonthlyPeakOrLow> PeakOrLow);
	
	/**
	 * 设置淡旺季规则值
	 * @param rules
	 */
	void setMonthlyPeakOrLowRules(List<MonthlyPeakOrLowRule> rules);
	
	List<MonthlyPeakOrLowRule> getMonthlyPeakOrLowRules();
	
	
	/**
	 * 月份淡旺季
	 * @author wanghw
	 * @Date 2017-8-16 
	 * @Description 
	 */
	public enum MonthlyPeakOrLow{
		/**
		 * 淡季
		 */
		LOW,
		/**
		 * 旺季
		 */
		PEAK
	}
	
	/*************v1.2.8 重做补货任务********************/
	
	/**
	 * 增加补货任务
	 * <code>状态：未申请</code>
	 * @param taskProducts
	 * @param operator
	 * @version 1.2.8
	 */
	List<ReplenishmentTaskProduct> appendReplenishmentTasks(int replenishmentTaskId,List<ReplenishmentTaskProduct> taskProducts,int operator);
	
	/**
	 * 生成补货任务
	 * <code>状态：未申请</code>
	 * @param taskProducts
	 * @param operator
	 * @version 1.2.8
	 */
	int createReplenishmentTasks(List<ReplenishmentTaskProduct> taskProducts,int operator);

	/**
	 * 生成补货任务
	 * <code>状态：未申请</code>
	 * @param taskProducts
	 * @param operator
	 * @param remark   fba补货单号
	 * @version 1.2.8
	 */
	int createReplenishmentTasksFromFba(List<ReplenishmentTaskProduct> taskProducts,int operator,String remark);




	/**
	 * 提交审核
	 * <code>状态：申请中</code>
	 * @param taskIds
	 * @param operator
	 * @version 1.2.8
	 */
	void submit(List<Integer> taskIds,int operator);
	
	/**
	 * 审核通过
	 * <code>状态：备货中</code>
	 * <br>通讯cms
	 * @param taskIds
	 * @param operator
	 * @version 1.2.8
	 */
	void pass(List<Integer> taskIds,int operator);


	void pass(List<Integer> taskIds,int operator,String remark);

	/**
	 * 审核不通过
	 * <code>状态：审核不通过</code>
	 * @param taskIds
	 * @param operator
	 * @version 1.2.8
	 */
	void reject(List<Integer> taskIds,int operator);
	
	/**
	 * 超批审核
	 * <br>超批采购审核状态为待审核、等待的产品
	 * @param taskProductIds
	 * @param remark 审核备注
	 * @param handle 1、通过 2、取消  3、等待
	 * @param operator
	 * @version 1.2.8
	 */
	void auditMoreBatch(List<Integer> taskProductIds,String remark,Integer handle,int operator);
	
	/**
	 * 超批采购审核状态为等待的产品，当订单项备货后，取消任务
	 * @param taskProductId
	 * @version 1.2.8
	 */
	void cancelMoreBatchWaitTaskProduct(int taskProductId);
	
	/**
	 * 补货商品查询
	 * @param search
	 * @return
	 * @version 1.2.8
	 */
	PageList<ReplenishmentTaskProduct> findReplenishmentTaskProduct(ReplenishmentTaskProductSearch search);
	
	/**
	 * 同步消息
	 */
	public void readMessage();
	
	public void updateReplenishmentTaskProduct(List<ReplenishmentTaskProduct> taskProducts);
	
	/**
	 * 自卖备货，自卖采购类型的已经超批的任务,(等待和确认)
	 * @param cmsProductId
	 * @return
	 */
	public List<ReplenishmentTaskProduct> getMoreBatchPassTaskProduct(int cmsProductId);
	
	/**
	 * 自卖订单超批待审核
	 * @param tableType 1、fba补货单列表  2、自卖补货列表
	 * @return
	 */
	public int getOrderPurchaseWaitMoreBatchAudit(int tableType);
}
