package com.itecheasy.osms.system;

import java.util.List;

import com.itecheasy.common.Page;
import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.Repository;
import com.itecheasy.core.fba.RepositoryService;
import com.itecheasy.core.fba.RepositoryVO;
import com.itecheasy.core.fba.SearchRepository;

/** 
 * @author wanghw
 * @date 2016-12-2 
 * @description TODO
 * @version 1.2.2
 */
public class RepositoryWebServiceImpl implements RepositoryWebService {
	private RepositoryService repositoryService;
	
	

	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	@Override
	public void margeRepository(Repository repository,int operator) {
		repositoryService.mergeRepository(repository,operator);
	}

	@Override
	public void deleteRepository(int repositoryId) throws BussinessException {
		repositoryService.deleteRepository(repositoryId);
	}

	@Override
	public Repository getRepositoryById(int id) {
		return repositoryService.getRepositoryById(id);
	}

	@Override
	public List<Repository> getRepositoriesByShopId(int shopId) {
		return repositoryService.getRepositoriesByShopId(shopId);
	}

	@Override
	public List<Repository> getAllRepositories() {
		return repositoryService.getAllRepositories();
	}

	@Override
	public PageList<RepositoryVO> findPageList(SearchRepository search) {
		List<RepositoryVO> vos=repositoryService.findPageList(search);
		PageList<RepositoryVO> pl=new PageList<RepositoryVO>();
		pl.setData(vos);
		pl.setPage(new Page(vos==null?0:vos.size(), search.getCurrentPage(), search.getPageSize()));
		return pl;
	}
	
	@Override
	public void setRepositoryOfShops(int repositoryId, List<Integer> shopIds) {
		this.repositoryService.setRepositoryOfShops(repositoryId, shopIds);
	}

}
