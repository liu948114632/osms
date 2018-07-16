package com.itecheasy.communication.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

import com.itecheasy.communication.util.CData;

/** 
 * @author whw
 * @date 2017-9-19 
 * @description TODO
 * @version 
 */
//@Target({ ElementType.METHOD, ElementType.TYPE })
//@Retention(RetentionPolicy.RUNTIME)
//@Inherited
//@Documented
public class MyTransaction extends HibernateTransactionManager{
	private final static Logger LOGGER=Logger.getLogger(MyTransaction.class);
	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 1L;
	public static Map<Long, List<CData>> files=new HashMap<Long, List<CData>>();
	
	@Override
	protected void doRollback(DefaultTransactionStatus status) {
		super.doRollback(status);
		
		long id=Thread.currentThread().getId();
		if(files.containsKey(id)){
			LOGGER.info("files transaction rollback,thread id ["+id+"]");
			for (CData c : files.get(id)) {
				c.rollback();
			}
			
			clearFiles(id);
		}
	}
	
	@Override
	protected void doCommit(DefaultTransactionStatus status) {
		super.doCommit(status);
		long id=Thread.currentThread().getId();
		if(files.containsKey(id)){
			LOGGER.info("files transaction commit,thread id ["+id+"]");
			for (CData c : files.get(id)) {
				c.commit();
			}
			
			clearFiles(id);
		}
	}


	@Override
	protected boolean isExistingTransaction(Object transaction) {
		return super.isExistingTransaction(transaction);
	}

	@Override
	protected void doBegin(Object transaction, TransactionDefinition definition) {
		super.doBegin(transaction, definition);
	}

	private void clearFiles(long id) {
		files.remove(id);
	}
}
