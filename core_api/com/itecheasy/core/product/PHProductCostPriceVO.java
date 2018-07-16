package com.itecheasy.core.product;

import java.util.List;

/**
 * @author wanghw
 * @date 2016-1-13
 * @description TODO
 * @version
 */
public class PHProductCostPriceVO {
	private List<PHProductCostPrice> PHProductCostPrices;
	private String message;

	public List<PHProductCostPrice> getPHProductCostPrices() {
		return PHProductCostPrices;
	}

	public void setPHProductCostPrices(List<PHProductCostPrice> pHProductCostPrices) {
		PHProductCostPrices = pHProductCostPrices;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
