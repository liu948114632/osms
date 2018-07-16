package com.itecheasy.core.prepare.dao;

import java.util.List;

import com.itecheasy.common.BaseDAO;
import com.itecheasy.core.po.SeaTransportationPreparePlanPO;
import com.itecheasy.core.prepare.PreparePlanProductVO;

/**
 * @author taozihao
 * @date 2018年7月4日 上午8:46:23
 * @description
 */
public interface SeaTransportationPreparePlanDao extends BaseDAO<SeaTransportationPreparePlanPO, Integer>{

	/**
	 * 查出当前店铺所有满足补货条件商品的以下信息 <br>
	 * PrimaryPictureCode <br>
	 * UnitWeight <br>
	 * MonthSales <br>
	 * Sku <br>
	 * HasSeaTransported <br>
	 * AfnTotalQuantity <br>
	 * @return
	 */
	public List<PreparePlanProductVO> getAllProductInfo(int shopId,double monthDiffer,double stockPeriod);
	
	/**
	 * 通过计划id查出当前店铺所有满足补货条件商品的以下信息 <br>
	 * FbaShopProductId <br>
	 * PrimaryPictureCode <br>
	 * MonthSales<br>
	 * Sku<br>
	 * HasSeaTransported<br>
	 * AfnTotalQuantity<br>
	 * ActualQuantity<br>
	 * PrepareQuantity<br>
	 * IsCanceled<br>
	 * ProductType<br>
	 * TotalWeight<br>
	 * UnitWeight<br>
	 * @param planId
	 * @return
	 */
	public List<PreparePlanProductVO> getProductInfoByPlanId(int planId);
}
