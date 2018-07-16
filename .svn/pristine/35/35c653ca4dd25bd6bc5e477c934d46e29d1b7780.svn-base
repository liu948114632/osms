package com.itecheasy.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.LockMode;

import com.itecheasy.common.dao.Criteria;


public interface BaseDAO<T, PK extends Serializable> {

	public PK addObject(T entity);
	
	public void addObject(List<T> entitys);
	
	public void updateObject(T entity);
	
	public void updateObject(List<T> entitys);
	
	public void mergeObject(T entity);
	
	public void mergeObject(List<T> entitys);

	public void deleteObject(T entity);

	public void deleteObjectById(PK pk);

	public void deleteObjectByIds(Collection<PK> pks);

	public void deleteObjects(Collection<T> objects);

	public T getObject(PK pk);

	public T getObject(Serializable pk, LockMode lockMode);
	
//	public T loadObject(PK pk);

	public Object getSingleObject(String hql);
	
	/**
	 * whw 获取单列的值
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public List<String> getSimpleColumnBySql(final String sql, final List<Object> parameters) ;
	
	public List<String> getSimpleColumnByStoredProcedure(final String name,
			final List<Param> parameters) ;
	
	public Object getSingleObject(String hql, Object parameter);
	
	public Object getSingleObject(String hql, Object[] parameters);
	
	public Object getSingleObjectBySql(String sql, Object[] parameters);
	
	public List<T> getAll();

	public T findByHql(String hql);
	
	public T findByHql(String hql, Object parameter);

	public T findByHql(String hql, Object[] parameters);

	public T findByHql(String hql, String alias, LockMode lockMode);
	
	public T findByHql(String hql, String alias, Object parameter, LockMode lockMode);
	
	public T findByHql(String hql, String alias, Object[] parameters, LockMode lockMode);
	
	public List<T> findListByHql(String hql);

	public List<T> findListByHql(String hql, Object parameter);

	public List<T> findListByHql(String hql, Object[] parameters);	
	
	public PageList<T> findPageListByHql(int currentPage, int pageSize, String hql);
	
	public PageList<T> findPageListByHql(int currentPage, int pageSize, String hql, Object parameter);

	/**
	 * 要求hql符合一定格式...
	 */
	public PageList<T> findPageListByHql(int currentPage, int pageSize, String hql, Object[] parameters);
	
	public List<T> findListByHqlFromCache(String hql);

	public List<T> findListByHqlFromCache(String hql, Object parameter);

	public List<T> findListByHqlFromCache(String hql, Object parameters[]);


	public int executeStoredProcedure(String sql, Object[] parameters);

	public Object executeUniqueStoredProcedure(String sql, Object[] parameters);

	@SuppressWarnings("unchecked")
	public List executeListStoredProcedure(String sql, Object[] parameters);

	@SuppressWarnings("unchecked")
	public List executeListStoredProcedure(String sql, String[] names, Object[] values);
	
	/**
	 *  jdbc 调用SQL2005存储过程
	 * @param currentPage
	 * @param pageSize
	 * @param sql
	 * 		 存储过程名
	 * @param values
	 * 		 参数
	 * @param clazz
	 * 		 返回实体
	 * @return 分页
	 */
	public <E> PageList<E> findPageListByStoredProcedure(int currentPage, int pageSize,String sql,List<Param> parameters,Class<E> clazz);
	

	/**
	 *  jdbc 调用SQL2005存储过程
	 * @param sql
	 * 		 存储过程名
	 * @param values
	 * 		 参数
	 * @param clazz
	 * 		 返回实体
	 * @return 分页
	 */
	public <E> List<E> findListByStoredProcedure(String sql,List<Param> parameters,Class<E> clazz);
	
	public <E> List<E> findListBySql(String sql, List<Object> params, Class<E> clazz);
	
	public  List<Integer> findListIntegerBySql(final String sql, final List<Object> parameters);
	
	public Object uniqueResultByStoredProcedure(final String name,final List<Param> parameters);
	
	
	public int execStoredProcedure(final String name,final List<Param> parameters);
	
	/******************************************************/
	public T get(Criteria criteria);
	public List<T> list(Criteria criteria);
	public int getCount(Criteria criteria);
	public PageList<T> pageList(Criteria criteria,int currentPage,int pageSize);
	public PageList<T> findPageListBySql(int currentPage,int pageSize, String sql, String where, String orderby,
			List<Object> params);
	public List<T> findListBySql(String sql,List<Object> params);
	
	
	public String execStoredProcedure4output(final String name,final List<Param> parameters);
}