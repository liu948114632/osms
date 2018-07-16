package com.itecheasy.common;

import com.itecheasy.common.util.DeployProperties;

public class SystemConfig {
	//private static PropertyFileLoader po = null;
	
	//static {
		//po = new PropertyFileLoader("deploy_config.properties");
	//}

	public static Integer getProductExpandRight(){
		
		return Integer.parseInt(DeployProperties.getInstance().getProperty("prdocut_expand_right"));
	}
	
	public static String getTempPictureFilePath() {
		return DeployProperties.getInstance().getProperty("picture_temp_path");
	}

	/**
	 * 获取OA 个人加密的字符串
	 * @return
	 */
	public static String getOaWebservicePinCode() {
		return DeployProperties.getInstance().getProperty("oa_webservice_pincode");
	}
	
	/**
	 * 获取OMS 个人加密的字符串
	 * @return
	 */
	public static String getOmsWebservicePinCode() {
		return DeployProperties.getInstance().getProperty("oms_webservice_pincode");
	}
	
	
	/**
	 * 获取OA 个人信息服务的URL
	 * @return
	 */
	public static String getOaWebserviceURL() {
		return DeployProperties.getInstance().getProperty("oa_webservice_url");
	}
	
	/**
	 * 获取OA财务服务的URL
	 * 
	 * @return
	 */
	public static String getOaWebserviceFiscalURL() {
		return DeployProperties.getInstance().getProperty("oa_webservice_fiscal_url");
	}
	
	public static String getOMSWebServiceURL(){
		return DeployProperties.getInstance().getProperty("oms_webservice_url");
	}
	
	public static String getFMSWebServiceURL(){
		return DeployProperties.getInstance().getProperty("fms_webservice_url");
	}
	
	public static String getBarcodeWebServiceURL(){
		return DeployProperties.getInstance().getProperty("barcode.url");
	}
	/**
	 * 获取订单体积重量转换系数
	 * @return
	 */
	public static Integer getRate(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("rate"));
	}
	
	/**
	 * PandaHall报价权限ID 
	 */
	public static Integer getPandaHallQuoteRightId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("pandahall_quote_right_id"));
	}
	
	/**
	 * PandaWhole报价权限ID 
	 */
	public static Integer getPandaWholeQuoteRightId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("pandawhole_quote_right_id"));
	}
	
	/**
	 * 采管报价权限ID 
	 */
	public static Integer getPurchaseManageQuoteRightId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("purchase_manage_quote_right_id"));
	}
	
	/**
	 * 办事处权限
	 */
	public static Integer getDepartmentFiscalRightId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("DEPARTMENT_FISCAL_RIGHT"));
	}
	
	/**
	 * 总部财务权限
	 */
	public static Integer getHqFiscalRightId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("HQ_FISCAL_RIGHT"));
	}
	
	/**
	 * 一号仓库部门编号
	 */
	public static Integer getFirstStorageDepartmentRightId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("FIRST_STORAGE_DEPARTMENT"));
	}
	
	/**
	 * 二号仓库部门编号
	 */
	public static Integer getSecondStorageDepartmentId(){
		return 11;
	}
	

	/**
	 * 报废部门编号
	 */
	public static Integer getScrapDepartmentId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("SCRAP_DEPARTMENT"));
	}
	
	
	/**
	 * 成品部编号
	 */
	public static Integer getFinishedProductDepartment()
	{
		return Integer.parseInt(DeployProperties.getInstance().getProperty("FINISHED_PRODUCT_DEPARTMENT"));
	}
	
	/**
	 * 工厂部门
	 * @return
	 */
	public static Integer getFactoryDepartment(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("FACTORY_DEPARTMENT"));
	}
	
	/**
	 * 客服的权限
	 */
	public static Integer getCustomerServiceRightId(){
		try{
			return Integer.parseInt(DeployProperties.getInstance().getProperty("CUSTOMER_SERVICE_RIGHT"));
		}catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * 接收拆分订单邮件的权限
	 */
	public static Integer getReceiveSplitOrderEmailRightId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("receive_split_order_email_right_id"));
	}
	
	/**
	 * 取消加工订单项邮件的权限
	 */
	public static Integer getCancelProcessingOrderItemEmailRightId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("cancel_processing_order_item_email_right_id"));
	}
	
	/**
	 * 加工小组权限ID
	 * @return
	 * Integer
	 */
	public static Integer getProcessingRroupRightId()
	{
        return Integer.parseInt(DeployProperties.getInstance().getProperty("processing_group_right_id"));
	}
	
	/**
	 * 加工小组权限ID
	 * @return
	 * Integer
	 */
	public static Integer getFSProcessingDepartmentId()
	{
        return Integer.parseInt(DeployProperties.getInstance().getProperty("FS_PROCESSION_DEPARTMENT"));
	}
	/**
	 * 办事处经理角色ID
	 * @return
	 * Integer
	 */
	public static Integer getDepartmentManagerRightGroupId()
	{
	    return Integer.parseInt(DeployProperties.getInstance().getProperty("department_manager_right_group_id"));
	}
	
	public static Integer getLogisticsCancelOrderEmailRightId()
	{
	    return Integer.parseInt(DeployProperties.getInstance().getProperty("l_order_cancel_email"));
	}
	
	/**
	 * 订单请求校对邮件的权限
	 */
	public static Integer getRequestCollateProcessingOrderEmailRightId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("l_order_request_collate_email_right_id"));
	}
	

	/**
	 * 维护记录完成修改发邮件给仓库人员处理
	 */
	public static Integer getStorageDealUserRightId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("s_storage_deal_user_right_id"));
	}
	
	/**
	 * #维护记录完成修改发邮件给客服
	 * @return
	 */
	public static Integer getOrderCustemerServiceRightId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("l_order_customer_service_right_id"));
	}
	

	/**
	 * #维护记录完成修改发邮件给客服
	 * @return
	 */
	public static Integer getQCDealUserRightId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("qc_deal_user_right_id"));
	}
	
	
	/**
	 * 投诉跟进人的权限
	 */
	public static Integer getComplaintTrackerRightId(){
		try{
			return Integer.parseInt(DeployProperties.getInstance().getProperty("COMPLAINT_TRACKER_RIGHT"));
		}catch (Exception e) {
			return 0;
		}
	}
	
	public static String getDownURL(){
		return DeployProperties.getInstance().getProperty("picture_down_url");
	}
	
	/**
	 * 水印文字
	 * @return
	 */
	public static String getPictureMark(){
		return DeployProperties.getInstance().getProperty("picture_mark");
	}
	
	/**
	 * 系统错误邮件
	 * @return
	 */
	public static String getSystemErrorMail(){
		return DeployProperties.getInstance().getProperty("system.error.mail");
	}
	
	private static final String FMSPROVIDERID = "fms.providerId";
	
	public static int getFMSProviderId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty(FMSPROVIDERID));
	}
	
	/**
	 * 物流中心
	 * @return
	 */
	public static int getLogisticsDepartment1(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("LOGISTICS_DEPARTMENT_1"));
	}
	/**
	 * 行政中心
	 * @return
	 */
	public static int getAdministrativeDepartment(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("ADMINISTRATIVE_DEPARTMENT"));
	}
	
	/**
	 * 义务成品
	 * @return
	 */
	public static int getYWFinishedProductDepartment(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("YW_FINISHED_PRODUCT_DEPARTMENT"));
	}
	
	
	/**
	 * 物流中心2
	 * @return
	 */
	public static int getLogisticsDepartment2(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("LOGISTICS_DEPARTMENT_2"));
	}
	
	/**
	 * webServer 用户名
	 * @return
	 */
	public static String getWebServerUserName(){
		return DeployProperties.getInstance().getProperty("webserver.user");
	}
	
	/**
	 * 获取当前版本号
	 * @return
	 */
	public static String getWebServerVersion(){
		return DeployProperties.getInstance().getProperty("webserver.version");
	}
	
	
	/**
	 * webServer 密码
	 * @return
	 */
	public static String getWebServerPassWord(){
		return DeployProperties.getInstance().getProperty("webserver.password");
	}
	
	/**
	 * 获取重量系数
	 * @return
	 */
	public static String getWeightRate(){
		return DeployProperties.getInstance().getProperty("weight.rate");
	}
	
	/**
	 * 工厂采购人
	 * 
	 * @return
	 */
	public static Integer getFactoryPurchaseUserId(){
		return Integer.parseInt(DeployProperties.getInstance().getProperty("factory.purchase.userid")); 
	}
	
	public static String getOrderDeliveryId(){
		return (DeployProperties.getInstance().getProperty("order.delivery.id")); 
	}
	
	/**
	 * 差异单初审权限ID
	 * @return
	 * Integer
	 */
	public static Integer getInventoryDiffAuditId()
	{
	    return Integer.parseInt(DeployProperties.getInstance().getProperty("storage.inventory.differences.audit.id")); 
	}
    
	/**
     * 差异单终审权限ID
     * @return
     * Integer
     */
    public static Integer getInventoryDiffSecondAuditId()
    {
        return Integer.parseInt(DeployProperties.getInstance().getProperty("storage.inventory.differences.second.audit.id")); 
    }
    
    /**
     * 成品部门的采购任务无法处理是邮件通知权限
     * @return
     * Integer
     */
    public static Integer getFinishedProductPurchaseTaskUnprocessMailRight()
    {
        return Integer.parseInt(DeployProperties.getInstance().getProperty("purchase.task.unprocess.mail.finished.right.id"));
    }

    /**
     * 义乌成品部门的采购任务无法处理是邮件通知权限
     * @return
     * Integer
     */
    public static Integer getYMFinishedProductPurchaseTaskUnprocessMailRight()
    {
        return Integer.parseInt(DeployProperties.getInstance().getProperty("purchase.task.unprocess.mail.ym.finished.right.id"));
    }
    
    /**
     * 办事处财务
     * @return
     */
    public static int getFinancialSurplusUserId(){
    	 return Integer.parseInt(DeployProperties.getInstance().getProperty("financial.surplus.user.id"));
    }
    /**
     * 采购部
     * @return
     */
    public static int getPurchingDepartmentId(){
   	 return Integer.parseInt(DeployProperties.getInstance().getProperty("PURCHASING_DEPARTMENT"));
   }
    /**
     * 采管部
     * @return
     */
    public static int getPurchingManagementDepartmentId(){
   	 return Integer.parseInt(DeployProperties.getInstance().getProperty("PURCHASE_MANAGEMENT_DEPARTMENT"));
   }
    
}
