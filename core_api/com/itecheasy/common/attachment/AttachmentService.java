package com.itecheasy.common.attachment;

import com.itecheasy.common.po.AttachmentStore;
import java.io.File;
import java.util.List;

public abstract interface AttachmentService {
	public abstract String addAttachment(String paramString1,
			String paramString2, String paramString3, String paramString4,
			File paramFile);

	public abstract String[] addAttachmentList(String paramString1,
			String paramString2, String[] paramArrayOfString1,
			String[] paramArrayOfString2, File[] paramArrayOfFile);

	public abstract void updateAttachmentFile(String paramString, File paramFile);

	public abstract void updateAttachmentFileList(String[] paramArrayOfString,
			File[] paramArrayOfFile);

	public abstract void updateAttachmentFile(String paramString1,
			String paramString2, String paramString3, File paramFile);

	public abstract void updateAttachmentFileList(String paramString1,
			String paramString2, String[] paramArrayOfString,
			File[] paramArrayOfFile);

	public abstract void updateAttachmentInfo(String paramString1,
			String paramString2);

	public abstract void updateAttachmentInfoList(String[] paramArrayOfString1,
			String[] paramArrayOfString2);

	public abstract void updateAttachmentInfo(String paramString1,
			String paramString2, String paramString3, String paramString4);

	public abstract void updateAttachmentInfoList(String paramString1,
			String paramString2, String[] paramArrayOfString1,
			String[] paramArrayOfString2);

	public abstract void deleteAttachment(String paramString);

	public abstract void deleteAttachmentList(String[] paramArrayOfString);

	public abstract void deleteAttachment(String paramString1,
			String paramString2, String paramString3);

	public abstract void deleteAttachmentList(String paramString1,
			String paramString2, String[] paramArrayOfString);

	public abstract int deleteModelId(String paramString1, String paramString2);

	public abstract List<AttachmentStore> getAttachmentInfoList(
			String paramString1, String paramString2);

	public abstract AttachmentStore getAttachmentInfo(String paramString);

	public abstract AttachmentStore getAttachmentInfo(String paramString1,
			String paramString2, String paramString3);

	public abstract List<File> getAttachmentFileList(String paramString1,
			String paramString2);

	public abstract File getAttachmentFile(String paramString);

	public abstract File getAttachmentFile(String paramString1,
			String paramString2, String paramString3);
}