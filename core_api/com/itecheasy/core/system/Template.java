package com.itecheasy.core.system;

/**
 * @author wanghw
 * @date 2015-3-28
 * @description TODO
 * @version
 */
public class Template {
	private int id;
	private String name;
	private String fileName;
	private int language;

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
