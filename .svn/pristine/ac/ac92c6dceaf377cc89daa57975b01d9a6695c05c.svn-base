package com.itecheasy.webservice.client;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.CompleteSaleCall;
import com.ebay.sdk.call.GetItemCall;
import com.ebay.sdk.call.GetOrdersCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.OrderIDArrayType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.ShipmentType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;



/** 
 * @author wanghw
 * @date 2016-8-19 
 * @description TODO
 * @version 1.2.0
 */
public class EbayClient {
	private static ApiContext apiContext =null;

	public static void init(EbayApiAccount account) {
//		System.out.println(System.getProperty("java.endorsed.dirs"));
		apiContext= new ApiContext();
		ApiCredential apiCred = new ApiCredential();
		ApiAccount ac = new ApiAccount();

		apiCred.setApiAccount(ac);
		apiCred.seteBayToken(account.getToken());
		apiContext.setApiCredential(apiCred);
		apiContext.setApiServerUrl(account.getServerUrl());
		apiContext.setSignInUrl(account.getSignInUrl());
		apiContext.setEpsServerUrl(account.getEpsServerUrl());
		apiContext.setErrorLanguage("zh_CN");
		apiContext.setSite(SiteCodeType.fromValue(account.getSite()));
	    ac.setDeveloper(account.getDeveloper());
	    ac.setApplication(account.getApplication());
	    ac.setCertificate(account.getCertificate());
	}
	
	public static OrderType[] getSimpleorder(EbayApiAccount account,String shopOrderId)throws Exception{
		init(new EbayApiAccount());
		DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL
				,
				DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES, DetailLevelCodeType.ITEM_RETURN_DESCRIPTION 
				};
		GetOrdersCall api = new GetOrdersCall(apiContext);
		api.setDetailLevel(detailLevels);
		OrderIDArrayType orderIDArray=new OrderIDArrayType();
		orderIDArray.setOrderID(new String[]{shopOrderId});
		api.setOrderIDArray(orderIDArray);
		api.setEnableCompression(false);
		OrderType[] orders=api.getOrders();
		return orders;
	} 
	
	public static OrderType[]  getOrder(EbayApiAccount account,Date from,Date to) throws Exception {
		init(account);
		DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL,
				DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES, DetailLevelCodeType.ITEM_RETURN_DESCRIPTION };

		
		GetOrdersCall api = new GetOrdersCall(apiContext);
		api.setDetailLevel(detailLevels);
		
		Calendar modTimeFrom=Calendar.getInstance();
		modTimeFrom.setTime(DateUtils.addMinutes(from, -2));//提前两分钟
		api.setModTimeFrom(modTimeFrom);
		
		Calendar modTimeTo=Calendar.getInstance();
		modTimeTo.setTime(to);
		api.setModTimeTo(modTimeTo);
		api.setEnableCompression(false);
		return api.getOrders();
	}
	
	public static void delivery(EbayApiAccount account,String shopOrderId,String shopOrderLineItemId,Date deliveryDate
			,String trackingNO,String CarrierCode) throws ApiException, SdkException, Exception{
		init(account);
		CompleteSaleCall call=new CompleteSaleCall(apiContext);
		call.setOrderID(shopOrderId);
		if(StringUtils.isEmpty(shopOrderId))
			call.setOrderLineItemID(shopOrderLineItemId);
		
		ShipmentType shipmentType=new ShipmentType();
		call.setShipment(shipmentType);
		
		Calendar dd=Calendar.getInstance();
		dd.setTime(deliveryDate);
		shipmentType.setDeliveryDate(dd);
		shipmentType.setShipmentTrackingNumber(trackingNO);
		shipmentType.setShippingCarrierUsed(CarrierCode);
		call.setEnableCompression(false);
		call.completeSale();
	}
	
	public static void main(String[] args) throws ApiException, SdkException, Exception {
		EbayApiAccount apiAccount=new EbayApiAccount();
		
		apiAccount.setToken("AgAAAA**AQAAAA**aAAAAA**HNu/Vw**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wFk4GjDJCHow6dj6x9nY+seQ**4usDAA**AAMAAA**k8AULboi8jYDeh1JzmW4U2LRXi9+y3EraUKEPP9K5tlck1IIeDjCSrazW293gkI7nl7ATcyi9U/hiy6glqlCnlYOtlf0b/TuCSrctMpFVEstyRfERJhpNotr6BuH9T+ut+KsLFKF53LtgGvjJDvkw6w9zQYmTKoEzK8TNTQuWEle6KUjBpmwjpbpOeshNRi6ej3rKCe8ODKRD//PQmptXg8qUhkpMAsr0w+KJSrfFG7AIWLXdKBqscl0tE/0+aouysvWTK2oW1aFB8bCvTowOgjDaBX0/4HK4R50JF+GzQSa2dWPimVt7pzfrAusDzwvrcvD2OqfizOzbBLoe5CbKndStFRJovwGM+M66pGnAVhSHyu1nbfhxugoWVarNkZwMzmi8EjLLb4VCEcE812yMXR1YvxSgsGkTzKDetu3Jmp52FFb5uvXBQjDJc8efDXmcjSOufZdDAI8hzLSroN8Ep4kYoYSpCyL0/K5+KU1VD1rEZqLXDMCHzmfPABMoYNWi7bMSvHm2faq0+CwUyatsEr8tODoGD7B/bPUNHxLzI0Ba2I9UouiS92c/ALSCrdXEW5oxr4YCoyiUlytv6NZLmVASO2Cje8HpdmsoOle8jLCjHO6R//ri2btTex1Aw8YIk729lACoDidlMKitcMMfFfkFydOiUP3e6NugRfwc3MBpNzU5otjYCW3VERH7rKgfTkIV0Hu6PK9skJ4UCC/hyRZE6oxExzqs/EI/GhD3vBfzHdUDJ3wXVjNgdpQT+Hz");
		apiAccount.setServerUrl("https://api.sandbox.ebay.com/wsapi");
		apiAccount.setEpsServerUrl("https://api.sandbox.ebay.com/ws/api.dll");
		apiAccount.setSignInUrl("https://signin.sandbox.ebay.com/ws/eBayISAPI.dll?SignIn");
		apiAccount.setDeveloper("f9277d77-3b3e-400d-b559-84bf1650f074");
		apiAccount.setCertificate("SBX-9a67cc3534b3-085e-43d8-beaa-7b9d");
		apiAccount.setApplication("yxf-yxfebayt-SBX-09a67cc35-e08e96ae");
		apiAccount.setSite("US");
		
		init(apiAccount);
		DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL
				,
				DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES, DetailLevelCodeType.ITEM_RETURN_DESCRIPTION 
				};

//		GetItemTransactionsCall cal=new GetItemTransactionsCall(apiContext);
//		cal.setOrderLineItemID("272281004581-1687853442017");
//		cal.setItemID("272281004581");
//		cal.setEnableCompression(false);
//		TransactionType[] orders= cal.getItemTransactions();
		
//		GetItemShippingCall api=new GetItemShippingCall(apiContext);
		
		GetItemCall api=new GetItemCall(apiContext);
		
		
//		GetOrdersCall api = new GetOrdersCall(apiContext);
////		
//		Calendar modTimeFrom=Calendar.getInstance();
//		modTimeFrom.setTime(new Date());
//		modTimeFrom.add(Calendar.DAY_OF_MONTH, -2);
//		api.setModTimeFrom(modTimeFrom);
//		
//		Calendar modTimeTo=Calendar.getInstance();
//		modTimeTo.setTime(new Date());
//		api.setModTimeTo(modTimeTo);
		api.setDetailLevel(detailLevels);
		//110199027070
//		OrderIDArrayType orderIDArray=new OrderIDArrayType();
//		orderIDArray.setOrderID(new String[]{"272407699670-1787682722017"});
//		api.setOrderIDArray(orderIDArray);
		api.setEnableCompression(false);
//		OrderType[] orders=api.getOrders();
//		System.out.println(orders);
		
		api.setItemID("110199027070");
		ItemType type=api.getItem();
		System.out.println();
//		
//		
//		GetItemCall call=new GetItemCall(apiContext);
//		call.addDetailLevel(DetailLevelCodeType.RETURN_ALL);
//		call.setEnableCompression(false);
//		//272273661889  location:272362771790
//		call.setItemID("272362771790");
//		ItemType itemType= call.getItem();
//		System.out.println(itemType);
		
//		CompleteSaleCall call=new CompleteSaleCall(apiContext);
//		call.setOrderID("272345183052-1703102369017");
//		call.setOrderLineItemID(shopOrderLineItemId);
//		ShipmentType shipmentType=new ShipmentType();
//		call.setShipment(shipmentType);
//		
//		Calendar dd=Calendar.getInstance();
//		dd.setTime(com.itecheasy.common.util.DateUtils.convertDate("2016-09-17", "yyyy-MM-dd"));
//		shipmentType.setDeliveryDate(dd);
//		shipmentType.setShipmentTrackingNumber("RS230764444CN");
//		shipmentType.setShippingCarrierUsed("Mail Post");
//		call.setEnableCompression(false);
//		call.completeSale();
//		System.out.println("done");
	}
}
