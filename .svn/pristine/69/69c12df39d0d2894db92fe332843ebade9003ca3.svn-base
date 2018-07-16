package com.itecheasy.communication.utils;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

import com.itecheasy.common.util.DeployProperties;

public class BBCAuthHandler implements CallbackHandler {
	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		if (!pc.getIdentifer().equals(DeployProperties.getInstance().getProperty("bbc.webservice.username"))) {
			throw new SecurityException("无效的服务用户名!");
		}
		if (!pc.getPassword().equals(DeployProperties.getInstance().getProperty("bbc.webservice.password"))) {
			throw new SecurityException("无效的服务密码!");
		}
	}

}
