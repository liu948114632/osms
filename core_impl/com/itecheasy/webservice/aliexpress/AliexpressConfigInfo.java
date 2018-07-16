package com.itecheasy.webservice.aliexpress;

import java.util.Date;

public class AliexpressConfigInfo {

	// private static String appKey = "46200918";
	// private static String appSecret = "LKk1Ap07KRv";
	// private static String redirect_uri = "http://localhost:17080";
	// private static String refreshToken =
	// "6b185312-ae5e-4527-8473-696f1033c9c1";

	private String appName;
	private String appKey;
	private String appSecret;
	private String refreshToken;
	private Date refreshTokenTimeOut;
	private int callTime;
	private int devId;

	public int getDevId() {
		return devId;
	}

	public void setDevId(int devId) {
		this.devId = devId;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Date getRefreshTokenTimeOut() {
		return refreshTokenTimeOut;
	}

	public void setRefreshTokenTimeOut(Date refreshTokenTimeOut) {
		this.refreshTokenTimeOut = refreshTokenTimeOut;
	}

	public int getCallTime() {
		return callTime;
	}

	public void setCallTime(int callTime) {
		this.callTime = callTime;
	}

}
