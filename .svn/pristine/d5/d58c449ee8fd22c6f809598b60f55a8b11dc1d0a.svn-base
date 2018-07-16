package com.itecheasy.core.fba;

import java.math.BigDecimal;
import java.util.Date;

import com.itecheasy.core.PackageStatus.PackageTraceStatus;

import javax.persistence.Column;

/**
 * @author wanghw
 * @date 2016-11-30
 * @description fba补货单
 * @version 1.2.2
 */
public class ReplenishmentOrder {
	private int id;
	private String code;

	/**
	 * 客户名称
	 * 
	 */
	private String customerName;
	private int shopSource;
	private String recipients;
	private Integer sendGroupId;
	private int repositoryId;
	private boolean modifyDeliveryRemark;
	private Date confirmDate;
	private String deliveryRemark;
	/**
	 * 是否可发货
	 * 
	 */
	private boolean isSend;
	/**
	 * 订单状态：准备货物(1), 已备货(31), 待校对(40), 已打包(55), 已出库(60), 已发货(64), 完成(128),
	 * 取消(132);
	 * 
	 */
	private int status;

	/**
	 * 货运方式
	 * 
	 */
	private int shippingMethod;
	/**
	 * 店铺id
	 * 
	 */
	private int shopId;
	/**
	 * dms发货成本 rmb
	 * 
	 */
	private Double costFreight;
	/**
	 * 成本价(订单中实际出库的商品基准成本价之和 )
	 * 
	 */
	private Double costPrice;
	/**
	 * 跟踪单号
	 * 
	 */
	private String trackingCode;
	/**
	 * 订单备注
	 * 
	 */
	private String remark;
	/**
	 * cms出库时间
	 * 
	 */
	private Date outDate;
	/**
	 * dms发货时间
	 * 
	 */
	private Date deliveryDate;

	/**
	 * 订单项总数
	 * 
	 */
	private int orderItemNum;
	/**
	 * 订单项备货总数
	 * 
	 */
	private int orderItemPrepareNum;
	/**
	 * 网店平台
	 * 
	 */
	private int shopType;

	/**
	 * 预计交货日期最后一天
	 * 
	 */
	private Date latestDeliveryDate;
	/**
	 * 预计交货日期第一天
	 * 
	 */
	private Date earliestDeliveryDate;
	/**
	 * 预计发货日期最后一天
	 * 
	 */
	private Date latestShipDate;
	/**
	 * 预计发货日期第一天
	 * 
	 */
	private Date earliestShippingDate;

	/**
	 * 系统增加订单时间
	 */
	private Date addOrderDate;

	private int addUser;

	private Integer country;

	/**
	 * 问题状态
	 */
	private int problemStatus;

	/**
	 * 问题类型
	 */
	private int problemType;

	/**
	 * 跟单员
	 */
	private Integer merchandiserId;

	/**
	 * 问题总值
	 */
	private int problemVal;

	/**
	 * 重发 待确认
	 */
	private boolean awaitConfirmResend;

	/**
	 * 取消 待确认
	 */
	private boolean awaitConfirmCancel;

	/**
	 * 订单物流状态
	 */
	private PackageTraceStatus packageStatus;

	private boolean isbackTag;

	private boolean awaitPutaway;

	/**
	 * 税号
	 */
	private String CPFCode;

	/**
	 * 是否质检
	 */
	private int isQualityInspection;

	/**
	 * 发票金额百分比
	 */
	private BigDecimal reimburseFreightPercent;

	/**
	 * 税号类型
	 */
	private Integer CPFType;

	/**
	 * 货运清单状态
	 */
	private int shippingListStatus;

	private Integer oldStatus;

	/**
	 * 订单取消标记
	 */
	private boolean orderCancelTag;
	private String deliveryCustomerService;
	private String shipmentID;
	
	/**
	 * 是否cms备货 0、否  1、是 2、sw备货
	 */
	private int cmsPrepare;

	/**
	 *
	 * 用于判断用户是否点击
	 *
	 */
//	private Boolean isShowReplenishmentButton;

	/**
	 * 报关金额百分比
	 */
	private double subTotalPercent;
	
	private Boolean copy;

	/** vo */
	private String merchandiserName;

	/** 亚马逊仓库id */
	
	private String destinationFulfillmentCenterId;

	//货建名
	private String shipmentName;


	private  String fbaShipmentMethod;

	//是否已经进行了cms备货
	private boolean isSwToCmsPrepare ;

	public boolean isSwToCmsPrepare() {
		return isSwToCmsPrepare;
	}

	public void setSwToCmsPrepare(boolean swToCmsPrepare) {
		isSwToCmsPrepare = swToCmsPrepare;
	}

	public String getFbaShipmentMethod() {
		return fbaShipmentMethod;
	}

	public void setFbaShipmentMethod(String fbaShipmentMethod) {
		this.fbaShipmentMethod = fbaShipmentMethod;
	}



	public String getShipmentName() {
		return shipmentName;
	}

	public void setShipmentName(String shipmentName) {
		this.shipmentName = shipmentName;
	}

	public String getDestinationFulfillmentCenterId() {
		return destinationFulfillmentCenterId;
	}

	public void setDestinationFulfillmentCenterId(String destinationFulfillmentCenterId) {
		this.destinationFulfillmentCenterId = destinationFulfillmentCenterId;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public boolean getIsSend() {
		return isSend;
	}

	public void setIsSend(boolean isSend) {
		this.isSend = isSend;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(int shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public Double getCostFreight() {
		return costFreight;
	}

	public void setCostFreight(Double costFreight) {
		this.costFreight = costFreight;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getOrderItemNum() {
		return orderItemNum;
	}

	public void setOrderItemNum(int orderItemNum) {
		this.orderItemNum = orderItemNum;
	}

	public int getOrderItemPrepareNum() {
		return orderItemPrepareNum;
	}

	public void setOrderItemPrepareNum(int orderItemPrepareNum) {
		this.orderItemPrepareNum = orderItemPrepareNum;
	}

	public int getShopType() {
		return shopType;
	}

	public void setShopType(int shopType) {
		this.shopType = shopType;
	}

	public Date getLatestDeliveryDate() {
		return latestDeliveryDate;
	}

	public void setLatestDeliveryDate(Date latestDeliveryDate) {
		this.latestDeliveryDate = latestDeliveryDate;
	}

	public Date getEarliestDeliveryDate() {
		return earliestDeliveryDate;
	}

	public void setEarliestDeliveryDate(Date earliestDeliveryDate) {
		this.earliestDeliveryDate = earliestDeliveryDate;
	}

	public Date getLatestShipDate() {
		return latestShipDate;
	}

	public void setLatestShipDate(Date latestShipDate) {
		this.latestShipDate = latestShipDate;
	}

	public Date getEarliestShippingDate() {
		return earliestShippingDate;
	}

	public void setEarliestShippingDate(Date earliestShippingDate) {
		this.earliestShippingDate = earliestShippingDate;
	}

	public Date getAddOrderDate() {
		return addOrderDate;
	}

	public void setAddOrderDate(Date addOrderDate) {
		this.addOrderDate = addOrderDate;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public int getProblemStatus() {
		return problemStatus;
	}

	public void setProblemStatus(int problemStatus) {
		this.problemStatus = problemStatus;
	}

	public int getProblemType() {
		return problemType;
	}

	public void setProblemType(int problemType) {
		this.problemType = problemType;
	}

	public Integer getMerchandiserId() {
		return merchandiserId;
	}

	public void setMerchandiserId(Integer merchandiserId) {
		this.merchandiserId = merchandiserId;
	}

	public int getProblemVal() {
		return problemVal;
	}

	public void setProblemVal(int problemVal) {
		this.problemVal = problemVal;
	}

	public boolean isAwaitConfirmResend() {
		return awaitConfirmResend;
	}

	public void setAwaitConfirmResend(boolean awaitConfirmResend) {
		this.awaitConfirmResend = awaitConfirmResend;
	}

	public boolean isAwaitConfirmCancel() {
		return awaitConfirmCancel;
	}

	public void setAwaitConfirmCancel(boolean awaitConfirmCancel) {
		this.awaitConfirmCancel = awaitConfirmCancel;
	}

	public PackageTraceStatus getPackageStatus() {
		return packageStatus;
	}

	public void setPackageStatus(PackageTraceStatus packageStatus) {
		this.packageStatus = packageStatus;
	}

	public boolean getIsbackTag() {
		return isbackTag;
	}

	public void setIsbackTag(boolean isbackTag) {
		this.isbackTag = isbackTag;
	}

	public boolean isAwaitPutaway() {
		return awaitPutaway;
	}

	public void setAwaitPutaway(boolean awaitPutaway) {
		this.awaitPutaway = awaitPutaway;
	}

	public String getCPFCode() {
		return CPFCode;
	}

	public void setCPFCode(String cPFCode) {
		CPFCode = cPFCode;
	}

	public int getIsQualityInspection() {
		return isQualityInspection;
	}

	public void setIsQualityInspection(int isQualityInspection) {
		this.isQualityInspection = isQualityInspection;
	}

	public BigDecimal getReimburseFreightPercent() {
		return reimburseFreightPercent;
	}

	public void setReimburseFreightPercent(BigDecimal reimburseFreightPercent) {
		this.reimburseFreightPercent = reimburseFreightPercent;
	}

	public Integer getCPFType() {
		return CPFType;
	}

	public void setCPFType(Integer cPFType) {
		CPFType = cPFType;
	}

	public int getShippingListStatus() {
		return shippingListStatus;
	}

	public void setShippingListStatus(int shippingListStatus) {
		this.shippingListStatus = shippingListStatus;
	}

	public int getAddUser() {
		return addUser;
	}

	public void setAddUser(int addUser) {
		this.addUser = addUser;
	}

	public Integer getSendGroupId() {
		return sendGroupId;
	}

	public void setSendGroupId(Integer sendGroupId) {
		this.sendGroupId = sendGroupId;
	}

	public int getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(int repositoryId) {
		this.repositoryId = repositoryId;
	}

	public boolean isModifyDeliveryRemark() {
		return modifyDeliveryRemark;
	}

	public void setModifyDeliveryRemark(boolean modifyDeliveryRemark) {
		this.modifyDeliveryRemark = modifyDeliveryRemark;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getDeliveryRemark() {
		return deliveryRemark;
	}

	public void setDeliveryRemark(String deliveryRemark) {
		this.deliveryRemark = deliveryRemark;
	}

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}

	public int getShopSource() {
		return shopSource;
	}

	public void setShopSource(int shopSource) {
		this.shopSource = shopSource;
	}

	public Integer getOldStatus() {
		return oldStatus;
	}

	public void setOldStatus(Integer oldStatus) {
		this.oldStatus = oldStatus;
	}

	public boolean isOrderCancelTag() {
		return orderCancelTag;
	}

	public void setOrderCancelTag(boolean orderCancelTag) {
		this.orderCancelTag = orderCancelTag;
	}

	public String getDeliveryCustomerService() {
		return deliveryCustomerService;
	}

	public void setDeliveryCustomerService(String deliveryCustomerService) {
		this.deliveryCustomerService = deliveryCustomerService;
	}

	public String getMerchandiserName() {
		return merchandiserName;
	}

	public void setMerchandiserName(String merchandiserName) {
		this.merchandiserName = merchandiserName;
	}

	public String getShipmentID() {
		return shipmentID;
	}

	public void setShipmentID(String shipmentID) {
		this.shipmentID = shipmentID;
	}

	public double getSubTotalPercent() {
		return subTotalPercent;
	}

	public void setSubTotalPercent(double subTotalPercent) {
		this.subTotalPercent = subTotalPercent;
	}

	public int getCmsPrepare() {
		return cmsPrepare;
	}

	public void setCmsPrepare(int cmsPrepare) {
		this.cmsPrepare = cmsPrepare;
	}

	public Boolean getCopy() {
		return copy;
	}

	public void setCopy(Boolean copy) {
		this.copy = copy;
	}
	
}
