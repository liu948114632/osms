package com.itecheasy.webservice.aliexpress;

import java.util.Date;

import com.alibaba.openapi.sdk.aeopenapi.param.TpOpenAddressDTO;

public class TpOpenOrderDetailDTO {
	private String buyerSignerFullname;//买家全名	
	private String buyerloginid;//买家账号	
	private String frozenStatus;//冻结状态("NO_FROZEN"无冻结；"IN_FROZEN"冻结中；)	
	private String fundStatus;//资金状态(NOT_PAY,未付款； PAY_SUCCESS,付款成功； WAIT_SELLER_CHECK，卖家验款)	
	private Date gmtCreate;//订单创建时间	
	private Date gmtModified;//修改时间	
	private Date gmtPaySuccess;//gmtPaySuccess:支付成功时间（与订单列表中gmtPayTime字段意义相同）	
	private Date gmtTradeEnd;//交易结束时间	
	private Long id;//主订单ID	
	private Boolean isPhone;//是否手机订单	true
	private String issueStatus;//纠纷状态("NO_ISSUE"无纠纷；"IN_ISSUE"纠纷中；“END_ISSUE”纠纷结束。)	
	private String loanStatus;//放款状态	
	private String logisticsStatus;//物流状态（"WAIT_SELLER_SEND_GOODS"等待卖家发货;"SELLER_SEND_PART_GOODS"卖家部分发货；"SELLER_SEND_GOODS"卖家已发货；"BUYER_ACCEPT_GOODS"买家已确认收货；"NO_LOGISTICS"没有物流流转信息）	
	private String orderStatus;//订单状态	
	private String paymentType;//付款方式 （migs信用卡支付走人民币渠道； migs102MasterCard支付并且走人民币渠道； migs101Visa支付并且走人民币渠道； pp101 PayPal； mb MoneyBooker渠道； tt101 Bank Transfer支付； wu101 West Union支付； wp101 Visa走美金渠道的支付； wp102 Mastercard 走美金渠道的支付； qw101 QIWI支付； cybs101 Visa走CYBS渠道的支付； cybs102 Mastercard 走CYBS渠道的支付； wm101 WebMoney支付； ebanx101 巴西Beloto支付 ；）	
	private String sellerOperatorAliidloginid;//卖家子帐号	
	private String sellerOperatorLoginId;//负责人loginId	
	private String sellerSignerFullname;//卖家名称	
	private TpOpenPersonDTO buyerInfo;//买家信息	
	private TpOpenOrderProductInfoDTO[] childOrderExtInfoList;//商品信息	
	private TpOpenChildOrderDTO[] childOrderList;//子订单列表	
	private Money escrowFee;//手续费	
	private Money initOderAmount;//商品总金额	
	private TpOpenLogisticInfoDTO[] logisticInfoList;//物流信息	
	private Money logisticsAmount;//物流费用	
	private Money orderAmount;//订单金额	
	private TpOpenAddressDTO receiptAddress;//收货地址	
	private String memo;//买家备注

	private TpOpenOrderMsgDTO[] orderMsgList;//留言信息	
	private TpOperationLogDTO[] oprLogDtoList;//操作日志列表	
	private TpOpenRefundInfoDTO refundInfo;//退款信息	
	private TpOpenIssueInfoDTO issueInfo;//纠纷信息	
	private TpOpenLoanInfoDTO loanInfo;//放款信息	
	
	public String getBuyerSignerFullname() {
		return buyerSignerFullname;
	}
	public void setBuyerSignerFullname(String buyerSignerFullname) {
		this.buyerSignerFullname = buyerSignerFullname;
	}
	public String getBuyerloginid() {
		return buyerloginid;
	}
	public void setBuyerloginid(String buyerloginid) {
		this.buyerloginid = buyerloginid;
	}
	public String getFrozenStatus() {
		return frozenStatus;
	}
	public void setFrozenStatus(String frozenStatus) {
		this.frozenStatus = frozenStatus;
	}
	public String getFundStatus() {
		return fundStatus;
	}
	public void setFundStatus(String fundStatus) {
		this.fundStatus = fundStatus;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	public Date getGmtPaySuccess() {
		return gmtPaySuccess;
	}
	public void setGmtPaySuccess(Date gmtPaySuccess) {
		this.gmtPaySuccess = gmtPaySuccess;
	}
	public Date getGmtTradeEnd() {
		return gmtTradeEnd;
	}
	public void setGmtTradeEnd(Date gmtTradeEnd) {
		this.gmtTradeEnd = gmtTradeEnd;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	

	public String getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getLogisticsStatus() {
		return logisticsStatus;
	}
	public void setLogisticsStatus(String logisticsStatus) {
		this.logisticsStatus = logisticsStatus;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getSellerOperatorAliidloginid() {
		return sellerOperatorAliidloginid;
	}
	public void setSellerOperatorAliidloginid(String sellerOperatorAliidloginid) {
		this.sellerOperatorAliidloginid = sellerOperatorAliidloginid;
	}
	public String getSellerOperatorLoginId() {
		return sellerOperatorLoginId;
	}
	public void setSellerOperatorLoginId(String sellerOperatorLoginId) {
		this.sellerOperatorLoginId = sellerOperatorLoginId;
	}
	public String getSellerSignerFullname() {
		return sellerSignerFullname;
	}
	public void setSellerSignerFullname(String sellerSignerFullname) {
		this.sellerSignerFullname = sellerSignerFullname;
	}
	public TpOpenPersonDTO getBuyerInfo() {
		return buyerInfo;
	}
	public void setBuyerInfo(TpOpenPersonDTO buyerInfo) {
		this.buyerInfo = buyerInfo;
	}
	public TpOpenOrderProductInfoDTO[] getChildOrderExtInfoList() {
		return childOrderExtInfoList;
	}
	public void setChildOrderExtInfoList(
			TpOpenOrderProductInfoDTO[] childOrderExtInfoList) {
		this.childOrderExtInfoList = childOrderExtInfoList;
	}
	public TpOpenChildOrderDTO[] getChildOrderList() {
		return childOrderList;
	}
	public void setChildOrderList(TpOpenChildOrderDTO[] childOrderList) {
		this.childOrderList = childOrderList;
	}
	public Money getEscrowFee() {
		return escrowFee;
	}
	public void setEscrowFee(Money escrowFee) {
		this.escrowFee = escrowFee;
	}
	public Money getInitOderAmount() {
		return initOderAmount;
	}
	public void setInitOderAmount(Money initOderAmount) {
		this.initOderAmount = initOderAmount;
	}
	public TpOpenLogisticInfoDTO[] getLogisticInfoList() {
		return logisticInfoList;
	}
	public void setLogisticInfoList(TpOpenLogisticInfoDTO[] logisticInfoList) {
		this.logisticInfoList = logisticInfoList;
	}
	public Money getLogisticsAmount() {
		return logisticsAmount;
	}
	public void setLogisticsAmount(Money logisticsAmount) {
		this.logisticsAmount = logisticsAmount;
	}
	public Money getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Money orderAmount) {
		this.orderAmount = orderAmount;
	}
	public TpOpenAddressDTO getReceiptAddress() {
		return receiptAddress;
	}
	public void setReceiptAddress(TpOpenAddressDTO receiptAddress) {
		this.receiptAddress = receiptAddress;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public TpOpenOrderMsgDTO[] getOrderMsgList() {
		return orderMsgList;
	}
	public void setOrderMsgList(TpOpenOrderMsgDTO[] orderMsgList) {
		this.orderMsgList = orderMsgList;
	}
	public TpOperationLogDTO[] getOprLogDtoList() {
		return oprLogDtoList;
	}
	public void setOprLogDtoList(TpOperationLogDTO[] oprLogDtoList) {
		this.oprLogDtoList = oprLogDtoList;
	}
	public TpOpenRefundInfoDTO getRefundInfo() {
		return refundInfo;
	}
	public void setRefundInfo(TpOpenRefundInfoDTO refundInfo) {
		this.refundInfo = refundInfo;
	}
	public TpOpenIssueInfoDTO getIssueInfo() {
		return issueInfo;
	}
	public void setIssueInfo(TpOpenIssueInfoDTO issueInfo) {
		this.issueInfo = issueInfo;
	}
	public TpOpenLoanInfoDTO getLoanInfo() {
		return loanInfo;
	}
	public void setLoanInfo(TpOpenLoanInfoDTO loanInfo) {
		this.loanInfo = loanInfo;
	}
	public Boolean getIsPhone() {
		return isPhone;
	}
	public void setIsPhone(Boolean isPhone) {
		this.isPhone = isPhone;
	}
	
	
}
