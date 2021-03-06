package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2016-12-3
 * @description TODO
 * @version 1.2.2
 */
@Entity
@Table(name = "replenishment_order_product")
public class ReplenishmentOrderItemPO {
	private int id;
	/**
	 * 订购量
	 * 
	 */
	private double orderedQuantity;   //订购批量
	private double preparedQuantity;   //已备量
	private int cmsProductId;
	private int unitQty;
	private String unit;
	private String cmsProductCode;
	private int fbaShopProductId;
	private String sku;
	private int replenishmentOrderId;
	private double costPrice;
	private String box;
	private String fbaBarcodeName;
	private String fbaBarcodeSku;


	/**
	 * OrderService   OrderProductStatus
	 *
	 * 备货中(1), 订货中(2),断货(4), 已备货(6),已发货(8), 完成(10), 取消(12);
	 */
	private int status;
	private Double unitWeight;
	private Double unitVolume;
	
	/**
	 * 商品备注
	 */
	private String customerRemark;
	/**
	 * 客服备注
	 */
	private String csRemark;
	
	/**
	 * 分部备注
	 */
	private String branchRemark;
	

	/**
	 * 采购跟单备注
	 */
	private String purchaseRemark;
	
	/**
	 * 是否cms备货 0、否  1、是 2、sw备货
	 */
	private int cmsPrepare;
	
	
	/**
	 * sw包裹是否出库
	 */
	private Boolean swPackageStockOut;


	/**
	 * 1.	FBA补货订单详细，商品项增加字段“提交AM批量”，默认值等于“订购批量”，可以修改。这个值是修改时传给亚马逊的实际批量。
	 * 2.	老单，“提交AM批量” 初始化等于“订购批量
	 */
	private Double amQuantity;

	@Column(name = "am_quantity")
	public Double getAmQuantity() {
		return amQuantity;
	}

	public void setAmQuantity(Double amQuantity) {
		this.amQuantity = amQuantity;
	}




	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "order_qty")
	public double getOrderedQuantity() {
		return orderedQuantity;
	}

	public void setOrderedQuantity(double orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	@Column(name = "prepare_qty")
	public double getPreparedQuantity() {
		return preparedQuantity;
	}

	public void setPreparedQuantity(double preparedQuantity) {
		this.preparedQuantity = preparedQuantity;
	}

	@Column(name = "cms_product_id")
	public int getCmsProductId() {
		return cmsProductId;
	}

	public void setCmsProductId(int cmsProductId) {
		this.cmsProductId = cmsProductId;
	}

	@Column(name = "unit_qty")
	public int getUnitQty() {
		return unitQty;
	}

	public void setUnitQty(int unitQty) {
		this.unitQty = unitQty;
	}

	@Column(name = "unit")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "cms_product_code")
	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	@Column(name = "fba_shop_product_id")
	public int getFbaShopProductId() {
		return fbaShopProductId;
	}

	public void setFbaShopProductId(int fbaShopProductId) {
		this.fbaShopProductId = fbaShopProductId;
	}

	@Column(name = "sku")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Column(name = "replenishment_order_id")
	public int getReplenishmentOrderId() {
		return replenishmentOrderId;
	}

	public void setReplenishmentOrderId(int replenishmentOrderId) {
		this.replenishmentOrderId = replenishmentOrderId;
	}

	@Column(name = "cost_price")
	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	@Column(name = "box")
	public String getBox() {
		return box;
	}

	public void setBox(String box) {
		this.box = box;
	}

	@Column(name = "fba_barcode_name")
	public String getFbaBarcodeName() {
		return fbaBarcodeName;
	}

	public void setFbaBarcodeName(String fbaBarcodeName) {
		this.fbaBarcodeName = fbaBarcodeName;
	}

	@Column(name = "fba_barcode_sku")
	public String getFbaBarcodeSku() {
		return fbaBarcodeSku;
	}

	public void setFbaBarcodeSku(String fbaBarcodeSku) {
		this.fbaBarcodeSku = fbaBarcodeSku;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="unit_weight")
	public Double getUnitWeight() {
		return unitWeight;
	}

	public void setUnitWeight(Double unitWeight) {
		this.unitWeight = unitWeight;
	}

	@Column(name="unit_volume")
	public Double getUnitVolume() {
		return unitVolume;
	}

	public void setUnitVolume(Double unitVolume) {
		this.unitVolume = unitVolume;
	}

	@Column(name="customer_remark")
	public String getCustomerRemark() {
		return customerRemark;
	}

	public void setCustomerRemark(String customerRemark) {
		this.customerRemark = customerRemark;
	}

	@Column(name="cs_remark")
	public String getCsRemark() {
		return csRemark;
	}

	public void setCsRemark(String csRemark) {
		this.csRemark = csRemark;
	}

	@Column(name="branch_remark")
	public String getBranchRemark() {
		return branchRemark;
	}

	public void setBranchRemark(String branchRemark) {
		this.branchRemark = branchRemark;
	}

	@Column(name="purchase_remark")
	public String getPurchaseRemark() {
		return purchaseRemark;
	}

	public void setPurchaseRemark(String purchaseRemark) {
		this.purchaseRemark = purchaseRemark;
	}

	@Column(name="cms_prepare")
	public int getCmsPrepare() {
		return cmsPrepare;
	}

	public void setCmsPrepare(int cmsPrepare) {
		this.cmsPrepare = cmsPrepare;
	}

	@Column(name="sw_package_stock_out")
	public Boolean getSwPackageStockOut() {
		return swPackageStockOut;
	}

	public void setSwPackageStockOut(Boolean swPackageStockOut) {
		this.swPackageStockOut = swPackageStockOut;
	}
	
}
