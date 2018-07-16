package com.itecheasy.osms.product;

import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.product.BaseProductCostPriceConfig;
import com.itecheasy.core.product.BaseProductCostPriceCurrency;
import com.itecheasy.core.product.Batch;
import com.itecheasy.core.product.CMSProductVo;
import com.itecheasy.core.product.ExportPic;
import com.itecheasy.core.product.OsmsStock;
import com.itecheasy.core.product.PHProductCostPriceVO;
import com.itecheasy.core.product.Product;
import com.itecheasy.core.product.ProductDevelop;
import com.itecheasy.core.product.ProductDevelopSearch;
import com.itecheasy.core.product.ProductPicture;
import com.itecheasy.core.product.ProductVo;
import com.itecheasy.core.product.SearchCMSProductForm;
import com.itecheasy.core.product.SearchProductForm;
import com.itecheasy.core.product.SearchShopProductForm;
import com.itecheasy.core.product.ShopProductVo;
import com.itecheasy.core.product.UpdateStockParam;
import com.itecheasy.core.product.searchLogForm;
import com.itecheasy.core.product.uploadLog;
import com.itecheasy.core.product.UpdateStockParam.UpdateStockHandle;

/** 
 * @author wanghw
 * @date 2015-3-27 
 * @description TODO
 * @version
 */
@WebService
public interface ProductWebService {
public PageList<CMSProductVo> findCMSProduct(
		@WebParam(name="form")SearchCMSProductForm form,
		@WebParam(name="currentPage")int currentPage,
		@WebParam(name="pageSize")int pageSize);
	
	public PageList<ProductVo> findProduct(
			@WebParam(name="form")SearchProductForm form,
			@WebParam(name="currentPage")int currentPage,
			@WebParam(name="pageSize")int pageSize);
	
	public int[] addProduct(@WebParam(name="cmsProducts")int[] cmsProducts,
			@WebParam(name="safetyStocks")int[] safetyStocks,
			@WebParam(name="operator")int operator,
			@WebParam(name="batchId")int batchId,
			@WebParam(name="batchName")String batchName,
			@WebParam(name="departmentId")int departmentId
			)throws BussinessException;
	
	public void deleteProduct(
			@WebParam(name="productIds")int[] productIds,
			@WebParam(name="operator")int operator)throws BussinessException;

	public void updateSafertyStock(
			@WebParam(name="productId")int productId,
			@WebParam(name="qty")int qty,
			@WebParam(name="operator")int operator)throws BussinessException;
	
	public void mergeProductRelation(
			@WebParam(name="productIds")int[] productIds,
			@WebParam(name="operator")int operator)throws BussinessException;
	
	public void setMainProduc(
			@WebParam(name="productId")int productId,
			@WebParam(name="operator")int operator)throws BussinessException;
	
	public void cancelProductRelation(
			@WebParam(name="productId")int productId,
			@WebParam(name="operator")int operator)throws BussinessException;
	
	
	public int addShopProducts(
			@WebParam(name="productIds")int[] productIds,
			@WebParam(name="operator")int operator,
			@WebParam(name="shopId")int shopId)throws BussinessException;
	
	
	public void deleteShopProduct(
			@WebParam(name="shopProductIds")int[] shopProductIds,
			@WebParam(name="operator")int operator)throws BussinessException;
	
	
	public PageList<ShopProductVo>  findShopProducts(
			@WebParam(name="form")SearchShopProductForm form,
			@WebParam(name="currentPage")int currentPage,
			@WebParam(name="pageSize")int pageSize);
	
	
	public List<ExportPic> exportPics(
			@WebParam(name="productId")int[] productId,
			@WebParam(name="operator")int operator)throws BussinessException;
	
	
	public String[] importPics(
			@WebParam(name="ExportPics")List<ExportPic> ExportPics,
			@WebParam(name="operator")int operator);
	
	
	public String exportShopProduct(
			@WebParam(name="shopProductIds")int[] shopProductIds,
			@WebParam(name="shopId")int shopId,
			@WebParam(name="templateId")int templateId,
			@WebParam(name="operator")int operator);
	
	
	public void importShopProduct(
			@WebParam(name="data")String data,
			@WebParam(name="templateId") int templateId,
			@WebParam(name="operator")int operator,
			@WebParam(name="shopId")int shopId)throws BussinessException;
	
	
	public void putaway(
			@WebParam(name="shopProductIds")int[] shopProductIds,
			@WebParam(name="operator")int operator);
	
	
	public void off(
			@WebParam(name="shopProductIds")int[] shopProductIds,
			@WebParam(name="operator")int operator);
	
	
	public void submitAmazon(
			@WebParam(name="file")byte[] file,
			@WebParam(name="upcs")String[] upcs,
			@WebParam(name="ext")String ext,
			@WebParam(name="shopId")int shopId,
			@WebParam(name="operator")int operator)throws BussinessException;
	
	public PageList<uploadLog> findFailedLog(
			@WebParam(name="form")searchLogForm form,
			@WebParam(name="currentPage")int currentPage,
			@WebParam(name="pageSize")int pageSize);
	
	public List<ProductPicture> getProductPictureByProduct(
			@WebParam(name="productId")int productId);
	
	public List<Batch> getBatchs(@WebParam(name="departmentId")int departmentId);
	
	public List<ProductPicture> getCMSProductPictureByProduct(
			@WebParam(name="cmsProductId")int cmsProductId);
	
	public String importOldProduct(
			@WebParam(name="departmentId")int departmentId,
			@WebParam(name="shopId")int shopId,
			@WebParam(name="jsonData")String jsonData,
			@WebParam(name="operator")int operator);
	
	public Product getProductById(int productId);
	
	PHProductCostPriceVO getPHProductCostPriceVO(List<String> productCodes,String version)throws BussinessException;
	
	void setBaseProductCostPriceConfig(List<BaseProductCostPriceConfig> configs)throws BussinessException;
	
	/**
	 * 删除商品成本配置
	 * @param id
	 */
	void deleteBaseProductCostPriceConfigById(int id);
	
	/**
	 * 删除币种，且删除币种下的所有商品成本配置
	 * @param currency
	 */
	void deleteBaseProductCostPriceConfigByCurrency(int currency);
	
	/**
	 * 查询币种下的所有商品成本配置
	 * @param currency
	 * @return
	 */
	List<BaseProductCostPriceConfig> getBaseProductCostPriceConfigs(int currency);
	
	List<BaseProductCostPriceConfig> getAllBaseProductCostPriceConfigs();
	/**
	 * 查询设置的商品成本的币种
	 * @return
	 */
	List<BaseProductCostPriceCurrency> getBaseProductCostPriceCurrencys(); 
	
	
	/**
	 * 导入产品开发记录
	 * @param productDevelops
	 * @param operator
	 */
	void addProductDevelop(@WebParam(name="productDevelops")List<ProductDevelop> productDevelops,
			@WebParam(name="operator")int operator);
	
	ProductDevelopPagelist findProductDevelop(@WebParam(name="search")ProductDevelopSearch search);
	
	ProductDevelop getProductDevelopByProduct(@WebParam(name="productCode")String productCode);
	
	List<String> getDeveloper();
	
	void statisticsSales(@WebParam(name="begin")Date begin,@WebParam(name="end")Date end);
	
	public String getStatisticsSalesLog();
	
	public void updateDepartmentalStock(@WebParam(name="stocks")List<UpdateStockParam> stocks,
			@WebParam(name="handle")UpdateStockHandle handle,@WebParam(name="operator")int operator)throws BussinessException;
	
	public List<OsmsStock> getOsmsStocks(@WebParam(name="productIds")List<Integer> productIds);
}
