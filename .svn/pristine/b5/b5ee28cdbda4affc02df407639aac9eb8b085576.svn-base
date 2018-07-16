package com.itecheasy.core.po;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2015-6-25
 * @description TODO
 * @version
 */
@Entity
@Table(name = "v_replenishment_order_")
public class ReplenishmentOrderViewPO {

	private int id;
	/**
	 * 订单编号
	 * 
	 */
	private String code;
	/**
	 * 客户名称
	 * 
	 */
	private String customerName;
	/**
	 * 是否可发货
	 * 
	 */
	private Boolean isSend;
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
	 * 同票id
	 * 
	 */
	private Integer sendGroupId;
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
	 * 税号
	 */
	private String CPFCode;

	/**
	 * 税号类型
	 */
	private Integer CPFType;

	/**
	 * 是否质检
	 */
	private int isQualityInspection;

	/**
	 * 报关运费百分比
	 */
	private BigDecimal reimburseFreightPercent;

	/**
	 * 跟单员
	 */
	private Integer merchandiserId;

	private String merchandiserName;

	/**
	 * 问题状态
	 */
	private int problemStatus;

	/**
	 * 问题类型
	 */
	private int problemType;

	private String deliveryCustomerService;

	/**
	 * 重发 待确认
	 */
	private boolean awaitConfirmResend;

	/**
	 * 取消 待确认
	 */
	private boolean awaitConfirmCancel;

	private boolean awaitPutaway;

	private int addUser;
	private int repositoryId;
	private boolean modifyDeliveryRemark;
	private Date confirmDate;
	private String deliveryRemark;

	private String recipients;

	private int shippingListStatus;
	private String shipmentID;
	
	/**
	 * 是否cms备货 0、否  1、是 2、sw备货
	 */
	private int cmsPrepare;
	
	private Boolean copy;

	@Column(name = "awaite_putaway")
	public boolean isAwaitPutaway() {
		return awaitPutaway;
	}

	public void setAwaitPutaway(boolean awaitPutaway) {
		this.awaitPutaway = awaitPutaway;
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

	@Column(name = "delivery_customer_service")
	public String getDeliveryCustomerService() {
		return deliveryCustomerService;
	}

	public void setDeliveryCustomerService(String deliveryCustomerService) {
		this.deliveryCustomerService = deliveryCustomerService;
	}

	@Column(name = "merchandiser_name")
	public String getMerchandiserName() {
		return merchandiserName;
	}

	public void setMerchandiserName(String merchandiserName) {
		this.merchandiserName = merchandiserName;
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

	@Column(name = "merchandiser_id")
	public Integer getMerchandiserId() {
		return merchandiserId;
	}

	public void setMerchandiserId(Integer merchandiserId) {
		this.merchandiserId = merchandiserId;
	}

	@Column(name = "country")
	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	@Column(name = "cpf_type")
	public Integer getCPFType() {
		return CPFType;
	}

	public void setCPFType(Integer cPFType) {
		CPFType = cPFType;
	}

	@Column(name = "add_order_date")
	public Date getAddOrderDate() {
		return addOrderDate;
	}

	public void setAddOrderDate(Date addOrderDate) {
		this.addOrderDate = addOrderDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "code")
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
	public Boolean getIsSend() {
		return isSend;
	}

	public void setIsSend(Boolean isSend) {
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

	@Column(name = "send_group_id")
	public Integer getSendGroupId() {
		return sendGroupId;
	}

	public void setSendGroupId(Integer sendGroupId) {
		this.sendGroupId = sendGroupId;
	}

	@Column(name = "tracking_code")
	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	@Column(name = "remark")
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

	@Column(name = "add_user")
	public int getAddUser() {
		return addUser;
	}

	public void setAddUser(int addUser) {
		this.addUser = addUser;
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

	@Column(name = "recipients")
	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}

	@Column(name="shipping_list_status")
	public int getShippingListStatus() {
		return shippingListStatus;
	}

	public void setShippingListStatus(int shippingListStatus) {
		this.shippingListStatus = shippingListStatus;
	}

	@Column(name="shipment_ID")
	public String getShipmentID() {
		return shipmentID;
	}

	public void setShipmentID(String shipmentID) {
		this.shipmentID = shipmentID;
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


	
}
