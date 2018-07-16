package com.itecheasy.core.order;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.itecheasy.common.PageList;
import com.itecheasy.common.attachment.AttachmentService;
import com.itecheasy.common.dao.Criteria;
import com.itecheasy.common.dao.Order.OrderType;
import com.itecheasy.common.dao.Restriction;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.order.dao.PackageProblemAttachmentDao;
import com.itecheasy.core.order.dao.PackageProblemDao;
import com.itecheasy.core.order.dao.PackageProblemHistoryDao;
import com.itecheasy.core.order.dao.VPackageProblemDao;
import com.itecheasy.core.po.PackageProblemAttachmentPO;
import com.itecheasy.core.po.PackageProblemHistoryPO;
import com.itecheasy.core.po.PackageProblemPO;
import com.itecheasy.core.po.VPackageProblemPO;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.task.BaseOrderDetailView;
import com.itecheasy.core.task.BaseOrderView;
import com.itecheasy.core.user.ProfileService;
import com.itecheasy.core.user.User;
import com.itecheasy.webservice.client.DMSClient;
import com.itecheasy.webservice.client.DMSUtils.OrderQuestionProcessResultType;
import com.itecheasy.webservice.client.DMSUtils.OrderQuestionProcessType;
/**
 * @author wanghw
 * @date 2016-2-23
 * @description 问题件
 * @version 1.1.7
 */
public class PackageProblemServiceImpl implements PackageProblemService {
	private static final String COULD_NOT_OPERATING_FOR_ERROR_PARAM = "参数错误，无法操作！";

	private static final String COULD_NOT_OPERATING_FOR_ERROR_STATUS = "无法操作！";

	private final static String PACKAGE_PROBLEM_ATTACHMENT = "PACKAGE_PROBLEM_ATTACHMENT";

	private PackageProblemDao packageProblemDao;
	private PackageProblemHistoryDao packageProblemHistoryDao;
	private PackageProblemAttachmentDao packageProblemAttachmentDao;
	private AttachmentService attachmentService;
	private SystemService systemService;
	private ProfileService profileService;
	private VPackageProblemDao vPackageProblemDao;
	private IOrderSchedule orderSchedule;

	public void setOrderSchedule(IOrderSchedule orderSchedule) {
		this.orderSchedule = orderSchedule;
	}

	public void setvPackageProblemDao(VPackageProblemDao vPackageProblemDao) {
		this.vPackageProblemDao = vPackageProblemDao;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public void setAttachmentService(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}

	public void setPackageProblemDao(PackageProblemDao packageProblemDao) {
		this.packageProblemDao = packageProblemDao;
	}

	public void setPackageProblemHistoryDao(PackageProblemHistoryDao packageProblemHistoryDao) {
		this.packageProblemHistoryDao = packageProblemHistoryDao;
	}

	public void setPackageProblemAttachmentDao(PackageProblemAttachmentDao packageProblemAttachmentDao) {
		this.packageProblemAttachmentDao = packageProblemAttachmentDao;
	}

	@Override
	public void createPackageProblem(PackageProblem packageProblem) {
		BaseOrderView order = orderSchedule.getOrderByCode(packageProblem.getOrderCode());
		if (order == null) {
			return;
		}
		//退件直接上架操作
		backPackagePutaway(packageProblem, order);
		PackageProblemPO po=BeanUtils.copyProperties(packageProblem, PackageProblemPO.class);
		po.setOrderId(order.getId());
		packageProblemDao.mergeObject(po);
	}
	
	@Override
	public void updatePackageProblem(PackageProblem packageProblem){
		PackageProblemPO po = getPackageProblemPOByOrderCode(packageProblem.getOrderCode(),packageProblem.getTypeTag());
		if(po==null)
			return;
		
		po.setType(packageProblem.getType());
	}
	
	@Override
	public void backPackageConfirmType(String orderCode,String operator,String confirmType){
		PackageProblemPO po = getPackageProblemPOByOrderCode(orderCode,PackageProblemTypeTag.DMS_退件.getVal());
		if(po==null)
			return;
		
		po.setConfirmType(confirmType);
	}
	
	/**
	 * 退件上架
	 * @param packageProblem
	 * @param order
	 */
	private  void backPackagePutaway(PackageProblem packageProblem,BaseOrderView order){
		if(packageProblem.getType()==PackageProblemType.退件.getVal()){
			orderSchedule.getInstance(order.getTableType()).putway(order.getId(), "DMS");
			packageProblem.setConfirmType(BackDeliveryProcessType.上架.name());
			packageProblem.setCloseUser("系统");
			packageProblem.setCloseDate(new Date());
			packageProblem.setStatus(PackageProblemStatus.OSMS_COLSED.getVal());
		}
	}

	private PackageProblemPO getPackageProblemPOByOrderCode(String orderCode,int typeTag) {
		Criteria criteria = new Criteria(PackageProblemPO.class);
		criteria.and(Restriction.eq("orderCode", orderCode));
		criteria.and(Restriction.eq("typeTag", typeTag));
		criteria.order("createDate", OrderType.desc);
		return packageProblemDao.get(criteria);
	}

	@Override
	public void applyPackageProblem(PackageProblemHistory history, int packageProblemId, int processResultType,String operator)
			throws BussinessException {
		PackageProblemPO po = packageProblemDao.getObject(packageProblemId);
		if (po == null) {
			throw new BussinessException(COULD_NOT_OPERATING_FOR_ERROR_PARAM);
		}

		if (po.getStatus() == PackageProblemStatus.OSMS_COLSED.getVal()) {
			throw new BussinessException(COULD_NOT_OPERATING_FOR_ERROR_PARAM);
		}
					
		if(history!=null){
			PackageProblemHistoryPO his = BeanUtils.copyProperties(history, PackageProblemHistoryPO.class);
			his.setPackageProblemId(po.getId());
			his.setReplyDate(new Date());
			
			int hisId = packageProblemHistoryDao.addObject(his);
			
			if (CollectionUtils.isNotEmpty(history.getAttachments())) {
				// 写入附件
				for (PackageProblemAttachment atta : history.getAttachments()) {
					
					String UUID = saveAttachment(hisId, atta);
					atta.setFileCode(UUID);
					atta.setPackageProblemHistoryId(hisId);
				}
			}
			
			List<PackageProblemAttachmentPO> attaPO = BeanUtils.copyList(history.getAttachments(),
					PackageProblemAttachmentPO.class);
			packageProblemAttachmentDao.addObject(attaPO);
			// 通讯dms
			DMSClient.receviceQuestion(po.getOrderCode(), history.getReplyUser(), history.getContent(), history.getAttachments());
		}
		
		apply2other(processResultType, operator, po);
		
	}

	/**
	 * 未妥投件处理2dms
	 * @param processResultType
	 * @param operator
	 * @param po
	 * @throws BussinessException
	 */
	private void apply2other(int processResultType, String operator, PackageProblemPO po) throws BussinessException {
		if(po.getType()==PackageProblemType.未妥投件.getVal()){
			BaseOrderDetailView order=orderSchedule.getOrderDetailByCode(po.getOrderCode());
			if(order.getSendGroupId()!=null){
				List<BaseOrderDetailView> orders= orderSchedule.getTicketGrouypByGroupId(order.getSendGroupId());
				for (BaseOrderDetailView order2 : orders) {
					apply2other4group(processResultType, operator, 
							this.getPackageProblemPOByOrderCode(order2.getCode(), PackageProblemTypeTag.DMS_问题件_未妥投件.getVal()),
							order2);
				}
			}else{
				apply2other4group(processResultType, operator, po, order);
			}
		}
	}

	private void apply2other4group(int processResultType, String operator, PackageProblemPO po, BaseOrderDetailView order)
			throws BussinessException {
		if(po.getStatus()==PackageProblemStatus.处理中.getVal()){
			if(order!=null){
				po.setConfirmType(OrderQuestionProcessType.getOrderQuestionProcessTypeText(processResultType));
				//通讯dms
				DMSClient.receviceOrderQuestionProcessType(po.getOrderCode(), 
						operator, processResultType, systemService.getShopInfo(order.getShopId()));
				//上架
				if(po.getConfirmType().equals(OrderQuestionProcessType.国内上架.name())){
					orderSchedule.getInstance(order.getTableType()).setPutawayFlag(po.getOrderId(),operator);
				}
			}		
		}
		
		po.setStatus(PackageProblemStatus.OSMS_COLSED.getVal());
		po.setCloseDate(new Date());
		po.setCloseUser(operator);
		packageProblemDao.mergeObject(po);
	}
	
	/**
	 * dms消息接收，未妥投件处理dms2self
	 * @param processResult
	 * @param po
	 */
	private void other2apply(Integer processResult, PackageProblemPO po,String operatorName) {
		if(po.getType()==PackageProblemType.未妥投件.getVal()){
			if(OrderQuestionProcessResultType.丢包_无赔偿.isEquals(processResult)||
					OrderQuestionProcessResultType.丢包_有赔偿.isEquals(processResult)){
				//dms已处理
				if(po.getStatus()<PackageProblemStatus.DMS_已关闭.getVal()){
					po.setStatus(PackageProblemStatus.DMS_已关闭.getVal());
				}
				po.setConfirmType(OrderQuestionProcessResultType.getOrderQuestionProcessResultTypeText(processResult));
			}
			//dms处理消息的结果
//			else if(OrderQuestionProcessResultType.确认.isEquals(processResult)){
//				//上架
//				if(po.getConfirmType().equals(OrderQuestionProcessType.国内上架.name())){
//					orderService.setPutawayFlag(po.getOrderId(),operatorName);
//				}
//			}
		}
	}

	private String saveAttachment(int objectId, PackageProblemAttachment atta){
		File tempFile = new File(DeployProperties.getInstance().getProperty("temp_dir") + PACKAGE_PROBLEM_ATTACHMENT
				+ "\\" + atta.getFileName());
		try {
			FileUtils.writeByteArrayToFile(tempFile, atta.getFile());
		} catch (IOException e) {
		}

		String UUID = attachmentService.addAttachment(PACKAGE_PROBLEM_ATTACHMENT, String.valueOf(objectId),
				atta.getFileName(), null, tempFile);
		return UUID;
	}

	@Override
	public void applyPackageProblem(String orderCode, String operatorName, String content, Date createTime,
			String[] downloads,String[] files,Integer processResult) {
		PackageProblemPO po = getPackageProblemPOByOrderCode(orderCode,PackageProblemTypeTag.DMS_问题件_未妥投件.getVal());
		if (po == null) {
			return;
		}
		other2apply(processResult, po,operatorName);
		
		po.setRead(false);
		PackageProblemHistoryPO his = new PackageProblemHistoryPO();
		his.setContent(content);
		his.setPackageProblemId(po.getId());
		his.setReplyDate(createTime);
		his.setReplyUser(operatorName);
		int hisId=packageProblemHistoryDao.addObject(his);
		
		//附件
		if(downloads!=null&&files!=null){
			for (int i = 0; i < files.length; i++) {
				if(StringUtils.isEmpty(files[i])){
					continue;
				}
				PackageProblemAttachment atta=new PackageProblemAttachment();
				atta.setFileName(files[i]);
				String UUID = saveAttachment(hisId, files[i],downloads[i]);
				
				atta.setFileCode(UUID);
				atta.setPackageProblemHistoryId(hisId);
				packageProblemAttachmentDao.addObject(BeanUtils.copyProperties(atta, PackageProblemAttachmentPO.class));
			}
		}
		
	}

	
	
	@Override
	public void confirmOrderQuestion(int packageProblemId,String operator)
			throws BussinessException{
		PackageProblemPO po= packageProblemDao.getObject(packageProblemId);
		if(po==null)
			return;
					
		if(po.getType()!=PackageProblemType.未妥投件.getVal()||po.getStatus()!=PackageProblemStatus.DMS_已关闭.getVal())
			throw new BussinessException(COULD_NOT_OPERATING_FOR_ERROR_PARAM);
		
		
		po.setStatus(PackageProblemStatus.OSMS_COLSED.getVal());
		
		po.setCloseDate(new Date());
		po.setCloseUser(operator);
	}
	
	private String saveAttachment(int objectId, String fileName,String downName){
		try {
			String imgUrl=DeployProperties.getInstance().getProperty("dms.attachment.down")+downName;
			URL url=new URL(imgUrl);
			File tempFile = new File(DeployProperties.getInstance().getProperty("temp_dir") + PACKAGE_PROBLEM_ATTACHMENT
					+ "\\" + fileName);
			FileUtils.copyURLToFile(url, tempFile);
//			PictureUtils.downLoadPic(imgUrl,fileName);
			String UUID = attachmentService.addAttachment(PACKAGE_PROBLEM_ATTACHMENT, String.valueOf(objectId),
					fileName, null, tempFile);
			return UUID;
		} catch (IOException e) {
			
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			URL url=new URL("http://192.168.111.78:9090/DMS/questionFile?fileName=201602271403cc567938415697f17b647c5a7d70.jpg");
			FileUtils.copyURLToFile(url, new File("c:\\sss.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void closePackageProblem(int packageProblemId, String operator) throws BussinessException {
		PackageProblemPO po = packageProblemDao.getObject(packageProblemId);
		if (po == null) {
			throw new BussinessException(COULD_NOT_OPERATING_FOR_ERROR_PARAM);
		}

		if (po.getStatus() == PackageProblemStatus.OSMS_COLSED.getVal()) {
			throw new BussinessException(COULD_NOT_OPERATING_FOR_ERROR_STATUS);
		}

		po.setStatus(PackageProblemStatus.OSMS_COLSED.getVal());
		po.setCloseDate(new Date());
		po.setCloseUser(operator);
		packageProblemDao.mergeObject(po);

		// dms
		DMSClient.closeQuestion(po.getOrderCode());
	}
	
	@Override
	public PackageProblem getPackageProblemByOrder(int orderId){
		String hql="from PackageProblemPO where orderId=? order by createDate desc";
		PackageProblemPO po =packageProblemDao.findByHql(hql, orderId);
		if(po!=null)
			return BeanUtils.copyProperties(po, PackageProblem.class);
		return null;
	}
	
	@Override
	public void closePackageProblem(String orderCode, String operator, Date closeTime) {
		PackageProblemPO po =this.getPackageProblemPOByOrderCode(orderCode,PackageProblemTypeTag.DMS_问题件_未妥投件.getVal());
		if(po==null){
			return ;
		}
		po.setRead(false);
		if(po.getStatus()<PackageProblemStatus.DMS_已关闭.getVal()){
			po.setStatus(PackageProblemStatus.DMS_已关闭.getVal());
			po.setCloseUser(operator);
			po.setCloseDate(closeTime);
		}
		
		packageProblemDao.mergeObject(po);
	}

	@Override
	public void reopenPackageProblem(int packageProblemId, int operator) throws BussinessException {
		PackageProblemPO po = packageProblemDao.getObject(packageProblemId);
		if (po == null) {
			throw new BussinessException(COULD_NOT_OPERATING_FOR_ERROR_PARAM);
		}
		if (po.getStatus() == PackageProblemStatus.处理中.getVal()) {
			throw new BussinessException(COULD_NOT_OPERATING_FOR_ERROR_STATUS);
		}
		if(po.getType()!=PackageProblemType.问题件.getVal()){
			throw new BussinessException("只有普通问题件可重新开启!");
		}
		if(this.getPackageProblemPOByOrderCode(po.getOrderCode(), po.getTypeTag()).getId()!=po.getId())
			throw new BussinessException("只有最新的问题件才能开启！");

		BaseOrderDetailView order = orderSchedule.getOrderDetailByCode(po.getOrderCode());
		if (!systemService.isTheSamePerson(order.getMerchandiserId(), operator)) {
			throw new BussinessException("不是自己的问题件，无法操作！");
		}

		po.setStatus(PackageProblemStatus.处理中.getVal());
		packageProblemDao.mergeObject(po);
		
		//通讯dms
		DMSClient.reopen(po.getOrderCode(), profileService.getUserNameById(operator));
	}
	
	@Override
	public void reopenPackageProblem(String orderCode, String operator) {
		PackageProblemPO po =this.getPackageProblemPOByOrderCode(orderCode,PackageProblemTypeTag.DMS_问题件_未妥投件.getVal());
		if(po==null){
			return ;
		}
		po.setRead(false);
		po.setStatus(PackageProblemStatus.处理中.getVal());
		packageProblemDao.mergeObject(po);
	}

	@Override
	public PageList<PackageProblemVO> findPackageProblems(PackageProblemSerchForm form) {
		StringBuilder where=new StringBuilder();
		String sql="SELECT * FROM dbo.v_package_problem ";
//		String sql="SELECT * FROM package_problem ";

		List<Object> params=new ArrayList<Object>();
		if(form.getShippingMethodId()>-1){
			where.append(" and shipping_method=?");
			params.add(form.getShippingMethodId());
		}
		if(form.getType()>-1){
			where.append(" and type=?");
			params.add(form.getType());
		}
		if(form.getPacageStatus()>-1){
			where.append(" and package_status=?");
			params.add(form.getPacageStatus());
		}
		if(form.getShopId()>-1){
			where.append(" and shop_id=?");
			params.add(form.getShopId());
		}
		if(StringUtils.isNotEmpty(form.getCreateUserName())){
			where.append(" and create_user_name=?");
			params.add(form.getCreateUserName());
		}
		
		if(StringUtils.isNotEmpty(form.getProcessUserId())){
			where.append(" and merchandiser_code=?");
			params.add(form.getProcessUserId());
		}
		if(StringUtils.isNotEmpty(form.getDeliveryCustomerService())){
			where.append(" and delivery_customer_service=?");
			params.add(form.getDeliveryCustomerService());
		}
		if(StringUtils.isNotEmpty(form.getOrderCode())){
			where.append(" and order_code like ?");
			params.add("%"+form.getOrderCode()+"%");
		}
		if(StringUtils.isNotEmpty(form.getCustomerName())){
			where.append(" and customer_name like ?");
			params.add("%"+form.getCustomerName()+"%");
		}
		if(StringUtils.isNotEmpty(form.getCustomerAccount())){
			where.append(" and customer_account like ?");
			params.add("%"+form.getCustomerAccount()+"%");
		}
		if(form.getStatus()>-1){
			where.append(" and status=?");
			params.add(form.getStatus());
		}
		if(StringUtils.isNotEmpty(form.getTraceCode())){
			where.append(" and tracking_code like ?");
			params.add("%"+form.getTraceCode()+"%");
		}

		PageList<VPackageProblemPO> pl=vPackageProblemDao.findPageListBySql(form.getCurrentPage(),
				form.getPageSize(), sql, where.toString(), " id desc ", params);
		
		if(pl!=null){
			PageList<PackageProblemVO> vo= BeanUtils.copyPageList(pl, PackageProblemVO.class);
			return vo;
		}
		return null;
	}

	@Override
	public List<PackageProblemHistory> getPackageProblemHistories(int packageProblemId) {
		String hql="from PackageProblemHistoryPO where packageProblemId=?";
		List<PackageProblemHistoryPO> pos= packageProblemHistoryDao.findListByHql(hql, packageProblemId);
		if(pos!=null){
			List<PackageProblemHistory> hiss=BeanUtils.copyList(pos, PackageProblemHistory.class);
			for (PackageProblemHistory his : hiss) {
				hql="from PackageProblemAttachmentPO where packageProblemHistoryId=?"; 
				List<PackageProblemAttachmentPO> attaPOs=packageProblemAttachmentDao.findListByHql(hql, his.getId());
				if(attaPOs!=null){
					his.setAttachments(BeanUtils.copyList(attaPOs, PackageProblemAttachment.class));
				}
			}
			return hiss;
		}
		return null;
	}

	@Override
	public void readPackageProblem(int packageProblemId) {
		PackageProblemPO po= packageProblemDao.getObject(packageProblemId);
		if(!po.isRead())
			po.setRead(true);
	}

	@Override
	public List<String> getPackageProblemCreateUser() {
		String sql="SELECT DISTINCT create_user_name FROM dbo.package_problem WITH(NOLOCK)";
		return packageProblemDao.getSimpleColumnBySql(sql, null);
	}

	@Override
	public List<String> getDeliveryCustomerService() {
		String sql="SELECT DISTINCT delivery_customer_service FROM dbo.package_problem WITH(NOLOCK)";
		return packageProblemDao.getSimpleColumnBySql(sql, null);
	}

	public int getPackageProblemHasNotReadMessageQty(int userId){
		String sql="SELECT COUNT([read]) AS total FROM dbo.v_package_problem WHERE merchandiser_code=? and  [read]=0";
		User u=profileService.getUserByID(userId);
		if(u!=null){
			Object r=packageProblemDao.getSingleObjectBySql(sql, new Object[]{u.getCode()});
			if(r!=null)
				return Integer.valueOf(r.toString());
		}
		
		return 0;
	}
}
