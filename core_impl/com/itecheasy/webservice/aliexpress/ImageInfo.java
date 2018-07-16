package com.itecheasy.webservice.aliexpress;

/**
 * @author wanghw
 * @date 2014-6-10 上午8:56:14
 * @description 图片信息
 */
public class ImageInfo {
	private String pictureGroupId;
	private String pictureCode;
	private String url;
	private String iid;
	private String referenceCount;
	private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getReferenceCount() {
		return referenceCount;
	}

	public void setReferenceCount(String referenceCount) {
		this.referenceCount = referenceCount;
	}

	public String getPictureGroupId() {
		return pictureGroupId;
	}

	public void setPictureGroupId(String pictureGroupId) {
		this.pictureGroupId = pictureGroupId;
	}

	public String getPictureCode() {
		return pictureCode;
	}

	public void setPictureCode(String pictureCode) {
		this.pictureCode = pictureCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIid() {
		return iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

}
