package com.itecheasy.core.system;

import java.util.List;

/** 
 * @author wanghw
 * @date 2016-1-13 
 * @description TODO
 * @version
 */
public interface FBAShippingMethodService {
	
	void addFBAShippingMethod(String shippingMethodOfFBA);
	
	List<String> getShippingMethodOfFBA() ;
}
