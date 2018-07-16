package com.itecheasy.common.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-6-25
 * @description TODO
 * @version
 */
@Entity
@Table(name="am_shop_upload_file_data")
public class AMShopUploadFileDataPO {
	private int id;
	private boolean imageUploadStatus;
	private int AMShopUploadFileTaskID;
	private int productId;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="image_upload_status")
	public boolean isImageUploadStatus() {
		return imageUploadStatus;
	}

	public void setImageUploadStatus(boolean imageUploadStatus) {
		this.imageUploadStatus = imageUploadStatus;
	}

	@Column(name="upload_file_id")
	public int getAMShopUploadFileTaskID() {
		return AMShopUploadFileTaskID;
	}

	public void setAMShopUploadFileTaskID(int aMShopUploadFileTaskID) {
		AMShopUploadFileTaskID = aMShopUploadFileTaskID;
	}

	@Column(name="image_product_id")
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
