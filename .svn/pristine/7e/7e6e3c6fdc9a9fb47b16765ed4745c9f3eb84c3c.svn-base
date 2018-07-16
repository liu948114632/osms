package com.itecheasy.core.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import com.itecheasy.core.system.ShippingMethod.ShippingMethodStatus;

/**
 * @alias 货运方式
 * @author taozt
 * 
 */
@Entity
@Table(name = "shipping_method")
public class ShippingMethodPO {

	private Integer id;
	private String name;
	private String url;
	private Boolean fillFreightNote;
	private ShippingMethodStatus status;
	private String printAddress;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "fill_freight_note")
	public Boolean getFillFreightNote() {
		return fillFreightNote;
	}

	public void setFillFreightNote(Boolean fillFreightNote) {
		this.fillFreightNote = fillFreightNote;
	}

	@Column(name = "print_address")
	public String getPrintAddress() {
		return printAddress;
	}

	public void setPrintAddress(String printAddress) {
		this.printAddress = printAddress;
	}

	@Enumerated
	@Column(name = "status")
	public ShippingMethodStatus getStatus() {
		return status;
	}

	public void setStatus(ShippingMethodStatus status) {
		this.status = status;
	}

	public ShippingMethodPO(Integer id) {
		super();
		this.id = id;
	}

	public ShippingMethodPO() {
		super();
	}
}
