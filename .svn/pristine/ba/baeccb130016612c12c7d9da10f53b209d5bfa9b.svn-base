package com.itecheasy.common;


import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class WsAuthHandler implements CallbackHandler {
	
	private final String ERROR_CLIENT_VERSION = "ERROR_CLIENT_VERSION";
	
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		if (!pc.getIdentifer().equals(SystemConfig.getWebServerVersion())) {
			throw new SecurityException(ERROR_CLIENT_VERSION);
		}		
		if (!pc.getPassword().equals(SystemConfig.getWebServerPassWord())) {
			throw new SecurityException("无效的服务密码!");
		}
	}

}
