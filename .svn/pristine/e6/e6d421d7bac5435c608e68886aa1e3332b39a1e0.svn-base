package com.itecheasy.core.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.core.po.ReportAutotaskRecordPO;
import com.itecheasy.core.report.dao.ReportAutotaskRecordDao;
import com.itecheasy.core.report.dao.ReportAutotaskShopConfigDao;

/**
 * @author taozihao
 * @date 2018年9月5日 上午10:08:02
 * @description
 */
public class AmazonReportTaskServiceImpl implements AmazonReportTaskService {
	
	private ReportAutotaskRecordDao reportAutotaskRecordDao;
	private ReportAutotaskShopConfigDao reportAutotaskShopConfigDao;

	public void setReportAutotaskRecordDao(ReportAutotaskRecordDao reportAutotaskRecordDao) {
		this.reportAutotaskRecordDao = reportAutotaskRecordDao;
	}

	public void setReportAutotaskShopConfigDao(ReportAutotaskShopConfigDao reportAutotaskShopConfigDao) {
		this.reportAutotaskShopConfigDao = reportAutotaskShopConfigDao;
	}

	@Override
	public List<ReportAutotaskShopConfigVO> getReportAutotaskShopConfigList() {
		return BeanUtils.copyList(reportAutotaskShopConfigDao.getAll(), ReportAutotaskShopConfigVO.class);
	}

	@Override
	public List<ReportAutotaskRecordVO> getReportAutotaskRecordList() {
		List<ReportAutotaskRecordPO> list = reportAutotaskRecordDao.findListByHql("FROM ReportAutotaskRecordPO WHERE status<>? AND failedTimes<3 ORDER BY id",new Object[]{ReportTaskStatus.DONE.getVal()});
		return BeanUtils.copyList(list, ReportAutotaskRecordVO.class);
	}

	@Override
	public List<ReportAutotaskRecordVO> getReportAutotaskRecordLimit(int limit) {
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(limit);
		params.add(ReportTaskStatus.DONE.getVal());
		List<ReportAutotaskRecordPO> list = reportAutotaskRecordDao.findListBySql("SELECT TOP ? * FROM report_autotask_record WHERE status<>? AND failed_times<3 ORDER BY id ", params);
		return BeanUtils.copyList(list, ReportAutotaskRecordVO.class);
	}

	@Override
	public void addReportAutotaskRecord(ReportAutotaskRecordVO reportAutotaskRecordVO) {
		reportAutotaskRecordDao.addObject(BeanUtils.copyProperties(reportAutotaskRecordVO, ReportAutotaskRecordPO.class, new String[]{"id"} ));
	}

	@Override
	public void downloadReportFromAmazon(ReportAutotaskRecordVO reportAutotaskRecordVO) {
		ReportAutotaskRecordPO recordPO = reportAutotaskRecordDao.getObject(reportAutotaskRecordVO.getId());
		System.out.println(reportAutotaskRecordVO.getShopId()+reportAutotaskRecordVO.getReportType());
		recordPO.setLastFireTime(new Date());
		try{
			//TODO
			
			recordPO.setStatus(ReportTaskStatus.DONE.getVal());
		}catch(Exception e){
			recordPO.setStatus(ReportTaskStatus.ERROR.getVal());
			recordPO.setFailedTimes(recordPO.getFailedTimes()+1);
		}
		reportAutotaskRecordDao.updateObject(recordPO);
		int rs = reportAutotaskShopConfigDao.updateLastFireTime(recordPO.getLastFireTime(), recordPO.getShopId(), recordPO.getReportType());
		System.out.println(rs);
	}

}
