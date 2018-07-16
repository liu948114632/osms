package com.itecheasy.core.order;

import java.util.List;

import com.itecheasy.core.system.Country;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.ShopService;
import com.itecheasy.core.system.SystemService;

/**
 * @author wanghw
 * @date 2015-5-15
 * @description TODO
 * @version
 */
public class LoginServices {
	private SystemService systemService;
	private ShopService shopService;

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public String sayHello(String name) {
		System.out.println("Hello now!");
		return "Hello " + name + "!";
	}
	
	public List<Shop> getShops(){
		return shopService.getAvailableShops();
	}

	public List<Country> getCountries() {
		return systemService.getAllCountrys();
	}
	
	public boolean order(OrderDetail detail){
		System.out.println(detail.getOrderAddress().getAddressLine1());
		return true;
	}
}
