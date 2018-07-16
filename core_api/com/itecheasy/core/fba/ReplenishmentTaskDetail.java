package com.itecheasy.core.fba;

import java.util.List;

/**
 * @author wanghw
 * @date 2016-11-30
 * @description TODO
 * @version 1.2.2
 */
public class ReplenishmentTaskDetail {
	private ReplenishmentTask replenishmentTask;
	private List<ReplenishmentTaskProduct> replenishmentTaskProducts;

	public ReplenishmentTask getReplenishmentTask() {
		return replenishmentTask;
	}

	public void setReplenishmentTask(ReplenishmentTask replenishmentTask) {
		this.replenishmentTask = replenishmentTask;
	}

	public List<ReplenishmentTaskProduct> getReplenishmentTaskProducts() {
		return replenishmentTaskProducts;
	}

	public void setReplenishmentTaskProducts(List<ReplenishmentTaskProduct> replenishmentTaskProducts) {
		this.replenishmentTaskProducts = replenishmentTaskProducts;
	}

}
