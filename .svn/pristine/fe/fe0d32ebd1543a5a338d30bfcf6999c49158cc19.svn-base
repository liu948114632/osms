package com.itecheasy.communication.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class UuidHelp {
	private static final long Day_Milliseconds = 24L * 60L * 60L * 1000L;
	private static final double Mill_Ratio = 3.333333d;
	private static final DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

	/**
	 * 从UUID获取时间
	 * 
	 * @param uuidString
	 *            UUID String
	 * @return
	 */
	public static Date getDateFromUuid(String uuidString) {
		UUID uuid = UUID.fromString(uuidString);
		byte[] guidArray = UUIDtoBytes(uuid);
		byte[] daysArray = new byte[4];
		byte[] msecsArray = new byte[5];

		copyArray(guidArray, guidArray.length - 7, daysArray, 2, 2);
		copyArray(guidArray, guidArray.length - 5, msecsArray, 0, 5);

		daysArray = reverseBytes(daysArray);
		msecsArray = reverseBytes(msecsArray);
		
		byte[] longArray = new byte[8];
		copyArray(msecsArray, 0, longArray, 0, 5);
        
		int days = bytesToInt(daysArray);//与1900,1.1相差天数
		long msecs = bytesToLong(longArray);//与1900,1.1相差时间
		msecs = msecs/10000;//java只能精确到毫秒，而之前保留的是.net的Ticks
	
		Date minDate = getDate("1900/01/01");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(minDate);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		calendar.add(Calendar.MILLISECOND, (int)msecs);

		return calendar.getTime();
	}

	/**
	 * 获取包含时间信息的UUID
	 */
	public static UUID getDateUuid() {
		UUID uuid = UUID.randomUUID();
		byte[] uuidArray = UUIDtoBytes(uuid);

		Date minDate = getDate("1900/01/01");
		Date now = new Date();
		Date shortNow = getDate(df.format(now));
		
		//当前时间与1900年1月1日相差天数
		Integer days = Integer.parseInt(String.valueOf((now.getTime() - minDate.getTime()) / Day_Milliseconds));
		
		//当前时间毫秒数(去掉了年月日的毫秒数),乘上10000以后变为.net的Ticks单位
		Long msecs = (now.getTime() - shortNow.getTime())*10000;//Math.round((((double) (now.getTime() - shortNow.getTime()))));
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(now));
		byte[] daysArray = intToByte(days);
		byte[] msecsArray = longToByte(msecs);
		
		daysArray = reverseBytes(daysArray);
		msecsArray = reverseBytes(msecsArray); 

		copyArray(daysArray, daysArray.length - 2, uuidArray,
				uuidArray.length - 7, 2);
		copyArray(msecsArray, 3, uuidArray,
				uuidArray.length - 5, 5);

		return bytesToUUID(uuidArray);
	}

	private static Date getDate(String d) {
		try {
			return df.parse(d);
		} catch (ParseException e) {
			return null;
		}
	}

	private static UUID bytesToUUID(byte[] data) {
		long msb = 0;
		long lsb = 0;
		for (int i = 0; i < 8; i++) {
			msb = (msb << 8) | (data[i] & 0xff);
		}
		for (int i = 8; i < 16; i++) {
			lsb = (lsb << 8) | (data[i] & 0xff);
		}
		return new UUID(msb, lsb);
	}

	private static byte[] UUIDtoBytes(UUID uuid) {
		long msb = uuid.getMostSignificantBits();
		long lsb = uuid.getLeastSignificantBits();
		byte[] buffer = new byte[16];
		for (int i = 0; i < 8; i++) {
			buffer[i] = (byte) (msb >>> 8 * (7 - i));
		}
		for (int i = 8; i < 16; i++) {
			buffer[i] = (byte) (lsb >>> 8 * (7 - i));
		}
		return buffer;
	}

	private static void copyArray(byte[] sourceArray, int sourceIndex,
			byte[] destinationArray, int destinationIndex, int length) {
		for (int i = 0; i < length; i++) {
			destinationArray[destinationIndex + i] = sourceArray[sourceIndex
					+ i];
		}
	}

	private static byte[] reverseBytes(byte[] byteArray) {
		byte[] temp = new byte[byteArray.length];
		int sIndex = byteArray.length - 1;
		for (int i = 0; i < byteArray.length; i++) {
			temp[sIndex - i] = byteArray[i];
		}
		return temp;
	}

	/*private static String bytesToString(byte[] bytes) {
		BASE64Encoder enc = new BASE64Encoder();
		return enc.encode(bytes);
	}*/

	private static byte[] intToByte(int i) {
		byte[] bt = new byte[4];
		bt[0] = (byte) (0xff & i);
		bt[1] = (byte) ((0xff00 & i) >> 8);
		bt[2] = (byte) ((0xff0000 & i) >> 16);
		bt[3] = (byte) ((0xff000000 & i) >> 24);
		return bt;
	}

	private static int bytesToInt(byte[] bytes) {
		int num = bytes[0] & 0xFF;
		num |= ((bytes[1] << 8) & 0xFF00);
		num |= ((bytes[2] << 16) & 0xFF0000);
		num |= ((bytes[3] << 24) & 0xFF000000);
		return num;
	}

	private static long bytesToLong(byte[] b) {
		long l = 0L;
		l = b[0] & 0xff;
		l |= ((long) (b[1] & 0xff) << 8) ;
		l |= ((long) (b[2] & 0xff) << 16);
		l |= ((long) (b[3] & 0xff) << 24);
		l |= ((long) (b[4] & 0xff) << 32);
		l |= ((long) (b[5] & 0xff) << 40);
		l |= ((long) (b[6] & 0xff) << 48);
		l |= ((long) (b[7] & 0xff) << 56);
		return l;
	}

	private static byte[] longToByte(long number) {
		long temp = number;
		byte[] b = new byte[8];
		for (int i = 0; i < b.length; i++) {
			b[i] = new Long(temp & 0xff).byteValue();// 将最低位保存在最低位
			temp = temp >> 8; // 向右移8位
		}
		return b;
	}  
	 
	
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String x = getDateUuid().toString();
		System.out.println(x);
		System.out.println(df.format(getDateFromUuid(x)));
		System.out.println(df.format(getDateFromUuid("7e0ead47-22ea-4166-b29f-c95108efc67f")));
	}
}
