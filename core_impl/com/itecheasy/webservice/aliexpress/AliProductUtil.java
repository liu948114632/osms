package com.itecheasy.webservice.aliexpress;

import org.apache.log4j.Logger;



public class AliProductUtil {
	private static final Logger logger = Logger.getLogger(AliProductUtil.class);
	public static final String THE_CHARACTER_ENCODING_IS_NOT_SUPPORTED = "THE_CHARACTER_ENCODING_IS_NOT_SUPPORTED";
	public static final String CONNECTION_REFUSED_CONNECT = "CONNECTION_REFUSED_CONNECT";
	public static final String PRODUCT_DATA_MODE_ERROR = "PRODUCT_DATA_MODE_ERROR";
	public static final String UPLOAD_PRODUCT_DATA_FAIL = "UPLOAD_PRODUCT_DATA_FAIL";
	public static final String MODIFY_PRODUCT_DATA_FAIL = "MODIFY_PRODUCT_DATA_FAIL";
	public static final String RETURN_RESULT_DATA_MODE_ERROR = "RETURN_RESULT_DATA_MODE_ERROR";
	
	/**
	 * json数据格式的处理
	 * @param jsonString
	 * @return
	 */
	public static String handleJson(String jsonString){
		return jsonString.replaceAll("\"attrValueId\":0,", "").replaceAll("\"attrNameId\":0,", "")
				.replaceAll("\"attrName\":\"\",", "").replaceAll(",\"attrValue\":\"\"", "").replaceAll(",null", "")
				.replaceAll("null,", "").replace(",\"attrValue\":null", "");
	}
	
}
