package com.itecheasy.osms.order;

import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.core.fba.*;
import com.itecheasy.core.fba.FbaInboundService.FbaInboundPlanSubmitStatus;
import com.itecheasy.core.fba.dao.FbaReplenishmentPlanDao;
import com.itecheasy.core.fba.dao.ReplenishmentOrderDao;
import com.itecheasy.core.order.dao.OrderTrackingDao;
import com.itecheasy.core.po.FbaReplenishmentPlanPO;
import com.itecheasy.core.po.ReplenishmentOrderPO;


/**
 * @author taozihao
 * @date 2018年6月7日 下午5:46:26
 * @description
 */
public class FbaInboundWebServiceImpl implements FbaInboundWebService {

	private FbaInboundService fbaInboundService;

	public void setFbaInboundService(FbaInboundService fbaInboundService) {
		this.fbaInboundService = fbaInboundService;
	}

	@Override
	public String checkExcel(int shopId ,List<String> skus) {
		return fbaInboundService.checkExcel(shopId,skus);
	}

	@Override
	public List<FbaInboundPlanItemExcelResult> showExcelProductResult(int shopId,List<InboundPlanProductItem> items) {
		return fbaInboundService.showExcelProductResult(shopId,items);
	}

	@Override
	public int createFbaInboundPlan(int shopId, String planName, String shipToCountryCode, String shippingMethod,
									List<InboundPlanProductItem> items,int isSubmitToAm, int operatorId) {
		return fbaInboundService.createFbaInboundPlan(shopId, planName, shipToCountryCode, shippingMethod, items,isSubmitToAm,operatorId);
	}

	@Override
	public PageList<FbaInboundPlanVO> getFbaInboundPlanList(int shopId, int page, int pageSize, String sku,
															String productCode,int operatorId) {
		return fbaInboundService.getFbaInboundPlanList(shopId, page, pageSize, sku, productCode,operatorId);
	}

	@Override
	public void updateFbaInboundPlan(int planId, String planName, String shipToCountryCode, String shippingMethod,
									 List<InboundPlanProductItem> items, int operatorId) {
		fbaInboundService.updateFbaInboundPlan(planId, planName, shipToCountryCode, shippingMethod, items,operatorId);
	}

	@Override
	public void cancelFbaInboundPlan(int planId, int operatorId) {
		fbaInboundService.cancelFbaInboundPlan(planId,operatorId);
	}

	@Override
	public List<FbaPreInboundOrderVO> submitFbaInboundPlan(int planId, int shopId, int operatorId) {
		return fbaInboundService.submitFbaInboundPlan(planId, shopId, operatorId);
	}

	@Override
	public void createFbaInboundOrder(List<ShipmenIdAndNameVO> shipmenIdAndNameVO, int shopId, int planId, int operatorId) {
		fbaInboundService.createFbaInboundOrder(shipmenIdAndNameVO,shopId,planId, operatorId);
	}

	@Override
	public FbaInboundPlanSearchVO findFbaInboundPlanByPlanId(int planId) {
		return fbaInboundService.findFbaInboundPlanByPlanId(planId);
	}

	@Override
	public void deleteFbaInboundPlan(int planId, int operatorId) {
		fbaInboundService.deleteFbaInboundPlan(planId,operatorId);
	}

	@Override
	public List<FbaInboundPlanOperateLog> getOperateLogsByPlanId(int planId) {
		return fbaInboundService.getOperateLogsByPlanId(planId);
	}


	@Override
	public void updateFbaInboundOrder(String shipmentId, int shopId, List<FbaPreInboundItemVO> items, int operatorId) {
		fbaInboundService.updateFbaInboundOrder(shipmentId,shopId,items,operatorId);
	}


	@Override
    public String putTransportContent(PutTransportContentVO putTransportContentVO) {
		return fbaInboundService.putTransportContent(putTransportContentVO);
	}
}
