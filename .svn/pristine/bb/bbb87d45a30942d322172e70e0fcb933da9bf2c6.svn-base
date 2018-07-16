package com.itecheasy.osms.system;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.Repository;
import com.itecheasy.core.fba.RepositoryVO;
import com.itecheasy.core.fba.SearchRepository;

/** 
 * @author wanghw
 * @date 2016-12-2 
 * @description TODO
 * @version 1.2.2
 */
@WebService
public interface RepositoryWebService {
	/**
	 * 新增/更新 仓库
	 * @param repository
	 */
	void margeRepository(@WebParam(name="repository")Repository repository,@WebParam(name="operator")int operator);
	
	/**
	 * 删除仓库
	 * @param repositoryId
	 * @throws BussinessException {@link #EX_REPOSITORY_HAS_USED}
	 */
	void deleteRepository(@WebParam(name="repositoryId")int repositoryId)throws BussinessException;
	
	void setRepositoryOfShops(@WebParam(name="repositoryId")int repositoryId,@WebParam(name="shopIds") List<Integer> shopIds);
	Repository getRepositoryById(@WebParam(name="id")int id);
	
	/**
	 * 店铺关联的仓库
	 * @param shopId
	 * @return
	 */
	List<Repository> getRepositoriesByShopId(@WebParam(name="shopId")int shopId);
	
	
	List<Repository> getAllRepositories();
	/**
	 * 分页查询
	 * @param search
	 * @return
	 */
	PageList<RepositoryVO> findPageList(@WebParam(name="search")SearchRepository search);
}
