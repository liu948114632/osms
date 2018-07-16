package com.itecheasy.common.util;

import java.util.HashMap;
import java.util.Map;

public class ConstantUtils {

	// 网店title
	public static final int SMT_TITLE_TYPE = 1;
	public static final int EBAY_TITLE_TYPE = 2;
	public static final int AMAZON_TITLE_TYPE = 3;

	public static final String FULFILLMENTCHANNELS_MFN = "MFN";
	public static final String FULFILLMENTCHANNELS_AFN = "AFN";

	private static Map<String, String> SpecialPhoneticMap = null;

	public  static Map<String, String> getSpecialPhoneticMap() {
		if (SpecialPhoneticMap == null) {
			SpecialPhoneticMap = new HashMap<String, String>();
			SpecialPhoneticMap.put("ö", "oe");
			SpecialPhoneticMap.put("ä", "ue");
			SpecialPhoneticMap.put("ü", "oe");
			SpecialPhoneticMap.put("ß", "ss");
			SpecialPhoneticMap.put("Ä", "ue");
			SpecialPhoneticMap.put("Ö", "oe");
			SpecialPhoneticMap.put("Ü", "oe");
		}
		return SpecialPhoneticMap;
	}

	public static void setSpecialPhoneticMap(Map<String, String> specialPhoneticMap) {
		SpecialPhoneticMap = specialPhoneticMap;
	}

}
