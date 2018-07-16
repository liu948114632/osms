package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wanghw
 * @date 2015-5-9
 * @description TODO
 * @version
 */
@Entity
@Table(name = "dbo.am_order_communication_log")
public class AMOrderCommunicationLogPo {
	private int id;
	private String amazonOrderId;
	private int status;
	private int shopId;
	private Date lastOperatorTime;
	private String remark;
	private int dowmCount;
//	private int shopDevInfoId;
//
//	@Column(name="shop_dev_info_id")
//	public int getShopDevInfoId() {
//		return shopDevInfoId;
//	}
//
//	public void setShopDevInfoId(int shopDevInfoId) {
//		this.shopDevInfoId = shopDevInfoId;
//	}

	@Column(name = "dowm_count")
	public int getDowmCount() {
		return dowmCount;
	}

	public void setDowmCount(int dowmCount) {
		this.dowmCount = dowmCount;
	}

	@Column(name = "last_operator_time")
	public Date getLastOperatorTime() {
		return lastOperatorTime;
	}

	public void setLastOperatorTime(Date lastOperatorTime) {
		this.lastOperatorTime = lastOperatorTime;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "shop_id")
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "amazon_order_id")
	public String getAmazonOrderId() {
		return amazonOrderId;
	}

	public void setAmazonOrderId(String amazonOrderId) {
		this.amazonOrderId = amazonOrderId;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
