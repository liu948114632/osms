package com.itecheasy.core.order;

import java.util.Date;
import java.util.List;

import com.itecheasy.core.BaseSearchForm;

/**
 * @author wanghw
 * @date 2016-1-11
 * @description TODO
 * @version
 */
public class OrderReportSearchForm extends BaseSearchForm {
	private Date begin;
	private Date end;
	private List<Integer> shopId;
	private int type;
	private String productCode;

	/**
	 * <ul>
	 * 1、月度业绩统计
	 * </ul>
	 * <ul>
	 * 2、月度退款统计
	 * </ul>
	 * <ul>
	 * 3、FBA商品实际收款统计
	 * </ul>
	 * <ul>
	 * 4、非FBA订单总金额统计
	 * </ul>
	 * <ul>
	 * 5、FBA订单总金额统计
	 * </ul>
	 * <ul>
	 * 6、所有订单总金额统计
	 * </ul>
	 * 
	 * @return
	 */
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public List<Integer> getShopId() {
		return shopId;
	}

	public void setShopId(List<Integer> shopId) {
		this.shopId = shopId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

}
