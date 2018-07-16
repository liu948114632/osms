package com.itecheasy.core.po;

import java.math.BigDecimal;

import javax.persistence.*;

/**
 * @author wanghw
 * @date 2016-1-11
 * @description TODO
 * @version
 */
@Entity
@Table(name="currency_exchange_rate")
public class CurrencyExchangeRatePO {
	private int id;
	private String version;
	private int currency;
	private BigDecimal rate;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column
	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	@Column
	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

}
