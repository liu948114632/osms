package com.itecheasy.core.product;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.itecheasy.common.PageList;
import com.itecheasy.common.Param;
import com.itecheasy.common.picture.PictureService;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.CollectionUtils.Equaltor;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.common.util.PictureUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.CurrencyUtils;
import com.itecheasy.core.po.BatchPo;
import com.itecheasy.core.po.ProductFreezeStockPo;
import com.itecheasy.core.po.ProductPictureCollectionPO;
import com.itecheasy.core.po.ProductPo;
import com.itecheasy.core.po.ProductPropertyValuePo;
import com.itecheasy.core.po.ProductRelationPo;
import com.itecheasy.core.product.UpdateStockParam.UpdateStockHandle;
import com.itecheasy.core.product.dao.BatchDao;
import com.itecheasy.core.product.dao.ProductDao;
import com.itecheasy.core.product.dao.ProductFreezeDao;
import com.itecheasy.core.product.dao.ProductPictureCollectionDAO;
import com.itecheasy.core.product.dao.ProductPropertyDao;
import com.itecheasy.core.product.dao.ProductRelationDao;
import com.itecheasy.core.system.Category;
import com.itecheasy.core.system.CurrencyExchangeRate;
import com.itecheasy.core.system.ProductRelation;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.system.SystemService.LogType;
import com.itecheasy.core.user.ProfileService;
import com.itecheasy.webservice.client.CMSClient;
import com.itecheasy.webservice.client.CMSClient.ExchangeStorageTypeOsms;
import com.itecheasy.webservice.client.CMSClient.ExchangeTargetStorageTypeOsms;
import com.itecheasy.webservice.client.DMSClient;
import com.itecheasy.webservice.cms.OsmsStorageFreeze;

/**
 * @author wanghw
 * @date 2015-3-26
 * @description 网店销售商品管理
 * @version 1.0.0
 */
public class ProductServiceImpl implements ProductService {
	private static final String PRODUCT_PICTURE = "product";

	private ProductDao productDao;
	private ProductRelationDao productRelationDao;
	private ProductPictureCollectionDAO productPictureCollectionDAO;
	private ProductPropertyDao productPropertyDao;
	private ProductFreezeDao productFreezeDao;
	private BatchDao batchDao;
	private BaseProductCostPriceService baseProductCostPriceService;

	private ProfileService profileService;
	private SystemService systemService;

	private PictureService pictureService;

	public void setBaseProductCostPriceService(BaseProductCostPriceService baseProductCostPriceService) {
		this.baseProductCostPriceService = baseProductCostPriceService;
	}

	public void setBatchDao(BatchDao batchDao) {
		this.batchDao = batchDao;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public void setProductFreezeDao(ProductFreezeDao productFreezeDao) {
		this.productFreezeDao = productFreezeDao;
	}

	public void setProductRelationDao(ProductRelationDao productRelationDao) {
		this.productRelationDao = productRelationDao;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setProductPropertyDao(ProductPropertyDao productPropertyDao) {
		this.productPropertyDao = productPropertyDao;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public void setProductPictureCollectionDAO(ProductPictureCollectionDAO productPictureCollectionDAO) {
		this.productPictureCollectionDAO = productPictureCollectionDAO;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Product getProduct(int productId) {
		ProductPo po = this.getProductPo(productId);
		if (po != null)
			return BeanUtils.copyProperties(po, Product.class);
		return null;
	}

	@Override
	public PageList<CMSProductVo> findCMSProduct(SearchCMSProductForm form, int currentPage, int pageSize) {
		return CMSClient.findCMSProduct(form, pageSize, currentPage);
	}

	@Override
	public PageList<ProductVo> findProduct(SearchProductForm form, int currentPage, int pageSize) {
		List<Param> parameters = new ArrayList<Param>();
		boolean lose = false;
		if (StringUtils.isNotEmpty(form.getProductCode())) {
			parameters.add(new Param("productCode", form.getProductCode()));
			lose = true;
		}
		if (CollectionUtils.isNotEmpty(form.getProductCodes())) {
			StringBuilder productCodeList = new StringBuilder();
			for (String productCode : form.getProductCodes()) {
				productCodeList.append(productCode + ",");
			}
			parameters.add(new Param("productCodes", productCodeList.substring(0, productCodeList.length() - 1)));
			lose = true;
		}
		if (form.getDepartment() > -1) {
			parameters.add(new Param("department", form.getDepartment()));
		}

		if (form.getShopId() > -1) {
			parameters.add(new Param("shopId", form.getShopId()));
		}
		if (!lose) {
			if (form.getCategory1() > -1) {
				parameters.add(new Param("category1", form.getCategory1()));
			}
			if (form.getCategory2() > -1) {
				parameters.add(new Param("category2", form.getCategory2()));
			}
			if (form.getCategory3() > -1) {
				parameters.add(new Param("category3", form.getCategory3()));
			}
			if (form.getFreezeStatus() > -1) {
				parameters.add(new Param("freezeStatus", form.getFreezeStatus()));
			}
			if (form.getSeriesId() > -1) {
				parameters.add(new Param("seriesId", form.getSeriesId()));
			}
			if (form.getIsSmallQuantities() > -1) {
				parameters.add(new Param("isSmallQuantities", form.getIsSmallQuantities()));
			}
			if (form.getIsPool() > -1) {
				parameters.add(new Param("isPool", form.getIsPool()));
			}
			if (form.getIsMix() > -1) {
				parameters.add(new Param("isMix", form.getIsMix()));
			}
			if (form.getIsGift() > -1) {
				parameters.add(new Param("isGift", form.getIsGift()));
			}
			if (form.getStatus() > -1) {
				parameters.add(new Param("status", form.getStatus()));
			}
			if (StringUtils.isNotEmpty(form.getName())) {
				parameters.add(new Param("name", form.getName()));
			}
			if (form.getBatchId() > 0) {
				parameters.add(new Param("batchId", form.getBatchId()));
			}
		}
		// 获取商品可用库存
		parameters.add(new Param("PageSize", String.valueOf(pageSize)));
		parameters.add(new Param("PageIndex", String.valueOf(currentPage)));
		PageList<ProductVo> pl = productDao.findPageListByStoredProcedure(currentPage, pageSize, "OSMS_product_list",
				parameters, ProductVo.class);

		if (CollectionUtils.isNotEmpty(pl.getData())) {
			List<String> cmsProductCode = new ArrayList<String>();
			List<Integer> cmsProductIds=new ArrayList<Integer>();
			for (ProductVo vo : pl.getData()) {
				cmsProductCode.add(vo.getCmsProductCode());
				cmsProductIds.add(vo.getCmsProductId());
			}
//			List<OsmsStorageFreeze> frees = CMSClient.getAvailableStockAndFreezeQtys(cmsProductCode);
			Map<Integer, OsmsStock> map=CMSClient.getOsmsStocks(cmsProductIds);

			for (ProductVo vo : pl.getData()) {
				if(map.containsKey(vo.getCmsProductId())){
					vo.setOrderStock(map.get(vo.getCmsProductId()).getOrderStock());
					vo.setFbaStock(map.get(vo.getCmsProductId()).getFbaStock());
					vo.setAvailableStock(map.get(vo.getCmsProductId()).getAvailableQuantity());
					vo.setFreezeStock(map.get(vo.getCmsProductId()).getRealFreezeQuantity());
				}
//				for (OsmsStorageFreeze free : frees) {
//					if (vo.getCmsProductCode().equals(free.getProductCode())) {
//						vo.setAvailableStock(free.getAvailableQuantity());
//						vo.setFreezeStock(free.getRealFreezeQuantity());
//						break;
//					}
//				}
			}
			
		}
		return pl;
	}

	@Override
	public int[] addProduct(int[] cmsProducts, int[] safetyStocks, int operator, int batchId, String batchName,
			int departmentId) throws BussinessException {
		int[] red = {};
		List<Integer> addIds = new ArrayList<Integer>();
		int depart = departmentId;
		if (batchId < 0) {
			batchId = addBatch(operator, batchName, depart);
		}
		for (int i = 0; i < cmsProducts.length; i++) {
			CMSProduct cms = CMSClient.getCMSProduct(cmsProducts[i]);
			if (getPoByCode(cms.getCode(), operator) != null) {
				continue;
			}
			// 判断可用库存
//			OsmsStorageFreeze free = CMSClient.getAvailableStockAndFreezeQty(cms.getCode());
//			if (cms.getAvailableStock() / cms.getUnitQuantity() < 1.0
//					&& (free == null || free.getRealFreezeQuantity().doubleValue() <= 0)) {
//				red = ArrayUtils.add(red, cmsProducts[i]);
//				continue;
//			}
			// 添加商品
			ProductPo po = convertCMSProduct2Product(cms);
			po.setDepartmentId(depart);
			po.setBatchId(batchId);
			po.setAddUserId(operator);
			Integer productId = productDao.addObject(po);
			// 存储图片
			List<ProductPicture> pics = cms.getProductPictures();
			if (CollectionUtils.isNotEmpty(pics)) {
				savePicture(po, productId, pics);
			}
			// 存储属性
			List<ProductProperty> propertys = cms.getProductPropertyValues();
			if (CollectionUtils.isNotEmpty(propertys)) {
				List<ProductPropertyValuePo> pos = BeanUtils.copyList(propertys, ProductPropertyValuePo.class);
				for (ProductPropertyValuePo productPropertyValuePo : pos) {
					productPropertyValuePo.setProductId(productId);
				}
				productPropertyDao.addObject(pos);
			}
			// 锁定库存
			try {
				freezeStock(productId, safetyStocks[i], operator, cms.getCode());
			} catch (Exception e) {
				red = ArrayUtils.add(red, cmsProducts[i]);
			}
			// 查询相关商品
			List<Integer> relationProductIds = setProductRelation(cms, depart);
			// 重新设置主副关系
			if (CollectionUtils.isNotEmpty(relationProductIds)) {
				if (relationProductIds.size() > 1) {
					relationProductIds.add(productId);
					// 归并商品
					int main = this.setProductRelations(CollectionUtils.list2Array(relationProductIds));
					for (int p : relationProductIds) {
						ProductRelationPo prpo = this.getProductRelationPo(p);
						if (prpo == null) {
							prpo = new ProductRelationPo();
							prpo.setProductId(p);
						}
						prpo.setMainProductId(main);
						if (prpo.getProductId() == main) {
							prpo.setMainProductId(null);
						}
						productRelationDao.mergeObject(prpo);
					}

				}
			}
			addIds.add(cmsProducts[i]);
			// 操作日志
			systemService.addProductOperatorLog(LogType.ADD_PRODUCT.ordinal(), productId, "添加CMS3商品" + cms.getCode()
					+ "到网店销售商品！", operator);
		}
		// 调用cms3接口，存储关系
		if (addIds.size() > 0) {
			CMSClient.addProduct2cms(addIds, depart);
		}
		return red;
	}

	private int addBatch(int operator, String batchName, int depart) {
		int batchId;
		String hql="from BatchPo where name=?";
		BatchPo batchesPo=batchDao.findByHql(hql, batchName);
		if(batchesPo!=null){
			return  batchesPo.getId();
		}
		batchesPo = new BatchPo();
		batchesPo.setName(batchName);
		batchesPo.setOperator(operator);
		batchesPo.setDepartmentId(depart);
		batchId = batchDao.addObject(batchesPo);
		return batchId;
	}

	private List<Integer> setProductRelation(CMSProduct cms, int departmentId) {
		List<Integer> relationProducts = new ArrayList<Integer>();
		// 同一个类别and 没有被添加到店铺销售商品
		String hql = "from ProductPo where status =false and departmentId=?";
		List<ProductPo> pos = null;
		if (cms.getCategoryId3() > 0) {
			hql += "  and categoryId3=?";
			pos = productDao.findListByHql(hql, new Object[] { departmentId, cms.getCategoryId3() });
		} else {
			hql += "  and categoryId2=?";
			pos = productDao.findListByHql(hql, new Object[] { departmentId, cms.getCategoryId2() });
		}

		// SELECT * FROM dbo.property WHERE name IN
		// ('Color',
		// 'Beads Size',--
		// 'Hole Size',--
		// 'Bag Size',
		// 'Color Effect',
		// 'Grade',
		// 'Metal Color',
		// 'Pin Length',
		// 'Swarovski Color',
		// 'Swarovski Size'
		// )
		List<Integer> undesiredComparePropertyId = CollectionUtils
				.array2List(new int[] { 3, 4, 13, 21, 27, 28, 76, 77 });
		List<ProductProperty> ps = cms.getProductPropertyValues();
		// 去掉要忽略的元素
		if (CollectionUtils.isEmpty(ps)) {
			ps = new ArrayList<ProductProperty>();
		}
		// 临时
		List<ProductProperty> tmp = new ArrayList<ProductProperty>();
		for (ProductProperty ppp : ps) {
			if (undesiredComparePropertyId.contains(ppp.getPropertyId())) {
				tmp.add(ppp);
			}
		}
		ps.removeAll(tmp);
		// 相同属性
		if (CollectionUtils.isNotEmpty(pos)) {
			for (ProductPo productPo : pos) {
				tmp = new ArrayList<ProductProperty>();
				// boolean add=true;
				List<ProductProperty> pros = getProductPropertiesByProductId(productPo.getId());
				if (CollectionUtils.isNotEmpty(pros)) {
					// 去掉要忽略的元素
					for (ProductProperty productProperty : pros) {
						if (undesiredComparePropertyId.contains(productProperty.getPropertyId())) {
							tmp.add(productProperty);
						}
					}
					pros.removeAll(tmp);

					if (pros.equals(ps)) {
						relationProducts.add(productPo.getId());
					}

					// for (int i = 0; i < pros.size(); i++) {
					// ProductProperty pp=pros.get(i);
					// if
					// (!undesiredComparePropertyId.contains(pp.getPropertyId()))
					// {
					// if (!(ps.contains(pp)&&pros.contains(ps.get(i)))) {
					// add=false;
					// break;
					// }
					// }
					// }

					// if (add) {
					// relationProducts.add(productPo.getId());
					// }
				}

				// if(CollectionUtils.isNotEmpty(pros)){
				// List<ProductProperty>
				// temp=pros.size()>cms.getProductPropertyValues().size()?
				// CollectionUtils.sub(pros, cms.getProductPropertyValues(),new
				// Equaltor<ProductProperty, ProductProperty>() {
				// @Override
				// public boolean equal(ProductProperty o1, ProductProperty o2)
				// {
				// return
				// o1.getPropertyId()==o2.getPropertyId()&&o1.getPropertyValue()==o2.getPropertyValue();
				// }
				// }):CollectionUtils.sub(cms.getProductPropertyValues(),
				// pros,new Equaltor<ProductProperty, ProductProperty>() {
				// @Override
				// public boolean equal(ProductProperty o1, ProductProperty o2)
				// {
				// return
				// o1.getPropertyId()==o2.getPropertyId()&&o1.getPropertyValue()==o2.getPropertyValue();
				// }
				// });
				// if (CollectionUtils.isNotEmpty(temp)) {
				// for (ProductProperty tmp : temp) {
				// if
				// (!undesiredComparePropertyId.contains(tmp.getPropertyId())) {
				// add=false;
				// break;
				// }
				// }
				// }
				// if (add) {
				// relationProducts.add(productPo.getId());
				// }
				// }
			}
		}
		return relationProducts;
	}

	private List<ProductPropertyValuePo> getPropertyValuePos(int productId) {
		String hql = "from ProductPropertyValuePo where productId=?";
		return productPropertyDao.findListByHql(hql, productId);
	}

	@Override
	public List<ProductProperty> getProductPropertiesByProductId(int productId) {
		List<ProductPropertyValuePo> pos = getPropertyValuePos(productId);
		if (CollectionUtils.isNotEmpty(pos))
			return BeanUtils.copyList(pos, ProductProperty.class);
		return null;
	}

	/**
	 * 存储图片
	 */
	private void savePicture(ProductPo po, Integer productId, List<ProductPicture> pics) throws BussinessException {
		int index = 2;
		for (ProductPicture pic : pics) {
			// 从新标号
			if (pic.getType() == 1) {
				pic.setOrderIndex(1);
			} else {
				pic.setOrderIndex(index);
				index++;
			}

			String imgUrl = DeployProperties.getInstance().getProperty("cms.photo.dowload.url") + pic.getPictureCode();
			try {
				File pictureFile = new File(PictureUtils.downLoadPic(imgUrl, pic.getPictureName()));
				String picCode = addPicture(pic, pictureFile, productId, po.getCmsProductCode());
				if (pic.getType() == 1) {
					// 更新冗余主图code
					po.setPrimaryPictureCode(picCode);
				}
			} catch (MalformedURLException e) {
				throw new BussinessException("图片下载异常：" + e.getMessage());
			} catch (IOException e) {
				throw new BussinessException("图片下载异常：" + e.getMessage());
			}

		}
	}

	/**
	 * 新增锁定库存，调用cms3接口
	 */
	private void freezeStock(int productId, int shouldQty, int operator, String cmsProductCode)
			throws BussinessException {
		ProductFreezeStockPo po = new ProductFreezeStockPo();

		// 判断是否有其它锁定
		ProductFreezeStockPo po2 = this.getOtherFreezeInfoByThisProduct(productId, cmsProductCode);
		if (po2 == null) {
			po.setCurrentFreeze(true);
		} else {
			if (po2.getShouldQty() < shouldQty) {
				po.setCurrentFreeze(true);
				po2.setCurrentFreeze(false);
				productFreezeDao.mergeObject(po2);
			} else {
				po.setCurrentFreeze(false);
			}
		}
		po.setDepartmentId(profileService.getDepartmentByOperator(operator));
		po.setOperator(operator);
		po.setProductId(productId);
		po.setShouldQty(shouldQty);
		po.setCmsProductCode(cmsProductCode);
		productFreezeDao.addObject(po);

		if (po.isCurrentFreeze()) {
			// 调用cms3接口锁定库存
			CMSClient.blockedStock(cmsProductCode, shouldQty,profileService.getUserNameById(operator));
		}

	}

	/**
	 * 添加图片
	 */
	private String addPicture(ProductPicture productPicture, File pictureFile, int productId, String cmsProductCode) {
		ProductPictureCollectionPO picturePo = BeanUtils.copyProperties(productPicture,
				ProductPictureCollectionPO.class);
		picturePo.setProductId(productId);
		String pictureCode = pictureService.addPicture(PRODUCT_PICTURE, String.valueOf(productId), null, null,
				pictureFile);
		picturePo.setPictureCode(pictureCode);
		String ext = FilenameUtils.getExtension(pictureFile.getName());
		picturePo.setPictureName(pictureCode + "." + ext);
		picturePo.setCmsProductCode(cmsProductCode);
		productPictureCollectionDAO.addObject(picturePo);

		return pictureCode;
	}

	private ProductPo getPoByCode(String cmsProductCode, int operator) {
		String hql = "from ProductPo where cmsProductCode=? and departmentId=?";
		ProductPo po = productDao.findByHql(hql,
				new Object[] { cmsProductCode, profileService.getDepartmentByOperator(operator) });
		return po;
	}

	private ProductPo convertCMSProduct2Product(CMSProduct cms) {
		ProductPo po = new ProductPo();
		po.setCmsProductCode(cms.getCode());
		po.setCmsProductId(cms.getId());
		po.setPhProductId(cms.getPhProductId());

		po.setCategoryId1(cms.getCategoryId1());
		po.setCategoryId2(cms.getCategoryId2());
		po.setCategoryId3(cms.getCategoryId3());
		po.setDescription(cms.getDescription());
		po.setIsGift(cms.getIsGift());
		po.setIsMix(cms.getIsMix());
		po.setIsSamllQuantities(cms.getIsSmallQuantities());
		po.setIspool(cms.getIsProductPool());
		po.setLastCategoryName(cms.getCategoryId3() > 0 ? cms.getCategory3Name() : cms.getCategory2Name());
		po.setPrimaryPictureCode(cms.getPrimaryPictureCode());
		po.setName(cms.getName());
		po.setUnit(cms.getUnit());
		po.setUnitQuantity(cms.getUnitQuantity());
		po.setCostPrice(cms.getCostPrice());
		po.setPhPrice(cms.getPhSalePrice());
		po.setStatus(false);
		po.setWeight(cms.getWeight().doubleValue());
		po.setPictureStatus(false);
		po.setSeries(cms.getSeriesId());
		po.setDescription(cms.getDescription());
		po.setVolume(cms.getVolume().doubleValue());
		return po;
	}

	@Override
	public void deleteProduct(int[] productIds, int operator) throws BussinessException {
		List<Integer> cmsProductIds = new ArrayList<Integer>();
		String name=profileService.getUserNameById(operator);
		for (int i = 0; i < productIds.length; i++) {
			ProductPo po = getProductPo(productIds[i]);
			if (po.isStatus()) {
				throw new BussinessException("勾选商品中存在状态为已挑选的商品，删除失败！");
			}
			cmsProductIds.add(po.getCmsProductId());
			// 删除产品主副关系
			deleteProductRelation(productIds[i]);
			// 删除商品
			productDao.deleteObject(po);
			// 删除图片
			deleteProductPicture(productIds[i]);
			// 是否锁定库存
			// 删除锁定记录
			List<ProductFreezeStockPo> stockPos = getFreezeStockPoByproductId(po.getCmsProductCode());
			boolean isCancel = false;
			int qty = 0;
			if (CollectionUtils.isNotEmpty(stockPos)) {
				if (stockPos.size() == 1) {
					productFreezeDao.deleteObject(stockPos.get(0));
					isCancel = true;
				} else {
					for (int j = 0; j < stockPos.size(); j++) {
						if (stockPos.get(j).getProductId() == productIds[i]) {
							productFreezeDao.deleteObject(stockPos.get(j));
							// 要删除的是第0个，则取第1个的值锁定
							if (j == 0) {
								qty = stockPos.get(1).getShouldQty();
								stockPos.get(1).setCurrentFreeze(true);
							}
							break;
						}
					}
				}

				try {
					if (isCancel) {
						CMSClient.cancelFreezeStock(po.getCmsProductCode(),name);
					} else {
						// 要删除的不是第0个，则取第0个的值更新锁定
						if (qty == 0) {
							qty = stockPos.get(0).getShouldQty();
							stockPos.get(0).setCurrentFreeze(true);
						}
						CMSClient.blockedStock(po.getCmsProductCode(), qty,name);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 操作日志
			systemService.addProductOperatorLog(LogType.DELETE_PRODUCT.ordinal(), productIds[i],
					"删除商品、删除图片、删除主副关系、释放锁定的库存", operator);
		}
		// 调用cms3接口删除记录
		CMSClient.deleteProduct2cms(cmsProductIds, profileService.getDepartmentByOperator(operator));
	}

	private List<ProductFreezeStockPo> getFreezeStockPoByproductId(String cmsProductCode) {
		String hql = "from ProductFreezeStockPo where cmsProductCode=? order by shouldQty desc";
		return productFreezeDao.findListByHql(hql, cmsProductCode);
	}

	private void deleteProductPicture(int productId) {
		String hql = "from ProductPictureCollectionPO where productId=?";
		List<ProductPictureCollectionPO> pos = productPictureCollectionDAO.findListByHql(hql, productId);
		if (CollectionUtils.isNotEmpty(pos)) {
			for (ProductPictureCollectionPO po : pos) {
				pictureService.deletePicture(po.getPictureCode());
				productPictureCollectionDAO.deleteObject(po);
			}
		}
	}

	private ProductPo getProductPo(int id) {
		return productDao.getObject(id);
	}

	/**
	 * 删除商品主副关系
	 * 
	 * @param productId
	 */
	private void deleteProductRelation(int productId) throws BussinessException {
		// 查询有主副关系
		ProductRelationPo po = getProductRelationPo(productId);
		if (po == null) {
			return;
		}
		// 判断是主商品
		if (po.getMainProductId() == null) {
			// 重新选择主商品
			List<ProductRelationPo> pos = this.getChildByP(productId);
			if (CollectionUtils.isNotEmpty(pos)) {
				// 如果只剩下一个商品，则删除关联关系
				if (pos.size() == 1) {
					productRelationDao.deleteObjects(pos);
				} else {
					int[] ids = {};
					for (ProductRelationPo p : pos) {
						ids = ArrayUtils.add(ids, p.getProductId());
					}
					int main = setProductRelations(ids);

					for (ProductRelationPo p : pos) {
						p.setMainProductId(main);
						if (p.getProductId() == main) {
							p.setMainProductId(null);
						}
					}
					productRelationDao.mergeObject(pos);
				}
			}

		} else {
			// 如果只剩下一个商品，则删除关联关系
			List<Integer> pos = this.getProductRelationIds(new int[] { po.getMainProductId() });
			if (CollectionUtils.isNotEmpty(pos) && pos.size() == 2) {
				productRelationDao.deleteObject(this.getProductRelationPo(po.getMainProductId()));
			}
		}
		productRelationDao.deleteObject(po);

	}

	/**
	 * 关系对象
	 * 
	 * @param productId
	 * @return
	 */
	private ProductRelationPo getProductRelationPo(int productId) {
		String hql = "from ProductRelationPo where productId=?";
		ProductRelationPo po = productRelationDao.findByHql(hql, productId);
		return po;
	}

	/**
	 * 关系对象
	 * 
	 * @param productId
	 * @return
	 */
	public ProductRelation getProductRelation(int productId) {
		String hql = "from ProductRelationPo where productId=?";
		ProductRelationPo po = productRelationDao.findByHql(hql, productId);
		if (po != null) {
			return BeanUtils.copyProperties(po, ProductRelation.class);
		}
		return null;
	}

	@Override
	public List<ProductRelation> getProductRelationsAndP(int productId) {
		List<ProductRelationPo> pos = this.getChildAndPByP(productId);
		if (CollectionUtils.isNotEmpty(pos))
			return BeanUtils.copyList(pos, ProductRelation.class);
		return null;
	}

	@Override
	public List<ProductRelation> getProductRelations(int productId) {
		List<ProductRelationPo> pos = this.getChildByP(productId);
		if (CollectionUtils.isNotEmpty(pos))
			return BeanUtils.copyList(pos, ProductRelation.class);
		return null;
	}

	/**
	 * 选择主商品，主产品为混装商品，如果无混装，则按照PH上传时间正序取主商品；
	 * 
	 * @param productIds
	 */
	private int setProductRelations(int[] productIds) throws BussinessException {
		String param = CollectionUtils.array2List(productIds).toString();
		StringBuilder sql = new StringBuilder("SELECT * FROM dbo.product WHERE id IN ( ");
		sql.append(param.substring(1, param.length() - 1)).append(") ORDER BY ph_product_id ASC ");
		List<ProductPo> pos = productDao.findListBySql(sql.toString(), null);
		for (int i = 0; i < pos.size(); i++) {
			ProductPo po = pos.get(i);
			if (po.isStatus()) {
				throw new BussinessException("id为" + po.getId() + "的商品" + po.getCmsProductCode() + "的状态是：已挑选");
			}
			if (po.getIsMix() > 0) {
				return po.getId();
			}
		}

		return pos.get(0).getId();
	}

	/**
	 * 根据主商品获取副商品，包含自己。
	 * 
	 * @param productId
	 * @return
	 */
	private List<ProductRelationPo> getChildAndPByP(int productId) {
		String hql = "from ProductRelationPo where mainProductId=? or productId=?";
		return productRelationDao.findListByHql(hql, new Object[] { productId, productId });
	}

	/**
	 * 根据主商品获取副商品，不包含自己。
	 * 
	 * @param productId
	 * @return
	 */
	private List<ProductRelationPo> getChildByP(int productId) {
		String hql = "from ProductRelationPo where mainProductId=?";
		return productRelationDao.findListByHql(hql, productId);
	}

	/**
	 * 获取这个商品的当前锁定部门
	 * 
	 * @param productId
	 * @return
	 */
	private ProductFreezeStockPo getOtherFreezeInfoByThisProduct(int productId, String code) {
		String hql = "from ProductFreezeStockPo where cmsProductCode=? and productId<>? and currentFreeze=true";
		return productFreezeDao.findByHql(hql, new Object[] { code, productId });
	}

	@Override
	public void updateSafertyStock(int productId, int qty, int operator) throws BussinessException {
		String hql = "from ProductFreezeStockPo where productId=?";
		ProductFreezeStockPo po = productFreezeDao.findByHql(hql, productId);
		/**
		 * 2017-03-25
		 * 自动取消没有销量的商品的冻结库存，导致更新时冻结数据已被删除
		 */
		if(po==null){
			ProductPo p= this.productDao.getObject(productId);
			if(p!=null)
				freezeStock(productId, qty, operator, p.getCmsProductCode());
			return ;
		}
		po.setShouldQty(qty);
		po.setOperator(operator);

		boolean isUpdate = false;

		// 判断商品是否需要发起cms3锁定请求
		if (po.isCurrentFreeze()) {
			// 判断最大值
			isUpdate = true;
		} else {
			ProductFreezeStockPo po2 = getOtherFreezeInfoByThisProduct(productId, po.getCmsProductCode());
			if (po2.getShouldQty() < qty) {
				isUpdate = true;
				po2.setCurrentFreeze(false);
				productFreezeDao.mergeObject(po2);
			}
		}

		if (isUpdate) {
			po.setCurrentFreeze(true);
			// 调用cms接口更新锁库存……
			CMSClient.blockedStock(po.getCmsProductCode(), qty,profileService.getUserNameById(operator));
		}
		productFreezeDao.mergeObject(po);
		// 记录操作日志……
		systemService.addProductOperatorLog(LogType.UPDATE_SAFETY_STOCK.ordinal(), productId,
				"更新cms商品" + po.getCmsProductCode() + "锁定库存为：" + qty, operator);
	}

	@Override
	public void mergeProductRelation(int[] productIds, int operator) throws BussinessException {
		// 获取相关商品
		List<Integer> ids = getProductRelationIds(productIds);
		// 如果没有关系
		int newId[] = ArrayUtils.addAll(CollectionUtils.list2Array(ids), productIds);

		int main = setProductRelations(newId);
		for (int p : newId) {
			ProductRelationPo po = this.getProductRelationPo(p);
			if (po == null) {
				po = new ProductRelationPo();
				po.setProductId(p);
			}
			po.setMainProductId(main);
			if (po.getProductId() == main) {
				po.setMainProductId(null);
			}
			productRelationDao.mergeObject(po);
		}
		systemService.addProductOperatorLog(LogType.MERGE_PRODUCT_RELATION.ordinal(), null,
				"归并商品" + CollectionUtils.array2List(productIds), operator);
	}

	/**
	 * 获取商品相关商品的IDS
	 * 
	 * @param productIds
	 * @return
	 */
	private List<Integer> getProductRelationIds(int[] productIds) throws BussinessException {
		if (productIds.length > 0) {
			StringBuilder sql = new StringBuilder("SELECT DISTINCT * FROM dbo.product_relation");
			sql.append(" WHERE main_product_id IN  (select ISNULL(main_product_id,product_id) "
					+ " from product_relation where product_id in (");
			String params = CollectionUtils.array2List(productIds).toString();
			String sub = params.substring(1, params.length() - 1);
			sql.append(sub)
					.append(" )) or product_id IN  (select ISNULL(main_product_id,product_id) "
							+ " from product_relation where product_id IN (").append(sub).append("))");
			List<ProductRelationPo> pos = productRelationDao.findListBySql(sql.toString(), null);
			if (CollectionUtils.isNotEmpty(pos)) {
				List<Integer> integers = new ArrayList<Integer>();
				for (ProductRelationPo po : pos) {
					integers.add(po.getProductId());
				}
				return integers;
			}
		}
		return null;
	}

	@Override
	public void setMainProduc(int productId, int operator) throws BussinessException {
		// //判断商品已挑选
		// if(this.getProductPo(productId).isStatus())
		// throw new BussinessException("商品状态为已挑选！");
		ProductRelation pr = this.getProductRelation(productId);
		if (pr == null)
			throw new BussinessException("商品没有其他关联商品！");
		if (pr.getMainProductId() == null)
			throw new BussinessException("商品已经是主商品了！");
		int main = pr.getMainProductId();
		List<ProductRelationPo> pos = this.getChildAndPByP(main);
		if (CollectionUtils.isNotEmpty(pos)) {
			for (ProductRelationPo po : pos) {
				ProductPo ppo = this.getProductPo(po.getProductId());
				if (ppo == null) {
					continue;
				}
				if (ppo.isStatus())
					throw new BussinessException("id为" + po.getProductId() + "的商品" + ppo.getCmsProductCode()
							+ "的状态是：已挑选");
				po.setMainProductId(productId);
				if (po.getProductId() == productId) {
					po.setMainProductId(null);
				}
			}
			productRelationDao.mergeObject(pos);
		}
		systemService.addProductOperatorLog(LogType.SET_MAIN_PRODUCT.ordinal(), productId, "设置商品为主商品！", operator);
	}

	@Override
	public void cancelProductRelation(int productId) throws BussinessException {
		Product pp = getProduct(productId);
		if (pp != null && !pp.isStatus()) {
			deleteProductRelation(productId);
			return;
		}
		throw new BussinessException("已挑选的商品不能取消关联！");
	}

	@Override
	public List<Batch> getBatchs(int departmentId) {
		String hql = "from BatchPo order  where departmentId=? order by id desc";
		List<BatchPo> pos = batchDao.findListByHql(hql, departmentId);
		if (CollectionUtils.isNotEmpty(pos)) {
			return BeanUtils.copyList(pos, Batch.class);
		}
		return null;
	}

	private List<ProductPictureCollectionPO> getPics(int productId) {
		String hql = "from ProductPictureCollectionPO where productId=?";
		return productPictureCollectionDAO.findListByHql(hql, productId);
	}

	@Override
	public List<ProductPicture> getProductPictures(int productId) {
		List<ProductPictureCollectionPO> pos = getPics(productId);
		if (CollectionUtils.isNotEmpty(pos))
			return BeanUtils.copyList(pos, ProductPicture.class);
		return null;
	}

	@Override
	public List<ProductPicture> getCMSProductPictureByProduct(int cmsProductId) {
		return CMSClient.getProductPictureByProduct(cmsProductId);
	}

	@Override
	public boolean isExistProduct(String cmsProductCode, int departmentId) {
		String hql = "from ProductPo where cmsProductCode=? and departmentId=?";
		ProductPo po = productDao.findByHql(hql, new Object[] { cmsProductCode, departmentId });
		if (po != null) {
			return true;
		}
		return false;
	}

	@Override
	public PHProductCostPriceVO getPHProductCostPriceVO(List<String> productCodes, String version)
			throws BussinessException {
		if (CollectionUtils.isEmpty(productCodes))
			return null;

		PHProductCostPriceVO vo = new PHProductCostPriceVO();
		
		//CMS
		Map<Integer, BigDecimal> weightRate=new HashMap<Integer, BigDecimal>();
		List<CMSProduct> cmsProducts = CMSClient.getCMSProductByCodes(productCodes);
		if (CollectionUtils.isEmpty(cmsProducts)) {
			vo.setMessage(MessageFormat.format("{0}在cms中不存在!", productCodes.toString()));
			return vo;
		}
		List<CurrencyExchangeRate> rates = systemService.getCurrentExchangeRate(version);
		// 消息
		StringBuilder _exist_msg = new StringBuilder();
		StringBuilder _offline_msg = new StringBuilder();
		StringBuilder _false_msg = new StringBuilder();
		// 不存在
		if (cmsProducts.size() != productCodes.size()) {
			List<String> _not_exist = CollectionUtils.sub(productCodes, cmsProducts,
					new Equaltor<String, CMSProduct>() {
						@Override
						public boolean equal(String o1, CMSProduct o2) {
							return o1.equals(o2.getCode());
						}
					});
			_exist_msg.append( _not_exist.toString());
		}

		List<PHProductCostPrice> PHProductCostPrices = new ArrayList<PHProductCostPrice>();

		PHProductCostPrice phProductCostPrice = null;
		boolean save = true;
		
		for (CMSProduct cms : cmsProducts) {
			save = true;
			if (cms.getOfflineStatus() == 2) {
				_offline_msg.append(cms.getCode()).append(",");
				save = false;
			}

			if (cms.getPhProductId() < 1) {
				_false_msg.append(cms.getCode()).append(",");
				save = false;
			}

			if (save) {
				phProductCostPrice = convertCMSProduct2PHProductCostPrice(cms,weightRate);
				PHProductCostPrices.add(phProductCostPrice);
				
			}
			
		}
		//基础配置
		List<BaseProductCostPriceConfig>  _source_config=baseProductCostPriceService.getBaseProductCostPriceConfigs();
		if(CollectionUtils.isNotEmpty(_source_config)&&PHProductCostPrices.size()>0){
			//DMS请求参数
			List<BaseProductFreight> freights=new ArrayList<BaseProductFreight>();
			BaseProductFreight freight=null;
			for (PHProductCostPrice ph : PHProductCostPrices) {
				for (BaseProductCostPriceConfig cg : _source_config) {
					freight=new BaseProductFreight();
					freight.setWeight(ph.getWeight());
					freight.setCountyId(cg.getCountry());
					freight.setShippingMethod(cg.getShippingMethod());
					if(!freights.contains(freight)){
						freights.add(freight);
					}
				}
			}
			
			freights=DMSClient.getShippingAmounts(freights);
			
			//运费转换
			List<ProductFreight> productFreights=null;
			ProductFreight productFreight=null;
			for (PHProductCostPrice ph : PHProductCostPrices) {
				productFreights=new ArrayList<ProductFreight>();
				for (BaseProductCostPriceConfig cg : _source_config) {
					for (BaseProductFreight bf : freights) {
						if(bf.getWeight().compareTo(ph.getWeight())==0
								&&bf.getCountyId()==cg.getCountry()
								&&bf.getShippingMethod()==cg.getShippingMethod()){
							
							productFreight=new ProductFreight();
							productFreight.setCountry(cg.getCountry());
							productFreight.setCurrency(cg.getCurrency());
							productFreight.setProductCode(ph.getProductCode());
							
							if(bf.getAmount()!=null){
								productFreight.setFreight(exchangeCurrency2Other(rates,CurrencyUtils.RMB, bf.getAmount(), 
										cg.getCurrency()));//币种转换RMB2Other
							}
							productFreight.setWeight(ph.getWeight());
							productFreight.setShipping_method(bf.getShippingMethod());
							productFreights.add(productFreight);
							break;
						}
					}
				}
				
				ph.setProductFreight(productFreights);
			}
			
		}
		
		
		setMessage(vo, _exist_msg, _offline_msg,_false_msg);
		vo.setPHProductCostPrices(PHProductCostPrices);
		return vo;
	}
	
	private BigDecimal exchangeCurrency2Other(List<CurrencyExchangeRate> rates,int sourceCurrencyId, 
			BigDecimal amount, int tagCurrencyId)throws BussinessException {
		CurrencyExchangeRate source=null;
		CurrencyExchangeRate tag=null;
		for (CurrencyExchangeRate currencyExchangeRate : rates) {
			if(sourceCurrencyId==currencyExchangeRate.getCurrency()){
				source=currencyExchangeRate;
			}
			
			if(tagCurrencyId==currencyExchangeRate.getCurrency()){
				tag=currencyExchangeRate;
			}
		}
		return amount.multiply(source.getRate()).divide(tag.getRate(),3,4);
//		return tag.getRate().divide(source.getRate(),6,4).multiply(amount).setScale(3, 4);
	}

	private void setMessage(PHProductCostPriceVO vo, StringBuilder _exist_msg, StringBuilder _offline_msg,
			StringBuilder _false_msg) {
		StringBuilder msg = new StringBuilder();
		if (_offline_msg.length() > 0) {
			_offline_msg.append("已永久下架/");
			msg.append(_offline_msg);
		}

		if (_exist_msg.length() > 0) {
			_exist_msg.append("在c3中不存在/");
			msg.append(_exist_msg);
		}
		if (_false_msg.length() > 0) {
			_false_msg.append("为非ph产品");
			msg.append(_false_msg);
		}

		if (msg.length() > 0) {
			vo.setMessage(MessageFormat.format("商品{0}", msg.toString()));
		}
	}

	private PHProductCostPrice convertCMSProduct2PHProductCostPrice(CMSProduct cms,Map<Integer, BigDecimal> weightRate) {
		PHProductCostPrice phProductCostPrice;
		phProductCostPrice = new PHProductCostPrice();
		phProductCostPrice.setProductCode(cms.getCode());
		phProductCostPrice.setContent(cms.getDescription());
		phProductCostPrice.setCostPrice(cms.getCostPrice().multiply(new BigDecimal(cms.getUnitQuantity())));
		phProductCostPrice.setPhSale(cms.getPhSalePrice());
		phProductCostPrice.setTitle(cms.getName());
		//重量
		int cateId=cms.getCategoryId3()==0?cms.getCategoryId2():cms.getCategoryId3();
		BigDecimal _weight_rate=new BigDecimal(1);
		if(weightRate.containsKey(cateId)){
			_weight_rate=weightRate.get(cateId);
		}else{
			Category category= CMSClient.getCategoryById(cateId);
			if(category!=null){
				_weight_rate=category.getWeightRate();
			}
			weightRate.put(cateId, _weight_rate);
		}
		phProductCostPrice.setWeight(cms.getWeight().
				multiply(new BigDecimal(cms.getUnitQuantity())).
				multiply(_weight_rate).setScale(2, 4));
		return phProductCostPrice;
	}

	
	@Override
	public void autoCancelFreezeStock() {
		List<Param> params=new ArrayList<Param>();
		Date today=new Date();
		params.add(new Param("endDate ", today));
		params.add(new Param("startDate", org.apache.commons.lang.time.DateUtils.addDays(DateUtils.getRealDate(today),
				-30)));
		List<String> cmsProductCodes=productDao.getSimpleColumnByStoredProcedure("dbo.p_statistic_product_freeze_stock_and_no_sales", 
				params );
		
		if(CollectionUtils.isNotEmpty(cmsProductCodes)){
			for (String cmsProductCode : cmsProductCodes) {
				List<ProductFreezeStockPo> stockPos = getFreezeStockPoByproductId(cmsProductCode);
				//通知cms释放库存
				try {
					CMSClient.cancelFreezeStock(cmsProductCode,"OSMS");
				} catch (Exception e) {
					e.printStackTrace();
				}
				this.productFreezeDao.deleteObjects(stockPos);
			}
			
		}
	}
	
	@Override
	public List<OsmsStock> getOsmsStocks(List<Integer> productIds) {
		List<Integer> cmsProductIds=new ArrayList<Integer>();
		for (Integer productId : productIds) {
			ProductPo po=this.productDao.getObject(productId);
			cmsProductIds.add(po.getCmsProductId());
		}
		Map<Integer, OsmsStock> map=CMSClient.getOsmsStocks(cmsProductIds);
		List<OsmsStock> os=new ArrayList<OsmsStock>();
		for (Integer productId : cmsProductIds) {
			os.add(map.get(productId));
		}
		return os;
	}
	
	@Override
	public void updateDepartmentalStock(List<UpdateStockParam> stocks, UpdateStockHandle handle, int operator)
			throws BussinessException {
		List<Integer> cmsProductIds=new ArrayList<Integer>();
		for (UpdateStockParam updateStockParam : stocks) {
//			ProductPo po=this.productDao.getObject(updateStockParam.getProductId());
			cmsProductIds.add(updateStockParam.getCmsProductId());
		}
	    Map<Integer, OsmsStock> map=CMSClient.getOsmsStocks(cmsProductIds);
	    
	    if(handle==UpdateStockHandle.CONVERT)
	    	convertStock(stocks, map,profileService.getUserNameById(operator));
	    else if(handle==UpdateStockHandle.SHARE)
	    	shareStock(stocks, map,profileService.getUserNameById(operator));
	    	
	}
	
	private void convertStock(List<UpdateStockParam> stocks, Map<Integer, OsmsStock>  map,String operater){
		for (UpdateStockParam u : stocks) {
			OsmsStock o=map.get(u.getCmsProductId());
			if(u.getFbaStockQty().intValue()<o.getFbaStock().intValue()){
				
				CMSClient.exchangeStorage(u.getCmsProductId(), ExchangeStorageTypeOsms.fba库存,
						o.getFbaStock().intValue()-u.getFbaStockQty().intValue(),
						ExchangeTargetStorageTypeOsms.自卖单库存,operater);
			}
			else if(u.getSellingOrderStockQty().intValue()<o.getOrderStock().intValue()){
				CMSClient.exchangeStorage(u.getCmsProductId(), ExchangeStorageTypeOsms.自卖单库存,
						o.getOrderStock().intValue()-u.getSellingOrderStockQty().intValue(),
						ExchangeTargetStorageTypeOsms.fba库存,operater);
			}
		}
	}
	
	private void shareStock(List<UpdateStockParam> stocks, Map<Integer, OsmsStock>  map,String operater){
		for (UpdateStockParam u : stocks) {
			OsmsStock o=map.get(u.getCmsProductId());
			if(u.getFbaStockQty().intValue()<o.getFbaStock().intValue()){
				
				CMSClient.exchangeStorage(u.getCmsProductId(), ExchangeStorageTypeOsms.fba库存,
						o.getFbaStock().intValue()-u.getFbaStockQty().intValue(),
						ExchangeTargetStorageTypeOsms.共享库存,operater);
			}
			if(u.getSellingOrderStockQty().intValue()<o.getOrderStock().intValue()){
				CMSClient.exchangeStorage(u.getCmsProductId(), ExchangeStorageTypeOsms.自卖单库存,
						o.getOrderStock().intValue()-u.getSellingOrderStockQty().intValue(),
						ExchangeTargetStorageTypeOsms.共享库存,operater);
			}
		}
	}
	
}
