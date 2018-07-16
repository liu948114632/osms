package com.itecheasy.osms.order;

import java.util.List;

import com.itecheasy.common.Page;
import com.itecheasy.core.order.OrderTracking;

/**
 * @author whw
 * @date 2017-8-16
 * @description TODO
 * @version
 */
public class OrderTracePagelist {
	private Page page;
	private List<OrderTracking> data;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<OrderTracking> getData() {
		return data;
	}

	public void setData(List<OrderTracking> data) {
		this.data = data;
	}

}
