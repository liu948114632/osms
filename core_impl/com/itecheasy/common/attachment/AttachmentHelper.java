package com.itecheasy.common.attachment;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.itecheasy.common.util.DeployProperties;

/** 
 * @author wanghw
 * @date 2016-12-5 
 * @description TODO
 * @version 1.2.2
 */
public class AttachmentHelper {
	private AttachmentService attachmentService;
	
	
	public void setAttachmentService(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}


	public String saveAttachment(int objectId, Attachment atta,String dirName){
		File tempFile = new File(DeployProperties.getInstance().getProperty("temp_dir") + dirName
				+ "\\" + atta.getFileName());
		try {
			FileUtils.writeByteArrayToFile(tempFile, atta.getFile());
		} catch (IOException e) {
		}

		String UUID = attachmentService.addAttachment(dirName, String.valueOf(objectId),
				atta.getFileName(), null, tempFile);
		return UUID;
	}
}
