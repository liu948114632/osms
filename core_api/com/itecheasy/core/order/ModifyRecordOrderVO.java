package com.itecheasy.core.order;

import java.util.List;

import com.itecheasy.common.Page;

/**
 * @author wanghw
 * @date 2017-1-11
 * @description TODO
 * @version 1.2.2
 */
public class ModifyRecordOrderVO {
	private List<ModifyRecordOrder> ModifyRecordOrders;
	private Page page;

	public List<ModifyRecordOrder> getModifyRecordOrders() {
		return ModifyRecordOrders;
	}

	public void setModifyRecordOrders(List<ModifyRecordOrder> modifyRecordOrders) {
		ModifyRecordOrders = modifyRecordOrders;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
