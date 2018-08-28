package com.itecheasy.osms.operation;

import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.core.operation.ClearInventoryTrackingForm;
import com.itecheasy.core.operation.ClearInventoryTrackingOperateLogVO;
import com.itecheasy.core.operation.ClearInventoryTrackingService;
import com.itecheasy.core.operation.ClearInventoryTrackingVO;
import com.itecheasy.core.operation.PriceOffPercentVO;

/**
 * @author taozihao
 * @date 2018年8月24日 下午7:10:07
 * @description	清仓跟踪
 */
public class ClearInventoryTrackingWebServiceImpl implements ClearInventoryTrackingWebService{

	private ClearInventoryTrackingService clearInventoryTrackingService;
	
	public void setClearInventoryTrackingService(ClearInventoryTrackingService clearInventoryTrackingService) {
		this.clearInventoryTrackingService = clearInventoryTrackingService;
	}

	@Override
	public PageList<ClearInventoryTrackingVO> getClearInventoryTrackingPageList(ClearInventoryTrackingForm queryForm) {
		return clearInventoryTrackingService.getClearInventoryTrackingPageList(queryForm);
	}

	@Override
	public void batchPriceOff(int shopId, List<PriceOffPercentVO> priceOffPercentVOList,int operatorId) {
		clearInventoryTrackingService.batchPriceOff(shopId, priceOffPercentVOList,operatorId);
	}

	@Override
	public List<ClearInventoryTrackingOperateLogVO> getOperateLogsByClearInventoryTrackingId(
			int clearInventoryTrackingId) {
		return clearInventoryTrackingService.getOperateLogsByClearInventoryTrackingId(clearInventoryTrackingId);
	}

}