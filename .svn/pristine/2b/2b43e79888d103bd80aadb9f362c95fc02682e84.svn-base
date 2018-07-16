package com.itecheasy.webservice.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.itecheasy.common.util.MD5;
import com.itecheasy.webservice.aliexpress.CommonUtil;

/** 
 * @author whw
 * @date 2017-7-19 
 * @description TODO
 * @version 3.9.42
 */
public class WDTClient {
	private static JSONObject postJson(){
		String method="QueryStorage";
		String InterfaceID="zhulangtest";
		String SellerID="dev5";
		String key="12345";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("WarehouseNO", "nltest");

		String Content=JSONObject.fromObject(params).toString();
		
		String result;
		
		String Sign=Base64.encodeBase64String(MD5.byte2Hex32LowerCase(Content+key).getBytes());
		
		String url = "http://121.199.38.85/openapi/interface.php?";
		
		org.apache.http.client.HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvp = new ArrayList<NameValuePair>();
		nvp.add(new BasicNameValuePair("Method", method));
		nvp.add(new BasicNameValuePair("SellerID", SellerID));
		nvp.add(new BasicNameValuePair("InterfaceID", InterfaceID));
		nvp.add(new BasicNameValuePair("Sign", Sign));
		nvp.add(new BasicNameValuePair("Content", Content));
		try {
			httpPost.setHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
			httpPost.setEntity(new UrlEncodedFormEntity(nvp, "UTF-8"));
			HttpResponse response = client.execute(httpPost);
			result = EntityUtils.toString(response.getEntity());
			System.out.println(result);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (null != client) {
				client.getConnectionManager().shutdown();
			}
		}
		return null;
	}
	
	
	private static JSONObject postJsonFromApacheHttp(){
		String methodApi="QueryStorage";
		String InterfaceID="zhulangtest";
		String SellerID="dev5";
		String key="12345";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("WarehouseNO", "nltest");
		String Content=JSONObject.fromObject(params).toString();
		String Sign=Base64.encodeBase64String((MD5.byte2Hex32LowerCase(Content+key).getBytes()));
		
		String url = "http://121.199.38.85/openapi/interface.php";
		
		 final HttpClient httpClient = new HttpClient();
	        final PostMethod method = new PostMethod(url);
	        method.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
	        
			method.setParameter("Method", methodApi);
			method.setParameter("SellerID", SellerID);
			method.setParameter("InterfaceID", InterfaceID);
			method.setParameter("Sign", Sign);
			method.setParameter("Content", Content);
			String response = "";
	        try{
	            int status = httpClient.executeMethod(method);
	            if(status >= 300 || status < 200){
	                throw new RuntimeException("invoke api failed,"  
	                        + " status:" + status + " response:" + method.getResponseBodyAsString());
	            }
	            response = CommonUtil.parserResponse(method);
	            JSONObject re=JSONObject.fromObject(response);
	            System.out.println(re);
	        } catch (HttpException e) {
	        } catch (IOException e) {
	        }finally{
	            method.releaseConnection();
	        }
	        return null;
	}
	
	public static void main(String[] args) {
		postJsonFromApacheHttp();
//		System.out.println(getURLEncoderString("测试店铺"));
	}
	
	
}
