package com.jnshu.crq.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;

@Component
@Aspect //指定当前类为切面类
public class LogAspect {

    private static final Logger logger = LogManager.getLogger(LogAspect.class);

//    横切serviceImpl下的所搜 pbliuc方法
    @Pointcut("execution(public * com.jnshu.crq.serviceImpl.*.*(..))")
    public void pointCut_1(){}

    @Pointcut("execution(public * com.jnshu.crq.action.*.*(..))")
    public void actionPointCut(){}

//    @Around("actionPointCut()")
//    public Object aroundAction(ProceedingJoinPoint joinPoint) throws Throwable{
//        // proceedingJoinPoint封装了连接点的详细信息
//        // proceed，执行目标方法 method.invoke
//        System.out.println("====asdasd=======");
//        String uuid = UUID.randomUUID().toString().replace("-", "");
//
//        logger.info("uuid:"+uuid);
//        // 添加日志链
//        MDC.put("mdcId", uuid);
//        // 获取Controller入参
//        Object[] jsonParam = joinPoint.getArgs();
////        String request =
//        String methodName = joinPoint.getSignature().getName()+"(";
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();//获取目标方法参数名称
//        String[] paramNames = methodSignature.getParameterNames();
//        StringBuffer stringBuffer = new StringBuffer();
//        for(int i=0;i<jsonParam.length;i++){
//            stringBuffer.append(paramNames[i]+"="+jsonParam[i].toString());
//            methodName+=paramNames[i];
//            if(i!=jsonParam.length-1){
//                stringBuffer.append(",");
//                methodName+=",";
//            }
//        }
//        methodName+=")";
//        logger.info("请求开始: methodName = {};参数params: {}", methodName,stringBuffer);
//        long startTime = System.currentTimeMillis();
//
//        // 目标方法执行完成后会有返回值，这个返回值一定return出去
//        Object o = (Object) joinPoint.proceed(jsonParam);
//
//        HashMap<String,Object> reponse = new HashMap<>();
//        reponse.put("result",o);
//        long endTime = System.currentTimeMillis();
//        long executeTime = endTime - startTime;
//        logger.info("请求结束: methodName = {}, 执行时间: time = {}ms, result = {}", methodName,executeTime,reponse);
////        if (MDC.get("reqId") != null) {
////            // 请求结束后移除日志链
////            MDC.remove("reqId");
////        }
//        return o;
//    }

// 前置通知，在执行目标方法之前执行
    @Before("pointCut_1()")
    public void printLog(JoinPoint joinPoint){
        try {
            SimpleDateFormat start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String methodName = joinPoint.getTarget().getClass()+"."+joinPoint.getSignature().getName()+"(";
//            methodName方法名称
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();//获取目标方法参数名称

            String[] paramNames = methodSignature.getParameterNames();
            StringBuffer stringBuffer = new StringBuffer();
            Object[] jsonParam = joinPoint.getArgs();
            if(jsonParam.length>0){
                for (int i=0;i<jsonParam.length;i++){
                    stringBuffer.append(paramNames[i]+"="+jsonParam[i].toString());
                    methodName+=paramNames[i];
                    if(i!=jsonParam.length-1){
                        stringBuffer.append(",");
                        methodName+=",";
                    }
                }
            }else{
                stringBuffer.append("此方法无参数");
            }
            methodName+=")";
            logger.info("时间:{};执行方法:{};{}",start.format(new Date()),methodName,stringBuffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }
    }
}
