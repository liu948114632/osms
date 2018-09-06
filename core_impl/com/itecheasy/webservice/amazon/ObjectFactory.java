
package com.itecheasy.webservice.amazon;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.itecheasy.webservice.amazon package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllReportUltimateResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "getAllReportUltimateResponse");
    private final static QName _CancelOrder_QNAME = new QName("http://amazon.core.itecheasy.com/", "cancelOrder");
    private final static QName _ListInboundShipmentsResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "listInboundShipmentsResponse");
    private final static QName _PutTransportContentResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "putTransportContentResponse");
    private final static QName _GetOrdersResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "getOrdersResponse");
    private final static QName _PutTransportContent_QNAME = new QName("http://amazon.core.itecheasy.com/", "putTransportContent");
    private final static QName _CancelOrderResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "cancelOrderResponse");
    private final static QName _GetReport_QNAME = new QName("http://amazon.core.itecheasy.com/", "getReport");
    private final static QName _ListInboundShipmentsByNextToken_QNAME = new QName("http://amazon.core.itecheasy.com/", "listInboundShipmentsByNextToken");
    private final static QName _ListInboundShipmentsByNextTokenResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "listInboundShipmentsByNextTokenResponse");
    private final static QName _GetResultBySessionId_QNAME = new QName("http://amazon.core.itecheasy.com/", "getResultBySessionId");
    private final static QName _GetOrderItemsResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "getOrderItemsResponse");
    private final static QName _ListInventorys_QNAME = new QName("http://amazon.core.itecheasy.com/", "listInventorys");
    private final static QName _ListInventorysByNextTokenResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "listInventorysByNextTokenResponse");
    private final static QName _ListInboundShipments_QNAME = new QName("http://amazon.core.itecheasy.com/", "listInboundShipments");
    private final static QName _GetAllReport_QNAME = new QName("http://amazon.core.itecheasy.com/", "getAllReport");
    private final static QName _UploadTraceCodeResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "uploadTraceCodeResponse");
    private final static QName _GetOrderResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "getOrderResponse");
    private final static QName _CreateInboundShipmentPlanResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "createInboundShipmentPlanResponse");
    private final static QName _UploadTraceCode_QNAME = new QName("http://amazon.core.itecheasy.com/", "uploadTraceCode");
    private final static QName _GetAmazonReport_QNAME = new QName("http://amazon.core.itecheasy.com/", "getAmazonReport");
    private final static QName _GetAllReportUltimate_QNAME = new QName("http://amazon.core.itecheasy.com/", "getAllReportUltimate");
    private final static QName _GetOrders_QNAME = new QName("http://amazon.core.itecheasy.com/", "getOrders");
    private final static QName _SubmitFeedResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "submitFeedResponse");
    private final static QName _GetOrderItems_QNAME = new QName("http://amazon.core.itecheasy.com/", "getOrderItems");
    private final static QName _GetResultBySessionIdResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "getResultBySessionIdResponse");
    private final static QName _UpdateInboundShipment_QNAME = new QName("http://amazon.core.itecheasy.com/", "updateInboundShipment");
    private final static QName _ListInventorysResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "listInventorysResponse");
    private final static QName _CreateInboundShipmentPlan_QNAME = new QName("http://amazon.core.itecheasy.com/", "createInboundShipmentPlan");
    private final static QName _GetOrder_QNAME = new QName("http://amazon.core.itecheasy.com/", "getOrder");
    private final static QName _ListInventorysByNextToken_QNAME = new QName("http://amazon.core.itecheasy.com/", "listInventorysByNextToken");
    private final static QName _GetAllReportResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "getAllReportResponse");
    private final static QName _CreateInboundShipmentResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "createInboundShipmentResponse");
    private final static QName _GetReportResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "getReportResponse");
    private final static QName _GetAmazonReportResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "getAmazonReportResponse");
    private final static QName _SubmitFeed_QNAME = new QName("http://amazon.core.itecheasy.com/", "submitFeed");
    private final static QName _UpdateInboundShipmentResponse_QNAME = new QName("http://amazon.core.itecheasy.com/", "updateInboundShipmentResponse");
    private final static QName _CreateInboundShipment_QNAME = new QName("http://amazon.core.itecheasy.com/", "createInboundShipment");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.itecheasy.webservice.amazon
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetOrdersResponse }
     * 
     */
    public GetOrdersResponse createGetOrdersResponse() {
        return new GetOrdersResponse();
    }

    /**
     * Create an instance of {@link PutTransportContent }
     * 
     */
    public PutTransportContent createPutTransportContent() {
        return new PutTransportContent();
    }

    /**
     * Create an instance of {@link CancelOrderResponse }
     * 
     */
    public CancelOrderResponse createCancelOrderResponse() {
        return new CancelOrderResponse();
    }

    /**
     * Create an instance of {@link CancelOrder }
     * 
     */
    public CancelOrder createCancelOrder() {
        return new CancelOrder();
    }

    /**
     * Create an instance of {@link GetAllReportUltimateResponse }
     * 
     */
    public GetAllReportUltimateResponse createGetAllReportUltimateResponse() {
        return new GetAllReportUltimateResponse();
    }

    /**
     * Create an instance of {@link ListInboundShipmentsResponse }
     * 
     */
    public ListInboundShipmentsResponse createListInboundShipmentsResponse() {
        return new ListInboundShipmentsResponse();
    }

    /**
     * Create an instance of {@link PutTransportContentResponse }
     * 
     */
    public PutTransportContentResponse createPutTransportContentResponse() {
        return new PutTransportContentResponse();
    }

    /**
     * Create an instance of {@link GetReport }
     * 
     */
    public GetReport createGetReport() {
        return new GetReport();
    }

    /**
     * Create an instance of {@link ListInboundShipmentsByNextToken }
     * 
     */
    public ListInboundShipmentsByNextToken createListInboundShipmentsByNextToken() {
        return new ListInboundShipmentsByNextToken();
    }

    /**
     * Create an instance of {@link ListInboundShipmentsByNextTokenResponse }
     * 
     */
    public ListInboundShipmentsByNextTokenResponse createListInboundShipmentsByNextTokenResponse() {
        return new ListInboundShipmentsByNextTokenResponse();
    }

    /**
     * Create an instance of {@link UploadTraceCodeResponse }
     * 
     */
    public UploadTraceCodeResponse createUploadTraceCodeResponse() {
        return new UploadTraceCodeResponse();
    }

    /**
     * Create an instance of {@link ListInboundShipments }
     * 
     */
    public ListInboundShipments createListInboundShipments() {
        return new ListInboundShipments();
    }

    /**
     * Create an instance of {@link GetAllReport }
     * 
     */
    public GetAllReport createGetAllReport() {
        return new GetAllReport();
    }

    /**
     * Create an instance of {@link ListInventorys }
     * 
     */
    public ListInventorys createListInventorys() {
        return new ListInventorys();
    }

    /**
     * Create an instance of {@link GetResultBySessionId }
     * 
     */
    public GetResultBySessionId createGetResultBySessionId() {
        return new GetResultBySessionId();
    }

    /**
     * Create an instance of {@link GetOrderItemsResponse }
     * 
     */
    public GetOrderItemsResponse createGetOrderItemsResponse() {
        return new GetOrderItemsResponse();
    }

    /**
     * Create an instance of {@link ListInventorysByNextTokenResponse }
     * 
     */
    public ListInventorysByNextTokenResponse createListInventorysByNextTokenResponse() {
        return new ListInventorysByNextTokenResponse();
    }

    /**
     * Create an instance of {@link UploadTraceCode }
     * 
     */
    public UploadTraceCode createUploadTraceCode() {
        return new UploadTraceCode();
    }

    /**
     * Create an instance of {@link GetAmazonReport }
     * 
     */
    public GetAmazonReport createGetAmazonReport() {
        return new GetAmazonReport();
    }

    /**
     * Create an instance of {@link GetOrderResponse }
     * 
     */
    public GetOrderResponse createGetOrderResponse() {
        return new GetOrderResponse();
    }

    /**
     * Create an instance of {@link CreateInboundShipmentPlanResponse }
     * 
     */
    public CreateInboundShipmentPlanResponse createCreateInboundShipmentPlanResponse() {
        return new CreateInboundShipmentPlanResponse();
    }

    /**
     * Create an instance of {@link GetAllReportUltimate }
     * 
     */
    public GetAllReportUltimate createGetAllReportUltimate() {
        return new GetAllReportUltimate();
    }

    /**
     * Create an instance of {@link GetOrderItems }
     * 
     */
    public GetOrderItems createGetOrderItems() {
        return new GetOrderItems();
    }

    /**
     * Create an instance of {@link GetResultBySessionIdResponse }
     * 
     */
    public GetResultBySessionIdResponse createGetResultBySessionIdResponse() {
        return new GetResultBySessionIdResponse();
    }

    /**
     * Create an instance of {@link UpdateInboundShipment }
     * 
     */
    public UpdateInboundShipment createUpdateInboundShipment() {
        return new UpdateInboundShipment();
    }

    /**
     * Create an instance of {@link GetOrders }
     * 
     */
    public GetOrders createGetOrders() {
        return new GetOrders();
    }

    /**
     * Create an instance of {@link SubmitFeedResponse }
     * 
     */
    public SubmitFeedResponse createSubmitFeedResponse() {
        return new SubmitFeedResponse();
    }

    /**
     * Create an instance of {@link ListInventorysByNextToken }
     * 
     */
    public ListInventorysByNextToken createListInventorysByNextToken() {
        return new ListInventorysByNextToken();
    }

    /**
     * Create an instance of {@link GetAllReportResponse }
     * 
     */
    public GetAllReportResponse createGetAllReportResponse() {
        return new GetAllReportResponse();
    }

    /**
     * Create an instance of {@link ListInventorysResponse }
     * 
     */
    public ListInventorysResponse createListInventorysResponse() {
        return new ListInventorysResponse();
    }

    /**
     * Create an instance of {@link CreateInboundShipmentPlan }
     * 
     */
    public CreateInboundShipmentPlan createCreateInboundShipmentPlan() {
        return new CreateInboundShipmentPlan();
    }

    /**
     * Create an instance of {@link GetOrder }
     * 
     */
    public GetOrder createGetOrder() {
        return new GetOrder();
    }

    /**
     * Create an instance of {@link SubmitFeed }
     * 
     */
    public SubmitFeed createSubmitFeed() {
        return new SubmitFeed();
    }

    /**
     * Create an instance of {@link CreateInboundShipment }
     * 
     */
    public CreateInboundShipment createCreateInboundShipment() {
        return new CreateInboundShipment();
    }

    /**
     * Create an instance of {@link UpdateInboundShipmentResponse }
     * 
     */
    public UpdateInboundShipmentResponse createUpdateInboundShipmentResponse() {
        return new UpdateInboundShipmentResponse();
    }

    /**
     * Create an instance of {@link GetReportResponse }
     * 
     */
    public GetReportResponse createGetReportResponse() {
        return new GetReportResponse();
    }

    /**
     * Create an instance of {@link CreateInboundShipmentResponse }
     * 
     */
    public CreateInboundShipmentResponse createCreateInboundShipmentResponse() {
        return new CreateInboundShipmentResponse();
    }

    /**
     * Create an instance of {@link GetAmazonReportResponse }
     * 
     */
    public GetAmazonReportResponse createGetAmazonReportResponse() {
        return new GetAmazonReportResponse();
    }

    /**
     * Create an instance of {@link InboundShipmentInfoVO }
     * 
     */
    public InboundShipmentInfoVO createInboundShipmentInfoVO() {
        return new InboundShipmentInfoVO();
    }

    /**
     * Create an instance of {@link AddressVO }
     * 
     */
    public AddressVO createAddressVO() {
        return new AddressVO();
    }

    /**
     * Create an instance of {@link BaseVO }
     * 
     */
    public BaseVO createBaseVO() {
        return new BaseVO();
    }

    /**
     * Create an instance of {@link AmazonUploadTraceTemplate }
     * 
     */
    public AmazonUploadTraceTemplate createAmazonUploadTraceTemplate() {
        return new AmazonUploadTraceTemplate();
    }

    /**
     * Create an instance of {@link ListInventorysResult }
     * 
     */
    public ListInventorysResult createListInventorysResult() {
        return new ListInventorysResult();
    }

    /**
     * Create an instance of {@link ReportConfigVO }
     * 
     */
    public ReportConfigVO createReportConfigVO() {
        return new ReportConfigVO();
    }

    /**
     * Create an instance of {@link FbaInventory }
     * 
     */
    public FbaInventory createFbaInventory() {
        return new FbaInventory();
    }

    /**
     * Create an instance of {@link ByteArrayOutputStream }
     * 
     */
    public ByteArrayOutputStream createByteArrayOutputStream() {
        return new ByteArrayOutputStream();
    }

    /**
     * Create an instance of {@link OrderItem }
     * 
     */
    public OrderItem createOrderItem() {
        return new OrderItem();
    }

    /**
     * Create an instance of {@link InboundShipmentVO }
     * 
     */
    public InboundShipmentVO createInboundShipmentVO() {
        return new InboundShipmentVO();
    }

    /**
     * Create an instance of {@link ListInboundShipmentsResultVO }
     * 
     */
    public ListInboundShipmentsResultVO createListInboundShipmentsResultVO() {
        return new ListInboundShipmentsResultVO();
    }

    /**
     * Create an instance of {@link CancelOrderBO }
     * 
     */
    public CancelOrderBO createCancelOrderBO() {
        return new CancelOrderBO();
    }

    /**
     * Create an instance of {@link AllReportUltimateVO }
     * 
     */
    public AllReportUltimateVO createAllReportUltimateVO() {
        return new AllReportUltimateVO();
    }

    /**
     * Create an instance of {@link PointsGrantedDetail }
     * 
     */
    public PointsGrantedDetail createPointsGrantedDetail() {
        return new PointsGrantedDetail();
    }

    /**
     * Create an instance of {@link RequestReportVO }
     * 
     */
    public RequestReportVO createRequestReportVO() {
        return new RequestReportVO();
    }

    /**
     * Create an instance of {@link ListOrderItemsResult }
     * 
     */
    public ListOrderItemsResult createListOrderItemsResult() {
        return new ListOrderItemsResult();
    }

    /**
     * Create an instance of {@link AmazonShipmentStatusListVO }
     * 
     */
    public AmazonShipmentStatusListVO createAmazonShipmentStatusListVO() {
        return new AmazonShipmentStatusListVO();
    }

    /**
     * Create an instance of {@link TransportContentVO }
     * 
     */
    public TransportContentVO createTransportContentVO() {
        return new TransportContentVO();
    }

    /**
     * Create an instance of {@link AmazonConfigInfo }
     * 
     */
    public AmazonConfigInfo createAmazonConfigInfo() {
        return new AmazonConfigInfo();
    }

    /**
     * Create an instance of {@link InvoiceData }
     * 
     */
    public InvoiceData createInvoiceData() {
        return new InvoiceData();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link ReportVO }
     * 
     */
    public ReportVO createReportVO() {
        return new ReportVO();
    }

    /**
     * Create an instance of {@link ListOrdersResultAmazon }
     * 
     */
    public ListOrdersResultAmazon createListOrdersResultAmazon() {
        return new ListOrdersResultAmazon();
    }

    /**
     * Create an instance of {@link Money }
     * 
     */
    public Money createMoney() {
        return new Money();
    }

    /**
     * Create an instance of {@link InboundItemVO }
     * 
     */
    public InboundItemVO createInboundItemVO() {
        return new InboundItemVO();
    }

    /**
     * Create an instance of {@link PaymentExecutionDetailItem }
     * 
     */
    public PaymentExecutionDetailItem createPaymentExecutionDetailItem() {
        return new PaymentExecutionDetailItem();
    }

    /**
     * Create an instance of {@link AmazonStockReportVO }
     * 
     */
    public AmazonStockReportVO createAmazonStockReportVO() {
        return new AmazonStockReportVO();
    }

    /**
     * Create an instance of {@link TransportDetailInputVO }
     * 
     */
    public TransportDetailInputVO createTransportDetailInputVO() {
        return new TransportDetailInputVO();
    }

    /**
     * Create an instance of {@link OrderAmazon }
     * 
     */
    public OrderAmazon createOrderAmazon() {
        return new OrderAmazon();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllReportUltimateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getAllReportUltimateResponse")
    public JAXBElement<GetAllReportUltimateResponse> createGetAllReportUltimateResponse(GetAllReportUltimateResponse value) {
        return new JAXBElement<GetAllReportUltimateResponse>(_GetAllReportUltimateResponse_QNAME, GetAllReportUltimateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "cancelOrder")
    public JAXBElement<CancelOrder> createCancelOrder(CancelOrder value) {
        return new JAXBElement<CancelOrder>(_CancelOrder_QNAME, CancelOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListInboundShipmentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "listInboundShipmentsResponse")
    public JAXBElement<ListInboundShipmentsResponse> createListInboundShipmentsResponse(ListInboundShipmentsResponse value) {
        return new JAXBElement<ListInboundShipmentsResponse>(_ListInboundShipmentsResponse_QNAME, ListInboundShipmentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutTransportContentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "putTransportContentResponse")
    public JAXBElement<PutTransportContentResponse> createPutTransportContentResponse(PutTransportContentResponse value) {
        return new JAXBElement<PutTransportContentResponse>(_PutTransportContentResponse_QNAME, PutTransportContentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrdersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getOrdersResponse")
    public JAXBElement<GetOrdersResponse> createGetOrdersResponse(GetOrdersResponse value) {
        return new JAXBElement<GetOrdersResponse>(_GetOrdersResponse_QNAME, GetOrdersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutTransportContent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "putTransportContent")
    public JAXBElement<PutTransportContent> createPutTransportContent(PutTransportContent value) {
        return new JAXBElement<PutTransportContent>(_PutTransportContent_QNAME, PutTransportContent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "cancelOrderResponse")
    public JAXBElement<CancelOrderResponse> createCancelOrderResponse(CancelOrderResponse value) {
        return new JAXBElement<CancelOrderResponse>(_CancelOrderResponse_QNAME, CancelOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getReport")
    public JAXBElement<GetReport> createGetReport(GetReport value) {
        return new JAXBElement<GetReport>(_GetReport_QNAME, GetReport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListInboundShipmentsByNextToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "listInboundShipmentsByNextToken")
    public JAXBElement<ListInboundShipmentsByNextToken> createListInboundShipmentsByNextToken(ListInboundShipmentsByNextToken value) {
        return new JAXBElement<ListInboundShipmentsByNextToken>(_ListInboundShipmentsByNextToken_QNAME, ListInboundShipmentsByNextToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListInboundShipmentsByNextTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "listInboundShipmentsByNextTokenResponse")
    public JAXBElement<ListInboundShipmentsByNextTokenResponse> createListInboundShipmentsByNextTokenResponse(ListInboundShipmentsByNextTokenResponse value) {
        return new JAXBElement<ListInboundShipmentsByNextTokenResponse>(_ListInboundShipmentsByNextTokenResponse_QNAME, ListInboundShipmentsByNextTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResultBySessionId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getResultBySessionId")
    public JAXBElement<GetResultBySessionId> createGetResultBySessionId(GetResultBySessionId value) {
        return new JAXBElement<GetResultBySessionId>(_GetResultBySessionId_QNAME, GetResultBySessionId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderItemsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getOrderItemsResponse")
    public JAXBElement<GetOrderItemsResponse> createGetOrderItemsResponse(GetOrderItemsResponse value) {
        return new JAXBElement<GetOrderItemsResponse>(_GetOrderItemsResponse_QNAME, GetOrderItemsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListInventorys }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "listInventorys")
    public JAXBElement<ListInventorys> createListInventorys(ListInventorys value) {
        return new JAXBElement<ListInventorys>(_ListInventorys_QNAME, ListInventorys.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListInventorysByNextTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "listInventorysByNextTokenResponse")
    public JAXBElement<ListInventorysByNextTokenResponse> createListInventorysByNextTokenResponse(ListInventorysByNextTokenResponse value) {
        return new JAXBElement<ListInventorysByNextTokenResponse>(_ListInventorysByNextTokenResponse_QNAME, ListInventorysByNextTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListInboundShipments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "listInboundShipments")
    public JAXBElement<ListInboundShipments> createListInboundShipments(ListInboundShipments value) {
        return new JAXBElement<ListInboundShipments>(_ListInboundShipments_QNAME, ListInboundShipments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllReport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getAllReport")
    public JAXBElement<GetAllReport> createGetAllReport(GetAllReport value) {
        return new JAXBElement<GetAllReport>(_GetAllReport_QNAME, GetAllReport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadTraceCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "uploadTraceCodeResponse")
    public JAXBElement<UploadTraceCodeResponse> createUploadTraceCodeResponse(UploadTraceCodeResponse value) {
        return new JAXBElement<UploadTraceCodeResponse>(_UploadTraceCodeResponse_QNAME, UploadTraceCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getOrderResponse")
    public JAXBElement<GetOrderResponse> createGetOrderResponse(GetOrderResponse value) {
        return new JAXBElement<GetOrderResponse>(_GetOrderResponse_QNAME, GetOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateInboundShipmentPlanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "createInboundShipmentPlanResponse")
    public JAXBElement<CreateInboundShipmentPlanResponse> createCreateInboundShipmentPlanResponse(CreateInboundShipmentPlanResponse value) {
        return new JAXBElement<CreateInboundShipmentPlanResponse>(_CreateInboundShipmentPlanResponse_QNAME, CreateInboundShipmentPlanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadTraceCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "uploadTraceCode")
    public JAXBElement<UploadTraceCode> createUploadTraceCode(UploadTraceCode value) {
        return new JAXBElement<UploadTraceCode>(_UploadTraceCode_QNAME, UploadTraceCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAmazonReport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getAmazonReport")
    public JAXBElement<GetAmazonReport> createGetAmazonReport(GetAmazonReport value) {
        return new JAXBElement<GetAmazonReport>(_GetAmazonReport_QNAME, GetAmazonReport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllReportUltimate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getAllReportUltimate")
    public JAXBElement<GetAllReportUltimate> createGetAllReportUltimate(GetAllReportUltimate value) {
        return new JAXBElement<GetAllReportUltimate>(_GetAllReportUltimate_QNAME, GetAllReportUltimate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrders }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getOrders")
    public JAXBElement<GetOrders> createGetOrders(GetOrders value) {
        return new JAXBElement<GetOrders>(_GetOrders_QNAME, GetOrders.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitFeedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "submitFeedResponse")
    public JAXBElement<SubmitFeedResponse> createSubmitFeedResponse(SubmitFeedResponse value) {
        return new JAXBElement<SubmitFeedResponse>(_SubmitFeedResponse_QNAME, SubmitFeedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderItems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getOrderItems")
    public JAXBElement<GetOrderItems> createGetOrderItems(GetOrderItems value) {
        return new JAXBElement<GetOrderItems>(_GetOrderItems_QNAME, GetOrderItems.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResultBySessionIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getResultBySessionIdResponse")
    public JAXBElement<GetResultBySessionIdResponse> createGetResultBySessionIdResponse(GetResultBySessionIdResponse value) {
        return new JAXBElement<GetResultBySessionIdResponse>(_GetResultBySessionIdResponse_QNAME, GetResultBySessionIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateInboundShipment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "updateInboundShipment")
    public JAXBElement<UpdateInboundShipment> createUpdateInboundShipment(UpdateInboundShipment value) {
        return new JAXBElement<UpdateInboundShipment>(_UpdateInboundShipment_QNAME, UpdateInboundShipment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListInventorysResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "listInventorysResponse")
    public JAXBElement<ListInventorysResponse> createListInventorysResponse(ListInventorysResponse value) {
        return new JAXBElement<ListInventorysResponse>(_ListInventorysResponse_QNAME, ListInventorysResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateInboundShipmentPlan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "createInboundShipmentPlan")
    public JAXBElement<CreateInboundShipmentPlan> createCreateInboundShipmentPlan(CreateInboundShipmentPlan value) {
        return new JAXBElement<CreateInboundShipmentPlan>(_CreateInboundShipmentPlan_QNAME, CreateInboundShipmentPlan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getOrder")
    public JAXBElement<GetOrder> createGetOrder(GetOrder value) {
        return new JAXBElement<GetOrder>(_GetOrder_QNAME, GetOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListInventorysByNextToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "listInventorysByNextToken")
    public JAXBElement<ListInventorysByNextToken> createListInventorysByNextToken(ListInventorysByNextToken value) {
        return new JAXBElement<ListInventorysByNextToken>(_ListInventorysByNextToken_QNAME, ListInventorysByNextToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllReportResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getAllReportResponse")
    public JAXBElement<GetAllReportResponse> createGetAllReportResponse(GetAllReportResponse value) {
        return new JAXBElement<GetAllReportResponse>(_GetAllReportResponse_QNAME, GetAllReportResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateInboundShipmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "createInboundShipmentResponse")
    public JAXBElement<CreateInboundShipmentResponse> createCreateInboundShipmentResponse(CreateInboundShipmentResponse value) {
        return new JAXBElement<CreateInboundShipmentResponse>(_CreateInboundShipmentResponse_QNAME, CreateInboundShipmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReportResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getReportResponse")
    public JAXBElement<GetReportResponse> createGetReportResponse(GetReportResponse value) {
        return new JAXBElement<GetReportResponse>(_GetReportResponse_QNAME, GetReportResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAmazonReportResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "getAmazonReportResponse")
    public JAXBElement<GetAmazonReportResponse> createGetAmazonReportResponse(GetAmazonReportResponse value) {
        return new JAXBElement<GetAmazonReportResponse>(_GetAmazonReportResponse_QNAME, GetAmazonReportResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitFeed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "submitFeed")
    public JAXBElement<SubmitFeed> createSubmitFeed(SubmitFeed value) {
        return new JAXBElement<SubmitFeed>(_SubmitFeed_QNAME, SubmitFeed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateInboundShipmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "updateInboundShipmentResponse")
    public JAXBElement<UpdateInboundShipmentResponse> createUpdateInboundShipmentResponse(UpdateInboundShipmentResponse value) {
        return new JAXBElement<UpdateInboundShipmentResponse>(_UpdateInboundShipmentResponse_QNAME, UpdateInboundShipmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateInboundShipment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazon.core.itecheasy.com/", name = "createInboundShipment")
    public JAXBElement<CreateInboundShipment> createCreateInboundShipment(CreateInboundShipment value) {
        return new JAXBElement<CreateInboundShipment>(_CreateInboundShipment_QNAME, CreateInboundShipment.class, null, value);
    }

}
