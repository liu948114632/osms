package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description TODO
 * @version
 */
@Entity
@Table(name = "template")
public class TemplatePo {
	private int id;
	private String name;
	private String fileName;
	private int language;
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	@Column(name="language")
	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="file_name")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
