package com.itecheasy.core.system;

import java.math.BigDecimal;

/**
 * @author wanghw
 * @date 2015-5-11
 * @description TODO
 * @version
 */
public class Currency {
	private int id;
	private String code;
	private String symbol;
	private String name;
	private Double threshold;
	private BigDecimal rate4USD;

	public BigDecimal getRate4USD() {
		return rate4USD;
	}

	public void setRate4USD(BigDecimal rate4usd) {
		rate4USD = rate4usd;
	}

	public Double getThreshold() {
		return threshold;
	}

	public void setThreshold(Double threshold) {
		this.threshold = threshold;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
