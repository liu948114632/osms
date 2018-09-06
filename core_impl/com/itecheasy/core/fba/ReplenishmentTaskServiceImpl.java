package com.itecheasy.core.fba;

import java.util.*;

import com.itecheasy.core.fba.dao.*;
import com.itecheasy.core.po.*;
import com.itecheasy.osms.order.ReplenishmentOrderWebService;
import com.itecheasy.osms.order.ReplenishmentTaskWebService;
import net.sf.json.JSONObject;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.itecheasy.common.PageList;
import com.itecheasy.common.Param;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.fba.ReplenishmentTaskProduct.MoreBatchAuditStatus;
import com.itecheasy.core.fba.ReplenishmentTaskProduct.ReplenishmentType;
import com.itecheasy.core.order.IOrderSchedule;
import com.itecheasy.core.product.CMSProduct;
import com.itecheasy.core.product.ShopProductCmsInfo;
import com.itecheasy.core.product.ShopProductCmsInfoService;
import com.itecheasy.core.task.BaseOrderView;
import com.itecheasy.core.user.ProfileService;
import com.itecheasy.core.util.StaticUtils;
import com.itecheasy.webservice.client.CMSClient;
import com.itecheasy.webservice.cms.CmsMessage;
import com.itecheasy.webservice.cms.OsmsPurchasingManageTask;
import com.itecheasy.webservice.cms.OsmsStorageTask;

/**
 * @author wanghw
 * @date 2016-12-7
 * @description TODO
 * @version 1.2.2
 */
public class ReplenishmentTaskServiceImpl implements ReplenishmentTaskService {
	private static final String CMS_TASK_ID_S = ",";
	private final static Logger LOGGER=Logger.getLogger(ReplenishmentTaskServiceImpl.class);
	private ReplenishmentTaskProductDao replenishmentTaskProductDao;
	private ReplenishmentTaskDao replenishmentTaskDao;
	private ShopProductCmsInfoService shopProductCmsInfoService;

	private ReplenishmentOrderDao replenishmentOrderDao;

	private ReplenishmentTaskRuleDao replenishmentTaskRuleDao;
	private ReplenishmentTaskMonthDao replenishmentTaskMonthDao;
	private ReplenishmentTaskLogDao replenishmentTaskLogDao;
	private ProfileService profileService;
	private IOrderSchedule orderSchedule;

	public void setReplenishmentOrderDao(ReplenishmentOrderDao replenishmentOrderDao) {
		this.replenishmentOrderDao = replenishmentOrderDao;
	}

	public void setOrderSchedule(IOrderSchedule orderSchedule) {
		this.orderSchedule = orderSchedule;
	}

	public void setReplenishmentTaskLogDao(ReplenishmentTaskLogDao replenishmentTaskLogDao) {
		this.replenishmentTaskLogDao = replenishmentTaskLogDao;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setReplenishmentTaskRuleDao(ReplenishmentTaskRuleDao replenishmentTaskRuleDao) {
		this.replenishmentTaskRuleDao = replenishmentTaskRuleDao;
	}

	public void setReplenishmentTaskMonthDao(ReplenishmentTaskMonthDao replenishmentTaskMonthDao) {
		this.replenishmentTaskMonthDao = replenishmentTaskMonthDao;
	}


	public void setReplenishmentTaskProductDao(ReplenishmentTaskProductDao replenishmentTaskProductDao) {
		this.replenishmentTaskProductDao = replenishmentTaskProductDao;
	}

	public void setReplenishmentTaskDao(ReplenishmentTaskDao replenishmentTaskDao) {
		this.replenishmentTaskDao = replenishmentTaskDao;
	}

	public void setShopProductCmsInfoService(ShopProductCmsInfoService shopProductCmsInfoService) {
		this.shopProductCmsInfoService = shopProductCmsInfoService;
	}

	@Override
	public int createReplenishmentTask(List<String> cmsProductCodes, int operator) {
		ReplenishmentTaskPO task = new ReplenishmentTaskPO();
		task.setCreater(operator);
		task.setCreateDate(new Date());
		task.setStatus(ReplenishmentTaskStatus.未申请.getVal());
		task.setSumNum(cmsProductCodes.size());
		task.setType(ReplenishmentType.FBA.getVal());
		task.setCode(createOrderCode());
		int taskId = replenishmentTaskDao.addObject(task);

		int _tatal_unit_num = 0;
		for (String code : cmsProductCodes) {
			ShopProductCmsInfo cms = shopProductCmsInfoService.getShopProductCmsInfoByCode(code);
			ReplenishmentTaskProductPO product = new ReplenishmentTaskProductPO();
			product.setCmsProductCode(code);
			product.setCmsProductId(cms.getCmsProductId());
			product.setUnit(cms.getUnit());
			product.setUnitQty(cms.getUnitQuantity());
			product.setReplenishmentNum((int) cms.getCmsAwaitReplenishment()>0?cms.getCmsAwaitReplenishment():0);
			product.setReplenishmentTaskId(taskId);
			//默认补货数
			product.setTaskQty(cms.getUnitQuantity()*product.getReplenishmentNum());
			product.setTaskPendingQty(product.getTaskQty());
			product.setStatus(ReplenishmentTaskStatus.未申请.getVal());
			product.setType(ReplenishmentType.FBA.getVal());
			_tatal_unit_num += product.getReplenishmentNum();
			replenishmentTaskProductDao.addObject(product);
			
			// 更新cms补货中量
			setTheCmsReplenishment(product.getType(),product.getCmsProductId());
		}
		task.setSumProductUnitNum(_tatal_unit_num);
		return taskId;
	}
	
	private ShopProductCmsInfo requestShopProductCmsInfo(String cmsProductCode){
		ShopProductCmsInfo cms=null;
		cms= shopProductCmsInfoService.getShopProductCmsInfoByCode(cmsProductCode);
		if(cms==null){
			cms=shopProductCmsInfoService.getShopProductCmsInfoById(shopProductCmsInfoService.mergeShopProductCmsInfo(cmsProductCode));
		}
		return cms;
	}

	//这个是直接在c3中创建补货订单
	public int createReplenishmentTasksPri(List<ReplenishmentTaskProduct> taskProducts, int operator){
		ReplenishmentTaskPO task = new ReplenishmentTaskPO();
		task.setCreater(operator);
		task.setCreateDate(new Date());
		task.setStatus(taskProducts.get(0).getStatus());   //Status为1   1、未申请 4、申请中 5、审核不通过 2、备货中 3、已完成  6、取消
		task.setSumNum(taskProducts.size());
		task.setType(taskProducts.get(0).getType());   //type为1
		task.setCode(createOrderCode());
		int taskId = replenishmentTaskDao.addObject(task);
		int _tatal_unit_num = 0;
		for (ReplenishmentTaskProduct product : taskProducts) {
			_tatal_unit_num += product.getReplenishmentNum();
			product.setReplenishmentTaskId(taskId);
			product.setTaskStatus(null);
			product.setTaskToDate(null);
			product.setTaskStrategyDepartment(null);
			product.setTaskType(null);
			replenishmentTaskProductDao.addObject(BeanUtils.copyProperties(product, ReplenishmentTaskProductPO.class));
			setTheCmsReplenishment(product.getType(),product.getCmsProductId());
		}
		task.setSumProductUnitNum(_tatal_unit_num);
		return taskId;
	}

	//看传过来的taskproducts的type是否为4   这个是在fba创建的c3补货订单来掉用的方法
	public int createReplenishmentTasksPri(List<ReplenishmentTaskProduct> taskProducts, int operator,String taskRemark){

		//因为在外面遍历了，所以里面没回只用取第一个

		//创建订单并且赋值给订单一些基本属性  补货任务
	    ReplenishmentTaskPO task = new ReplenishmentTaskPO();
		task.setCreater(operator);
		task.setCreateDate(new Date());
		task.setStatus(taskProducts.get(0).getStatus());     //根据product状态来设置 1、未申请 4、申请中 5、审核不通过 2、备货中 3、已完成  6、取消
		task.setSumNum(taskProducts.size());

		task.setType(3);   //自卖订单采购

		task.setCode(createOrderCode());

		//ReplenishmentTask
		int taskId = replenishmentTaskDao.addObject(task);   //根据补货订单对象生成一个订单并且把返回的订单id拿到并且赋值给每个product作为关联
		int _tatal_unit_num = 0;   //用于统计所有product的数量

		//已经创建了cms补货计划,写入数据库，值为true就代表已经创建过该fba补货计划的的c3补货订单
		String hql=" from ReplenishmentOrderPO where code=?";
		ReplenishmentOrderPO replenishmentOrderPO = replenishmentOrderDao.findByHql(hql,taskRemark);
		if(replenishmentOrderPO!=null) {

			replenishmentOrderPO.setSwToCmsPrepare(false);
//			replenishmentOrderPO.setIsQualityInspection();
			replenishmentOrderDao.updateObject(replenishmentOrderPO);
		}



		//把传过来的productList遍历，并且为订单中的每个商品添加基本属性，最后把整个product对象写入到数据库
		for (ReplenishmentTaskProduct product : taskProducts) {
			_tatal_unit_num += product.getReplenishmentNum();
            product.setTaskRemark(product.getTaskRemark() +"   (FBA补货订单号:" +taskRemark+")");   //为每个商品追加备注为fba补货订单号
            product.setReplenishmentTaskId(taskId);
			product.setTaskStatus(null);
			product.setTaskToDate(null);
			product.setTaskStrategyDepartment(null);
			product.setTaskType(null);
		//	taskProducts.get(0).getUnitQty();
//			product.setUnitQty(1);   //通过这种方式创建的批量都是1
//			product.setTaskQty(product.getReplenishmentNum());
			replenishmentTaskProductDao.addObject(BeanUtils.copyProperties(product, ReplenishmentTaskProductPO.class));

			setTheCmsReplenishment(product.getType(),product.getCmsProductId());
		}


		//自动通过审核日志记录
//		addLog("审核通过", taskId, profileService.getUserNameById(operator));

		//下达任务到cms，并且任务备注始终都会有fba补货订单号
		List<Integer> taskIds = new ArrayList<Integer>();
		taskIds.add(taskId);

		pass(taskIds,operator,taskRemark);
//		for (ReplenishmentTaskProductPO p : ps) {
//			p.setStatus(po.getStatus());
//			//下达任务到cms
//			addTask(p, name);
//		}

		task.setSumProductUnitNum(_tatal_unit_num);   //设置订单商品total   但是并没有被写入到数据库
		return taskId;
	}


	@Override
	public int createReplenishmentTasksFromFba(List<ReplenishmentTaskProduct> taskProducts, int operator, String taskRemark) {
        for (ReplenishmentTaskProduct product : taskProducts) {
            requestShopProductCmsInfo(product.getCmsProductCode());
            product.setStatus(ReplenishmentTaskStatus.申请中.getVal());   //先把productList中的status全部改为申请中
        }
		//未申请和已申请
		return createReplenishmentTasksPri(taskProducts, operator,taskRemark);
	}

	@Override
	public int createReplenishmentTasks(List<ReplenishmentTaskProduct> taskProducts, int operator) {
		for (ReplenishmentTaskProduct product : taskProducts) {
			requestShopProductCmsInfo(product.getCmsProductCode());
			product.setStatus(ReplenishmentTaskStatus.未申请.getVal());   //先把productList中的status全部改为未申请
		}
		return createReplenishmentTasksPri(taskProducts, operator);
	}
	
	@Override
	public List<ReplenishmentTaskProduct> appendReplenishmentTasks(int replenishmentTaskId, List<ReplenishmentTaskProduct> taskProducts,
			int operator) {
		ReplenishmentTaskPO task = this.replenishmentTaskDao.getObject(replenishmentTaskId);
		int _tatal_unit_num = 0;
		for (ReplenishmentTaskProduct product : taskProducts) {
			_tatal_unit_num += product.getReplenishmentNum();
			product.setReplenishmentTaskId(replenishmentTaskId);
			product.setType(task.getType());
			product.setStatus(task.getStatus());
			ReplenishmentTaskProductPO po = BeanUtils.copyProperties(product, ReplenishmentTaskProductPO.class);
			replenishmentTaskProductDao.addObject(po);
			
			BeanUtils.copyProperties(po	, product);
			
			setTheCmsReplenishment(product.getType(),product.getCmsProductId());
		}
		task.setSumProductUnitNum(task.getSumProductUnitNum()+_tatal_unit_num);
		task.setSumNum(task.getSumNum()+taskProducts.size());
		
		return taskProducts;
	}

	private String createOrderCode() {
		List<Param> parameters = new ArrayList<Param>();
		parameters.add(new Param("Code", ""));
		String object = replenishmentTaskDao.execStoredProcedure4output(
				"[dbo].[Order_OrderIdBuild_replenishment_task]", parameters);
		if (object != null) {
			return object.toString();
		}
		return null;
	}

	@Override
	public void saveReplenishmentProducts(ReplenishmentTask task, List<ReplenishmentTaskProduct> products, int operator) {
		ReplenishmentTaskPO po = replenishmentTaskDao.getObject(task.getId());
		if (po.getStatus() != ReplenishmentTaskStatus.未申请.getVal()
				&&po.getStatus() != ReplenishmentTaskStatus.审核不通过.getVal())
			throw new BussinessException(EX_STATUS);

		int _update_num = 0;
		for (ReplenishmentTaskProduct p : products) {
			ReplenishmentTaskProductPO pp = replenishmentTaskProductDao.getObject(p.getId());
			_update_num = _update_num+pp.getReplenishmentNum() - p.getReplenishmentNum();
			pp.setReplenishmentNum(p.getReplenishmentNum());
			pp.setTaskQty(pp.getUnitQty()*pp.getReplenishmentNum());
			pp.setTaskPendingQty(pp.getTaskPendingQty());
			replenishmentTaskProductDao.mergeObject(pp);
			
			setTheCmsReplenishment(pp.getType(),pp.getCmsProductId());
		}
		po.setSumProductUnitNum(po.getSumProductUnitNum()-_update_num);

		po.setType(task.getType());
		List<ReplenishmentTaskProductPO> pos=this.getTaskProduct(task.getId());
		
		for (ReplenishmentTaskProductPO p : pos) {
			p.setType(task.getType());
			p.setStatus(po.getStatus());
		}
		
		replenishmentTaskDao.mergeObject(po);
	}

	@Override
	@Deprecated
	public void orderedReplenishmentTask(int replenishmentTaskId, int operator) {
		ReplenishmentTaskPO po = replenishmentTaskDao.getObject(replenishmentTaskId);
		if (po.getStatus() != ReplenishmentTaskItemStatus.未下单.getVal())
			throw new BussinessException("只有未下单状态的补货单，才能请求设为已下单辑");

		po.setOrderedDate(new Date());
		po.setStatus(ReplenishmentTaskItemStatus.已下单.getVal());
		
		List<ReplenishmentTaskProductPO> products = getTaskProduct(replenishmentTaskId);
		if (CollectionUtils.isNotEmpty(products)) {
			for (ReplenishmentTaskProductPO p : products) {
				p.setStatus(ReplenishmentTaskItemStatus.已下单.getVal());
			}
		}
	}

	@Override
	@Deprecated
	public void complatedReplenishmentTask(int replenishmentTaskId, int operator) {
		ReplenishmentTaskPO po = replenishmentTaskDao.getObject(replenishmentTaskId);
		if (po.getStatus() != ReplenishmentTaskItemStatus.已下单.getVal())
			throw new BussinessException("只有已下单状态的补货单，才能请求设为已完成");

		po.setComplatedDate(new Date());
		po.setStatus(ReplenishmentTaskStatus.已完成.getVal());
		po.setComplatedNum(po.getSumNum());
		List<ReplenishmentTaskProductPO> products = getTaskProduct(replenishmentTaskId);
		if (CollectionUtils.isNotEmpty(products)) {
			for (ReplenishmentTaskProductPO p : products) {
				p.setStatus(ReplenishmentTaskItemStatus.已完成.getVal());
				if(!CMSTaskStatus.已取消.equal(p.getTaskStatus())
						&&!CMSTaskStatus.已结束.equal(p.getTaskStatus())){
					p.setTaskStatus(CMSTaskStatus.已结束.getVal());
					//重新统计补货中的数量
					setTheCmsReplenishment(p.getType(),p.getCmsProductId());
				}
				replenishmentTaskProductDao.mergeObject(p);
			}
		}
	}
	
	private List<ReplenishmentTaskProductPO> getTaskProduct(int replenishmentTaskId){
		String hql = "from ReplenishmentTaskProductPO where replenishmentTaskId=?";
		return  replenishmentTaskProductDao.findListByHql(hql, replenishmentTaskId);
	}

	private List<ReplenishmentTaskProductPO> getNotComplatedTaskProduct(int replenishmentTaskId) {
		String hql="from ReplenishmentTaskProductPO where status!=? and status!=? and replenishmentTaskId=?";
		return replenishmentTaskProductDao.findListByHql(hql, new Object[]{ReplenishmentTaskStatus.已完成.getVal(),
				ReplenishmentTaskStatus.取消.getVal(),
				replenishmentTaskId});
	}
	
	private List<ReplenishmentTaskProductPO> getNotCancelTaskProduct(int replenishmentTaskId) {
		String hql="from ReplenishmentTaskProductPO where status!=? and replenishmentTaskId=?";
		return replenishmentTaskProductDao.findListByHql(hql, new Object[]{
				ReplenishmentTaskStatus.取消.getVal(),
				replenishmentTaskId});
	}

	@Override
	public void complatedReplenishmentTaskProduct(int replenishmentTaskProductId, int operator) {
		ReplenishmentTaskProductPO p = replenishmentTaskProductDao.getObject(replenishmentTaskProductId);
		if(p.getStatus()==ReplenishmentTaskItemStatus.已完成.getVal()){
			throw new BussinessException(p.getCmsProductCode()+"已经完成！");
		}
		p.setTaskStatus(CMSTaskStatus.已结束.getVal());
		complatedReplenishmentTaskProduct(p);
	}

	private void complatedReplenishmentTaskProduct(ReplenishmentTaskProductPO p) {
		if(p.getStatus()!=ReplenishmentTaskStatus.已完成.getVal()
				&&p.getStatus()!=ReplenishmentTaskStatus.取消.getVal()){
			p.setStatus(ReplenishmentTaskStatus.已完成.getVal());
			ReplenishmentTaskPO po = replenishmentTaskDao.getObject(p.getReplenishmentTaskId());
			po.setComplatedNum(po.getComplatedNum() + 1);
			replenishmentTaskProductDao.mergeObject(p);
			//重新统计补货中的数量
			setTheCmsReplenishment(p.getType(),p.getCmsProductId());
			
			beCompletingTask(po);
		}
	}

	private void setTheCmsReplenishment(int type,int cmsProductId) {
		if(type==ReplenishmentType.FBA.getVal()
				||type==ReplenishmentType.ORDER.getVal())
			shopProductCmsInfoService.setTheCmsReplenishment(cmsProductId);
	}

	private boolean beCompletingTask(ReplenishmentTaskPO po) {
		if (CollectionUtils.isEmpty(getNotComplatedTaskProduct(po.getId()))) {
			po.setComplatedDate(new Date());
			po.setStatus(ReplenishmentTaskStatus.已完成.getVal());
			return true;
		}
		
		return false;
	}
	
	private boolean beCancelTask(ReplenishmentTaskPO po) {
		if (CollectionUtils.isEmpty(getNotCancelTaskProduct(po.getId()))) {
			po.setStatus(ReplenishmentTaskStatus.取消.getVal());
			po.setSumProductUnitNum(0);
			po.setSumNum(0);
			return true;
		}
		return false;
	}

	@Override
	public void deleteReplenishmentTaskProduct(int replenishmentTaskProductId, int operator) {
		ReplenishmentTaskProductPO p = replenishmentTaskProductDao.getObject(replenishmentTaskProductId);
		replenishmentTaskProductDao.deleteObject(p);

		ReplenishmentTaskPO po = replenishmentTaskDao.getObject(p.getReplenishmentTaskId());
		po.setSumNum(po.getSumNum() - 1);
		po.setSumProductUnitNum(po.getSumProductUnitNum()-p.getReplenishmentNum());
		if(po.getSumNum()==0){
			replenishmentTaskDao.deleteObjectById(p.getReplenishmentTaskId());
		}else{
//			beCompletingTask(po);
		}
		setTheCmsReplenishment(po.getType(),p.getCmsProductId());
	}
	
	private void cancleReplenishmentTaskProduct(ReplenishmentTaskProductPO p){
		if(p.getStatus()!=ReplenishmentTaskStatus.已完成.getVal()
				&&p.getStatus()!=ReplenishmentTaskStatus.取消.getVal()){
			p.setStatus(ReplenishmentTaskStatus.取消.getVal());
			
			ReplenishmentTaskPO po = replenishmentTaskDao.getObject(p.getReplenishmentTaskId());
			po.setSumNum(po.getSumNum() - 1);
			po.setSumProductUnitNum(po.getSumProductUnitNum()-p.getReplenishmentNum());
			
			if(!beCancelTask(po))
				beCompletingTask(po);
			
			setTheCmsReplenishment(p.getType(),p.getCmsProductId());
		}
	}

	@Override
	public void deleteReplenishmentTask(int replenishmentTaskId, int operator) {
		ReplenishmentTaskPO po = replenishmentTaskDao.getObject(replenishmentTaskId);
		if (po.getStatus() != ReplenishmentTaskStatus.未申请.getVal())
			throw new BussinessException("只有未下单状态的补货单，才能删除");

		List<ReplenishmentTaskProduct> ts = getReplenishmentTaskDetail(replenishmentTaskId);

		if (CollectionUtils.isNotEmpty(ts)) {
			for (ReplenishmentTaskProduct t : ts) {
				this.deleteReplenishmentTaskProduct(t.getId(), operator);
			}
		}
	}

	@Override
	@Deprecated
	public int syncReplenishmentTask(int pageSize, int currentPage) {
		String hql = "from ReplenishmentTaskPO where status!=?";
		PageList<ReplenishmentTaskPO> pl = replenishmentTaskDao.findPageListByHql(currentPage++, pageSize, hql,
				ReplenishmentTaskStatus.已完成.getVal());

//		for (ReplenishmentTaskPO task : pl.getData()) {
//			List<OsmsPurchasingManageTask> ps = CMSClient.getFBAPurchasingManagementTaskByCode(task.getCode());
//
//			if (CollectionUtils.isEmpty(ps))
//				continue;
//			
//			//重复
//			Map<Integer, Boolean> _same=new HashMap<Integer, Boolean>();
//			for (OsmsPurchasingManageTask pt : ps){
//				_same.put(pt.getProductId(), _same.containsKey(pt.getProductId()));
//			}
//			
//			
//			StringBuilder cmsProductCodes=new StringBuilder();
//			for (OsmsPurchasingManageTask pt : ps) {
//				ReplenishmentTaskProductPO p = getReplenishmentTaskProductPO(task.getId(), pt.getProductId());
//				if (!(p.getTaskStatus() != null && isComplatedProductTask(p.getTaskStatus()))
//						) {
//					//重复不同步
//					if(_same.get(pt.getProductId())){
//						cmsProductCodes.append(p.getCmsProductCode()).append(CMS_TASK_ID_S);
//						continue;
//					}
//					p.setTaskStatus(pt.getStatus());
//					p.setTaskFeedback(pt.getFeedbackRemark());
//					p.setTaskPendingQty(pt.getWaitQuantity());
////					p.setTaskPurchaseManagerRemark(pt.getPurchaseManageRemark());
//					p.setTaskQty(pt.getPlanQuantity());
//					p.setTaskToDate(DateUtils.getDateByXMLGregorianCalendar(pt.getAssignTime()));
//					p.setTaskStrategyDepartment(pt.getAssignToDepartmentName());
////					p.setTaskToDepartment("采购部");
//					p.setTaskRemark(pt.getRemark());
//
//					// 结束任务或者取消任务
//					if (isComplatedProductTask(p.getTaskStatus())) {
////						task.setComplatedNum(task.getComplatedNum() + 1);
//						//重新统计补货中的数量
////							setTheCmsReplenishment(p);
//						//2017-01-12 09:50:04  不自动完成补货任务
////							fbaShopProductUpdateControl.cmsReplenishment(p.getCmsProductId(), -p.getReplenishmentNum());
////							if (beCompletingTask(task)) {
////								return;
////							}
//					}
//					replenishmentTaskProductDao.mergeObject(p);
//				}
//			}
//			replenishmentTaskDao.mergeObject(task);
//			
//			if(cmsProductCodes.length()>0){
//				StaticUtils.addEmail("C3补货单"+task.getCode()+"任务数与CMS系统不一样", 
//						"不一致商品如下:"+cmsProductCodes.toString());
//			}
//		}

		if (pl.getPage().getPageCount() < currentPage) {
			return -1;
		}
		return currentPage;
	}

	/**
	 * 补货商品任务是否完成
	 * 
	 * @param status
	 * @return
	 */
	private boolean isComplatedProductTask(Integer status) {
		if(status==null)
			return false;
		return status == CMSTaskStatus._已取消.getVal()
				|| status == CMSTaskStatus._已结束.getVal();
	}
	
	/**
	 * 是否正在超批
	 * @param moreBatchAuditStatus
	 * @return
	 */
	private boolean isMoreBatchAuditing(Integer moreBatchAuditStatus){
		return moreBatchAuditStatus!=null&&moreBatchAuditStatus.intValue()==MoreBatchAuditStatus.待审核.getVal();
	}

	@Override
	public PageList<FbaRelatedCMSProduct> findCMSReplenishmentProducts(SearchFbaRelatedCMSProduct search) {
		List<Param> parameters = new ArrayList<Param>();

		if (search.getIsRemindCMSReplenishment() > -1) {
			parameters.add(new Param("isRemindCMSReplenishment", search.getIsRemindCMSReplenishment()));
		}
		if (StringUtils.isNotEmpty(search.getCmsProductCode())) {
			parameters.add(new Param("cmsProductCode", search.getCmsProductCode()));
		}
		if (CollectionUtils.isNotEmpty(search.getCmsProductCodes())) {
			StringBuilder productCodeList = new StringBuilder();
			for (String productCode : search.getCmsProductCodes()) {
				productCodeList.append(productCode + CMS_TASK_ID_S);
			}
			parameters.add(new Param("cmsProductCodes", productCodeList.substring(0, productCodeList.length() - 1)));
		}

		parameters.add(new Param("PageIndex", String.valueOf(search.getCurrentPage())));
		parameters.add(new Param("PageSize", String.valueOf(search.getPageSize())));

		
		PageList<FbaRelatedCMSProduct> pl = replenishmentTaskDao.findPageListByStoredProcedure(search.getCurrentPage(),
				search.getPageSize(), "p_cms_replenishment_product", parameters, FbaRelatedCMSProduct.class);

		
		if(pl!=null&&CollectionUtils.isNotEmpty(pl.getData())){
			Map<Integer, FbaRelatedCMSProduct> parents=new HashMap<Integer, FbaRelatedCMSProduct>();
			//排序
			List<FbaRelatedCMSProduct> parentsList=new ArrayList<FbaRelatedCMSProduct>();
			for (FbaRelatedCMSProduct p : pl.getData()) {
				FbaRelatedCMSProduct parent=null;
				if(parents.containsKey(p.getCmsProductId())){
					//统计
					parent=parents.get(p.getCmsProductId());
					parent.setFbaAvailableStock(parent.getFbaAvailableStock()+p.getFbaAvailableStock());
					parent.setSumSecurityLine(parent.getSumSecurityLine()+p.getSumSecurityLine());
				}else{
					//生成父对象
					parent=BeanUtils.copyProperties(p, FbaRelatedCMSProduct.class);
					parent.setParent(true);
					parents.put(p.getCmsProductId(), parent);
					parentsList.add(parent);
				}
			}
			
			
			pl.getData().addAll(parentsList);
		}
		return pl;
	}
	

	@Override
	public ReplenishmentTask getReplenishmentTask(int replenishmentTaskId) {
		return BeanUtils.copyProperties(replenishmentTaskDao.getObject(replenishmentTaskId), ReplenishmentTask.class);
	}

	@Override
	public List<ReplenishmentTaskProduct> getReplenishmentTaskDetail(int replenishmentTaskId) {
		String hql = "from ReplenishmentTaskProductPO where replenishmentTaskId=? ";
		List<ReplenishmentTaskProduct> items = BeanUtils.copyList(
				replenishmentTaskProductDao.findListByHql(hql, replenishmentTaskId), ReplenishmentTaskProduct.class);
		if (CollectionUtils.isNotEmpty(items)) {
			for (ReplenishmentTaskProduct replenishmentTaskProduct : items) {
				ShopProductCmsInfo info = shopProductCmsInfoService.getShopProductCmsInfoById(replenishmentTaskProduct
						.getCmsProductId());
				replenishmentTaskProduct.setProductName(info.getProductName());
				replenishmentTaskProduct.setColorCardPictureCode(info.getColorCardPictureCode());
				replenishmentTaskProduct.setPrimaryPictureCode(info.getPrimaryPictureCode());
			}
		}
		return items;
	}
	
	@Override
	public List<ReplenishmentTaskProduct> getReplenishmentTaskDetail(int replenishmentTaskId,String productCode,
			List<String> productCodes) {
		String hql = " SELECT id FROM dbo.replenishment_task_product a where a.replenishment_task_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(replenishmentTaskId);
		if(StringUtils.isNotEmpty(productCode)){
			hql+="  AND  (a.cms_product_code like ?  " +
					" or EXISTS(SELECT * FROM dbo.replenishment_task_product r WHERE r.main_task_id=a.id AND r.cms_product_code  like ? )) ";
			params.add("%"+productCode+"%");
			params.add("%"+productCode+"%");
		}
		if(CollectionUtils.isNotEmpty(productCodes)){
			StringBuilder s=new StringBuilder();
			for (String string : productCodes) {
				s.append(",'").append(string).append("'");
			}
			
			hql+="  AND  (a.cms_product_code in ( "+s.substring(1).toString()+" ) " +
					" or EXISTS(SELECT * FROM dbo.replenishment_task_product r WHERE " +
					"r.main_task_id=a.id AND r.cms_product_code  in ( "+s.substring(1).toString()+" ))) ";
		}
		
//		if(waitMoreBatchAudit>-1){
//			hql+="  AND  (a.more_batch_audit_status=1 " +
//					" or EXISTS(SELECT * FROM dbo.replenishment_task_product r WHERE " +
//					"r.main_task_id=a.id AND r.more_batch_audit_status=1 )) ";
//		}
//		
//		if(partProductWaitMoreBatchAudit>-1){
//			hql+="  AND  ((a.more_batch_audit_status=1 and a.is_part_product=1 )" +
//					" or EXISTS(SELECT * FROM dbo.replenishment_task_product r WHERE " +
//					"r.main_task_id=a.id AND r.more_batch_audit_status=1 and r.is_part_product=1)) ";
//		}
		
		hql=" SELECT * FROM replenishment_task_product WHERE id IN ( " +
				"SELECT c.id FROM dbo.replenishment_task_product c INNER JOIN  ( "+hql+") t  ON c.id=t.id OR c.main_task_id=t.id ) order by more_batch_audit_status";
		List<ReplenishmentTaskProduct> items = BeanUtils.copyList(
				replenishmentTaskProductDao.findListBySql(hql, params), ReplenishmentTaskProduct.class);

		//把moreBatchAuditStatus属性为null的集合排在下面
		List<ReplenishmentTaskProduct> moreBatchAuditStatus = new ArrayList<ReplenishmentTaskProduct>();
		List<ReplenishmentTaskProduct> nullMoreBatchAuditStatus = new ArrayList<ReplenishmentTaskProduct>();
		for (ReplenishmentTaskProduct item : items) {
			if (item.getMoreBatchAuditStatus() == null){
				nullMoreBatchAuditStatus.add(item);
			}else{
				moreBatchAuditStatus.add(item);
			}
		}
		moreBatchAuditStatus.addAll(nullMoreBatchAuditStatus);


		//只要商品中有一个子商品是待审核状态，就把这个商品排在最上面
		List<ReplenishmentTaskProduct> mainTask = new ArrayList<ReplenishmentTaskProduct>();	//这些都是要放在最前面的
		List<Integer> ids = new ArrayList<Integer>();
		for (ReplenishmentTaskProduct batchAuditStatus : moreBatchAuditStatus) {
			if (null!=batchAuditStatus.getMoreBatchAuditStatus() &&	MoreBatchAuditStatus.待审核.getVal() == batchAuditStatus.getMoreBatchAuditStatus()
					&&	batchAuditStatus.getMainTaskId()!=null && batchAuditStatus.getMainTaskId()!=0) {
				if(!ids.contains(batchAuditStatus.getMainTaskId())){
					ReplenishmentTaskProductPO object = replenishmentTaskProductDao.getObject(batchAuditStatus.getMainTaskId());
					ReplenishmentTaskProduct replenishmentTaskProduct = BeanUtils.copyProperties(object, ReplenishmentTaskProduct.class);
					mainTask.add(replenishmentTaskProduct);
					ids.add(object.getId());
				}
			}
		}
		for (Integer id : ids) {
			Iterator<ReplenishmentTaskProduct> batchAuditStatus = moreBatchAuditStatus.iterator();
			while(batchAuditStatus.hasNext()){
				ReplenishmentTaskProduct ne = batchAuditStatus.next();
				if (ne.getId() == id){
					batchAuditStatus.remove();
				}
			}
		}
		mainTask.addAll(moreBatchAuditStatus);

/**
 * cms任务状态：（1 未下达、2 已下达、3 采购完成、4 无法处理、6 已结束、7 已取消、8排队中）
 * cms办事处任务状态（10 未分配、20 已分配、30 采购中 40订货中、50加工中、55待入库、60 无法处理、70 已结束 80 已取消）
 */
		if (CollectionUtils.isNotEmpty(mainTask)) {
			for (ReplenishmentTaskProduct replenishmentTaskProduct : mainTask) {
				ShopProductCmsInfo info = shopProductCmsInfoService.getShopProductCmsInfoById(replenishmentTaskProduct
						.getCmsProductId());
				replenishmentTaskProduct.setProductName(info.getProductName());
				replenishmentTaskProduct.setColorCardPictureCode(info.getColorCardPictureCode());
				replenishmentTaskProduct.setPrimaryPictureCode(info.getPrimaryPictureCode());
//				replenishmentTaskProduct.setTaskStatus(10);
			}
		}
 		return mainTask;
	}

	@Override
	public ReplenishmentTaskProduct getReplenishmentTaskProduct(int replenishmentTaskId, int cmsProductId) {
		return BeanUtils.copyProperties(getReplenishmentTaskProductPO(replenishmentTaskId, cmsProductId),
				ReplenishmentTaskProduct.class);
	}

	private ReplenishmentTaskProductPO getReplenishmentTaskProductPO(int replenishmentTaskId, int cmsProductId) {
		String hql = "from ReplenishmentTaskProductPO where replenishmentTaskId=? and cmsProductId=? ";
		return replenishmentTaskProductDao.findByHql(hql, new Object[] { replenishmentTaskId, cmsProductId });
	}

	@Override
	public PageList<ReplenishmentTask> findReplenishmentTasks(SearchReplenishmentTask search) {
		StringBuilder sql = new StringBuilder();
		StringBuilder where = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("SELECT replenishment_task.* FROM dbo.replenishment_task ");

		where.append(" and type in (1,2,3) and NOT EXISTS(SELECT * FROM dbo.replenishment_task_product a WHERE a.replenishment_task_id=replenishment_task.id AND a.order_purchase=1) ");
		if (StringUtils.isNotEmpty(search.getReplenishmentTaskCode())) {
			where.append(" and code like ? ");
			params.add("%" + search.getReplenishmentTaskCode() + "%");
		}
		
		if(search.getOrderedDateBegin()!=null){
			where.append(" and ordered_date>=? ");
			params.add(com.itecheasy.common.util.DateUtils.getRealDate(search.getOrderedDateBegin()));
		}
		if(search.getOrderedDateEnd()!=null){
			where.append(" and ordered_date<=? ");
			params.add(com.itecheasy.common.util.DateUtils.getFullDate(search.getOrderedDateEnd()));
		}

		if (StringUtils.isNotEmpty(search.getCmsProductCode())) {
			where.append(" AND id IN (SELECT DISTINCT replenishment_task_id  FROM dbo.replenishment_task_product "
					+ "WHERE cms_product_code=? )");
			params.add(search.getCmsProductCode());
		}
		
		if(search.getWaitMoreBatchAudit()>-1){
			where.append(" AND id IN (SELECT DISTINCT replenishment_task_id  FROM dbo.replenishment_task_product "
					+ "WHERE more_batch_audit_status=1 and main_task_id is null)");
		}
		
		if(search.getPartProductWaitMoreBatchAudit()>-1){
			where.append(" AND id IN (SELECT DISTINCT replenishment_task_id  FROM dbo.replenishment_task_product "
					+ "WHERE more_batch_audit_status=1 and main_task_id is not null)");
		}
		
		
		if(search.getIsSample()==1){
			where.append(" AND id IN (SELECT DISTINCT replenishment_task_id  FROM dbo.replenishment_task_product "
					+ "WHERE is_sample is not null )");
		}else if(search.getIsSample()==0){
			where.append(" AND id IN (SELECT DISTINCT replenishment_task_id  FROM dbo.replenishment_task_product "
					+ "WHERE is_sample is null )");
		}
		
		if (CollectionUtils.isNotEmpty(search.getCmsProductCodes())) {
			where.append(" AND id IN (SELECT DISTINCT replenishment_task_id  FROM dbo.replenishment_task_product "
					+ "WHERE cms_product_code in (");
			
			StringBuilder codes=new StringBuilder();
			for (String object : search.getCmsProductCodes()) {
				codes.append(",'"+object+"'");
			}
			params.add(search.getCmsProductCode());
			where.append(codes.toString().substring(1)).append(") )"); 
		}

		if (search.getStatus() > -1) {
			where.append(" and status=? ");
			params.add(search.getStatus());
		}

		if (search.getCreater() > -1) {
			where.append(" and creater=? ");
			params.add(search.getCreater());
		}
		
		if(search.getAuditor()>-1){
			where.append(" and auditor=? ");
			params.add(search.getAuditor());
		}
		
		if(search.getType()>-1){
			where.append(" and type=? ");
			params.add(search.getType());
		}

		if (search.getCreateDateBegin() != null) {
			where.append(" and create_date>=? ");
			params.add(com.itecheasy.common.util.DateUtils.getRealDate(search.getCreateDateBegin()));
		}

		if (search.getCreateDateEnd() != null) {
			where.append(" and create_date<=? ");
			params.add(com.itecheasy.common.util.DateUtils.getFullDate(search.getCreateDateEnd()));
		}

		PageList<ReplenishmentTaskPO> pl = replenishmentTaskDao.findPageListBySql(search.getCurrentPage(),
				search.getPageSiez(), sql.toString(), where.toString(), "   CASE status " +
						"WHEN 1 THEN 1 " +
						" WHEN 4 THEN 2 " +
						"WHEN 5 THEN 3 " +
						"WHEN 2 THEN 4" +
						" WHEN 3 THEN 5 WHEN 6 THEN 6" +
						" END ,create_date desc ", params);
		return BeanUtils.copyPageList(pl, ReplenishmentTask.class);
	}

	@Override
	public List<MonthlyPeakOrLow> getMonthlyPeakOrLow() {
		String hql="select a from ReplenishmentTaskMonthPO a order by a.month asc ";
		List<ReplenishmentTaskMonthPO> pos=replenishmentTaskMonthDao.findListByHql(hql);
		if(CollectionUtils.isNotEmpty(pos)){
			List<MonthlyPeakOrLow> peakOrLows=new ArrayList<ReplenishmentTaskService.MonthlyPeakOrLow>();
			for (ReplenishmentTaskMonthPO po : pos) {
				peakOrLows.add( po.getMonthlyPeakOrLow());
			}
			
			return peakOrLows;
		}
		return null;
	}

	@Override
	public void setMonthlyPeakOrLow(List<MonthlyPeakOrLow> PeakOrLows) {
		replenishmentTaskMonthDao.deleteObjects(replenishmentTaskMonthDao.getAll());
		
		Date operateData = new Date();
		for (int i = 0; i < PeakOrLows.size(); i++) {
			ReplenishmentTaskMonthPO po=new ReplenishmentTaskMonthPO();
			po.setMonth(i+1);
			po.setOperateData(operateData);
			po.setMonthlyPeakOrLow(PeakOrLows.get(i));
			replenishmentTaskMonthDao.addObject(po);
		}
	}

	@Override
	public void setMonthlyPeakOrLowRules(List<MonthlyPeakOrLowRule> rules) {
		List<ReplenishmentTaskRulePO>  olds=getReplenishmentTaskRulePOs();
		if(CollectionUtils.isNotEmpty(olds)){
			for (ReplenishmentTaskRulePO po : olds) {
				po.setDeleted(true);
			}
		}
		
		replenishmentTaskRuleDao.addObject(BeanUtils.copyList(rules, ReplenishmentTaskRulePO.class));
	}

	private  List<ReplenishmentTaskRulePO> getReplenishmentTaskRulePOs(){
		String hql="from ReplenishmentTaskRulePO where deleted=false order by sort asc,id asc";
		return this.replenishmentTaskRuleDao.findListByHql(hql);
	}
	
	@Override
	public List<MonthlyPeakOrLowRule> getMonthlyPeakOrLowRules() {
		List<ReplenishmentTaskRulePO> pos=getReplenishmentTaskRulePOs();
		return BeanUtils.copyList(pos,MonthlyPeakOrLowRule.class);
	}
	
	@Override
	public void submit(List<Integer> taskIds, int operator) {
		for (Integer taskId : taskIds) {
			ReplenishmentTaskPO po=this.replenishmentTaskDao.getObject(taskId);
			if(po.getStatus()!=ReplenishmentTaskStatus.未申请.getVal()
					&&po.getStatus()!=ReplenishmentTaskStatus.审核不通过.getVal())
				throw new BussinessException(EX_STATUS);
			//status 2 备货中
			po.setStatus(ReplenishmentTaskStatus.申请中.getVal());
			
			List<ReplenishmentTaskProductPO> ps=getTaskProduct(taskId);
			for (ReplenishmentTaskProductPO p : ps) {
				p.setStatus(po.getStatus());
			}
			addLog("申请审核", taskId, profileService.getUserNameById(operator));
		}
	}
	
	@Override
	public void reject(List<Integer> taskIds, int operator) {
		for (Integer taskId : taskIds) {
			ReplenishmentTaskPO po=this.replenishmentTaskDao.getObject(taskId);
			if(po.getStatus()!=ReplenishmentTaskStatus.申请中.getVal())
				throw new BussinessException(EX_STATUS);
			
			po.setStatus(ReplenishmentTaskStatus.审核不通过.getVal());
			po.setAuditor(operator);
			po.setAuditDate(new Date());
			List<ReplenishmentTaskProductPO> ps=getTaskProduct(taskId);
			for (ReplenishmentTaskProductPO p : ps) {
				p.setStatus(po.getStatus());
			}
			addLog("审核不通过", taskId, profileService.getUserNameById(operator));
		}
	}
	
	
	void addLog(String remark, int taskId,String operator){
	    //创建日志对象写入对应的值并记录到数据库
		ReplenishmentTaskLogPO po=new ReplenishmentTaskLogPO();
		po.setDate(new Date());
		po.setObjectId(taskId);
		po.setRemark(remark);
		po.setOperator(operator);
		
		this.replenishmentTaskLogDao.addObject(po);
	}
	
	@Override
	public void pass(List<Integer> taskIds, int operator) {
		String name=profileService.getUserNameById(operator);
		for (Integer taskId : taskIds) {
			ReplenishmentTaskPO po=this.replenishmentTaskDao.getObject(taskId);
			if(po.getStatus()!=ReplenishmentTaskStatus.申请中.getVal())
				throw new BussinessException(EX_STATUS);
			
			po.setStatus(ReplenishmentTaskStatus.备货中.getVal());
			po.setAuditDate(new Date());
			po.setOrderedDate(po.getAuditDate());
			po.setAuditor(operator);
			List<ReplenishmentTaskProductPO> ps=getTaskProduct(taskId);
			addLog("审核通过", taskId, profileService.getUserNameById(operator));
			for (ReplenishmentTaskProductPO p : ps) {
				p.setStatus(po.getStatus());
				//下达任务到cms
				addTask(p, name);
			}
		}
	}

	@Override
	public void pass(List<Integer> taskIds, int operator, String remark) {
		String name=profileService.getUserNameById(operator);   //根据operator编号来获取operatorName

        //遍历订单idList
		for (Integer taskId : taskIds) {
			ReplenishmentTaskPO po=this.replenishmentTaskDao.getObject(taskId);

			//如果补货订单状态不为申请中，就抛出异常
			if(po.getStatus()!=ReplenishmentTaskStatus.申请中.getVal())   //申请中:4
				throw new BussinessException(EX_STATUS);

			po.setStatus(ReplenishmentTaskStatus.备货中.getVal());   //改为？？？状态
			po.setAuditDate(new Date());
			po.setOrderedDate(po.getAuditDate());
			po.setAuditor(operator);

			List<ReplenishmentTaskProductPO> ps=getTaskProduct(taskId);
			addLog("审核通过", taskId, profileService.getUserNameById(operator));   //记录订单id日志，审核通过
			for (ReplenishmentTaskProductPO p : ps) {           //1、未申请 4、申请中 5、审核不通过 2、备货中 3、已完成  6、取消
				p.setStatus(po.getStatus());   //设置product的status设置为审核通过
				//把每个product分别下达任务到cms
				addTask(p, name,remark);
			}
		}
	}

	private OsmsStorageTask convertTaskType(int type){
		if(type==ReplenishmentType.FBA.getVal())
			return OsmsStorageTask.WHFBA_海外仓补货;
		if(type==ReplenishmentType.ORDER.getVal())
			return OsmsStorageTask.WH_自卖订单补货;
		return null;
	}
	
	/**
	 * 下达任务
	 * @param p
	 * @param operator
	 */
	private void addTask(ReplenishmentTaskProductPO p,String operator){
		p.setCmsTaskId(CMSClient.addTask(convertTaskType(p.getType()), p.getCmsProductId(), p.getTaskQty(), p.getTaskRemark(), operator));
		p.setTaskStatus(null);
		addLog(p.getCmsProductCode()+"下达任务: "+p.getCmsTaskId().intValue(), p.getReplenishmentTaskId(), operator);
		LOGGER.info(p.getCmsProductCode()+"下达任务: "+p.getCmsTaskId().intValue());
	}

	/**
	 * 下达任务   通讯到cms
	 * @param p
	 * @param operator
	 */
	private void addTask(ReplenishmentTaskProductPO p,String operator,String remark){
	    //通讯到cms 传入:任务类型，cmsProductId，商品数量，备注
        //convertTaskType(p.getType()) 更具type来判断是 WHFBA_海外仓补货还是 WH_自卖订单补货
		int cmsTaskId = CMSClient.addTask(convertTaskType(p.getType()), p.getCmsProductId(), p.getTaskQty(), p.getTaskRemark() + remark, operator);
		p.setCmsTaskId(cmsTaskId);
		p.setTaskStatus(null);   //这个不一样，是任务状态

		addLog(p.getCmsProductCode()+"下达任务: "+p.getCmsTaskId().intValue(), p.getReplenishmentTaskId(), operator);
		LOGGER.info(p.getCmsProductCode()+"下达任务: "+p.getCmsTaskId().intValue());
	}


	/**
	 * 重新下达任务
	 * @param p
	 * @param operator
	 */
	private void reAddTask(ReplenishmentTaskProductPO p,String operator){
		Integer oldCmsTaskId = p.getCmsTaskId();
		p.setCmsTaskId(CMSClient.reAddTask(oldCmsTaskId, p.getTaskQty(), p.getTaskRemark(), operator));
		p.setTaskStatus(null);
		addLog(p.getCmsProductCode()+"重新下达任务: "+oldCmsTaskId.intValue()+"-->"+p.getCmsTaskId().intValue(),
				p.getReplenishmentTaskId(), operator);
		LOGGER.info(p.getCmsProductCode()+"重新下达任务: "+oldCmsTaskId.intValue()+"-->"+p.getCmsTaskId().intValue());
	}
	
	@Override
	public void cancelMoreBatchWaitTaskProduct(int taskProductId) {
		ReplenishmentTaskProductPO tp=replenishmentTaskProductDao.getObject(taskProductId);
		if(tp.getMoreBatchAuditStatus().equals(MoreBatchAuditStatus.等待.getVal())){
			tp.setStatus(ReplenishmentTaskStatus.取消.getVal());
			tp.setMoreBatchAuditStatus(MoreBatchAuditStatus.取消.getVal());
			
			addLog(tp.getCmsProductCode()+"订单商品已经备货，取消超批等待的任务", tp.getReplenishmentTaskId(), "");
			
			cancleReplenishmentTaskProduct(tp);
		}
	}
	
	@Override
	public PageList<ReplenishmentTaskProduct> findReplenishmentTaskProduct(ReplenishmentTaskProductSearch search) {
		List<Param> parameters = new ArrayList<Param>();

		if (search.getType() > -1) {
			parameters.add(new Param("type", search.getType()));
		}
		if (search.getWaitMoreBatchAudit() > -1) {
			parameters.add(new Param("waitMoreBatchAudit", search.getWaitMoreBatchAudit()));
		}
		if(search.getPartProductWaitMoreBatchAudit()>-1){
			parameters.add(new Param("partProductWaitMoreBatchAudit", search.getWaitMoreBatchAudit()));
		}
		if (StringUtils.isNotEmpty(search.getOrderCode())) {
			parameters.add(new Param("orderCode", search.getOrderCode()));
		}
		if (StringUtils.isNotEmpty(search.getCode())) {
			parameters.add(new Param("code", search.getCode()));
		}
		if (StringUtils.isNotEmpty(search.getProductCode())) {
			parameters.add(new Param("productCode", search.getProductCode()));
		}
		if (CollectionUtils.isNotEmpty(search.getProductCodes())) {
			StringBuilder productCodeList = new StringBuilder();
			for (String productCode : search.getProductCodes()) {
				productCodeList.append(productCode + CMS_TASK_ID_S);
			}
			parameters.add(new Param("productCodes", productCodeList.substring(0, productCodeList.length() - 1)));
		}

		parameters.add(new Param("PageIndex", String.valueOf(search.getCurrentPage())));
		parameters.add(new Param("PageSize", String.valueOf(search.getPageSize())));

		
		PageList<ReplenishmentTaskProduct> pl = replenishmentTaskDao.findPageListByStoredProcedure(search.getCurrentPage(),
				search.getPageSize(), "searchReplenishmentTaskProducts", parameters, ReplenishmentTaskProduct.class);

		return pl;
	}
	
	public int getOrderPurchaseWaitMoreBatchAudit(int tableType){
		String hql="SELECT COUNT(*) AS count FROM dbo.replenishment_task_product a    " +
				"WHERE  a.order_purchase=1 AND a.more_batch_audit_status=1 ";
		
		if(tableType==1){
			hql=" SELECT COUNT(*) AS count FROM dbo.replenishment_task_product a WHERE  type in (1,2)  AND " +
					"a.more_batch_audit_status=1 and order_purchase IS NULL ";
		}
		
		Object o=replenishmentTaskDao.getSingleObjectBySql(hql, null);
		if(o!=null)
			return Integer.valueOf(o.toString());
		return 0;
	}
	
	@Override
	public void auditMoreBatch(List<Integer> taskProductIds, String remark, Integer handle, int operator) {
		for (Integer taskProductId : taskProductIds) {
			ReplenishmentTaskProductPO tp=replenishmentTaskProductDao.getObject(taskProductId);
			if(tp.getMoreBatchAuditStatus()==null
					||(!tp.getMoreBatchAuditStatus().equals(MoreBatchAuditStatus.待审核.getVal())
					&&!tp.getMoreBatchAuditStatus().equals(MoreBatchAuditStatus.等待.getVal()))){
				throw new BussinessException(EX_STATUS);
			}
			
			//情况等待的订单项
			if(tp.getMoreBatchAuditStatus().equals(MoreBatchAuditStatus.等待.getVal())){
				setWaitReplenishment(tp, null);
			}
			
			tp.setMoreBatchAuditRemark(remark);
			if(handle==1){//通过
				auditMoreBatchPass(tp, operator);
			}else if(handle==2){//取消
				auditMoreBatchCancel(tp,operator);
			}else if(handle.equals(3)){//等待
				auditMoreBatchWait(tp, operator);
			}
		}
	}
	
	private void auditMoreBatchPass(ReplenishmentTaskProductPO tp, int operator){
		tp.setMoreBatchAuditStatus(MoreBatchAuditStatus.审核通过.getVal());
		String name = profileService.getUserNameById(operator);
		addLog(tp.getCmsProductCode()+" 超批审核：通过", tp.getReplenishmentTaskId(), name);
		//非配件
		if(BooleanUtils.isNotTrue(tp.getIsPartProduct())){
			tp.setOldTaskQty(tp.getTaskQty());
			tp.setTaskQty(tp.getMoreBatchQuantity());
			
			ReplenishmentTaskPO po = replenishmentTaskDao.getObject(tp.getReplenishmentTaskId());
			po.setSumProductUnitNum(po.getSumProductUnitNum()-tp.getReplenishmentNum());
			tp.setReplenishmentNum(tp.getMoreBatchQuantity().intValue()/tp.getUnitQty());
			po.setSumProductUnitNum(po.getSumProductUnitNum()+tp.getReplenishmentNum());
			
			reAddTask(tp, name);
		}else{
			//重新下达
			reAddTask(tp, name);
			//新任务
			copyTask(tp, name, operator);
		}
		
	}
	
	/**
	 * 配件超批，下达一个新任务
	 * @param tp
	 */
	private void copyTask(ReplenishmentTaskProductPO tp,String operator,int operatorId){
		List<ReplenishmentTaskProduct> taskProducts=new ArrayList<ReplenishmentTaskProduct>();
		ReplenishmentTaskProduct taskProduct=BeanUtils.copyProperties(tp, ReplenishmentTaskProduct.class,new String[]{"id"});
		taskProducts.add(taskProduct);
		taskProduct.setMoreBatchAuditStatus(null);
		taskProduct.setMoreBatchQuantity(null);
		taskProduct.setTaskQty(tp.getMoreBatchQuantity()-tp.getTaskQty());
		taskProduct.setTaskPendingQty(taskProduct.getTaskQty());
		taskProduct.setReplenishmentNum(taskProduct.getTaskQty().intValue()/taskProduct.getUnitQty());
		taskProduct.setIsPartProduct(null);
		taskProduct.setMainTaskId(null);
		taskProduct.setCmsTaskId(null);
		ReplenishmentTaskPO taskPO=this.replenishmentTaskDao.getObject(tp.getReplenishmentTaskId());
		if(tp.getType()==ReplenishmentType.ORDER_PURCHASE.getVal()){//生成新的补货单
			taskProduct.setType(ReplenishmentType.ORDER.getVal());
			taskProduct.setTaskRemark("补货单"+taskPO.getCode()+"超批审核生成。");
			int taskId=createReplenishmentTasksPri(taskProducts, operatorId);
			List<ReplenishmentTaskProductPO>  pos=getTaskProduct(taskId);
			for (ReplenishmentTaskProductPO p : pos) {
				addTask(p, operator);
			}
		}else{
			taskProduct.setTaskRemark("超批审核商品");
			List<ReplenishmentTaskProduct> pos=appendReplenishmentTasks(tp.getReplenishmentTaskId(), taskProducts, operatorId);
			for (ReplenishmentTaskProduct p : pos) {
				addTask(this.replenishmentTaskProductDao.getObject(p.getId()), operator);
			}
		}

	}
	
	/**
	 * 超批审核 ：取消
	 * @param tp
	 */
	private void auditMoreBatchCancel(ReplenishmentTaskProductPO tp, int operator){
		tp.setStatus(ReplenishmentTaskStatus.取消.getVal());
		tp.setMoreBatchAuditStatus(MoreBatchAuditStatus.取消.getVal());
		
		addLog(tp.getCmsProductCode()+" 超批审核：取消", tp.getReplenishmentTaskId(), profileService.getUserNameById(operator));
		
		cancleReplenishmentTaskProduct(tp);
		
		if(BooleanUtils.isNotTrue(tp.getIsPartProduct())){//非配件
			tp.setReplenishmentNum(0);
			tp.setTaskQty(0);
		}
	}
	
	/**
	 * 超批审核 ：等待
	 * @param tp
	 * @param operator
	 */
	private void auditMoreBatchWait(ReplenishmentTaskProductPO tp, int operator){
		if(tp.getType()!=ReplenishmentType.ORDER_PURCHASE.getVal()
				||BooleanUtils.isTrue(tp.getIsPartProduct())){
			throw new BussinessException("只有自卖订单采购类型的商品且非配件才能有超批等待");
		}
		
		tp.setMoreBatchAuditStatus(MoreBatchAuditStatus.等待.getVal());
		
		setWaitReplenishment(tp,tp.getId());
		
		addLog(tp.getCmsProductCode()+" 超批审核：等待", tp.getReplenishmentTaskId(), profileService.getUserNameById(operator));
	}

	/**
	 * 设置订单商品超批等待
	 * @param tp
	 * @param id
	 */
	private void setWaitReplenishment(ReplenishmentTaskProductPO tp,Integer id) {
		BaseOrderView o=orderSchedule.getOrderByCode(tp.getObjectCode());
		if(o!=null){
			orderSchedule.getInstanceMessage(o.getTableType()).moreBatchAuditWait(tp.getObjectItemId(), id);
		}
	}
	
	private ReplenishmentTaskProductPO getReplenishmentTaskProductPOByBussinessId(int cmsTaskId){
		String hql="from ReplenishmentTaskProductPO where cmsTaskId =?";
		return this.replenishmentTaskProductDao.findByHql(hql, cmsTaskId);
	}
	
	
	private ReplenishmentTaskProductPO processTask(JSONObject message, int cmsTaskId,int taskType){
		int cmsProductId=message.getInt("productId");
		int taskQty=message.getInt("taskQty");
		
		List<ReplenishmentTaskProduct> taskProducts=new ArrayList<ReplenishmentTaskProduct>();
		ReplenishmentTaskProduct taskProduct=new ReplenishmentTaskProduct();
		taskProduct.setCmsProductId(cmsProductId);
		CMSProduct cp=CMSClient.getCMSProduct(cmsProductId);
		ShopProductCmsInfo cms=requestShopProductCmsInfo(cp.getCode());
		taskProduct.setCmsProductCode(cp.getCode());
		taskProduct.setCmsProductId(cms.getCmsProductId());
		taskProduct.setUnit(cms.getUnit());
		taskProduct.setUnitQty(cms.getUnitQuantity());
		taskProduct.setReplenishmentNum(taskQty/cms.getUnitQuantity());
		taskProduct.setTaskQty(taskQty);
		taskProduct.setTaskPendingQty(taskQty);
		taskProduct.setCmsTaskId(cmsTaskId);
		taskProduct.setStatus(ReplenishmentTaskStatus.备货中.getVal());
		taskProducts.add(taskProduct);
		
		if(taskType==1){//订单任务
			taskProduct.setIsOrderPurchase(true);
			taskProduct.setType(ReplenishmentType.ORDER_PURCHASE.getVal());
			createReplenishmentTasksPri(taskProducts, 0);
		}
		if(taskType==2){//打样加工 配件任务
			taskProduct.setIsPartProduct(true);
			if (message.containsKey("isSample")&&message.getBoolean("isSample")) {//打样加工
				taskProduct.setType(ReplenishmentType.ORDER.getVal());
				taskProduct.setIsSample(true);
				taskProduct.setReplenishmentTaskId(createReplenishmentTasksPri(taskProducts, 0));
			}else if(message.containsKey("pTaskIds")){
				String pCmsTaskId=message.getString("pTaskIds");
				//配件,挂上级,随机
				String[] pIds=pCmsTaskId.split(CMS_TASK_ID_S);
				ReplenishmentTaskProductPO parentPo=null;
				for (String pId : pIds) {
					parentPo=getReplenishmentTaskProductPOByBussinessId(Integer.valueOf(pId));
					if(parentPo!=null) break;
				}
				if(parentPo==null)
					return null;
				//做一级处理
				taskProduct.setMainTaskId(parentPo.getMainTaskId()==null?parentPo.getId():parentPo.getMainTaskId());
				taskProduct.setRelatedCmsTaskId(pCmsTaskId);
				taskProduct.setIsOrderPurchase(parentPo.getIsOrderPurchase());
				taskProduct.setReplenishmentTaskId(parentPo.getReplenishmentTaskId());
				appendReplenishmentTasks(parentPo.getReplenishmentTaskId(), taskProducts, 0);
			}
		}
		if(taskProduct.getReplenishmentTaskId()>0)
			addLog("同步任务："+cmsTaskId, taskProduct.getReplenishmentTaskId(), "系统");
		
		return getReplenishmentTaskProductPOByBussinessId(cmsTaskId);
	}
	
	
	public void readMessage(){
		//打样加工单同步
		//配件同步
		List<CmsMessage> ms=CMSClient.getUnDealCMSMessage();
		if(CollectionUtils.isNotEmpty(ms)){
			List<Integer> ids=new ArrayList<Integer>();
			for (CmsMessage m : ms) {
				JSONObject message = null;
//				try {
					ids.add(m.getId());
					message=JSONObject.fromObject(m.getMessage());
					LOGGER.info("replenishment message:"+message);
					int mType=message.getInt("type");
					int taskId=message.getInt("taskId");
					ReplenishmentTaskProductPO pp=getReplenishmentTaskProductPOByBussinessId(taskId);
					if(mType==3){//新建
						int taskType=message.getInt("taskType");
						if(pp==null){
							 pp=processTask(message, taskId,taskType);
							//配件只需采购，并没超批，也只是随机显示在其中的一共补货单中，并且备注“补货单A、C一起加工采购”
							if(pp==null)
								continue;
							if(message.containsKey("pTaskIds"))
								setMorePartRemark(message.getString("pTaskIds"), pp);
							syncTaskCommonInfo(message, taskType, pp);
						}
					}else if(mType==1){//备货
						if(pp==null)
							continue;
						int taskType=message.getInt("taskType");
						//基础信息
						syncTaskCommonInfo(message, taskType, pp);
						
						if(message.containsKey("completeQty")){
							pp.setComplatedQty(message.getInt("completeQty"));
							pp.setTaskPendingQty(pp.getTaskQty()-pp.getComplatedQty());
						}else if(pp.getComplatedQty()==null){
							pp.setComplatedQty(0);
						}
						
						if(!isMoreBatchAuditing(pp.getMoreBatchAuditStatus())){
							if(pp.getTaskStatus().intValue()==CMSTaskStatus._已结束.getVal()&&pp.getComplatedQty().equals(0)
									){
								//取消
								cancleReplenishmentTaskProduct(pp);
							} else if(!isMoreBatchAuditing(pp.getMoreBatchAuditStatus())&&isComplatedProductTask(pp.getTaskStatus())){
								//更新补货单
								complatedReplenishmentTaskProduct(pp);
							}
						}
						
					}else if(mType==2){//超批
						if(pp==null)
							continue;
						if(pp.getMoreBatchAuditStatus()==null||pp.getMoreBatchAuditStatus()==MoreBatchAuditStatus.审核通过.getVal()){//重新超批
							pp.setMoreBatchQuantity(message.getInt("excessQty"));
							pp.setMoreBatchFeedBack(message.getString("excessRemark"));
							pp.setMoreBatchAuditStatus(MoreBatchAuditStatus.待审核.getVal());
							if(BooleanUtils.isTrue(pp.getIsPartProduct())&&message.containsKey("pTaskIds")){//配件商品备注字段显示“补货单XXX、YYY一起加工采购”
								String pTaskId= message.getString("pTaskIds");
								pp.setRelatedCmsTaskId(pTaskId);
								setMorePartRemark(pTaskId, pp);
							}
							addLog(pp.getCmsProductCode()+"商品超批", pp.getReplenishmentTaskId(), "cms");
						}
					}
//				} catch (Exception e) {
//					StaticUtils.addEmail("补货单消息同步异常", (message!=null?message.toString()+"\n":"")+e.getMessage());
//					if(e.getMessage()!=null&&e.getMessage().contains("could not load an entity")){//2018-05-03 死锁，与“统计cms待补货量”任务冲突
//						ids.remove(m.getId());
//					}
//				}
			}
			
			CMSClient.dealCMSMessages(ids);
		}
	}

	
	/**
	 * 同步基础信息
	 * @param message
	 * @param taskType
	 * @param pp
	 */
	private void syncTaskCommonInfo(JSONObject message, int taskType, ReplenishmentTaskProductPO pp) {
		int status = message.getInt("taskStatus");
		if(!(isMoreBatchAuditing(pp.getMoreBatchAuditStatus())&&status==CMSTaskStatus._已取消.getVal())
				){//正在超批是取消 不同步
			if(pp.getTaskStatus()==null||pp.getTaskStatus().intValue()!=status){
				pp.setTaskStatus(status);
				if(status==CMSTaskStatus._已取消.getVal()){
					//取消
					cancleReplenishmentTaskProduct(pp);
				}
			}
		}
		
		
		if(message.containsKey("orderCode"))
			pp.setObjectCode(message.getString("orderCode"));
		if(message.containsKey("businessId"))
			pp.setObjectItemId(message.getInt("businessId"));
		pp.setTaskStrategyDepartment(message.getString("strategyDepartment"));
		pp.setTaskType(taskType);
	}
	
	private void setMorePartRemark(String pTaskIds, ReplenishmentTaskProductPO pp) {
		if(pTaskIds.contains(CMS_TASK_ID_S)){//两个或以上
			String hql="select a from ReplenishmentTaskPO a,ReplenishmentTaskProductPO b " +
					"where a.id=b.replenishmentTaskId and b.cmsTaskId in ("+pTaskIds+") and a.id!="+pp.getReplenishmentTaskId();
			
			List<ReplenishmentTaskPO>  pos=this.replenishmentTaskDao.findListByHql(hql);
			StringBuilder sb=new StringBuilder();
			if(CollectionUtils.isNotEmpty(pos)){
				for (ReplenishmentTaskPO r : pos) {
					sb.append(r.getCode()).append(CMS_TASK_ID_S);
				}
				pp.setTaskRemark("补货单"+sb.toString()+"一起加工采购");
			}
		}
	}

	@Override
	public void updateReplenishmentTaskProduct(List<ReplenishmentTaskProduct> taskProducts) {
		for (ReplenishmentTaskProduct taskProduct : taskProducts) {
			ReplenishmentTaskProductPO po=this.replenishmentTaskProductDao.getObject(taskProduct.getId());
			po.setTaskRemark(taskProduct.getTaskRemark());
		}
	}
	
	public List<ReplenishmentTaskProduct> getMoreBatchPassTaskProduct(int cmsProductId){
		String sql="SELECT b.code,a.cms_product_code AS cmsProductCode,a.cms_product_id AS cmsProductId,a.status,a.type," +
				"a.more_batch_quantity AS moreBatchQuantity,a.more_batch_audit_status AS moreBatchAuditStatus " +
				" FROM dbo.replenishment_task_product a " +
				" INNER JOIN dbo.replenishment_task b ON a.replenishment_task_id=b.id" +
				"  WHERE   a.cms_product_id=? ";
		List<Object> params=new ArrayList<Object>();
		params.add(cmsProductId);
		return replenishmentTaskProductDao.findListBySql(sql, params, ReplenishmentTaskProduct.class);
	}
}
