package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-6-26
 * @description TODO
 * @version
 */
@Entity
@Table(name = "order_delivery_task")
public class OrderDeliveryTaskPO {
	private int id;
	private String orderId;

	/**
	 * 任务状态 ：0、新建 1、已执行 2、上传失败
	 */
	private int status;
	private Date createTime;
	private int uploadCount;
	private int shopId;

	private int shopType;

	@Column(name="shop_type")
	public int getShopType() {
		return shopType;
	}

	public void setShopType(int shopType) {
		this.shopType = shopType;
	}

	@Column(name = "shop_id")
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Column(name = "upload_count")
	public int getUploadCount() {
		return uploadCount;
	}

	public void setUploadCount(int uploadCount) {
		this.uploadCount = uploadCount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "order_id")
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Column
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
