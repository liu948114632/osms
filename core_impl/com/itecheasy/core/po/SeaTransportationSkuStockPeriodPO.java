package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author taozihao
 * @date 2018年7月23日 上午10:56:52
 * @description	海运备货计划sku库存周期
 */

@Entity
@Table(name = "sea_transportation_sku_stock_period")
public class SeaTransportationSkuStockPeriodPO {
	private int id;
	private Integer seaTransportationPreparePlanItemId;
	private Date date;
	private Double stockPeriod;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="sea_transportation_prepare_plan_item_id")
	public Integer getSeaTransportationPreparePlanItemId() {
		return seaTransportationPreparePlanItemId;
	}

	public void setSeaTransportationPreparePlanItemId(Integer seaTransportationPreparePlanItemId) {
		this.seaTransportationPreparePlanItemId = seaTransportationPreparePlanItemId;
	}

	@Column(name="[date]")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name="stock_period")
	public Double getStockPeriod() {
		return stockPeriod;
	}

	public void setStockPeriod(Double stockPeriod) {
		this.stockPeriod = stockPeriod;
	}

}
