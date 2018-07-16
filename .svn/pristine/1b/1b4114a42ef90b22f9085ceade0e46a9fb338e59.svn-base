package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 订单备货商品表
 * 
 * 
 */
@Entity
@Table(name = "order_prepare_product")
public class OrderPrepareProductPO {
	private int id;
	/**
	 * 计划备货数
	 * 
	 */
	private double orderQty;
	/**
	 * 实际备货数
	 * 
	 */
	private double prepareQty;
	/**
	 * 订单项状态：备货中(1), 断货(4), 已备货(8), 完成(10), 取消(12);
	 * 
	 */
	private int status;
	/**
	 * 备货商品id
	 * 
	 */
	private int cmsProductId;
	/**
	 * 批量数量
	 * 
	 */
	private int unitQty;
	/**
	 * 批量单位
	 * 
	 */
	private String unit;

	private int orderId;
	private String cmsProductCode;
	private int orderProductId;
	private Double unitWeight;
	private Double unitVolume;

	/**
	 * cms子箱
	 */
	private String box;

	/**
	 * 是否受限制
	 */
	private Boolean islimit;

	/**
	 * 是否cms备货
	 */
	private int cmsPrepare;

	/**
	 * 非正常匹配，无法匹配网店店铺商品。
	 */
	private boolean abnormalMate;

	private boolean deleted;

	private boolean electronic;

	/**
	 * 带磁
	 */
	private boolean magnetism;

	/**
	 * 纺织品
	 */
	private boolean textile;

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
	 * sw包裹是否出库
	 */
	private Boolean swPackageStockOut;
	
	/**
	 * 采购跟单备注
	 */
	private String purchaseRemark;
	
	/**
	 * 订单采购，超批审核等待的任务id
	 * @version 1.2.8
	 */
	private Integer moreBatchAuditWaitTaskProductId;

	@Column(name = "textile")
	public boolean isTextile() {
		return textile;
	}

	public void setTextile(boolean textile) {
		this.textile = textile;
	}

	@Column(name = "magnetism")
	public boolean isMagnetism() {
		return magnetism;
	}

	public void setMagnetism(boolean magnetism) {
		this.magnetism = magnetism;
	}

	@Column(name = "is_deleted")
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Column(name = "electronic")
	public boolean isElectronic() {
		return electronic;
	}

	public void setElectronic(boolean electronic) {
		this.electronic = electronic;
	}

	@Column(name = "abnormal_mate")
	public boolean isAbnormalMate() {
		return abnormalMate;
	}

	public void setAbnormalMate(boolean abnormalMate) {
		this.abnormalMate = abnormalMate;
	}

	@Column(name = "cms_prepare")
	public int getCmsPrepare() {
		return cmsPrepare;
	}

	public void setCmsPrepare(int cmsPrepare) {
		this.cmsPrepare = cmsPrepare;
	}

	@Column(name = "is_limit")
	public Boolean getIslimit() {
		return islimit;
	}

	public void setIslimit(Boolean islimit) {
		this.islimit = islimit;
	}

	private double costPrice;

	@Column(name = "cost_price")
	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public String getBox() {
		return box;
	}

	public void setBox(String box) {
		this.box = box;
	}

	@Column(name = "unit_weight")
	public Double getUnitWeight() {
		return unitWeight;
	}

	public void setUnitWeight(Double unitWeight) {
		this.unitWeight = unitWeight;
	}

	@Column(name = "unit_volume")
	public Double getUnitVolume() {
		return unitVolume;
	}

	public void setUnitVolume(Double unitVolume) {
		this.unitVolume = unitVolume;
	}

	@Column(name = "order_product_id")
	public int getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "order_qty")
	public double getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(double orderQty) {
		this.orderQty = orderQty;
	}

	@Column(name = "prepare_qty")
	public double getPrepareQty() {
		return prepareQty;
	}

	public void setPrepareQty(double prepareQty) {
		this.prepareQty = prepareQty;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	@Column(name = "order_id")
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Column(name = "cms_product_code")
	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	@Column(name = "customer_remark")
	public String getCustomerRemark() {
		return customerRemark;
	}

	public void setCustomerRemark(String customerRemark) {
		this.customerRemark = customerRemark;
	}

	@Column(name = "cs_remark")
	public String getCsRemark() {
		return csRemark;
	}

	public void setCsRemark(String csRemark) {
		this.csRemark = csRemark;
	}

	@Column(name = "branch_remark")
	public String getBranchRemark() {
		return branchRemark;
	}

	public void setBranchRemark(String branchRemark) {
		this.branchRemark = branchRemark;
	}

	@Column(name="sw_package_stock_out")
	public Boolean getSwPackageStockOut() {
		return swPackageStockOut;
	}

	public void setSwPackageStockOut(Boolean swPackageStockOut) {
		this.swPackageStockOut = swPackageStockOut;
	}

	@Column(name="purchase_remark")
	public String getPurchaseRemark() {
		return purchaseRemark;
	}

	public void setPurchaseRemark(String purchaseRemark) {
		this.purchaseRemark = purchaseRemark;
	}

	@Column(name="more_batch_audit_wait_task_id")
	public Integer getMoreBatchAuditWaitTaskProductId() {
		return moreBatchAuditWaitTaskProductId;
	}

	public void setMoreBatchAuditWaitTaskProductId(Integer moreBatchAuditWaitTaskProductId) {
		this.moreBatchAuditWaitTaskProductId = moreBatchAuditWaitTaskProductId;
	}

	

}