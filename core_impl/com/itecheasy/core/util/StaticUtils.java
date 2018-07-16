package com.itecheasy.core.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.core.email.EmailService;
import com.itecheasy.core.system.AmazonShippingMethod;
import com.itecheasy.core.system.ShippingMethod;
import com.itecheasy.core.system.Shop;
import com.itecheasy.core.system.ShopDevInfo;
import com.itecheasy.core.system.ShopInfo;
import com.itecheasy.core.system.ShopService;
import com.itecheasy.core.system.SpecialPhonetic;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.user.Department;
import com.itecheasy.core.user.ProfileService;
import com.itecheasy.webservice.aliexpress.AliexpressConfigInfo;
import com.itecheasy.webservice.client.EbayApiAccount;

/**
 * @author wanghw
 * @date 2014-9-16 下午4:14:15
 * @description 工具类
 */

public class StaticUtils {
	private static final String SANDBOX = "sandbox";
	private final static Logger LOGGER =Logger.getLogger(StaticUtils.class);
	private EmailService emailService;
	private ProfileService profileService;
	private SystemService systemService;
	private ShopService shopService;
	
	private static int currentDevIdIndex=0;
	
	/**
	 * <pre>
	 * 缓存中取开发者账号，用于下载订单,
	 * 账号轮番下载订单，防止请求频率过高被amazon拒绝
	 * 加快自动任务频率，有效加快下载订单速度。
	 * 问题：其他账号无订单是，会延迟有单账号的速度，如何解决？
	 * </pre>
	 * 2016年6月23日09:45:48
	 * @return 开发者账号id
	 */
	public synchronized static int getCurrentDevId() {
		List<ShopDevInfo> info=ul.systemService.getCacheShopDevInfos();
		if(CollectionUtils.isNotEmpty(info)){
			if(currentDevIdIndex>=info.size()-1){
				currentDevIdIndex=0;
			}else{
				currentDevIdIndex++;
			}
			return info.get(currentDevIdIndex).getId();
		}
		return currentDevIdIndex;
	}
	
	

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	

	private static StaticUtils ul;
	
	private static Map<String, String> SpecialPhoneticMap = null;

	public static Map<String, String> getSpecialPhoneticMap() {
		if (SpecialPhoneticMap == null) {
			SpecialPhoneticMap = new HashMap<String, String>();
			List<SpecialPhonetic> pp=ul.systemService.getSpecialPhonetics();
			if(CollectionUtils.isNotEmpty(pp)){
				for (SpecialPhonetic specialPhonetic : pp) {
					SpecialPhoneticMap.put(specialPhonetic.getKey(), specialPhonetic.getValue());
				}
			}
		}
		return SpecialPhoneticMap;
	}

	public void init() {
		ul = this;
		ul.emailService = this.emailService;
		ul.profileService = this.profileService;
		ul.systemService=this.systemService;
		ul.shopService=this.shopService;
	}
	
	public static AmazonInfo getAmazonInfo(int shopId){
		try {
			ShopDevInfo info=ul.systemService.getCacheAccount(shopId);
			if (info!=null) {
				AmazonInfo am=new AmazonInfo();
				am.setAccessKeyId(info.getAccessKey());
				am.setAPISellerUserToken(info.getToken());
				am.setMarketplaceID(info.getMarketplaceID());
				am.setSecretAccessKey(info.getAccessSecretKey());
				am.setSellerID(info.getSellerID());
				am.setServiceURL(info.getServiceURL());
				am.setTag(shopId);
				return am;
			}else{
				addEmail("店铺没有配置amazon账号信息", "店铺"+shopId+"没有配置amazon账号信息,无法请求接口!");
			}
		} catch (Exception e) {
			addEmail("店铺没有配置amazon账号信息", "店铺"+shopId+"没有配置amazon账号信息,无法请求接口!");
		}
		return null;
	}
	
	public static AmazonInfo getAmazonInfoByShop(int shopId){
		try {
			ShopDevInfo info=ul.systemService.getCacheAccount(shopId);
			Shop s= ul.systemService.getShop(shopId);
			if (info!=null) {
				AmazonInfo am=new AmazonInfo();
				am.setAccessKeyId(info.getAccessKey());
				am.setAPISellerUserToken(info.getToken());
				am.setMarketplaceID(s.getMarketplaceID());
				am.setSecretAccessKey(info.getAccessSecretKey());
				am.setSellerID(info.getSellerID());
				am.setServiceURL(info.getServiceURL());
				am.setTag(shopId);
				return am;
			}else{
				addEmail("店铺没有配置amazon账号信息", "店铺"+shopId+"没有配置amazon账号信息,无法请求接口!");
			}
		} catch (Exception e) {
			addEmail("店铺没有配置amazon账号信息", "店铺"+shopId+"没有配置amazon账号信息,无法请求接口!");
		}
		return null;
	}
	
	public static String getWebServiceURL(int shopId){
		ShopInfo info =ul.systemService.getCacheShopInfo(shopId);
		if (info!=null) {
			LOGGER.info("获取店铺的配置信息:"+shopId);
			return info.getWebserviceUrl();
		}else{
			addEmail("店铺没有配置amazon账号信息", "店铺"+shopId+"没有配置amazon账号信息,无法请求接口!");
			return null;
		}
	}
	
	public static AmazonShippingMethod convert2AmazonShipping(int shippingMethod){
		return ul.systemService.getAmazonShippingMethod(shippingMethod);
	}
	
	public static void addEmail(String subject, String content) {
		try {
			ul.emailService.addEmail(DeployProperties.getInstance().getProperty("system.email"), subject, content);
		} catch (Exception e) {
			LOGGER.error("邮件生成失败:"+e.getMessage());
		}
	}
	
	public static ShippingMethod getShippingMethod(int id){
		return ul.systemService.getShippingMethod(id);
	}

	public static String getDepartmentName(int id) {
		Department department = ul.profileService.getDepartmentByID(id);
		if (department != null) {
			return department.getName();
		}
		return null;
	}
	
	public static EbayApiAccount getEbayApiAccount(int shopId){
		return ul.systemService.getEbayApiAccount(shopId);
	}
	
	public static EbayApiAccount convertEbayApiAccount(ShopDevInfo info){
		EbayApiAccount eAccount=new EbayApiAccount();
		eAccount.setDeveloper(info.getDeveloperID());
		eAccount.setCertificate(info.getCertificateID());
		eAccount.setSite(info.getMarketplaceID());
		eAccount.setToken(info.getToken());
		eAccount.setApplication(info.getApplicationID());
		if(SANDBOX.equals(info.getServiceURL())){
			eAccount.setEpsServerUrl(DeployProperties.getInstance().getProperty("sandbox.ebay.EpsServerUrl"));
			eAccount.setServerUrl(DeployProperties.getInstance().getProperty("sandbox.ebay.ServerUrl"));
			eAccount.setSignInUrl(DeployProperties.getInstance().getProperty("sandbox.ebay.SignInUrl"));
		}else{
			eAccount.setEpsServerUrl(DeployProperties.getInstance().getProperty("produce.ebay.EpsServerUrl"));
			eAccount.setServerUrl(DeployProperties.getInstance().getProperty("produce.ebay.ServerUrl"));
			eAccount.setSignInUrl(DeployProperties.getInstance().getProperty("produce.ebay.SignInUrl"));
		}
		return eAccount;
	}
	
	public static AliexpressConfigInfo convertAliexpressConfigInfo(ShopDevInfo info){
		AliexpressConfigInfo api=new AliexpressConfigInfo();
		api.setAppKey(info.getAccessKey());
		api.setAppSecret(info.getAccessSecretKey());
		api.setRefreshToken(info.getToken());
		api.setRefreshTokenTimeOut(info.getTokenTimeOut());
		api.setDevId(info.getId());
		return api;
	}
}
