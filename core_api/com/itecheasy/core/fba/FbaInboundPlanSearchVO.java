package com.itecheasy.core.fba;

import java.util.List;

/**
 * @author taozihao
 * @date 2018年6月11日 上午10:52:07
 * @description
 */
public class FbaInboundPlanSearchVO {
	private int shopId;
	private String shipToCountryCode;
	private String shippingMethod;
	private String planName;
	private FbaFromAddress adddress;
	private int mskus;
	private int submitStatus;
	private List<FbaInboundPlanItemExcelResult> items;
	private List<FbaPreInboundOrderVO> orders;
	
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShipToCountryCode() {
		return shipToCountryCode;
	}

	public void setShipToCountryCode(String shipToCountryCode) {
		this.shipToCountryCode = shipToCountryCode;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public FbaFromAddress getAdddress() {
		return adddress;
	}

	public void setAdddress(FbaFromAddress adddress) {
		this.adddress = adddress;
	}

	public int getMskus() {
		return mskus;
	}

	public void setMskus(int mskus) {
		this.mskus = mskus;
	}
	
	public int getSubmitStatus() {
		return submitStatus;
	}

	public void setSubmitStatus(int submitStatus) {
		this.submitStatus = submitStatus;
	}

	public List<FbaInboundPlanItemExcelResult> getItems() {
		return items;
	}

	public void setItems(List<FbaInboundPlanItemExcelResult> items) {
		this.items = items;
	}

	public List<FbaPreInboundOrderVO> getOrders() {
		return orders;
	}

	public void setOrders(List<FbaPreInboundOrderVO> orders) {
		this.orders = orders;
	}

}