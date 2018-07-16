package com.itecheasy.common.util;

public class SqlUtil {

	/**
	 * 生成字符串的模糊查询
	 * @param name
	 * @return
	 */
	public static String escapeLike(String name){
		return  " '%" + name.replace("/", "//").replace("%", "/%").replace("_", "/_").replace("'", "''") + "%' escape '/' ";
	}
	
	/**
	 * 生成字符串的前序模糊查询
	 * @param name
	 * @return
	 */
	public static String escapeSuffixLike(String name){
		return  " '" + name.replace("/", "//").replace("%", "/%").replace("_", "/_").replace("'", "''") + "%' escape '/' ";
	}
	
	/**
	 * 生成转义后的查询字符串
	 * @param name
	 * @return
	 */
	public static String escapeString(String name){
		return  " '" + name.replace("'", "''") + "' ";
	}
	
}
