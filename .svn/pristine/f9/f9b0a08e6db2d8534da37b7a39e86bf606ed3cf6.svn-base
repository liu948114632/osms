package com.itecheasy.webservice.client;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.log4j.Logger;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;

import com.itecheasy.common.Page;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.product.CMSProduct;
import com.itecheasy.core.product.CMSProductVo;
import com.itecheasy.core.product.OsmsStock;
import com.itecheasy.core.product.ProductPicture;
import com.itecheasy.core.product.ProductProperty;
import com.itecheasy.core.product.SearchCMSProductForm;
import com.itecheasy.core.system.CategorySeries;
import com.itecheasy.core.util.StaticUtils;
import com.itecheasy.webservice.cms.BusinessDepartmentStorage;
import com.itecheasy.webservice.cms.BussinessException_Exception;
import com.itecheasy.webservice.cms.Category;
import com.itecheasy.webservice.cms.CmsMessage;
import com.itecheasy.webservice.cms.ExchangeStorageType;
import com.itecheasy.webservice.cms.ExchangeTargetStorageType;
import com.itecheasy.webservice.cms.OsmsCommunicationService;
import com.itecheasy.webservice.cms.OsmsCommunicationServiceImplService;
import com.itecheasy.webservice.cms.OsmsProductDetail;
import com.itecheasy.webservice.cms.OsmsPurchasingManageTask;
import com.itecheasy.webservice.cms.OsmsStorageFreeze;
import com.itecheasy.webservice.cms.OsmsStorageTask;
import com.itecheasy.webservice.cms.PageList;
import com.itecheasy.webservice.cms.PhCategorySeries;
import com.itecheasy.webservice.cms.Property;
import com.itecheasy.webservice.cms.PropertyValue;
import com.itecheasy.webservice.cms.StorageType;
import com.itecheasy.webservice.cms.User;

/**
 * @author wanghw
 * @date 2015-3-28
 * @description cms商品接口
 * @version
 */
public class CMSClient {
	private static final String CMS异常 = "CMS异常:";
	private static OsmsCommunicationService osmsService;
	private final static Logger logger = Logger.getLogger(CMSClient.class.getName());
	private static void init(){
		URL baseUrl;
		baseUrl = com.itecheasy.webservice.cms.OsmsCommunicationServiceImplService.class.getResource(".");
		OsmsCommunicationServiceImplService service;
		try {
			service = new OsmsCommunicationServiceImplService(new URL(baseUrl, DeployProperties.getInstance()
					.getCMSURL()), new QName("http://osms.communication.itecheasy.com/",
					"OsmsCommunicationServiceImplService"));
			osmsService = service.getOsmsCommunicationServiceImplPort();
			Client client = ClientProxy.getClient(osmsService);
			Endpoint cxfEndpoint = client.getEndpoint();
			Map<String, Object> outProps = new HashMap<String, Object>();
			outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
			outProps.put(WSHandlerConstants.USER, DeployProperties.getInstance().getProperty("cms.webservice.username"));
			outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
			outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, WsClinetAuthHandler.class.getName());
			cxfEndpoint.getOutInterceptors().add(new WSS4JOutInterceptor(outProps));
			HTTPConduit http = (HTTPConduit) client.getConduit();
			HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
			httpClientPolicy.setConnectionTimeout(1000 * 60 * 5);
			httpClientPolicy.setAllowChunking(false);
			httpClientPolicy.setReceiveTimeout(1000 * 60 * 5);
			http.setClient(httpClientPolicy);
		} catch (Exception e) {
			osmsService=null;
			logger.error("Failed to create URL for the wsdl Location: '"+DeployProperties.getInstance().getCMSURL()+"', retrying as a local file");
			logger.error(e.getMessage());
			StaticUtils.addEmail("OSMS系统:CMS服务调用异常", e.getMessage()+"\r\n"+
					"Failed to create URL for the wsdl Location: '"+DeployProperties.getInstance().getCMSURL()+"', retrying as a local file");
			throw new RuntimeException(e.getMessage());
		}
	}
	
	

	public static List<com.itecheasy.core.system.Category> getAllCategory() {
		if(osmsService==null)
			init();
		List<Category> ps = osmsService.getAllCategory();
		return BeanUtils.copyList(ps, com.itecheasy.core.system.Category.class);
	}

	public static List<com.itecheasy.core.system.Category> getRootCategory() {
		if(osmsService==null)
			init();
		List<Category> ps = osmsService.getAllRootCategory();
		return BeanUtils.copyList(ps, com.itecheasy.core.system.Category.class);
	}

	public static com.itecheasy.core.system.Category getCategoryById(int cateId) {
		if(osmsService==null)
			init();
		Category ps = osmsService.getCategoryById(cateId);
		return BeanUtils.copyProperties(ps, com.itecheasy.core.system.Category.class);
	}

	public static List<com.itecheasy.core.system.Category> getCategoryByParentId(int parentId) {
		if(osmsService==null)
			init();
		List<Category> ps = osmsService.getCategoryByParentId(parentId);
		return BeanUtils.copyList(ps, com.itecheasy.core.system.Category.class);
	}

	public static List<com.itecheasy.core.system.Property> getPropertyByCategoryId(int cateId) {
		if(osmsService==null)
			init();
		List<Property> ps = osmsService.getPropertyByCategoryId(cateId);
		if (CollectionUtils.isNotEmpty(ps)) {
			List<com.itecheasy.core.system.Property> pl = new ArrayList<com.itecheasy.core.system.Property>();
			for (Property p : ps) {
				com.itecheasy.core.system.Property p2 = BeanUtils.copyProperties(p,
						com.itecheasy.core.system.Property.class, new String[] { "propertyValues" });
				p2.setPropertyValues(BeanUtils.copyList(p.getPropertyValues(),
						com.itecheasy.core.system.PropertyValue.class));
				pl.add(p2);
			}
			return pl;
		}
		return null;
	}

	public static List<com.itecheasy.core.system.Property> getPropertyByCategoryIds(List<Integer> cateIds) {
		if(osmsService==null)
			init();
		List<Property> ps = osmsService.getPropertyByCategoryIds(cateIds);
		if (CollectionUtils.isNotEmpty(ps)) {
			List<com.itecheasy.core.system.Property> pl = new ArrayList<com.itecheasy.core.system.Property>();
			for (Property p : ps) {
				com.itecheasy.core.system.Property p2 = BeanUtils.copyProperties(p,
						com.itecheasy.core.system.Property.class, new String[] { "propertyValues" });
				p2.setPropertyValues(BeanUtils.copyList(p.getPropertyValues(),
						com.itecheasy.core.system.PropertyValue.class));
				pl.add(p2);
			}
			return pl;
		}
		return null;
	}

	public static com.itecheasy.core.system.Property getPropertyById(int propertyId) {
		if(osmsService==null)
			init();
		Property p = osmsService.getPropertyById(propertyId);
		if (p != null) {
			com.itecheasy.core.system.Property p2 = BeanUtils.copyProperties(p,
					com.itecheasy.core.system.Property.class, new String[] { "propertyValues" });
			p2.setPropertyValues(BeanUtils.copyList(p.getPropertyValues(),
					com.itecheasy.core.system.PropertyValue.class));
			return p2;
		}
		return null;
	}

	public static com.itecheasy.core.system.PropertyValue getPropertyValueById(int propertyValueId) {
		if(osmsService==null)
			init();
		PropertyValue pv = osmsService.getPropertyValueById(propertyValueId);
		if (pv != null)
			return BeanUtils.copyProperties(pv, com.itecheasy.core.system.PropertyValue.class);
		return null;
	}

	public static List<OsmsStorageFreeze> getAvailableStockAndFreezeQtys(List<String> cmsProductCode) {
		if(osmsService==null)
			init();
		return osmsService.getEbayBlockedStock(cmsProductCode);
	}

	public static OsmsStorageFreeze getAvailableStockAndFreezeQty(String cmsProductCode) {
		if(osmsService==null)
			init();
		List<String> codes = new ArrayList<String>();
		codes.add(cmsProductCode);
		List<OsmsStorageFreeze> frees = osmsService.getEbayBlockedStock(codes);
		if (CollectionUtils.isNotEmpty(frees)){
			OsmsStorageFreeze free=frees.get(0);
			if(free.getAvailableQuantity()==null)
				free.setAvailableQuantity(0d);
			if(free.getRealFreezeQuantity()==null)
				free.setRealFreezeQuantity(0d);
			if(free.getShouldFreezeQuantity()==null)
				free.setShouldFreezeQuantity(0d);
			
			return free;
		}
		return null;
	}

	public static void addProduct2cms(List<Integer> productIds, int departmentId) throws BussinessException {
		try {
			if(osmsService==null)
				init();
			if (CollectionUtils.isNotEmpty(productIds)) {
				List<Integer> departmentIds =new ArrayList<Integer>();
				for (int i = 0; i < productIds.size(); i++) {
					departmentIds.add(departmentId);
				}
				osmsService.addProductToShop(productIds,departmentIds);
			}
		} catch (BussinessException_Exception e) {
			throw new BussinessException(e.getMessage());
		}
	}

	public static void deleteProduct2cms(List<Integer> productIds, int departmentId) throws BussinessException {
		try {
			if(osmsService==null)
				init();
			if (CollectionUtils.isNotEmpty(productIds)) {
				List<Integer> departmentIds =new ArrayList<Integer>();
				for (int i = 0; i < productIds.size(); i++) {
					departmentIds.add(departmentId);
				}
				osmsService.removeProductFromShop(productIds,departmentIds);
			}
		} catch (BussinessException_Exception e) {
			throw new BussinessException(e.getMessage());

		}
	}

	public static void cancelFreezeStock(String cmsProductCode,String operator) {
		try {
			if(osmsService==null)
				init();
			osmsService.cancelBlockedStock(cmsProductCode,operator);
		} catch (BussinessException_Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public static void blockedStock(String cmsProductCode, int qty,String operator) throws BussinessException {
		try {
			if(osmsService==null)
				init();
			osmsService.blockedStock(cmsProductCode, qty,operator);
		} catch (BussinessException_Exception e) {
			throw new BussinessException(e.getMessage());
		}
	}

	public static com.itecheasy.common.PageList<CMSProductVo> findCMSProduct(SearchCMSProductForm form, int pageSize,
			int currentPage) {
		if(osmsService==null)
			init();
		com.itecheasy.common.PageList<CMSProductVo> pl = new com.itecheasy.common.PageList<CMSProductVo>();
		PageList pageList = osmsService.findProducts(pageSize, currentPage, form.getCategory1(), form.getCategory2(),
				form.getCategory3(), form.getSeriesId(), form.getProperty1(), form.getProperty2(), form.getProperty3(),
				form.getProperty4(), form.getValue1(), form.getValue2(), form.getValue3(), form.getValue4(),
				form.getIsPool(), form.getIsMix(), form.getIsGift(), form.getProductCodes(), form.getProductCode(),
				form.getName(), form.getIsSmallQuantities(), form.getDepartment());

		if (pageList != null && pageList.getData() != null) {
			pl.setData(BeanUtils.copyList(pageList.getData(), CMSProductVo.class));
			pl.setPage(new Page(pageList.getPage().getTotalRowCount(), currentPage, pageSize));
		}
		return pl;
	}

	public static CMSProduct getCMSProduct(int productId) {
		if(osmsService==null)
			init();
		OsmsProductDetail de = osmsService.getOsmsProductDetailByProductId(productId);
		if (de != null) {
			CMSProduct cms = BeanUtils.copyProperties(de, CMSProduct.class, new String[] { "productPropertyValues",
					"productPictures" });
			cms.setProductTs(de.isIsTs()!=null&&de.isIsTs());
			cms.setProductPictures(BeanUtils.copyList(de.getProductPictures(), ProductPicture.class));
			cms.setProductPropertyValues(BeanUtils.copyList(de.getProductPropertyValues(), ProductProperty.class));
			return cms;
		}
		return null;
	}
	
	public static Boolean isProductTs(int productId){
		if(osmsService==null){
			init();
		}
		return osmsService.isProductTs(productId);
	}
	
	public static CMSProduct getCMSProductByCode(String productCode) {
		if(osmsService==null)
			init();
		OsmsProductDetail de = osmsService.getOsmsProductDetailByProductCode(productCode);
		if (de != null) {
			CMSProduct cms = BeanUtils.copyProperties(de, CMSProduct.class, new String[] { "productPropertyValues",
					"productPictures" });
			cms.setProductTs(de.isIsTs()!=null&&de.isIsTs());
			cms.setProductPictures(BeanUtils.copyList(de.getProductPictures(), ProductPicture.class));
			cms.setProductPropertyValues(BeanUtils.copyList(de.getProductPropertyValues(), ProductProperty.class));
			return cms;
		}
		return null;
	}
	
	public static CMSProduct getSimpleCmsProductInfo(String productCode){
		return null;
	}
	
	public static List<CMSProduct> getSimpleCmsProductInfo(List<String> productCodes){
		return null;
	}
	
	public static List<CMSProduct> getCMSProductByCodes(List<String> code){
		if(osmsService==null)
			init();
		List<OsmsProductDetail> de =osmsService.getOsmsProductDetailByCodes(code);
		if(CollectionUtils.isNotEmpty(de)){
			return BeanUtils.copyList(de, CMSProduct.class,new String[]{"productPropertyValues",
					"productPictures"});
		}
		return null;
		
	}

	public static List<CategorySeries> getCategorySeriesByCategroyId(int categoryId) {
		if(osmsService==null)
			init();
		List<PhCategorySeries> ss = osmsService.getCategorySeriesByCategroyId(categoryId);
		if (CollectionUtils.isNotEmpty(ss)) {
			return BeanUtils.copyList(ss, CategorySeries.class);
		}
		return null;
	}
	

	public static List<ProductPicture> getProductPictureByProduct(int productId){
		if(osmsService==null)
			init();
		List<com.itecheasy.webservice.cms.ProductPicture>  pics=osmsService.getProductPictureByProduct(productId);
		if (CollectionUtils.isNotEmpty(pics)) {
			return BeanUtils.copyList(pics, ProductPicture.class);
		}
		return null;
	}
	
	public static List<OsmsPurchasingManageTask> getFBAPurchasingManagementTaskByCode(String code){
		if(osmsService==null)
			init();
		return osmsService.getFBAPurchasingManagementTaskByCode(code);
	}
	
	public static User getUserByCode(String cmsUserCode){
		if(osmsService==null)
			init();
		return  osmsService.getUserByCode(cmsUserCode);
	}
	
	public static User getUserbyId(int id){
		if(osmsService==null)
			init();
		return  osmsService.getUserByID(id);
	}
	
	public static boolean isSwProduct(int productId){
		if(osmsService==null)
			init();
		return  osmsService.isProductSw(productId);
	}
	
//	public static List<OsmsPurchasingManageTask> getNotCompleteTasksByProductID(int cmsProductId){
//		if(osmsService==null){
//			init();
//		}
//		return osmsService.getNotCompleteTasksByProductID(cmsProductId);
//	}
	
	public static Map<Integer, Integer> getNotCompleteTasksByProductIDs(List<Integer> cmsProductIds){
		if(osmsService==null){
			init();
		}
		List<OsmsPurchasingManageTask> tasks= osmsService.getNotCompleteTasksByProductID(cmsProductIds);
		int num=0;
		if(CollectionUtils.isNotEmpty(tasks)){
			Map<Integer, Integer> map=new HashMap<Integer, Integer>();
			for (Integer id : cmsProductIds) {
				num=0;
				for (OsmsPurchasingManageTask t : tasks) {
					if(t.getProductId()==id.intValue())
						num+=t.getPlanQuantity();
				}
				
				map.put(id, num);
				
			}
			return map;
		}
		return null;
	}
	
	public static List<BusinessDepartmentStorage>  getBetchAllTypeStorage(List<Integer> cmsProductIds){
		if(osmsService==null)
			init();
		return osmsService.getBetchAllTypeStorage(cmsProductIds);
	}
	
	public static List<BusinessDepartmentStorage>  getBetchStorageByType(List<Integer> cmsProductIds,StorageTypeOsms type){
		if(osmsService==null)
			init();
		return osmsService.getBetchStorageByType(cmsProductIds, StorageType.fromValue(type.toString()));
	}
	
	public static Map<Integer, OsmsStock> getOsmsStocks(List<Integer> cmsProductIds){
//		网站(4), 公共库存
//		fba库存(1),
//		自卖单库存(2),
//		抢占冻结(3); ebay冻结
		Map<Integer, OsmsStock> map=new HashMap<Integer, OsmsStock>();
		List<BusinessDepartmentStorage>  bs=getBetchAllTypeStorage(cmsProductIds);
		if(bs!=null){
			for (BusinessDepartmentStorage b : bs) {
				OsmsStock o = null;
				if(!map.containsKey(b.getProductId())){
					o=new OsmsStock();
					o.setCmsProductId(b.getProductId());
					map.put(b.getProductId(), o);
				}
				o=map.get(b.getProductId());
				if(b.getType()==1){
					o.setFbaStock(o.getFbaStock().add(b.getQuantity()).subtract(b.getLockQuantity()));
				}else if(b.getType()==2){
					o.setOrderStock(o.getOrderStock().add(b.getQuantity()).subtract(b.getLockQuantity()));
				}else if(b.getType()==4){
					o.setAvailableQuantity(o.getAvailableQuantity()+(b.getQuantity()).subtract(b.getLockQuantity()).doubleValue());
				}else if(b.getType()==3){
					o.setRealFreezeQuantity(o.getRealFreezeQuantity()+(b.getQuantity()).subtract(b.getLockQuantity()).doubleValue());
				}
			}
		}
		
		return map;
	}
	
	public static void exchangeStorage(int productId, ExchangeStorageTypeOsms storageType, int qty,
			ExchangeTargetStorageTypeOsms targetStorageType, String operater) {
		if(osmsService==null){
			init();
		}
		try {
			osmsService.exchangeStorage(productId, ExchangeStorageType.fromValue(storageType.toString()), 
					qty, ExchangeTargetStorageType.fromValue(targetStorageType.toString()), operater);
		} catch (BussinessException_Exception e) {
			throw new BussinessException(CMS异常+e.getMessage());
		}
	}
	
	public enum StorageTypeOsms{
		网站(4),
		fba库存(1),
		自卖单库存(2),
		抢占冻结(3);
		private int value;
		private StorageTypeOsms(int value){
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
	}
	
	public enum ExchangeStorageTypeOsms{
		fba库存(1),
		自卖单库存(2);
		private int value;
		private ExchangeStorageTypeOsms(int value){
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
	}
	public enum ExchangeTargetStorageTypeOsms{
		fba库存(1),
		自卖单库存(2),
		共享库存(3)
		;
		private int value;
		private ExchangeTargetStorageTypeOsms(int value){
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
	}
	
	public enum OSMSStorageTaskOsms{
		WHFBA海外仓补货(13),
		WH自卖订单补货(18);
		private int value;
		private OSMSStorageTaskOsms(int value){
			this.value=value;
		}
		public int getValue() {
			return this.value;
		}
	}
	
	/**
	 * 同步消息（返回json格式数据，任务id为系统间通讯的唯一标志）
	 * {type：1,2} 1:更新状态以及任务完成数，2超批
	 * {completeQty:完成数}
	 * {taskStatus:任务状态}
	 * {excessQty:超批数量}
	 * {excessremark：超批备注}
	 * {taskRemark:任务备注}
	 * {taskId 任务id}
	 * {businessId:}
	 * {orderCode:orderCode}
	 * {pTaskIds:....}
	 * {productId:}
	 * {taskQty}
	 * {strategyDepartmentId}
	 * {taskType:3:主动备库存，1：订单任务,2：加工}
	 * @param businessDepartmentId
	 * @return
	 */
	public static List<CmsMessage> getUnDealCMSMessage(){
		if(osmsService==null)
			init();
		return osmsService.getUnDealCMSMessage();
	}
	
	public static void dealCMSMessages(List<Integer> messageIds){
			init();
		try {
			osmsService.dealCMSMessages(messageIds);
		} catch (BussinessException_Exception e) {
			logger.error(CMS异常+"消息确认失败");
			throw new BussinessException(CMS异常+"消息确认失败");
		}
	}
	
	public static int addTask(OsmsStorageTask taskType,int productId,int qty,String remark,String operater){
		if(osmsService==null)
			init();
		try {
			return osmsService.addTask(taskType, productId, qty, remark, operater);
		} catch (BussinessException_Exception e) {
			logger.error(CMS异常+e.getMessage());
			throw new BussinessException(CMS异常+e.getMessage());
		}
	}
	
	public static int reAddTask(int cmsTaskId,int qty,String remark,String operater){
		if(osmsService==null)
			init();
		try {
			return osmsService.reAssignaddTask(cmsTaskId, qty, remark, operater);
		} catch (BussinessException_Exception e) {
			logger.error(CMS异常+e.getMessage());
			throw new BussinessException(CMS异常+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
//		List<OsmsPurchasingManageTask> c=CMSClient.getFBAPurchasingManagementTaskByCode("CB161221862144");
//		System.out.println(c);
//		User u=getUserbyId(1815);
//		System.out.println(u);
		List<Integer> cmsProductIds=new ArrayList<Integer>();
		cmsProductIds.add(3573134);
		CMSClient.getOsmsStocks(cmsProductIds);
		System.out.println();
	}
}
