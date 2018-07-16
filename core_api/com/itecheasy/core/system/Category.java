package com.itecheasy.core.system;

import java.math.BigDecimal;

/**
 * @author wanghw
 * @date 2015-3-28
 * @description TODO
 * @version
 */
public class Category {
	private int id;
	private String invoiceEnName;
	private int level;
	private String name;
	private int parentID;

	private String description;
	private String invoiceCnName;
	private BigDecimal packageVolumeRate;
	private BigDecimal volumeRate;
	private BigDecimal weightRate;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInvoiceCnName() {
		return invoiceCnName;
	}

	public void setInvoiceCnName(String invoiceCnName) {
		this.invoiceCnName = invoiceCnName;
	}

	public BigDecimal getPackageVolumeRate() {
		return packageVolumeRate;
	}

	public void setPackageVolumeRate(BigDecimal packageVolumeRate) {
		this.packageVolumeRate = packageVolumeRate;
	}

	public BigDecimal getVolumeRate() {
		return volumeRate;
	}

	public void setVolumeRate(BigDecimal volumeRate) {
		this.volumeRate = volumeRate;
	}

	public BigDecimal getWeightRate() {
		return weightRate;
	}

	public void setWeightRate(BigDecimal weightRate) {
		this.weightRate = weightRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInvoiceEnName() {
		return invoiceEnName;
	}

	public void setInvoiceEnName(String invoiceEnName) {
		this.invoiceEnName = invoiceEnName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

}
