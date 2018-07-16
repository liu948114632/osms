package com.itecheasy.core.po;

import java.math.BigDecimal;

import javax.persistence.*;

/**
 * 币种
 * 
 */
@Entity
@Table(name="currency")
public class CurrencyPO {
	private int id;
	/**
	 * 简称
	 * 
	 */
	private String code;
	/**
	 * 符号
	 * 
	 */
	private String symbol;

	private String name;
	
	private Double threshold;
	
	

	public Double getThreshold() {
		return threshold;
	}

	public void setThreshold(Double threshold) {
		this.threshold = threshold;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="symbol")
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}