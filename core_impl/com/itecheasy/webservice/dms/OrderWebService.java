package com.itecheasy.webservice.dms;

import java.math.BigDecimal;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * 
 */
@WebService(name = "OrderWebService", targetNamespace = "http://out.webservice.dms.itecheasy.com/")
public interface OrderWebService {

	/**
	 * 
	 * @param codes
	 * @param accountSetting
	 * @param sendGroupId
	 * @param operator
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "mergeOrder", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.MergeOrder")
	@ResponseWrapper(localName = "mergeOrderResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.MergeOrderResponse")
	public void mergeOrder(@WebParam(name = "codes", targetNamespace = "") List<String> codes,
			@WebParam(name = "sendGroupId", targetNamespace = "") Integer sendGroupId,
			@WebParam(name = "operator", targetNamespace = "") String operator,
			@WebParam(name = "accountSetting", targetNamespace = "") AccountSetting accountSetting)
			throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg3
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "receviceQuestion", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.ReceviceQuestion")
	@ResponseWrapper(localName = "receviceQuestionResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.ReceviceQuestionResponse")
	public void receviceQuestion(@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") String arg1,
			@WebParam(name = "arg2", targetNamespace = "") String arg2,
			@WebParam(name = "arg3", targetNamespace = "") List<FileType> arg3) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param codes
	 * @param accountSetting
	 * @param operator
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "cancelMerge", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.CancelMerge")
	@ResponseWrapper(localName = "cancelMergeResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.CancelMergeResponse")
	public void cancelMerge(@WebParam(name = "codes", targetNamespace = "") List<String> codes,
			@WebParam(name = "operator", targetNamespace = "") String operator,
			@WebParam(name = "accountSetting", targetNamespace = "") AccountSetting accountSetting)
			throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @throws BussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "reopen", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.Reopen")
	@ResponseWrapper(localName = "reopenResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.ReopenResponse")
	public void reopen(@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") String arg1) throws BussinessException_Exception;

	/**
	 * 
	 * @param arg5
	 * @param arg4
	 * @param arg3
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 * @return returns com.itecheasy.webservice.dms.ServerLineInfo
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod(operationName = "GetDeliveryServerLine")
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "GetDeliveryServerLine", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetDeliveryServerLine")
	@ResponseWrapper(localName = "GetDeliveryServerLineResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetDeliveryServerLineResponse")
	public ServerLineInfo getDeliveryServerLine(@WebParam(name = "arg0", targetNamespace = "") Integer arg0,
			@WebParam(name = "arg1", targetNamespace = "") Integer arg1,
			@WebParam(name = "arg2", targetNamespace = "") BigDecimal arg2,
			@WebParam(name = "arg3", targetNamespace = "") String arg3,
			@WebParam(name = "arg4", targetNamespace = "") String arg4,
			@WebParam(name = "arg5", targetNamespace = "") AccountSetting arg5) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg4
	 * @param orderCode
	 * @param barCode
	 * @param qty
	 * @param boxCode
	 * @param accountSetting
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "updateBoxBarCode", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateBoxBarCode")
	@ResponseWrapper(localName = "updateBoxBarCodeResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateBoxBarCodeResponse")
	public void updateBoxBarCode(@WebParam(name = "orderCode", targetNamespace = "") String orderCode,
			@WebParam(name = "boxCode", targetNamespace = "") String boxCode,
			@WebParam(name = "barCode", targetNamespace = "") String barCode,
			@WebParam(name = "qty", targetNamespace = "") BigDecimal qty,
			@WebParam(name = "arg4", targetNamespace = "") BigDecimal arg4,
			@WebParam(name = "accountSetting", targetNamespace = "") AccountSetting accountSetting)
			throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param orderCode
	 * @param account
	 * @param opernatorName
	 * @param type
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "receviceOrderQuestionProcessType", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.ReceviceOrderQuestionProcessType")
	@ResponseWrapper(localName = "receviceOrderQuestionProcessTypeResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.ReceviceOrderQuestionProcessTypeResponse")
	public void receviceOrderQuestionProcessType(@WebParam(name = "orderCode", targetNamespace = "") String orderCode,
			@WebParam(name = "opernatorName", targetNamespace = "") String opernatorName,
			@WebParam(name = "type", targetNamespace = "") Integer type,
			@WebParam(name = "account", targetNamespace = "") AccountSetting account)
			throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "addOrder", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.AddOrder")
	@ResponseWrapper(localName = "addOrderResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.AddOrderResponse")
	public void addOrder(@WebParam(name = "arg0", targetNamespace = "") OrderInfo arg0,
			@WebParam(name = "arg1", targetNamespace = "") AccountSetting arg1) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "completePackageTrace", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.CompletePackageTrace")
	@ResponseWrapper(localName = "completePackageTraceResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.CompletePackageTraceResponse")
	public void completePackageTrace(@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") AccountSetting arg1) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @return returns boolean
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "confirmDeliveryMessage", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.ConfirmDeliveryMessage")
	@ResponseWrapper(localName = "confirmDeliveryMessageResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.ConfirmDeliveryMessageResponse")
	public boolean confirmDeliveryMessage(@WebParam(name = "arg0", targetNamespace = "") List<Integer> arg0,
			@WebParam(name = "arg1", targetNamespace = "") AccountSetting arg1) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg5
	 * @param arg4
	 * @param arg3
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 * @return returns com.itecheasy.webservice.dms.ServiceLineFreightAmount
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getCheapestShippingMethodAndExpense", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetCheapestShippingMethodAndExpense")
	@ResponseWrapper(localName = "getCheapestShippingMethodAndExpenseResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetCheapestShippingMethodAndExpenseResponse")
	public ServiceLineFreightAmount getCheapestShippingMethodAndExpense(
			@WebParam(name = "arg0", targetNamespace = "") int arg0,
			@WebParam(name = "arg1", targetNamespace = "") BigDecimal arg1,
			@WebParam(name = "arg2", targetNamespace = "") int arg2,
			@WebParam(name = "arg3", targetNamespace = "") String arg3,
			@WebParam(name = "arg4", targetNamespace = "") String arg4,
			@WebParam(name = "arg5", targetNamespace = "") AccountSetting arg5) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 * @throws BussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "applyCancelRepeat", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.ApplyCancelRepeat")
	@ResponseWrapper(localName = "applyCancelRepeatResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.ApplyCancelRepeatResponse")
	public void applyCancelRepeat(@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") String arg1,
			@WebParam(name = "arg2", targetNamespace = "") int arg2) throws BussinessException_Exception;

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @return returns
	 *         java.util.List<com.itecheasy.webservice.dms.ShippingAmount>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getAmount", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetAmount")
	@ResponseWrapper(localName = "getAmountResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetAmountResponse")
	public List<ShippingAmount> getAmount(@WebParam(name = "arg0", targetNamespace = "") List<ShippingAmount> arg0,
			@WebParam(name = "arg1", targetNamespace = "") AccountSetting arg1);

	/**
	 * 
	 * @param arg5
	 * @param arg4
	 * @param arg3
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 * @return returns java.math.BigDecimal
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod(operationName = "GetDeliveryFreightAmount")
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "GetDeliveryFreightAmount", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetDeliveryFreightAmount")
	@ResponseWrapper(localName = "GetDeliveryFreightAmountResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetDeliveryFreightAmountResponse")
	public BigDecimal getDeliveryFreightAmount(@WebParam(name = "arg0", targetNamespace = "") Integer arg0,
			@WebParam(name = "arg1", targetNamespace = "") Integer arg1,
			@WebParam(name = "arg2", targetNamespace = "") BigDecimal arg2,
			@WebParam(name = "arg3", targetNamespace = "") String arg3,
			@WebParam(name = "arg4", targetNamespace = "") String arg4,
			@WebParam(name = "arg5", targetNamespace = "") AccountSetting arg5) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param orderInfoJson
	 * @param accountSetting
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "updateOrderInfo", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateOrderInfo")
	@ResponseWrapper(localName = "updateOrderInfoResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateOrderInfoResponse")
	public void updateOrderInfo(@WebParam(name = "orderInfoJson", targetNamespace = "") String orderInfoJson,
			@WebParam(name = "accountSetting", targetNamespace = "") AccountSetting accountSetting)
			throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "updateCurrency", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateCurrency")
	@ResponseWrapper(localName = "updateCurrencyResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateCurrencyResponse")
	public void updateCurrency(@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") BigDecimal arg1) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @throws BussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "confirmCancelRepeat", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.ConfirmCancelRepeat")
	@ResponseWrapper(localName = "confirmCancelRepeatResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.ConfirmCancelRepeatResponse")
	public void confirmCancelRepeat(@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") String arg1) throws BussinessException_Exception;

	/**
	 * 
	 * @param content
	 * @param orderCode
	 * @param accountSetting
	 * @param type
	 * @param operator
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "updateBackOrderInfo", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateBackOrderInfo")
	@ResponseWrapper(localName = "updateBackOrderInfoResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateBackOrderInfoResponse")
	public void updateBackOrderInfo(@WebParam(name = "orderCode", targetNamespace = "") String orderCode,
			@WebParam(name = "content", targetNamespace = "") String content,
			@WebParam(name = "type", targetNamespace = "") Integer type,
			@WebParam(name = "operator", targetNamespace = "") String operator,
			@WebParam(name = "accountSetting", targetNamespace = "") AccountSetting accountSetting)
			throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg0
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "closeQuestion", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.CloseQuestion")
	@ResponseWrapper(localName = "closeQuestionResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.CloseQuestionResponse")
	public void closeQuestion(@WebParam(name = "arg0", targetNamespace = "") String arg0)
			throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg5
	 * @param arg4
	 * @param arg3
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 * @param arg6
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "updateOrderShippingAddress2", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateOrderShippingAddress2")
	@ResponseWrapper(localName = "updateOrderShippingAddress2Response", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateOrderShippingAddress2Response")
	public void updateOrderShippingAddress2(@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") Integer arg1,
			@WebParam(name = "arg2", targetNamespace = "") Address arg2,
			@WebParam(name = "arg3", targetNamespace = "") boolean arg3,
			@WebParam(name = "arg4", targetNamespace = "") BigDecimal arg4,
			@WebParam(name = "arg5", targetNamespace = "") AccountSetting arg5,
			@WebParam(name = "arg6", targetNamespace = "") boolean arg6) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @throws BussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "updateApplyInfo", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateApplyInfo")
	@ResponseWrapper(localName = "updateApplyInfoResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateApplyInfoResponse")
	public void updateApplyInfo(@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") String arg1) throws BussinessException_Exception;

	/**
	 * 
	 * @param arg5
	 * @param arg4
	 * @param arg3
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 * @return returns int
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getCheapestShippingMethodAndExpenseOSMS", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetCheapestShippingMethodAndExpenseOSMS")
	@ResponseWrapper(localName = "getCheapestShippingMethodAndExpenseOSMSResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetCheapestShippingMethodAndExpenseOSMSResponse")
	public int getCheapestShippingMethodAndExpenseOSMS(
			@WebParam(name = "arg0", targetNamespace = "") List<Integer> arg0,
			@WebParam(name = "arg1", targetNamespace = "") BigDecimal arg1,
			@WebParam(name = "arg2", targetNamespace = "") int arg2,
			@WebParam(name = "arg3", targetNamespace = "") String arg3,
			@WebParam(name = "arg4", targetNamespace = "") String arg4,
			@WebParam(name = "arg5", targetNamespace = "") AccountSetting arg5) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg4
	 * @param arg3
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 * @return returns int
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getFedexAgentDeliveryShippingMethod", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetFedexAgentDeliveryShippingMethod")
	@ResponseWrapper(localName = "getFedexAgentDeliveryShippingMethodResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetFedexAgentDeliveryShippingMethodResponse")
	public int getFedexAgentDeliveryShippingMethod(@WebParam(name = "arg0", targetNamespace = "") Integer arg0,
			@WebParam(name = "arg1", targetNamespace = "") BigDecimal arg1,
			@WebParam(name = "arg2", targetNamespace = "") String arg2,
			@WebParam(name = "arg3", targetNamespace = "") String arg3,
			@WebParam(name = "arg4", targetNamespace = "") AccountSetting arg4) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg4
	 * @param arg3
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 * @return returns boolean
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "isRemoteArea", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.IsRemoteArea")
	@ResponseWrapper(localName = "isRemoteAreaResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.IsRemoteAreaResponse")
	public boolean isRemoteArea(@WebParam(name = "arg0", targetNamespace = "") Integer arg0,
			@WebParam(name = "arg1", targetNamespace = "") Integer arg1,
			@WebParam(name = "arg2", targetNamespace = "") String arg2,
			@WebParam(name = "arg3", targetNamespace = "") String arg3,
			@WebParam(name = "arg4", targetNamespace = "") AccountSetting arg4) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @return returns java.math.BigDecimal
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getDeliveryWeight", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetDeliveryWeight")
	@ResponseWrapper(localName = "getDeliveryWeightResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetDeliveryWeightResponse")
	public BigDecimal getDeliveryWeight(@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") Integer arg1) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param flag
	 * @param orderCode
	 * @param account
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "setFBAFlag", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.SetFBAFlag")
	@ResponseWrapper(localName = "setFBAFlagResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.SetFBAFlagResponse")
	public void setFBAFlag(@WebParam(name = "orderCode", targetNamespace = "") String orderCode,
			@WebParam(name = "flag", targetNamespace = "") Boolean flag,
			@WebParam(name = "account", targetNamespace = "") AccountSetting account)
			throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "updateOrderWebFreight", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateOrderWebFreight")
	@ResponseWrapper(localName = "updateOrderWebFreightResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateOrderWebFreightResponse")
	public void updateOrderWebFreight(@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") BigDecimal arg1,
			@WebParam(name = "arg2", targetNamespace = "") AccountSetting arg2) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @return returns java.util.List<java.lang.Integer>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getAllFreeShippingMethod", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetAllFreeShippingMethod")
	@ResponseWrapper(localName = "getAllFreeShippingMethodResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetAllFreeShippingMethodResponse")
	public List<Integer> getAllFreeShippingMethod();

	/**
	 * 
	 * @param arg5
	 * @param arg4
	 * @param arg3
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 * @return returns int
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getDeliveryShippingMethod", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetDeliveryShippingMethod")
	@ResponseWrapper(localName = "getDeliveryShippingMethodResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetDeliveryShippingMethodResponse")
	public int getDeliveryShippingMethod(@WebParam(name = "arg0", targetNamespace = "") Integer arg0,
			@WebParam(name = "arg1", targetNamespace = "") List<ShippingWeight> arg1,
			@WebParam(name = "arg2", targetNamespace = "") String arg2,
			@WebParam(name = "arg3", targetNamespace = "") String arg3,
			@WebParam(name = "arg4", targetNamespace = "") Boolean arg4,
			@WebParam(name = "arg5", targetNamespace = "") AccountSetting arg5) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg5
	 * @param arg4
	 * @param arg3
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "updateOrderShippingAddress", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateOrderShippingAddress")
	@ResponseWrapper(localName = "updateOrderShippingAddressResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateOrderShippingAddressResponse")
	public void updateOrderShippingAddress(@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") Integer arg1,
			@WebParam(name = "arg2", targetNamespace = "") Address arg2,
			@WebParam(name = "arg3", targetNamespace = "") boolean arg3,
			@WebParam(name = "arg4", targetNamespace = "") BigDecimal arg4,
			@WebParam(name = "arg5", targetNamespace = "") AccountSetting arg5) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @return returns com.itecheasy.webservice.dms.InvoiceInfo
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getInvoice", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetInvoice")
	@ResponseWrapper(localName = "getInvoiceResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetInvoiceResponse")
	public InvoiceInfo getInvoice(@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") AccountSetting arg1) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param orderCode
	 * @param accountSetting
	 * @param deliveryFlag
	 * @param operator
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@RequestWrapper(localName = "updateOrderDeliveryInfo", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateOrderDeliveryInfo")
	@ResponseWrapper(localName = "updateOrderDeliveryInfoResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.UpdateOrderDeliveryInfoResponse")
	public void updateOrderDeliveryInfo(@WebParam(name = "orderCode", targetNamespace = "") String orderCode,
			@WebParam(name = "deliveryFlag", targetNamespace = "") boolean deliveryFlag,
			@WebParam(name = "operator", targetNamespace = "") String operator,
			@WebParam(name = "accountSetting", targetNamespace = "") AccountSetting accountSetting)
			throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg4
	 * @param arg3
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 * @return returns int
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getFedexDeliveryShippingMethod", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetFedexDeliveryShippingMethod")
	@ResponseWrapper(localName = "getFedexDeliveryShippingMethodResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetFedexDeliveryShippingMethodResponse")
	public int getFedexDeliveryShippingMethod(@WebParam(name = "arg0", targetNamespace = "") Integer arg0,
			@WebParam(name = "arg1", targetNamespace = "") BigDecimal arg1,
			@WebParam(name = "arg2", targetNamespace = "") String arg2,
			@WebParam(name = "arg3", targetNamespace = "") String arg3,
			@WebParam(name = "arg4", targetNamespace = "") AccountSetting arg4) throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg0
	 * @return returns java.util.List<com.itecheasy.webservice.dms.MessageInfo>
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getDeliveryMessage", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetDeliveryMessage")
	@ResponseWrapper(localName = "getDeliveryMessageResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetDeliveryMessageResponse")
	public List<MessageInfo> getDeliveryMessage(@WebParam(name = "arg0", targetNamespace = "") AccountSetting arg0)
			throws DMSBussinessException_Exception;

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @return returns java.util.List<com.itecheasy.webservice.dms.PackageInfo>
	 * @throws DMSBussinessException_Exception
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getPackageInfo", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetPackageInfo")
	@ResponseWrapper(localName = "getPackageInfoResponse", targetNamespace = "http://out.webservice.dms.itecheasy.com/", className = "com.itecheasy.webservice.dms.GetPackageInfoResponse")
	public List<PackageInfo> getPackageInfo(@WebParam(name = "arg0", targetNamespace = "") PackageInfoQuery arg0,
			@WebParam(name = "arg1", targetNamespace = "") AccountSetting arg1) throws DMSBussinessException_Exception;

}
