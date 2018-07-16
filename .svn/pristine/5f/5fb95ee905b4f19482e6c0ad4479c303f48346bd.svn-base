package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description TODO
 * @version
 */
@Entity
@Table(name = "product_picture_export_log")
public class ProductPictureExportLogPo {
	private int id;
	private String cmsProductCode;
	private String imageCode;
	private String exportName;
	private Boolean isImport;
	private Date exportTime;
	private int operator;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="cms_product_code")
	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	@Column(name="image_code")
	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

	@Column(name="export_name")
	public String getExportName() {
		return exportName;
	}

	public void setExportName(String exportName) {
		this.exportName = exportName;
	}

	@Column(name="is_import")
	public Boolean getIsImport() {
		return isImport;
	}

	public void setIsImport(Boolean isImport) {
		this.isImport = isImport;
	}

	@Column(name="export_date")
	public Date getExportTime() {
		return exportTime;
	}

	public void setExportTime(Date exportTime) {
		this.exportTime = exportTime;
	}

	@Column(name="operator")
	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

}
