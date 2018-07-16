package com.itecheasy.osms.prepare;

import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.prepare.PreparePlanSearchVO;
import com.itecheasy.core.prepare.SeaTransportationPlanDetailVO;
import com.itecheasy.core.prepare.SeaTransportationPlanOperateLogVO;
import com.itecheasy.core.prepare.SeaTransportationPlanVO;
import com.itecheasy.core.prepare.SeaTransportationPrepareService;

/**
 * @author taozihao
 * @date 2018年6月30日 下午3:54:37
 * @description
 */
public class SeaTransportationPrepareWebServiceImpl implements SeaTransportationPrepareWebService {
	
	public SeaTransportationPrepareService seaTransportationPrepareService;

	public void setSeaTransportationPrepareService(SeaTransportationPrepareService seaTransportationPrepareService) {
		this.seaTransportationPrepareService = seaTransportationPrepareService;
	}

	@Override
	public PageList<SeaTransportationPlanVO> getSeaTransportationPlanList(PreparePlanSearchVO planSearchVO,
			int operatorId) {
		
		return seaTransportationPrepareService.getSeaTransportationPlanList(planSearchVO, operatorId);
	}

	@Override
	public SeaTransportationPlanDetailVO saveAndGetRecommendProductList(SeaTransportationPlanVO seaTransportationPlanVO,
			int operatorId)  throws BussinessException{
		return seaTransportationPrepareService.saveAndGetRecommendProductList(seaTransportationPlanVO, operatorId);
	}

	@Override
	public void addSeaTransportationPlan(SeaTransportationPlanDetailVO seaTransportationPlanDetail,
			int operatorId) {
		seaTransportationPrepareService.addSeaTransportationPlan(seaTransportationPlanDetail, operatorId);
	}

	@Override
	public void updateSeaTransportationPlan(SeaTransportationPlanVO seaTransportationPlanVO, int operatorId) {
		seaTransportationPrepareService.updateSeaTransportationPlan(seaTransportationPlanVO, operatorId);
	}

	@Override
	public void addProduct(List<String> skus, int planId, int operatorId) {
		seaTransportationPrepareService.addProduct(skus, planId, operatorId);
	}

	@Override
	public SeaTransportationPlanDetailVO getSeaTransportationPlanDetailByPlanId(int planId) {
		return seaTransportationPrepareService.getSeaTransportationPlanDetailByPlanId(planId);
	}

	@Override
	public void cancelProducts(int planId, List<String> skus, int operatorId) throws BussinessException {
		seaTransportationPrepareService.cancelProducts(planId, skus, operatorId);
	}

	@Override
	public void updateProductActualQuantity(int planId, String sku, int actualQuantity, int operatorId) {
		seaTransportationPrepareService.updateProductActualQuantity(planId, sku, actualQuantity, operatorId);
	}

	@Override
	public void updateCheckStatus(int planId, int operatorId, int status) {
		seaTransportationPrepareService.updateCheckStatus(planId, operatorId, status);
	}

	@Override
	public List<SeaTransportationPlanOperateLogVO> getSeaTransportationPlanOperateLogs(int planId) {
		return seaTransportationPrepareService.getSeaTransportationPlanOperateLogs(planId);
	}

	@Override
	public void addSeaTransToInboundPlanLog(int seaTransPlanId, int inboundPlanId, int operatorId) {
		seaTransportationPrepareService.addSeaTransToInboundPlanLog(seaTransPlanId, inboundPlanId, operatorId);
	}

}
