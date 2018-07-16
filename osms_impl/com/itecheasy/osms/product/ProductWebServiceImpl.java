package com.itecheasy.osms.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.common.sysconfig.SysConfigService;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.product.BaseProductCostPriceConfig;
import com.itecheasy.core.product.BaseProductCostPriceCurrency;
import com.itecheasy.core.product.BaseProductCostPriceService;
import com.itecheasy.core.product.Batch;
import com.itecheasy.core.product.CMSProduct;
import com.itecheasy.core.product.CMSProductVo;
import com.itecheasy.core.product.ExportPic;
import com.itecheasy.core.product.OsmsStock;
import com.itecheasy.core.product.PHProductCostPriceVO;
import com.itecheasy.core.product.Product;
import com.itecheasy.core.product.ProductDevelop;
import com.itecheasy.core.product.ProductDevelopSearch;
import com.itecheasy.core.product.ProductDevelopService;
import com.itecheasy.core.product.ProductPicture;
import com.itecheasy.core.product.ProductService;
import com.itecheasy.core.product.ProductVo;
import com.itecheasy.core.product.SearchCMSProductForm;
import com.itecheasy.core.product.SearchProductForm;
import com.itecheasy.core.product.SearchShopProductForm;
import com.itecheasy.core.product.ShopProductService;
import com.itecheasy.core.product.ShopProductVo;
import com.itecheasy.core.product.UpdateStockParam;
import com.itecheasy.core.product.searchLogForm;
import com.itecheasy.core.product.uploadLog;
import com.itecheasy.core.product.UpdateStockParam.UpdateStockHandle;
import com.itecheasy.webservice.client.CMSClient;

/**
 * @author wanghw
 * @date 2015-3-27
 * @description TODO
 * @version
 */
public class ProductWebServiceImpl implements ProductWebService {
	private ProductService productService;
	private ShopProductService shopProductService;
	private BaseProductCostPriceService baseProductCostPriceService;
	private ProductDevelopService productDevelopService;
	private SysConfigService sysConfigService;
	

	public void setSysConfigService(SysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}

	public void setProductDevelopService(ProductDevelopService productDevelopService) {
		this.productDevelopService = productDevelopService;
	}

	public void setBaseProductCostPriceService(BaseProductCostPriceService baseProductCostPriceService) {
		this.baseProductCostPriceService = baseProductCostPriceService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setShopProductService(ShopProductService shopProductService) {
		this.shopProductService = shopProductService;
	}

	@Override
	public PageList<CMSProductVo> findCMSProduct(SearchCMSProductForm form, int currentPage, int pageSize) {
		return productService.findCMSProduct(form, currentPage, pageSize);
	}

	@Override
	public PageList<ProductVo> findProduct(SearchProductForm form, int currentPage, int pageSize) {
		return productService.findProduct(form, currentPage, pageSize);
	}

	@Override
	public int[] addProduct(int[] cmsProducts, int[] safetyStocks, int operator, int batchId, String batchName,
			int departmentId) throws BussinessException {
		return productService.addProduct(cmsProducts, safetyStocks, operator, batchId, batchName, departmentId);
	}

	@Override
	public void deleteProduct(int[] productIds, int operator) throws BussinessException {
		productService.deleteProduct(productIds, operator);
	}

	@Override
	public void cancelProductRelation(int productId, int operator) throws BussinessException {
		productService.cancelProductRelation(productId);
	}

	@Override
	public void mergeProductRelation(int[] productIds, int operator) throws BussinessException {
		productService.mergeProductRelation(productIds, operator);
	}

	@Override
	public void setMainProduc(int productId, int operator) throws BussinessException {
		productService.setMainProduc(productId, operator);
	}

	@Override
	public void updateSafertyStock(int productId, int qty, int operator) throws BussinessException {
		productService.updateSafertyStock(productId, qty, operator);
	}

	@Override
	public int addShopProducts(int[] productIds, int operator, int shopId) throws BussinessException {
		return shopProductService.addShopProducts(productIds, operator, shopId);
	}

	@Override
	public void deleteShopProduct(int[] shopProductIds, int operator) throws BussinessException {
		shopProductService.deleteShopProduct(shopProductIds, operator);
	}

	@Override
	public PageList<ShopProductVo> findShopProducts(SearchShopProductForm form, int currentPage, int pageSize) {
		return shopProductService.findShopProducts(form, currentPage, pageSize);
	}

	@Override
	public List<ExportPic> exportPics(int[] productId, int operator) throws BussinessException {
		return shopProductService.exportPics(productId, operator);
	}

	@Override
	public String[] importPics(List<ExportPic> ExportPics, int operator) {
		return shopProductService.importPics(ExportPics, operator);
	}

	@Override
	public String exportShopProduct(int[] shopProductIds, int shopId, int templateId, int operator) {
		return shopProductService.exportShopProduct(shopProductIds, shopId, templateId, operator);
	}

	@Override
	public void importShopProduct(String data, int templateId, int operator, int shopId) throws BussinessException {
		shopProductService.importShopProduct(data, templateId, operator, shopId);
	}

	@Override
	public void putaway(int[] shopProductIds, int operator) {
		shopProductService.putaway(shopProductIds, operator);
	}

	@Override
	public void off(int[] shopProductIds, int operator) {
		shopProductService.off(shopProductIds, operator);
	}

	@Override
	public void submitAmazon(byte[] file, String[] upcs, String ext, int shopId, int operator)
			throws BussinessException {
		shopProductService.submitAmazon(file, upcs, ext, shopId, operator);
	}

	@Override
	public PageList<uploadLog> findFailedLog(searchLogForm form, int currentPage, int pageSize) {
		return shopProductService.findFailedLog(form, currentPage, pageSize);
	}

	@Override
	public List<ProductPicture> getProductPictureByProduct(int productId) {
		return productService.getProductPictures(productId);
	}

	@Override
	public List<Batch> getBatchs(int departmentId) {
		return productService.getBatchs(departmentId);
	}

	@Override
	public List<ProductPicture> getCMSProductPictureByProduct(int cmsProductId) {
		return productService.getCMSProductPictureByProduct(cmsProductId);
	}

	@Override
	public Product getProductById(int productId) {
		return productService.getProduct(productId);
	}

	@Override
	public String importOldProduct(int departmentId, int shopId, String jsonData, int operator) {
		// 生成product数据
		// 生成amProduct数据
		// 生成json数据

		return null;
	}

	@Override
	public PHProductCostPriceVO getPHProductCostPriceVO(List<String> productCodes, String version)
			throws BussinessException {
		return productService.getPHProductCostPriceVO(productCodes, version);
	}

	@Override
	public void setBaseProductCostPriceConfig(List<BaseProductCostPriceConfig> configs) throws BussinessException {
		baseProductCostPriceService.setBaseProductCostPriceConfig(configs);
	}

	@Override
	public void deleteBaseProductCostPriceConfigById(int id) {
		baseProductCostPriceService.deleteBaseProductCostPriceConfigById(id);
	}

	@Override
	public void deleteBaseProductCostPriceConfigByCurrency(int currency) {
		baseProductCostPriceService.deleteBaseProductCostPriceConfigByCurrency(currency);
	}

	@Override
	public List<BaseProductCostPriceConfig> getBaseProductCostPriceConfigs(int currency) {
		return baseProductCostPriceService.getBaseProductCostPriceConfigs();
	}

	@Override
	public List<BaseProductCostPriceConfig> getAllBaseProductCostPriceConfigs() {
		return baseProductCostPriceService.getAllBaseProductCostPriceConfigsAndCurrency();
	}

	@Override
	public List<BaseProductCostPriceCurrency> getBaseProductCostPriceCurrencys() {
		return baseProductCostPriceService.getBaseProductCostPriceCurrencys();
	}

	@Override
	public void addProductDevelop(List<ProductDevelop> productDevelops, int operator) {
		productDevelopService.addProductDevelop(productDevelops, operator);
	}
	@Override
	public ProductDevelopPagelist findProductDevelop(ProductDevelopSearch search) {
		ProductDevelopPagelist pl= new ProductDevelopPagelist();
		PageList<ProductDevelop>  ps=productDevelopService.findProductDevelop(search);
		if(CollectionUtils.isNotEmpty(ps.getData())){
			List<String> codes=new ArrayList<String>();
			
			for (ProductDevelop p : ps.getData()) {
				codes.add(p.getCmsProductCode());
			}
			
			 List<CMSProduct> cms= CMSClient.getCMSProductByCodes(codes);
			 if(CollectionUtils.isNotEmpty(cms)){
				 for (CMSProduct cmsProduct : cms) {
					 for (ProductDevelop p : ps.getData()) {
						if(p.getCmsProductCode().endsWith(cmsProduct.getCode())){
							p.setPrimaryPictureCode(cmsProduct.getPrimaryPictureCode());
							p.setCmsProductId(cmsProduct.getId());
							break;
						}
					}
				}
			 }
		}
		pl.setData(ps.getData());
		pl.setPage(ps.getPage());
		return pl;
	}
	@Override
	public List<String> getDeveloper() {
		return productDevelopService.getDeveloper();
	}
	@Override
	public ProductDevelop getProductDevelopByProduct(String productCode) {
		return this.productDevelopService.getProductDevelopByProduct(productCode);
	}
	
	@Override
	public void statisticsSales(Date begin,Date end) {
		productDevelopService.statisticsSales(begin,end);
	}
	
	@Override
	public String getStatisticsSalesLog() {
		return sysConfigService.getValue(ProductDevelopService.STATISTICS_SALES_LOG);
	}
	
	@Override
	public void updateDepartmentalStock(List<UpdateStockParam> stocks, UpdateStockHandle handle, int operator)
			throws BussinessException {
		productService.updateDepartmentalStock(stocks, handle, operator);
	}
	
	@Override
	public List<OsmsStock> getOsmsStocks(List<Integer> productIds) {
		return productService.getOsmsStocks(productIds);
	}
}
