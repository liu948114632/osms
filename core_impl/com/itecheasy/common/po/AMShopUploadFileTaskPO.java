package com.itecheasy.common.po;

import java.util.Date;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-6-25
 * @description TODO
 * @version
 */
@Entity
@Table(name="am_shop_upload_file_task")
public class AMShopUploadFileTaskPO {
	private int id;
	private String fileData;
	private int amShopUploadLogId;
	private Date createDate;
	private int type;
	private int status;
	private String fileLocal;
	private int shopId;
	
	@Column(name="shop_id")
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="file_data")
	public String getFileData() {
		return fileData;
	}

	public void setFileData(String fileData) {
		this.fileData = fileData;
	}

	@Column(name="am_shop_upload_log_id")
	public int getAmShopUploadLogId() {
		return amShopUploadLogId;
	}

	public void setAmShopUploadLogId(int amShopUploadLogId) {
		this.amShopUploadLogId = amShopUploadLogId;
	}

	@Column(name="create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="file_local")
	public String getFileLocal() {
		return fileLocal;
	}

	public void setFileLocal(String fileLocal) {
		this.fileLocal = fileLocal;
	}

}
