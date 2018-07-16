package com.itecheasy.core.product;

import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;


/** 
 * @author wanghw
 * @date 2015-3-23 
 * @description 店铺商品管理
 * @version 1.0.0
 */
public interface ShopProductService {
	public final String INIT_SKU="PH0000000001";
	
	/**
	 * 商品上传状态
	 * @author wanghw
	 * @Date 2015-4-29 
	 * @Description TODO
	 */
	public enum ProductUploadStatus{
		默认待上传,已上传,待上传_上传过amazon;
	}
	
	public AMShopProduct getProductBySku(String sku,int shopId);
	
	/**
	 * 增加am 店铺销售商品
	 * <pre>
	 * 自动设置商品主副关系
	 * 如果商品已上传amazon，则自动取消商品的主副关系	
	 * </pre>
	 * @param productIds 网店商品id
	 * @param operator
	 * @return 成功添加了多少个商品
	 */
	public int addShopProducts(int[] productIds,int operator,int shopId)throws BussinessException;
	
	/**
	 * 删除店铺销售商品
	 * <p>
	 * @param shopProductIds 店铺商品ids
	 * @param operator
	 */
	public void deleteShopProduct(int[] shopProductIds,int operator)throws BussinessException;
	
	/**
	 * 分页查询店铺销售商品
	 * @param form
	 * @return
	 */
	public PageList<ShopProductVo>  findShopProducts(SearchShopProductForm form,int currentPage, int pageSize);
	
	/**
	 * 导出商品图片
	 * @param pictureCodes 图片code
	 * @param operator
	 * @return
	 */
	public List<ExportPic> exportPics(int[] productId,int operator)throws BussinessException;
	
	/**
	 * 导入商品图片
	 * <br>更新网店商品图片状态为：已完善
	 * @param ExportPics
	 * @param operator
	 */
	public String[] importPics(List<ExportPic> ExportPics,int operator);
	
	/**
	 * 导出店铺商品信息
	 * @param shopProductIds 店铺销售商品ids
	 * @param operator
	 * @return json格式数据
	 */
	public String exportShopProduct(int[] shopProductIds,int shopId,int templateId,int operator);
	
	/**
	 * 导入店铺商品信息，更新数据
	 * @param data json数据格式
	 * @param operator
	 */
	public void importShopProduct(String data,int templateId ,int operator,int shopId)throws BussinessException;
	
	/**
	 * 上架，影响json数据
	 * @param shopProductIds 店铺销售商品ids
	 * @param operator
	 */
	public void putaway(int[] shopProductIds,int operator);
	
	/**
	 * 下架，影响json数据
	 * @param shopProductIds 店铺销售商品ids
	 * @param operator
	 */
	public void off(int[] shopProductIds,int operator);
	
	/**
	 * 更新数据至amazon
	 * @param file
	 * @param operator
	 */
	public void submitAmazon(byte[] file,String[] upcs,String ext,int shopId,int operator)throws BussinessException;
	
	/**
	 * 修改amaozn商品上传日志
	 * @param sessionId
	 * @param id
	 * @param wburl
	 */
	public void addAmazonLog(String sessionId, int id, int shopId);
	
	/**
	 * 检查商品的图片是否已完成ftp上传
	 * @param productId
	 * @return
	 */
	public boolean checkPictureFTP(Integer productId);
	
	/**
	 * 分页查询失败日志
	 * @param form
	 * @return
	 */
	public PageList<uploadLog> findFailedLog(searchLogForm form,int currentPage, int pageSize);
	
	
}
