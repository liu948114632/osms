package com.itecheasy.osms.system;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itecheasy.core.fba.FbaFromAddress;

/**
 * 
 * @author taozihao
 * @date 2018-6-5 
 * @description 
 */
@WebService
public interface FbaFromAddressWebService {
	/**
	 * 新增退货地址
	 * @param shopId
	 * @param FbaFromAddress
	 */
	public void addFbaFromAddress(@WebParam(name="fbaFromAddress") FbaFromAddress fbaFromAddress);
	
	/**
	 * 修改退货地址
	 * @param fbaFromAddress
	 */
	public void updateFbaFromAddress(@WebParam(name="fbaFromAddress") FbaFromAddress fbaFromAddress);
	
	/**
	 * 查询所有退货地址列表
	 * @return
	 */
	public List<FbaFromAddress> getFbaFromAddressList();
	
	/**
	 * 为店铺默认fba发货地址，如果之前存在则修改
	 */
	public void setFbaFromAddressForShop(@WebParam(name="shopId") int shopId, @WebParam(name="fbaFromAddressId") int fbaFromAddressId);

	/**
	 * 通过店铺id获取退货地址
	 * @param shopId
	 * @return
	 */
	public FbaFromAddress getfbaFromAddressByShopId(@WebParam(name="shopId") int shopId);
}
