package com.itecheasy.core.fba;

import java.util.List;

import com.itecheasy.core.BussinessException;

/** 
 * @author wanghw
 * @date 2016-11-29 
 * @description 仓库
 * @version 1.2.2
 */
public interface RepositoryService {
	static final String EX_REPOSITORY_HAS_USED="仓库未应用到订单的，才可删除";
	
	/**
	 * 新增/更新 仓库
	 * @param repository
	 */
	void mergeRepository(Repository repository,int operator)throws BussinessException;
	
	/**
	 * 删除仓库
	 * @param repositoryId
	 * @throws BussinessException {@link #EX_REPOSITORY_HAS_USED}
	 */
	void deleteRepository(int repositoryId)throws BussinessException;
	
	void setRepositoryOfShops(int repositoryId,List<Integer> shopIds);
	
	Repository getRepositoryById(int id);
	
	/**
	 * 店铺关联的仓库
	 * @param shopId
	 * @return
	 */
	List<Repository> getRepositoriesByShopId(int shopId);
	
	
	public List<Repository> getAllRepositories();
	/**
	 * 分页查询
	 * @param search
	 * @return
	 */
	List<RepositoryVO> findPageList(SearchRepository search);
}
