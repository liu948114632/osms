package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.*;

import com.itecheasy.core.PackageStatus.PackageTraceStatus;

/**
 * @author wanghw
 * @date 2016-2-18
 * @description 问题件列表
 * @version 1.1.7
 */
@Entity
@Table(name = "v_package_problem")
public class VPackageProblemPO {
	private int id;
	private int status;
	private String orderCode;
	private int orderId;
	private boolean read;
	private String createUser;
	private Date createDate;
	private String closeUser;
	private Date closeDate;
	private String deliveryCustomerService;
	private String remark;

	private String customerAccount;
	private String customerName;
	private String phone;
	private PackageTraceStatus packageStatus;
	private String trackingCode;
	private Date deliveryDate;
	private String merchandiserName;
	private int shippingMethod;
	private Integer country;
	private String merchandiserCode;
	
	private int type;
	private String confirmType;

	@Column(name="confirm_type")
	public String getConfirmType() {
		return confirmType;
	}

	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
	
	@Column
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name="merchandiser_code")
	public String getMerchandiserCode() {
		return merchandiserCode;
	}

	public void setMerchandiserCode(String merchandiserCode) {
		this.merchandiserCode = merchandiserCode;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "order_code")
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Column(name = "order_id")
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Column(name = "read")
	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	@Column(name = "create_user_name")
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "close_user_name")
	public String getCloseUser() {
		return closeUser;
	}

	public void setCloseUser(String closeUser) {
		this.closeUser = closeUser;
	}

	@Column(name = "close_date")
	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "customer_account")
	public String getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
	}

	@Column(name = "customer_name")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "package_status")
	public PackageTraceStatus getPackageStatus() {
		return packageStatus;
	}

	public void setPackageStatus(PackageTraceStatus packageStatus) {
		this.packageStatus = packageStatus;
	}

	@Column(name = "tracking_code")
	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	@Column(name = "delivery_date")
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
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

	@Column(name = "shipping_method")
	public int getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(int shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	@Column(name = "country_id")
	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

}
