package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2016-12-2
 * @description TODO
 * @version 1.2.2
 */
@Entity
@Table(name = "fba_shop_product")
public class FbaShopProductPO {
	private int id;
	private int shopId;
	private String sku;
	private String fbaBarcodeName;
	private String fbaBarcodeSku;

	private int cmsProductId;
	private String cmsProductCode;
	private int status;
	
	/**
	 * 商品是否走过海运 没走过=0 ,走过=1
	 */
	private Integer hasSeaTransported;
	
	/**
	 * 是否海运黑名单   非海运黑名单=0 ,黑名单=1
	 */
	private Integer isSeaTransportationBlacklist;
	
	/**
	 * fba和自卖月销量
	 */
	private Integer monthSales;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="shop_id")
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Column
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Column(name="fba_barcode_name")
	public String getFbaBarcodeName() {
		return fbaBarcodeName;
	}

	public void setFbaBarcodeName(String fbaBarcodeName) {
		this.fbaBarcodeName = fbaBarcodeName;
	}

	@Column(name="fba_barcode_sku")
	public String getFbaBarcodeSku() {
		return fbaBarcodeSku;
	}

	public void setFbaBarcodeSku(String fbaBarcodeSku) {
		this.fbaBarcodeSku = fbaBarcodeSku;
	}

	@Column(name="cms_product_id")
	public int getCmsProductId() {
		return cmsProductId;
	}

	public void setCmsProductId(int cmsProductId) {
		this.cmsProductId = cmsProductId;
	}

	@Column(name="cms_product_code")
	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	@Column
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * 没走过=0 ,走过=1
	 */
	@Column(name="has_sea_transported")
	public Integer getHasSeaTransported() {
		return hasSeaTransported;
	}

	public void setHasSeaTransported(Integer hasSeaTransported) {
		this.hasSeaTransported = hasSeaTransported;
	}

	@Column(name="is_sea_transportation_blacklist")
	public Integer getIsSeaTransportationBlacklist() {
		return isSeaTransportationBlacklist;
	}
	/**
	 * 非海运黑名单=0 ,黑名单=1
	 */
	public void setIsSeaTransportationBlacklist(Integer isSeaTransportationBlacklist) {
		this.isSeaTransportationBlacklist = isSeaTransportationBlacklist;
	}

	@Column(name = "month_sales")
	public Integer getMonthSales() {
		return monthSales;
	}

	public void setMonthSales(Integer monthSales) {
		this.monthSales = monthSales;
	}
}
