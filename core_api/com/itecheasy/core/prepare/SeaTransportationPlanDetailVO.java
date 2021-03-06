package com.itecheasy.core.prepare;

import java.util.List;

/**
 * @author taozihao
 * @date 2018年6月30日 下午2:43:45
 * @description 海运备货计划详情
 */
public class SeaTransportationPlanDetailVO {
	private SeaTransportationPlanVO seaTransportationPlanVO;
	private List<PreparePlanProductVO> preparePlanProductList;

	public SeaTransportationPlanVO getSeaTransportationPlanVO() {
		return seaTransportationPlanVO;
	}

	public void setSeaTransportationPlanVO(SeaTransportationPlanVO seaTransportationPlanVO) {
		this.seaTransportationPlanVO = seaTransportationPlanVO;
	}

	public List<PreparePlanProductVO> getPreparePlanProductList() {
		return preparePlanProductList;
	}

	public void setPreparePlanProductList(List<PreparePlanProductVO> preparePlanProductList) {
		this.preparePlanProductList = preparePlanProductList;
	}

}
