package com.itecheasy.common.attachment;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.itecheasy.common.po.AttachmentStore;
import com.itecheasy.common.po.AttachmentStoreRule;

public class AttachmentServiceImpl implements AttachmentService {
	private List<AttachmentStoreRule> attachmentStoreRule;
	private AttachmentDAO attachmentDAO;

	public AttachmentDAO getAttachmentDAO() {
		return this.attachmentDAO;
	}

	public void setAttachmentDAO(AttachmentDAO attachmentDAO) {
		this.attachmentDAO = attachmentDAO;
	}

	public void initialize() {
		this.attachmentStoreRule = this.attachmentDAO.getAllAttachmentStoreRule();
	}

	private String getAttachmentStorePath(String modelType, String modelId,
			String attachmentName) {
		if (this.attachmentStoreRule.size() > 0) {
			String path = ((AttachmentStoreRule) this.attachmentStoreRule
					.get(0)).getStorePath();
			if (!path.endsWith("/"))
				path = path + "/";
			return path + modelType + "/" + modelId + "/";
		}

		throw new RuntimeException("can not find attachment store rule.");
	}

	private File getAttachmentStoreFile(String modelType, String modelId,
			String attachmentName, String filename) {
		return new File(getAttachmentStorePath(modelType, modelId,
				attachmentName)
				+ filename);
	}

	public String addAttachment(String modelType, String modelId,
			String attachmentName, String description, File file) {
		try {
			String code = UUID.randomUUID().toString();

			AttachmentStore info = new AttachmentStore();
			info.setModelType(modelType);
			info.setModelId(modelId);
			info.setAttachmentName(attachmentName);
			info.setAttachmentCode(code);
			String tmpFilename = file.getName();
			int pos = tmpFilename.lastIndexOf(".");
			String ext = tmpFilename.substring(pos + 1);
			info.setFilename(attachmentName + "." + ext);
			info.setDescription(description);

			this.attachmentDAO.addObject(info);

			File destFile = getAttachmentStoreFile(modelType, modelId,attachmentName, info.getFilename());
			FileUtils.copyFile(file, destFile);

			return info.getAttachmentCode();
		} catch (IOException e) {
			throw new RuntimeException("can not copy file "+ file.getAbsolutePath(), e);
		}

	}

	public String[] addAttachmentList(String modelType, String modelId,
			String[] attachmentName, String[] description, File[] file) {
		int count = file.length;
		String[] ret = new String[count];
		for (int i = 0; i < count; i++) {
			ret[i] = addAttachment(modelType, modelId, attachmentName[i],
					description[i], file[i]);
		}
		return ret;
	}

	public File getAttachmentFile(String attachmentCode) {
		if(StringUtils.isEmpty(attachmentCode)){
			return null;
		}
		AttachmentStore info = this.attachmentDAO.getObject(attachmentCode);
		if (info == null) {
			return null;
		}
		return getAttachmentStoreFile(info.getModelType(), info.getModelId(),
				info.getAttachmentName(), info.getFilename());
	}

	public File getAttachmentFile(String modelType, String modelId,
			String attachmentName) {
		AttachmentStore info = this.attachmentDAO
				.findByHql("from AttachmentStore p where p.modelType = ? and p.modelId = ? and p.attachmentName = ?",
						new Object[] { modelType, modelId, attachmentName });
		if (info == null) {
			return null;
		}
		return getAttachmentStoreFile(info.getModelType(), info.getModelId(),
				info.getAttachmentName(), info.getFilename());
	}

	public List<File> getAttachmentFileList(String modelType, String modelId) {
		List<AttachmentStore> infoList = this.attachmentDAO
				.findListByHql("from AttachmentStore p where p.modelType = ? and p.modelId = ?",
						new Object[] { modelType, modelId });
		List<File> ret = new LinkedList<File>();
		for (AttachmentStore info : infoList) {
			ret
					.add(getAttachmentStoreFile(info.getModelType(), info
							.getModelId(), info.getAttachmentName(), info
							.getFilename()));
		}
		return ret;
	}

	public AttachmentStore getAttachmentInfo(String attachmentCode) {
		if(StringUtils.isEmpty(attachmentCode)){
			return null;
		}
		return this.attachmentDAO.getObject(attachmentCode);
	}

	public AttachmentStore getAttachmentInfo(String modelType, String modelId,
			String attachmentName) {
		return (AttachmentStore) this.attachmentDAO
				.findByHql(
						"from AttachmentStore p where p.modelType = ? and p.modelId = ? and p.attachmentName = ?",
						new Object[] { modelType, modelId, attachmentName });
	}

	public List<AttachmentStore> getAttachmentInfoList(String modelType,
			String modelId) {
		List<AttachmentStore> infoList = this.attachmentDAO
				.findListByHql(
						"from AttachmentStore p where p.modelType = ? and p.modelId = ?",
						new Object[] { modelType, modelId });
		List<AttachmentStore> ret = new LinkedList<AttachmentStore>();
		for (AttachmentStore info : infoList) {
			ret.add(info);
		}
		return ret;
	}

	public int deleteModelId(String modelType, String modelId) {
		throw new RuntimeException("under construction.");
	}

	public void deleteAttachment(String attachmentCode) {
		File file = getAttachmentFile(attachmentCode);

		AttachmentStore info = getAttachmentInfo(attachmentCode);
		if(info != null){
			this.attachmentDAO.deleteObject(info);
		}
		file.delete();
	}

	public void deleteAttachment(String modelType, String modelId,
			String attachmentName) {
		AttachmentStore info = getAttachmentInfo(modelType, modelId,
				attachmentName);
		deleteAttachment(info.getAttachmentCode());
	}

	public void deleteAttachmentList(String[] attachmentCode) {
		for (String code : attachmentCode)
			deleteAttachment(code);
	}

	public void deleteAttachmentList(String modelType, String modelId,
			String[] attachmentName) {
		for (String name : attachmentName)
			deleteAttachment(modelType, modelId, name);
	}

	public void updateAttachmentFile(String attachmentCode, File file) {
		AttachmentStore info = getAttachmentInfo(attachmentCode);
		updateAttachmentFile(info.getModelType(), info.getModelId(), info
				.getAttachmentName(), file);
	}

	public void updateAttachmentFile(String modelType, String modelId,
			String attachmentName, File file) {
		AttachmentStore info = getAttachmentInfo(modelType, modelId,
				attachmentName);
		File oldFile = getAttachmentFile(modelType, modelId, attachmentName);
		oldFile.delete();

		String tmpFilename = file.getName();
		int pos = tmpFilename.lastIndexOf(".");
		String ext = tmpFilename.substring(pos + 1);
		info.setFilename(attachmentName + "." + ext);
		this.attachmentDAO.updateObject(info);

		File destFile = getAttachmentStoreFile(info.getModelType(), info
				.getModelId(), info.getAttachmentName(), info.getFilename());
		try {
			FileUtils.copyFile(file, destFile);
		} catch (IOException e) {
			throw new RuntimeException("can not copy file "
					+ file.getAbsolutePath(), e);
		}
	}

	public void updateAttachmentFileList(String[] attachmentCode, File[] file) {
		int count = attachmentCode.length;
		for (int i = 0; i < count; i++)
			updateAttachmentFile(attachmentCode[i], file[i]);
	}

	public void updateAttachmentFileList(String modelType, String modelId,
			String[] attachmentName, File[] file) {
		int count = attachmentName.length;
		for (int i = 0; i < count; i++)
			updateAttachmentFile(modelType, modelId, attachmentName[i], file[i]);
	}

	public void updateAttachmentInfo(String attachmentCode, String description) {
		AttachmentStore info = getAttachmentInfo(attachmentCode);
		info.setDescription(description);
		this.attachmentDAO.updateObject(info);
	}

	public void updateAttachmentInfo(String modelType, String modelId,
			String attachmentName, String description) {
		AttachmentStore info = getAttachmentInfo(modelType, modelId,
				attachmentName);
		info.setDescription(description);
		this.attachmentDAO.updateObject(info);
	}

	public void updateAttachmentInfoList(String[] attachmentCode,
			String[] description) {
		int count = attachmentCode.length;
		for (int i = 0; i < count; i++)
			updateAttachmentInfo(attachmentCode[i], description[i]);
	}

	public void updateAttachmentInfoList(String modelType, String modelId,
			String[] attachmentName, String[] description) {
		int count = attachmentName.length;
		for (int i = 0; i < count; i++)
			updateAttachmentInfo(modelType, modelId, attachmentName[i],
					description[i]);
	}
}