package com.itecheasy.common.util;

import java.util.Random;

public class StringUtils {
    /**
     * 对字符串按一定长度进行补齐 例：str="956", pad='0', lenght=10, 则在字符串"956"前补齐"0",
     * 补齐后一共10位, 返回"0000000956"
     *
     * @param str    待补齐的字符串
     * @param pad    前面填充的字符
     * @param length 填充后的长度
     * @return
     */
    public static String fillString(String str, char pad, int length) {
        int i = str.getBytes().length;
        if (i > length) {
        	 throw new RuntimeException(str + " is larger than " + length);
        }

        int j = length - i; // 前面要补齐的个数

        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < j; k++) {
            sb.append(pad);
        }

        sb.append(str);

        return sb.toString();
    }
    
    /**
     * 用chars中的字符生成length位随机的字符串
     * @param length
     * @param chars
     * @return
     */
    public static String random(int length, char[] chars) {
    	StringBuffer sb = new StringBuffer();
    	
    	Random r = new Random();
    	for(int i=0;i<length;i++) {
    		sb.append(chars[r.nextInt(chars.length)]);
    	}
    	
    	return sb.toString();
    }
    
    /**
	 * 判断字符串是否为空(为null和空字符串表示空)
	 * @return true表示空,false表示非空
	 */
	public static boolean isEmpty(String str)
	{
		return str == null || str.isEmpty();
	}
	
	public static boolean isNotEmpty(String str){
		return org.apache.commons.lang.StringUtils.isNotEmpty(str);
	}
	
	
	/**
	 * 获得字符串对象的字符串，如果对象为null，则返回空字符串,如果对象不为null，则是本身
	 * @param text
	 * @return 字符串，如果对象为null，则返回空字符串
	 */
	public static String convertEmptyStringOfNull(String text){
		if( text == null) return "";
		return text;
	}
	
	/**
	 * 将字符串转义成SQL可用的字符串
	 * @param str
	 * @return
	 */
	public static String tranSQLString(String str)
	{
		if( str == null) return null;
		
		return str.replace("'", "''");
	}
	
	/**
	 * 判断字符串是否含有中文
	 * @param str
	 * @return
	 * boolean
	 */
	public static boolean haveChinaChar(String str)
	{
	    boolean flag = false;
	    for(int i = 0; i < str.length(); i++)
	    {
	        char c = str.charAt(i);
	        if(c >= 0x0391 && c <= 0xFFE5)
	        {
	            flag = true;
	            break;
	        }
	    }
	    
	    return flag;
	}
	
	/**
	 * 英文字符串  字母 + 标点符号+ 空白字符
	 * @param str
	 * @return
	 * boolean
	 */
	public static boolean isEnString(String str)
	{
	    return str.matches("[\\w\\p{Punct}\\s]+");
	}
	
	
	public static String getNum2Word(int n) {
	    char[] buf = new char[(int) Math.floor(Math.log(25 * (n + 1)) / Math.log(26))];
	    for (int i = buf.length - 1; i >= 0; i--) {
	        n--;
	        buf[i] = (char) ('A' + n % 26);
	        n /= 26;
	    }
	    return new String(buf);
	}
	
	private final static int COPY_MIN_A=65;
	public static int getWord2Num(String word) {
		char[] value = word.toCharArray();
		int result=0;
		for (int j = 0; j < value.length; j++) {
			result = result * 26 + value[j] - COPY_MIN_A + 1;
		}
		return result;
	}
	
	
//	public static void main(String[] args)
//    {
//        String str = "hello, world 中国";
//        System.out.println(haveChinaChar(str));
//    }
}
