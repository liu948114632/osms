package com.itecheasy.core.po;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2015-6-4
 * @description TODO
 * @version
 */
@Entity
@Table(name = "merchandiser")
public class MerchandiserPO {
	private int id;
	private String merchandiserName;
	private String merchandiserEmail;
	private String code;
	
	@Column(name="code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="merchandiser_name")
	public String getMerchandiserName() {
		return merchandiserName;
	}

	public void setMerchandiserName(String merchandiserName) {
		this.merchandiserName = merchandiserName;
	}

	@Column(name="merchandiser_email")
	public String getMerchandiserEmail() {
		return merchandiserEmail;
	}

	public void setMerchandiserEmail(String merchandiserEmail) {
		this.merchandiserEmail = merchandiserEmail;
	}

}
