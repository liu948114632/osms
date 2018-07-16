package com.itecheasy.osms.system;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.order.FBAStoreOrderService;
import com.itecheasy.core.order.FirstWayFreightSetting;
import com.itecheasy.core.product.CMSProduct;
import com.itecheasy.core.system.Category;
import com.itecheasy.core.system.CategorySeries;
import com.itecheasy.core.system.Country;
import com.itecheasy.core.system.Currency;
import com.itecheasy.core.system.CurrencyExchangeRate;
import com.itecheasy.core.system.Merchandiser;
import com.itecheasy.core.system.Property;
import com.itecheasy.core.system.PropertyValue;
import com.itecheasy.core.system.SalesTarget;
import com.itecheasy.core.system.SettingReimbursePercent;
import com.itecheasy.core.system.ShippingMethod;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.ShopDevInfo;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.core.system.ShopRelation;
import com.itecheasy.core.system.ShopSearchForm;
import com.itecheasy.core.system.ShopService;
import com.itecheasy.core.system.ShopType;
import com.itecheasy.core.system.ShopVO;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.system.Template;
import com.itecheasy.core.system.TemplateDetial;
import com.itecheasy.core.user.User;
import com.itecheasy.webservice.client.CMSClient;

/**
 * @author wanghw
 * @date 2015-3-28
 * @description 
 * @version 1.0
 */
public class SystemWebServiceImpl implements SystemWebService {
	private SystemService systemService;
	private ShopService shopService;

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	@Override
	public ShopInfo getShopInfo(int shopId) {
		return systemService.getShopInfo(shopId);
	}

	@Override
	public List<Shop> getShops() {
		return systemService.getShops();
	}

	@Override
	public List<Shop> getShopsByUserId(int userId) {
		return systemService.getShopsByUserId(userId);
	}

	@Override
	public List<User> getUsersByShopId(int shopId){
		return systemService.getUsersByShopId(shopId);
	}
	
	@Override
	public List<String> getProductTypeByshopId(int shopId) {
		return systemService.getProductTypeByshopId(shopId);
	}

	@Override
	public List<String> getBrowesNodeByshopId(int shopId) {
		return systemService.getBrowesNodeByshopId(shopId);
	}

	@Override
	public CMSProduct getCmsProduct(String cmsProductCode){
		return CMSClient.getCMSProductByCode(cmsProductCode);
	}
	
	@Override
	public CMSProduct getCmsProductById(int cmsProductId) {
		return CMSClient.getCMSProduct(cmsProductId);
	}
	
	public List<CMSProduct> getCmsProducts(List<String> cmsProductCodes){
		return CMSClient.getCMSProductByCodes(cmsProductCodes);
	}
	
	@Override
	public List<Category> getAllCategory() {
		return systemService.getAllCategory();
	}

	@Override
	public List<Category> getRootCategory() {
		return systemService.getRootCategory();
	}

	@Override
	public Category getCategoryById(int cateId) {
		return systemService.getCategoryById(cateId);
	}

	@Override
	public List<Category> getCategoryByParentId(int parentId) {
		return systemService.getCategoryByParentId(parentId);
	}

	@Override
	public List<CategorySeries> getCategorySeriesByCategory(int categoryId) {
		return systemService.getCategorySeriesByCategory(categoryId);
	}

	@Override
	public List<Property> getPropertyByCategoryId(int cateId) {
		return systemService.getPropertyByCategoryId(cateId);
	}

	@Override
	public List<Property> getPropertyByCategoryIds(List<Integer> cateIds) {
		return systemService.getPropertyByCategoryIds(cateIds);
	}

	@Override
	public Property getPropertyById(int propertyId) {
		return systemService.getPropertyById(propertyId);
	}

	@Override
	public PropertyValue getPropertyValueById(int propertyValueId) {
		return systemService.getPropertyValueById(propertyValueId);
	}

	@Override
	public List<TemplateDetial> getTemplateDetials(int templateId) {
		return systemService.getTemplateDetials(templateId);
	}

	@Override
	public List<Template> getTemplates() {
		return systemService.getTemplates();
	}

	@Override
	public List<ShippingMethod> getAllShippingMethod() {
		return systemService.getAllShippingMethod();
	}

	@Override
	public List<Country> getAllCountrys() {
		return systemService.getAllCountrys();
	}

	@Override
	public List<Currency> getAllCurrency() {
		return systemService.getAllCurrency();
	}

	@Override
	public void setShop2user(int user, List<Integer> shopIds) {
		shopService.setShop2user(user, shopIds);
	}
	
	@Override
	public void setUser2shop(int shopId, List<Integer> userIds) {
		shopService.setUser2shop(shopId, userIds);
	}

	@Override
	public int addShop(Shop shop) throws BussinessException {
		return shopService.addShop(shop);
	}

	@Override
	public void setShopEnable(int shop, boolean enable) throws BussinessException {
		shopService.setShopEnable(shop, enable);
	}

	@Override
	public List<ShopDevInfo> getAllAccount() {
		return shopService.getAllAccount();
	}
	
	@Override
	public List<ShopDevInfo> getAllAccountByType(int shopType) {
		return shopService.getAllAccount(shopType);
	}

	@Override
	public List<ShopVO> getShopList(ShopSearchForm form) {
		return shopService.getShopList(form);
	}
	
	@Override
	public void setMerchandiserById(int shopId, String userCode)throws BussinessException {
		shopService.setMerchandiserById(shopId, userCode);
	}
	
	@Override
	public void addRelations(List<ShopRelation> relations) {
		shopService.addRelations(relations);
	}
	
	@Override
	public List<Shop> getAvailableShops() {
		return shopService.getAvailableShops();
	}
	
	@Override
	public void updateShop(Shop shop)throws BussinessException {
		shopService.updateShop(shop);
	}
	
	@Override
	public Shop getShop(int shopId) {
		return systemService.getShop(shopId);
	}
	
	
	@Override
	public List<ShippingMethod> getAllShippingMethod4Amazon() {
		return systemService.getAllShippingMethod4Amazon();
	}
	
	@Override
	public List<ShippingMethod> getAllShippingMethod4Smt() {
		return systemService.getAllShippingMethod4Smt();
	}

	@Override
	public void setExchangeRate(List<CurrencyExchangeRate> rates) {
		if(CollectionUtils.isNotEmpty(rates)){
			for (CurrencyExchangeRate currencyExchangeRate : rates) {
				systemService.setExchangeRate(currencyExchangeRate);
			}
		}
	}

	@Override
	public List<CurrencyExchangeRate> getCurrentExchangeRate(String version)throws BussinessException {
		return systemService.getCurrentExchangeRate(version);
	}

	@Override
	public CurrencyExchangeRate getExchangeRate(String version, int currencyId)throws BussinessException {
		return systemService.getExchangeRate(version, currencyId);
	}

	@Override
	public BigDecimal exchangeCurrency2Other(int sourceCurrencyId, BigDecimal amount, int tagCurrencyId, String version)throws BussinessException {
		if(StringUtils.isEmpty(version)){
			return systemService.exchangeCurrency2Other(sourceCurrencyId, amount, tagCurrencyId);
		}
		return systemService.exchangeCurrency2Other(sourceCurrencyId, amount, tagCurrencyId, version);
	}

	@Override
	public List<String> getShippingMethodOfFBA() {
		return systemService.getShippingMethodOfFBA();
	}

	
	@Override
	public void setSalesTargets(List<SalesTarget> salesTargets) {
		shopService.setSalesTargets(salesTargets);
	}

	@Override
	public List<SalesTarget> getSalesTargets(String version) {
		return shopService.getSalesTargets(version);
	}

	@Override
	public List<SalesTarget> getSalesTargetByShopId(String verion, int[] shopId) {
		return shopService.getSalesTargetByShopId(verion, shopId);
	}
	
	private FBAStoreOrderService fbaStoreOrderService;
	
	public void setFbaStoreOrderService(FBAStoreOrderService fbaStoreOrderService) {
		this.fbaStoreOrderService = fbaStoreOrderService;
	}

	@Override
	public void setFirstWayFreights(List<FirstWayFreightSetting> firstWayFreightSettings) {
		fbaStoreOrderService.setFirstWayFreights(firstWayFreightSettings);
	}
	
	@Override
	public List<FirstWayFreightSetting> getFirstWayFreightSettings(String version) {
		return fbaStoreOrderService.getFirstWayFreightSettings(version);
	}
	
	public List<SettingReimbursePercent> getSettingReimbursePercents(){
		return systemService.getSettingReimbursePercents();
	}
	
	@Override
	public Merchandiser getMerchandiserByShopId(int shopId) {
		ShopInfo shopInfo=systemService.getShopInfo(shopId);
		return systemService.getMerchandiserByCode(shopInfo.getMerchandiserId());
	}
	
	@Override
	public List<ShopType> getShopTypes() {
		return systemService.getShopTypes();
	}
}
