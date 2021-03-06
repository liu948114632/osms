package com.itecheasy.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DeployProperties {

	private static Logger logger = Logger.getLogger(DeployProperties.class);

	private static final String PROPERTIE_FILE_NAME = "deploy_config.properties";

	private static long lastModified = 0L;

	private Properties properties = null;

	private static DeployProperties instance = new DeployProperties();;

	private File file = null;

	public static DeployProperties getInstance() {
		return instance;
	}

	private DeployProperties() {
		try {
			Resource resource = new ClassPathResource(PROPERTIE_FILE_NAME);
			file = resource.getFile();
			lastModified = file.lastModified();
			if (lastModified == 0) {
				logger.error(PROPERTIE_FILE_NAME + " file does not exist!");
			}
			properties = new Properties();
			properties.load(resource.getInputStream());

		} catch (IOException e) {
			logger.error("can not read config file " + PROPERTIE_FILE_NAME);
		}
		logger.info(PROPERTIE_FILE_NAME + " loaded.");
	}

	public final String getProperty(String key) {
		return getProperty(key, StringUtils.EMPTY);
	}

	public final String getProperty(String key, String defaultValue) {
		long newTime = file.lastModified();
		if (newTime == 0) {
			return defaultValue;
		} else if (newTime > lastModified) {
			try {
				properties.clear();
				Resource resource = new ClassPathResource(PROPERTIE_FILE_NAME);
				properties.load(new FileInputStream(resource.getFile()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		lastModified = newTime;
		return properties.getProperty(key) == null ? defaultValue : properties
				.getProperty(key);
	}

	public String getOAURL() {
		return getProperty("oa.webservice.url");
	}

	public String getOAPinCode() {
		return getProperty("oa.webservice.pinCode");
	}

	public String getCMSURL() {
		return getProperty("cms.webservice.url");
	}
	
	public String getSWURL() {
		return getProperty("sw.webservice.url");
	}

	public String getCMSPinCode() {
		return getProperty("jxt.webservice.username");
	}

	public String getTempUploadFilePath() {
		return getProperty("temp_upload_path");
	}

	/**
	 * 获取需要同步亚马逊库龄的店铺
	 * @return
	 */
	public String getSyncAmazonAgedShops() {
		return getProperty("sync.amazon.aged.item");
	}


	public String getExcelPictureUrl(){
		return getProperty("excel_img_url");
	}
	
	public int getFBAOrderSalesInfostatisticDays(){
		try {
			return  Integer.valueOf(getProperty("FBAOrderSalesInfostatisticDays","30"));
		} catch (NumberFormatException e) {
			return 30;
		}
	}
	
	public int getAllOrderSalesInfostatisticDays(){
		try {
			return  Integer.valueOf(getProperty("AllOrderSalesInfostatisticDays","45"));
		} catch (NumberFormatException e) {
			return 45;
		}
	}

	public String getAliExpressHost() {
		return getProperty("aliexpress.api.host");
	}
	
	public String getAliExpressPort() {
		return String.valueOf(getProperty("aliexpress.api.port"));
	}

	public String getAliExpressRedirectUri() {
		return getProperty("aliexpress.api.redirectUri");
	}
	
	public List<Integer> getFbaRpCountry(){
		List<Integer> list=new ArrayList<Integer>();
		String c=getProperty("rp.sw.country");
		String[] s=c.split(",");
		for (int i = 0; i < s.length; i++) {
			list.add(Integer.valueOf(s[i]));
		}
		
		return list;
	}
}
