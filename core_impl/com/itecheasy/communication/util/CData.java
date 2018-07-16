package com.itecheasy.communication.util;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.itecheasy.communication.order.MyTransaction;

import net.sf.json.JSONObject;

public class CData implements Serializable {
	private static final long serialVersionUID = 3010127381553327897L;

	public CData() {
	}

	public CData(String command, int direction, String remark) {
		this.command = command;
		this.direction = direction;
		this.remark = remark;
	}

	public void addOperateData(String key, Object value) {
		this.operateData.put(key.toLowerCase(), value);
	}

	public Object getOperateData(String key) {
		if (this.operateData == null) {
			if (!deserializeData()) {
				return null;
			}
		}
		return this.operateData.get(key.toLowerCase());
	}

	public boolean containsKey(String key) {
		if (this.operateData == null) {
			if (!deserializeData()) {
				return false;
			}
		}
		return this.operateData.containsKey(key.toLowerCase());
	}

	private boolean deserializeData() {
		if (dataString == null || dataString.isEmpty()) {
			return false;
		}
		JSONObject json = JSONObject.fromObject(dataString);
		this.operateData = (Map<String, Object>) json.toBean(json, Map.class);
		return true;
	}

	/**
	 * 写数据文件
	 * 
	 * @param targetDirectionPath
	 *            目标文件夹
	 */
	public void writeData(String targetDirectionPath) {
		if (targetDirectionPath == null || targetDirectionPath.isEmpty()) {
			throw new RuntimeException("targetDirectionPath is invalid.");
		}
		if (this.dataString == null) {
			this.dataString = JSONObject.fromObject(this.operateData).toString().replace("null,", "\"\",");
		}
		new File(targetDirectionPath).mkdirs();
		this.dataString = XmlUtils.chinaToUnicode(this.dataString);
		Operater.writeData(this, targetDirectionPath);
		long id = Thread.currentThread().getId();
		if(!MyTransaction.files.containsKey(id)) {
			MyTransaction.files.put(id, new ArrayList<CData>());
		}
		MyTransaction.files.get(id).add(this);
	}

	public void commit() {
		File tempFile = new File(this.tempFilePath);
		File file = new File(this.filePath);
		tempFile.renameTo(file);
	}
	
	public void rollback(){
		File tempFile = new File(this.tempFilePath);
		tempFile.delete();
	}
	
	/**
	 * 写数据文件
	 * 
	 * @param targetDirectionPath
	 *            目标文件夹
	 * @param isFormatDataString
	 *            是否重新格式化数据字符串
	 */
	public void writeData(String targetDirectionPath, boolean isFormatDataString) {
		if (targetDirectionPath == null || targetDirectionPath.isEmpty()) {
			throw new RuntimeException("targetDirectionPath is invalid.");
		}
		if (isFormatDataString) {
			this.dataString = JSONObject.fromObject(this.operateData).toString();
		} else {
			if (this.dataString == null) {
				this.dataString = JSONObject.fromObject(this.operateData).toString();
			}
		}
		this.dataString = XmlUtils.chinaToUnicode(this.dataString);
		Operater.writeData(this, targetDirectionPath);
	}

	/**
	 * 移动数据文件
	 * 
	 * @param targetDirectionPath
	 *            目标文件夹
	 */
	public void moveTo(String targetDirectionPath) {
		if (this.filePath == null) {
			throw new RuntimeException("Failed to move. Call writeData() first.");
		}
		Operater.moveData(this, targetDirectionPath);
	}

	/**
	 * 复制数据文件
	 * 
	 * @param targetDirectionPath
	 *            目标文件夹
	 */
	public void copyTo(String targetDirectionPath) {
		if (this.filePath == null) {
			throw new RuntimeException("Failed to copy. Call writeData() first.");
		}
		Operater.copyDataTo(this, targetDirectionPath);
	}

	/**
	 * 判断数据文件是否存在
	 * 
	 * @return
	 */
	public boolean exists() {
		if (this.filePath == null) {
			return false;
		} else {
			return FileUtils.existFile(this.filePath);
		}
	}

	private Map<String, Object> operateData = new HashMap<String, Object>();;

	private String command;

	private String dataString;

	private Integer direction;

	private String filePath;

	private String fileName;

	private String remark;

	private Integer dataType = 2;

	private String tempFilePath;

	public String getTempFilePath() {
		return tempFilePath;
	}

	public void setTempFilePath(String tempFilePath) {
		this.tempFilePath = tempFilePath;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getDataString() {
		return dataString;
	}

	protected void setDataString(String dataString) {
		this.dataString = dataString;
	}

	public Integer getDirection() {
		return direction;
	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	public String getFilePath() {
		return filePath;
	}

	protected void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	protected void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getDataType() {
		return dataType;
	}

	protected void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

}
