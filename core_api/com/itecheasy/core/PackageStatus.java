package com.itecheasy.core;

/** 
 * @author wanghw
 * @date 2016-2-18 
 * @description 包裹跟踪状态
 * @version 1.1.7
 */
public class PackageStatus {
	/**
	 * 包裹跟踪状态
	 * 
	 * @author wanghw
	 * 
	 */
	public enum PackageTraceStatus {
		/**
		 * 在途
		 */
		IN_TRANSIT("在途"),
		/**
		 * 上网
		 */
		UPPER_WIRE("上网"),
		/**
		 * 离港
		 */
		DEPARTURE_FROM_PORT("离港"),
		/**
		 * 到达目的国家
		 */
		ARRIVE_AT_THE_DESTINATION_COUNTRIES("到达目的国家"),
		/**
		 * 清关中
		 */
		CLEARANCE("清关中"),
		/**
		 * 派送
		 */
		SEND("派送"),
		/**
		 * 未妥投
		 */
		NOT_DELIVERY("未妥投"),
		/**
		 * 签收
		 */
		SIGN_FOR("签收"),
		/**
		 * 确认
		 */
		CONFIRM("确认");
		private final String enName;

		private PackageTraceStatus(String enName) {
			this.enName = enName;
		}

		public static PackageTraceStatus getStatus(int val){
			for (PackageTraceStatus st : PackageTraceStatus.values()) {
				if(st.ordinal()==val){
					return st;
				}
			}
			return null;
		}
		
		public String getEnName() {
			return enName;
		}
	}

	public static PackageTraceStatus convertPackageStatus(String dmsPackageStatus) throws BussinessException {
		if ("IN_TRANSIT".equals(dmsPackageStatus)) {
			return PackageTraceStatus.IN_TRANSIT;
		} else if ("UPPER_WIRE".equals(dmsPackageStatus)) {
			return PackageTraceStatus.UPPER_WIRE;
		} else if ("DEPARTURE_FROM_PORT".equals(dmsPackageStatus)) {
			return PackageTraceStatus.DEPARTURE_FROM_PORT;
		} else if ("ARRIVE_AT_THE_DESTINATION_COUNTRIES".equals(dmsPackageStatus)) {
			return PackageTraceStatus.ARRIVE_AT_THE_DESTINATION_COUNTRIES;
		} else if ("CLEARANCE".equals(dmsPackageStatus)) {
			return PackageTraceStatus.CLEARANCE;
		} else if ("SEND".equals(dmsPackageStatus)) {
			return PackageTraceStatus.SEND;
		} else if ("NOT_DELIVERY".equals(dmsPackageStatus)) {
			return PackageTraceStatus.NOT_DELIVERY;
		} else if ("SIGN_FOR".equals(dmsPackageStatus)) {
			return PackageTraceStatus.SIGN_FOR;
		} else if ("CONFIRM".equals(dmsPackageStatus)) {
			return PackageTraceStatus.CONFIRM;
		}
//		throw new BussinessException("DMS包裹状态不对！");
		return null;
	}
}
