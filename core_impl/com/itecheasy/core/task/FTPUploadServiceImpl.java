package com.itecheasy.core.task;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.itecheasy.common.dao.Criteria;
import com.itecheasy.common.dao.Restriction;
import com.itecheasy.common.picture.ContinueFTP;
import com.itecheasy.common.picture.FTPStatus;
import com.itecheasy.common.picture.FTPUploadLogDao;
import com.itecheasy.common.po.FTPUploadLogPO;
import com.itecheasy.common.util.CollectionUtils;

/** 
 * @author wanghw
 * @date 2015-5-25 
 * @description TODO
 * @version
 */
public class FTPUploadServiceImpl implements FTPUploadService{
	private Logger logger=Logger.getLogger(FTPUploadServiceImpl.class);
	private FTPUploadLogDao ftpUploadLogDao;
	
	public void setFtpUploadLogDao(FTPUploadLogDao ftpUploadLogDao) {
		this.ftpUploadLogDao = ftpUploadLogDao;
	}

	@Override
	public void doWork() {
		logger.info("ftp do working!"+new Date());
		Criteria criteria=new Criteria(FTPUploadLogPO.class);
		criteria.and(Restriction.eq("status", FTPStatus.FAILED));
		List<FTPUploadLogPO>  pos=ftpUploadLogDao.list(criteria);
		if (CollectionUtils.isNotEmpty(pos)) {
			int index=pos.size()>5?5:pos.size();
			for (int i = 0; i < index; i++) {
				FTPUploadLogPO po=pos.get(i);
					save(po);
			}
		}
		logger.info("ftp finish working!"+new Date());
	}
	
	private void save(FTPUploadLogPO po){
		logger.info("ftp saving object!");
		if (StringUtils.isNotEmpty(po.getLocalName())) {
			File file=new File(po.getLocalName());
			if (file.exists()) {
				new ContinueFTP(po).run();
			}else{
				po.setStatus(FTPStatus.CANCEL);
				po.setRemark("the local file is deleted!");
			}
		}else{
			new ContinueFTP(po).run();
		}
		ftpUploadLogDao.mergeObject(po);
	}

}
