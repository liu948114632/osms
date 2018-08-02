package com.itecheasy.printMethod;

import com.itecheasy.printMethod.annotations.LoggerNameDescription;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Auther: liteng
 * @Date: 2018/7/26 11:37
 * @Description: aop中的常用方法   todo
 *
 */
public class AopUtils {

    /**
     * 获取方法名和参数
     * @author lyl
     * @param joinPoint
     * @return
     */
    private String getMethodNameAndArgs(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        StringBuffer sb = new StringBuffer("请求方法：");
        sb.append(joinPoint.getTarget().getClass().getName() + "."
                + joinPoint.getSignature().getName() + "(");
        for (int i = 0; i < args.length; i++) {
            sb.append("arg[" + i + "]: " + args[i] + ",");
        }
        if (args.length > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(")");
        return sb.toString();
    }

    // TODO: 2018/7/27 to do build
    /**
     * 获取注解中对方法的描述信息 用于service层注解
     * @author lyl
     * @param joinPoint
     * @param a 注解
     * @return 注解里面的描述
     * @throws ClassNotFoundException
     */
    public static <A extends Annotation> String  getServiceMthodDescription(JoinPoint joinPoint, Class<A> a) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName) && method.isAnnotationPresent(a)) {
                A annotation = method.getAnnotation(a);
//                A annotation1 = annotation.getClass().getAnnotation();
//                description = annotation1
                break;
            }
        }
        return description;
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * @author lyl
     * @param joinPoint
     * @return
     * @throws ClassNotFoundException
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName) && method.isAnnotationPresent(LoggerNameDescription.class)) {
                LoggerNameDescription controllerLog = method.getAnnotation(LoggerNameDescription.class);
                description =controllerLog.methodNameDescription();
                break;
            }
        }
        return description;
    }
    /**
     * 将异常信息输出到log文件
     * @param t
     * @return
     */
    public static String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }



}
