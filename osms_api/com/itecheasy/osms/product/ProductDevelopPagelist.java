package com.itecheasy.osms.product;

import java.util.List;

import com.itecheasy.common.Page;
import com.itecheasy.core.product.ProductDevelop;

/**
 * @author whw
 * @date 2017-8-16
 * @description TODO
 * @version
 */
public class ProductDevelopPagelist {
	protected List<ProductDevelop> data;
	protected Page page;

	public List<ProductDevelop> getData() {
		return data;
	}

	public void setData(List<ProductDevelop> data) {
		this.data = data;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
