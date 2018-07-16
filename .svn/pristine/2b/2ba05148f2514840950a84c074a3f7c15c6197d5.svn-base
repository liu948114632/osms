package com.itecheasy.common;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class CmsAuthHandler implements CallbackHandler {

	public void handle(Callback[] callbacks) throws IOException,UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		if (!pc.getIdentifer().equals(SystemConfig.getWebServerUserName())) {
			throw new SecurityException("无效的服务用户名!");
		}
		if (!pc.getPassword().equals(SystemConfig.getWebServerPassWord())) {
			throw new SecurityException("无效的服务密码!");
		}
	}
}
