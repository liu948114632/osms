package com.itecheasy.core.order;

import java.util.Date;
import java.util.List;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;
import com.itecheasy.webservice.client.DMSUtils.OrderQuestionProcessResultType;

/**
 * @author wanghw
 * @date 2016-2-18
 * @description 问题件业务类
 * @version 1.1.7
 */
public interface PackageProblemService {
	/**
	 * 创建问题件
	 * @param packageProblem
	 */
	void createPackageProblem(PackageProblem packageProblem);

	/**
	 * 答复,通讯dms
	 * @param history
	 * @param packageProblemId
	 * @param operator
	 */
	void applyPackageProblem(PackageProblemHistory history, int packageProblemId, int processResultType,String operator)
		throws BussinessException;
	
	/**
	 * 同步dms答复
	 * @param orderCode
	 * @param operatorName
	 * @param content
	 * @param createTime
	 * @param processResult {@link OrderQuestionProcessResultType}
	 */
	void applyPackageProblem(String orderCode,String operatorName,String content,Date createTime,
			String[] downloads,String[] files,Integer processResult);

	/**
	 * 关闭
	 * @param operator
	 * @param packageProblemId
	 */
	void closePackageProblem(int packageProblemId,String operator)throws BussinessException;
	
	/**
	 * 关闭
	 * @param orderCode
	 * @param operator
	 * @param closeTime
	 */
	void closePackageProblem(String orderCode,String operator,Date closeTime);

	/**
	 * 重新打开问题件
	 * @param packageProblemId
	 * @param operator
	 */
	void reopenPackageProblem(int packageProblemId,int operator)throws BussinessException;

	/**
	 * 重新打开问题件
	 * @param orderCode
	 * @param operator
	 */
	void reopenPackageProblem(String orderCode,String operator);
	
	/**
	 * 查询问题件
	 * @param form
	 * @return
	 */
	PageList<PackageProblemVO> findPackageProblems(PackageProblemSerchForm form);

	/**
	 * 问题件回复历史
	 * @param packageProblemId
	 * @return
	 */
	List<PackageProblemHistory> getPackageProblemHistories(int packageProblemId);
	
	/**
	 * 阅读问题件
	 * @param packageProblemId
	 */
	void readPackageProblem(int packageProblemId);
	
	/**
	 * 获取问题件创建人
	 * @return
	 */
	List<String> getPackageProblemCreateUser();
	
	/**
	 * 获取货运客服
	 * @return
	 */
	List<String> getDeliveryCustomerService();

	PackageProblem getPackageProblemByOrder(int orderId);
	
	int getPackageProblemHasNotReadMessageQty(int userId);

	/**
	 * 未妥投件确认处理<br>
	 * {@code 
	 * if dms已确认-->更新问题件状态为已关闭，不用通讯给dms
	 * else dms未处理-->更新问题状态为osms已关闭，通讯dms
	 * }
	 * @param packageProblemId
	 * @param operator
	 */
	void confirmOrderQuestion(int packageProblemId, String operator)throws BussinessException;

	/**
	 * 更新问题件类型
	 * @param packageProblem
	 */
	void updatePackageProblem(PackageProblem packageProblem);

	
	/**
	 * 退件处理结果
	 * @param orderCode
	 * @param operator
	 * @param confirmType
	 */
	void backPackageConfirmType(String orderCode, String operator, String confirmType);
}
