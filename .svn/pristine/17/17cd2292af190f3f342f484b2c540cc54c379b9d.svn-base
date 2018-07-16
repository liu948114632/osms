package com.itecheasy.common.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "common_attachment_store")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AttachmentStore implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4432410567456907081L;
	private String modelType;
	private String modelId;
	private String attachmentName;
	private String description;
	private String attachmentCode;
	private String filename;

	/*
	 * @GeneratedValue(strategy=GenerationType.AUTO) public Long getId() {
	 * return this.id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
	 */

	@Id
	@Column(name = "attachment_code")
	public String getAttachmentCode() {
		return this.attachmentCode;
	}

	public void setAttachmentCode(String attachmentCode) {
		this.attachmentCode = attachmentCode;
	}

	@Column(name = "model_type")
	public String getModelType() {
		return this.modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	@Column(name = "model_id")
	public String getModelId() {
		return this.modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	@Column(name = "attachment_name")
	public String getAttachmentName() {
		return this.attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}