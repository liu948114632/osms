package com.itecheasy.core.po;

import java.util.Date;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-6-15
 * @description 店铺开发者账号信息
 * @version
 */
@Entity
@Table(name = "shop_dev_info")
public class ShopDevInfoPO {
	private int id;
	private int type;
	private String accessKey;
	private String accessSecretKey;
	private String sellerID;
	private String token;
	private String remark;
	private String name;
	private String marketplaceID;
	private String serviceURL;
	private Date lastUpdatedAfter;

	private String DeveloperID;
	private String ApplicationID;
	private String CertificateID;

	private boolean pause;

	private Date tokenTimeOut;

	@Column(name="token_time_out")
	public Date getTokenTimeOut() {
		return tokenTimeOut;
	}

	public void setTokenTimeOut(Date tokenTimeOut) {
		this.tokenTimeOut = tokenTimeOut;
	}

	@Column
	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	@Column(name = "dev_id")
	public String getDeveloperID() {
		return DeveloperID;
	}

	public void setDeveloperID(String developerID) {
		DeveloperID = developerID;
	}

	@Column(name = "app_id")
	public String getApplicationID() {
		return ApplicationID;
	}

	public void setApplicationID(String applicationID) {
		ApplicationID = applicationID;
	}

	@Column(name = "cert_id")
	public String getCertificateID() {
		return CertificateID;
	}

	public void setCertificateID(String certificateID) {
		CertificateID = certificateID;
	}

	@Column(name = "last_updated_after")
	public Date getLastUpdatedAfter() {
		return lastUpdatedAfter;
	}

	public void setLastUpdatedAfter(Date lastUpdatedAfter) {
		this.lastUpdatedAfter = lastUpdatedAfter;
	}

	@Column
	public String getServiceURL() {
		return serviceURL;
	}

	public void setServiceURL(String serviceURL) {
		this.serviceURL = serviceURL;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getMarketplaceID() {
		return marketplaceID;
	}

	public void setMarketplaceID(String marketplaceID) {
		this.marketplaceID = marketplaceID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "access_key")
	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	@Column(name = "access_secret_key")
	public String getAccessSecretKey() {
		return accessSecretKey;
	}

	public void setAccessSecretKey(String accessSecretKey) {
		this.accessSecretKey = accessSecretKey;
	}

	@Column(name = "seller_id")
	public String getSellerID() {
		return sellerID;
	}

	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}

	@Column
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
