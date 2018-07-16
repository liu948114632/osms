package com.itecheasy.webservice.aliexpress;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.itecheasy.common.util.DateUtils;
import com.itecheasy.common.util.DeployProperties;


/**
 * 授权服务类，主要提供了所有授权服务都会用到的获取授权令牌的功能
 */
public class AuthService {
	private static final Logger logger = Logger.getLogger(AuthService.class);

    /**
     * 通过临时令牌换取授权令牌
     * @param host 请求的主机名，包括域名和端口
     * @param params 请求参数，必填client_id、client_secret、redirect_uri和code，scope和view可选
     * @param needRefreshToken 是否需要返回refreshToken
     * @return getToken请求的json串
     */
    public static String getToken(String host, Map<String, String> params, boolean needRefreshToken){
        String urlHead = "https://" + host + "/openapi/";
        String namespace = "system.oauth2";
        String name = "getToken";
        int version = 1;
        String protocol = "http";
        if(params != null){
            if(params.get("client_id") == null || params.get("client_secret") == null
                    || params.get("redirect_uri") == null || params.get("code") == null){
            	logger.error("params is invalid, lack neccessary key!");
                return null;
            }
            params.put("grant_type", "authorization_code");
            params.put("need_refresh_token", Boolean.toString(needRefreshToken));
            String appKey = params.get("client_id");
            String urlPath = CommonUtil.buildInvokeUrlPath(namespace, name, version, protocol, appKey);
            String result = ApiCallService.callApiTest(urlHead, urlPath, null, params);
            return result;
        }
        return null;
    }
    
    
    
    
    /**
     * 通过长时令牌换取授权令牌
     * @param host 请求的主机名，包括域名和端口
     * @param params 请求参数，必填client_id、client_secret、redirect_uri和refresh_token，scope和view可选
     * @return
     */
    public static String refreshToken(String host, Map<String, String> params){
        String urlHead = "https://" + host + "/openapi/";
        String namespace = "system.oauth2";
        String name = "getToken";
        int version = 1;
        String protocol = "param2";
        if(params != null){
            if(params.get("client_id") == null || params.get("client_secret") == null
                    || params.get("redirect_uri") == null || params.get("refresh_token") == null){
            	logger.error("params is invalid, lack neccessary key!");
                return null;
            }
            params.put("grant_type", "refresh_token");
            String appKey = params.get("client_id");
            String urlPath = CommonUtil.buildInvokeUrlPath(namespace, name, version, protocol, appKey);
            String result = ApiCallService.callApiTest(urlHead, urlPath, null, params);
            return result;
        }
        return null;
    }
    
    /**
     * 如果当前时间离refreshToken过期时间在30天以内，那么可以调用postponeToken接口换取新的refreshToken；否则会报错。
     * @param host
     * @param params
     * @return
     */
    public static String postponeToken(String host, Map<String, String> params){
        String urlHead = "https://" + host + "/openapi/";
        String namespace = "system.oauth2";
        String name = "postponeToken";
        int version = 1;
        String protocol = "param2";
        if(params != null){
            if(params.get("client_id") == null || params.get("client_secret") == null
                     || params.get("refresh_token") == null){
            	logger.error("params is invalid, lack neccessary key!");
                return null;
            }
            params.put("grant_type", "refresh_token");
            String appKey = params.get("client_id");
            String urlPath = CommonUtil.buildInvokeUrlPath(namespace, name, version, protocol, appKey);
            String result = ApiCallService.callApiTest(urlHead, urlPath, null, params);
            
            return result;
        }
        return null;
    }
    
    public static void main(String[] args){
        String host = "gw.open.1688.com";//国际交易请用"gw.api.alibaba.com" gw.open.1688.com
        String client_id = "46200918";
        String appSecret = "LKk1Ap07KRv";
        String redirect_uri = "http://localhost:17080";
        /*
        //Test getting token from code
        String code = "yourCode";
        Map<String, String> params1 = new HashMap<String, String>();
        params1.put("client_id", client_id);
        params1.put("redirect_uri", redirect_uri);
        params1.put("client_secret", appSecret);
        params1.put("code", code);
        String getTokenResult = getToken(host, params1, true);
        System.out.println("用临时令牌换取授权令牌的返回结果：" + getTokenResult);
        JSONObject jsonObject = JSONObject.fromObject(getTokenResult);
        System.out.println("refreshToken:" + jsonObject.get("refresh_token"));
        System.out.println("accessToken:" + jsonObject.get("access_token"));
        */
        //Test getting token from refreshToken
        String refreshToken = "6b185312-ae5e-4527-8473-696f1033c9c1";
        Map<String, String> params = new HashMap<String, String>();
        params.put("client_id", client_id);
        params.put("redirect_uri", redirect_uri);
        params.put("client_secret", appSecret);
        params.put("refresh_token", refreshToken);
        String refreshTokenResult = refreshToken(host, params);
        System.out.println("用长时令牌换取授权令牌的返回结果：" + refreshTokenResult);
        JSONObject jsonObject1 = JSONObject.fromObject(refreshTokenResult);
        System.out.println("accessToken:" + jsonObject1.getString("access_token"));// accessToken
        //test call api
        String urlPath = "param2/1/system/currentTime/" + client_id;	//"param2/1/system/currentTime/1000000"
        String urlHead = "http://" + host + "/openapi/";
        Map<String, String> param = new HashMap<String, String>();
        param.put("access_token",  jsonObject1.getString("access_token"));
        String result = ApiCallService.callApiTest(urlHead, urlPath, appSecret, param);
        System.out.println(result);
    }
    
   
    
}