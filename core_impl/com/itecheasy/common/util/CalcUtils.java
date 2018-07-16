package com.itecheasy.common.util;

import java.math.BigDecimal;

/** 
 * @author wanghw
 * @date 2015-5-21 
 * @description TODO
 * @version
 */
public class CalcUtils {
	
	/**
	 * 单重转换成批量重量
	 * @param weight
	 * @return
	 */
	public static BigDecimal unitweight(BigDecimal weight,int unitQty){
		if (weight==null) {
			return null;
		}
		return weight.multiply(new BigDecimal(unitQty)).multiply(new BigDecimal(1.15)).setScale(0,BigDecimal.ROUND_UP);
	}
	
	/**
	 * 单体转换成批量体积
	 * @param volume
	 * @param unitQty
	 * @return
	 */
	public static BigDecimal unitVoluem(BigDecimal volume,int unitQty){
		if (volume==null) {
			return null;
		}
		return volume.multiply(new BigDecimal(unitQty)).multiply(new BigDecimal(1.3)).setScale(0,0);
	}
	
}
