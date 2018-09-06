package com.itecheasy.core.report;

import java.util.List;

/**
 * @author taozihao
 * @date 2018年9月3日 下午4:48:00
 * @description 亚马逊报告自动任务服务
 */
public interface AmazonReportTaskService {
	/**
	 * 获取所有自动任务报告的店铺配置信息
	 * 
	 * @return List<ReportAutotaskShopConfigVO> 店铺报告配置信息
	 */
	public List<ReportAutotaskShopConfigVO> getReportAutotaskShopConfigList();

	/**
	 * 获取所有要跑报告的自动任务（失败次数小于3，并且是非完成状态的）
	 * 
	 * @return List<ReportAutotaskRecordVO>
	 */
	public List<ReportAutotaskRecordVO> getReportAutotaskRecordList();

	/**
	 * 获取给定参数的数量的报告的自动任务（失败次数小于3，并且是非完成状态的）
	 * 
	 * @return List<ReportAutotaskRecordVO>
	 */
	public List<ReportAutotaskRecordVO> getReportAutotaskRecordLimit(int limit);

	/**
	 * 增加一条报告的自动任务记录
	 * 
	 * @param reportAutotaskRecordVO
	 */
	public void addReportAutotaskRecord(ReportAutotaskRecordVO reportAutotaskRecordVO);
	
	/**
	 * 为该条记录下载报告
	 * 
	 * @param reportAutotaskRecordVO
	 */
	public void downloadReportFromAmazon(ReportAutotaskRecordVO reportAutotaskRecordVO);

	public enum ReportTaskStatus {
		
		TODO(0), DONE(1), ERROR(2);
		
		private int val;

		public int getVal() {
			return val;
		}

		private ReportTaskStatus(int val) {
			this.val = val;
		}
	}
}
