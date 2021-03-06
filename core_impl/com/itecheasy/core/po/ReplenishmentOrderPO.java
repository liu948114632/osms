package com.itecheasy.core.po;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.itecheasy.core.PackageStatus.PackageTraceStatus;

/**
 * @author wanghw
 * @date 2016-12-3
 * @description TODO
 * @version 1.2.2
 */
@Entity
@Table(name = "replenishment_order")
public class ReplenishmentOrderPO {
	private int id;
	private String code;

	/**
	 * 客户名称
	 * 
	 */
	private String customerName;
	private int addUser;
	private Integer sendGroupId;
	private int repositoryId;
	private boolean modifyDeliveryRemark;
	private Date confirmDate;
	private String deliveryRemark;
	private int shopSource;

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

	/**
	 * 收件人
	 */
	private String recipients;

	private Integer oldStatus;

	/**
	 * 订单取消标记
	 */
	private boolean orderCancelTag;
	private String deliveryCustomerService;

	private String shipmentID;
	
	private double subTotalPercent;
	
	/**
	 * 是否cms备货 0、否  1、是 2、sw备货
	 */
	private int cmsPrepare;
	
	private Boolean copy;




	//start taozihao

	/*
		shipment_name varchar(); --货件的名称
		destination_fulfillment_centerid--可以从InboundShipmentPlans 获取
		submit_status char(1)--补货订单是否已提交亚马逊, "0"表示未提交,"1"表示已提交
		fba_replenishment_plan_id int  --计划id
	*/

	private String shipmentName;
	private String destinationFulfillmentCenterId;
	/**
	 * "0"表示未提交,"1"表示已提交
	 */
	private String submitStatus;
	private Integer fbaReplenishmentPlanId;


	private  String fbaShipmentMethod;


	//是否已经进行了cms备货
	private Boolean isSwToCmsPrepare;



	/**
	 *
	 *	RECEIVING(63,"货件已到达亚马逊配送中心，但有部分商品尚未标记为已收到"),
	 * 	CLOSED(73,"货件已到达亚马逊配送中心，但有部分商品尚未标记为已收到");
	 *
	 */
	private Integer orderAmazonStatus;

	//调用亚马逊接口同步亚马逊订单状态，如果状态是RECEIVING和CLOSED就把时间改为同步的时间，因为亚马逊也不会返回给我们具体的收集到货时间
	private Date amazonPracticalityArriveDate;

    @Column(name="order_amazon_status")
	public Integer getOrderAmazonStatus() {
		return orderAmazonStatus;
	}

	public void setOrderAmazonStatus(Integer orderAmazonStatus) {
		this.orderAmazonStatus = orderAmazonStatus;
	}

    @Column(name="amazon_practicality_arrive_date")
	public Date getAmazonPracticalityArriveDate() {
		return amazonPracticalityArriveDate;
	}

	public void setAmazonPracticalityArriveDate(Date amazonPracticalityArriveDate) {
		this.amazonPracticalityArriveDate = amazonPracticalityArriveDate;
	}




	@Column(name="is_cms_replenishment")
	public Boolean isSwToCmsPrepare() {
		return isSwToCmsPrepare;
	}

	public void setSwToCmsPrepare(Boolean swToCmsPrepare) {
		isSwToCmsPrepare = swToCmsPrepare;
	}





	@Column(name="fba_shipment_method")
	public String getFbaShipmentMethod() {
		return fbaShipmentMethod;
	}

	public void setFbaShipmentMethod(String fbaShipmentMethod) {
		this.fbaShipmentMethod = fbaShipmentMethod;
	}



	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "customer_name")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "is_send")
	public boolean getIsSend() {
		return isSend;
	}

	public void setIsSend(boolean isSend) {
		this.isSend = isSend;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "shipping_method")
	public int getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(int shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	@Column(name = "shop_id")
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Column(name = "cost_freight")
	public Double getCostFreight() {
		return costFreight;
	}

	public void setCostFreight(Double costFreight) {
		this.costFreight = costFreight;
	}

	@Column(name = "cost_price")
	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	@Column(name = "tracking_code")
	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	@Column
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "out_date")
	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	@Column(name = "delivery_date")
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Column(name = "order_item_num")
	public int getOrderItemNum() {
		return orderItemNum;
	}

	public void setOrderItemNum(int orderItemNum) {
		this.orderItemNum = orderItemNum;
	}

	@Column(name = "order_item_prepare_num")
	public int getOrderItemPrepareNum() {
		return orderItemPrepareNum;
	}

	public void setOrderItemPrepareNum(int orderItemPrepareNum) {
		this.orderItemPrepareNum = orderItemPrepareNum;
	}

	@Column(name = "shop_type")
	public int getShopType() {
		return shopType;
	}

	public void setShopType(int shopType) {
		this.shopType = shopType;
	}

	@Column(name = "latest_delivery_date")
	public Date getLatestDeliveryDate() {
		return latestDeliveryDate;
	}

	public void setLatestDeliveryDate(Date latestDeliveryDate) {
		this.latestDeliveryDate = latestDeliveryDate;
	}

	@Column(name = "earliest_delivery_date")
	public Date getEarliestDeliveryDate() {
		return earliestDeliveryDate;
	}

	public void setEarliestDeliveryDate(Date earliestDeliveryDate) {
		this.earliestDeliveryDate = earliestDeliveryDate;
	}

	@Column(name = "latest_shipping_date")
	public Date getLatestShipDate() {
		return latestShipDate;
	}

	public void setLatestShipDate(Date latestShipDate) {
		this.latestShipDate = latestShipDate;
	}

	@Column(name = "earliest_shipping_date")
	public Date getEarliestShippingDate() {
		return earliestShippingDate;
	}

	public void setEarliestShippingDate(Date earliestShippingDate) {
		this.earliestShippingDate = earliestShippingDate;
	}

	@Column(name = "add_order_date")
	public Date getAddOrderDate() {
		return addOrderDate;
	}

	public void setAddOrderDate(Date addOrderDate) {
		this.addOrderDate = addOrderDate;
	}

	@Column(name = "country")
	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	@Column(name = "problem_status")
	public int getProblemStatus() {
		return problemStatus;
	}

	public void setProblemStatus(int problemStatus) {
		this.problemStatus = problemStatus;
	}

	@Column(name = "problem_type")
	public int getProblemType() {
		return problemType;
	}

	public void setProblemType(int problemType) {
		this.problemType = problemType;
	}

	@Column(name = "merchandiser_id")
	public Integer getMerchandiserId() {
		return merchandiserId;
	}

	public void setMerchandiserId(Integer merchandiserId) {
		this.merchandiserId = merchandiserId;
	}

	@Column(name = "problem_val")
	public int getProblemVal() {
		return problemVal;
	}

	public void setProblemVal(int problemVal) {
		this.problemVal = problemVal;
	}

	@Column(name = "await_confirm_resend")
	public boolean isAwaitConfirmResend() {
		return awaitConfirmResend;
	}

	public void setAwaitConfirmResend(boolean awaitConfirmResend) {
		this.awaitConfirmResend = awaitConfirmResend;
	}

	@Column(name = "await_confirm_cancel")
	public boolean isAwaitConfirmCancel() {
		return awaitConfirmCancel;
	}

	public void setAwaitConfirmCancel(boolean awaitConfirmCancel) {
		this.awaitConfirmCancel = awaitConfirmCancel;
	}

	@Enumerated
	@Column(name = "package_status")
	public PackageTraceStatus getPackageStatus() {
		return packageStatus;
	}

	public void setPackageStatus(PackageTraceStatus packageStatus) {
		this.packageStatus = packageStatus;
	}

	@Column(name = "back_tag")
	public boolean getIsbackTag() {
		return isbackTag;
	}

	public void setIsbackTag(boolean isbackTag) {
		this.isbackTag = isbackTag;
	}

	@Column(name = "awaite_putaway")
	public boolean isAwaitPutaway() {
		return awaitPutaway;
	}

	public void setAwaitPutaway(boolean awaitPutaway) {
		this.awaitPutaway = awaitPutaway;
	}

	@Column(name = "CPF_code")
	public String getCPFCode() {
		return CPFCode;
	}

	public void setCPFCode(String cPFCode) {
		CPFCode = cPFCode;
	}

	@Column(name = "Is_Quality_Inspection")
	public int getIsQualityInspection() {
		return isQualityInspection;
	}

	public void setIsQualityInspection(int isQualityInspection) {
		this.isQualityInspection = isQualityInspection;
	}

	@Column(name = "reimburse_freight_percent")
	public BigDecimal getReimburseFreightPercent() {
		return reimburseFreightPercent;
	}

	public void setReimburseFreightPercent(BigDecimal reimburseFreightPercent) {
		this.reimburseFreightPercent = reimburseFreightPercent;
	}

	@Column(name = "cpf_type")
	public Integer getCPFType() {
		return CPFType;
	}

	public void setCPFType(Integer cPFType) {
		CPFType = cPFType;
	}

	@Column(name = "shipping_list_status")
	public int getShippingListStatus() {
		return shippingListStatus;
	}

	public void setShippingListStatus(int shippingListStatus) {
		this.shippingListStatus = shippingListStatus;
	}

	@Column(name = "add_user")
	public int getAddUser() {
		return addUser;
	}

	public void setAddUser(int addUser) {
		this.addUser = addUser;
	}

	@Column(name = "send_group_id")
	public Integer getSendGroupId() {
		return sendGroupId;
	}

	public void setSendGroupId(Integer sendGroupId) {
		this.sendGroupId = sendGroupId;
	}

	@Column(name = "repository_id")
	public int getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(int repositoryId) {
		this.repositoryId = repositoryId;
	}

	@Column(name = "is_modify_delivery_remark")
	public boolean isModifyDeliveryRemark() {
		return modifyDeliveryRemark;
	}

	public void setModifyDeliveryRemark(boolean modifyDeliveryRemark) {
		this.modifyDeliveryRemark = modifyDeliveryRemark;
	}

	@Column(name = "confirm_date")
	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	@Column(name = "delivery_remark")
	public String getDeliveryRemark() {
		return deliveryRemark;
	}

	public void setDeliveryRemark(String deliveryRemark) {
		this.deliveryRemark = deliveryRemark;
	}

	@Column
	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}

	@Column(name = "shop_source")
	public int getShopSource() {
		return shopSource;
	}

	public void setShopSource(int shopSource) {
		this.shopSource = shopSource;
	}

	@Column(name = "old_status")
	public Integer getOldStatus() {
		if (oldStatus == null) {
			return status;
		}
		return oldStatus;
	}

	public void setOldStatus(Integer oldStatus) {
		this.oldStatus = oldStatus;
	}

	@Column(name = "order_cancel_tag")
	public boolean isOrderCancelTag() {
		return orderCancelTag;
	}

	public void setOrderCancelTag(boolean orderCancelTag) {
		this.orderCancelTag = orderCancelTag;
	}

	@Column(name = "delivery_customer_service")
	public String getDeliveryCustomerService() {
		return deliveryCustomerService;
	}

	public void setDeliveryCustomerService(String deliveryCustomerService) {
		this.deliveryCustomerService = deliveryCustomerService;
	}

	@Column(name="shipment_ID")
	public String getShipmentID() {
		return shipmentID;
	}

	public void setShipmentID(String shipmentID) {
		this.shipmentID = shipmentID;
	}

	@Column(name="sub_total_percent")
	public double getSubTotalPercent() {
		return subTotalPercent;
	}

	public void setSubTotalPercent(double subTotalPercent) {
		this.subTotalPercent = subTotalPercent;
	}

	@Column(name="cms_prepare")
	public int getCmsPrepare() {
		return cmsPrepare;
	}

	public void setCmsPrepare(int cmsPrepare) {
		this.cmsPrepare = cmsPrepare;
	}

	@Column(name="copy")
	public Boolean getCopy() {
		return copy;
	}

	public void setCopy(Boolean copy) {
		this.copy = copy;
	}
	
	


	@Column(name="shipment_name")
	public String getShipmentName() {
		return shipmentName;
	}

	public void setShipmentName(String shipmentName) {
		this.shipmentName = shipmentName;
	}

	@Column(name="destination_fulfillment_centerid")
	public String getDestinationFulfillmentCenterId() {
		return destinationFulfillmentCenterId;
	}

	public void setDestinationFulfillmentCenterId(String destinationFulfillmentCenterId) {
		this.destinationFulfillmentCenterId = destinationFulfillmentCenterId;
	}

	@Column(name="submit_status")
	public String getSubmitStatus() {
		return submitStatus;
	}

	/**
	 * "0"表示未提交,"1"表示已提交
	 * @param submitStatus
	 */
	public void setSubmitStatus(String submitStatus) {
		this.submitStatus = submitStatus;
	}




	@Column(name="fba_replenishment_plan_id")
	public Integer getFbaReplenishmentPlanId() {
		return fbaReplenishmentPlanId;
	}

	/**
	 * 从InboundShipmentPlans获取
	 * @param fbaReplenishmentPlanId
	 */
	public void setFbaReplenishmentPlanId(Integer fbaReplenishmentPlanId) {
		this.fbaReplenishmentPlanId = fbaReplenishmentPlanId;
	}
	
}
