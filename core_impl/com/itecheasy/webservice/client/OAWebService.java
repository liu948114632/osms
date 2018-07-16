package com.itecheasy.webservice.client;

import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.webservice.oa.ObjectFactory;
import com.itecheasy.webservice.oa.ProfileService;
import com.itecheasy.webservice.oa.ProfileServiceSoap;
import com.itecheasy.webservice.oa.UserModel;
import com.itecheasy.webservice.oa.WebServiceSetting;


public class OAWebService {

	private static ProfileServiceSoap portType;
	private static WebServiceSetting webServiceSetting;
	
	private static void init() {
		ProfileService service = new ProfileService();
		portType = service.getProfileServiceSoap();
		ObjectFactory objectFactory = new ObjectFactory();
		webServiceSetting = objectFactory.createWebServiceSetting();
		webServiceSetting.setPinCode(DeployProperties.getInstance().getOAPinCode());
	}

	public static int authorizationLogin(String workNumber, String password) {
		if( portType ==null)
		{
			init();
		}
		return portType.authorizationLogin(workNumber, password,
				webServiceSetting);

	}

	public static UserModel getUserModel(String workNumber) {		
		if( portType ==null)
		{
			init();
		}
		return portType.getUserModel(workNumber, webServiceSetting);
	}
	
	public static void main(String[] args) {
		UserModel u=OAWebService.getUserModel("ite02385");
		System.out.println(u.getEmail());
	}
}
