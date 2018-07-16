package com.itecheasy.communication.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

public class XmlUtils {
	public static final String HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	private static final String STRING_START = "<![CDATA[";
	private static final String STRING_END = "]]>";
	private static final String EMPTY = "";

	public static <T> String entityToXml(T item, String[] ignoreParams) {
		return entityToXml(item, ignoreParams, false);
	}

	public static <T> String entityToXml(T item, String[] ignoreParams,
			boolean appendHeader) {
		Method[] getMethods = item.getClass().getDeclaredMethods();
		StringBuilder sb = new StringBuilder();
		if (appendHeader) {
			sb.append(HEADER);
		}
		String name = item.getClass().getName();
		name = name.substring(name.lastIndexOf(".") + 1, name.length());
		try {
			sb.append("<").append(name).append(">");
			String mName;
			String fieldName;
			Object o;
			String value;
			for (Method m : getMethods) {
				mName = m.getName();
				if (mName.startsWith("get")) {
					fieldName = mName.substring(3);
				} else if (mName.startsWith("is")) {
					fieldName = mName.substring(2);
				} else {
					continue;
				}
				if (containString(ignoreParams, fieldName)) {
					continue;
				}

				o = m.invoke(item, new Object[] {});
				value = o == null ? EMPTY : o.toString();
				if (o instanceof String && StringUtils.isNotEmpty(value)) {
					value = STRING_START + value + STRING_END;
				}
				sb.append("<").append(fieldName).append(">").append(value)
						.append("</").append(fieldName).append(">");
			}
			sb.append("</").append(name).append(">");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String getCDataXml(CData cData) {
		return XmlUtils.entityToXml(cData, new String[] { "filePath",
				"fileName", "operateData" });
	}

	/**
	 * XML转换为实体对象
	 * 
	 * @param xml
	 * 
	 * @return
	 */
	public static CData xmlToEntity(String xml) {
		return xmlToEntity(xml, new String[] { "filePath", "fileName",
				"operateData" });
	}

	public static CData xmlToEntity(String xml, String[] ignoreParams) {
		CData cData = new CData();
		String name = cData.getClass().getName();
		name = name.substring(name.lastIndexOf(".") + 1, name.length());
		try {
			Document xmlDom = DocumentHelper.parseText(xml);
			Node node = xmlDom.selectSingleNode("/" + name);		
			XmlToEntity(node, cData, ignoreParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cData;
	}

	private static void XmlToEntity(Node node, CData cData,
			String[] ignoreParams) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method[] methods = cData.getClass().getDeclaredMethods();
		List<Method> getMethods = getMethodsOfGet(methods);
		List<Method> setMethods = getMethodsOfSet(methods);
		String mName;
		String fieldName;
		Method setMethod;
		String noedeValue;
		for (Method m : getMethods) {
			mName = m.getName();
			if (mName.startsWith("get")) {
				fieldName = mName.substring(3);
			} else if (mName.startsWith("is")) {
				fieldName = mName.substring(2);
			} else {
				continue;
			}
			if (containString(ignoreParams, fieldName)) {
				continue;
			}

			Node cnode = node.selectSingleNode(fieldName);
			if (cnode == null) {
				continue;
			}
			noedeValue = cnode.getText();
			if (noedeValue == null) {
				continue;
			}
			setMethod = findMethod(setMethods, "set" + fieldName);
			if (setMethod != null) {
				setMethod.invoke(cData, new Object[] { convertObject(m.getReturnType().getName(), noedeValue)});
			}
		}
	}

	private static Method findMethod(List<Method> methods, String methodName) {
		for (Method m : methods) {
			if (m.getName().equalsIgnoreCase(methodName)) {
				return m;
			}
		}
		return null;
	}

	private static List<Method> getMethodsOfGet(Method[] methods) {
		List<Method> methodsOfGet = new LinkedList<Method>();
		for (Method m : methods) {
			if (m.getName().startsWith("get") || m.getName().startsWith("is")) {
				methodsOfGet.add(m);
			}
		}
		return methodsOfGet;
	}

	private static List<Method> getMethodsOfSet(Method[] methods) {
		List<Method> methodsOfSet = new LinkedList<Method>();
		for (Method m : methods) {
			if (m.getName().startsWith("set")) {
				methodsOfSet.add(m);
			}
		}
		return methodsOfSet;
	}

	private static boolean containString(String[] strArr, String str) {
		if (strArr == null || strArr.length == 0) {
			return false;
		}
		for (String s : strArr) {
			if (str.equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	private static Object convertObject(String targetClassName, String s) {	
		if (String.class.getName().equals(targetClassName)) {
			return s;
		}
		if (Integer.class.getName().equals(targetClassName) || int.class.getClass().equals(targetClassName)) {
			return Integer.parseInt(s);
		}
		if (Boolean.class.getName().equals(targetClassName) || boolean.class.getClass().equals(targetClassName)) {
			return Boolean.parseBoolean(s);
		}
		if(Date.class.getName().equals(targetClassName)){
			return Date.parse(s);
		}
		return s;
	}
	
	
	/** 
     * 把中文转成Unicode码  2<sup>11</sup> <sub>当我永别了战友的时候</sub>
     * @param str 
     * @return 
     */  
    public static String chinaToUnicode(String str){
//    	if (StringUtils.isEmpty(str)) {
//			return "";
//		}
//        String result="";  
//        String tmp;
//        char c;
//        int j;
//        for (int i = 0; i < str.length(); i++){  
////            int chr1 = (char) str.charAt(i);  
////            if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)  
//            if(isChinese(str.charAt(i))){//汉字范围 \u4e00-\u9fa5 (中文)  
//            	c = str.charAt(i);
//            	result+="\\u";
//    			j = (c >>> 8); // 取出高8位
//    			tmp = Integer.toHexString(j);
//    			if (tmp.length() == 1)
//    				result+="0";
//    			result+=tmp;
//    			j = (c & 0xFF); // 取出低8位
//    			tmp = Integer.toHexString(j);
//    			if (tmp.length() == 1)
//    				result+="0";
//    			result+=tmp;
//            }else{  
//                result+=str.charAt(i);  
//            }  
//        }  
//        return result;  
    	return string2Unicode(str);
    }   
  
    /** 
     * 判断是否为中文字符 
     * @param c 
     * @return 
     */  
    public  static boolean isChinese(char c) {  
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                ||ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                ||c <= '\u001F' ||
				c >= '\u007F' ||
				c == '<' ||
						c == '\t' ) {  
            return true;  
        }  
        return false;  
    }
    

/**
 * 字符串转换unicode
 */
public static String string2Unicode(String str) {

    StringBuffer unicode = new StringBuffer();
    for (int i = 0; i < str.length(); i++) {
        // 取出每一个字符
        char c = str.charAt(i);
        String t = Integer.toHexString(c);
        if(isChinese(c)){
        	switch (4 - t.length()) {
        	case 0:
        		unicode.append("\\u" + t);
        		break;
        	case 1:
        		t = "0" + t;
        		unicode.append("\\u" + t);
        		break;
        	case 2:
        		t = "00" + t;
        		unicode.append("\\u" + t);
        		break;
        	case 3:
        	default:
        		t = String.valueOf(c);
        		unicode.append(t);
        		break;
        	}
		}else{
			unicode.append(c);
		}
    }
    return unicode.toString();
}


public static void main(String[] args) {
	System.out.println(chinaToUnicode("，,aº昨天"));
}

}
