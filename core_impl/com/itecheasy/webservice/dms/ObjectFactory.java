package com.itecheasy.webservice.dms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.itecheasy.webservice.dms package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _UpdateOrderInfoResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"updateOrderInfoResponse");
	private final static QName _GetDeliveryMessageResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "getDeliveryMessageResponse");
	private final static QName _GetDeliveryWeightResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"getDeliveryWeightResponse");
	private final static QName _GetFedexDeliveryShippingMethod_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "getFedexDeliveryShippingMethod");
	private final static QName _Reopen_QNAME = new QName("http://out.webservice.dms.itecheasy.com/", "reopen");
	private final static QName _ReceviceOrderQuestionProcessType_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "receviceOrderQuestionProcessType");
	private final static QName _CloseQuestionResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"closeQuestionResponse");
	private final static QName _ConfirmDeliveryMessage_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"confirmDeliveryMessage");
	private final static QName _UpdateOrderShippingAddressResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "updateOrderShippingAddressResponse");
	private final static QName _GetInvoice_QNAME = new QName("http://out.webservice.dms.itecheasy.com/", "getInvoice");
	private final static QName _UpdateCurrencyResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"updateCurrencyResponse");
	private final static QName _SetFBAFlag_QNAME = new QName("http://out.webservice.dms.itecheasy.com/", "setFBAFlag");
	private final static QName _GetCheapestShippingMethodAndExpense_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "getCheapestShippingMethodAndExpense");
	private final static QName _GetCheapestShippingMethodAndExpenseResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "getCheapestShippingMethodAndExpenseResponse");
	private final static QName _GetDeliveryFreightAmount_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"GetDeliveryFreightAmount");
	private final static QName _GetAllFreeShippingMethod_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"getAllFreeShippingMethod");
	private final static QName _UpdateBoxBarCode_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"updateBoxBarCode");
	private final static QName _GetDeliveryServerLineResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "GetDeliveryServerLineResponse");
	private final static QName _GetDeliveryFreightAmountResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "GetDeliveryFreightAmountResponse");
	private final static QName _UpdateApplyInfo_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"updateApplyInfo");
	private final static QName _UpdateOrderWebFreight_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"updateOrderWebFreight");
	private final static QName _BussinessException_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"BussinessException");
	private final static QName _SetFBAFlagResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"setFBAFlagResponse");
	private final static QName _ConfirmDeliveryMessageResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "confirmDeliveryMessageResponse");
	private final static QName _ReopenResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"reopenResponse");
	private final static QName _ReceviceOrderQuestionProcessTypeResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "receviceOrderQuestionProcessTypeResponse");
	private final static QName _GetFedexDeliveryShippingMethodResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "getFedexDeliveryShippingMethodResponse");
	private final static QName _GetDeliveryShippingMethod_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"getDeliveryShippingMethod");
	private final static QName _GetFedexAgentDeliveryShippingMethod_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "getFedexAgentDeliveryShippingMethod");
	private final static QName _GetInvoiceResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"getInvoiceResponse");
	private final static QName _UpdateOrderShippingAddress2_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "updateOrderShippingAddress2");
	private final static QName _GetDeliveryWeight_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"getDeliveryWeight");
	private final static QName _GetAmountResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"getAmountResponse");
	private final static QName _GetCheapestShippingMethodAndExpenseOSMS_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "getCheapestShippingMethodAndExpenseOSMS");
	private final static QName _ConfirmCancelRepeat_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"confirmCancelRepeat");
	private final static QName _UpdateBackOrderInfoResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "updateBackOrderInfoResponse");
	private final static QName _UpdateApplyInfoResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"updateApplyInfoResponse");
	private final static QName _UpdateBackOrderInfo_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"updateBackOrderInfo");
	private final static QName _DMSBussinessException_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"DMSBussinessException");
	private final static QName _UpdateOrderWebFreightResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "updateOrderWebFreightResponse");
	private final static QName _CompletePackageTrace_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"completePackageTrace");
	private final static QName _ReceviceQuestionResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"receviceQuestionResponse");
	private final static QName _IsRemoteArea_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"isRemoteArea");
	private final static QName _CompletePackageTraceResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "completePackageTraceResponse");
	private final static QName _UpdateOrderDeliveryInfo_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"updateOrderDeliveryInfo");
	private final static QName _CloseQuestion_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"closeQuestion");
	private final static QName _UpdateCurrency_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"updateCurrency");
	private final static QName _AddOrderResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"addOrderResponse");
	private final static QName _UpdateBoxBarCodeResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"updateBoxBarCodeResponse");
	private final static QName _UpdateOrderDeliveryInfoResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "updateOrderDeliveryInfoResponse");
	private final static QName _CancelMerge_QNAME = new QName("http://out.webservice.dms.itecheasy.com/", "cancelMerge");
	private final static QName _MergeOrder_QNAME = new QName("http://out.webservice.dms.itecheasy.com/", "mergeOrder");
	private final static QName _UpdateOrderShippingAddress_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "updateOrderShippingAddress");
	private final static QName _UpdateOrderShippingAddress2Response_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "updateOrderShippingAddress2Response");
	private final static QName _ApplyCancelRepeat_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"applyCancelRepeat");
	private final static QName _ReceviceQuestion_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"receviceQuestion");
	private final static QName _IsRemoteAreaResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"isRemoteAreaResponse");
	private final static QName _GetPackageInfoResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"getPackageInfoResponse");
	private final static QName _GetDeliveryMessage_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"getDeliveryMessage");
	private final static QName _ApplyCancelRepeatResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"applyCancelRepeatResponse");
	private final static QName _GetAmount_QNAME = new QName("http://out.webservice.dms.itecheasy.com/", "getAmount");
	private final static QName _GetDeliveryShippingMethodResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "getDeliveryShippingMethodResponse");
	private final static QName _UpdateOrderInfo_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"updateOrderInfo");
	private final static QName _ConfirmCancelRepeatResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "confirmCancelRepeatResponse");
	private final static QName _MergeOrderResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"mergeOrderResponse");
	private final static QName _GetAllFreeShippingMethodResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "getAllFreeShippingMethodResponse");
	private final static QName _AddOrder_QNAME = new QName("http://out.webservice.dms.itecheasy.com/", "addOrder");
	private final static QName _GetDeliveryServerLine_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"GetDeliveryServerLine");
	private final static QName _GetCheapestShippingMethodAndExpenseOSMSResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "getCheapestShippingMethodAndExpenseOSMSResponse");
	private final static QName _CancelMergeResponse_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"cancelMergeResponse");
	private final static QName _GetFedexAgentDeliveryShippingMethodResponse_QNAME = new QName(
			"http://out.webservice.dms.itecheasy.com/", "getFedexAgentDeliveryShippingMethodResponse");
	private final static QName _GetPackageInfo_QNAME = new QName("http://out.webservice.dms.itecheasy.com/",
			"getPackageInfo");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.itecheasy.webservice.dms
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link GetDeliveryMessageResponse }
	 * 
	 */
	public GetDeliveryMessageResponse createGetDeliveryMessageResponse() {
		return new GetDeliveryMessageResponse();
	}

	/**
	 * Create an instance of {@link UpdateApplyInfoResponse }
	 * 
	 */
	public UpdateApplyInfoResponse createUpdateApplyInfoResponse() {
		return new UpdateApplyInfoResponse();
	}

	/**
	 * Create an instance of {@link SetFBAFlagResponse }
	 * 
	 */
	public SetFBAFlagResponse createSetFBAFlagResponse() {
		return new SetFBAFlagResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderShippingAddress2Response }
	 * 
	 */
	public UpdateOrderShippingAddress2Response createUpdateOrderShippingAddress2Response() {
		return new UpdateOrderShippingAddress2Response();
	}

	/**
	 * Create an instance of {@link GetFedexAgentDeliveryShippingMethodResponse }
	 * 
	 */
	public GetFedexAgentDeliveryShippingMethodResponse createGetFedexAgentDeliveryShippingMethodResponse() {
		return new GetFedexAgentDeliveryShippingMethodResponse();
	}

	/**
	 * Create an instance of {@link PackageLogInfo }
	 * 
	 */
	public PackageLogInfo createPackageLogInfo() {
		return new PackageLogInfo();
	}

	/**
	 * Create an instance of {@link ApplyCancelRepeat }
	 * 
	 */
	public ApplyCancelRepeat createApplyCancelRepeat() {
		return new ApplyCancelRepeat();
	}

	/**
	 * Create an instance of {@link UpdateBoxBarCodeResponse }
	 * 
	 */
	public UpdateBoxBarCodeResponse createUpdateBoxBarCodeResponse() {
		return new UpdateBoxBarCodeResponse();
	}

	/**
	 * Create an instance of {@link AddOrder }
	 * 
	 */
	public AddOrder createAddOrder() {
		return new AddOrder();
	}

	/**
	 * Create an instance of {@link GetAllFreeShippingMethodResponse }
	 * 
	 */
	public GetAllFreeShippingMethodResponse createGetAllFreeShippingMethodResponse() {
		return new GetAllFreeShippingMethodResponse();
	}

	/**
	 * Create an instance of {@link GetDeliveryServerLine }
	 * 
	 */
	public GetDeliveryServerLine createGetDeliveryServerLine() {
		return new GetDeliveryServerLine();
	}

	/**
	 * Create an instance of {@link ShippingAmount }
	 * 
	 */
	public ShippingAmount createShippingAmount() {
		return new ShippingAmount();
	}

	/**
	 * Create an instance of {@link Address }
	 * 
	 */
	public Address createAddress() {
		return new Address();
	}

	/**
	 * Create an instance of {@link ConfirmDeliveryMessageResponse }
	 * 
	 */
	public ConfirmDeliveryMessageResponse createConfirmDeliveryMessageResponse() {
		return new ConfirmDeliveryMessageResponse();
	}

	/**
	 * Create an instance of {@link IsRemoteAreaResponse }
	 * 
	 */
	public IsRemoteAreaResponse createIsRemoteAreaResponse() {
		return new IsRemoteAreaResponse();
	}

	/**
	 * Create an instance of {@link UpdateCurrency }
	 * 
	 */
	public UpdateCurrency createUpdateCurrency() {
		return new UpdateCurrency();
	}

	/**
	 * Create an instance of {@link CloseQuestion }
	 * 
	 */
	public CloseQuestion createCloseQuestion() {
		return new CloseQuestion();
	}

	/**
	 * Create an instance of {@link GetFedexDeliveryShippingMethodResponse }
	 * 
	 */
	public GetFedexDeliveryShippingMethodResponse createGetFedexDeliveryShippingMethodResponse() {
		return new GetFedexDeliveryShippingMethodResponse();
	}

	/**
	 * Create an instance of {@link UpdateApplyInfo }
	 * 
	 */
	public UpdateApplyInfo createUpdateApplyInfo() {
		return new UpdateApplyInfo();
	}

	/**
	 * Create an instance of {@link GetInvoiceResponse }
	 * 
	 */
	public GetInvoiceResponse createGetInvoiceResponse() {
		return new GetInvoiceResponse();
	}

	/**
	 * Create an instance of {@link ApplyCancelRepeatResponse }
	 * 
	 */
	public ApplyCancelRepeatResponse createApplyCancelRepeatResponse() {
		return new ApplyCancelRepeatResponse();
	}

	/**
	 * Create an instance of {@link ServiceLineFreightAmount }
	 * 
	 */
	public ServiceLineFreightAmount createServiceLineFreightAmount() {
		return new ServiceLineFreightAmount();
	}

	/**
	 * Create an instance of {@link PackageQuestionInfo }
	 * 
	 */
	public PackageQuestionInfo createPackageQuestionInfo() {
		return new PackageQuestionInfo();
	}

	/**
	 * Create an instance of {@link GetDeliveryShippingMethodResponse }
	 * 
	 */
	public GetDeliveryShippingMethodResponse createGetDeliveryShippingMethodResponse() {
		return new GetDeliveryShippingMethodResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderInfo }
	 * 
	 */
	public UpdateOrderInfo createUpdateOrderInfo() {
		return new UpdateOrderInfo();
	}

	/**
	 * Create an instance of {@link BoxInfo }
	 * 
	 */
	public BoxInfo createBoxInfo() {
		return new BoxInfo();
	}

	/**
	 * Create an instance of {@link OrderProductInfo }
	 * 
	 */
	public OrderProductInfo createOrderProductInfo() {
		return new OrderProductInfo();
	}

	/**
	 * Create an instance of {@link ConfirmCancelRepeat }
	 * 
	 */
	public ConfirmCancelRepeat createConfirmCancelRepeat() {
		return new ConfirmCancelRepeat();
	}

	/**
	 * Create an instance of {@link GetAmountResponse }
	 * 
	 */
	public GetAmountResponse createGetAmountResponse() {
		return new GetAmountResponse();
	}

	/**
	 * Create an instance of {@link Currency }
	 * 
	 */
	public Currency createCurrency() {
		return new Currency();
	}

	/**
	 * Create an instance of {@link ReceviceOrderQuestionProcessTypeResponse }
	 * 
	 */
	public ReceviceOrderQuestionProcessTypeResponse createReceviceOrderQuestionProcessTypeResponse() {
		return new ReceviceOrderQuestionProcessTypeResponse();
	}

	/**
	 * Create an instance of {@link GetInvoice }
	 * 
	 */
	public GetInvoice createGetInvoice() {
		return new GetInvoice();
	}

	/**
	 * Create an instance of {@link UpdateOrderWebFreight }
	 * 
	 */
	public UpdateOrderWebFreight createUpdateOrderWebFreight() {
		return new UpdateOrderWebFreight();
	}

	/**
	 * Create an instance of {@link UpdateOrderDeliveryInfo }
	 * 
	 */
	public UpdateOrderDeliveryInfo createUpdateOrderDeliveryInfo() {
		return new UpdateOrderDeliveryInfo();
	}

	/**
	 * Create an instance of {@link SetFBAFlag }
	 * 
	 */
	public SetFBAFlag createSetFBAFlag() {
		return new SetFBAFlag();
	}

	/**
	 * Create an instance of {@link GetPackageInfo }
	 * 
	 */
	public GetPackageInfo createGetPackageInfo() {
		return new GetPackageInfo();
	}

	/**
	 * Create an instance of {@link GetCheapestShippingMethodAndExpenseOSMS }
	 * 
	 */
	public GetCheapestShippingMethodAndExpenseOSMS createGetCheapestShippingMethodAndExpenseOSMS() {
		return new GetCheapestShippingMethodAndExpenseOSMS();
	}

	/**
	 * Create an instance of {@link ConfirmCancelRepeatResponse }
	 * 
	 */
	public ConfirmCancelRepeatResponse createConfirmCancelRepeatResponse() {
		return new ConfirmCancelRepeatResponse();
	}

	/**
	 * Create an instance of {@link GetCheapestShippingMethodAndExpense }
	 * 
	 */
	public GetCheapestShippingMethodAndExpense createGetCheapestShippingMethodAndExpense() {
		return new GetCheapestShippingMethodAndExpense();
	}

	/**
	 * Create an instance of {@link PackageInfo }
	 * 
	 */
	public PackageInfo createPackageInfo() {
		return new PackageInfo();
	}

	/**
	 * Create an instance of {@link Reopen }
	 * 
	 */
	public Reopen createReopen() {
		return new Reopen();
	}

	/**
	 * Create an instance of {@link ReceviceQuestionResponse }
	 * 
	 */
	public ReceviceQuestionResponse createReceviceQuestionResponse() {
		return new ReceviceQuestionResponse();
	}

	/**
	 * Create an instance of {@link CompletePackageTraceResponse }
	 * 
	 */
	public CompletePackageTraceResponse createCompletePackageTraceResponse() {
		return new CompletePackageTraceResponse();
	}

	/**
	 * Create an instance of {@link ReceviceOrderQuestionProcessType }
	 * 
	 */
	public ReceviceOrderQuestionProcessType createReceviceOrderQuestionProcessType() {
		return new ReceviceOrderQuestionProcessType();
	}

	/**
	 * Create an instance of {@link MergeOrder }
	 * 
	 */
	public MergeOrder createMergeOrder() {
		return new MergeOrder();
	}

	/**
	 * Create an instance of {@link BussinessException }
	 * 
	 */
	public BussinessException createBussinessException() {
		return new BussinessException();
	}

	/**
	 * Create an instance of {@link GetFedexAgentDeliveryShippingMethod }
	 * 
	 */
	public GetFedexAgentDeliveryShippingMethod createGetFedexAgentDeliveryShippingMethod() {
		return new GetFedexAgentDeliveryShippingMethod();
	}

	/**
	 * Create an instance of {@link PackageInfoQuery }
	 * 
	 */
	public PackageInfoQuery createPackageInfoQuery() {
		return new PackageInfoQuery();
	}

	/**
	 * Create an instance of {@link OrderInfo }
	 * 
	 */
	public OrderInfo createOrderInfo() {
		return new OrderInfo();
	}

	/**
	 * Create an instance of {@link ReceviceQuestion }
	 * 
	 */
	public ReceviceQuestion createReceviceQuestion() {
		return new ReceviceQuestion();
	}

	/**
	 * Create an instance of {@link InvoiceInfo }
	 * 
	 */
	public InvoiceInfo createInvoiceInfo() {
		return new InvoiceInfo();
	}

	/**
	 * Create an instance of {@link UpdateBoxBarCode }
	 * 
	 */
	public UpdateBoxBarCode createUpdateBoxBarCode() {
		return new UpdateBoxBarCode();
	}

	/**
	 * Create an instance of {@link GetDeliveryFreightAmount }
	 * 
	 */
	public GetDeliveryFreightAmount createGetDeliveryFreightAmount() {
		return new GetDeliveryFreightAmount();
	}

	/**
	 * Create an instance of {@link GetAllFreeShippingMethod }
	 * 
	 */
	public GetAllFreeShippingMethod createGetAllFreeShippingMethod() {
		return new GetAllFreeShippingMethod();
	}

	/**
	 * Create an instance of {@link GetDeliveryFreightAmountResponse }
	 * 
	 */
	public GetDeliveryFreightAmountResponse createGetDeliveryFreightAmountResponse() {
		return new GetDeliveryFreightAmountResponse();
	}

	/**
	 * Create an instance of {@link CurrencyInfo }
	 * 
	 */
	public CurrencyInfo createCurrencyInfo() {
		return new CurrencyInfo();
	}

	/**
	 * Create an instance of {@link MessageInfo }
	 * 
	 */
	public MessageInfo createMessageInfo() {
		return new MessageInfo();
	}

	/**
	 * Create an instance of {@link GetDeliveryWeight }
	 * 
	 */
	public GetDeliveryWeight createGetDeliveryWeight() {
		return new GetDeliveryWeight();
	}

	/**
	 * Create an instance of {@link UpdateOrderDeliveryInfoResponse }
	 * 
	 */
	public UpdateOrderDeliveryInfoResponse createUpdateOrderDeliveryInfoResponse() {
		return new UpdateOrderDeliveryInfoResponse();
	}

	/**
	 * Create an instance of {@link GetDeliveryShippingMethod }
	 * 
	 */
	public GetDeliveryShippingMethod createGetDeliveryShippingMethod() {
		return new GetDeliveryShippingMethod();
	}

	/**
	 * Create an instance of {@link UpdateOrderShippingAddress }
	 * 
	 */
	public UpdateOrderShippingAddress createUpdateOrderShippingAddress() {
		return new UpdateOrderShippingAddress();
	}

	/**
	 * Create an instance of {@link DMSBussinessException }
	 * 
	 */
	public DMSBussinessException createDMSBussinessException() {
		return new DMSBussinessException();
	}

	/**
	 * Create an instance of {@link IsRemoteArea }
	 * 
	 */
	public IsRemoteArea createIsRemoteArea() {
		return new IsRemoteArea();
	}

	/**
	 * Create an instance of {@link CompletePackageTrace }
	 * 
	 */
	public CompletePackageTrace createCompletePackageTrace() {
		return new CompletePackageTrace();
	}

	/**
	 * Create an instance of {@link UpdateOrderShippingAddressResponse }
	 * 
	 */
	public UpdateOrderShippingAddressResponse createUpdateOrderShippingAddressResponse() {
		return new UpdateOrderShippingAddressResponse();
	}

	/**
	 * Create an instance of {@link GetDeliveryMessage }
	 * 
	 */
	public GetDeliveryMessage createGetDeliveryMessage() {
		return new GetDeliveryMessage();
	}

	/**
	 * Create an instance of {@link UpdateCurrencyResponse }
	 * 
	 */
	public UpdateCurrencyResponse createUpdateCurrencyResponse() {
		return new UpdateCurrencyResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderShippingAddress2 }
	 * 
	 */
	public UpdateOrderShippingAddress2 createUpdateOrderShippingAddress2() {
		return new UpdateOrderShippingAddress2();
	}

	/**
	 * Create an instance of {@link UpdateOrderWebFreightResponse }
	 * 
	 */
	public UpdateOrderWebFreightResponse createUpdateOrderWebFreightResponse() {
		return new UpdateOrderWebFreightResponse();
	}

	/**
	 * Create an instance of {@link GetDeliveryServerLineResponse }
	 * 
	 */
	public GetDeliveryServerLineResponse createGetDeliveryServerLineResponse() {
		return new GetDeliveryServerLineResponse();
	}

	/**
	 * Create an instance of {@link GetPackageInfoResponse }
	 * 
	 */
	public GetPackageInfoResponse createGetPackageInfoResponse() {
		return new GetPackageInfoResponse();
	}

	/**
	 * Create an instance of {@link ConfirmDeliveryMessage }
	 * 
	 */
	public ConfirmDeliveryMessage createConfirmDeliveryMessage() {
		return new ConfirmDeliveryMessage();
	}

	/**
	 * Create an instance of {@link CancelMergeResponse }
	 * 
	 */
	public CancelMergeResponse createCancelMergeResponse() {
		return new CancelMergeResponse();
	}

	/**
	 * Create an instance of {@link UpdateBackOrderInfo }
	 * 
	 */
	public UpdateBackOrderInfo createUpdateBackOrderInfo() {
		return new UpdateBackOrderInfo();
	}

	/**
	 * Create an instance of {@link ReopenResponse }
	 * 
	 */
	public ReopenResponse createReopenResponse() {
		return new ReopenResponse();
	}

	/**
	 * Create an instance of {@link MergeOrderResponse }
	 * 
	 */
	public MergeOrderResponse createMergeOrderResponse() {
		return new MergeOrderResponse();
	}

	/**
	 * Create an instance of
	 * {@link GetCheapestShippingMethodAndExpenseOSMSResponse }
	 * 
	 */
	public GetCheapestShippingMethodAndExpenseOSMSResponse createGetCheapestShippingMethodAndExpenseOSMSResponse() {
		return new GetCheapestShippingMethodAndExpenseOSMSResponse();
	}

	/**
	 * Create an instance of {@link ServerLineInfo }
	 * 
	 */
	public ServerLineInfo createServerLineInfo() {
		return new ServerLineInfo();
	}

	/**
	 * Create an instance of {@link GetCheapestShippingMethodAndExpenseResponse }
	 * 
	 */
	public GetCheapestShippingMethodAndExpenseResponse createGetCheapestShippingMethodAndExpenseResponse() {
		return new GetCheapestShippingMethodAndExpenseResponse();
	}

	/**
	 * Create an instance of {@link FileType }
	 * 
	 */
	public FileType createFileType() {
		return new FileType();
	}

	/**
	 * Create an instance of {@link AddOrderResponse }
	 * 
	 */
	public AddOrderResponse createAddOrderResponse() {
		return new AddOrderResponse();
	}

	/**
	 * Create an instance of {@link InvoiceItemInfo }
	 * 
	 */
	public InvoiceItemInfo createInvoiceItemInfo() {
		return new InvoiceItemInfo();
	}

	/**
	 * Create an instance of {@link CancelMerge }
	 * 
	 */
	public CancelMerge createCancelMerge() {
		return new CancelMerge();
	}

	/**
	 * Create an instance of {@link CloseQuestionResponse }
	 * 
	 */
	public CloseQuestionResponse createCloseQuestionResponse() {
		return new CloseQuestionResponse();
	}

	/**
	 * Create an instance of {@link GetAmount }
	 * 
	 */
	public GetAmount createGetAmount() {
		return new GetAmount();
	}

	/**
	 * Create an instance of {@link ShippingWeight }
	 * 
	 */
	public ShippingWeight createShippingWeight() {
		return new ShippingWeight();
	}

	/**
	 * Create an instance of {@link GetDeliveryWeightResponse }
	 * 
	 */
	public GetDeliveryWeightResponse createGetDeliveryWeightResponse() {
		return new GetDeliveryWeightResponse();
	}

	/**
	 * Create an instance of {@link AccountSetting }
	 * 
	 */
	public AccountSetting createAccountSetting() {
		return new AccountSetting();
	}

	/**
	 * Create an instance of {@link UpdateBackOrderInfoResponse }
	 * 
	 */
	public UpdateBackOrderInfoResponse createUpdateBackOrderInfoResponse() {
		return new UpdateBackOrderInfoResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderInfoResponse }
	 * 
	 */
	public UpdateOrderInfoResponse createUpdateOrderInfoResponse() {
		return new UpdateOrderInfoResponse();
	}

	/**
	 * Create an instance of {@link GetFedexDeliveryShippingMethod }
	 * 
	 */
	public GetFedexDeliveryShippingMethod createGetFedexDeliveryShippingMethod() {
		return new GetFedexDeliveryShippingMethod();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderInfoResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateOrderInfoResponse")
	public JAXBElement<UpdateOrderInfoResponse> createUpdateOrderInfoResponse(UpdateOrderInfoResponse value) {
		return new JAXBElement<UpdateOrderInfoResponse>(_UpdateOrderInfoResponse_QNAME, UpdateOrderInfoResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDeliveryMessageResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getDeliveryMessageResponse")
	public JAXBElement<GetDeliveryMessageResponse> createGetDeliveryMessageResponse(GetDeliveryMessageResponse value) {
		return new JAXBElement<GetDeliveryMessageResponse>(_GetDeliveryMessageResponse_QNAME,
				GetDeliveryMessageResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDeliveryWeightResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getDeliveryWeightResponse")
	public JAXBElement<GetDeliveryWeightResponse> createGetDeliveryWeightResponse(GetDeliveryWeightResponse value) {
		return new JAXBElement<GetDeliveryWeightResponse>(_GetDeliveryWeightResponse_QNAME,
				GetDeliveryWeightResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetFedexDeliveryShippingMethod }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getFedexDeliveryShippingMethod")
	public JAXBElement<GetFedexDeliveryShippingMethod> createGetFedexDeliveryShippingMethod(
			GetFedexDeliveryShippingMethod value) {
		return new JAXBElement<GetFedexDeliveryShippingMethod>(_GetFedexDeliveryShippingMethod_QNAME,
				GetFedexDeliveryShippingMethod.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Reopen }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "reopen")
	public JAXBElement<Reopen> createReopen(Reopen value) {
		return new JAXBElement<Reopen>(_Reopen_QNAME, Reopen.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReceviceOrderQuestionProcessType }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "receviceOrderQuestionProcessType")
	public JAXBElement<ReceviceOrderQuestionProcessType> createReceviceOrderQuestionProcessType(
			ReceviceOrderQuestionProcessType value) {
		return new JAXBElement<ReceviceOrderQuestionProcessType>(_ReceviceOrderQuestionProcessType_QNAME,
				ReceviceOrderQuestionProcessType.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CloseQuestionResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "closeQuestionResponse")
	public JAXBElement<CloseQuestionResponse> createCloseQuestionResponse(CloseQuestionResponse value) {
		return new JAXBElement<CloseQuestionResponse>(_CloseQuestionResponse_QNAME, CloseQuestionResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ConfirmDeliveryMessage }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "confirmDeliveryMessage")
	public JAXBElement<ConfirmDeliveryMessage> createConfirmDeliveryMessage(ConfirmDeliveryMessage value) {
		return new JAXBElement<ConfirmDeliveryMessage>(_ConfirmDeliveryMessage_QNAME, ConfirmDeliveryMessage.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderShippingAddressResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateOrderShippingAddressResponse")
	public JAXBElement<UpdateOrderShippingAddressResponse> createUpdateOrderShippingAddressResponse(
			UpdateOrderShippingAddressResponse value) {
		return new JAXBElement<UpdateOrderShippingAddressResponse>(_UpdateOrderShippingAddressResponse_QNAME,
				UpdateOrderShippingAddressResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetInvoice }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getInvoice")
	public JAXBElement<GetInvoice> createGetInvoice(GetInvoice value) {
		return new JAXBElement<GetInvoice>(_GetInvoice_QNAME, GetInvoice.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateCurrencyResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateCurrencyResponse")
	public JAXBElement<UpdateCurrencyResponse> createUpdateCurrencyResponse(UpdateCurrencyResponse value) {
		return new JAXBElement<UpdateCurrencyResponse>(_UpdateCurrencyResponse_QNAME, UpdateCurrencyResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SetFBAFlag }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "setFBAFlag")
	public JAXBElement<SetFBAFlag> createSetFBAFlag(SetFBAFlag value) {
		return new JAXBElement<SetFBAFlag>(_SetFBAFlag_QNAME, SetFBAFlag.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetCheapestShippingMethodAndExpense }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getCheapestShippingMethodAndExpense")
	public JAXBElement<GetCheapestShippingMethodAndExpense> createGetCheapestShippingMethodAndExpense(
			GetCheapestShippingMethodAndExpense value) {
		return new JAXBElement<GetCheapestShippingMethodAndExpense>(_GetCheapestShippingMethodAndExpense_QNAME,
				GetCheapestShippingMethodAndExpense.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetCheapestShippingMethodAndExpenseResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getCheapestShippingMethodAndExpenseResponse")
	public JAXBElement<GetCheapestShippingMethodAndExpenseResponse> createGetCheapestShippingMethodAndExpenseResponse(
			GetCheapestShippingMethodAndExpenseResponse value) {
		return new JAXBElement<GetCheapestShippingMethodAndExpenseResponse>(
				_GetCheapestShippingMethodAndExpenseResponse_QNAME, GetCheapestShippingMethodAndExpenseResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDeliveryFreightAmount }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "GetDeliveryFreightAmount")
	public JAXBElement<GetDeliveryFreightAmount> createGetDeliveryFreightAmount(GetDeliveryFreightAmount value) {
		return new JAXBElement<GetDeliveryFreightAmount>(_GetDeliveryFreightAmount_QNAME,
				GetDeliveryFreightAmount.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetAllFreeShippingMethod }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getAllFreeShippingMethod")
	public JAXBElement<GetAllFreeShippingMethod> createGetAllFreeShippingMethod(GetAllFreeShippingMethod value) {
		return new JAXBElement<GetAllFreeShippingMethod>(_GetAllFreeShippingMethod_QNAME,
				GetAllFreeShippingMethod.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateBoxBarCode }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateBoxBarCode")
	public JAXBElement<UpdateBoxBarCode> createUpdateBoxBarCode(UpdateBoxBarCode value) {
		return new JAXBElement<UpdateBoxBarCode>(_UpdateBoxBarCode_QNAME, UpdateBoxBarCode.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDeliveryServerLineResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "GetDeliveryServerLineResponse")
	public JAXBElement<GetDeliveryServerLineResponse> createGetDeliveryServerLineResponse(
			GetDeliveryServerLineResponse value) {
		return new JAXBElement<GetDeliveryServerLineResponse>(_GetDeliveryServerLineResponse_QNAME,
				GetDeliveryServerLineResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDeliveryFreightAmountResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "GetDeliveryFreightAmountResponse")
	public JAXBElement<GetDeliveryFreightAmountResponse> createGetDeliveryFreightAmountResponse(
			GetDeliveryFreightAmountResponse value) {
		return new JAXBElement<GetDeliveryFreightAmountResponse>(_GetDeliveryFreightAmountResponse_QNAME,
				GetDeliveryFreightAmountResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link UpdateApplyInfo }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateApplyInfo")
	public JAXBElement<UpdateApplyInfo> createUpdateApplyInfo(UpdateApplyInfo value) {
		return new JAXBElement<UpdateApplyInfo>(_UpdateApplyInfo_QNAME, UpdateApplyInfo.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderWebFreight }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateOrderWebFreight")
	public JAXBElement<UpdateOrderWebFreight> createUpdateOrderWebFreight(UpdateOrderWebFreight value) {
		return new JAXBElement<UpdateOrderWebFreight>(_UpdateOrderWebFreight_QNAME, UpdateOrderWebFreight.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link BussinessException }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "BussinessException")
	public JAXBElement<BussinessException> createBussinessException(BussinessException value) {
		return new JAXBElement<BussinessException>(_BussinessException_QNAME, BussinessException.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SetFBAFlagResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "setFBAFlagResponse")
	public JAXBElement<SetFBAFlagResponse> createSetFBAFlagResponse(SetFBAFlagResponse value) {
		return new JAXBElement<SetFBAFlagResponse>(_SetFBAFlagResponse_QNAME, SetFBAFlagResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ConfirmDeliveryMessageResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "confirmDeliveryMessageResponse")
	public JAXBElement<ConfirmDeliveryMessageResponse> createConfirmDeliveryMessageResponse(
			ConfirmDeliveryMessageResponse value) {
		return new JAXBElement<ConfirmDeliveryMessageResponse>(_ConfirmDeliveryMessageResponse_QNAME,
				ConfirmDeliveryMessageResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ReopenResponse }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "reopenResponse")
	public JAXBElement<ReopenResponse> createReopenResponse(ReopenResponse value) {
		return new JAXBElement<ReopenResponse>(_ReopenResponse_QNAME, ReopenResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReceviceOrderQuestionProcessTypeResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "receviceOrderQuestionProcessTypeResponse")
	public JAXBElement<ReceviceOrderQuestionProcessTypeResponse> createReceviceOrderQuestionProcessTypeResponse(
			ReceviceOrderQuestionProcessTypeResponse value) {
		return new JAXBElement<ReceviceOrderQuestionProcessTypeResponse>(
				_ReceviceOrderQuestionProcessTypeResponse_QNAME, ReceviceOrderQuestionProcessTypeResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetFedexDeliveryShippingMethodResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getFedexDeliveryShippingMethodResponse")
	public JAXBElement<GetFedexDeliveryShippingMethodResponse> createGetFedexDeliveryShippingMethodResponse(
			GetFedexDeliveryShippingMethodResponse value) {
		return new JAXBElement<GetFedexDeliveryShippingMethodResponse>(_GetFedexDeliveryShippingMethodResponse_QNAME,
				GetFedexDeliveryShippingMethodResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDeliveryShippingMethod }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getDeliveryShippingMethod")
	public JAXBElement<GetDeliveryShippingMethod> createGetDeliveryShippingMethod(GetDeliveryShippingMethod value) {
		return new JAXBElement<GetDeliveryShippingMethod>(_GetDeliveryShippingMethod_QNAME,
				GetDeliveryShippingMethod.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetFedexAgentDeliveryShippingMethod }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getFedexAgentDeliveryShippingMethod")
	public JAXBElement<GetFedexAgentDeliveryShippingMethod> createGetFedexAgentDeliveryShippingMethod(
			GetFedexAgentDeliveryShippingMethod value) {
		return new JAXBElement<GetFedexAgentDeliveryShippingMethod>(_GetFedexAgentDeliveryShippingMethod_QNAME,
				GetFedexAgentDeliveryShippingMethod.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetInvoiceResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getInvoiceResponse")
	public JAXBElement<GetInvoiceResponse> createGetInvoiceResponse(GetInvoiceResponse value) {
		return new JAXBElement<GetInvoiceResponse>(_GetInvoiceResponse_QNAME, GetInvoiceResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderShippingAddress2 }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateOrderShippingAddress2")
	public JAXBElement<UpdateOrderShippingAddress2> createUpdateOrderShippingAddress2(UpdateOrderShippingAddress2 value) {
		return new JAXBElement<UpdateOrderShippingAddress2>(_UpdateOrderShippingAddress2_QNAME,
				UpdateOrderShippingAddress2.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDeliveryWeight }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getDeliveryWeight")
	public JAXBElement<GetDeliveryWeight> createGetDeliveryWeight(GetDeliveryWeight value) {
		return new JAXBElement<GetDeliveryWeight>(_GetDeliveryWeight_QNAME, GetDeliveryWeight.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetAmountResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getAmountResponse")
	public JAXBElement<GetAmountResponse> createGetAmountResponse(GetAmountResponse value) {
		return new JAXBElement<GetAmountResponse>(_GetAmountResponse_QNAME, GetAmountResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetCheapestShippingMethodAndExpenseOSMS }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getCheapestShippingMethodAndExpenseOSMS")
	public JAXBElement<GetCheapestShippingMethodAndExpenseOSMS> createGetCheapestShippingMethodAndExpenseOSMS(
			GetCheapestShippingMethodAndExpenseOSMS value) {
		return new JAXBElement<GetCheapestShippingMethodAndExpenseOSMS>(_GetCheapestShippingMethodAndExpenseOSMS_QNAME,
				GetCheapestShippingMethodAndExpenseOSMS.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ConfirmCancelRepeat }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "confirmCancelRepeat")
	public JAXBElement<ConfirmCancelRepeat> createConfirmCancelRepeat(ConfirmCancelRepeat value) {
		return new JAXBElement<ConfirmCancelRepeat>(_ConfirmCancelRepeat_QNAME, ConfirmCancelRepeat.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateBackOrderInfoResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateBackOrderInfoResponse")
	public JAXBElement<UpdateBackOrderInfoResponse> createUpdateBackOrderInfoResponse(UpdateBackOrderInfoResponse value) {
		return new JAXBElement<UpdateBackOrderInfoResponse>(_UpdateBackOrderInfoResponse_QNAME,
				UpdateBackOrderInfoResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateApplyInfoResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateApplyInfoResponse")
	public JAXBElement<UpdateApplyInfoResponse> createUpdateApplyInfoResponse(UpdateApplyInfoResponse value) {
		return new JAXBElement<UpdateApplyInfoResponse>(_UpdateApplyInfoResponse_QNAME, UpdateApplyInfoResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateBackOrderInfo }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateBackOrderInfo")
	public JAXBElement<UpdateBackOrderInfo> createUpdateBackOrderInfo(UpdateBackOrderInfo value) {
		return new JAXBElement<UpdateBackOrderInfo>(_UpdateBackOrderInfo_QNAME, UpdateBackOrderInfo.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DMSBussinessException }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "DMSBussinessException")
	public JAXBElement<DMSBussinessException> createDMSBussinessException(DMSBussinessException value) {
		return new JAXBElement<DMSBussinessException>(_DMSBussinessException_QNAME, DMSBussinessException.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderWebFreightResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateOrderWebFreightResponse")
	public JAXBElement<UpdateOrderWebFreightResponse> createUpdateOrderWebFreightResponse(
			UpdateOrderWebFreightResponse value) {
		return new JAXBElement<UpdateOrderWebFreightResponse>(_UpdateOrderWebFreightResponse_QNAME,
				UpdateOrderWebFreightResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CompletePackageTrace }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "completePackageTrace")
	public JAXBElement<CompletePackageTrace> createCompletePackageTrace(CompletePackageTrace value) {
		return new JAXBElement<CompletePackageTrace>(_CompletePackageTrace_QNAME, CompletePackageTrace.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReceviceQuestionResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "receviceQuestionResponse")
	public JAXBElement<ReceviceQuestionResponse> createReceviceQuestionResponse(ReceviceQuestionResponse value) {
		return new JAXBElement<ReceviceQuestionResponse>(_ReceviceQuestionResponse_QNAME,
				ReceviceQuestionResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link IsRemoteArea }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "isRemoteArea")
	public JAXBElement<IsRemoteArea> createIsRemoteArea(IsRemoteArea value) {
		return new JAXBElement<IsRemoteArea>(_IsRemoteArea_QNAME, IsRemoteArea.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CompletePackageTraceResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "completePackageTraceResponse")
	public JAXBElement<CompletePackageTraceResponse> createCompletePackageTraceResponse(
			CompletePackageTraceResponse value) {
		return new JAXBElement<CompletePackageTraceResponse>(_CompletePackageTraceResponse_QNAME,
				CompletePackageTraceResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderDeliveryInfo }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateOrderDeliveryInfo")
	public JAXBElement<UpdateOrderDeliveryInfo> createUpdateOrderDeliveryInfo(UpdateOrderDeliveryInfo value) {
		return new JAXBElement<UpdateOrderDeliveryInfo>(_UpdateOrderDeliveryInfo_QNAME, UpdateOrderDeliveryInfo.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CloseQuestion }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "closeQuestion")
	public JAXBElement<CloseQuestion> createCloseQuestion(CloseQuestion value) {
		return new JAXBElement<CloseQuestion>(_CloseQuestion_QNAME, CloseQuestion.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCurrency }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateCurrency")
	public JAXBElement<UpdateCurrency> createUpdateCurrency(UpdateCurrency value) {
		return new JAXBElement<UpdateCurrency>(_UpdateCurrency_QNAME, UpdateCurrency.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "addOrderResponse")
	public JAXBElement<AddOrderResponse> createAddOrderResponse(AddOrderResponse value) {
		return new JAXBElement<AddOrderResponse>(_AddOrderResponse_QNAME, AddOrderResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateBoxBarCodeResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateBoxBarCodeResponse")
	public JAXBElement<UpdateBoxBarCodeResponse> createUpdateBoxBarCodeResponse(UpdateBoxBarCodeResponse value) {
		return new JAXBElement<UpdateBoxBarCodeResponse>(_UpdateBoxBarCodeResponse_QNAME,
				UpdateBoxBarCodeResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderDeliveryInfoResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateOrderDeliveryInfoResponse")
	public JAXBElement<UpdateOrderDeliveryInfoResponse> createUpdateOrderDeliveryInfoResponse(
			UpdateOrderDeliveryInfoResponse value) {
		return new JAXBElement<UpdateOrderDeliveryInfoResponse>(_UpdateOrderDeliveryInfoResponse_QNAME,
				UpdateOrderDeliveryInfoResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CancelMerge }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "cancelMerge")
	public JAXBElement<CancelMerge> createCancelMerge(CancelMerge value) {
		return new JAXBElement<CancelMerge>(_CancelMerge_QNAME, CancelMerge.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link MergeOrder }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "mergeOrder")
	public JAXBElement<MergeOrder> createMergeOrder(MergeOrder value) {
		return new JAXBElement<MergeOrder>(_MergeOrder_QNAME, MergeOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderShippingAddress }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateOrderShippingAddress")
	public JAXBElement<UpdateOrderShippingAddress> createUpdateOrderShippingAddress(UpdateOrderShippingAddress value) {
		return new JAXBElement<UpdateOrderShippingAddress>(_UpdateOrderShippingAddress_QNAME,
				UpdateOrderShippingAddress.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderShippingAddress2Response }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateOrderShippingAddress2Response")
	public JAXBElement<UpdateOrderShippingAddress2Response> createUpdateOrderShippingAddress2Response(
			UpdateOrderShippingAddress2Response value) {
		return new JAXBElement<UpdateOrderShippingAddress2Response>(_UpdateOrderShippingAddress2Response_QNAME,
				UpdateOrderShippingAddress2Response.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ApplyCancelRepeat }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "applyCancelRepeat")
	public JAXBElement<ApplyCancelRepeat> createApplyCancelRepeat(ApplyCancelRepeat value) {
		return new JAXBElement<ApplyCancelRepeat>(_ApplyCancelRepeat_QNAME, ApplyCancelRepeat.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReceviceQuestion }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "receviceQuestion")
	public JAXBElement<ReceviceQuestion> createReceviceQuestion(ReceviceQuestion value) {
		return new JAXBElement<ReceviceQuestion>(_ReceviceQuestion_QNAME, ReceviceQuestion.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link IsRemoteAreaResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "isRemoteAreaResponse")
	public JAXBElement<IsRemoteAreaResponse> createIsRemoteAreaResponse(IsRemoteAreaResponse value) {
		return new JAXBElement<IsRemoteAreaResponse>(_IsRemoteAreaResponse_QNAME, IsRemoteAreaResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetPackageInfoResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getPackageInfoResponse")
	public JAXBElement<GetPackageInfoResponse> createGetPackageInfoResponse(GetPackageInfoResponse value) {
		return new JAXBElement<GetPackageInfoResponse>(_GetPackageInfoResponse_QNAME, GetPackageInfoResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDeliveryMessage }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getDeliveryMessage")
	public JAXBElement<GetDeliveryMessage> createGetDeliveryMessage(GetDeliveryMessage value) {
		return new JAXBElement<GetDeliveryMessage>(_GetDeliveryMessage_QNAME, GetDeliveryMessage.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ApplyCancelRepeatResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "applyCancelRepeatResponse")
	public JAXBElement<ApplyCancelRepeatResponse> createApplyCancelRepeatResponse(ApplyCancelRepeatResponse value) {
		return new JAXBElement<ApplyCancelRepeatResponse>(_ApplyCancelRepeatResponse_QNAME,
				ApplyCancelRepeatResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetAmount }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getAmount")
	public JAXBElement<GetAmount> createGetAmount(GetAmount value) {
		return new JAXBElement<GetAmount>(_GetAmount_QNAME, GetAmount.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDeliveryShippingMethodResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getDeliveryShippingMethodResponse")
	public JAXBElement<GetDeliveryShippingMethodResponse> createGetDeliveryShippingMethodResponse(
			GetDeliveryShippingMethodResponse value) {
		return new JAXBElement<GetDeliveryShippingMethodResponse>(_GetDeliveryShippingMethodResponse_QNAME,
				GetDeliveryShippingMethodResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link UpdateOrderInfo }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "updateOrderInfo")
	public JAXBElement<UpdateOrderInfo> createUpdateOrderInfo(UpdateOrderInfo value) {
		return new JAXBElement<UpdateOrderInfo>(_UpdateOrderInfo_QNAME, UpdateOrderInfo.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ConfirmCancelRepeatResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "confirmCancelRepeatResponse")
	public JAXBElement<ConfirmCancelRepeatResponse> createConfirmCancelRepeatResponse(ConfirmCancelRepeatResponse value) {
		return new JAXBElement<ConfirmCancelRepeatResponse>(_ConfirmCancelRepeatResponse_QNAME,
				ConfirmCancelRepeatResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link MergeOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "mergeOrderResponse")
	public JAXBElement<MergeOrderResponse> createMergeOrderResponse(MergeOrderResponse value) {
		return new JAXBElement<MergeOrderResponse>(_MergeOrderResponse_QNAME, MergeOrderResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetAllFreeShippingMethodResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getAllFreeShippingMethodResponse")
	public JAXBElement<GetAllFreeShippingMethodResponse> createGetAllFreeShippingMethodResponse(
			GetAllFreeShippingMethodResponse value) {
		return new JAXBElement<GetAllFreeShippingMethodResponse>(_GetAllFreeShippingMethodResponse_QNAME,
				GetAllFreeShippingMethodResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AddOrder }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "addOrder")
	public JAXBElement<AddOrder> createAddOrder(AddOrder value) {
		return new JAXBElement<AddOrder>(_AddOrder_QNAME, AddOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDeliveryServerLine }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "GetDeliveryServerLine")
	public JAXBElement<GetDeliveryServerLine> createGetDeliveryServerLine(GetDeliveryServerLine value) {
		return new JAXBElement<GetDeliveryServerLine>(_GetDeliveryServerLine_QNAME, GetDeliveryServerLine.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetCheapestShippingMethodAndExpenseOSMSResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getCheapestShippingMethodAndExpenseOSMSResponse")
	public JAXBElement<GetCheapestShippingMethodAndExpenseOSMSResponse> createGetCheapestShippingMethodAndExpenseOSMSResponse(
			GetCheapestShippingMethodAndExpenseOSMSResponse value) {
		return new JAXBElement<GetCheapestShippingMethodAndExpenseOSMSResponse>(
				_GetCheapestShippingMethodAndExpenseOSMSResponse_QNAME,
				GetCheapestShippingMethodAndExpenseOSMSResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CancelMergeResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "cancelMergeResponse")
	public JAXBElement<CancelMergeResponse> createCancelMergeResponse(CancelMergeResponse value) {
		return new JAXBElement<CancelMergeResponse>(_CancelMergeResponse_QNAME, CancelMergeResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetFedexAgentDeliveryShippingMethodResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getFedexAgentDeliveryShippingMethodResponse")
	public JAXBElement<GetFedexAgentDeliveryShippingMethodResponse> createGetFedexAgentDeliveryShippingMethodResponse(
			GetFedexAgentDeliveryShippingMethodResponse value) {
		return new JAXBElement<GetFedexAgentDeliveryShippingMethodResponse>(
				_GetFedexAgentDeliveryShippingMethodResponse_QNAME, GetFedexAgentDeliveryShippingMethodResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetPackageInfo }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://out.webservice.dms.itecheasy.com/", name = "getPackageInfo")
	public JAXBElement<GetPackageInfo> createGetPackageInfo(GetPackageInfo value) {
		return new JAXBElement<GetPackageInfo>(_GetPackageInfo_QNAME, GetPackageInfo.class, null, value);
	}

}
