package com.itecheasy.core.fba;

/**
 * @author taozihao
 * @date 2018年7月26日 上午9:42:04
 * @description 备货计划方式以及id
 */
public class PreparePlanTypeVO {
	private String shippingMethod;
	private Integer preparePlanId;

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public Integer getPreparePlanId() {
		return preparePlanId;
	}

	public void setPreparePlanId(Integer preparePlanId) {
		this.preparePlanId = preparePlanId;
	}

}
