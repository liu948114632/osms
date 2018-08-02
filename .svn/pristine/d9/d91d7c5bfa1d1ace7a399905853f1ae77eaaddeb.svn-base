package com.itecheasy.printMethod;

import com.itecheasy.core.BussinessException;
import com.itecheasy.printMethod.annotations.LoggerNameDescription;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.reflect.MethodSignature;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @Auther: liteng
 * @Date: 2018/7/26 09:24
 * @Description:
 */
public class ChinoException {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final ObjectMapper jsonMapper = new ObjectMapper();




    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) throws NoSuchMethodException, IOException {

        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Method realMethod = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(), method.getParameterTypes());

        // 获取目标类名
        String className = joinPoint.getTarget().getClass().getName();
        // 获取方法名
        String methodName = signature.getName();

        LoggerNameDescription loggerNameDescription = realMethod.getAnnotation(LoggerNameDescription.class);    //获取目标对象的注解
        String methodNameDescription = loggerNameDescription.methodNameDescription();

//        Object result = null;
        logger.info(methodNameDescription + "传来了: {}", jsonMapper.writeValueAsString(joinPoint.getArgs())); //这个异常怎么处理？
//        logger.info(methodNameDescription + "返回了: result: {}", jsonMapper.writeValueAsString(result));
    }

    //捕获所有的异常，但是并不是处理了他们
    public void afterThrowing3(JoinPoint joinPoint,Throwable e) {
        if (e instanceof CustomerException) {

            logger.error("通知中发现异常CustomerException", e);
        } else if (e instanceof BussinessException){
            ((BussinessException) e).getErrorCode();


        } else if (e instanceof RuntimeException) {
            logger.error("通知中发现运行未知异常", e);
        } else if(e instanceof Exception){
            logger.error("通知中发现其他飞运行异常，请检查您的hardware", e);
        }else{
            logger.error("通知中发现其他飞运行异常，请检查您的hardware", e);
        }

        System.out.println("异常通知");
        System.out.println("异常类："+e.getClass());
        System.out.println("异常信息："+e.getMessage());
    }



    //spring mvc 和spring boot可以自定义一个异常类来进行配置，所有controller的异常抛出去之后会被这个异常拦截器给拦截
    //这个异常拦截器里就是捕获不同的异常来进行对应的处理
}
