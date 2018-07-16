package com.itecheasy.core.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.itecheasy.common.dao.Criteria;
import com.itecheasy.common.dao.Order.OrderType;
import com.itecheasy.common.dao.Restriction;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.CollectionUtils.Equaltor;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.po.AMShopProductPo;
import com.itecheasy.core.po.MerchandiserPO;
import com.itecheasy.core.po.ShopDevInfoPO;
import com.itecheasy.core.po.ShopInfoPo;
import com.itecheasy.core.po.ShopPo;
import com.itecheasy.core.po.ShopRelationPO;
import com.itecheasy.core.po.ShopSalesTargetPO;
import com.itecheasy.core.po.UserShopPo;
import com.itecheasy.core.product.dao.AMShopProductDao;
import com.itecheasy.core.system.dao.MerchandiserDao;
import com.itecheasy.core.system.dao.ShopDao;
import com.itecheasy.core.system.dao.ShopDevInfoDao;
import com.itecheasy.core.system.dao.ShopInfoDao;
import com.itecheasy.core.system.dao.ShopRelationDao;
import com.itecheasy.core.system.dao.ShopSalesTargetDao;
import com.itecheasy.core.system.dao.UserShopDao;
import com.itecheasy.webservice.client.CMSClient;
import com.itecheasy.webservice.cms.User;

/**
 * @author wanghw
 * @date 2015-6-16
 * @description 
 * @version
 */
public class ShopServiceImpl implements ShopService {
	private static final String USER_NOT_EXIST_CMS = "订单处理人在cms系统中不不存在，请联系cms添加用户！";
	private UserShopDao userShopDao;
	private ShopRelationDao shopRelationDao;
	private ShopDao shopDao;
	private ShopInfoDao shopInfoDao;
	private ShopDevInfoDao shopDevInfoDao;
	private AMShopProductDao amShopProductDao;
	private MerchandiserDao merchandiserDao;
	private SystemService systemService;
	
	private ShopSalesTargetDao shopSalesTargetDao;

	public void setShopSalesTargetDao(ShopSalesTargetDao shopSalesTargetDao) {
		this.shopSalesTargetDao = shopSalesTargetDao;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public void setMerchandiserDao(MerchandiserDao merchandiserDao) {
		this.merchandiserDao = merchandiserDao;
	}

	public void setAmShopProductDao(AMShopProductDao amShopProductDao) {
		this.amShopProductDao = amShopProductDao;
	}

	public void setShopDevInfoDao(ShopDevInfoDao shopDevInfoDao) {
		this.shopDevInfoDao = shopDevInfoDao;
	}

	public void setShopInfoDao(ShopInfoDao shopInfoDao) {
		this.shopInfoDao = shopInfoDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	public void setShopRelationDao(ShopRelationDao shopRelationDao) {
		this.shopRelationDao = shopRelationDao;
	}

	public void setUserShopDao(UserShopDao userShopDao) {
		this.userShopDao = userShopDao;
	}

	@Override
	public int addShop(Shop shop) throws BussinessException {
		if (shop != null) {
			//  同一平台，同一语种下的店铺名称不允许重名
			String hql = "select s from ShopPo s ,ShopInfoPo i where i.shopId=s.id and  s.type=? and i.language=? and s.name=?";

			List<ShopPo> pos = shopDao.findListByHql(hql,
					new Object[] { shop.getType(), shop.getLanguage(), shop.getName() });
			if (CollectionUtils.isNotEmpty(pos)) {
				throw new BussinessException("同一平台，同一语种下的店铺名称不允许重名");
			}

			ShopPo shopPo = new ShopPo();
			BeanUtils.copyProperties(shop, shopPo, new String[] { "id" });
			shopPo.setEnable(true);
			int shopId = shopDao.addObject(shopPo);

			User cmsuser = CMSClient.getUserByCode(shop.getMerchandiserId());
			if (cmsuser == null) {
				throw new BussinessException(USER_NOT_EXIST_CMS);
			}
			existMerchandiser(cmsuser);
			ShopInfoPo infoPo = new ShopInfoPo();
			BeanUtils.copyProperties(shop, infoPo, new String[] { "id","currency" });
			infoPo.setShopId(shopId);
			if(shopPo.getCurrency()>0){
				infoPo.setCurrency(systemService.getCurrency(shopPo.getCurrency()).getCode());
			}
			List<OrderSource>  os=systemService.getOrderSource(shop.getType());
			if(CollectionUtils.isNotEmpty(os)){
				infoPo.setShopSource(os.get(0).getId());
			}

			shopInfoDao.addObject(infoPo);

			return shopId;
		}
		return -1;
	}

	@Override
	public void addRelations(List<ShopRelation> relations) {
		if (CollectionUtils.isNotEmpty(relations)) {
			for (ShopRelation shopRelation : relations) {
				ShopRelationPO po = new ShopRelationPO();
				BeanUtils.copyProperties(shopRelation, po, new String[] { "id" });
				if (shopRelation.getShop1() < shopRelation.getShop2()) {
					po.setShop1(shopRelation.getShop2());
					po.setShop2(shopRelation.getShop1());
				}
				shopRelationDao.addObject(po);
			}
		}
	}

	@Override
	public void setShop2user(int user, List<Integer> shopIds) {
		String hql = "from UserShopPo where userId=?";
		List<UserShopPo> pos = userShopDao.findListByHql(hql, user);
		List<Integer> add = CollectionUtils.sub(shopIds, pos, new Equaltor<Integer, UserShopPo>() {
			public boolean equal(Integer o1, UserShopPo o2) {
				return o1.equals(o2.getShopId());
			};
		});

		List<UserShopPo> delete = CollectionUtils.sub(pos, shopIds, new Equaltor<UserShopPo, Integer>() {
			public boolean equal(UserShopPo o1, Integer o2) {
				return o1.getShopId() == o2;
			}
		});

		for (Integer shopId : add) {
			UserShopPo po = new UserShopPo();
			po.setUserId(user);
			po.setShopId(shopId);
			userShopDao.addObject(po);
		}

		if (CollectionUtils.isNotEmpty(delete)) {
			userShopDao.deleteObjects(delete);
		}
	}

	
	@Override
	public void setUser2shop(int shopId, List<Integer> userIds) {
		String hql = "from UserShopPo where shopId=?";
		List<UserShopPo> pos = userShopDao.findListByHql(hql, shopId);
		List<Integer> add = CollectionUtils.sub(userIds, pos, new Equaltor<Integer, UserShopPo>() {
			public boolean equal(Integer o1, UserShopPo o2) {
				return o1.equals(o2.getUserId());
			};
		});

		List<UserShopPo> delete = CollectionUtils.sub(pos, userIds, new Equaltor<UserShopPo, Integer>() {
			public boolean equal(UserShopPo o1, Integer o2) {
				return o1.getUserId() == o2;
			}
		});

		for (Integer userId : add) {
			UserShopPo po = new UserShopPo();
			po.setUserId(userId);
			po.setShopId(shopId);
			userShopDao.addObject(po);
		}

		if (CollectionUtils.isNotEmpty(delete)) {
			userShopDao.deleteObjects(delete);
		}
	}

	
	@Override
	public List<Shop> getRelationShop(int shopId, int type) {
		String hql = "SELECT DISTINCT s.id ,  s.name , s.type , s.department ,  "
				+ "s.shop_dev_info_id as shopDevInfoId,  s.enable ,i.language "
				+ " FROM dbo.shop s inner join dbo.shop_info i on i.shop_id=s.id INNER JOIN dbo.shop_relation r "
				+ "ON ((r.shop1=s.id AND r.shop2=?)OR (r.shop2=s.id AND r.shop1=?)) " + "WHERE r.type=?";
		List<Object> params = new ArrayList<Object>();
		params.add(shopId);
		params.add(shopId);
		params.add(type);
		List<Shop> pos = shopDao.findListBySql(hql, params, Shop.class);
		return pos;
	}

	@Override
	public List<Integer> getCorrelationShop(int shopId) {
		String hql = "SELECT DISTINCT s.* FROM dbo.shop s INNER JOIN dbo.shop_relation r "
				+ "ON ((r.shop1=s.id AND r.shop2=?) OR (r.shop2=s.id AND r.shop1=?)) " + "WHERE r.type=1";
		List<Object> params = new ArrayList<Object>();
		params.add(shopId);
		params.add(shopId);
		List<ShopPo> pos = shopDao.findListBySql(hql, params);
		List<Integer> ids = null;
		if (CollectionUtils.isNotEmpty(pos)) {
			ids = new ArrayList<Integer>();
			for (ShopPo po : pos) {
				ids.add(po.getId());
			}
		}

		return ids;
	}

	@Override
	public List<ShopDevInfo> getAllAccount() {
		Criteria criteria = new Criteria(ShopDevInfoPO.class);
		criteria.order("name", OrderType.asc);
		List<ShopDevInfoPO> pos = shopDevInfoDao.list(criteria);
		if (CollectionUtils.isNotEmpty(pos)) {
			return BeanUtils.copyList(pos, ShopDevInfo.class);
		}
		return null;
	}
	
	@Override
	public List<ShopDevInfo> getAllAccount(int shopType) {
		Criteria criteria = new Criteria(ShopDevInfoPO.class);
		criteria.and(Restriction.eq("type", shopType));
		criteria.order("name", OrderType.asc);
		List<ShopDevInfoPO> pos = shopDevInfoDao.list(criteria);
		if (CollectionUtils.isNotEmpty(pos)) {
			return BeanUtils.copyList(pos, ShopDevInfo.class);
		}
		return null;
	}
	
	@Override
	public List<ShopDevInfo> getJointAccount(int shopType) {
		Criteria criteria = new Criteria(ShopDevInfoPO.class);
		criteria.and(Restriction.eq("type", shopType));
		criteria.and(Restriction.eq("pause", false));
		criteria.order("name", OrderType.asc);
		List<ShopDevInfoPO> pos = shopDevInfoDao.list(criteria);
		if (CollectionUtils.isNotEmpty(pos)) {
			return BeanUtils.copyList(pos, ShopDevInfo.class);
		}
		return null;
	}

	public ShopDevInfo getAccount(int shopId){
		ShopPo po= shopDao.getObject(shopId);
		ShopDevInfoPO info=shopDevInfoDao.getObject(po.getShopDevInfoId());
		if (info!=null) {
			return BeanUtils.copyProperties(info, ShopDevInfo.class);
		}
		return null;
	}
	
	@Override
	public void setShopEnable(int shop, boolean enable) throws BussinessException {
		ShopPo po = shopDao.getObject(shop);
		if (po != null) {
			if (enable) {
				// 设为可用
				if (!po.isEnable()) {
					po.setEnable(true);
				}
			} else {
				// 设为不可用
				if (po.isEnable()) {
					// 检查是否店铺的所有的商品是 下架状态
					Criteria criteria = new Criteria(AMShopProductPo.class);
					criteria.and(Restriction.eq("shopId", shop));
					criteria.and(Restriction.eq("shelveStatus", true));

					int count = amShopProductDao.getCount(criteria);

					if (count > 0) {
						throw new BussinessException("该店铺有上架的商品，请先将商品下架");
					}
					po.setEnable(false);
				}
			}
			shopDao.mergeObject(po);
		}
	}

	@Override
	public List<ShopVO> getShopList(ShopSearchForm form) {
		String sql = "SELECT  s.id  AS id,        s.name AS shopName,        i.language,   s.department ,     "
				+ "s.type ,        enable ,        d.name AS accountName,        u.name as orderUserName,i.fill_state as fillState ," +
				" i.customer_id as customerId,s.currency " +
				" FROM dbo.shop s "
				+ " left JOIN dbo.shop_dev_info d ON s.shop_dev_info_id=d.id " +
				" left JOIN dbo.shop_info i "
				+ "ON i.shop_id=s.id   " +
				" left JOIN dbo.[user] u " + 
				"ON i.merchandiser_id=u.code and u.disabled=0 ";
		StringBuilder where = new StringBuilder(" where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (form.getType() > -1) {
			where.append(" AND s.type=? ");
			params.add(form.getType());
		}

		if (form.getDepartment() > -1) {
			where.append(" AND s.department=? ");
			params.add(form.getDepartment());
		}

		if (StringUtils.isNotEmpty(form.getShopName())) {
			where.append(" AND s.name like ? ");
			params.add("%" + form.getShopName() + "%");
		}

		if (form.getLanguage() > -1) {
			where.append(" AND i.language=? ");
			params.add(form.getLanguage());
		}
		List<ShopVO> vo = shopDao.findListBySql(sql + where.toString() + " order by s.id desc ", params, ShopVO.class);

		if (CollectionUtils.isNotEmpty(vo)) {
			for (ShopVO shopVO : vo) {
				shopVO.setCompeteShop(this.getRelationShop(shopVO.getId(), 1));
				shopVO.setCorrelationShop(this.getRelationShop(shopVO.getId(), 0));
				shopVO.setUsers(systemService.getUsersByShopId(shopVO.getId()));
			}
		}

		return vo;
	}

	@Override
	public void setMerchandiserById(int shopId, String userCode) throws BussinessException {
		if (StringUtils.isEmpty(userCode) || !userCode.contains("ite")) {
			throw new BussinessException(USER_NOT_EXIST_CMS);
		}
		User cmsuser = CMSClient.getUserByCode(userCode);
		if (cmsuser == null) {
			throw new BussinessException(USER_NOT_EXIST_CMS);
		}
		existMerchandiser(cmsuser);

		Criteria criteria = new Criteria(ShopInfoPo.class);
		criteria.and(Restriction.eq("shopId", shopId));
		ShopInfoPo po = shopInfoDao.get(criteria);
		if (po != null) {
			po.setMerchandiserId(userCode);
			shopInfoDao.mergeObject(po);
		}
	}

	private void existMerchandiser(User cmsuser) {
		MerchandiserPO po = merchandiserDao.getObject(cmsuser.getId());
		if (po == null) {
			po = new MerchandiserPO();
			po.setMerchandiserEmail(cmsuser.getEmail());
			po.setMerchandiserName(cmsuser.getName());
			po.setId(cmsuser.getId());
			po.setCode(cmsuser.getCode());
			merchandiserDao.addObject(po);
		}
	}

	@Override
	public List<Shop> getAvailableShops() {
		Criteria criteria = new Criteria(ShopPo.class);
		criteria.order("name", OrderType.asc);
		criteria.and(Restriction.eq("enable", true));
		List<ShopPo> pos = shopDao.list(criteria);
		if (CollectionUtils.isNotEmpty(pos)) {
			return BeanUtils.copyList(pos, Shop.class);
		}
		return null;
	}
	
	public List<Shop> getAvailableShopsByDevAccount(int devId){
		Criteria criteria = new Criteria(ShopPo.class);
		criteria.order("name", OrderType.asc);
		criteria.and(Restriction.eq("enable", true));
		criteria.and(Restriction.eq("shopDevInfoId", devId));
		List<ShopPo> pos = shopDao.list(criteria);
		if (CollectionUtils.isNotEmpty(pos)) {
			return BeanUtils.copyList(pos, Shop.class);
		}
		return null;
	}

	@Override
	public void updateShop(Shop shop) throws BussinessException {
		ShopPo po = shopDao.getObject(shop.getId());
		if (po != null) {
			// 同一平台，同一语种下的店铺名称不允许重名
			String hql = "select s from ShopPo s ,ShopInfoPo i where i.shopId=s.id and " +
					" s.type=? and i.language=? and s.name=? and s.id!=?";
			ShopInfo info= systemService.getShopInfo(po.getId());
			List<ShopPo> pos = shopDao.findListByHql(hql,
					new Object[] { po.getType(), info.getLanguage(), shop.getName(),po.getId() });
			if (CollectionUtils.isNotEmpty(pos)) {
				throw new BussinessException("同一平台，同一语种下的店铺名称不允许重名");
			}
			po.setName(shop.getName());
			
			if(info.isFillState()!=shop.isFillState()){
				ShopInfoPo infoPo= this.shopInfoDao.getObject(info.getId());
				infoPo.setFillState(shop.isFillState());
				this.shopInfoDao.mergeObject(infoPo);
			}
			shopDao.mergeObject(po);
		}
	}

	@Override
	public void setSalesTargets(List<SalesTarget> salesTargets) {
		if(CollectionUtils.isEmpty(salesTargets)){
			return ;
		}
		
		Date current=new Date();
		for (SalesTarget salesTarget : salesTargets) {
			ShopSalesTargetPO po=getSalesTargetPOByShopId(salesTarget.getVersion(), salesTarget.getShopId());
			if(po==null){
				po=new ShopSalesTargetPO();
				po.setShopId(salesTarget.getShopId());
				po.setVersion(salesTarget.getVersion());
			}
			po.setProfitRate(salesTarget.getProfitRate());
			po.setSalesTargetOfALevel(salesTarget.getSalesTargetOfALevel());
			po.setSalesTargetOfBLevel(salesTarget.getSalesTargetOfBLevel());
			po.setUpdateDate(current);
			shopSalesTargetDao.mergeObject(po);
		}
	}

	@Override
	public List<SalesTarget> getSalesTargets(String version) {
		String hql="from ShopSalesTargetPO where version=?";
		List<ShopSalesTargetPO> pos= shopSalesTargetDao.findListByHql(hql, version);
		if(CollectionUtils.isNotEmpty(pos)){
			return BeanUtils.copyList(pos, SalesTarget.class);
		}
		return null;
	}
	
	private ShopSalesTargetPO getSalesTargetPOByShopId(String version, int shopId){
		String hql="from ShopSalesTargetPO where version=? and shopId=?";
		return  shopSalesTargetDao.findByHql(hql, 
				new Object[]{version,shopId});
	}

	@Override
	public SalesTarget getSalesTargetByShopId(String version, int shopId) {
		ShopSalesTargetPO po= getSalesTargetPOByShopId(version, shopId);
		if(po!=null){
			return BeanUtils.copyProperties(po, SalesTarget.class);
		}
		return null;
	}
	
	@Override
	public List<SalesTarget> getSalesTargetByShopId(String version, int[] shopId) {
		String sql="SELECT" +
				" name AS shopName," +
				" shop.id AS shopId," +
				" version ," +
				" dbo.shop_sales_target.profit_rate AS profitRate," +
				" dbo.shop_sales_target.sales_target_A_level AS salesTargetOfALevel," +
				" dbo.shop_sales_target.sales_target_B_level AS salesTargetOfBLevel" +
				" FROM dbo.shop" +
				" LEFT JOIN dbo.shop_sales_target" +
				" ON shop_id=dbo.shop.id and version=? " +
				" where 1=1 ";
		
		List<Object> params=new ArrayList<Object>();
		if(shopId!=null&&shopId.length>0){
			String ids=CollectionUtils.array2List(shopId).toString();
			sql=sql+" and shop.id in ( "+ids.substring(1, ids.length()-1)+" )";
		}
		params.add(version);
		return shopSalesTargetDao.findListBySql(sql, params, SalesTarget.class);
	}
}
