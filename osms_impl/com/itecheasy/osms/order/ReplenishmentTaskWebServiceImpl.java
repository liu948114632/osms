package com.itecheasy.osms.order;

import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.FbaRelatedCMSProduct;
import com.itecheasy.core.fba.MonthlyPeakOrLowRule;
import com.itecheasy.core.fba.ReplenishmentTask;
import com.itecheasy.core.fba.ReplenishmentTaskProduct;
import com.itecheasy.core.fba.ReplenishmentTaskProductSearch;
import com.itecheasy.core.fba.ReplenishmentTaskService;
import com.itecheasy.core.fba.ReplenishmentTaskService.MonthlyPeakOrLow;
import com.itecheasy.core.fba.SearchFbaRelatedCMSProduct;
import com.itecheasy.core.fba.SearchReplenishmentTask;

/**
 * @author wanghw
 * @date 2016-12-2
 * @description TODO
 * @version 1.2.2
 */
public class ReplenishmentTaskWebServiceImpl implements ReplenishmentTaskWebService {
	private ReplenishmentTaskService replenishmentTaskService;

	public void setReplenishmentTaskService(ReplenishmentTaskService replenishmentTaskService) {
		this.replenishmentTaskService = replenishmentTaskService;
	}

	@Override
	public int createReplenishmentTask(List<String> cmsProductCodes, int operator) {
		return replenishmentTaskService.createReplenishmentTask(cmsProductCodes, operator);
	}
	
	@Override
	public void orderedReplenishmentTask(int[] replenishmentTaskIds, int operator) {
		for (int replenishmentTaskId : replenishmentTaskIds) {
			replenishmentTaskService.orderedReplenishmentTask(replenishmentTaskId, operator);
		}
	}

	@Override
	public void complatedReplenishmentTask(int[] replenishmentTaskIds, int operator) {
		for (int replenishmentTaskId : replenishmentTaskIds) {
			replenishmentTaskService.complatedReplenishmentTask(replenishmentTaskId, operator);
		}
	}

	@Override
	public void complatedReplenishmentTaskProduct(int[] replenishmentTaskProductIds, int operator) {
		for (int replenishmentTaskProductId : replenishmentTaskProductIds) {
			replenishmentTaskService.complatedReplenishmentTaskProduct(replenishmentTaskProductId, operator);
		}
	}

	@Override
	public void deleteReplenishmentTaskProduct(int replenishmentTaskProductId, int operator) {
		replenishmentTaskService.deleteReplenishmentTaskProduct(replenishmentTaskProductId, operator);
	}

	@Override
	public void deleteReplenishmentTask(int replenishmentTaskId, int operator) {
		replenishmentTaskService.deleteReplenishmentTask(replenishmentTaskId, operator);
	}

	@Override
	public PageList<FbaRelatedCMSProduct> findCMSReplenishmentProducts(SearchFbaRelatedCMSProduct search) {
		return replenishmentTaskService.findCMSReplenishmentProducts(search);
	}

	@Override
	public ReplenishmentTask getReplenishmentTask(int replenishmentTaskId) {
		return replenishmentTaskService.getReplenishmentTask(replenishmentTaskId);
	}

	
	
	@Override
	public List<ReplenishmentTaskProduct> getReplenishmentTaskDetail(int replenishmentTaskId, String productCode,
			List<String> productCodes) {
		List<ReplenishmentTaskProduct> products= replenishmentTaskService.getReplenishmentTaskDetail(replenishmentTaskId, productCode,
				productCodes);
		if(CollectionUtils.isNotEmpty(products)){
//			ReplenishmentTask task=replenishmentTaskService.getReplenishmentTask(replenishmentTaskId);
//			List<OsmsPurchasingManageTask> ps = CMSClient.getFBAPurchasingManagementTaskByCode(task.getCode());
//			if (CollectionUtils.isEmpty(ps)){
//				List<Integer> ids=new ArrayList<Integer>();
//				for (ReplenishmentTaskProduct p : products) {
//					ids.add(p.getCmsProductId());
//				}
//				Map<Integer, Integer> map=CMSClient.getNotCompleteTasksByProductIDs(ids);
//				if(map!=null){
//					for (ReplenishmentTaskProduct p : products) {
//						p.setShowReddish(map.get(p.getCmsProductId()).intValue()>p.getReplenishmentNum()*p.getUnitQty());
//					}
//				}
//			}
		}
		return products;
	}

	@Override
	public PageList<ReplenishmentTask> findReplenishmentTasks(SearchReplenishmentTask search) {
		return replenishmentTaskService.findReplenishmentTasks(search);
	}

	@Override
	public void saveReplenishmentProducts(ReplenishmentTask task,List<ReplenishmentTaskProduct> products, int operator) {
		replenishmentTaskService.saveReplenishmentProducts(task, products, operator);
	}

	@Override
	public List<MonthlyPeakOrLow> getMonthlyPeakOrLow() {
		return replenishmentTaskService.getMonthlyPeakOrLow();
	}

	
	@Override
	public void setMonthlyPeakOrLowRules(List<MonthlyPeakOrLowRule> rules,List<MonthlyPeakOrLow> PeakOrLow)throws BussinessException {
		if(PeakOrLow==null||PeakOrLow.size()!=12)
			throw new BussinessException("请设置十二个月");
		
		replenishmentTaskService.setMonthlyPeakOrLow(PeakOrLow);
		replenishmentTaskService.setMonthlyPeakOrLowRules(rules);
		
		//统计
	}

	@Override
	public List<MonthlyPeakOrLowRule> getMonthlyPeakOrLowRules() {
		return replenishmentTaskService.getMonthlyPeakOrLowRules();
	}
	
	@Override
	public List<ReplenishmentTaskProduct> appendReplenishmentTasks(int replenishmentTaskId, List<ReplenishmentTaskProduct> taskProducts,
			int operator) {
		return replenishmentTaskService.appendReplenishmentTasks(replenishmentTaskId, taskProducts, operator);
	}
	
	@Override
	public void auditMoreBatch(List<Integer> taskProductIds, String remark, Integer handle, int operator) {
		replenishmentTaskService.auditMoreBatch(taskProductIds, remark, handle, operator);
	}

	@Override
	public int createReplenishmentTasksFromFba(List<ReplenishmentTaskProduct> taskProducts, int operator, String remark) {
		return replenishmentTaskService.createReplenishmentTasksFromFba(taskProducts,operator,remark);
	}

	@Override
	public int createReplenishmentTasks(List<ReplenishmentTaskProduct> taskProducts, int operator) {
		return replenishmentTaskService.createReplenishmentTasks(taskProducts, operator);
	}
	@Override
	public PageList<ReplenishmentTaskProduct> findReplenishmentTaskProduct(ReplenishmentTaskProductSearch search) {
		return replenishmentTaskService.findReplenishmentTaskProduct(search);
	}
	@Override
	public void pass(List<Integer> taskIds, int operator) {
		replenishmentTaskService.pass(taskIds, operator);
	}
	@Override
	public void reject(List<Integer> taskIds, int operator) {
		replenishmentTaskService.reject(taskIds, operator);
	}
	@Override
	public void submit(List<Integer> taskIds, int operator) {
		replenishmentTaskService.submit(taskIds, operator);
	}
	
	@Override
	public void updateReplenishmentTaskProduct(List<ReplenishmentTaskProduct> taskProducts) {
		replenishmentTaskService.updateReplenishmentTaskProduct(taskProducts);
	}
	
	@Override
	public List<ReplenishmentTaskProduct> getMoreBatchPassTaskProduct(int cmsProductId) {
		return replenishmentTaskService.getMoreBatchPassTaskProduct(cmsProductId);
	}
	
	@Override
	public int getOrderPurchaseWaitMoreBatchAudit(int tableType) {
		return replenishmentTaskService.getOrderPurchaseWaitMoreBatchAudit(tableType);
	}
}
