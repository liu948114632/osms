package com.itecheasy.printMethod;

import com.itecheasy.common.util.DeployProperties;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;

import java.lang.reflect.Type;


public class AccessPath implements MethodInterceptor{
//	Logger logger = Logger.getLogger("SYSTEM_METHOD_LOG");
	Logger logger = Logger.getLogger(AccessPath.class);

	AccessPath(){
		System.out.println("-------------------------");
	}


	 public static Boolean getSystemDebugSwitch(){
		 String  debug =  DeployProperties.getInstance().getProperty("DEBUG","0");

			if(debug.equals("1")){
				return true;
			}else{
				return false;
			}
	 }
	 
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
//		if(getSystemDebugSwitch()){
			  StopWatch clock = new StopWatch();  
		        clock.start(); //计时开始

		        Object result = invocation.proceed();  //被代理的方法

		        clock.stop();  //计时结束  
		        //方法参数类型，转换成简单类型  
		        Class[] params = invocation.getMethod().getParameterTypes();  
		        StringBuilder sb = new StringBuilder();
		        for (int i = 0; i < params.length; i++) {  
		        	sb.append(params[i].getSimpleName()).append(",");  
		        }

//				Type returnType = invocation.getMethod().getAnnotatedReturnType().getType();

		        logger.info("该方法执行耗费:" + clock.getTime() + " ms ["
		                + invocation.getThis().getClass().getName() + "."
		                + invocation.getMethod().getName() +  "("+sb.toString()+")] ");



		        return result;  
//		}else{
//			Object object =invocation.proceed();
//			return object;
//		}
		
	}

}
