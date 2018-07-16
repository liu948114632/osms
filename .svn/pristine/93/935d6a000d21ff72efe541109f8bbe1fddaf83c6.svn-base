package com.itecheasy.webservice.client;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

import com.itecheasy.common.util.DeployProperties;

public class WsClinetAuthHandler implements CallbackHandler {
	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
			  for (int i = 0; i < callbacks.length; i++) { 
		            WSPasswordCallback pc = (WSPasswordCallback) callbacks[i]; 
		            pc.setPassword(DeployProperties.getInstance().getProperty("cms.webservice.password"));//密码
		           // pc.setIdentifier("testPassword");
		            
			  }
	        }
	}
