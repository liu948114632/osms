package com.itecheasy.core.prepare;

import java.util.List;

/**
 * @author taozihao
 * @date 2018年6月30日 下午1:12:34
 * @description 备货计划商品项
 */
public class PreparePlanProductVO {
	private String primaryPictureCode;
	private String sku;
	private int prepareQuantity;
	private int actualQuantity;
	private double unitWeight;
	private double totalWeight;
	private int productType;
	private int amAvailableStock;
	private int atOnPassageQuantity;
	private int afnTotalQuantity;
	private int monthSales;
	private int isCanceled;
	private int fbaShopProductId;//fba_shop_product_id
	/**
	 * 商品是否走过海运 没走过=0 ,走过=1
	 */
	private int hasSeaTransported;
	private List<DateAndStockPeriodVO> dateAndStockPeriods;

	public String getPrimaryPictureCode() {
		return primaryPictureCode;
	}

	public void setPrimaryPictureCode(String primaryPictureCode) {
		this.primaryPictureCode = primaryPictureCode;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getPrepareQuantity() {
		return prepareQuantity;
	}

	public void setPrepareQuantity(int prepareQuantity) {
		this.prepareQuantity = prepareQuantity;
	}

	public int getActualQuantity() {
		return actualQuantity;
	}

	public void setActualQuantity(int actualQuantity) {
		this.actualQuantity = actualQuantity;
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public int getAmAvailableStock() {
		return amAvailableStock;
	}

	public void setAmAvailableStock(int amAvailableStock) {
		this.amAvailableStock = amAvailableStock;
	}

	public int getAtOnPassageQuantity() {
		return atOnPassageQuantity;
	}

	public void setAtOnPassageQuantity(int atOnPassageQuantity) {
		this.atOnPassageQuantity = atOnPassageQuantity;
	}

	public int getMonthSales() {
		return monthSales;
	}

	public void setMonthSales(int monthSales) {
		this.monthSales = monthSales;
	}

	public int getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(int isCanceled) {
		this.isCanceled = isCanceled;
	}

	public int getHasSeaTransported() {
		return hasSeaTransported;
	}

	public void setHasSeaTransported(int hasSeaTransported) {
		this.hasSeaTransported = hasSeaTransported;
	}

	public List<DateAndStockPeriodVO> getDateAndStockPeriods() {
		return dateAndStockPeriods;
	}

	public void setDateAndStockPeriods(List<DateAndStockPeriodVO> dateAndStockPeriods) {
		this.dateAndStockPeriods = dateAndStockPeriods;
	}

	public double getUnitWeight() {
		return unitWeight;
	}

	public void setUnitWeight(double unitWeight) {
		this.unitWeight = unitWeight;
	}

	public int getAfnTotalQuantity() {
		return afnTotalQuantity;
	}

	public void setAfnTotalQuantity(int afnTotalQuantity) {
		this.afnTotalQuantity = afnTotalQuantity;
	}

	public int getFbaShopProductId() {
		return fbaShopProductId;
	}

	public void setFbaShopProductId(int fbaShopProductId) {
		this.fbaShopProductId = fbaShopProductId;
	}

}
