

package com.itecheasy.core.po;

import java.util.Comparator;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description TODO
 * @version
 */
@Entity
@Table(name = "shop")
public class ShopPo    {
	private int id;
	private String name;
	private int type;

	private Integer department;

	private Integer shopDevInfoId;
	private Date lastUpdatedAfter;

	private boolean enable;
	private String marketplaceID;

	private int currency;

	private int firstWayCountry;
	
	private Integer fbaFromAddressId;//退货地址
	
	/**
	 * 海运安全库存周期
	 */
	private Double seaTransSecurityStockPeriod;
	
	/**
	 * 海运预计货运天数
	 */
	private Integer seaTransDays;




	@Column(name="fba_from_address_id")
	public Integer getFbaFromAddressId() {
		return fbaFromAddressId;
	}

	public void setFbaFromAddressId(Integer fbaFromAddressId) {
		this.fbaFromAddressId = fbaFromAddressId;
	}

	@Column(name="first_way_country")
	public int getFirstWayCountry() {
		return firstWayCountry;
	}

	public void setFirstWayCountry(int firstWayCountry) {
		this.firstWayCountry = firstWayCountry;
	}

	@Column(name = "currency")
	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	@Column(name = "marketplaceID")
	public String getMarketplaceID() {
		return marketplaceID;
	}

	public void setMarketplaceID(String marketplaceID) {
		this.marketplaceID = marketplaceID;
	}

	/**
	 * 品牌
	 */
	private boolean notUPC;

	@Column(name = "not_upc")
	public boolean isNotUPC() {
		return notUPC;
	}

	public void setNotUPC(boolean notUPC) {
		this.notUPC = notUPC;
	}

	@Column
	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@Column(name = "shop_dev_info_id")
	public Integer getShopDevInfoId() {
		return shopDevInfoId;
	}

	public void setShopDevInfoId(Integer shopDevInfoId) {
		this.shopDevInfoId = shopDevInfoId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	@Column
	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "last_updated_after")
	public Date getLastUpdatedAfter() {
		return lastUpdatedAfter;
	}

	public void setLastUpdatedAfter(Date lastUpdatedAfter) {
		this.lastUpdatedAfter = lastUpdatedAfter;
	}

	@Column(name = "sea_trans_security_stock_period")
	public Double getSeaTransSecurityStockPeriod() {
		return seaTransSecurityStockPeriod;
	}

	public void setSeaTransSecurityStockPeriod(Double seaTransSecurityStockPeriod) {
		this.seaTransSecurityStockPeriod = seaTransSecurityStockPeriod;
	}

	// TODO: 2018/7/4 字段
	@Column(name = "sea_trans_days")
	public Integer getSeaTransDays() {
		return seaTransDays;
	}

	public void setSeaTransDays(Integer seaTransDays) {
		this.seaTransDays = seaTransDays;
	}
}
