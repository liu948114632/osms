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
 * @date 2015-3-25
 * @description TODO
 * @version
 */
@Entity
@Table(name = "am_shop_product")
public class AMShopProductPo {
	private int id;
	private Integer productId;
	private String cmsProductCode;
	private int shopId;
	private String Sku;
	private String upc;
	private String productType;
	private String browseNode;
	private BigDecimal price;
	private Boolean contentStatus;
	private int uploadStatus;
	private Boolean shelveStatus;
	private String productName;
	private String productContent;
	private Date time;
	private int operator;
	private String brandName;
	private String skuEnd;
	private int groupId;

	private Date productNameLastUpdateTime;
	private Date productContentLastUpdateTime;

	@Column(name="product_name_last_update_time")
	public Date getProductNameLastUpdateTime() {
		return productNameLastUpdateTime;
	}

	public void setProductNameLastUpdateTime(Date productNameLastUpdateTime) {
		this.productNameLastUpdateTime = productNameLastUpdateTime;
	}

	@Column(name="product_content_last_update_time")
	public Date getProductContentLastUpdateTime() {
		return productContentLastUpdateTime;
	}

	public void setProductContentLastUpdateTime(Date productContentLastUpdateTime) {
		this.productContentLastUpdateTime = productContentLastUpdateTime;
	}

	@Column(name = "group_id")
	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	@Column(name = "brand_name")
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "product_id")
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Column(name = "cms_product_code")
	public String getCmsProductCode() {
		return cmsProductCode;
	}

	public void setCmsProductCode(String cmsProductCode) {
		this.cmsProductCode = cmsProductCode;
	}

	@Column(name = "shop_id")
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Column(name = "sku")
	public String getSku() {
		return Sku;
	}

	public void setSku(String sku) {
		Sku = sku;
	}

	@Column(name = "upc")
	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	@Column(name = "product_type")
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Column(name = "browse_node")
	public String getBrowseNode() {
		return browseNode;
	}

	public void setBrowseNode(String browseNode) {
		this.browseNode = browseNode;
	}

	@Column(name = "price")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "content_status")
	public Boolean getContentStatus() {
		return contentStatus;
	}

	public void setContentStatus(Boolean contentStatus) {
		this.contentStatus = contentStatus;
	}

	@Column(name = "upload_status")
	public int getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(int uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	@Column(name = "product_name")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "product_content")
	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	@Column(name = "time")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "operator")
	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	@Column(name = "shelve_status")
	public Boolean getShelveStatus() {
		return shelveStatus;
	}

	public void setShelveStatus(Boolean shelveStatus) {
		this.shelveStatus = shelveStatus;
	}

	@Column(name = "sku_end")
	public String getSkuEnd() {
		return skuEnd;
	}

	public void setSkuEnd(String skuEnd) {
		this.skuEnd = skuEnd;
	}

}
