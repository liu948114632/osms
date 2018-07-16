package com.itecheasy.webservice.cms.order;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.itecheasy.webservice.cms.order
 * package.
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

	private final static QName _AddMultiOrderItemResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"addMultiOrderItemResponse");
	private final static QName _AddOrderItem_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"addOrderItem");
	private final static QName _UpdateOrderCountry_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderCountry");
	private final static QName _CancleMultiOrderItem_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"cancleMultiOrderItem");
	private final static QName _GetOrderOperatorLogById_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderOperatorLogById");
	private final static QName _UpdateIsCanSend_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateIsCanSend");
	private final static QName _DealOrderModifyRecordResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "dealOrderModifyRecordResponse");
	private final static QName _GetOrderModifyRecordOperatorLogByIdResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderModifyRecordOperatorLogByIdResponse");
	private final static QName _ApplayOrderResendResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"applayOrderResendResponse");
	private final static QName _GetAttachmentByCode_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getAttachmentByCode");
	private final static QName _SplitOrderResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"splitOrderResponse");
	private final static QName _ApplayOrderCancle_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"applayOrderCancle");
	private final static QName _GetOrderItemOperatorLogByIdResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderItemOperatorLogByIdResponse");
	private final static QName _CancelProcessingOrderItemResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "cancelProcessingOrderItemResponse");
	private final static QName _CreatePendingOrder_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"createPendingOrder");
	private final static QName _UpdateOrderItemRemark_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderItemRemark");
	private final static QName _SendToCustomerResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"sendToCustomerResponse");
	private final static QName _UpdateItemPrice_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateItemPrice");
	private final static QName _ApplayOrderCancleResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"applayOrderCancleResponse");
	private final static QName _ReplaceOrder_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"replaceOrder");
	private final static QName _GetOrderModifyRecordOperatorLogsById_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderModifyRecordOperatorLogsById");
	private final static QName _AddReportOrder_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"addReportOrder");
	private final static QName _GetOrderByCode_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderByCode");
	private final static QName _RequestProcessingOrderItem_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "requestProcessingOrderItem");
	private final static QName _GetOrderItemOperatorLogById_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderItemOperatorLogById");
	private final static QName _GetOrderItemRelateBoxsByOrderItemId_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderItemRelateBoxsByOrderItemId");
	private final static QName _UpdateOrderResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderResponse");
	private final static QName _CompleteOrder_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"completeOrder");
	private final static QName _BussinessException_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"BussinessException");
	private final static QName _GetOrderApplayOperatorLogResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderApplayOperatorLogResponse");
	private final static QName _GetDeliveryLimiteInfoResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getDeliveryLimiteInfoResponse");
	private final static QName _ReplaceOrderItemResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"replaceOrderItemResponse");
	private final static QName _GetOrderItemRelateBoxsByOrderItemIdResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderItemRelateBoxsByOrderItemIdResponse");
	private final static QName _CancleOrderItemResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"cancleOrderItemResponse");
	private final static QName _GetOrderReadySellLackLogResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderReadySellLackLogResponse");
	private final static QName _GetOrderReadySellLackLog_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderReadySellLackLog");
	private final static QName _OrderSetQuality_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"orderSetQuality");
	private final static QName _GetOrderById_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderById");
	private final static QName _GetOrderModifyRecordOperatorLogById_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderModifyRecordOperatorLogById");
	private final static QName _RemoveOrderGroupResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"removeOrderGroupResponse");
	private final static QName _UpdateOrderRemark_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderRemark");
	private final static QName _SetConsultationUser_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"setConsultationUser");
	private final static QName _DealOrderCommunicationLogResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "dealOrderCommunicationLogResponse");
	private final static QName _UpdateOrderDeliveryInfo_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderDeliveryInfo");
	private final static QName _GetLastOrderWeighingRecordByOrderCodeResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getLastOrderWeighingRecordByOrderCodeResponse");
	private final static QName _SetOrderTracking_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"setOrderTracking");
	private final static QName _UpdateOrderItemRemarkResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateOrderItemRemarkResponse");
	private final static QName _GetApplayByIdResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getApplayByIdResponse");
	private final static QName _GetOrderModifyRecordByIdResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderModifyRecordByIdResponse");
	private final static QName _CancelProcessingOrderItem_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"cancelProcessingOrderItem");
	private final static QName _UpdateMultiOrderItem_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateMultiOrderItem");
	private final static QName _SendReadyOrderItemsResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "sendReadyOrderItemsResponse");
	private final static QName _RequestProcessingOrderItemResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "requestProcessingOrderItemResponse");
	private final static QName _SendReadyOrderItems_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"sendReadyOrderItems");
	private final static QName _GetOrderTrackingReplayHistory_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderTrackingReplayHistory");
	private final static QName _UpdateMultiOrderItemResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateMultiOrderItemResponse");
	private final static QName _ApplayOrderResend_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"applayOrderResend");
	private final static QName _FindOrderTrackingResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"findOrderTrackingResponse");
	private final static QName _GetOrderItemByOrderIdResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderItemByOrderIdResponse");
	private final static QName _OrderSetQualityResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"orderSetQualityResponse");
	private final static QName _UpdateOrderHandler_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderHandler");
	private final static QName _UpdateMutilOrderItemRemarkResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateMutilOrderItemRemarkResponse");
	private final static QName _GetOrderByCodeResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderByCodeResponse");
	private final static QName _SetOrderTrackingRemarkResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "setOrderTrackingRemarkResponse");
	private final static QName _UpdateOrderHandlerByCustomerResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateOrderHandlerByCustomerResponse");
	private final static QName _RemoveOrderGroup_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"removeOrderGroup");
	private final static QName _CompleteOrderTracking_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"completeOrderTracking");
	private final static QName _GetAttachmentByCodeResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getAttachmentByCodeResponse");
	private final static QName _GetApplayById_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getApplayById");
	private final static QName _CancleMultiOrderItemResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "cancleMultiOrderItemResponse");
	private final static QName _UpdateIsCanSendResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateIsCanSendResponse");
	private final static QName _UpdateOrderGroupResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderGroupResponse");
	private final static QName _UpdateOrderRemarkResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderRemarkResponse");
	private final static QName _GetOrderModifyRecords_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderModifyRecords");
	private final static QName _GetOrderApplayOperatorLogById_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderApplayOperatorLogById");
	private final static QName _UpdateOrderItemResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderItemResponse");
	private final static QName _CancleOrder_QNAME = new QName("http://osms.communication.itecheasy.com/", "cancleOrder");
	private final static QName _GetApplayItemsByApplayId_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getApplayItemsByApplayId");
	private final static QName _GetDeliveryLimiteInfo_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getDeliveryLimiteInfo");
	private final static QName _UpdateOrderItem_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderItem");
	private final static QName _UpdateOrderGroup_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderGroup");
	private final static QName _ReplyOrderTracking_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"replyOrderTracking");
	private final static QName _CompleteMultiOrder_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"completeMultiOrder");
	private final static QName _GetOrderModifyRecordsResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderModifyRecordsResponse");
	private final static QName _UpdateOrderItemWeightResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateOrderItemWeightResponse");
	private final static QName _AddReportOrderResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"addReportOrderResponse");
	private final static QName _SetOrderTrackingRemark_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"setOrderTrackingRemark");
	private final static QName _UpdateOrder_QNAME = new QName("http://osms.communication.itecheasy.com/", "updateOrder");
	private final static QName _DealOrderReadySellLackLogResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "dealOrderReadySellLackLogResponse");
	private final static QName _GetOrderTrackingOperatorLog_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderTrackingOperatorLog");
	private final static QName _GetLastOrderWeighingRecordByOrderCode_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getLastOrderWeighingRecordByOrderCode");
	private final static QName _GetOrderTrackingReplayHistoryResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderTrackingReplayHistoryResponse");
	private final static QName _ReplaceOrderItem_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"replaceOrderItem");
	private final static QName _CompleteOrderTrackingResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "completeOrderTrackingResponse");
	private final static QName _DealOrderReadySellLackLog_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"dealOrderReadySellLackLog");
	private final static QName _UpdateOrderDiscount_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderDiscount");
	private final static QName _UpdateOrderItemWeight_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderItemWeight");
	private final static QName _GetApplayItemsByApplayIdResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getApplayItemsByApplayIdResponse");
	private final static QName _DealOrderCommunicationLogSuccessResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "dealOrderCommunicationLogSuccessResponse");
	private final static QName _SetConsultationUserResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "setConsultationUserResponse");
	private final static QName _UpdateOrderDelivery_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderDelivery");
	private final static QName _GetOrderTrackingById_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderTrackingById");
	private final static QName _SendToCustomer_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"sendToCustomer");
	private final static QName _ReplaceOrderResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"replaceOrderResponse");
	private final static QName _SplitOrder_QNAME = new QName("http://osms.communication.itecheasy.com/", "splitOrder");
	private final static QName _GetOrderApplayOperatorLog_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderApplayOperatorLog");
	private final static QName _GetOrderModifyRecordOperatorLog_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderModifyRecordOperatorLog");
	private final static QName _DealOrderCommunicationLog_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"dealOrderCommunicationLog");
	private final static QName _RequestCollateOrderResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "requestCollateOrderResponse");
	private final static QName _CreatePendingOrderResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "createPendingOrderResponse");
	private final static QName _UpdateOrderPayStatusResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateOrderPayStatusResponse");
	private final static QName _GetOrderOperatorLog_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderOperatorLog");
	private final static QName _GetOrderItemById_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderItemById");
	private final static QName _UpdateOrderCountryResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateOrderCountryResponse");
	private final static QName _GetOrderByIdResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderByIdResponse");
	private final static QName _UpdateOrderHandlerResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateOrderHandlerResponse");
	private final static QName _GetOrderModifyRecordById_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderModifyRecordById");
	private final static QName _AddAttachmentFileResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"addAttachmentFileResponse");
	private final static QName _UpdateMutilOrderItemRemark_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateMutilOrderItemRemark");
	private final static QName _UpdateOrderDeliveryResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateOrderDeliveryResponse");
	private final static QName _GetOrderItemOperatorLog_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderItemOperatorLog");
	private final static QName _GetOrderItemByIdResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderItemByIdResponse");
	private final static QName _UpdateOrderItemQuantityResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateOrderItemQuantityResponse");
	private final static QName _UpdateItemPriceResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateItemPriceResponse");
	private final static QName _UpdateOrderDeliveryInfoResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateOrderDeliveryInfoResponse");
	private final static QName _GetOrderCommunicationLogResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderCommunicationLogResponse");
	private final static QName _AddOrderResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"addOrderResponse");
	private final static QName _ApplayOrderShelve_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"applayOrderShelve");
	private final static QName _UpdateOrderPayStatus_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderPayStatus");
	private final static QName _IsAssigningOrderResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"isAssigningOrderResponse");
	private final static QName _GetOrderItemOperatorLogResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderItemOperatorLogResponse");
	private final static QName _GetOrderItemByOrderId_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderItemByOrderId");
	private final static QName _DelOrderTrackingResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"delOrderTrackingResponse");
	private final static QName _GetOrderTrackingOperatorLogResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderTrackingOperatorLogResponse");
	private final static QName _UpdateOrderHandlerCodeResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateOrderHandlerCodeResponse");
	private final static QName _CancleOrderResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"cancleOrderResponse");
	private final static QName _GetOrderTrackingOperatorLogById_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderTrackingOperatorLogById");
	private final static QName _GetOrderOperatorLogByIdResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderOperatorLogByIdResponse");
	private final static QName _AddMultiOrderItem_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"addMultiOrderItem");
	private final static QName _UpdateOrderHandlerByCustomer_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateOrderHandlerByCustomer");
	private final static QName _UpdateOrderHandlerCode_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderHandlerCode");
	private final static QName _FindOrderTracking_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"findOrderTracking");
	private final static QName _RequestCollateOrder_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"requestCollateOrder");
	private final static QName _GetOrderModifyRecordOperatorLogsResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderModifyRecordOperatorLogsResponse");
	private final static QName _DealOrderModifyRecord_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"dealOrderModifyRecord");
	private final static QName _UpdateOrderItemQuantity_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"updateOrderItemQuantity");
	private final static QName _GetOrderModifyRecordOperatorLogs_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderModifyRecordOperatorLogs");
	private final static QName _DealOrderCommunicationLogSuccess_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "dealOrderCommunicationLogSuccess");
	private final static QName _GetOrderTrackingOperatorLogByIdResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderTrackingOperatorLogByIdResponse");
	private final static QName _CompleteMultiOrderResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "completeMultiOrderResponse");
	private final static QName _AddOrder_QNAME = new QName("http://osms.communication.itecheasy.com/", "addOrder");
	private final static QName _ReplyOrderTrackingResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "replyOrderTrackingResponse");
	private final static QName _IsAssigningOrder_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"isAssigningOrder");
	private final static QName _CancleOrderItem_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"cancleOrderItem");
	private final static QName _GetOrderModifyRecordOperatorLogResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderModifyRecordOperatorLogResponse");
	private final static QName _UpdateOrderDiscountResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "updateOrderDiscountResponse");
	private final static QName _AddOrderItemResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"addOrderItemResponse");
	private final static QName _CompleteOrderResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"completeOrderResponse");
	private final static QName _AddAttachmentFile_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"addAttachmentFile");
	private final static QName _GetOrderModifyRecordOperatorLogsByIdResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderModifyRecordOperatorLogsByIdResponse");
	private final static QName _GetOrderTrackingByIdResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderTrackingByIdResponse");
	private final static QName _ApplayOrderShelveResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"applayOrderShelveResponse");
	private final static QName _GetOrderCommunicationLog_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"getOrderCommunicationLog");
	private final static QName _SetOrderTrackingResponse_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"setOrderTrackingResponse");
	private final static QName _DelOrderTracking_QNAME = new QName("http://osms.communication.itecheasy.com/",
			"delOrderTracking");
	private final static QName _GetOrderOperatorLogResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderOperatorLogResponse");
	private final static QName _GetOrderApplayOperatorLogByIdResponse_QNAME = new QName(
			"http://osms.communication.itecheasy.com/", "getOrderApplayOperatorLogByIdResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.itecheasy.webservice.cms.order
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link CancleOrderItem }
	 * 
	 */
	public CancleOrderItem createCancleOrderItem() {
		return new CancleOrderItem();
	}

	/**
	 * Create an instance of {@link GetLastOrderWeighingRecordByOrderCode }
	 * 
	 */
	public GetLastOrderWeighingRecordByOrderCode createGetLastOrderWeighingRecordByOrderCode() {
		return new GetLastOrderWeighingRecordByOrderCode();
	}

	/**
	 * Create an instance of {@link GetApplayItemsByApplayIdResponse }
	 * 
	 */
	public GetApplayItemsByApplayIdResponse createGetApplayItemsByApplayIdResponse() {
		return new GetApplayItemsByApplayIdResponse();
	}

	/**
	 * Create an instance of {@link ApplayOrderShelveResponse }
	 * 
	 */
	public ApplayOrderShelveResponse createApplayOrderShelveResponse() {
		return new ApplayOrderShelveResponse();
	}

	/**
	 * Create an instance of {@link OrderShippingAddress }
	 * 
	 */
	public OrderShippingAddress createOrderShippingAddress() {
		return new OrderShippingAddress();
	}

	/**
	 * Create an instance of {@link DelOrderTrackingResponse }
	 * 
	 */
	public DelOrderTrackingResponse createDelOrderTrackingResponse() {
		return new DelOrderTrackingResponse();
	}

	/**
	 * Create an instance of {@link SplitOrderResponse }
	 * 
	 */
	public SplitOrderResponse createSplitOrderResponse() {
		return new SplitOrderResponse();
	}

	/**
	 * Create an instance of {@link GetOrderItemByIdResponse }
	 * 
	 */
	public GetOrderItemByIdResponse createGetOrderItemByIdResponse() {
		return new GetOrderItemByIdResponse();
	}

	/**
	 * Create an instance of {@link CancleOrder }
	 * 
	 */
	public CancleOrder createCancleOrder() {
		return new CancleOrder();
	}

	/**
	 * Create an instance of {@link UpdateOrderCountryResponse }
	 * 
	 */
	public UpdateOrderCountryResponse createUpdateOrderCountryResponse() {
		return new UpdateOrderCountryResponse();
	}

	/**
	 * Create an instance of {@link UpdateItemPrice }
	 * 
	 */
	public UpdateItemPrice createUpdateItemPrice() {
		return new UpdateItemPrice();
	}

	/**
	 * Create an instance of {@link UpdateMutilOrderItemRemark }
	 * 
	 */
	public UpdateMutilOrderItemRemark createUpdateMutilOrderItemRemark() {
		return new UpdateMutilOrderItemRemark();
	}

	/**
	 * Create an instance of {@link SetOrderTracking }
	 * 
	 */
	public SetOrderTracking createSetOrderTracking() {
		return new SetOrderTracking();
	}

	/**
	 * Create an instance of {@link GetOrderItemOperatorLogResponse }
	 * 
	 */
	public GetOrderItemOperatorLogResponse createGetOrderItemOperatorLogResponse() {
		return new GetOrderItemOperatorLogResponse();
	}

	/**
	 * Create an instance of {@link DelOrderTracking }
	 * 
	 */
	public DelOrderTracking createDelOrderTracking() {
		return new DelOrderTracking();
	}

	/**
	 * Create an instance of {@link GetOrderOperatorLogByIdResponse }
	 * 
	 */
	public GetOrderOperatorLogByIdResponse createGetOrderOperatorLogByIdResponse() {
		return new GetOrderOperatorLogByIdResponse();
	}

	/**
	 * Create an instance of {@link AddOrderItem }
	 * 
	 */
	public AddOrderItem createAddOrderItem() {
		return new AddOrderItem();
	}

	/**
	 * Create an instance of {@link RequestCollateOrder }
	 * 
	 */
	public RequestCollateOrder createRequestCollateOrder() {
		return new RequestCollateOrder();
	}

	/**
	 * Create an instance of {@link SetOrderTrackingRemarkResponse }
	 * 
	 */
	public SetOrderTrackingRemarkResponse createSetOrderTrackingRemarkResponse() {
		return new SetOrderTrackingRemarkResponse();
	}

	/**
	 * Create an instance of {@link OrderWeighingRecordProductInfo }
	 * 
	 */
	public OrderWeighingRecordProductInfo createOrderWeighingRecordProductInfo() {
		return new OrderWeighingRecordProductInfo();
	}

	/**
	 * Create an instance of
	 * {@link GetLastOrderWeighingRecordByOrderCodeResponse }
	 * 
	 */
	public GetLastOrderWeighingRecordByOrderCodeResponse createGetLastOrderWeighingRecordByOrderCodeResponse() {
		return new GetLastOrderWeighingRecordByOrderCodeResponse();
	}

	/**
	 * Create an instance of {@link GetOrderCommunicationLogResponse }
	 * 
	 */
	public GetOrderCommunicationLogResponse createGetOrderCommunicationLogResponse() {
		return new GetOrderCommunicationLogResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderItem }
	 * 
	 */
	public UpdateOrderItem createUpdateOrderItem() {
		return new UpdateOrderItem();
	}

	/**
	 * Create an instance of {@link DealOrderReadySellLackLogResponse }
	 * 
	 */
	public DealOrderReadySellLackLogResponse createDealOrderReadySellLackLogResponse() {
		return new DealOrderReadySellLackLogResponse();
	}

	/**
	 * Create an instance of {@link Page }
	 * 
	 */
	public Page createPage() {
		return new Page();
	}

	/**
	 * Create an instance of {@link UpdateOrderHandlerByCustomer }
	 * 
	 */
	public UpdateOrderHandlerByCustomer createUpdateOrderHandlerByCustomer() {
		return new UpdateOrderHandlerByCustomer();
	}

	/**
	 * Create an instance of {@link CreatePendingOrderResponse }
	 * 
	 */
	public CreatePendingOrderResponse createCreatePendingOrderResponse() {
		return new CreatePendingOrderResponse();
	}

	/**
	 * Create an instance of {@link AddOrderResponse }
	 * 
	 */
	public AddOrderResponse createAddOrderResponse() {
		return new AddOrderResponse();
	}

	/**
	 * Create an instance of {@link GetOrderModifyRecords }
	 * 
	 */
	public GetOrderModifyRecords createGetOrderModifyRecords() {
		return new GetOrderModifyRecords();
	}

	/**
	 * Create an instance of {@link UpdateMutilOrderItemRemarkResponse }
	 * 
	 */
	public UpdateMutilOrderItemRemarkResponse createUpdateMutilOrderItemRemarkResponse() {
		return new UpdateMutilOrderItemRemarkResponse();
	}

	/**
	 * Create an instance of {@link AddMultiOrderItem }
	 * 
	 */
	public AddMultiOrderItem createAddMultiOrderItem() {
		return new AddMultiOrderItem();
	}

	/**
	 * Create an instance of {@link GetOrderModifyRecordOperatorLogById }
	 * 
	 */
	public GetOrderModifyRecordOperatorLogById createGetOrderModifyRecordOperatorLogById() {
		return new GetOrderModifyRecordOperatorLogById();
	}

	/**
	 * Create an instance of {@link GetOrderModifyRecordOperatorLogByIdResponse }
	 * 
	 */
	public GetOrderModifyRecordOperatorLogByIdResponse createGetOrderModifyRecordOperatorLogByIdResponse() {
		return new GetOrderModifyRecordOperatorLogByIdResponse();
	}

	/**
	 * Create an instance of {@link OrderTrackingReplayHistoryVO }
	 * 
	 */
	public OrderTrackingReplayHistoryVO createOrderTrackingReplayHistoryVO() {
		return new OrderTrackingReplayHistoryVO();
	}

	/**
	 * Create an instance of {@link ReplyOrderTracking }
	 * 
	 */
	public ReplyOrderTracking createReplyOrderTracking() {
		return new ReplyOrderTracking();
	}

	/**
	 * Create an instance of {@link RequestProcessingOrderItem }
	 * 
	 */
	public RequestProcessingOrderItem createRequestProcessingOrderItem() {
		return new RequestProcessingOrderItem();
	}

	/**
	 * Create an instance of {@link CreatePendingOrder }
	 * 
	 */
	public CreatePendingOrder createCreatePendingOrder() {
		return new CreatePendingOrder();
	}

	/**
	 * Create an instance of {@link GetOrderApplayOperatorLog }
	 * 
	 */
	public GetOrderApplayOperatorLog createGetOrderApplayOperatorLog() {
		return new GetOrderApplayOperatorLog();
	}

	/**
	 * Create an instance of {@link GetOrderModifyRecordsResponse }
	 * 
	 */
	public GetOrderModifyRecordsResponse createGetOrderModifyRecordsResponse() {
		return new GetOrderModifyRecordsResponse();
	}

	/**
	 * Create an instance of {@link AddMultiOrderItemResponse }
	 * 
	 */
	public AddMultiOrderItemResponse createAddMultiOrderItemResponse() {
		return new AddMultiOrderItemResponse();
	}

	/**
	 * Create an instance of {@link DealOrderCommunicationLogSuccessResponse }
	 * 
	 */
	public DealOrderCommunicationLogSuccessResponse createDealOrderCommunicationLogSuccessResponse() {
		return new DealOrderCommunicationLogSuccessResponse();
	}

	/**
	 * Create an instance of {@link GetOrderModifyRecordById }
	 * 
	 */
	public GetOrderModifyRecordById createGetOrderModifyRecordById() {
		return new GetOrderModifyRecordById();
	}

	/**
	 * Create an instance of {@link CommunicationLog }
	 * 
	 */
	public CommunicationLog createCommunicationLog() {
		return new CommunicationLog();
	}

	/**
	 * Create an instance of {@link SetOrderTrackingRemark }
	 * 
	 */
	public SetOrderTrackingRemark createSetOrderTrackingRemark() {
		return new SetOrderTrackingRemark();
	}

	/**
	 * Create an instance of {@link GetOrderModifyRecordOperatorLogs }
	 * 
	 */
	public GetOrderModifyRecordOperatorLogs createGetOrderModifyRecordOperatorLogs() {
		return new GetOrderModifyRecordOperatorLogs();
	}

	/**
	 * Create an instance of {@link Order }
	 * 
	 */
	public Order createOrder() {
		return new Order();
	}

	/**
	 * Create an instance of {@link UpdateOrderHandler }
	 * 
	 */
	public UpdateOrderHandler createUpdateOrderHandler() {
		return new UpdateOrderHandler();
	}

	/**
	 * Create an instance of {@link GetDeliveryLimiteInfoResponse }
	 * 
	 */
	public GetDeliveryLimiteInfoResponse createGetDeliveryLimiteInfoResponse() {
		return new GetDeliveryLimiteInfoResponse();
	}

	/**
	 * Create an instance of {@link GetOrderOperatorLogById }
	 * 
	 */
	public GetOrderOperatorLogById createGetOrderOperatorLogById() {
		return new GetOrderOperatorLogById();
	}

	/**
	 * Create an instance of {@link RequestProcessingOrderItemResponse }
	 * 
	 */
	public RequestProcessingOrderItemResponse createRequestProcessingOrderItemResponse() {
		return new RequestProcessingOrderItemResponse();
	}

	/**
	 * Create an instance of {@link CancleMultiOrderItem }
	 * 
	 */
	public CancleMultiOrderItem createCancleMultiOrderItem() {
		return new CancleMultiOrderItem();
	}

	/**
	 * Create an instance of {@link GetOrderTrackingReplayHistoryResponse }
	 * 
	 */
	public GetOrderTrackingReplayHistoryResponse createGetOrderTrackingReplayHistoryResponse() {
		return new GetOrderTrackingReplayHistoryResponse();
	}

	/**
	 * Create an instance of {@link CompleteOrderTracking }
	 * 
	 */
	public CompleteOrderTracking createCompleteOrderTracking() {
		return new CompleteOrderTracking();
	}

	/**
	 * Create an instance of {@link GetOrderModifyRecordOperatorLogsById }
	 * 
	 */
	public GetOrderModifyRecordOperatorLogsById createGetOrderModifyRecordOperatorLogsById() {
		return new GetOrderModifyRecordOperatorLogsById();
	}

	/**
	 * Create an instance of {@link OrderWeighingRecordInfo }
	 * 
	 */
	public OrderWeighingRecordInfo createOrderWeighingRecordInfo() {
		return new OrderWeighingRecordInfo();
	}

	/**
	 * Create an instance of {@link GetOrderApplayOperatorLogByIdResponse }
	 * 
	 */
	public GetOrderApplayOperatorLogByIdResponse createGetOrderApplayOperatorLogByIdResponse() {
		return new GetOrderApplayOperatorLogByIdResponse();
	}

	/**
	 * Create an instance of {@link SendToCustomer }
	 * 
	 */
	public SendToCustomer createSendToCustomer() {
		return new SendToCustomer();
	}

	/**
	 * Create an instance of {@link GetOrderItemByOrderId }
	 * 
	 */
	public GetOrderItemByOrderId createGetOrderItemByOrderId() {
		return new GetOrderItemByOrderId();
	}

	/**
	 * Create an instance of {@link ApplayOrderResend }
	 * 
	 */
	public ApplayOrderResend createApplayOrderResend() {
		return new ApplayOrderResend();
	}

	/**
	 * Create an instance of {@link OrderModifyOperatorLog }
	 * 
	 */
	public OrderModifyOperatorLog createOrderModifyOperatorLog() {
		return new OrderModifyOperatorLog();
	}

	/**
	 * Create an instance of {@link GetApplayItemsByApplayId }
	 * 
	 */
	public GetApplayItemsByApplayId createGetApplayItemsByApplayId() {
		return new GetApplayItemsByApplayId();
	}

	/**
	 * Create an instance of {@link GetOrderByCodeResponse }
	 * 
	 */
	public GetOrderByCodeResponse createGetOrderByCodeResponse() {
		return new GetOrderByCodeResponse();
	}

	/**
	 * Create an instance of {@link ReplaceOrderItemResponse }
	 * 
	 */
	public ReplaceOrderItemResponse createReplaceOrderItemResponse() {
		return new ReplaceOrderItemResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrder }
	 * 
	 */
	public UpdateOrder createUpdateOrder() {
		return new UpdateOrder();
	}

	/**
	 * Create an instance of {@link OrderSetQuality }
	 * 
	 */
	public OrderSetQuality createOrderSetQuality() {
		return new OrderSetQuality();
	}

	/**
	 * Create an instance of {@link GetOrderItemOperatorLog }
	 * 
	 */
	public GetOrderItemOperatorLog createGetOrderItemOperatorLog() {
		return new GetOrderItemOperatorLog();
	}

	/**
	 * Create an instance of {@link UpdateOrderDelivery }
	 * 
	 */
	public UpdateOrderDelivery createUpdateOrderDelivery() {
		return new UpdateOrderDelivery();
	}

	/**
	 * Create an instance of {@link CompleteOrderResponse }
	 * 
	 */
	public CompleteOrderResponse createCompleteOrderResponse() {
		return new CompleteOrderResponse();
	}

	/**
	 * Create an instance of {@link GetOrderModifyRecordOperatorLogResponse }
	 * 
	 */
	public GetOrderModifyRecordOperatorLogResponse createGetOrderModifyRecordOperatorLogResponse() {
		return new GetOrderModifyRecordOperatorLogResponse();
	}

	/**
	 * Create an instance of {@link IsAssigningOrder }
	 * 
	 */
	public IsAssigningOrder createIsAssigningOrder() {
		return new IsAssigningOrder();
	}

	/**
	 * Create an instance of {@link GetOrderByIdResponse }
	 * 
	 */
	public GetOrderByIdResponse createGetOrderByIdResponse() {
		return new GetOrderByIdResponse();
	}

	/**
	 * Create an instance of {@link DealOrderReadySellLackLog }
	 * 
	 */
	public DealOrderReadySellLackLog createDealOrderReadySellLackLog() {
		return new DealOrderReadySellLackLog();
	}

	/**
	 * Create an instance of {@link GetOrderOperatorLog }
	 * 
	 */
	public GetOrderOperatorLog createGetOrderOperatorLog() {
		return new GetOrderOperatorLog();
	}

	/**
	 * Create an instance of {@link DealOrderCommunicationLog }
	 * 
	 */
	public DealOrderCommunicationLog createDealOrderCommunicationLog() {
		return new DealOrderCommunicationLog();
	}

	/**
	 * Create an instance of {@link GetApplayByIdResponse }
	 * 
	 */
	public GetApplayByIdResponse createGetApplayByIdResponse() {
		return new GetApplayByIdResponse();
	}

	/**
	 * Create an instance of {@link GetOrderApplayOperatorLogResponse }
	 * 
	 */
	public GetOrderApplayOperatorLogResponse createGetOrderApplayOperatorLogResponse() {
		return new GetOrderApplayOperatorLogResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderHandlerByCustomerResponse }
	 * 
	 */
	public UpdateOrderHandlerByCustomerResponse createUpdateOrderHandlerByCustomerResponse() {
		return new UpdateOrderHandlerByCustomerResponse();
	}

	/**
	 * Create an instance of {@link DealOrderCommunicationLogSuccess }
	 * 
	 */
	public DealOrderCommunicationLogSuccess createDealOrderCommunicationLogSuccess() {
		return new DealOrderCommunicationLogSuccess();
	}

	/**
	 * Create an instance of {@link GetAttachmentByCode }
	 * 
	 */
	public GetAttachmentByCode createGetAttachmentByCode() {
		return new GetAttachmentByCode();
	}

	/**
	 * Create an instance of {@link UpdateOrderDiscount }
	 * 
	 */
	public UpdateOrderDiscount createUpdateOrderDiscount() {
		return new UpdateOrderDiscount();
	}

	/**
	 * Create an instance of {@link GetOrderItemOperatorLogById }
	 * 
	 */
	public GetOrderItemOperatorLogById createGetOrderItemOperatorLogById() {
		return new GetOrderItemOperatorLogById();
	}

	/**
	 * Create an instance of {@link CompleteOrderTrackingResponse }
	 * 
	 */
	public CompleteOrderTrackingResponse createCompleteOrderTrackingResponse() {
		return new CompleteOrderTrackingResponse();
	}

	/**
	 * Create an instance of {@link OrderSetQualityResponse }
	 * 
	 */
	public OrderSetQualityResponse createOrderSetQualityResponse() {
		return new OrderSetQualityResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderGroupResponse }
	 * 
	 */
	public UpdateOrderGroupResponse createUpdateOrderGroupResponse() {
		return new UpdateOrderGroupResponse();
	}

	/**
	 * Create an instance of {@link GetOrderReadySellLackLogResponse }
	 * 
	 */
	public GetOrderReadySellLackLogResponse createGetOrderReadySellLackLogResponse() {
		return new GetOrderReadySellLackLogResponse();
	}

	/**
	 * Create an instance of {@link GetOrderTrackingOperatorLogResponse }
	 * 
	 */
	public GetOrderTrackingOperatorLogResponse createGetOrderTrackingOperatorLogResponse() {
		return new GetOrderTrackingOperatorLogResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderItemResponse }
	 * 
	 */
	public UpdateOrderItemResponse createUpdateOrderItemResponse() {
		return new UpdateOrderItemResponse();
	}

	/**
	 * Create an instance of {@link GetOrderTrackingOperatorLog }
	 * 
	 */
	public GetOrderTrackingOperatorLog createGetOrderTrackingOperatorLog() {
		return new GetOrderTrackingOperatorLog();
	}

	/**
	 * Create an instance of {@link UpdateItemPriceResponse }
	 * 
	 */
	public UpdateItemPriceResponse createUpdateItemPriceResponse() {
		return new UpdateItemPriceResponse();
	}

	/**
	 * Create an instance of {@link CancleOrderResponse }
	 * 
	 */
	public CancleOrderResponse createCancleOrderResponse() {
		return new CancleOrderResponse();
	}

	/**
	 * Create an instance of {@link SendReadyOrderItems }
	 * 
	 */
	public SendReadyOrderItems createSendReadyOrderItems() {
		return new SendReadyOrderItems();
	}

	/**
	 * Create an instance of {@link DealOrderCommunicationLogResponse }
	 * 
	 */
	public DealOrderCommunicationLogResponse createDealOrderCommunicationLogResponse() {
		return new DealOrderCommunicationLogResponse();
	}

	/**
	 * Create an instance of {@link ReplaceOrder }
	 * 
	 */
	public ReplaceOrder createReplaceOrder() {
		return new ReplaceOrder();
	}

	/**
	 * Create an instance of {@link GetOrderModifyRecordOperatorLog }
	 * 
	 */
	public GetOrderModifyRecordOperatorLog createGetOrderModifyRecordOperatorLog() {
		return new GetOrderModifyRecordOperatorLog();
	}

	/**
	 * Create an instance of {@link UpdateOrderHandlerCode }
	 * 
	 */
	public UpdateOrderHandlerCode createUpdateOrderHandlerCode() {
		return new UpdateOrderHandlerCode();
	}

	/**
	 * Create an instance of {@link UpdateMultiOrderItem }
	 * 
	 */
	public UpdateMultiOrderItem createUpdateMultiOrderItem() {
		return new UpdateMultiOrderItem();
	}

	/**
	 * Create an instance of {@link OrderTrackingItemVO }
	 * 
	 */
	public OrderTrackingItemVO createOrderTrackingItemVO() {
		return new OrderTrackingItemVO();
	}

	/**
	 * Create an instance of {@link DealOrderModifyRecord }
	 * 
	 */
	public DealOrderModifyRecord createDealOrderModifyRecord() {
		return new DealOrderModifyRecord();
	}

	/**
	 * Create an instance of {@link UpdateMultiOrderItemResponse }
	 * 
	 */
	public UpdateMultiOrderItemResponse createUpdateMultiOrderItemResponse() {
		return new UpdateMultiOrderItemResponse();
	}

	/**
	 * Create an instance of {@link OrderTrackingAttachment }
	 * 
	 */
	public OrderTrackingAttachment createOrderTrackingAttachment() {
		return new OrderTrackingAttachment();
	}

	/**
	 * Create an instance of {@link GetOrderTrackingOperatorLogById }
	 * 
	 */
	public GetOrderTrackingOperatorLogById createGetOrderTrackingOperatorLogById() {
		return new GetOrderTrackingOperatorLogById();
	}

	/**
	 * Create an instance of {@link UpdateIsCanSend }
	 * 
	 */
	public UpdateIsCanSend createUpdateIsCanSend() {
		return new UpdateIsCanSend();
	}

	/**
	 * Create an instance of {@link GetOrderModifyRecordByIdResponse }
	 * 
	 */
	public GetOrderModifyRecordByIdResponse createGetOrderModifyRecordByIdResponse() {
		return new GetOrderModifyRecordByIdResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderGroup }
	 * 
	 */
	public UpdateOrderGroup createUpdateOrderGroup() {
		return new UpdateOrderGroup();
	}

	/**
	 * Create an instance of {@link UpdateOrderPayStatus }
	 * 
	 */
	public UpdateOrderPayStatus createUpdateOrderPayStatus() {
		return new UpdateOrderPayStatus();
	}

	/**
	 * Create an instance of {@link ApplayOrderCancle }
	 * 
	 */
	public ApplayOrderCancle createApplayOrderCancle() {
		return new ApplayOrderCancle();
	}

	/**
	 * Create an instance of {@link SplitOrder }
	 * 
	 */
	public SplitOrder createSplitOrder() {
		return new SplitOrder();
	}

	/**
	 * Create an instance of {@link SetConsultationUser }
	 * 
	 */
	public SetConsultationUser createSetConsultationUser() {
		return new SetConsultationUser();
	}

	/**
	 * Create an instance of {@link CancelProcessingOrderItem }
	 * 
	 */
	public CancelProcessingOrderItem createCancelProcessingOrderItem() {
		return new CancelProcessingOrderItem();
	}

	/**
	 * Create an instance of {@link GetOrderModifyRecordOperatorLogsResponse }
	 * 
	 */
	public GetOrderModifyRecordOperatorLogsResponse createGetOrderModifyRecordOperatorLogsResponse() {
		return new GetOrderModifyRecordOperatorLogsResponse();
	}

	/**
	 * Create an instance of {@link AddOrderItemResponse }
	 * 
	 */
	public AddOrderItemResponse createAddOrderItemResponse() {
		return new AddOrderItemResponse();
	}

	/**
	 * Create an instance of {@link GetOrderItemRelateBoxsByOrderItemId }
	 * 
	 */
	public GetOrderItemRelateBoxsByOrderItemId createGetOrderItemRelateBoxsByOrderItemId() {
		return new GetOrderItemRelateBoxsByOrderItemId();
	}

	/**
	 * Create an instance of {@link SendReadyOrderItemsResponse }
	 * 
	 */
	public SendReadyOrderItemsResponse createSendReadyOrderItemsResponse() {
		return new SendReadyOrderItemsResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderDeliveryInfo }
	 * 
	 */
	public UpdateOrderDeliveryInfo createUpdateOrderDeliveryInfo() {
		return new UpdateOrderDeliveryInfo();
	}

	/**
	 * Create an instance of {@link OrderItemRelateBox }
	 * 
	 */
	public OrderItemRelateBox createOrderItemRelateBox() {
		return new OrderItemRelateBox();
	}

	/**
	 * Create an instance of {@link OrderTracking }
	 * 
	 */
	public OrderTracking createOrderTracking() {
		return new OrderTracking();
	}

	/**
	 * Create an instance of {@link UpdateOrderItemWeight }
	 * 
	 */
	public UpdateOrderItemWeight createUpdateOrderItemWeight() {
		return new UpdateOrderItemWeight();
	}

	/**
	 * Create an instance of {@link GetOrderReadySellLackLog }
	 * 
	 */
	public GetOrderReadySellLackLog createGetOrderReadySellLackLog() {
		return new GetOrderReadySellLackLog();
	}

	/**
	 * Create an instance of {@link UpdateOrderDeliveryInfoResponse }
	 * 
	 */
	public UpdateOrderDeliveryInfoResponse createUpdateOrderDeliveryInfoResponse() {
		return new UpdateOrderDeliveryInfoResponse();
	}

	/**
	 * Create an instance of {@link GetOrderItemById }
	 * 
	 */
	public GetOrderItemById createGetOrderItemById() {
		return new GetOrderItemById();
	}

	/**
	 * Create an instance of {@link OrderCancleResendApplayItem }
	 * 
	 */
	public OrderCancleResendApplayItem createOrderCancleResendApplayItem() {
		return new OrderCancleResendApplayItem();
	}

	/**
	 * Create an instance of {@link RemoveOrderGroup }
	 * 
	 */
	public RemoveOrderGroup createRemoveOrderGroup() {
		return new RemoveOrderGroup();
	}

	/**
	 * Create an instance of {@link GetApplayById }
	 * 
	 */
	public GetApplayById createGetApplayById() {
		return new GetApplayById();
	}

	/**
	 * Create an instance of {@link OrderWeighingRecordItemInfo }
	 * 
	 */
	public OrderWeighingRecordItemInfo createOrderWeighingRecordItemInfo() {
		return new OrderWeighingRecordItemInfo();
	}

	/**
	 * Create an instance of {@link UpdateOrderItemRemark }
	 * 
	 */
	public UpdateOrderItemRemark createUpdateOrderItemRemark() {
		return new UpdateOrderItemRemark();
	}

	/**
	 * Create an instance of {@link OrderCommunicationLog }
	 * 
	 */
	public OrderCommunicationLog createOrderCommunicationLog() {
		return new OrderCommunicationLog();
	}

	/**
	 * Create an instance of {@link CompleteMultiOrder }
	 * 
	 */
	public CompleteMultiOrder createCompleteMultiOrder() {
		return new CompleteMultiOrder();
	}

	/**
	 * Create an instance of {@link ReplaceOrderItem }
	 * 
	 */
	public ReplaceOrderItem createReplaceOrderItem() {
		return new ReplaceOrderItem();
	}

	/**
	 * Create an instance of {@link OrderExpandInfo }
	 * 
	 */
	public OrderExpandInfo createOrderExpandInfo() {
		return new OrderExpandInfo();
	}

	/**
	 * Create an instance of {@link GetOrderItemOperatorLogByIdResponse }
	 * 
	 */
	public GetOrderItemOperatorLogByIdResponse createGetOrderItemOperatorLogByIdResponse() {
		return new GetOrderItemOperatorLogByIdResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderHandlerResponse }
	 * 
	 */
	public UpdateOrderHandlerResponse createUpdateOrderHandlerResponse() {
		return new UpdateOrderHandlerResponse();
	}

	/**
	 * Create an instance of {@link CancelProcessingOrderItemResponse }
	 * 
	 */
	public CancelProcessingOrderItemResponse createCancelProcessingOrderItemResponse() {
		return new CancelProcessingOrderItemResponse();
	}

	/**
	 * Create an instance of {@link OrderItem }
	 * 
	 */
	public OrderItem createOrderItem() {
		return new OrderItem();
	}

	/**
	 * Create an instance of {@link UpdateOrderRemark }
	 * 
	 */
	public UpdateOrderRemark createUpdateOrderRemark() {
		return new UpdateOrderRemark();
	}

	/**
	 * Create an instance of {@link GetOrderByCode }
	 * 
	 */
	public GetOrderByCode createGetOrderByCode() {
		return new GetOrderByCode();
	}

	/**
	 * Create an instance of {@link CompleteMultiOrderResponse }
	 * 
	 */
	public CompleteMultiOrderResponse createCompleteMultiOrderResponse() {
		return new CompleteMultiOrderResponse();
	}

	/**
	 * Create an instance of {@link OrderItemDetail }
	 * 
	 */
	public OrderItemDetail createOrderItemDetail() {
		return new OrderItemDetail();
	}

	/**
	 * Create an instance of {@link FindOrderTracking }
	 * 
	 */
	public FindOrderTracking createFindOrderTracking() {
		return new FindOrderTracking();
	}

	/**
	 * Create an instance of {@link GetOrderTrackingReplayHistory }
	 * 
	 */
	public GetOrderTrackingReplayHistory createGetOrderTrackingReplayHistory() {
		return new GetOrderTrackingReplayHistory();
	}

	/**
	 * Create an instance of {@link AddReportOrder }
	 * 
	 */
	public AddReportOrder createAddReportOrder() {
		return new AddReportOrder();
	}

	/**
	 * Create an instance of {@link UpdateOrderItemWeightResponse }
	 * 
	 */
	public UpdateOrderItemWeightResponse createUpdateOrderItemWeightResponse() {
		return new UpdateOrderItemWeightResponse();
	}

	/**
	 * Create an instance of {@link CompleteOrder }
	 * 
	 */
	public CompleteOrder createCompleteOrder() {
		return new CompleteOrder();
	}

	/**
	 * Create an instance of {@link IsAssigningOrderResponse }
	 * 
	 */
	public IsAssigningOrderResponse createIsAssigningOrderResponse() {
		return new IsAssigningOrderResponse();
	}

	/**
	 * Create an instance of {@link ApplayOrderCancleResponse }
	 * 
	 */
	public ApplayOrderCancleResponse createApplayOrderCancleResponse() {
		return new ApplayOrderCancleResponse();
	}

	/**
	 * Create an instance of {@link AddOrder }
	 * 
	 */
	public AddOrder createAddOrder() {
		return new AddOrder();
	}

	/**
	 * Create an instance of {@link ReplaceOrderResponse }
	 * 
	 */
	public ReplaceOrderResponse createReplaceOrderResponse() {
		return new ReplaceOrderResponse();
	}

	/**
	 * Create an instance of {@link FindOrderTrackingResponse }
	 * 
	 */
	public FindOrderTrackingResponse createFindOrderTrackingResponse() {
		return new FindOrderTrackingResponse();
	}

	/**
	 * Create an instance of {@link GetOrderTrackingById }
	 * 
	 */
	public GetOrderTrackingById createGetOrderTrackingById() {
		return new GetOrderTrackingById();
	}

	/**
	 * Create an instance of {@link GetOrderTrackingOperatorLogByIdResponse }
	 * 
	 */
	public GetOrderTrackingOperatorLogByIdResponse createGetOrderTrackingOperatorLogByIdResponse() {
		return new GetOrderTrackingOperatorLogByIdResponse();
	}

	/**
	 * Create an instance of {@link CancleOrderItemResponse }
	 * 
	 */
	public CancleOrderItemResponse createCancleOrderItemResponse() {
		return new CancleOrderItemResponse();
	}

	/**
	 * Create an instance of {@link SetConsultationUserResponse }
	 * 
	 */
	public SetConsultationUserResponse createSetConsultationUserResponse() {
		return new SetConsultationUserResponse();
	}

	/**
	 * Create an instance of {@link OrderModifyRecord }
	 * 
	 */
	public OrderModifyRecord createOrderModifyRecord() {
		return new OrderModifyRecord();
	}

	/**
	 * Create an instance of {@link UpdateOrderItemQuantity }
	 * 
	 */
	public UpdateOrderItemQuantity createUpdateOrderItemQuantity() {
		return new UpdateOrderItemQuantity();
	}

	/**
	 * Create an instance of {@link AddReportOrderResponse }
	 * 
	 */
	public AddReportOrderResponse createAddReportOrderResponse() {
		return new AddReportOrderResponse();
	}

	/**
	 * Create an instance of {@link OrderItemExpand }
	 * 
	 */
	public OrderItemExpand createOrderItemExpand() {
		return new OrderItemExpand();
	}

	/**
	 * Create an instance of {@link ApplayOrderShelve }
	 * 
	 */
	public ApplayOrderShelve createApplayOrderShelve() {
		return new ApplayOrderShelve();
	}

	/**
	 * Create an instance of {@link AddAttachmentFileResponse }
	 * 
	 */
	public AddAttachmentFileResponse createAddAttachmentFileResponse() {
		return new AddAttachmentFileResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderHandlerCodeResponse }
	 * 
	 */
	public UpdateOrderHandlerCodeResponse createUpdateOrderHandlerCodeResponse() {
		return new UpdateOrderHandlerCodeResponse();
	}

	/**
	 * Create an instance of {@link OrderCancleResendApplay }
	 * 
	 */
	public OrderCancleResendApplay createOrderCancleResendApplay() {
		return new OrderCancleResendApplay();
	}

	/**
	 * Create an instance of {@link OrderReadySellLackLog }
	 * 
	 */
	public OrderReadySellLackLog createOrderReadySellLackLog() {
		return new OrderReadySellLackLog();
	}

	/**
	 * Create an instance of {@link UpdateOrderRemarkResponse }
	 * 
	 */
	public UpdateOrderRemarkResponse createUpdateOrderRemarkResponse() {
		return new UpdateOrderRemarkResponse();
	}

	/**
	 * Create an instance of {@link GetOrderTrackingByIdResponse }
	 * 
	 */
	public GetOrderTrackingByIdResponse createGetOrderTrackingByIdResponse() {
		return new GetOrderTrackingByIdResponse();
	}

	/**
	 * Create an instance of {@link GetOrderItemRelateBoxsByOrderItemIdResponse }
	 * 
	 */
	public GetOrderItemRelateBoxsByOrderItemIdResponse createGetOrderItemRelateBoxsByOrderItemIdResponse() {
		return new GetOrderItemRelateBoxsByOrderItemIdResponse();
	}

	/**
	 * Create an instance of {@link OrderModifyRecordItem }
	 * 
	 */
	public OrderModifyRecordItem createOrderModifyRecordItem() {
		return new OrderModifyRecordItem();
	}

	/**
	 * Create an instance of {@link GetOrderApplayOperatorLogById }
	 * 
	 */
	public GetOrderApplayOperatorLogById createGetOrderApplayOperatorLogById() {
		return new GetOrderApplayOperatorLogById();
	}

	/**
	 * Create an instance of {@link GetAttachmentByCodeResponse }
	 * 
	 */
	public GetAttachmentByCodeResponse createGetAttachmentByCodeResponse() {
		return new GetAttachmentByCodeResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderResponse }
	 * 
	 */
	public UpdateOrderResponse createUpdateOrderResponse() {
		return new UpdateOrderResponse();
	}

	/**
	 * Create an instance of {@link SetOrderTrackingResponse }
	 * 
	 */
	public SetOrderTrackingResponse createSetOrderTrackingResponse() {
		return new SetOrderTrackingResponse();
	}

	/**
	 * Create an instance of
	 * {@link GetOrderModifyRecordOperatorLogsByIdResponse }
	 * 
	 */
	public GetOrderModifyRecordOperatorLogsByIdResponse createGetOrderModifyRecordOperatorLogsByIdResponse() {
		return new GetOrderModifyRecordOperatorLogsByIdResponse();
	}

	/**
	 * Create an instance of {@link UpdateIsCanSendResponse }
	 * 
	 */
	public UpdateIsCanSendResponse createUpdateIsCanSendResponse() {
		return new UpdateIsCanSendResponse();
	}

	/**
	 * Create an instance of {@link GetOrderOperatorLogResponse }
	 * 
	 */
	public GetOrderOperatorLogResponse createGetOrderOperatorLogResponse() {
		return new GetOrderOperatorLogResponse();
	}

	/**
	 * Create an instance of {@link OrderTrackingPageList }
	 * 
	 */
	public OrderTrackingPageList createOrderTrackingPageList() {
		return new OrderTrackingPageList();
	}

	/**
	 * Create an instance of {@link RequestCollateOrderResponse }
	 * 
	 */
	public RequestCollateOrderResponse createRequestCollateOrderResponse() {
		return new RequestCollateOrderResponse();
	}

	/**
	 * Create an instance of {@link RemoveOrderGroupResponse }
	 * 
	 */
	public RemoveOrderGroupResponse createRemoveOrderGroupResponse() {
		return new RemoveOrderGroupResponse();
	}

	/**
	 * Create an instance of {@link AddAttachmentFile }
	 * 
	 */
	public AddAttachmentFile createAddAttachmentFile() {
		return new AddAttachmentFile();
	}

	/**
	 * Create an instance of {@link UpdateOrderCountry }
	 * 
	 */
	public UpdateOrderCountry createUpdateOrderCountry() {
		return new UpdateOrderCountry();
	}

	/**
	 * Create an instance of {@link UpdateOrderItemQuantityResponse }
	 * 
	 */
	public UpdateOrderItemQuantityResponse createUpdateOrderItemQuantityResponse() {
		return new UpdateOrderItemQuantityResponse();
	}

	/**
	 * Create an instance of {@link BussinessException }
	 * 
	 */
	public BussinessException createBussinessException() {
		return new BussinessException();
	}

	/**
	 * Create an instance of {@link UpdateOrderPayStatusResponse }
	 * 
	 */
	public UpdateOrderPayStatusResponse createUpdateOrderPayStatusResponse() {
		return new UpdateOrderPayStatusResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderDeliveryResponse }
	 * 
	 */
	public UpdateOrderDeliveryResponse createUpdateOrderDeliveryResponse() {
		return new UpdateOrderDeliveryResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderDiscountResponse }
	 * 
	 */
	public UpdateOrderDiscountResponse createUpdateOrderDiscountResponse() {
		return new UpdateOrderDiscountResponse();
	}

	/**
	 * Create an instance of {@link GetOrderById }
	 * 
	 */
	public GetOrderById createGetOrderById() {
		return new GetOrderById();
	}

	/**
	 * Create an instance of {@link OrderTrackingItem }
	 * 
	 */
	public OrderTrackingItem createOrderTrackingItem() {
		return new OrderTrackingItem();
	}

	/**
	 * Create an instance of {@link GetOrderItemByOrderIdResponse }
	 * 
	 */
	public GetOrderItemByOrderIdResponse createGetOrderItemByOrderIdResponse() {
		return new GetOrderItemByOrderIdResponse();
	}

	/**
	 * Create an instance of {@link SendToCustomerResponse }
	 * 
	 */
	public SendToCustomerResponse createSendToCustomerResponse() {
		return new SendToCustomerResponse();
	}

	/**
	 * Create an instance of {@link UpdateOrderItemRemarkResponse }
	 * 
	 */
	public UpdateOrderItemRemarkResponse createUpdateOrderItemRemarkResponse() {
		return new UpdateOrderItemRemarkResponse();
	}

	/**
	 * Create an instance of {@link GetOrderCommunicationLog }
	 * 
	 */
	public GetOrderCommunicationLog createGetOrderCommunicationLog() {
		return new GetOrderCommunicationLog();
	}

	/**
	 * Create an instance of {@link DealOrderModifyRecordResponse }
	 * 
	 */
	public DealOrderModifyRecordResponse createDealOrderModifyRecordResponse() {
		return new DealOrderModifyRecordResponse();
	}

	/**
	 * Create an instance of {@link CancleMultiOrderItemResponse }
	 * 
	 */
	public CancleMultiOrderItemResponse createCancleMultiOrderItemResponse() {
		return new CancleMultiOrderItemResponse();
	}

	/**
	 * Create an instance of {@link ApplayOrderResendResponse }
	 * 
	 */
	public ApplayOrderResendResponse createApplayOrderResendResponse() {
		return new ApplayOrderResendResponse();
	}

	/**
	 * Create an instance of {@link ReplyOrderTrackingResponse }
	 * 
	 */
	public ReplyOrderTrackingResponse createReplyOrderTrackingResponse() {
		return new ReplyOrderTrackingResponse();
	}

	/**
	 * Create an instance of {@link GetDeliveryLimiteInfo }
	 * 
	 */
	public GetDeliveryLimiteInfo createGetDeliveryLimiteInfo() {
		return new GetDeliveryLimiteInfo();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddMultiOrderItemResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "addMultiOrderItemResponse")
	public JAXBElement<AddMultiOrderItemResponse> createAddMultiOrderItemResponse(AddMultiOrderItemResponse value) {
		return new JAXBElement<AddMultiOrderItemResponse>(_AddMultiOrderItemResponse_QNAME,
				AddMultiOrderItemResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AddOrderItem }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "addOrderItem")
	public JAXBElement<AddOrderItem> createAddOrderItem(AddOrderItem value) {
		return new JAXBElement<AddOrderItem>(_AddOrderItem_QNAME, AddOrderItem.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderCountry }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderCountry")
	public JAXBElement<UpdateOrderCountry> createUpdateOrderCountry(UpdateOrderCountry value) {
		return new JAXBElement<UpdateOrderCountry>(_UpdateOrderCountry_QNAME, UpdateOrderCountry.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CancleMultiOrderItem }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "cancleMultiOrderItem")
	public JAXBElement<CancleMultiOrderItem> createCancleMultiOrderItem(CancleMultiOrderItem value) {
		return new JAXBElement<CancleMultiOrderItem>(_CancleMultiOrderItem_QNAME, CancleMultiOrderItem.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderOperatorLogById }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderOperatorLogById")
	public JAXBElement<GetOrderOperatorLogById> createGetOrderOperatorLogById(GetOrderOperatorLogById value) {
		return new JAXBElement<GetOrderOperatorLogById>(_GetOrderOperatorLogById_QNAME, GetOrderOperatorLogById.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link UpdateIsCanSend }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateIsCanSend")
	public JAXBElement<UpdateIsCanSend> createUpdateIsCanSend(UpdateIsCanSend value) {
		return new JAXBElement<UpdateIsCanSend>(_UpdateIsCanSend_QNAME, UpdateIsCanSend.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DealOrderModifyRecordResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "dealOrderModifyRecordResponse")
	public JAXBElement<DealOrderModifyRecordResponse> createDealOrderModifyRecordResponse(
			DealOrderModifyRecordResponse value) {
		return new JAXBElement<DealOrderModifyRecordResponse>(_DealOrderModifyRecordResponse_QNAME,
				DealOrderModifyRecordResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderModifyRecordOperatorLogByIdResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderModifyRecordOperatorLogByIdResponse")
	public JAXBElement<GetOrderModifyRecordOperatorLogByIdResponse> createGetOrderModifyRecordOperatorLogByIdResponse(
			GetOrderModifyRecordOperatorLogByIdResponse value) {
		return new JAXBElement<GetOrderModifyRecordOperatorLogByIdResponse>(
				_GetOrderModifyRecordOperatorLogByIdResponse_QNAME, GetOrderModifyRecordOperatorLogByIdResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ApplayOrderResendResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "applayOrderResendResponse")
	public JAXBElement<ApplayOrderResendResponse> createApplayOrderResendResponse(ApplayOrderResendResponse value) {
		return new JAXBElement<ApplayOrderResendResponse>(_ApplayOrderResendResponse_QNAME,
				ApplayOrderResendResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetAttachmentByCode }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getAttachmentByCode")
	public JAXBElement<GetAttachmentByCode> createGetAttachmentByCode(GetAttachmentByCode value) {
		return new JAXBElement<GetAttachmentByCode>(_GetAttachmentByCode_QNAME, GetAttachmentByCode.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SplitOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "splitOrderResponse")
	public JAXBElement<SplitOrderResponse> createSplitOrderResponse(SplitOrderResponse value) {
		return new JAXBElement<SplitOrderResponse>(_SplitOrderResponse_QNAME, SplitOrderResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ApplayOrderCancle }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "applayOrderCancle")
	public JAXBElement<ApplayOrderCancle> createApplayOrderCancle(ApplayOrderCancle value) {
		return new JAXBElement<ApplayOrderCancle>(_ApplayOrderCancle_QNAME, ApplayOrderCancle.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderItemOperatorLogByIdResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderItemOperatorLogByIdResponse")
	public JAXBElement<GetOrderItemOperatorLogByIdResponse> createGetOrderItemOperatorLogByIdResponse(
			GetOrderItemOperatorLogByIdResponse value) {
		return new JAXBElement<GetOrderItemOperatorLogByIdResponse>(_GetOrderItemOperatorLogByIdResponse_QNAME,
				GetOrderItemOperatorLogByIdResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CancelProcessingOrderItemResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "cancelProcessingOrderItemResponse")
	public JAXBElement<CancelProcessingOrderItemResponse> createCancelProcessingOrderItemResponse(
			CancelProcessingOrderItemResponse value) {
		return new JAXBElement<CancelProcessingOrderItemResponse>(_CancelProcessingOrderItemResponse_QNAME,
				CancelProcessingOrderItemResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CreatePendingOrder }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "createPendingOrder")
	public JAXBElement<CreatePendingOrder> createCreatePendingOrder(CreatePendingOrder value) {
		return new JAXBElement<CreatePendingOrder>(_CreatePendingOrder_QNAME, CreatePendingOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderItemRemark }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderItemRemark")
	public JAXBElement<UpdateOrderItemRemark> createUpdateOrderItemRemark(UpdateOrderItemRemark value) {
		return new JAXBElement<UpdateOrderItemRemark>(_UpdateOrderItemRemark_QNAME, UpdateOrderItemRemark.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SendToCustomerResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "sendToCustomerResponse")
	public JAXBElement<SendToCustomerResponse> createSendToCustomerResponse(SendToCustomerResponse value) {
		return new JAXBElement<SendToCustomerResponse>(_SendToCustomerResponse_QNAME, SendToCustomerResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link UpdateItemPrice }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateItemPrice")
	public JAXBElement<UpdateItemPrice> createUpdateItemPrice(UpdateItemPrice value) {
		return new JAXBElement<UpdateItemPrice>(_UpdateItemPrice_QNAME, UpdateItemPrice.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ApplayOrderCancleResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "applayOrderCancleResponse")
	public JAXBElement<ApplayOrderCancleResponse> createApplayOrderCancleResponse(ApplayOrderCancleResponse value) {
		return new JAXBElement<ApplayOrderCancleResponse>(_ApplayOrderCancleResponse_QNAME,
				ApplayOrderCancleResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ReplaceOrder }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "replaceOrder")
	public JAXBElement<ReplaceOrder> createReplaceOrder(ReplaceOrder value) {
		return new JAXBElement<ReplaceOrder>(_ReplaceOrder_QNAME, ReplaceOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderModifyRecordOperatorLogsById }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderModifyRecordOperatorLogsById")
	public JAXBElement<GetOrderModifyRecordOperatorLogsById> createGetOrderModifyRecordOperatorLogsById(
			GetOrderModifyRecordOperatorLogsById value) {
		return new JAXBElement<GetOrderModifyRecordOperatorLogsById>(_GetOrderModifyRecordOperatorLogsById_QNAME,
				GetOrderModifyRecordOperatorLogsById.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AddReportOrder }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "addReportOrder")
	public JAXBElement<AddReportOrder> createAddReportOrder(AddReportOrder value) {
		return new JAXBElement<AddReportOrder>(_AddReportOrder_QNAME, AddReportOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderByCode }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderByCode")
	public JAXBElement<GetOrderByCode> createGetOrderByCode(GetOrderByCode value) {
		return new JAXBElement<GetOrderByCode>(_GetOrderByCode_QNAME, GetOrderByCode.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RequestProcessingOrderItem }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "requestProcessingOrderItem")
	public JAXBElement<RequestProcessingOrderItem> createRequestProcessingOrderItem(RequestProcessingOrderItem value) {
		return new JAXBElement<RequestProcessingOrderItem>(_RequestProcessingOrderItem_QNAME,
				RequestProcessingOrderItem.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderItemOperatorLogById }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderItemOperatorLogById")
	public JAXBElement<GetOrderItemOperatorLogById> createGetOrderItemOperatorLogById(GetOrderItemOperatorLogById value) {
		return new JAXBElement<GetOrderItemOperatorLogById>(_GetOrderItemOperatorLogById_QNAME,
				GetOrderItemOperatorLogById.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderItemRelateBoxsByOrderItemId }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderItemRelateBoxsByOrderItemId")
	public JAXBElement<GetOrderItemRelateBoxsByOrderItemId> createGetOrderItemRelateBoxsByOrderItemId(
			GetOrderItemRelateBoxsByOrderItemId value) {
		return new JAXBElement<GetOrderItemRelateBoxsByOrderItemId>(_GetOrderItemRelateBoxsByOrderItemId_QNAME,
				GetOrderItemRelateBoxsByOrderItemId.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderResponse")
	public JAXBElement<UpdateOrderResponse> createUpdateOrderResponse(UpdateOrderResponse value) {
		return new JAXBElement<UpdateOrderResponse>(_UpdateOrderResponse_QNAME, UpdateOrderResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CompleteOrder }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "completeOrder")
	public JAXBElement<CompleteOrder> createCompleteOrder(CompleteOrder value) {
		return new JAXBElement<CompleteOrder>(_CompleteOrder_QNAME, CompleteOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link BussinessException }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "BussinessException")
	public JAXBElement<BussinessException> createBussinessException(BussinessException value) {
		return new JAXBElement<BussinessException>(_BussinessException_QNAME, BussinessException.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderApplayOperatorLogResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderApplayOperatorLogResponse")
	public JAXBElement<GetOrderApplayOperatorLogResponse> createGetOrderApplayOperatorLogResponse(
			GetOrderApplayOperatorLogResponse value) {
		return new JAXBElement<GetOrderApplayOperatorLogResponse>(_GetOrderApplayOperatorLogResponse_QNAME,
				GetOrderApplayOperatorLogResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDeliveryLimiteInfoResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getDeliveryLimiteInfoResponse")
	public JAXBElement<GetDeliveryLimiteInfoResponse> createGetDeliveryLimiteInfoResponse(
			GetDeliveryLimiteInfoResponse value) {
		return new JAXBElement<GetDeliveryLimiteInfoResponse>(_GetDeliveryLimiteInfoResponse_QNAME,
				GetDeliveryLimiteInfoResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReplaceOrderItemResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "replaceOrderItemResponse")
	public JAXBElement<ReplaceOrderItemResponse> createReplaceOrderItemResponse(ReplaceOrderItemResponse value) {
		return new JAXBElement<ReplaceOrderItemResponse>(_ReplaceOrderItemResponse_QNAME,
				ReplaceOrderItemResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderItemRelateBoxsByOrderItemIdResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderItemRelateBoxsByOrderItemIdResponse")
	public JAXBElement<GetOrderItemRelateBoxsByOrderItemIdResponse> createGetOrderItemRelateBoxsByOrderItemIdResponse(
			GetOrderItemRelateBoxsByOrderItemIdResponse value) {
		return new JAXBElement<GetOrderItemRelateBoxsByOrderItemIdResponse>(
				_GetOrderItemRelateBoxsByOrderItemIdResponse_QNAME, GetOrderItemRelateBoxsByOrderItemIdResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CancleOrderItemResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "cancleOrderItemResponse")
	public JAXBElement<CancleOrderItemResponse> createCancleOrderItemResponse(CancleOrderItemResponse value) {
		return new JAXBElement<CancleOrderItemResponse>(_CancleOrderItemResponse_QNAME, CancleOrderItemResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderReadySellLackLogResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderReadySellLackLogResponse")
	public JAXBElement<GetOrderReadySellLackLogResponse> createGetOrderReadySellLackLogResponse(
			GetOrderReadySellLackLogResponse value) {
		return new JAXBElement<GetOrderReadySellLackLogResponse>(_GetOrderReadySellLackLogResponse_QNAME,
				GetOrderReadySellLackLogResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderReadySellLackLog }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderReadySellLackLog")
	public JAXBElement<GetOrderReadySellLackLog> createGetOrderReadySellLackLog(GetOrderReadySellLackLog value) {
		return new JAXBElement<GetOrderReadySellLackLog>(_GetOrderReadySellLackLog_QNAME,
				GetOrderReadySellLackLog.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link OrderSetQuality }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "orderSetQuality")
	public JAXBElement<OrderSetQuality> createOrderSetQuality(OrderSetQuality value) {
		return new JAXBElement<OrderSetQuality>(_OrderSetQuality_QNAME, OrderSetQuality.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderById }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderById")
	public JAXBElement<GetOrderById> createGetOrderById(GetOrderById value) {
		return new JAXBElement<GetOrderById>(_GetOrderById_QNAME, GetOrderById.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderModifyRecordOperatorLogById }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderModifyRecordOperatorLogById")
	public JAXBElement<GetOrderModifyRecordOperatorLogById> createGetOrderModifyRecordOperatorLogById(
			GetOrderModifyRecordOperatorLogById value) {
		return new JAXBElement<GetOrderModifyRecordOperatorLogById>(_GetOrderModifyRecordOperatorLogById_QNAME,
				GetOrderModifyRecordOperatorLogById.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveOrderGroupResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "removeOrderGroupResponse")
	public JAXBElement<RemoveOrderGroupResponse> createRemoveOrderGroupResponse(RemoveOrderGroupResponse value) {
		return new JAXBElement<RemoveOrderGroupResponse>(_RemoveOrderGroupResponse_QNAME,
				RemoveOrderGroupResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderRemark }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderRemark")
	public JAXBElement<UpdateOrderRemark> createUpdateOrderRemark(UpdateOrderRemark value) {
		return new JAXBElement<UpdateOrderRemark>(_UpdateOrderRemark_QNAME, UpdateOrderRemark.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SetConsultationUser }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "setConsultationUser")
	public JAXBElement<SetConsultationUser> createSetConsultationUser(SetConsultationUser value) {
		return new JAXBElement<SetConsultationUser>(_SetConsultationUser_QNAME, SetConsultationUser.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DealOrderCommunicationLogResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "dealOrderCommunicationLogResponse")
	public JAXBElement<DealOrderCommunicationLogResponse> createDealOrderCommunicationLogResponse(
			DealOrderCommunicationLogResponse value) {
		return new JAXBElement<DealOrderCommunicationLogResponse>(_DealOrderCommunicationLogResponse_QNAME,
				DealOrderCommunicationLogResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderDeliveryInfo }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderDeliveryInfo")
	public JAXBElement<UpdateOrderDeliveryInfo> createUpdateOrderDeliveryInfo(UpdateOrderDeliveryInfo value) {
		return new JAXBElement<UpdateOrderDeliveryInfo>(_UpdateOrderDeliveryInfo_QNAME, UpdateOrderDeliveryInfo.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetLastOrderWeighingRecordByOrderCodeResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getLastOrderWeighingRecordByOrderCodeResponse")
	public JAXBElement<GetLastOrderWeighingRecordByOrderCodeResponse> createGetLastOrderWeighingRecordByOrderCodeResponse(
			GetLastOrderWeighingRecordByOrderCodeResponse value) {
		return new JAXBElement<GetLastOrderWeighingRecordByOrderCodeResponse>(
				_GetLastOrderWeighingRecordByOrderCodeResponse_QNAME,
				GetLastOrderWeighingRecordByOrderCodeResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SetOrderTracking }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "setOrderTracking")
	public JAXBElement<SetOrderTracking> createSetOrderTracking(SetOrderTracking value) {
		return new JAXBElement<SetOrderTracking>(_SetOrderTracking_QNAME, SetOrderTracking.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderItemRemarkResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderItemRemarkResponse")
	public JAXBElement<UpdateOrderItemRemarkResponse> createUpdateOrderItemRemarkResponse(
			UpdateOrderItemRemarkResponse value) {
		return new JAXBElement<UpdateOrderItemRemarkResponse>(_UpdateOrderItemRemarkResponse_QNAME,
				UpdateOrderItemRemarkResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetApplayByIdResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getApplayByIdResponse")
	public JAXBElement<GetApplayByIdResponse> createGetApplayByIdResponse(GetApplayByIdResponse value) {
		return new JAXBElement<GetApplayByIdResponse>(_GetApplayByIdResponse_QNAME, GetApplayByIdResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderModifyRecordByIdResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderModifyRecordByIdResponse")
	public JAXBElement<GetOrderModifyRecordByIdResponse> createGetOrderModifyRecordByIdResponse(
			GetOrderModifyRecordByIdResponse value) {
		return new JAXBElement<GetOrderModifyRecordByIdResponse>(_GetOrderModifyRecordByIdResponse_QNAME,
				GetOrderModifyRecordByIdResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CancelProcessingOrderItem }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "cancelProcessingOrderItem")
	public JAXBElement<CancelProcessingOrderItem> createCancelProcessingOrderItem(CancelProcessingOrderItem value) {
		return new JAXBElement<CancelProcessingOrderItem>(_CancelProcessingOrderItem_QNAME,
				CancelProcessingOrderItem.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateMultiOrderItem }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateMultiOrderItem")
	public JAXBElement<UpdateMultiOrderItem> createUpdateMultiOrderItem(UpdateMultiOrderItem value) {
		return new JAXBElement<UpdateMultiOrderItem>(_UpdateMultiOrderItem_QNAME, UpdateMultiOrderItem.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SendReadyOrderItemsResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "sendReadyOrderItemsResponse")
	public JAXBElement<SendReadyOrderItemsResponse> createSendReadyOrderItemsResponse(SendReadyOrderItemsResponse value) {
		return new JAXBElement<SendReadyOrderItemsResponse>(_SendReadyOrderItemsResponse_QNAME,
				SendReadyOrderItemsResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RequestProcessingOrderItemResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "requestProcessingOrderItemResponse")
	public JAXBElement<RequestProcessingOrderItemResponse> createRequestProcessingOrderItemResponse(
			RequestProcessingOrderItemResponse value) {
		return new JAXBElement<RequestProcessingOrderItemResponse>(_RequestProcessingOrderItemResponse_QNAME,
				RequestProcessingOrderItemResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SendReadyOrderItems }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "sendReadyOrderItems")
	public JAXBElement<SendReadyOrderItems> createSendReadyOrderItems(SendReadyOrderItems value) {
		return new JAXBElement<SendReadyOrderItems>(_SendReadyOrderItems_QNAME, SendReadyOrderItems.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderTrackingReplayHistory }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderTrackingReplayHistory")
	public JAXBElement<GetOrderTrackingReplayHistory> createGetOrderTrackingReplayHistory(
			GetOrderTrackingReplayHistory value) {
		return new JAXBElement<GetOrderTrackingReplayHistory>(_GetOrderTrackingReplayHistory_QNAME,
				GetOrderTrackingReplayHistory.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateMultiOrderItemResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateMultiOrderItemResponse")
	public JAXBElement<UpdateMultiOrderItemResponse> createUpdateMultiOrderItemResponse(
			UpdateMultiOrderItemResponse value) {
		return new JAXBElement<UpdateMultiOrderItemResponse>(_UpdateMultiOrderItemResponse_QNAME,
				UpdateMultiOrderItemResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ApplayOrderResend }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "applayOrderResend")
	public JAXBElement<ApplayOrderResend> createApplayOrderResend(ApplayOrderResend value) {
		return new JAXBElement<ApplayOrderResend>(_ApplayOrderResend_QNAME, ApplayOrderResend.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link FindOrderTrackingResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "findOrderTrackingResponse")
	public JAXBElement<FindOrderTrackingResponse> createFindOrderTrackingResponse(FindOrderTrackingResponse value) {
		return new JAXBElement<FindOrderTrackingResponse>(_FindOrderTrackingResponse_QNAME,
				FindOrderTrackingResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderItemByOrderIdResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderItemByOrderIdResponse")
	public JAXBElement<GetOrderItemByOrderIdResponse> createGetOrderItemByOrderIdResponse(
			GetOrderItemByOrderIdResponse value) {
		return new JAXBElement<GetOrderItemByOrderIdResponse>(_GetOrderItemByOrderIdResponse_QNAME,
				GetOrderItemByOrderIdResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link OrderSetQualityResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "orderSetQualityResponse")
	public JAXBElement<OrderSetQualityResponse> createOrderSetQualityResponse(OrderSetQualityResponse value) {
		return new JAXBElement<OrderSetQualityResponse>(_OrderSetQualityResponse_QNAME, OrderSetQualityResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderHandler }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderHandler")
	public JAXBElement<UpdateOrderHandler> createUpdateOrderHandler(UpdateOrderHandler value) {
		return new JAXBElement<UpdateOrderHandler>(_UpdateOrderHandler_QNAME, UpdateOrderHandler.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateMutilOrderItemRemarkResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateMutilOrderItemRemarkResponse")
	public JAXBElement<UpdateMutilOrderItemRemarkResponse> createUpdateMutilOrderItemRemarkResponse(
			UpdateMutilOrderItemRemarkResponse value) {
		return new JAXBElement<UpdateMutilOrderItemRemarkResponse>(_UpdateMutilOrderItemRemarkResponse_QNAME,
				UpdateMutilOrderItemRemarkResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderByCodeResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderByCodeResponse")
	public JAXBElement<GetOrderByCodeResponse> createGetOrderByCodeResponse(GetOrderByCodeResponse value) {
		return new JAXBElement<GetOrderByCodeResponse>(_GetOrderByCodeResponse_QNAME, GetOrderByCodeResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SetOrderTrackingRemarkResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "setOrderTrackingRemarkResponse")
	public JAXBElement<SetOrderTrackingRemarkResponse> createSetOrderTrackingRemarkResponse(
			SetOrderTrackingRemarkResponse value) {
		return new JAXBElement<SetOrderTrackingRemarkResponse>(_SetOrderTrackingRemarkResponse_QNAME,
				SetOrderTrackingRemarkResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderHandlerByCustomerResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderHandlerByCustomerResponse")
	public JAXBElement<UpdateOrderHandlerByCustomerResponse> createUpdateOrderHandlerByCustomerResponse(
			UpdateOrderHandlerByCustomerResponse value) {
		return new JAXBElement<UpdateOrderHandlerByCustomerResponse>(_UpdateOrderHandlerByCustomerResponse_QNAME,
				UpdateOrderHandlerByCustomerResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RemoveOrderGroup }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "removeOrderGroup")
	public JAXBElement<RemoveOrderGroup> createRemoveOrderGroup(RemoveOrderGroup value) {
		return new JAXBElement<RemoveOrderGroup>(_RemoveOrderGroup_QNAME, RemoveOrderGroup.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CompleteOrderTracking }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "completeOrderTracking")
	public JAXBElement<CompleteOrderTracking> createCompleteOrderTracking(CompleteOrderTracking value) {
		return new JAXBElement<CompleteOrderTracking>(_CompleteOrderTracking_QNAME, CompleteOrderTracking.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetAttachmentByCodeResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getAttachmentByCodeResponse")
	public JAXBElement<GetAttachmentByCodeResponse> createGetAttachmentByCodeResponse(GetAttachmentByCodeResponse value) {
		return new JAXBElement<GetAttachmentByCodeResponse>(_GetAttachmentByCodeResponse_QNAME,
				GetAttachmentByCodeResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetApplayById }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getApplayById")
	public JAXBElement<GetApplayById> createGetApplayById(GetApplayById value) {
		return new JAXBElement<GetApplayById>(_GetApplayById_QNAME, GetApplayById.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CancleMultiOrderItemResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "cancleMultiOrderItemResponse")
	public JAXBElement<CancleMultiOrderItemResponse> createCancleMultiOrderItemResponse(
			CancleMultiOrderItemResponse value) {
		return new JAXBElement<CancleMultiOrderItemResponse>(_CancleMultiOrderItemResponse_QNAME,
				CancleMultiOrderItemResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateIsCanSendResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateIsCanSendResponse")
	public JAXBElement<UpdateIsCanSendResponse> createUpdateIsCanSendResponse(UpdateIsCanSendResponse value) {
		return new JAXBElement<UpdateIsCanSendResponse>(_UpdateIsCanSendResponse_QNAME, UpdateIsCanSendResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderGroupResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderGroupResponse")
	public JAXBElement<UpdateOrderGroupResponse> createUpdateOrderGroupResponse(UpdateOrderGroupResponse value) {
		return new JAXBElement<UpdateOrderGroupResponse>(_UpdateOrderGroupResponse_QNAME,
				UpdateOrderGroupResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderRemarkResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderRemarkResponse")
	public JAXBElement<UpdateOrderRemarkResponse> createUpdateOrderRemarkResponse(UpdateOrderRemarkResponse value) {
		return new JAXBElement<UpdateOrderRemarkResponse>(_UpdateOrderRemarkResponse_QNAME,
				UpdateOrderRemarkResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderModifyRecords }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderModifyRecords")
	public JAXBElement<GetOrderModifyRecords> createGetOrderModifyRecords(GetOrderModifyRecords value) {
		return new JAXBElement<GetOrderModifyRecords>(_GetOrderModifyRecords_QNAME, GetOrderModifyRecords.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderApplayOperatorLogById }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderApplayOperatorLogById")
	public JAXBElement<GetOrderApplayOperatorLogById> createGetOrderApplayOperatorLogById(
			GetOrderApplayOperatorLogById value) {
		return new JAXBElement<GetOrderApplayOperatorLogById>(_GetOrderApplayOperatorLogById_QNAME,
				GetOrderApplayOperatorLogById.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderItemResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderItemResponse")
	public JAXBElement<UpdateOrderItemResponse> createUpdateOrderItemResponse(UpdateOrderItemResponse value) {
		return new JAXBElement<UpdateOrderItemResponse>(_UpdateOrderItemResponse_QNAME, UpdateOrderItemResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CancleOrder }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "cancleOrder")
	public JAXBElement<CancleOrder> createCancleOrder(CancleOrder value) {
		return new JAXBElement<CancleOrder>(_CancleOrder_QNAME, CancleOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetApplayItemsByApplayId }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getApplayItemsByApplayId")
	public JAXBElement<GetApplayItemsByApplayId> createGetApplayItemsByApplayId(GetApplayItemsByApplayId value) {
		return new JAXBElement<GetApplayItemsByApplayId>(_GetApplayItemsByApplayId_QNAME,
				GetApplayItemsByApplayId.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetDeliveryLimiteInfo }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getDeliveryLimiteInfo")
	public JAXBElement<GetDeliveryLimiteInfo> createGetDeliveryLimiteInfo(GetDeliveryLimiteInfo value) {
		return new JAXBElement<GetDeliveryLimiteInfo>(_GetDeliveryLimiteInfo_QNAME, GetDeliveryLimiteInfo.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link UpdateOrderItem }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderItem")
	public JAXBElement<UpdateOrderItem> createUpdateOrderItem(UpdateOrderItem value) {
		return new JAXBElement<UpdateOrderItem>(_UpdateOrderItem_QNAME, UpdateOrderItem.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderGroup }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderGroup")
	public JAXBElement<UpdateOrderGroup> createUpdateOrderGroup(UpdateOrderGroup value) {
		return new JAXBElement<UpdateOrderGroup>(_UpdateOrderGroup_QNAME, UpdateOrderGroup.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReplyOrderTracking }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "replyOrderTracking")
	public JAXBElement<ReplyOrderTracking> createReplyOrderTracking(ReplyOrderTracking value) {
		return new JAXBElement<ReplyOrderTracking>(_ReplyOrderTracking_QNAME, ReplyOrderTracking.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CompleteMultiOrder }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "completeMultiOrder")
	public JAXBElement<CompleteMultiOrder> createCompleteMultiOrder(CompleteMultiOrder value) {
		return new JAXBElement<CompleteMultiOrder>(_CompleteMultiOrder_QNAME, CompleteMultiOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderModifyRecordsResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderModifyRecordsResponse")
	public JAXBElement<GetOrderModifyRecordsResponse> createGetOrderModifyRecordsResponse(
			GetOrderModifyRecordsResponse value) {
		return new JAXBElement<GetOrderModifyRecordsResponse>(_GetOrderModifyRecordsResponse_QNAME,
				GetOrderModifyRecordsResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderItemWeightResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderItemWeightResponse")
	public JAXBElement<UpdateOrderItemWeightResponse> createUpdateOrderItemWeightResponse(
			UpdateOrderItemWeightResponse value) {
		return new JAXBElement<UpdateOrderItemWeightResponse>(_UpdateOrderItemWeightResponse_QNAME,
				UpdateOrderItemWeightResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddReportOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "addReportOrderResponse")
	public JAXBElement<AddReportOrderResponse> createAddReportOrderResponse(AddReportOrderResponse value) {
		return new JAXBElement<AddReportOrderResponse>(_AddReportOrderResponse_QNAME, AddReportOrderResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SetOrderTrackingRemark }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "setOrderTrackingRemark")
	public JAXBElement<SetOrderTrackingRemark> createSetOrderTrackingRemark(SetOrderTrackingRemark value) {
		return new JAXBElement<SetOrderTrackingRemark>(_SetOrderTrackingRemark_QNAME, SetOrderTrackingRemark.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link UpdateOrder }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrder")
	public JAXBElement<UpdateOrder> createUpdateOrder(UpdateOrder value) {
		return new JAXBElement<UpdateOrder>(_UpdateOrder_QNAME, UpdateOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DealOrderReadySellLackLogResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "dealOrderReadySellLackLogResponse")
	public JAXBElement<DealOrderReadySellLackLogResponse> createDealOrderReadySellLackLogResponse(
			DealOrderReadySellLackLogResponse value) {
		return new JAXBElement<DealOrderReadySellLackLogResponse>(_DealOrderReadySellLackLogResponse_QNAME,
				DealOrderReadySellLackLogResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderTrackingOperatorLog }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderTrackingOperatorLog")
	public JAXBElement<GetOrderTrackingOperatorLog> createGetOrderTrackingOperatorLog(GetOrderTrackingOperatorLog value) {
		return new JAXBElement<GetOrderTrackingOperatorLog>(_GetOrderTrackingOperatorLog_QNAME,
				GetOrderTrackingOperatorLog.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetLastOrderWeighingRecordByOrderCode }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getLastOrderWeighingRecordByOrderCode")
	public JAXBElement<GetLastOrderWeighingRecordByOrderCode> createGetLastOrderWeighingRecordByOrderCode(
			GetLastOrderWeighingRecordByOrderCode value) {
		return new JAXBElement<GetLastOrderWeighingRecordByOrderCode>(_GetLastOrderWeighingRecordByOrderCode_QNAME,
				GetLastOrderWeighingRecordByOrderCode.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderTrackingReplayHistoryResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderTrackingReplayHistoryResponse")
	public JAXBElement<GetOrderTrackingReplayHistoryResponse> createGetOrderTrackingReplayHistoryResponse(
			GetOrderTrackingReplayHistoryResponse value) {
		return new JAXBElement<GetOrderTrackingReplayHistoryResponse>(_GetOrderTrackingReplayHistoryResponse_QNAME,
				GetOrderTrackingReplayHistoryResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReplaceOrderItem }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "replaceOrderItem")
	public JAXBElement<ReplaceOrderItem> createReplaceOrderItem(ReplaceOrderItem value) {
		return new JAXBElement<ReplaceOrderItem>(_ReplaceOrderItem_QNAME, ReplaceOrderItem.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CompleteOrderTrackingResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "completeOrderTrackingResponse")
	public JAXBElement<CompleteOrderTrackingResponse> createCompleteOrderTrackingResponse(
			CompleteOrderTrackingResponse value) {
		return new JAXBElement<CompleteOrderTrackingResponse>(_CompleteOrderTrackingResponse_QNAME,
				CompleteOrderTrackingResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DealOrderReadySellLackLog }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "dealOrderReadySellLackLog")
	public JAXBElement<DealOrderReadySellLackLog> createDealOrderReadySellLackLog(DealOrderReadySellLackLog value) {
		return new JAXBElement<DealOrderReadySellLackLog>(_DealOrderReadySellLackLog_QNAME,
				DealOrderReadySellLackLog.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderDiscount }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderDiscount")
	public JAXBElement<UpdateOrderDiscount> createUpdateOrderDiscount(UpdateOrderDiscount value) {
		return new JAXBElement<UpdateOrderDiscount>(_UpdateOrderDiscount_QNAME, UpdateOrderDiscount.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderItemWeight }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderItemWeight")
	public JAXBElement<UpdateOrderItemWeight> createUpdateOrderItemWeight(UpdateOrderItemWeight value) {
		return new JAXBElement<UpdateOrderItemWeight>(_UpdateOrderItemWeight_QNAME, UpdateOrderItemWeight.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetApplayItemsByApplayIdResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getApplayItemsByApplayIdResponse")
	public JAXBElement<GetApplayItemsByApplayIdResponse> createGetApplayItemsByApplayIdResponse(
			GetApplayItemsByApplayIdResponse value) {
		return new JAXBElement<GetApplayItemsByApplayIdResponse>(_GetApplayItemsByApplayIdResponse_QNAME,
				GetApplayItemsByApplayIdResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DealOrderCommunicationLogSuccessResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "dealOrderCommunicationLogSuccessResponse")
	public JAXBElement<DealOrderCommunicationLogSuccessResponse> createDealOrderCommunicationLogSuccessResponse(
			DealOrderCommunicationLogSuccessResponse value) {
		return new JAXBElement<DealOrderCommunicationLogSuccessResponse>(
				_DealOrderCommunicationLogSuccessResponse_QNAME, DealOrderCommunicationLogSuccessResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SetConsultationUserResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "setConsultationUserResponse")
	public JAXBElement<SetConsultationUserResponse> createSetConsultationUserResponse(SetConsultationUserResponse value) {
		return new JAXBElement<SetConsultationUserResponse>(_SetConsultationUserResponse_QNAME,
				SetConsultationUserResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderDelivery }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderDelivery")
	public JAXBElement<UpdateOrderDelivery> createUpdateOrderDelivery(UpdateOrderDelivery value) {
		return new JAXBElement<UpdateOrderDelivery>(_UpdateOrderDelivery_QNAME, UpdateOrderDelivery.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderTrackingById }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderTrackingById")
	public JAXBElement<GetOrderTrackingById> createGetOrderTrackingById(GetOrderTrackingById value) {
		return new JAXBElement<GetOrderTrackingById>(_GetOrderTrackingById_QNAME, GetOrderTrackingById.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SendToCustomer }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "sendToCustomer")
	public JAXBElement<SendToCustomer> createSendToCustomer(SendToCustomer value) {
		return new JAXBElement<SendToCustomer>(_SendToCustomer_QNAME, SendToCustomer.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReplaceOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "replaceOrderResponse")
	public JAXBElement<ReplaceOrderResponse> createReplaceOrderResponse(ReplaceOrderResponse value) {
		return new JAXBElement<ReplaceOrderResponse>(_ReplaceOrderResponse_QNAME, ReplaceOrderResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SplitOrder }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "splitOrder")
	public JAXBElement<SplitOrder> createSplitOrder(SplitOrder value) {
		return new JAXBElement<SplitOrder>(_SplitOrder_QNAME, SplitOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderApplayOperatorLog }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderApplayOperatorLog")
	public JAXBElement<GetOrderApplayOperatorLog> createGetOrderApplayOperatorLog(GetOrderApplayOperatorLog value) {
		return new JAXBElement<GetOrderApplayOperatorLog>(_GetOrderApplayOperatorLog_QNAME,
				GetOrderApplayOperatorLog.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderModifyRecordOperatorLog }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderModifyRecordOperatorLog")
	public JAXBElement<GetOrderModifyRecordOperatorLog> createGetOrderModifyRecordOperatorLog(
			GetOrderModifyRecordOperatorLog value) {
		return new JAXBElement<GetOrderModifyRecordOperatorLog>(_GetOrderModifyRecordOperatorLog_QNAME,
				GetOrderModifyRecordOperatorLog.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DealOrderCommunicationLog }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "dealOrderCommunicationLog")
	public JAXBElement<DealOrderCommunicationLog> createDealOrderCommunicationLog(DealOrderCommunicationLog value) {
		return new JAXBElement<DealOrderCommunicationLog>(_DealOrderCommunicationLog_QNAME,
				DealOrderCommunicationLog.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RequestCollateOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "requestCollateOrderResponse")
	public JAXBElement<RequestCollateOrderResponse> createRequestCollateOrderResponse(RequestCollateOrderResponse value) {
		return new JAXBElement<RequestCollateOrderResponse>(_RequestCollateOrderResponse_QNAME,
				RequestCollateOrderResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CreatePendingOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "createPendingOrderResponse")
	public JAXBElement<CreatePendingOrderResponse> createCreatePendingOrderResponse(CreatePendingOrderResponse value) {
		return new JAXBElement<CreatePendingOrderResponse>(_CreatePendingOrderResponse_QNAME,
				CreatePendingOrderResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderPayStatusResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderPayStatusResponse")
	public JAXBElement<UpdateOrderPayStatusResponse> createUpdateOrderPayStatusResponse(
			UpdateOrderPayStatusResponse value) {
		return new JAXBElement<UpdateOrderPayStatusResponse>(_UpdateOrderPayStatusResponse_QNAME,
				UpdateOrderPayStatusResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderOperatorLog }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderOperatorLog")
	public JAXBElement<GetOrderOperatorLog> createGetOrderOperatorLog(GetOrderOperatorLog value) {
		return new JAXBElement<GetOrderOperatorLog>(_GetOrderOperatorLog_QNAME, GetOrderOperatorLog.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderItemById }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderItemById")
	public JAXBElement<GetOrderItemById> createGetOrderItemById(GetOrderItemById value) {
		return new JAXBElement<GetOrderItemById>(_GetOrderItemById_QNAME, GetOrderItemById.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderCountryResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderCountryResponse")
	public JAXBElement<UpdateOrderCountryResponse> createUpdateOrderCountryResponse(UpdateOrderCountryResponse value) {
		return new JAXBElement<UpdateOrderCountryResponse>(_UpdateOrderCountryResponse_QNAME,
				UpdateOrderCountryResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderByIdResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderByIdResponse")
	public JAXBElement<GetOrderByIdResponse> createGetOrderByIdResponse(GetOrderByIdResponse value) {
		return new JAXBElement<GetOrderByIdResponse>(_GetOrderByIdResponse_QNAME, GetOrderByIdResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderHandlerResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderHandlerResponse")
	public JAXBElement<UpdateOrderHandlerResponse> createUpdateOrderHandlerResponse(UpdateOrderHandlerResponse value) {
		return new JAXBElement<UpdateOrderHandlerResponse>(_UpdateOrderHandlerResponse_QNAME,
				UpdateOrderHandlerResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderModifyRecordById }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderModifyRecordById")
	public JAXBElement<GetOrderModifyRecordById> createGetOrderModifyRecordById(GetOrderModifyRecordById value) {
		return new JAXBElement<GetOrderModifyRecordById>(_GetOrderModifyRecordById_QNAME,
				GetOrderModifyRecordById.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddAttachmentFileResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "addAttachmentFileResponse")
	public JAXBElement<AddAttachmentFileResponse> createAddAttachmentFileResponse(AddAttachmentFileResponse value) {
		return new JAXBElement<AddAttachmentFileResponse>(_AddAttachmentFileResponse_QNAME,
				AddAttachmentFileResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateMutilOrderItemRemark }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateMutilOrderItemRemark")
	public JAXBElement<UpdateMutilOrderItemRemark> createUpdateMutilOrderItemRemark(UpdateMutilOrderItemRemark value) {
		return new JAXBElement<UpdateMutilOrderItemRemark>(_UpdateMutilOrderItemRemark_QNAME,
				UpdateMutilOrderItemRemark.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderDeliveryResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderDeliveryResponse")
	public JAXBElement<UpdateOrderDeliveryResponse> createUpdateOrderDeliveryResponse(UpdateOrderDeliveryResponse value) {
		return new JAXBElement<UpdateOrderDeliveryResponse>(_UpdateOrderDeliveryResponse_QNAME,
				UpdateOrderDeliveryResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderItemOperatorLog }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderItemOperatorLog")
	public JAXBElement<GetOrderItemOperatorLog> createGetOrderItemOperatorLog(GetOrderItemOperatorLog value) {
		return new JAXBElement<GetOrderItemOperatorLog>(_GetOrderItemOperatorLog_QNAME, GetOrderItemOperatorLog.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderItemByIdResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderItemByIdResponse")
	public JAXBElement<GetOrderItemByIdResponse> createGetOrderItemByIdResponse(GetOrderItemByIdResponse value) {
		return new JAXBElement<GetOrderItemByIdResponse>(_GetOrderItemByIdResponse_QNAME,
				GetOrderItemByIdResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderItemQuantityResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderItemQuantityResponse")
	public JAXBElement<UpdateOrderItemQuantityResponse> createUpdateOrderItemQuantityResponse(
			UpdateOrderItemQuantityResponse value) {
		return new JAXBElement<UpdateOrderItemQuantityResponse>(_UpdateOrderItemQuantityResponse_QNAME,
				UpdateOrderItemQuantityResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateItemPriceResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateItemPriceResponse")
	public JAXBElement<UpdateItemPriceResponse> createUpdateItemPriceResponse(UpdateItemPriceResponse value) {
		return new JAXBElement<UpdateItemPriceResponse>(_UpdateItemPriceResponse_QNAME, UpdateItemPriceResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderDeliveryInfoResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderDeliveryInfoResponse")
	public JAXBElement<UpdateOrderDeliveryInfoResponse> createUpdateOrderDeliveryInfoResponse(
			UpdateOrderDeliveryInfoResponse value) {
		return new JAXBElement<UpdateOrderDeliveryInfoResponse>(_UpdateOrderDeliveryInfoResponse_QNAME,
				UpdateOrderDeliveryInfoResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderCommunicationLogResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderCommunicationLogResponse")
	public JAXBElement<GetOrderCommunicationLogResponse> createGetOrderCommunicationLogResponse(
			GetOrderCommunicationLogResponse value) {
		return new JAXBElement<GetOrderCommunicationLogResponse>(_GetOrderCommunicationLogResponse_QNAME,
				GetOrderCommunicationLogResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "addOrderResponse")
	public JAXBElement<AddOrderResponse> createAddOrderResponse(AddOrderResponse value) {
		return new JAXBElement<AddOrderResponse>(_AddOrderResponse_QNAME, AddOrderResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ApplayOrderShelve }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "applayOrderShelve")
	public JAXBElement<ApplayOrderShelve> createApplayOrderShelve(ApplayOrderShelve value) {
		return new JAXBElement<ApplayOrderShelve>(_ApplayOrderShelve_QNAME, ApplayOrderShelve.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderPayStatus }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderPayStatus")
	public JAXBElement<UpdateOrderPayStatus> createUpdateOrderPayStatus(UpdateOrderPayStatus value) {
		return new JAXBElement<UpdateOrderPayStatus>(_UpdateOrderPayStatus_QNAME, UpdateOrderPayStatus.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link IsAssigningOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "isAssigningOrderResponse")
	public JAXBElement<IsAssigningOrderResponse> createIsAssigningOrderResponse(IsAssigningOrderResponse value) {
		return new JAXBElement<IsAssigningOrderResponse>(_IsAssigningOrderResponse_QNAME,
				IsAssigningOrderResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderItemOperatorLogResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderItemOperatorLogResponse")
	public JAXBElement<GetOrderItemOperatorLogResponse> createGetOrderItemOperatorLogResponse(
			GetOrderItemOperatorLogResponse value) {
		return new JAXBElement<GetOrderItemOperatorLogResponse>(_GetOrderItemOperatorLogResponse_QNAME,
				GetOrderItemOperatorLogResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderItemByOrderId }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderItemByOrderId")
	public JAXBElement<GetOrderItemByOrderId> createGetOrderItemByOrderId(GetOrderItemByOrderId value) {
		return new JAXBElement<GetOrderItemByOrderId>(_GetOrderItemByOrderId_QNAME, GetOrderItemByOrderId.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DelOrderTrackingResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "delOrderTrackingResponse")
	public JAXBElement<DelOrderTrackingResponse> createDelOrderTrackingResponse(DelOrderTrackingResponse value) {
		return new JAXBElement<DelOrderTrackingResponse>(_DelOrderTrackingResponse_QNAME,
				DelOrderTrackingResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderTrackingOperatorLogResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderTrackingOperatorLogResponse")
	public JAXBElement<GetOrderTrackingOperatorLogResponse> createGetOrderTrackingOperatorLogResponse(
			GetOrderTrackingOperatorLogResponse value) {
		return new JAXBElement<GetOrderTrackingOperatorLogResponse>(_GetOrderTrackingOperatorLogResponse_QNAME,
				GetOrderTrackingOperatorLogResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderHandlerCodeResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderHandlerCodeResponse")
	public JAXBElement<UpdateOrderHandlerCodeResponse> createUpdateOrderHandlerCodeResponse(
			UpdateOrderHandlerCodeResponse value) {
		return new JAXBElement<UpdateOrderHandlerCodeResponse>(_UpdateOrderHandlerCodeResponse_QNAME,
				UpdateOrderHandlerCodeResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CancleOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "cancleOrderResponse")
	public JAXBElement<CancleOrderResponse> createCancleOrderResponse(CancleOrderResponse value) {
		return new JAXBElement<CancleOrderResponse>(_CancleOrderResponse_QNAME, CancleOrderResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderTrackingOperatorLogById }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderTrackingOperatorLogById")
	public JAXBElement<GetOrderTrackingOperatorLogById> createGetOrderTrackingOperatorLogById(
			GetOrderTrackingOperatorLogById value) {
		return new JAXBElement<GetOrderTrackingOperatorLogById>(_GetOrderTrackingOperatorLogById_QNAME,
				GetOrderTrackingOperatorLogById.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderOperatorLogByIdResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderOperatorLogByIdResponse")
	public JAXBElement<GetOrderOperatorLogByIdResponse> createGetOrderOperatorLogByIdResponse(
			GetOrderOperatorLogByIdResponse value) {
		return new JAXBElement<GetOrderOperatorLogByIdResponse>(_GetOrderOperatorLogByIdResponse_QNAME,
				GetOrderOperatorLogByIdResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddMultiOrderItem }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "addMultiOrderItem")
	public JAXBElement<AddMultiOrderItem> createAddMultiOrderItem(AddMultiOrderItem value) {
		return new JAXBElement<AddMultiOrderItem>(_AddMultiOrderItem_QNAME, AddMultiOrderItem.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderHandlerByCustomer }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderHandlerByCustomer")
	public JAXBElement<UpdateOrderHandlerByCustomer> createUpdateOrderHandlerByCustomer(
			UpdateOrderHandlerByCustomer value) {
		return new JAXBElement<UpdateOrderHandlerByCustomer>(_UpdateOrderHandlerByCustomer_QNAME,
				UpdateOrderHandlerByCustomer.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderHandlerCode }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderHandlerCode")
	public JAXBElement<UpdateOrderHandlerCode> createUpdateOrderHandlerCode(UpdateOrderHandlerCode value) {
		return new JAXBElement<UpdateOrderHandlerCode>(_UpdateOrderHandlerCode_QNAME, UpdateOrderHandlerCode.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link FindOrderTracking }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "findOrderTracking")
	public JAXBElement<FindOrderTracking> createFindOrderTracking(FindOrderTracking value) {
		return new JAXBElement<FindOrderTracking>(_FindOrderTracking_QNAME, FindOrderTracking.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RequestCollateOrder }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "requestCollateOrder")
	public JAXBElement<RequestCollateOrder> createRequestCollateOrder(RequestCollateOrder value) {
		return new JAXBElement<RequestCollateOrder>(_RequestCollateOrder_QNAME, RequestCollateOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderModifyRecordOperatorLogsResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderModifyRecordOperatorLogsResponse")
	public JAXBElement<GetOrderModifyRecordOperatorLogsResponse> createGetOrderModifyRecordOperatorLogsResponse(
			GetOrderModifyRecordOperatorLogsResponse value) {
		return new JAXBElement<GetOrderModifyRecordOperatorLogsResponse>(
				_GetOrderModifyRecordOperatorLogsResponse_QNAME, GetOrderModifyRecordOperatorLogsResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DealOrderModifyRecord }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "dealOrderModifyRecord")
	public JAXBElement<DealOrderModifyRecord> createDealOrderModifyRecord(DealOrderModifyRecord value) {
		return new JAXBElement<DealOrderModifyRecord>(_DealOrderModifyRecord_QNAME, DealOrderModifyRecord.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderItemQuantity }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderItemQuantity")
	public JAXBElement<UpdateOrderItemQuantity> createUpdateOrderItemQuantity(UpdateOrderItemQuantity value) {
		return new JAXBElement<UpdateOrderItemQuantity>(_UpdateOrderItemQuantity_QNAME, UpdateOrderItemQuantity.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderModifyRecordOperatorLogs }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderModifyRecordOperatorLogs")
	public JAXBElement<GetOrderModifyRecordOperatorLogs> createGetOrderModifyRecordOperatorLogs(
			GetOrderModifyRecordOperatorLogs value) {
		return new JAXBElement<GetOrderModifyRecordOperatorLogs>(_GetOrderModifyRecordOperatorLogs_QNAME,
				GetOrderModifyRecordOperatorLogs.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DealOrderCommunicationLogSuccess }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "dealOrderCommunicationLogSuccess")
	public JAXBElement<DealOrderCommunicationLogSuccess> createDealOrderCommunicationLogSuccess(
			DealOrderCommunicationLogSuccess value) {
		return new JAXBElement<DealOrderCommunicationLogSuccess>(_DealOrderCommunicationLogSuccess_QNAME,
				DealOrderCommunicationLogSuccess.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderTrackingOperatorLogByIdResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderTrackingOperatorLogByIdResponse")
	public JAXBElement<GetOrderTrackingOperatorLogByIdResponse> createGetOrderTrackingOperatorLogByIdResponse(
			GetOrderTrackingOperatorLogByIdResponse value) {
		return new JAXBElement<GetOrderTrackingOperatorLogByIdResponse>(_GetOrderTrackingOperatorLogByIdResponse_QNAME,
				GetOrderTrackingOperatorLogByIdResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CompleteMultiOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "completeMultiOrderResponse")
	public JAXBElement<CompleteMultiOrderResponse> createCompleteMultiOrderResponse(CompleteMultiOrderResponse value) {
		return new JAXBElement<CompleteMultiOrderResponse>(_CompleteMultiOrderResponse_QNAME,
				CompleteMultiOrderResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AddOrder }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "addOrder")
	public JAXBElement<AddOrder> createAddOrder(AddOrder value) {
		return new JAXBElement<AddOrder>(_AddOrder_QNAME, AddOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReplyOrderTrackingResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "replyOrderTrackingResponse")
	public JAXBElement<ReplyOrderTrackingResponse> createReplyOrderTrackingResponse(ReplyOrderTrackingResponse value) {
		return new JAXBElement<ReplyOrderTrackingResponse>(_ReplyOrderTrackingResponse_QNAME,
				ReplyOrderTrackingResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link IsAssigningOrder }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "isAssigningOrder")
	public JAXBElement<IsAssigningOrder> createIsAssigningOrder(IsAssigningOrder value) {
		return new JAXBElement<IsAssigningOrder>(_IsAssigningOrder_QNAME, IsAssigningOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CancleOrderItem }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "cancleOrderItem")
	public JAXBElement<CancleOrderItem> createCancleOrderItem(CancleOrderItem value) {
		return new JAXBElement<CancleOrderItem>(_CancleOrderItem_QNAME, CancleOrderItem.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderModifyRecordOperatorLogResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderModifyRecordOperatorLogResponse")
	public JAXBElement<GetOrderModifyRecordOperatorLogResponse> createGetOrderModifyRecordOperatorLogResponse(
			GetOrderModifyRecordOperatorLogResponse value) {
		return new JAXBElement<GetOrderModifyRecordOperatorLogResponse>(_GetOrderModifyRecordOperatorLogResponse_QNAME,
				GetOrderModifyRecordOperatorLogResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateOrderDiscountResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "updateOrderDiscountResponse")
	public JAXBElement<UpdateOrderDiscountResponse> createUpdateOrderDiscountResponse(UpdateOrderDiscountResponse value) {
		return new JAXBElement<UpdateOrderDiscountResponse>(_UpdateOrderDiscountResponse_QNAME,
				UpdateOrderDiscountResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddOrderItemResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "addOrderItemResponse")
	public JAXBElement<AddOrderItemResponse> createAddOrderItemResponse(AddOrderItemResponse value) {
		return new JAXBElement<AddOrderItemResponse>(_AddOrderItemResponse_QNAME, AddOrderItemResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CompleteOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "completeOrderResponse")
	public JAXBElement<CompleteOrderResponse> createCompleteOrderResponse(CompleteOrderResponse value) {
		return new JAXBElement<CompleteOrderResponse>(_CompleteOrderResponse_QNAME, CompleteOrderResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AddAttachmentFile }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "addAttachmentFile")
	public JAXBElement<AddAttachmentFile> createAddAttachmentFile(AddAttachmentFile value) {
		return new JAXBElement<AddAttachmentFile>(_AddAttachmentFile_QNAME, AddAttachmentFile.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderModifyRecordOperatorLogsByIdResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderModifyRecordOperatorLogsByIdResponse")
	public JAXBElement<GetOrderModifyRecordOperatorLogsByIdResponse> createGetOrderModifyRecordOperatorLogsByIdResponse(
			GetOrderModifyRecordOperatorLogsByIdResponse value) {
		return new JAXBElement<GetOrderModifyRecordOperatorLogsByIdResponse>(
				_GetOrderModifyRecordOperatorLogsByIdResponse_QNAME,
				GetOrderModifyRecordOperatorLogsByIdResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderTrackingByIdResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderTrackingByIdResponse")
	public JAXBElement<GetOrderTrackingByIdResponse> createGetOrderTrackingByIdResponse(
			GetOrderTrackingByIdResponse value) {
		return new JAXBElement<GetOrderTrackingByIdResponse>(_GetOrderTrackingByIdResponse_QNAME,
				GetOrderTrackingByIdResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ApplayOrderShelveResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "applayOrderShelveResponse")
	public JAXBElement<ApplayOrderShelveResponse> createApplayOrderShelveResponse(ApplayOrderShelveResponse value) {
		return new JAXBElement<ApplayOrderShelveResponse>(_ApplayOrderShelveResponse_QNAME,
				ApplayOrderShelveResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderCommunicationLog }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderCommunicationLog")
	public JAXBElement<GetOrderCommunicationLog> createGetOrderCommunicationLog(GetOrderCommunicationLog value) {
		return new JAXBElement<GetOrderCommunicationLog>(_GetOrderCommunicationLog_QNAME,
				GetOrderCommunicationLog.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SetOrderTrackingResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "setOrderTrackingResponse")
	public JAXBElement<SetOrderTrackingResponse> createSetOrderTrackingResponse(SetOrderTrackingResponse value) {
		return new JAXBElement<SetOrderTrackingResponse>(_SetOrderTrackingResponse_QNAME,
				SetOrderTrackingResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link DelOrderTracking }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "delOrderTracking")
	public JAXBElement<DelOrderTracking> createDelOrderTracking(DelOrderTracking value) {
		return new JAXBElement<DelOrderTracking>(_DelOrderTracking_QNAME, DelOrderTracking.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderOperatorLogResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderOperatorLogResponse")
	public JAXBElement<GetOrderOperatorLogResponse> createGetOrderOperatorLogResponse(GetOrderOperatorLogResponse value) {
		return new JAXBElement<GetOrderOperatorLogResponse>(_GetOrderOperatorLogResponse_QNAME,
				GetOrderOperatorLogResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetOrderApplayOperatorLogByIdResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osms.communication.itecheasy.com/", name = "getOrderApplayOperatorLogByIdResponse")
	public JAXBElement<GetOrderApplayOperatorLogByIdResponse> createGetOrderApplayOperatorLogByIdResponse(
			GetOrderApplayOperatorLogByIdResponse value) {
		return new JAXBElement<GetOrderApplayOperatorLogByIdResponse>(_GetOrderApplayOperatorLogByIdResponse_QNAME,
				GetOrderApplayOperatorLogByIdResponse.class, null, value);
	}

}
