package com.itecheasy.core.product;

import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.product.UpdateStockParam.UpdateStockHandle;
import com.itecheasy.core.system.ProductRelation;

/** 
 * @author wanghw
 * @date 2015-3-23 
 * @description 网店销售商品管理
 * @version
 */
public interface ProductService {
	public final static String ERROR_PRODUCT_EXIST="本部门已添加过该商品";
	
	public Product getProduct(int productId);
	/**
	 * 分页查询CMS3库存产品
	 * @param form 查询条件
	 * @return
	 */
	public PageList<CMSProductVo> findCMSProduct(SearchCMSProductForm form,int currentPage,int pageSize);
	
	/**
	 * 分页查询网店销售产品
	 * @param form 查询条件
	 * @return
	 */
	public PageList<ProductVo> findProduct(SearchProductForm form,int currentPage,int pageSize);
	
	/**
	 * 添加网店销售商品
	 * <pre>
	 * 添加主副产品关系
	 * 添加商品安全库存，调用cms3锁库存接口
	 * 调用cms3接口添加纪录
	 * </pre>
	 * @param cmsProducts cms3商品
	 * @param operator
	 * @throws BussinessException
	 */
	public int[] addProduct(int[] cmsProducts,int[] safetyStocks,int operator,int batchId,String batchName,int departmentId)throws BussinessException;
	
	/**
	 * 删除网店销售商品
	 * <pre>
	 * 调用cms3接口移除记录
	 * 删除商品主副关系
	 * </pre>
	 * @param productIds
	 * @param operator
	 */
	public void deleteProduct(int[] productIds,int operator)throws BussinessException;
	
	/**
	 * 更新网店销售产品安全库存，同时调用cms3接口更新应锁库存
	 * <pre>
	 * 当多个部门同时锁定某一个商品的安全库存时，取各部门设置的安全库存最大值进行锁定；
	 * 安全库存的锁定需要兼容旧系统《君信通》的安全库存锁定，一样是取最大值。
	 * </pre>
	 * @param productId
	 * @param qty
	 */
	public void updateSafertyStock(int productId,int qty,int operator)throws BussinessException;
	
	/**
	 * 归并产品，添加网店销售商品主副关系，旧关系自动合并
	 * <p>
	 * 主产品采用规则选择
	 * @param productIds 网店销售商品id
	 */
	public void mergeProductRelation(int[] productIds,int operatpr)throws BussinessException;
	
	/**
	 * 将商品设置为主商品
	 * @param productId 网店销售商品id
	 */
	public void setMainProduc(int productId,int operator)throws BussinessException;
	
	/**
	 * 取消商品关联关系
	 * @param productId 网店销售商品id
	 */
	public void cancelProductRelation(int productId)throws BussinessException;
	
	/**
	 * 获取所有的批次
	 * @return
	 */
	public List<Batch> getBatchs(int departmentId); 
	
	/**
	 * 根据productId获取商品图片
	 * @param productId
	 * @return
	 */
	public List<ProductPicture> getProductPictures(int productId);
	
	/**
	 * 根据cmsproductId获取cms商品图片
	 * @param cmsProductId
	 * @return
	 */
	public List<ProductPicture> getCMSProductPictureByProduct(int cmsProductId);
	
	/**
	 * 关系对象
	 * @param productId
	 * @return
	 */
	public ProductRelation getProductRelation(int productId);
	
	/**
	 * 获取主商品的相关商品，包含自己
	 * @param productId
	 * @return
	 */
	public List<ProductRelation> getProductRelationsAndP(int productId);
	/**
	 * 获取主商品的相关商品,不包含自己
	 * @param productId
	 * @return
	 */
	public List<ProductRelation> getProductRelations(int productId);
	
	/**
	 * 获取商品的属性
	 * @param productId
	 * @return
	 */
	List<ProductProperty> getProductPropertiesByProductId(int productId);
	
	public boolean isExistProduct(String cmsProductCode,int departmentId);
	
	/**
	 * PH商品成本
	 * @param productCodes
	 * @param version 汇率版本  <code>yyyyMM</code>
	 * @return
	 */
	PHProductCostPriceVO getPHProductCostPriceVO(List<String> productCodes,String version)throws BussinessException;
	
	/**
	 * 自动取消库存冻结
	 */
	void autoCancelFreezeStock();
	
	public List<OsmsStock> getOsmsStocks(List<Integer> productIds);
	
	/**
	 * 修改部门库存
	 * @param stocks
	 * @param operator
	 * @throws BussinessException
	 * @version 1.2.8
	 */
	public void updateDepartmentalStock(List<UpdateStockParam> stocks,UpdateStockHandle handle,int operator)throws BussinessException;
}
