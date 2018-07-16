package com.itecheasy.common.util;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer    {
	private static  String [] encryptKey = new String[]{"jdbc.url","jdbc.username","jdbc.password"};


	@Override
	protected void convertProperties(Properties property) {
		Set<Entry<Object, Object>> entry = property.entrySet();
		for (Entry<Object, Object> entry2 : entry) {
			if(ArrayUtils.contains(encryptKey,  entry2.getKey().toString()) ){
				try {
					entry2.setValue(decode(entry2.getValue().toString()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(entry2.getValue());
			}
			
		}
		super.convertProperties(property);
	}
	
	
	@Override
	protected String convertPropertyValue(String originalValue) {
		// TODO Auto-generated method stub
		return super.convertPropertyValue(originalValue);
	}
	


	private String decode(String value) throws IOException, Exception{
		return DESEncrypt.decrypt(RSAEncrypt.decrypt(value)) ;
	}
}

