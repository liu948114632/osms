package com.itecheasy.core.system;

import java.util.Date;

/**
 * @author wanghw
 * @date 2015-6-16
 * @description TODO
 * @version
 */
public class ShopDevInfo {
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

	private Date tokenTimeOut;

	public Date getTokenTimeOut() {
		return tokenTimeOut;
	}

	public void setTokenTimeOut(Date tokenTimeOut) {
		this.tokenTimeOut = tokenTimeOut;
	}

	public String getDeveloperID() {
		return DeveloperID;
	}

	public void setDeveloperID(String developerID) {
		DeveloperID = developerID;
	}

	public String getApplicationID() {
		return ApplicationID;
	}

	public void setApplicationID(String applicationID) {
		ApplicationID = applicationID;
	}

	public String getCertificateID() {
		return CertificateID;
	}

	public void setCertificateID(String certificateID) {
		CertificateID = certificateID;
	}

	public Date getLastUpdatedAfter() {
		return lastUpdatedAfter;
	}

	public void setLastUpdatedAfter(Date lastUpdatedAfter) {
		this.lastUpdatedAfter = lastUpdatedAfter;
	}

	public String getServiceURL() {
		return serviceURL;
	}

	public void setServiceURL(String serviceURL) {
		this.serviceURL = serviceURL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getAccessSecretKey() {
		return accessSecretKey;
	}

	public void setAccessSecretKey(String accessSecretKey) {
		this.accessSecretKey = accessSecretKey;
	}

	public String getSellerID() {
		return sellerID;
	}

	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarketplaceID() {
		return marketplaceID;
	}

	public void setMarketplaceID(String marketplaceID) {
		this.marketplaceID = marketplaceID;
	}

}
