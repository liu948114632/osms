package com.itecheasy.core.order;

import java.math.BigDecimal;

/**
 * @author wanghw
 * @date 2016-1-11
 * @description 订单实收款按类型汇总金额
 * @see OrderPaymentDataType
 * @version
 */
public class OrderPaymentDataTypeAmountCount extends OrderPaymentDataType {
	private BigDecimal amount;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
