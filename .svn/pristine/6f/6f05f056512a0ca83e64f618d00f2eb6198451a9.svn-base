package com.itecheasy.core.fba;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wanghw
 * @date 2016-12-1
 * @description TODO
 * @version 1.2.2
 */
public class ReplenishmentTaskProduct {
	/**
	 * @author wanghw
	 * @Date 2018-2-27 
	 * @Description 超批审核状态
	 * @version 1.2.8
	 */
	public enum MoreBatchAuditStatus{
		待审核(1),   审核通过(2),  取消(3),等待(4)
		;
		private int val;

		public int getVal() {
			return val;
		}
		
		private MoreBatchAuditStatus(int val) {
			this.val=val;
		}
	}
	
	/**
	 * @author wanghw
	 * @Date 2018-2-27 
	 * @Description 补货单类型
	 * @version 1.2.8
	 */
	public enum ReplenishmentType{
		/**
		 * fba/海外仓备货补货
		 */
		FBA(1),
		/**
		 * 订单备货补货
		 */
		ORDER(2),
		/**
		 * 订单采购
		 */
		ORDER_PURCHASE(3);
		private int val;

		public int getVal() {
			return val;
		}
		
		private ReplenishmentType(int val) {
			this.val=val;
		}
	}
	
	private int id;
	private int replenishmentTaskId;
	private int cmsProductId;
	private String cmsProductCode;
	/**
	 * 补货批量
	 */
	private int replenishmentNum;
	private int unitQty;
	/**
	 * 补货数
	 */
	private Integer taskQty;
	/**
	 * 原补货数
	 */
	private Integer oldTaskQty;
	
	
	/**
	 * 待处理数
	 */
	private Integer taskPendingQty;
	private Integer complatedQty;
	/**
	 * cms任务状态：（1 未下达、2 已下达、3 采购完成、4 无法处理、6 已结束、7 已取消、8排队中）
	 * cms办事处任务状态（10 未分配、20 已分配、30 采购中 40订货中、50加工中、55待入库、60 无法处理、70 已结束 80 已取消）
	 */
	private Integer taskStatus;
	
	private String taskStrategyDepartment;
	private Date taskToDate;
	/**
	 * 备注
	 */
	private String taskRemark;
	
	private String unit;
	private String productName;
	private String colorCardPictureCode;
	private String primaryPictureCode;
	
	/**
	 * 1、未下单 2、已下单 3、已完成
	 * <br>
	 * v1.2.8
	 * 1、未申请 4、申请中 5、审核不通过 2、备货中 3、已完成  6、取消
	 */
	private int status;
	
	/**
	 * 补货任务没有对应的任务。但是有未完成的主动备库存任务，且任务数>大于补货批量，产品淡红色显示
	 */
	private boolean showReddish;
	
	
	/**
	 * cms办事处任务类型 1 订单任务、2配件任务、3 主动备库存任务
	 * @version 1.2.8
	 */
	private Integer taskType;
	
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
	 * 是否是配件商品
	 * @version 1.2.8
	 */
	private Boolean isPartProduct;
	
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
	
	/**vo**/
	private Date createDate;
	private Date complatedDate;
	private String code;
	/**vo**/
	
	public String getPrimaryPictureCode() {
		return primaryPictureCode;
	}

	public void setPrimaryPictureCode(String primaryPictureCode) {
		this.primaryPictureCode = primaryPictureCode;
	}

	public String getColorCardPictureCode() {
		return colorCardPictureCode;
	}

	public void setColorCardPictureCode(String colorCardPictureCode) {
		this.colorCardPictureCode = colorCardPictureCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReplenishmentTaskId() {
		return replenishmentTaskId;
	}

	public void setReplenishmentTaskId(int replenishmentTaskId) {
		this.replenishmentTaskId = replenishmentTaskId;
	}

	public int getCmsProductId() {
		return cmsProductId;
	}

	public void setCmsProductId(int cmsProductId) {
		this.cmsProductId = cmsProductId;
	}

	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	public int getReplenishmentNum() {
		return replenishmentNum;
	}

	public void setReplenishmentNum(int replenishmentNum) {
		this.replenishmentNum = replenishmentNum;
	}

	public int getUnitQty() {
		return unitQty;
	}

	public void setUnitQty(int unitQty) {
		this.unitQty = unitQty;
	}

	public Integer getTaskQty() {
		return taskQty;
	}

	public void setTaskQty(Integer taskQty) {
		this.taskQty = taskQty;
	}

	public Integer getTaskPendingQty() {
		return taskPendingQty;
	}

	public void setTaskPendingQty(Integer taskPendingQty) {
		this.taskPendingQty = taskPendingQty;
	}

	public Integer getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(Integer taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskStrategyDepartment() {
		return taskStrategyDepartment;
	}

	public void setTaskStrategyDepartment(String taskStrategyDepartment) {
		this.taskStrategyDepartment = taskStrategyDepartment;
	}

	public Date getTaskToDate() {
		return taskToDate;
	}

	public void setTaskToDate(Date taskToDate) {
		this.taskToDate = taskToDate;
	}

	public String getTaskRemark() {
		return taskRemark;
	}

	public void setTaskRemark(String taskRemark) {
		this.taskRemark = taskRemark;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isShowReddish() {
		return showReddish;
	}

	public void setShowReddish(boolean showReddish) {
		this.showReddish = showReddish;
	}

	public Integer getOldTaskQty() {
		return oldTaskQty;
	}

	public void setOldTaskQty(Integer oldTaskQty) {
		this.oldTaskQty = oldTaskQty;
	}

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public Integer getMainTaskId() {
		return mainTaskId;
	}

	public void setMainTaskId(Integer mainTaskId) {
		this.mainTaskId = mainTaskId;
	}

	public String getObjectCode() {
		return objectCode;
	}

	public void setObjectCode(String objectCode) {
		this.objectCode = objectCode;
	}

	public Integer getObjectItemId() {
		return objectItemId;
	}

	public void setObjectItemId(Integer objectItemId) {
		this.objectItemId = objectItemId;
	}

	public Integer getCmsTaskId() {
		return cmsTaskId;
	}

	public void setCmsTaskId(Integer cmsTaskId) {
		this.cmsTaskId = cmsTaskId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Integer getMoreBatchAuditStatus() {
		return moreBatchAuditStatus;
	}

	public void setMoreBatchAuditStatus(Integer moreBatchAuditStatus) {
		this.moreBatchAuditStatus = moreBatchAuditStatus;
	}

	public String getMoreBatchAuditRemark() {
		return moreBatchAuditRemark;
	}

	public void setMoreBatchAuditRemark(String moreBatchAuditRemark) {
		this.moreBatchAuditRemark = moreBatchAuditRemark;
	}

	public Integer getMoreBatchQuantity() {
		return moreBatchQuantity;
	}

	public void setMoreBatchQuantity(Integer moreBatchQuantity) {
		this.moreBatchQuantity = moreBatchQuantity;
	}

	public String getMoreBatchFeedBack() {
		return moreBatchFeedBack;
	}

	public void setMoreBatchFeedBack(String moreBatchFeedBack) {
		this.moreBatchFeedBack = moreBatchFeedBack;
	}

	public Boolean getIsPartProduct() {
		return isPartProduct;
	}

	public void setIsPartProduct(Boolean isPartProduct) {
		this.isPartProduct = isPartProduct;
	}

	public String getRelatedCmsTaskId() {
		return relatedCmsTaskId;
	}

	public void setRelatedCmsTaskId(String relatedCmsTaskId) {
		this.relatedCmsTaskId = relatedCmsTaskId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getComplatedDate() {
		return complatedDate;
	}

	public void setComplatedDate(Date complatedDate) {
		this.complatedDate = complatedDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsOrderPurchase() {
		return isOrderPurchase;
	}

	public void setIsOrderPurchase(Boolean isOrderPurchase) {
		this.isOrderPurchase = isOrderPurchase;
	}

	public Integer getComplatedQty() {
		return complatedQty;
	}

	public void setComplatedQty(Integer complatedQty) {
		this.complatedQty = complatedQty;
	}

	public Boolean getIsSample() {
		return isSample;
	}

	public void setIsSample(Boolean isSample) {
		this.isSample = isSample;
	}
	
	
}
