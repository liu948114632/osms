package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "replenishment_order_shipping_list")
public class ReplenishmentOrderShippingListPO {
	private int id;
	private int replenishmentOrderId;
	private String fileName;
	private String fileCode;
	private Date joinDate;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="replenishment_order_id")
	public int getReplenishmentOrderId() {
		return replenishmentOrderId;
	}

	public void setReplenishmentOrderId(int replenishmentOrderId) {
		this.replenishmentOrderId = replenishmentOrderId;
	}

	@Column(name = "file_name")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "file_code")
	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	@Column(name = "join_date")
	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
