package com.itecheasy.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itecheasy.core.product.ProductDevelop;
import com.itecheasy.core.product.ProductDevelopService;

/** 
 * @author whw
 * @date 2017-8-17 
 * @description TODO
 * @version 
 */
public class ProductTest extends SprintTest{
	private ProductDevelopService productDevelopService;

	public void setProductDevelopService(ProductDevelopService productDevelopService) {
		this.productDevelopService = productDevelopService;
	}
	
	
	public void add(){
		List<ProductDevelop> productDevelops=new ArrayList<ProductDevelop>();
		ProductDevelop productDevelop=new ProductDevelop();
		productDevelop.setCmsProductCode("dz001");
		productDevelop.setDeveloper("xxx");
		productDevelop.setPutawayDate(new Date());
		
		productDevelops.add(productDevelop);
		productDevelopService.addProductDevelop(productDevelops, 6);
	}

	public void test(){
		String text = "";
		String[] split = text.split("\r\n");
		for (int i = 0; i < split.length; i++) {
			split[i].split("\t");
		}
	}
}
