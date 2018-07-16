package com.itecheasy.osms.system;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itecheasy.core.BussinessException;
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
import com.itecheasy.core.system.ShopType;
import com.itecheasy.core.system.ShopVO;
import com.itecheasy.core.system.Template;
import com.itecheasy.core.system.TemplateDetial;
import com.itecheasy.core.user.User;

/**
 * @author wanghw
 * @date 2015-3-28
 * @description TODO
 * @version 1.0
 */
@WebService
public interface SystemWebService {

	public List<Shop> getShops();

	public ShopInfo getShopInfo(@WebParam(name = "shopId") int shopId);

	public List<Shop> getShopsByUserId(@WebParam(name = "userId") int userId);

	public List<User> getUsersByShopId(@WebParam(name = "shopId") int shopId);

	public List<String> getProductTypeByshopId(@WebParam(name = "shopId") int shopId);

	public List<String> getBrowesNodeByshopId(@WebParam(name = "shopId") int shopId);

	/********************************* CMS ***************************************/
	public CMSProduct getCmsProduct(String cmsProductCode);
	public CMSProduct getCmsProductById(int cmsProductId);
	public List<CMSProduct> getCmsProducts(List<String> cmsProductCodes);

	public List<Category> getAllCategory();

	public List<Category> getRootCategory();

	public Category getCategoryById(@WebParam(name = "cateId") int cateId);

	public List<Category> getCategoryByParentId(@WebParam(name = "parentId") int parentId);

	public List<Property> getPropertyByCategoryId(@WebParam(name = "cateId") int cateId);

	public List<Property> getPropertyByCategoryIds(@WebParam(name = "cateIds") List<Integer> cateIds);

	public Property getPropertyById(@WebParam(name = "propertyId") int propertyId);

	public PropertyValue getPropertyValueById(@WebParam(name = "propertyValueId") int propertyValueId);

	public List<CategorySeries> getCategorySeriesByCategory(@WebParam(name = "categoryId") int categoryId);

	public List<Template> getTemplates();

	public List<TemplateDetial> getTemplateDetials(@WebParam(name = "templateId") int templateId);

	/********************************* 1.1 ***************************************/

	public List<Currency> getAllCurrency();

	public List<ShippingMethod> getAllShippingMethod();

	public List<Country> getAllCountrys();

	/********************************* 1.2 ***************************************/
	public void setShop2user(@WebParam(name = "user") int user, @WebParam(name = "shopIds") List<Integer> shopIds);

	public void setUser2shop(@WebParam(name = "shopId") int shopId, @WebParam(name = "userIds") List<Integer> userIds);

	public int addShop(Shop shop) throws BussinessException;

	public void setShopEnable(int shop, boolean enable) throws BussinessException;

	public List<ShopDevInfo> getAllAccount();
	
	public List<ShopDevInfo> getAllAccountByType(@WebParam(name = "shoptype")int shoptype);

	public List<ShopVO> getShopList(ShopSearchForm form);

	public void addRelations(List<ShopRelation> relations);

	public void setMerchandiserById(int shopId, String userCode) throws BussinessException;

	public List<Shop> getAvailableShops();

	public void updateShop(Shop shop) throws BussinessException;

	public Shop getShop(int shopId);

	public List<ShippingMethod> getAllShippingMethod4Amazon();
	
	public List<ShippingMethod> getAllShippingMethod4Smt();
	/********************************* 1.1.6 汇率 ***************************************/

	void setExchangeRate(List<CurrencyExchangeRate> rates);

	List<CurrencyExchangeRate> getCurrentExchangeRate(String version) throws BussinessException;

	CurrencyExchangeRate getExchangeRate(String version, int currencyId) throws BussinessException;

	BigDecimal exchangeCurrency2Other(int sourceCurrencyId, BigDecimal amount, int tagCurrencyId, String version)
			throws BussinessException;

	List<String> getShippingMethodOfFBA();

	/********************************* 1.1.7 目标业绩***************************************/
	
	/**
	 * 设置业绩目标
	 * @param salesTargets
	 */
	void setSalesTargets(List<SalesTarget> salesTargets);
	
	/**
	 * 查询业绩目标
	 * @param version <i>yyyyMM</i>
	 * @return
	 */
	List<SalesTarget> getSalesTargets(String version);
	
	/**
	 *  查询店铺业绩目标
	 * @param verion <i>yyyyMM</i>
	 * @param shopId
	 * @return
	 */
	List<SalesTarget> getSalesTargetByShopId(String verion, int[] shopId);
	
	/**
	 * 设置头程运费
	 * @param firstWayFreightSettings
	 */
	void setFirstWayFreights(List<FirstWayFreightSetting> firstWayFreightSettings);
	
	
	/**
	 * 查询头程运费
	 * @return
	 */
	List<FirstWayFreightSetting> getFirstWayFreightSettings(String version);
	
	public List<SettingReimbursePercent> getSettingReimbursePercents();
	
	public Merchandiser getMerchandiserByShopId(int shopId);
	
	List<ShopType> getShopTypes();
}
