package com.itecheasy.osms.operation;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itecheasy.common.PageList;
import com.itecheasy.core.operation.ClearInventoryTrackingForm;
import com.itecheasy.core.operation.ClearInventoryTrackingOperateLogVO;
import com.itecheasy.core.operation.ClearInventoryTrackingVO;
import com.itecheasy.core.operation.PriceOffPercentVO;

/**
 * @author taozihao
 * @date 2018年8月24日 下午3:39:34
 * @description 清仓跟踪
 */
@WebService
public interface ClearInventoryTrackingWebService {

	/**
	 * 分页查询清仓跟踪
	 * 
	 * @param queryForm
	 *            查询表单
	 * @return PageList<ClearInventoryTrackingVO> 分页清仓跟踪
	 */
	public PageList<ClearInventoryTrackingVO> getClearInventoryTrackingPageList(
			@WebParam(name = "queryForm") ClearInventoryTrackingForm queryForm);

	/**
	 * 批量降价
	 * 
	 * @param shopId
	 *            店铺id
	 * @param priceOffPercentVOList
	 *            降价商品sku以及对应的降价百分比
	 */
	public void batchPriceOff(@WebParam(name = "shopId") int shopId,
			@WebParam(name = "priceOffPercentVOList") List<PriceOffPercentVO> priceOffPercentVOList,@WebParam(name = "operatorId") int operatorId);

	/**
	 * 通过清仓跟踪id获取操作日志
	 * 
	 * @param clearInventoryTrackingId
	 *            清仓跟踪id
	 * @return List<ClearInventoryTrackingOperateLogVO>
	 */
	public List<ClearInventoryTrackingOperateLogVO> getOperateLogsByClearInventoryTrackingId(
			@WebParam(name = "clearInventoryTrackingId") int clearInventoryTrackingId);

}
