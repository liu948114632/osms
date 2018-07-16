package com.itecheasy.core.fba;

import java.util.ArrayList;
import java.util.List;

import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.dao.RepositoryDao;
import com.itecheasy.core.fba.dao.RepositoryShopDao;
import com.itecheasy.core.po.RepositoryPO;
import com.itecheasy.core.po.RepositoryShopPO;
import com.itecheasy.core.user.ProfileService;

/** 
 * @author wanghw
 * @date 2016-12-2 
 * @description TODO
 * @version 1.2.2
 */
public class RepositoryServiceImpl implements RepositoryService {
	private RepositoryDao repositoryDao;
	private RepositoryShopDao repositoryShopDao;
	private ReplenishmentOrderService replenishmentOrderService;
	private ProfileService profileService;
	

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setReplenishmentOrderService(ReplenishmentOrderService replenishmentOrderService) {
		this.replenishmentOrderService = replenishmentOrderService;
	}

	public void setRepositoryDao(RepositoryDao repositoryDao) {
		this.repositoryDao = repositoryDao;
	}

	public void setRepositoryShopDao(RepositoryShopDao repositoryShopDao) {
		this.repositoryShopDao = repositoryShopDao;
	}

	@Override
	public void mergeRepository(Repository repository,int operator)throws BussinessException {
		RepositoryPO po=BeanUtils.copyProperties(repository, RepositoryPO.class);
		String hql="from RepositoryPO where repositoryName=? and id!=?";
		
		if(repositoryDao.findByHql(hql, new Object[]{po.getRepositoryName(),po.getId()})!=null){
			throw new BussinessException("仓库名字重复");
		}
		
		if(repository.getId()==0){
			int id=repositoryDao.addObject(po);
			
			if(repository.getShopIds()!=null){
				for (Integer shopId : repository.getShopIds()) { 
					RepositoryShopPO rShopPO=new RepositoryShopPO();
					rShopPO.setRepositoryId(id);
					rShopPO.setShopId(shopId);
					
					repositoryShopDao.addObject(rShopPO);
				}
			}
		}else{
			repositoryDao.updateObject(po);
			setRepositoryOfShops(repository.getId(), CollectionUtils.array2List(repository.getShopIds()));
			//更新订单
			List<Object> parameters=new ArrayList<Object>();
			parameters.add(repository.getId());
			List<Integer> ids=repositoryDao.findListIntegerBySql("SELECT a.id FROM dbo.replenishment_order a WHERE a.status<60 AND a.repository_id=?", 
					parameters);
			
			if(CollectionUtils.isNotEmpty(ids)){
				for (Integer orderId : ids) {
					replenishmentOrderService.updateOrderAddress(orderId, repository.getId(), true, 
							profileService.getUserNameById(operator));
				}
			}
		}
		
	
	}

	@Override
	public void setRepositoryOfShops(int repositoryId, List<Integer> shopIds) {
		String hql="from RepositoryShopPO where repositoryId=? ";
		List<RepositoryShopPO> pos=this.repositoryShopDao.findListByHql(hql, repositoryId);
		
		this.repositoryShopDao.deleteObjects(pos);
		
		if(CollectionUtils.isNotEmpty(shopIds)){
			for (Integer shopId : shopIds) {
				RepositoryShopPO rShopPO=new RepositoryShopPO();
				rShopPO.setRepositoryId(repositoryId);
				rShopPO.setShopId(shopId);
				
				repositoryShopDao.addObject(rShopPO);
			}
		}
	}
	
	@Override
	public void deleteRepository(int repositoryId) throws BussinessException {
		if(repositoryDao.getSingleObjectBySql("SELECT TOP 1 1 FROM dbo.replenishment_order "
         +" WHERE repository_id=? AND status<>132", new Object[]{repositoryId})!=null)
			throw new BussinessException(EX_REPOSITORY_HAS_USED);
		
		repositoryDao.deleteObjectById(repositoryId);
		repositoryShopDao.deleteObjects(getRepositoryShopRelation(repositoryId));
	}
	
	private List<RepositoryShopPO> getRepositoryShopRelation(int repositoryId){
		String hql="from RepositoryShopPO where repositoryId=?";
		return repositoryShopDao.findListByHql(hql, repositoryId);
	}

	@Override
	public Repository getRepositoryById(int repositoryId) {
		Repository repository=BeanUtils.copyProperties(repositoryDao.getObject(repositoryId), Repository.class);
		
		if(repository!=null){
			List<RepositoryShopPO> relations=getRepositoryShopRelation(repositoryId);
			if(CollectionUtils.isNotEmpty(relations)){
				List<Integer> shopIds=new ArrayList<Integer>();
				for (RepositoryShopPO re : relations) {
					shopIds.add(re.getShopId());
				}
				repository.setShopIds(CollectionUtils.list2Array(shopIds));
			}
		}
		
		return repository;
	}

	@Override
	public List<Repository> getRepositoriesByShopId(int shopId) {
		String hql="select a from RepositoryPO a,RepositoryShopPO b where a.id=b.repositoryId" +
				" and b.shopId=? order by a.repositoryName asc";
		
		return BeanUtils.copyList(repositoryDao.findListByHql(hql, shopId), Repository.class);
	}

	@Override
	public List<Repository> getAllRepositories() {
		return BeanUtils.copyList(repositoryDao.getAll(), Repository.class);
	}
	
	@Override
	public List<RepositoryVO> findPageList(SearchRepository search) {
		StringBuilder sql=new StringBuilder();
		StringBuilder where=new StringBuilder();
		sql.append("SELECT v.* FROM v_fba_repository v ");
		where.append(" where 1=1  ");
		List<Object> params=new ArrayList<Object>();
		if(search.getDeparementId()>-1){
			where.append(" AND v.departmentId=? ");
			params.add(search.getDeparementId());
		}
		
		if(search.getShopId()>-1){
			sql.append(" INNER JOIN dbo.fba_repository_shop rs ON rs.repository_id=v.id ");
			where.append(" AND rs.shop_id=? ");
			params.add(search.getShopId());
		}
		sql.append(where).append(" order by v.id asc ");
		return repositoryDao.findListBySql(sql.toString(), params, RepositoryVO.class);
	}

}
