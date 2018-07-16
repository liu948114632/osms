package com.itecheasy.common.po;

import javax.persistence.*;

import com.itecheasy.common.picture.FTPStatus;
import com.itecheasy.common.picture.FTPType;

/**
 * @author wanghw
 * @date 2015-5-25
 * @description TODO
 * @version
 */
@Entity
@Table(name = "ftp_upload_log")
public class FTPUploadLogPO {
	private int id;
	private String localName;
	private String remoteName;
	private FTPStatus status;
	private FTPType type;
	private String remark;
	private String ip;
	private String port;
	private String name;
	private String pwd;
	private Integer objectId;
	
	
	@Column(name="object_id")
	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="local_name")
	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	@Column(name="remote_name")
	public String getRemoteName() {
		return remoteName;
	}

	public void setRemoteName(String remoteName) {
		this.remoteName = remoteName;
	}

	@Column(name="status")
	public FTPStatus getStatus() {
		return status;
	}

	public void setStatus(FTPStatus status) {
		this.status = status;
	}

	@Column(name="type")
	public FTPType getType() {
		return type;
	}

	public void setType(FTPType type) {
		this.type = type;
	}

	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="ftp_ip")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name="ftp_port")
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Column(name="ftp_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="ftp_pwd")
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
