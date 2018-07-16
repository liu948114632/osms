package com.itecheasy.core.product;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;

import com.itecheasy.common.PageList;
import com.itecheasy.common.picture.FTPStatus;
import com.itecheasy.common.picture.FTPType;
import com.itecheasy.common.picture.FTPUploadLogDao;
import com.itecheasy.common.picture.PictureService;
import com.itecheasy.common.po.AMShopUploadFileDataPO;
import com.itecheasy.common.po.AMShopUploadFileTaskPO;
import com.itecheasy.common.po.FTPUploadLogPO;
import com.itecheasy.common.po.PictureStorePO;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.common.util.PictureUtils;
import com.itecheasy.common.util.ThreadUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.FbaShopProduct;
import com.itecheasy.core.fba.FbaShopProductService;
import com.itecheasy.core.fba.FbaShopProductService.FbaShopProductStatus;
import com.itecheasy.core.po.AMShopProductDetailPo;
import com.itecheasy.core.po.AMShopProductPo;
import com.itecheasy.core.po.AMShopUploadLogPo;
import com.itecheasy.core.po.AMUPCPO;
import com.itecheasy.core.po.ProductPictureCollectionPO;
import com.itecheasy.core.po.ProductPictureExportLogPo;
import com.itecheasy.core.po.ProductPo;
import com.itecheasy.core.po.VShopProductPo;
import com.itecheasy.core.po.VShopUploadLogPo;
import com.itecheasy.core.product.dao.AMShopProductDao;
import com.itecheasy.core.product.dao.AMShopProductDetailDao;
import com.itecheasy.core.product.dao.AMShopUploadFileDataDao;
import com.itecheasy.core.product.dao.AMShopUploadFileTaskDao;
import com.itecheasy.core.product.dao.PictureExportLogDao;
import com.itecheasy.core.product.dao.ProductDao;
import com.itecheasy.core.product.dao.ProductPictureCollectionDAO;
import com.itecheasy.core.product.dao.ShopUploadLogDao;
import com.itecheasy.core.product.dao.UPCDao;
import com.itecheasy.core.product.dao.VShopProductDao;
import com.itecheasy.core.product.dao.VShopUploadLogDao;
import com.itecheasy.core.system.ProductRelation;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.system.SystemService.LogType;
import com.itecheasy.core.system.SystemService.UploadType;
import com.itecheasy.core.system.TemplateDetial;
import com.itecheasy.webservice.client.AmazonClient;
import com.itecheasy.webservice.client.CMSClient;
import com.itecheasy.webservice.cms.OsmsStorageFreeze;

/**
 * @author wanghw
 * @date 2015-3-28
 * @desiption 店铺商品
 * @version
 */
public class ShopProductServiceImpl implements ShopProductService {
	private static final String PARENT_CHILD = "parent_child";
	private static final String CHILD = "child";
	private static final String PARENT = "parent";
	private static final Logger LOGGER = Logger.getLogger(ShopProductServiceImpl.class);

	private static final String DELETE = "Delete";
	private static final String UPDATE = "Update";
	private ProductPictureCollectionDAO productPictureCollectionDAO;
	private PictureExportLogDao pictureExportLogDao;
	private PictureService pictureService;
	private SystemService systemService;
	private FbaShopProductService fbaShopProductService;

	private ProductDao productDao;
	private ProductService productService;
	private AMShopProductDao amShopProductDao;
	private AMShopProductDetailDao amShopProductDetailDao;
	private FTPUploadLogDao ftpUploadLogDao;


	private VShopProductDao vShopProductDao;
	private UPCDao upcDao;

	private VShopUploadLogDao vShopUploadLogDao;
	private ShopUploadLogDao shopUploadLogDao;
	
	private AMShopUploadFileTaskDao amShopUploadFileTaskDao;
	private AMShopUploadFileDataDao amShopUploadFileDataDao;
	
	public void setFbaShopProductService(FbaShopProductService fbaShopProductService) {
		this.fbaShopProductService = fbaShopProductService;
	}

	public void setAmShopUploadFileTaskDao(AMShopUploadFileTaskDao amShopUploadFileTaskDao) {
		this.amShopUploadFileTaskDao = amShopUploadFileTaskDao;
	}

	public void setAmShopUploadFileDataDao(AMShopUploadFileDataDao amShopUploadFileDataDao) {
		this.amShopUploadFileDataDao = amShopUploadFileDataDao;
	}

	public void setFtpUploadLogDao(FTPUploadLogDao ftpUploadLogDao) {
		this.ftpUploadLogDao = ftpUploadLogDao;
	}

	public void setShopUploadLogDao(ShopUploadLogDao shopUploadLogDao) {
		this.shopUploadLogDao = shopUploadLogDao;
	}

	public void setAmShopProductDetailDao(AMShopProductDetailDao amShopProductDetailDao) {
		this.amShopProductDetailDao = amShopProductDetailDao;
	}

	public void setvShopUploadLogDao(VShopUploadLogDao vShopUploadLogDao) {
		this.vShopUploadLogDao = vShopUploadLogDao;
	}

	public void setvShopProductDao(VShopProductDao vShopProductDao) {
		this.vShopProductDao = vShopProductDao;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setUpcDao(UPCDao upcDao) {
		this.upcDao = upcDao;
	}

	public void setAmShopProductDao(AMShopProductDao amShopProductDao) {
		this.amShopProductDao = amShopProductDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public void setPictureExportLogDao(PictureExportLogDao pictureExportLogDao) {
		this.pictureExportLogDao = pictureExportLogDao;
	}

	public void setProductPictureCollectionDAO(ProductPictureCollectionDAO productPictureCollectionDAO) {
		this.productPictureCollectionDAO = productPictureCollectionDAO;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	@Override
	public int addShopProducts(int[] productIds, int operator, int shopId) throws BussinessException {
		int retult = 0;
		ShopInfo info = systemService.getShopInfo(shopId);
		Shop shop=systemService.getShop(shopId);
		// 判断是否为本次添加
		List<Integer> addPos = new ArrayList<Integer>();

		// 判断关联店铺 sp2
		boolean _is_need_like = false;
//		List<Integer> shopRelations = shopService.getCorrelationShop(shopId);
//		if (CollectionUtils.isNotEmpty(shopRelations)) {
//			_is_need_like = true;
//		}

		// upc
		AMUPCPO upc = null;
		for (int i = 0; i < productIds.length; i++) {
			int productId = productIds[i];
			int mainProductId = productIds[i];
			// 判断本次已添加
			if (addPos.contains(productId)) {
				continue;
			}
			// 判断
			if (hasAmshopProduct(productId, shopId) != null) {
				throw new BussinessException("该店铺已经添加过这个商品！");
			}
			String sku = getSku();
			// 从 网店商品列表中 添加商品到店铺的时候， 如果 网店商品列表中 存在关联商品，
			// 但是 只选择了 其中 1个，则默认 选择 所关联的 所有商品，一次性添加到 店铺商品列表中

			ProductRelation pr = productService.getProductRelation(productId);
			// 如果有相关商品
			if (pr != null) {
				if (pr.getMainProductId() != null) {
					mainProductId = pr.getMainProductId();
				}
				List<ProductRelation> prs = productService.getProductRelationsAndP(mainProductId);

				// 检测是否有添加的
				int j = 1;

				// 用于更新groupId
				int groupId = 0;
				List<AMShopProductPo> pos = new ArrayList<AMShopProductPo>();
				for (ProductRelation pr2 : prs) {
					// 判断该店铺是否有该商品的 相关商品信息
					AMShopProductPo amp = getShopProductByOSMSP(pr2.getProductId(), shopId);
					// and 该商品没有上传过amazon
					ProductPo ppo = productDao.getObject(pr2.getProductId());
					if (amp != null) {
						if (amp.getUploadStatus() < ProductUploadStatus.已上传.ordinal()
								&& !addPos.contains(pr2.getProductId())) {
							// 未上传则 更新sku
							String oldSku=amp.getSku();
							amp.setSku(sku + "-" + j);
							amp.setSkuEnd(String.valueOf(j));
							fbaShopProductService.replaceSku(shopId, oldSku, amp.getSku());
							j++;
							if (groupId > 0) {
								amp.setGroupId(groupId);
							}
						}
					} else {
						// 添加商品
						AMShopProductPo po = new AMShopProductPo();
						po.setProductId(pr2.getProductId());
						po.setShopId(shopId);

						// 判断该商品是否添加过以前的店铺 sp2
//						if (_is_need_like) {
//							AMShopProductPo amShopProductPo = getAmShopProductPoByProductCodeAndShop(shopRelations,
//									ppo.getCmsProductCode());
//							if (amShopProductPo != null) {
//								po.setSku(amShopProductPo.getSku());
//								setShopProduct(operator, info, ppo, po, amShopProductPo.getUpc(),shop.isNotUPC());
//							} else {
//								_is_need_like = false;
//							}
//						}
//						if (!_is_need_like) {
//							upc = this.getUPC(shop.isNotUPC());
							po.setSku(sku + "-" + j);
//							setShopProduct(operator, info, ppo, po, upc != null ? upc.getUpc() : null,shop.isNotUPC());
							setShopProduct(operator, info, ppo, po, null,shop.isNotUPC());
//						}

						po.setSkuEnd(String.valueOf(j));
						j++;

						if (groupId > 0) {
							po.setGroupId(groupId);
						}

						// 内容状态
						AMShopProductPo other = getOtherShopProductInfoByThisProductTop1(pr2.getProductId(), shopId);
						if (other != null) {
							po.setContentStatus(other.getContentStatus());
						}
						
						
						Integer shopProductId = amShopProductDao.addObject(po);
//						copyAM2Fba(po);
						
						addPos.add(pr2.getProductId());
						pos.add(po);
						retult++;

						updateUPC(_is_need_like, upc, shopProductId);

						// 更新网店商品状态为已挑选
						ppo.setStatus(true);
						productDao.mergeObject(ppo);

						// 操作记录
						systemService.addProductOperatorLog(LogType.ADD_AM_SHOP_PRODUCT.ordinal(), shopProductId,
								"新增商品" + ppo.getCmsProductCode(), operator);
					}
					// 自动生成父商品
					if (pr2.getProductId() == mainProductId) {
						groupId = addParentAMProduct(operator, shopId, info, sku, pos, pr2, ppo, null);
						for (AMShopProductPo amShopProductPo : pos) {
							amShopProductPo.setGroupId(groupId);
						}
					}
				}

			}
			// 如果没有相关商品
			else {
				AMShopProductPo mainAMsp = getShopProductByOSMSP(mainProductId, shopId);
				// and 该商品没有上传过amazon
				if (mainAMsp != null) {
					continue;
				}

				ProductPo ppo = productDao.getObject(productId);
				// 添加商品
				AMShopProductPo po = new AMShopProductPo();
				po.setProductId(mainProductId);
				po.setShopId(shopId);

				// 判断该商品是否添加过以前的店铺 sp2
//				if (_is_need_like) {
//					AMShopProductPo amShopProductPo = getAmShopProductPoByProductCodeAndShop(shopRelations,
//							ppo.getCmsProductCode());
//					if (amShopProductPo != null) {
//						po.setSku(amShopProductPo.getSku());
//						setShopProduct(operator, info, ppo, po, amShopProductPo.getUpc(),shop.isNotUPC());
//					} else {
//						_is_need_like = false;
//					}
//				}
				if (!_is_need_like) {
					upc = this.getUPC(shop.isNotUPC());
					po.setSku(sku);
					setShopProduct(operator, info, ppo, po, upc != null ? upc.getUpc() : null,shop.isNotUPC());
				}

				// 内容状态
				AMShopProductPo other = getOtherShopProductInfoByThisProductTop1(productId, shopId);
				if (other != null) {
					po.setContentStatus(other.getContentStatus());
				}

				Integer shopProductId = amShopProductDao.addObject(po);
//				copyAM2Fba(po);
				po.setGroupId(shopProductId);
				retult++;

				// 更新upc状态 sp2
				updateUPC(_is_need_like, upc, shopProductId);

				// 更新网店商品状态为已挑选
				ppo.setStatus(true);
				productDao.mergeObject(ppo);

				// 操作记录
				systemService.addProductOperatorLog(LogType.ADD_AM_SHOP_PRODUCT.ordinal(), shopProductId,
						"新增商品" + ppo.getCmsProductCode(), operator);
			}

		}
		return retult;
	}
	
	/**
	 * 产品加入对应的店铺商品管理，自动在fba商品列表产生数据，状态待确认
	 * @param am
	 * @version 1.2.2
	 */
	@Deprecated
	protected void copyAM2Fba(AMShopProductPo am){
		FbaShopProduct fba=new FbaShopProduct();
		fba.setStatus(FbaShopProductStatus.待确认.ordinal());
		fba.setCmsProductCode(am.getCmsProductCode());
		fba.setShopId(am.getShopId());
		fba.setSku(am.getSku());
		fbaShopProductService.addFbaShopProduct(fba);
	}
	

	private void updateUPC(boolean _is_need_like, AMUPCPO upc, Integer shopProductId) {
		if (!_is_need_like&&upc!=null) {
			upc.setStatus(true);
			upc.setAmShopProductId(shopProductId);
			upcDao.mergeObject(upc);
		}
	}

	protected AMShopProductPo getAmShopProductPoByProductCodeAndShop(List<Integer> shopIds, String cmsProductCode) {
		StringBuilder hql = new StringBuilder("SELECT * FROM dbo.am_shop_product "
				+ " WHERE cms_product_code=? AND shop_id IN ( ");
		List<Object> params = new ArrayList<Object>();
		params.add(cmsProductCode);
		String param = shopIds.toString();
		hql.append(param.substring(1, param.length() - 1)).append(" ) order by id desc");
		List<AMShopProductPo> pos = amShopProductDao.findListBySql(hql.toString(), params);
		if (CollectionUtils.isNotEmpty(pos)) {
			return pos.get(0);
		}
		return null;
	}

	private int addParentAMProduct(int operator, int shopId, ShopInfo info, String sku, List<AMShopProductPo> pos,
			ProductRelation pr2, ProductPo ppo, AMUPCPO upc) {
		AMShopProductPo parentPo;
		parentPo = new AMShopProductPo();
		setShopProduct(operator, info, ppo, parentPo, upc != null ? upc.getUpc() : null,true);
		parentPo.setSkuEnd("0");
		parentPo.setSku(sku);
		parentPo.setProductId(pr2.getProductId());
		parentPo.setShopId(shopId);
		parentPo.setUpc(null);
		pos.add(parentPo);
		Integer parentShopProductId = amShopProductDao.addObject(parentPo);
//		copyAM2Fba(parentPo);
		// retult++;
		// 操作记录
		systemService.addProductOperatorLog(LogType.ADD_AM_SHOP_PRODUCT.ordinal(), parentShopProductId,
				"自动增加父商品" + ppo.getCmsProductCode(), operator);
		return parentShopProductId;
	}

	private void setShopProduct(int operator, ShopInfo info, ProductPo ppo, AMShopProductPo po, String upc,boolean isNotUPC) {
//		if (upc != null&&!isNotUPC) {
//			po.setUpc(upc);
//		}
		po.setOperator(operator);
		po.setTime(DateUtils.getFullMillisecondDate());
		po.setCmsProductCode(ppo.getCmsProductCode());
		po.setUploadStatus(ProductUploadStatus.默认待上传.ordinal());
		po.setContentStatus(false);
		po.setBrandName(ppo.getLastCategoryName());
		po.setShelveStatus(true);

		// 商品名称取 同语种店铺最后更新的商品名称 sp2
		AMShopProductPo other = this.getOtherShopProductFieldByThisProductTop1(ppo.getId(), info.getShopId(),
				" order by a.product_name_last_update_time desc ");
		if (other != null) {
			po.setProductName(other.getProductName());
		} else {
			po.setProductName(ppo.getName());
		}

		// 商品描述取 同语种店铺最后更新的商品描述 sp2
		AMShopProductPo other2 = this.getOtherShopProductFieldByThisProductTop1(ppo.getId(), info.getShopId(),
				" order by a.product_content_last_update_time desc");
		if (other != null) {
			po.setProductContent(other2.getProductContent());
		} else {
			po.setProductContent(ppo.getDescription());
		}

	}

	private String getSku() {
		String hql = "from AMShopProductPo as p order by id desc";
		AMShopProductPo o = amShopProductDao.findByHql(hql);
		if (o != null) {
			String i2 = String.valueOf(o.getId() + 1);
			return "PH" + com.itecheasy.common.util.StringUtils.fillString(i2, '0', 10);
		}
		return INIT_SKU;
	}

	/**
	 * 添加店铺商品时，添加相应的 主副关系
	 */
	// private void addShopProductRe(int shopId, int productId, Integer
	// shopProductId) {
	// ProductRelation pr=productService.getProductRelation(productId);
	// //不是主产品
	// if (pr.getMainProductId()!=null) {
	// //判断该店铺是否有该商品的 相关商品信息
	// AMShopProduct mainAMsp=getShopProductByOSMSP(pr.getMainProductId(),
	// shopId);
	// // and 该商品没有上传过amazon
	// if (mainAMsp!=null&&!mainAMsp.getUploadStatus()) {
	// //判断这个店铺商品是否有关系对象
	// AMShopProductRelationPo
	// mainShopProdcutRePo=getAmShopProductRelationPo(mainAMsp.getId());
	// if (mainShopProdcutRePo==null) {
	// mainShopProdcutRePo=new AMShopProductRelationPo();
	// mainShopProdcutRePo.setMainAMShopProductId(null);
	// mainShopProdcutRePo.setAmShopProductId(mainAMsp.getId());
	// amShopProductRelationDao.addObject(mainShopProdcutRePo);
	// }
	//
	// AMShopProductRelationPo selfRePo=new AMShopProductRelationPo();
	// selfRePo.setMainAMShopProductId(mainAMsp.getId());
	// selfRePo.setAmShopProductId(shopProductId);
	// amShopProductRelationDao.addObject(selfRePo);
	// }
	// }
	// //是主产品
	// else{
	// List<ProductRelation> prs=productService.getProductRelations(productId);
	// if (CollectionUtils.isNotEmpty(prs)) {
	//
	// AMShopProductRelationPo selfRePo=new AMShopProductRelationPo();
	// selfRePo.setMainAMShopProductId(null);
	// selfRePo.setAmShopProductId(shopProductId);
	// amShopProductRelationDao.addObject(selfRePo);
	//
	// for (ProductRelation pr2 : prs) {
	// AMShopProduct childAMsp=getShopProductByOSMSP(pr2.getProductId(),
	// shopId);
	// if (childAMsp!=null&&!childAMsp.getUploadStatus()) {
	// //判断这个店铺商品是否有关系对象
	// AMShopProductRelationPo
	// childAMpro=getAmShopProductRelationPo(childAMsp.getId());
	// if (childAMpro==null) {
	// childAMpro=new AMShopProductRelationPo();
	// childAMpro.setMainAMShopProductId(shopProductId);
	// childAMpro.setAmShopProductId(childAMsp.getId());
	// amShopProductRelationDao.addObject(childAMpro);
	// }
	// }
	//
	// }
	// }
	// }
	// }

	// private AMShopProductRelationPo getAmShopProductRelationPo(int
	// shopProductId){
	// String hql="from AMShopProductRelationPo where amShopProductId=? " ;
	// return amShopProductRelationDao.findByHql(hql, shopProductId);
	// }

	/**
	 * 查看网店商品在店铺是否存在
	 * 
	 * @param product
	 * @param shopId
	 */
	private AMShopProductPo getShopProductByOSMSP(int product, int shopId) {
		String hql = "from AMShopProductPo where productId=? and shopId=?";
		AMShopProductPo po = amShopProductDao.findByHql(hql, new Object[] { product, shopId });
		return po;
	}

	/**
	 * 获取所有网店商品相关的店铺商品
	 * 
	 * @param product
	 * @return
	 */
	private List<AMShopProductPo> getShopProductByOSMSP(int product) {
		String hql = "from AMShopProductPo where productId=? ";
		List<AMShopProductPo> pos = amShopProductDao.findListByHql(hql, new Object[] { product });
		return pos;
	}

	/**
	 * 查看这个 网店销售商品 在其他 同语种店铺的信息
	 * 
	 * @param productId
	 * @param shopId
	 * @return
	 */
	private List<AMShopProductPo> getOtherShopProductInfoByThisProduct(int productId, int shopId) {
		String hql = "select a.* from am_shop_product a " + " inner join shop_info s on a.shop_id=s.shop_id "
				+ " inner join shop_info s2 on s.language= s2.language "
				+ " where s2.shop_id=? and a.product_id=? AND a.shop_id<>? ";
		List<Object> params = new ArrayList<Object>();
		params.add(shopId);
		params.add(productId);
		params.add(shopId);

		return amShopProductDao.findListBySql(hql, params);

	}

	private AMShopProductPo getOtherShopProductFieldByThisProductTop1(int productId, int shopId, String orderBy) {
		String hql = "select a.* from am_shop_product a " + " inner join shop_info s on a.shop_id=s.shop_id "
				+ " inner join shop_info s2 on s.language= s2.language "
				+ " where s2.shop_id=? and a.product_id=? AND a.shop_id<>? " + orderBy;
		List<Object> params = new ArrayList<Object>();
		params.add(shopId);
		params.add(productId);
		params.add(shopId);

		List<AMShopProductPo> pos = amShopProductDao.findListBySql(hql, params);
		if (CollectionUtils.isNotEmpty(pos))
			return pos.get(0);
		return null;

	}

	private AMShopProductPo getOtherShopProductInfoByThisProductTop1(int productId, int shopId) {
		List<AMShopProductPo> pos = getOtherShopProductInfoByThisProduct(productId, shopId);
		if (CollectionUtils.isNotEmpty(pos))
			return pos.get(0);
		return null;
	}

	/**
	 * 获取可用的UPC码
	 * 
	 * @return
	 */
	private AMUPCPO getUPC(boolean notUPC) throws BussinessException {
		if (notUPC) {
			return null;
		}
		String hql = "from AMUPCPO where status=false";
		List<AMUPCPO> pos = upcDao.findListByHql(hql);
		if (CollectionUtils.isNotEmpty(pos))
			return pos.get(0);
		throw new BussinessException("UPC已经用完了！");
	}

	private AMShopProductPo hasAmshopProduct(int productId, int shopId) {
		String hql = "from AMShopProductPo where shopId=? and productId=?";
		return amShopProductDao.findByHql(hql, new Object[] { shopId, productId });
	}

	private AMUPCPO getAmupcpo(String upc, int shopProductId) {
		String hql = "from AMUPCPO where upc=? and amShopProductId=? and status=true";
		return upcDao.findByHql(hql, new Object[] { upc, shopProductId });
	}

	private AMShopProduct getShopProduct(int shopProductId) {
		AMShopProductPo po = amShopProductDao.getObject(shopProductId);
		if (po != null) {
			return BeanUtils.copyProperties(po, AMShopProduct.class);
		}
		return null;
	}

	@Override
	public void deleteShopProduct(int[] shopProductIds, int operator) throws BussinessException {
		for (int i = 0; i < shopProductIds.length; i++) {
			int shopProductId = shopProductIds[i];
			AMShopProduct ap = this.getShopProduct(shopProductId);
			if (ap == null) {
				continue;
			}
			List<AMShopProductPo> pos = this.getShopProductGroup(ap.getGroupId());
			for (AMShopProductPo po : pos) {
				Integer productId = po.getProductId();

				if (po.getUploadStatus() != ProductUploadStatus.默认待上传.ordinal()) {
					throw new BussinessException("相关商品中有已上传到amazon中，只有从来没有上传到amazon的商品才允许删除！");
				}
				// 删除json
				AMShopProductDetailPo detail = getAmShopProductDetailPo(shopProductId);
				if (detail != null) {
					amShopProductDetailDao.deleteObject(detail);
				}

				amShopProductDao.deleteObject(po);

				// 回收upc
				List<AMShopProductPo> amShopProductPos = this.getShopProductByUPC(po.getUpc());
				AMUPCPO amupcpo = getAmupcpo(po.getUpc(), po.getId());
				if (amupcpo != null) {
					if (CollectionUtils.isEmpty(amShopProductPos)) {
						amupcpo.setStatus(false);
						amupcpo.setAmShopProductId(null);
						upcDao.mergeObject(amupcpo);
					} else {
						amupcpo.setAmShopProductId(amShopProductPos.get(0).getId());
						upcDao.mergeObject(amupcpo);
					}
				}

				// 修改状态对应的网店商品挑选状态
				if (CollectionUtils.isEmpty(this.getAMShopProductByProductId(productId))) {
					ProductPo ppo = productDao.getObject(productId);
					if (ppo != null) {
						ppo.setStatus(false);
					}
				}
			}
			// 操作日志
			systemService.addProductOperatorLog(LogType.DELETE_AM_SHOP_PRODUCT.ordinal(), shopProductId, "删除店铺销售商品",
					operator);
		}
	}

	private List<AMShopProductPo> getAMShopProductByProductId(int productId) {
		String hql = "from  AMShopProductPo where productId=?";
		return amShopProductDao.findListByHql(hql, productId);
	}

	private AMShopProductDetailPo getAmShopProductDetailPo(int shopProductId) {
		String hql = "from AMShopProductDetailPo where amShopProductId=?";
		return amShopProductDetailDao.findByHql(hql, shopProductId);
	}

	@Override
	public PageList<ShopProductVo> findShopProducts(SearchShopProductForm form, int currentPage, int pageSize) {
		String sql = " SELECT * FROM dbo.v_shop_product_info ";
		StringBuilder where = new StringBuilder();

		List<Object> params = new ArrayList<Object>();
		boolean lose = false;
		if (StringUtils.isNotEmpty(form.getProductCode())) {
			where.append(" and cms_product_code like ? ");
			params.add("%" + form.getProductCode() + "%");
			lose = true;
		}
		if (CollectionUtils.isNotEmpty(form.getProductCodes())) {
			where.append(" and cms_product_code  in (");
			for (String productCode : form.getProductCodes()) {
				where.append("'").append(productCode).append("',");
			}
			where.append("'') ");
			lose = true;
		}
		if (!lose) {
			if (StringUtils.isNotEmpty(form.getSku())) {
				where.append(" and sku LIKE ? ");
				params.add("%" + form.getSku() + "%");
			}
			if (StringUtils.isNotEmpty(form.getBrowseNode())) {
				where.append(" and browse_node LIKE ? ");
				params.add("%" + form.getBrowseNode() + "%");
			}
			if (StringUtils.isNotEmpty(form.getProductName())) {
				where.append(" and product_name LIKE ? ");
				params.add("%" + form.getProductName() + "%");
			}
			if (form.getPictureStatus() > -1) {
				where.append(" AND picture_status=? ");
				params.add(form.getPictureStatus());
			}
			if (StringUtils.isNotEmpty(form.getProductType())) {
				where.append(" AND product_type=? ");
				params.add(form.getProductType());
			}
			if (form.getShelveStatus() > -1) {
				where.append(" AND shelve_status=? ");
				params.add(form.getShelveStatus());
			}
			if (form.getUploadStatus() > -1) {
				if (form.getUploadStatus() == 0) {
					where.append(" AND upload_status<>1 ");
				} else {
					where.append(" AND upload_status=1 ");
				}
			}
			if (form.getContextStatus() > -1) {
				where.append(" AND content_status=? ");
				params.add(form.getContextStatus());
			}
			if (form.getBatchId() > 0) {
				where.append(" AND batch_id=? ");
				params.add(form.getBatchId());
			}
		}
		if (form.getShopId() > 0) {
			where.append(" AND shop_id=? ");
			params.add(form.getShopId());
		}
		PageList<VShopProductPo> ps = vShopProductDao.findPageListBySql(currentPage, pageSize, sql, where.toString(),
				" group_id DESC ,sku_end ASC ", params);

		PageList<ShopProductVo> pl = new PageList<ShopProductVo>();
		pl.setPage(ps.getPage());
		if (CollectionUtils.isNotEmpty(ps.getData())) {
			pl.setData(BeanUtils.copyList(ps.getData(), ShopProductVo.class));

			List<String> cmsProductCode = new ArrayList<String>();
			for (ShopProductVo vo : pl.getData()) {
				cmsProductCode.add(vo.getCmsProductCode());
			}
			List<OsmsStorageFreeze> frees = CMSClient.getAvailableStockAndFreezeQtys(cmsProductCode);

			for (OsmsStorageFreeze free : frees) {
				if(free.getRealFreezeQuantity()!=null)
				for (ShopProductVo vo : pl.getData()) {
					if (vo.getCmsProductCode().equals(free.getProductCode())) {
						vo.setFreezeQty(free.getRealFreezeQuantity().intValue());
					}
				}

			}
		}
		return pl;
	}

	@Override
	public List<ExportPic> exportPics(int[] productIds, int operator) throws BussinessException {
		Date d = DateUtils.getFullMillisecondDate();
		List<ExportPic> pics = new ArrayList<ExportPic>();
		List<ProductPictureExportLogPo> ppos = new ArrayList<ProductPictureExportLogPo>();
		for (int i = 0; i < productIds.length; i++) {
			List<ProductPicture> pos = productService.getProductPictures(productIds[i]);
			if (CollectionUtils.isNotEmpty(pos)) {
				int len = pos.size() > 3 ? 3 : pos.size();
				for (int j = 0; j < len; j++) {
					ProductPicture pp = pos.get(j);
					ExportPic pic = new ExportPic();
					String ext = FilenameUtils.getExtension(pp.getPictureName());

					StringBuilder sb = new StringBuilder("[");
					sb.append(pp.getCmsProductCode()).append("]-").append(pp.getOrderIndex().intValue());
					sb.append(".").append(ext);

					pic.setExportName(sb.toString());
					pic.setProdcutId(productIds[i]);

					try {
						File f = pictureService.getPictureFile(pp.getPictureCode());
						if (f != null) {
							pic.setPic(FileUtils.readFileToByteArray(f));
						}
					} catch (IOException e) {
						throw new BussinessException("图片读取失败!");
					}
					if (!pics.contains(pic)) {
						pics.add(pic);
					}

					ProductPictureExportLogPo ppo = new ProductPictureExportLogPo();
					ppo.setCmsProductCode(pp.getCmsProductCode());
					ppo.setExportName(sb.toString());
					ppo.setExportTime(d);
					ppo.setImageCode(pp.getPictureCode());
					ppo.setOperator(operator);
					ppo.setIsImport(false);

					ppos.add(ppo);
				}
			}
		}
		pictureExportLogDao.addObject(ppos);
		// 记录操作日志
		systemService.addProductOperatorLog(LogType.EXPORT_PICTURE.ordinal(), null,
				"导出了id为" + ArrayUtils.toString(productIds) + " 的商品图片！", operator);
		return pics;
	}

	private List<ProductPictureCollectionPO> getPictureCollectionPO(String cmsProductCode, int indexId) {
		String hql = "from ProductPictureCollectionPO where cmsProductCode=? and orderIndex=?";
		return productPictureCollectionDAO.findListByHql(hql, new Object[] { cmsProductCode, indexId });
	}

	@Override
	public String[] importPics(List<ExportPic> ExportPics, int operator) {
		if (CollectionUtils.isEmpty(ExportPics)) {
			return null;
		}
		int fail = 0;
		List<String> ids = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		// String hql="from ProductPictureExportLogPo where exportName=?";
		for (ExportPic pic : ExportPics) {
			// ProductPictureExportLogPo logPo=
			// pictureExportLogDao.findByHql(hql, pic.getExportName());
			String s = pic.getExportName();
			List<ProductPictureCollectionPO> pos = null;
			try {
				if (s.contains(".") && s.contains("[") && s.contains("]") && s.lastIndexOf(".") > s.lastIndexOf("]")) {
					pos = getPictureCollectionPO(s.substring(s.indexOf("[") + 1, s.lastIndexOf("]")),
							Integer.valueOf(s.substring(s.lastIndexOf("-") + 1, s.lastIndexOf("."))));
				} else {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				sb.append(pic.getExportName()).append(" 更新失败，原因 :图片名称匹配失败！\r\n");
				fail++;
				continue;
			}

			if (CollectionUtils.isEmpty(pos)) {
				fail++;
				sb.append(pic.getExportName()).append(" 更新失败，原因 :图片名称匹配失败！\r\n");
				continue;
			}

			// 更新图片----------
			for (ProductPictureCollectionPO coll : pos) {
				if (!ids.contains(coll.getCmsProductCode()))
					ids.add(coll.getCmsProductCode());
				// 1、删除图片
				pictureService.deletePicture(coll.getPictureCode());

				// 2、添加图片
				String oldCode = coll.getPictureCode();
				String pictureCode = pictureService.addPicture("product", String.valueOf(coll.getProductId()), null,
						coll.getPictureName(), PictureUtils.createTempFile(pic.getPic(), pic.getExportName()));
				coll.setPictureCode(pictureCode);
				int p = coll.getPictureName().lastIndexOf(".");
				String ext = coll.getPictureName().substring(p + 1);
				coll.setPictureName(pictureCode + "." + ext);

				// 3、修改商品的图片状态：已完善
				ProductPo po = productDao.getObject(coll.getProductId());
				po.setPictureStatus(true);
				if (coll.getType() == 1) {
					// 更新冗余主图code
					po.setPrimaryPictureCode(pictureCode);
				}

				// 4、操作记录
				systemService.addProductOperatorLog(LogType.UPDATE_PICTURE.ordinal(), coll.getProductId(), "更新商品"
						+ coll.getCmsProductCode() + "的图片" + oldCode + "为" + pictureCode, operator);
				productDao.mergeObject(po);
				productPictureCollectionDAO.mergeObject(coll);

				// 5、更新图片引用
				List<AMShopProductPo> ams = getShopProductByOSMSP(coll.getProductId());
				if (CollectionUtils.isNotEmpty(ams)) {
					String _key = null;
					if (coll.getType() == 1) {
						_key = "main_image_url";
					} else if (coll.getType() != 1 && coll.getOrderIndex() == 2) {
						_key = "other_image_url1";
					} else if (coll.getType() != 1 && coll.getOrderIndex() == 3) {
						_key = "other_image_url2";
					} else {
						continue;
					}

					for (AMShopProductPo amShopProductPo : ams) {
						AMShopProductDetailPo detail = getAmShopProductDetailPo(amShopProductPo.getId());
						if (detail != null) {
							JSONObject jo = JSONObject.fromObject(detail.getValue());
							if (StringUtils.isNotEmpty(_key)) {
								if(jo.containsKey(_key)){
									String oldValue = jo.getString(_key);
									if (StringUtils.isEmpty(oldValue)) {
										continue;
									}
									int _index = oldValue.lastIndexOf("/");
									String _url = oldValue.substring(0, _index + 1);
									jo.put(_key, _url + coll.getPictureName());
								}
								detail.setValue(jo.toString());
								amShopProductDetailDao.mergeObject(detail);
							}
						}
					}
				}
			}

		}
		if (fail > 0) {
			return new String[] { "更新失败\r\n共更新" + ids.size() + "个商品，" + ExportPics.size() + "张图片，" + fail + "张图片更新失败!",
					sb.toString() };
		}
		return new String[] { "更新成功\r\n共更新" + ids.size() + "个商品，" + ExportPics.size() + "张图片", "" };
	}

	@Override
	public String exportShopProduct(int[] shopProductIds, int shopId, int templateId, int operator) {
		List<JSONObject> jss = new ArrayList<JSONObject>();
		ShopInfo si = systemService.getShopInfo(shopId);
		for (int i = 0; i < shopProductIds.length; i++) {
			// 导出相关商品？？？？
			int shopProductId = shopProductIds[i];
			AMShopProductDetailPo po = getDetailByShopProduct(shopProductId);
			if (po == null) {
				// 初始化值
				List<TemplateDetial> tds = systemService.getTemplateDetials(templateId);
				VShopProductPo vp = getVShopProduct(shopProductId);
				List<ProductProperty> propertys = productService.getProductPropertiesByProductId(vp.getProductId());
				List<ProductPicture> pics = productService.getProductPictures(vp.getProductId());
				if (CollectionUtils.isNotEmpty(tds) && vp != null) {
					JSONObject jo = new JSONObject();
					for (TemplateDetial td : tds) {
						jo.put(td.getColumnName(), getInitColumnValue(td.getColumnName(), vp, si, propertys, pics));
					}
					jss.add(jo);
					po = new AMShopProductDetailPo();
					po.setAmShopProductId(shopProductId);
					po.setOperator(operator);
					po.setTemplate(templateId);
					po.setTime(new Date());
					po.setValue(jo.toString());
					amShopProductDetailDao.addObject(po);
				}
			} else {
				jss.add(JSONObject.fromObject(po.getValue()));
			}
		}
		return JSONArray.fromObject(jss).toString();
	}

	private VShopProductPo getVShopProduct(int shopProductId) {
		String hql = "from VShopProductPo where id=? ";
		return vShopProductDao.findByHql(hql, shopProductId);
	}

	private AMShopProductDetailPo getDetailByShopProduct(int shopProductId) {
		String hql = "from AMShopProductDetailPo where amShopProductId=?";
		return amShopProductDetailDao.findByHql(hql, shopProductId);
	}

	private String getPictureUrl(String pictureCode) {
		PictureStorePO po = pictureService.getPictureInfo(pictureCode);
		if (po != null) {
			StringBuffer sb = new StringBuffer("/");
			sb.append(po.getModelType()).append("/").append(po.getModelId()).append("/").append(po.getPictureName());
			return sb.toString();
		}
		return null;
	}

	private String getInitColumnValue(String column, VShopProductPo vp, ShopInfo si, List<ProductProperty> values,
			List<ProductPicture> pics) {
		if ("item_sku".equalsIgnoreCase(column)) {
			// 子商品
			return vp.getSku();
		}
		if ("item_name".equalsIgnoreCase(column)) {
			return vp.getProductName();
		}
		if ("external_product_id_type".equalsIgnoreCase(column)) {
			return "upc";
		}
		if ("brand_name".equalsIgnoreCase(column)) {
			return vp.getBrandName();
		}
		if ("manufacturer".equalsIgnoreCase(column)) {
			return "PandaHall";
		}
		if ("product_description".equalsIgnoreCase(column)) {
			return vp.getProductContent();
		}
		if (PARENT_CHILD.equalsIgnoreCase(column)) {
			if (StringUtils.isEmpty(vp.getSkuEnd())) {
				return "";
			} else if ("0".equals(vp.getSkuEnd())) {
				return PARENT;
			} else {
				return CHILD;
			}
		}

		if ("main_image_url".equalsIgnoreCase(column)) {
			if (CollectionUtils.isNotEmpty(pics)) {
				for (int i = 0; i < pics.size(); i++) {
					if (pics.get(i).getType() == 1) {
						return DeployProperties.getInstance().getExcelPictureUrl()
								+ getPictureUrl(pics.get(i).getPictureCode());
					}
				}
			}
		}

		// 虚拟父商品不需要导出的值
		if (!"0".equals(vp.getSkuEnd())) {
			if ("fulfillment_latency".equalsIgnoreCase(column)) {
				return "4";
			}

			// 无父子关系商品不导出
			if (StringUtils.isNotEmpty(vp.getSkuEnd())) {
				if ("variation_theme".equalsIgnoreCase(column)) {
					return "ColorName";
				}

				if ("relationship_type".equalsIgnoreCase(column)) {
					return "Variation";
				}
			}

			if ("quantity".equalsIgnoreCase(column)) {
				OsmsStorageFreeze free = CMSClient.getAvailableStockAndFreezeQty(vp.getCmsProductCode());
				if (free != null) {
					Double qty = free.getAvailableQuantity() == null ? 0 : (free.getAvailableQuantity() - free
							.getRealFreezeQuantity()) / 2 / vp.getUnitQuantity();
					Double shouldQty = free.getRealFreezeQuantity() / vp.getUnitQuantity();
					Double result = (qty).compareTo(shouldQty) > 0 ? qty : shouldQty;

					return new BigDecimal(result).setScale(0, BigDecimal.ROUND_DOWN).toString();
				}
				return "0";
			}
			if ("generic_keywords1".equalsIgnoreCase(column)) {
				if (vp.getProductName().contains(",")) {
					return vp.getProductName().split(",")[0];
				}
			}
			if ("external_product_id".equalsIgnoreCase(column)) {
				return vp.getUpc();
			}
			if ("part_number".equalsIgnoreCase(column) || "model".equalsIgnoreCase(column)) {
				return "wh-"+vp.getCmsProductCode();
			}
			
			
			if ("update_delete".equalsIgnoreCase(column)) {
				if (vp.getShelveStatus() == null || !vp.getShelveStatus()) {
					return DELETE;
				}
				return UPDATE;
			}
			if ("product_site_launch_date".equalsIgnoreCase(column)) {
				return DateUtils.convertDate(DateUtils.getFullMillisecondDate(), "yyyy-MM-dd");
			}
			if ("standard_price".equalsIgnoreCase(column)) {
				// （PH售价*1.3 + 向上取整数(重量 / 50) * 2 ）/ 0.85
				return (vp.getPhPrice().multiply(new BigDecimal(1.3)))
						.add(new BigDecimal(vp.getWeight()).divide(new BigDecimal(50), 0, BigDecimal.ROUND_UP)
								.multiply(new BigDecimal(2))).divide(new BigDecimal(0.85), 2, 4).toString();
			}
			if ("currency".equalsIgnoreCase(column)) {
				return si.getCurrency();
			}

			if ("condition_type".equalsIgnoreCase(column)) {
				return "New";
			}
			if ("website_shipping_weight".equalsIgnoreCase(column)) {
				return new BigDecimal(vp.getWeight()).multiply(new BigDecimal(vp.getUnitQuantity()))
						.divide(new BigDecimal(1000)).setScale(2, 4).toString();
			}
			if ("website_shipping_weight_unit_of_measure".equalsIgnoreCase(column)) {
				return "KG";
			}
			if ("recommended_browse_nodes1".equalsIgnoreCase(column)) {
				return "3063572031";
			}
			if ("recommended_browse_nodes2".equalsIgnoreCase(column)) {
				return "364051031";
			}

			if ("generic_keywords2".equalsIgnoreCase(column)) {
				String[] result = vp.getProductName().split(",");
				if (result.length > 2)
					return result[2];
			}
			if ("generic_keywords3".equalsIgnoreCase(column)) {
				return vp.getBrandName();
			}

			if ("parent_sku".equalsIgnoreCase(column)) {
				if (StringUtils.isNotEmpty(vp.getSkuEnd()) && !"0".equals(vp.getSkuEnd())) {
					return getParentSku(vp.getId());
				}
			}

			if ("country_string".equalsIgnoreCase(column)) {
				return "China";
			}
			if ("bullet_point1".equalsIgnoreCase(column)) {
				if (CollectionUtils.isNotEmpty(values)) {
					for (ProductProperty va : values) {
						if ("Material".equalsIgnoreCase(va.getPropertyName())) {
							return "Material:" + va.getPropertyValueName();
						}
					}
				}
			}
			if ("bullet_point2".equalsIgnoreCase(column)) {
				if (CollectionUtils.isNotEmpty(values)) {
					for (ProductProperty va : values) {
						if ("Color".equalsIgnoreCase(va.getPropertyName())) {
							return "Color:" + va.getPropertyValueName();
						}
					}
				}
			}
			if ("bullet_point3".equalsIgnoreCase(column)) {
				if (CollectionUtils.isNotEmpty(values)) {
					for (ProductProperty va : values) {
						if ("Shape".equalsIgnoreCase(va.getPropertyName())) {
							return "Shape:" + va.getPropertyValueName();
						}
					}
				}
			}
			if ("bullet_point4".equalsIgnoreCase(column)) {
				if (CollectionUtils.isNotEmpty(values)) {
					for (ProductProperty va : values) {
						if ("Usage".equalsIgnoreCase(va.getPropertyName())) {
							return "Usage:" + va.getPropertyValueName();
						}
					}
				}
			}
			// 从右向左，找到商品名称中最后一个about，截取商品名称包含about到名称结束的所有字符；
			// 法语查找词为：environ 德语为: etwa 西班牙语为：sobre 意大利语为：circa
			if ("bullet_point5".equalsIgnoreCase(column)) {
				String key = getKeyByLanguage(si.getLanguage());
				if (vp.getProductName().contains(key)) {
					return vp.getProductName().substring(vp.getProductName().indexOf(key));
				}
			}

			if ("other_image_url1".equalsIgnoreCase(column)) {
				if (CollectionUtils.isNotEmpty(pics)) {
					if (pics.size() > 1) {
						return DeployProperties.getInstance().getExcelPictureUrl()
								+ getPictureUrl(pics.get(1).getPictureCode());
					}
				}
			}
			if ("other_image_url2".equalsIgnoreCase(column)) {
				if (CollectionUtils.isNotEmpty(pics)) {
					if (pics.size() > 2) {
						return DeployProperties.getInstance().getExcelPictureUrl()
								+ getPictureUrl(pics.get(2).getPictureCode());
					}
				}
			}
		}
		return "";
	}

	private String getParentSku(int amShopProductId) {
		String sql = "SELECT a.* FROM am_shop_product a "
				+ " INNER JOIN   dbo.am_shop_product b ON a.id=b.group_id WHERE b.ID=" + amShopProductId;
		List<AMShopProductPo> pos = amShopProductDao.findListBySql(sql, null);
		if (CollectionUtils.isNotEmpty(pos)) {
			return pos.get(0).getSku();
		}
		return null;
	}

	/**
	 * 从右向左，找到商品名称中最后一个about，截取商品名称包含about到名称结束的所有字符； 法语查找词为：environ 德语为: etwa
	 * 西班牙语为：sobre 意大利语为：circa
	 * 
	 * @param language
	 * @return
	 */
	private String getKeyByLanguage(int language) {
		switch (language) {
		case 3:
			return "etwa";
		case 4:
			return "environ";
		case 6:
			return "sobre";
		case 8:
			return "circa";
		default:
			return "about";
		}
	}

	@Override
	public void importShopProduct(String data, int templateId, int operator, int shopId) throws BussinessException {
		if (StringUtils.isNotEmpty(data)) {
			JSONArray ja = JSONArray.fromObject(data);
			for (int i = 0; i < ja.size(); i++) {
				JSONObject newJo = ja.getJSONObject(i);
				String sku = newJo.getString("item_sku");
				if (StringUtils.isNotEmpty(sku)) {
					// // 判断是否是父商品
					// String isParent = newJo.getString(PARENT_CHILD);
					// if (PARENT.equalsIgnoreCase(isParent)) {
					// sku = sku + "-0";
					// }

					AMShopProductPo po = getShopProductBySku(sku, shopId);
					if (po == null) {
						String upc = newJo.getString("external_product_id");
						po = getShopProductByUPCAndShop(upc, shopId);
					}
					if (po == null) {
						throw new BussinessException("Excel中有无法匹配的商品！");
					}
					AMShopProductDetailPo depo = getDetailByShopProduct(po.getId());
					if (depo != null) {
						JSONObject oldJo = JSONObject.fromObject(depo.getValue());
						List<TemplateDetial> temps = systemService.getTemplateDetials(templateId);
						depo.setValue(oldJo.toString());
//						int j = 0;
						for (TemplateDetial temp : temps) {
							if (!temp.isReadonly()) {
								String column = temp.getColumnName();
								if (!newJo.containsKey(column)) {
									continue;
								}
								String value = newJo.getString(column);
								oldJo.put(column, value);
								// 更新对象的值
								 updateObjectData(column, value, po);
							}
						}
						// // 更新同语种商品的信息
						// List<AMShopProductPo> other =
						// getOtherShopProductInfoByThisProduct(po.getProductId(),
						// po.getShopId());
						// // 虚拟父商品不更新同语种信息
						// if (CollectionUtils.isNotEmpty(other) &&
						// !"0".equals(po.getSkuEnd())) {
						// for (AMShopProductPo amShopProductPo : other) {
						// amShopProductPo.setContentStatus(true);
						// if (j > 0) {
						// amShopProductPo.setProductName(po.getProductName());
						// amShopProductPo.setProductContent(po.getProductContent());
						//
						// // 更新json
						// AMShopProductDetailPo json =
						// getDetailByShopProduct(po.getId());
						// if (json != null) {
						// JSONObject jo =
						// JSONObject.fromObject(json.getValue());
						// if (jo.containsKey("item_name")) {
						// jo.put("item_name", po.getProductName());
						// }
						//
						// if (jo.containsKey("product_description")) {
						// jo.put("product_description",
						// po.getProductContent());
						// }
						// }
						// }
						// }
						// }

						// 更新状态
						if (!po.getContentStatus()) {
							po.setContentStatus(true);
						}
						if (po.getUploadStatus() == ProductUploadStatus.已上传.ordinal()) {
							po.setUploadStatus(ProductUploadStatus.待上传_上传过amazon.ordinal());
						}
						depo.setValue(oldJo.toString());
					}
				}
			}
		}
	}

	private AMShopProductPo getShopProductByUPCAndShop(String upc, int shopId) {
		String hql = "from AMShopProductPo where upc=? and shopId=?";
		return amShopProductDao.findByHql(hql, new Object[] { upc, shopId });
	}

	private List<AMShopProductPo> getShopProductByUPC(String upc) {		
		String hql = "from AMShopProductPo where upc=?";
		return amShopProductDao.findListByHql(hql, upc);
	}

	private int updateObjectData(String column, String value, AMShopProductPo po) {
		if (column.equalsIgnoreCase("item_name")) {
			po.setProductName(value);
			po.setProductNameLastUpdateTime(new Date());
			return 1;
		}
		if (column.equalsIgnoreCase("product_description")) {
			po.setProductContentLastUpdateTime(new Date());
			po.setProductContent(value);
			return 1;
		}

		if (column.equalsIgnoreCase("feed_product_type")) {
			po.setProductType(value);
			systemService.autoAddProductType(po.getShopId(), value);
			return 1;
		}
		if (column.equalsIgnoreCase("item_type")) {
			po.setBrowseNode(value);
			systemService.autoAddBrowesNode(po.getShopId(), value);
			return 1;
		}

		// 虚拟父商品不更新一下值
		if (!"0".equals(po.getSkuEnd())) {
			if (column.equalsIgnoreCase("standard_price")) {
				po.setPrice(StringUtils.isNotEmpty(value) ? new BigDecimal(value) : null);
			}
			if (column.equalsIgnoreCase("recommended_browse_nodes1")) {
				po.setBrowseNode(value);
			}
			if (column.equalsIgnoreCase("feed_product_type")) {
				po.setProductType(value);
			}
		}
		return 0;
	}

	/**
	 * 根据sku获取店铺商品对象
	 * 
	 * @param sku
	 * @return
	 */
	private AMShopProductPo getShopProductBySku(String sku, int shopId) {
		// if (sku.contains("-")) {
		// String hql = "from AMShopProductPo where Sku=? and skuEnd=?";
		// String params[] = sku.split("-");
		// try {
		// return amShopProductDao.findByHql(hql, new Object[] { params[0],
		// Integer.valueOf(params[1]) });
		// } catch (NumberFormatException e) {
		// return null;
		// }
		//
		// } else {
		String hql = "from AMShopProductPo where Sku=? and shopId=?";
		return amShopProductDao.findByHql(hql, new Object[] { sku, shopId });
		// }
		// String sql="SELECT * FROM dbo.am_shop_product WHERE CASE WHEN "
		// +" sku_end IS NOT NULL and sku_end <>'0' THEN sku+'-'+sku_end "
		// +" ELSE sku END ='"+sku+"'";
		// List<AMShopProductPo> pos=amShopProductDao.findListBySql(sql, null);
		// if (CollectionUtils.isNotEmpty(pos)) {
		// return pos.get(0);
		// }
		// return null;
	}

	/**
	 * 根据sku获取店铺商品对象
	 * 
	 * @param sku
	 * @return
	 */
	private List<AMShopProductPo> getShopProductGroup(int groupId) {
		String hql = "from AMShopProductPo where groupId=?";
		return amShopProductDao.findListByHql(hql, groupId);
	}

	@Override
	public void putaway(int[] shopProductIds, int operator) {
		for (int i = 0; i < shopProductIds.length; i++) {
			int shopProductId = shopProductIds[i];
			AMShopProductPo po = amShopProductDao.getObject(shopProductId);
			po.setShelveStatus(true);
			AMShopProductDetailPo detail = getAmShopProductDetailPo(shopProductId);
			if (detail != null) {
				JSONObject jo = JSONObject.fromObject(detail.getValue());
				String o = jo.getString("update_delete");
				if (!UPDATE.equals(o)) {
					jo.put("update_delete", UPDATE);
					detail.setValue(jo.toString());
					amShopProductDetailDao.updateObject(detail);
				}
			}
			amShopProductDao.mergeObject(po);

			// 操作记录
			systemService.addProductOperatorLog(LogType.SHOP_PRODUCT_PUTWAY.ordinal(), shopProductId, "更新商品的为上架状态！",
					operator);
		}
	}

	@Override
	public void off(int[] shopProductIds, int operator) {
		for (int i = 0; i < shopProductIds.length; i++) {
			int shopProductId = shopProductIds[i];
			AMShopProductPo po = amShopProductDao.getObject(shopProductId);
			po.setShelveStatus(false);
			AMShopProductDetailPo detail = getAmShopProductDetailPo(shopProductId);
			if (detail != null) {
				JSONObject jo = JSONObject.fromObject(detail.getValue());
				String o = jo.getString("update_delete");
				if (!DELETE.equals(o)) {
					jo.put("update_delete", DELETE);
					detail.setValue(jo.toString());
					amShopProductDetailDao.updateObject(detail);
				}
			}
			amShopProductDao.mergeObject(po);

			// 操作记录
			systemService.addProductOperatorLog(LogType.SHOP_PRODUCT_PUTWAY.ordinal(), shopProductId, "更新商品的为下架状态！",
					operator);
		}
	}

	@Override
	public void submitAmazon(byte[] file, String[] skus, String ext, int shopId, int operator)
			throws BussinessException {
		AMShopUploadLogPo po = null;
		try {
			// 验证Excel商品状态
			if (skus == null || skus.length < 1) {
				return;
			}

			List<Integer> ftpResult=new  ArrayList<Integer>();
			//判断是否有图片还未上传到ftp
			boolean _not_complated_ftp=false;
			for (String sku : skus) {
				// 父商品没有upc
				if (StringUtils.isEmpty(sku)) {
					continue;
				}
				AMShopProductPo ampo = this.getShopProductBySku(sku, shopId);
				if (ampo == null) {
					throw new BussinessException("Excel中有商品在OSMS系统中不存在！sku为：" + sku);
				}

				if (!ampo.getContentStatus()) {
					throw new BussinessException("Excel中有商品内容状态为：未完善！sku为：" + sku);
				}

				if (ampo.getUploadStatus() == ProductUploadStatus.已上传.ordinal()) {
					throw new BussinessException("Excel中有商品上传状态为： 已上传！sku为：" + sku);
				}

				Product ppo = productService.getProduct(ampo.getProductId());
				if (ppo == null) {
					throw new BussinessException("Excel中有商品数据错误！sku为：" + sku);
				}

				if (!ppo.isPictureStatus()) {
					throw new BussinessException("Excel中有商品图片状态为：未审核！sku为：" + sku);
				}

				// 通过Excel更新商品之后，或修改上下架状态之后，状态为已上传
				ampo.setUploadStatus(ProductUploadStatus.已上传.ordinal());

				// 验证图片是否已上传到ftp
				 if(checkPictureFTP(ampo.getProductId())){
					 ftpResult.add(ampo.getProductId());
					 _not_complated_ftp=true;
				 }
			}
			
			String sourceFileName = DeployProperties.getInstance().getTempUploadFilePath()
					+ DateUtils.convertDate(new Date(), "yyyyMMddHHmmss") + ".txt";
			File txt = new File(sourceFileName);
			FileUtils.writeByteArrayToFile(txt, file);

			// 上传记录
			po = new AMShopUploadLogPo();
			po.setOperator(operator);
			po.setType(UploadType.PRODUCT.ordinal());
			po.setShopId(shopId);
			po.setUploadTime(new Date());
			po.setTitle("更新" + skus.length + "个商品到AMAZON");
			po.setRemark("图片未完成上传，暂停商品上传任务，待图片完成后，自动上传商品到AMAZON！");
			
			final Integer id = shopUploadLogDao.addObject(po);
			if (_not_complated_ftp) {
				//图片没有完成上传，暂停上传，创建商品上传任务
				po.setResult(2);//待上传
				
				AMShopUploadFileTaskPO task=new AMShopUploadFileTaskPO();
				task.setAmShopUploadLogId(id);
				task.setFileLocal(txt.getAbsolutePath());
				task.setType(0);
				task.setStatus(0);
				task.setCreateDate(new Date());
				task.setShopId(shopId);
				Integer taskId=amShopUploadFileTaskDao.addObject(task);
				AMShopUploadFileDataPO data=null;
				for (Integer productId : ftpResult) {
					data=new AMShopUploadFileDataPO();
					data.setAMShopUploadFileTaskID(taskId);
					data.setImageUploadStatus(false);
					data.setProductId(productId);
					amShopUploadFileDataDao.addObject(data);
				}
			}else{
				// 店铺
				final ShopInfo info = systemService.getShopInfo(shopId);
				final String submitSession = AmazonClient.submitFeed(info.getShopId(),
						FileUtils.readFileToByteArray(txt), "txt");
				po.setSubmitSession(submitSession);
				
				if (StringUtils.isEmpty(submitSession)) {
					po.setResult(0);
					po.setRemark("文件未上传到amazon，请重试!");
				} else {
					po.setResult(1);
				}
				
				if (StringUtils.isNotEmpty(submitSession)) {
					ThreadUtils.pool.execute(new Runnable() {
						@Override
						public void run() {
							try {
								Thread.currentThread().setName("pool-1-thread-" + submitSession);
								LOGGER.info(Thread.currentThread().getName() + "------start waiting！");
								String tmp = new String(submitSession);
								 TimeUnit.MINUTES.sleep(15);
								addAmazonLog(tmp, id, info.getShopId());
								LOGGER.info(Thread.currentThread().getName() + "-------end waiting！");
							} catch (InterruptedException e) {
								LOGGER.error(e.getMessage());
							}
						}
					});
				}
			}
		} catch (Exception e) {
			if (po == null) {
				po = new AMShopUploadLogPo();
				po.setOperator(operator);
				po.setType(UploadType.PRODUCT.ordinal());
				po.setTitle("更新" + skus.length + "个商品到AMAZON");
				po.setUploadTime(new Date());
				po.setShopId(shopId);
			}
			po.setResult(0);
			po.setRemark(e.getMessage());
			shopUploadLogDao.mergeObject(po);
		}
	}

	public boolean checkPictureFTP(Integer productId) {
		if (productId==null) {
			return false;
		}
		String hql = "select p from FTPUploadLogPO p where p.type=? and p.status=? " +
				" and p.objectId=? order by p.id desc";
		FTPUploadLogPO po= ftpUploadLogDao.findByHql(hql, "p",new Object[]{FTPType.UPLOAD,FTPStatus.FAILED,productId},LockMode.NONE);
		if (po!=null) {
			return true;
		}
		return false;
	}

	public void addAmazonLog(String sessionId, int id, int shopId) {
		LOGGER.info(Thread.currentThread().getName() + "getResultBySessionId-------->>start working product!");
		String hql = "from AMShopUploadLogPo where submitSession=? and id=?";
		AMShopUploadLogPo po = shopUploadLogDao.findByHql(hql, new Object[] { sessionId, id });
		if (po == null) {
			return;
		}
		String result = AmazonClient.getResultBySessionId(shopId, sessionId);
		if (StringUtils.isNotEmpty(result) && result.length() > 100) {
			po.setResult(0);
		}
		po.setRemark(result);
		shopUploadLogDao.mergeObject(po);
		LOGGER.info(Thread.currentThread().getName() + "getResultBySessionId-------->>end working product!");
	}

	@Override
	public PageList<uploadLog> findFailedLog(searchLogForm form, int currentPage, int pageSize) {
		String sql = "SELECT  * FROM dbo.v_shop_upload_log ";
		StringBuilder where = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		boolean _is_need = true;
		if (form.getResult() > -1) {
			where.append(" and result=? ");
			params.add(form.getResult());
		}
		if (form.getType() > -1) {
			where.append(" and type=? ");
			params.add(form.getType());
			if (form.getType() == 1) {
				// 忽略订单查询时的 操作人
				_is_need = false;
			}
		}

		if (_is_need) {
			if (form.getOperator() > 0) {
				where.append(" AND operator=? ");
				params.add(form.getOperator());
			}
		}

		PageList<VShopUploadLogPo> pl = vShopUploadLogDao.findPageListBySql(currentPage, pageSize, sql,
				where.toString(), " upload_time desc ", params);
		if (CollectionUtils.isNotEmpty(pl.getData()))
			return BeanUtils.copyPageList(pl, uploadLog.class);
		return null;

	}

	public String importOldProduct(int departmentId, int shopId, String jsonData, int operator) {
		if (StringUtils.isNotEmpty(jsonData)) {
			// 数据初始化
			Map<String, JSONObject> jm = new HashMap<String, JSONObject>();
			JSONArray ja = JSONArray.fromObject(jsonData);
			for (int i = 0; i < ja.size(); i++) {
				JSONObject jo = JSONObject.fromObject(ja.get(i));
				if (jo.containsKey("part_number")) {
					// 判断在系统存在？
					if (productService.isExistProduct(jo.getString("part_number"), departmentId))
						continue;
					jm.put(jo.getString("part_number"), jo);
				}
			}
			// 生成product数据

			// 生成amProduct数据

			// 生成json数据

		}

		return null;
	}

	public static void main(String[] args) {
		String s = "[CWIR-CW0.4mm]-2.jpg";
		System.out.println(s.substring(s.indexOf("[") + 1, s.lastIndexOf("]")));
		System.out.println(Integer.valueOf(s.substring(s.lastIndexOf("-") + 1, s.lastIndexOf("."))));

		// System.out.println(ProductUploadStatus.已上传.ordinal());
	}

	@Override
	public AMShopProduct getProductBySku(String sku, int shopId) {
		AMShopProductPo po = getShopProductBySku(sku, shopId);
		if (po != null) {
			return BeanUtils.copyProperties(po, AMShopProduct.class);
		}
		return null;
	}

}
