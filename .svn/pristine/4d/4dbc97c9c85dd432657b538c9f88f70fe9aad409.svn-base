package com.itecheasy.osms.order;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.FbaRelatedCMSProduct;
import com.itecheasy.core.fba.MonthlyPeakOrLowRule;
import com.itecheasy.core.fba.ReplenishmentTask;
import com.itecheasy.core.fba.ReplenishmentTaskProduct;
import com.itecheasy.core.fba.ReplenishmentTaskProductSearch;
import com.itecheasy.core.fba.SearchFbaRelatedCMSProduct;
import com.itecheasy.core.fba.SearchReplenishmentTask;
import com.itecheasy.core.fba.ReplenishmentTaskService.MonthlyPeakOrLow;

/** 
 * @author wanghw
 * @date 2016-12-2 
 * @description TODO
 * @version 1.2.2
 */
@WebService
public interface ReplenishmentTaskWebService {
	/**
	 * 生成cms补货单
	 * @param cmsProductCodes
	 * @param operator
	 */
	int createReplenishmentTask(@WebParam(name="cmsProductCodes")List<String> cmsProductCodes,@WebParam(name="operator")int operator);

	/**
	 * 设置已下单
	 * @param replenishmentTaskId
	 * @param operator
	 */
	void orderedReplenishmentTask(@WebParam(name="replenishmentTaskIds")int[] replenishmentTaskIds,@WebParam(name="operator")int operator);
	
	/**
	 * 完成补货单
	 * @param replenishmentTaskId
	 * @param operator
	 */
	void complatedReplenishmentTask(@WebParam(name="replenishmentTaskIds")int replenishmentTaskId[],@WebParam(name="operator")int operator);
	
	/**
	 * 完成补货单商品
	 * @param replenishmentTaskProductId
	 * @param operator
	 */
	void complatedReplenishmentTaskProduct(@WebParam(name="replenishmentTaskProductIds")int[] replenishmentTaskProductIds,@WebParam(name="operator")int operator);
	
	/**
	 * 删除补货单 商品
	 * @param replenishmentTaskProductId
	 * @param operator
	 */
	void deleteReplenishmentTaskProduct(@WebParam(name="replenishmentTaskProductId")int replenishmentTaskProductId,@WebParam(name="operator")int operator);
	
	public void deleteReplenishmentTask(@WebParam(name="replenishmentTaskId")int replenishmentTaskId, 
			@WebParam(name="operator")int operator);
	
	/**
	 * cms补货产品列表
	 * @return
	 */
	PageList<FbaRelatedCMSProduct> findCMSReplenishmentProducts(@WebParam(name="search")SearchFbaRelatedCMSProduct search);

	//根据id查询是否有c3补货订单这个订单对象
	ReplenishmentTask getReplenishmentTask(@WebParam(name="replenishmentTaskId")int replenishmentTaskId);
	
	List<ReplenishmentTaskProduct> getReplenishmentTaskDetail(@WebParam(name="replenishmentTaskId")int replenishmentTaskId
			,@WebParam(name="productCode")String productCode,
			@WebParam(name="productCodes")List<String> productCodes);
	
	PageList<ReplenishmentTask> findReplenishmentTasks(@WebParam(name="search")SearchReplenishmentTask search);
	
	public void saveReplenishmentProducts(ReplenishmentTask task,List<ReplenishmentTaskProduct> products, int operator);
	
	/**
	 * 获取月份的淡旺季
	 * @return
	 */
	List<MonthlyPeakOrLow> getMonthlyPeakOrLow();
	
	/**
	 * 设置淡旺季规则值
	 * @param rules
	 */
	void setMonthlyPeakOrLowRules(@WebParam(name="rules")List<MonthlyPeakOrLowRule> rules,
			@WebParam(name="PeakOrLow")List<MonthlyPeakOrLow> PeakOrLow) throws BussinessException;
	
	List<MonthlyPeakOrLowRule> getMonthlyPeakOrLowRules();
	
	/**
	 * 增加补货任务
	 * <code>状态：未申请</code>
	 * @param taskProducts
	 * @param operator
	 * @version 1.2.8
	 */
	List<ReplenishmentTaskProduct> appendReplenishmentTasks(@WebParam(name="replenishmentTaskId")int replenishmentTaskId,
			@WebParam(name="taskProducts")List<ReplenishmentTaskProduct> taskProducts,
			@WebParam(name="operator")int operator);
	
	/**
	 * 生成补货任务
	 * <code>状态：未申请</code>
	 * @param taskProducts
	 * @param operator
	 * @version 1.2.8
	 */
	int createReplenishmentTasks(@WebParam(name="taskProducts")List<ReplenishmentTaskProduct> taskProducts,
			@WebParam(name="operator")int operator);

	/**
	 * 生成补货任务
	 * 用于从fba补货中全部产品为sw备货，但是想要走c3时出现的一个按钮，
	 * 这样创建出来的c3补货订单的商品后面多出了一个备注为fba补货订单的订单号
	 *
	 * <code>状态：未申请</code>   ？？？
	 * @param taskProducts
	 * @param operator   操作员
	 * @param remark	备注   fba补货订单的订单号
	 * @version 1.2.8
	 */
	int createReplenishmentTasksFromFba(@WebParam(name="taskProducts")List<ReplenishmentTaskProduct> taskProducts,
								 @WebParam(name="operator")int operator,@WebParam(name = "remark") String remark);



	/**
	 * 提交审核
	 * <code>状态：申请中</code>
	 * @param taskIds
	 * @param operator
	 * @version 1.2.8
	 */
	void submit(@WebParam(name="taskIds")List<Integer> taskIds,
			@WebParam(name="operator")int operator);
	
	/**
	 * 审核通过
	 * <code>状态：备货中</code>
	 * <br>通讯cms
	 * @param taskIds
	 * @param operator
	 * @version 1.2.8
	 */
	void pass(@WebParam(name="taskIds")List<Integer> taskIds,
			@WebParam(name="operator")int operator);
	
	/**
	 * 审核不通过
	 * <code>状态：审核不通过</code>
	 * @param taskIds
	 * @param operator
	 * @version 1.2.8
	 */
	void reject(@WebParam(name="taskIds")List<Integer> taskIds,
			@WebParam(name="operator")int operator);
	
	/**
	 * 超批审核
	 * <br>超批采购审核状态为待审核、等待的产品
	 * @param taskProductIds
	 * @param remark 审核备注
	 * @param handle 1、通过 2、取消  3、等待
	 * @param operator
	 * @version 1.2.8
	 */
	void auditMoreBatch(@WebParam(name="taskProductIds")List<Integer> taskProductIds,
			@WebParam(name="remark")String remark,
			@WebParam(name="handle")Integer handle,
			@WebParam(name="operator")int operator);
	
	PageList<ReplenishmentTaskProduct> findReplenishmentTaskProduct(
			@WebParam(name="search")ReplenishmentTaskProductSearch search);
	
	void updateReplenishmentTaskProduct(@WebParam(name="taskProducts")List<ReplenishmentTaskProduct> taskProducts);
	
	public List<ReplenishmentTaskProduct> getMoreBatchPassTaskProduct(@WebParam(name="cmsProductId")int cmsProductId);
	
	public int getOrderPurchaseWaitMoreBatchAudit(@WebParam(name="tableType")int tableType);
}
