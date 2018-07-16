package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "product_picture_collection")
public class ProductPictureCollectionPO {
	private Integer id;
	private Integer productId;
	private Integer type;
	private String pictureCode;
	private String pictureName;
	private Integer orderIndex;
	private String cmsProductCode;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="product_id")
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	@Column(name="type")
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Column(name="picture_code")
	public String getPictureCode() {
		return pictureCode;
	}
	public void setPictureCode(String pictureCode) {
		this.pictureCode = pictureCode;
	}
	@Column(name="picture_name")
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	
 	@Column(name="order_index")
	public Integer getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}
	
	@Column(name="cms_product_code")
	public String getCmsProductCode() {
		return cmsProductCode;
	}
	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}
	
}
