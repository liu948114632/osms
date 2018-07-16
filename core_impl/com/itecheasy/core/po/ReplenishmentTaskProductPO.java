package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2016-12-7
 * @description TODO
 * @version 1.2.2
 */
@Entity
@Table(name = "replenishment_task_product")
public class ReplenishmentTaskProductPO {
	private int id;
	private int replenishmentTaskId;
	private int cmsProductId;
	private String cmsProductCode;
	private int replenishmentNum;
	private int unitQty;
	private String unit;
	private Integer taskQty;
	private Integer oldTaskQty;
	private Integer taskPendingQty;
	private Integer complatedQty;
	private Integer taskStatus;
	private String taskStrategyDepartment;
	private Date taskToDate;
	private String taskRemark;
	private String taskFeedback;

	/**
	 *  1、未申请 4、申请中 5、审核不通过 2、备货中 3、已完成  6、取消
	 */
	private int status;
	
	/**
	 * cms办事处任务类型 1 订单任务、2配件任务、3 主动备库存任务
	 * @version 1.2.8
	 */
	private Integer taskType;
	
	/**
	 * 是否是配件商品
	 * @version 1.2.8
	 */
	private Boolean isPartProduct;
	
	/**
	 * 配件所属任务Id
	 * @version 1.2.8
	 */
	private Integer mainTaskId;
	
	/**
	 * cms加工单/订单id
	 * @version 1.2.8
	 */
	private String objectCode;
	
	/**
	 * cms加工单项/订单项id
	 * @version 1.2.8
	 */
	private Integer objectItemId;
	
	/**
	 * cms采管任务id
	 * @version 1.2.8
	 */
	private Integer cmsTaskId;
	
	/**
	 * 相关联的采管任务id
	 */
	private String relatedCmsTaskId;
	
	/**
	 * 任务类型 ：
	 * <dd>1、FBA/海外仓补货</dd>
	 * <dd>2、自卖备货补货</dd>
	 * <dd>3、自卖订单采购</dd>
	 * <br>
	 * @version 1.2.8
	 */
	private int type;
	
	/**
	 * 超批审核状态:1、待审核   2、审核通过  3、审核不通过  4、等待
	 * @version 1.2.8
	 */
	private Integer moreBatchAuditStatus;
	
	/**
	 * 超批审核备注
	 * @version 1.2.8
	 */
	private String moreBatchAuditRemark;
	
	/**
	 * 超批采购数量
	 * @version 1.2.8
	 */
	private Integer moreBatchQuantity;
	
	/**
	 * 超批采购反馈，记录办事处反馈需要增加采购量的理由
	 * @version 1.2.8
	 */
	private String moreBatchFeedBack;
	
	/**
	 * 订单采购任务及配件超批生成的新任务（列表查询区分自卖订单采购补货商品列表）
	 * @version 1.2.8
	 */
	private Boolean isOrderPurchase;
	
	/**
	 * 打样加工
	 * @version 1.2.8
	 */
	private Boolean isSample;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="replenishment_task_id")
	public int getReplenishmentTaskId() {
		return replenishmentTaskId;
	}

	public void setReplenishmentTaskId(int replenishmentTaskId) {
		this.replenishmentTaskId = replenishmentTaskId;
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

	@Column(name="replenishment_num")
	public int getReplenishmentNum() {
		return replenishmentNum;
	}

	public void setReplenishmentNum(int replenishmentNum) {
		this.replenishmentNum = replenishmentNum;
	}

	@Column(name="unit_quantity")
	public int getUnitQty() {
		return unitQty;
	}

	public void setUnitQty(int unitQty) {
		this.unitQty = unitQty;
	}

	@Column(name="unit")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name="task_quantity")
	public Integer getTaskQty() {
		return taskQty;
	}

	public void setTaskQty(Integer taskQty) {
		this.taskQty = taskQty;
	}

	@Column(name="task_pending_quantity")
	public Integer getTaskPendingQty() {
		return taskPendingQty;
	}

	public void setTaskPendingQty(Integer taskPendingQty) {
		this.taskPendingQty = taskPendingQty;
	}

	@Column(name="task_status")
	public Integer getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(Integer taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Column(name="task_strategy_department")
	public String getTaskStrategyDepartment() {
		return taskStrategyDepartment;
	}

	public void setTaskStrategyDepartment(String taskStrategyDepartment) {
		this.taskStrategyDepartment = taskStrategyDepartment;
	}

	@Column(name="task_to_date")
	public Date getTaskToDate() {
		return taskToDate;
	}

	public void setTaskToDate(Date taskToDate) {
		this.taskToDate = taskToDate;
	}

	@Column(name="task_remark")
	public String getTaskRemark() {
		return taskRemark;
	}

	public void setTaskRemark(String taskRemark) {
		this.taskRemark = taskRemark;
	}

	@Column(name="task_feedback")
	public String getTaskFeedback() {
		return taskFeedback;
	}

	public void setTaskFeedback(String taskFeedback) {
		this.taskFeedback = taskFeedback;
	}

	@Column(name="status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	@Column(name="task_type")
	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	@Column(name="main_task_id")
	public Integer getMainTaskId() {
		return mainTaskId;
	}

	public void setMainTaskId(Integer mainTaskId) {
		this.mainTaskId = mainTaskId;
	}

	@Column(name="task_object_code")
	public String getObjectCode() {
		return objectCode;
	}

	public void setObjectCode(String objectCode) {
		this.objectCode = objectCode;
	}

	@Column(name="task_object_item_id")
	public Integer getObjectItemId() {
		return objectItemId;
	}

	public void setObjectItemId(Integer objectItemId) {
		this.objectItemId = objectItemId;
	}

	@Column(name="cms_task_id")
	public Integer getCmsTaskId() {
		return cmsTaskId;
	}

	public void setCmsTaskId(Integer cmsTaskId) {
		this.cmsTaskId = cmsTaskId;
	}

	@Column(name="type")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name="more_batch_audit_status")
	public Integer getMoreBatchAuditStatus() {
		return moreBatchAuditStatus;
	}

	public void setMoreBatchAuditStatus(Integer moreBatchAuditStatus) {
		this.moreBatchAuditStatus = moreBatchAuditStatus;
	}

	@Column(name="more_batch_audit_remark")
	public String getMoreBatchAuditRemark() {
		return moreBatchAuditRemark;
	}

	public void setMoreBatchAuditRemark(String moreBatchAuditRemark) {
		this.moreBatchAuditRemark = moreBatchAuditRemark;
	}

	@Column(name="more_batch_quantity")
	public Integer getMoreBatchQuantity() {
		return moreBatchQuantity;
	}

	public void setMoreBatchQuantity(Integer moreBatchQuantity) {
		this.moreBatchQuantity = moreBatchQuantity;
	}

	@Column(name="more_batch_feed_back")
	public String getMoreBatchFeedBack() {
		return moreBatchFeedBack;
	}

	public void setMoreBatchFeedBack(String moreBatchFeedBack) {
		this.moreBatchFeedBack = moreBatchFeedBack;
	}

	@Column(name="is_part_product")
	public Boolean getIsPartProduct() {
		return isPartProduct;
	}

	public void setIsPartProduct(Boolean isPartProduct) {
		this.isPartProduct = isPartProduct;
	}

	@Column(name="old_task_qty")
	public Integer getOldTaskQty() {
		return oldTaskQty;
	}

	public void setOldTaskQty(Integer oldTaskQty) {
		this.oldTaskQty = oldTaskQty;
	}

	@Column(name="complated_qty")
	public Integer getComplatedQty() {
		return complatedQty;
	}

	public void setComplatedQty(Integer complatedQty) {
		this.complatedQty = complatedQty;
	}

	@Column(name="related_cms_task_ids")
	public String getRelatedCmsTaskId() {
		return relatedCmsTaskId;
	}

	public void setRelatedCmsTaskId(String relatedCmsTaskId) {
		this.relatedCmsTaskId = relatedCmsTaskId;
	}

	@Column(name="order_purchase")
	public Boolean getIsOrderPurchase() {
		return isOrderPurchase;
	}

	public void setIsOrderPurchase(Boolean isOrderPurchase) {
		this.isOrderPurchase = isOrderPurchase;
	}

	@Column(name="is_sample")
	public Boolean getIsSample() {
		return isSample;
	}

	public void setIsSample(Boolean isSample) {
		this.isSample = isSample;
	}
	
	
}
