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
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect//指定当前类为切面类
public class LogAspect {
    private static final Logger logger = LogManager.getLogger(LogAspect.class);
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Pointcut("execution(public * com.jnshu.crq.action.*.*(..))")
    public void pointCutBef(){};

    @Pointcut("execution(public * com.jnshu..crq.action.*.*(..))")
    public void pointCutAround(){};

//    @Before("pointCutBef()")
    public void printBefLog(JoinPoint joinPoint){


        String methodName = joinPoint.getTarget().getClass()+"."+joinPoint.getSignature().getName()+"(";

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();//函数签名

        String[] argNames =  methodSignature.getParameterNames();//参数名称

        StringBuffer sb = new StringBuffer();

        Object[] args = joinPoint.getArgs();//实际参数

        if(args.length>0){
            for(int i=0;i<args.length;i++){
                sb.append(argNames[i]+"="+args[i].toString());
                methodName+=argNames[i];
                if(i!=args.length-1){
                    sb.append(",");
                    methodName+=",";
                }
            }
            methodName+=")";
        }else{
            logger.info("此方法无参数");
        }

        logger.info("时间:{};执行方法:{};方法参数:{}",format.format(new Date()),methodName,sb.toString());
    }

    @Around("pointCutAround()")
    public Object printLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getTarget().getClass()+"."+joinPoint.getSignature().getName()+"(";

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        String[] argNames = methodSignature.getParameterNames();

        StringBuffer sb = new StringBuffer();

        Object[] args = joinPoint.getArgs();

        if(args.length>0){
            for(int i=0;i<args.length;i++) {
                sb.append(argNames[i]+"="+args[i]);
                methodName+=argNames[i];
                if(i!=args.length-1){
                    sb.append(",");
                    methodName+=",";
                }
            }
        }
        methodName+=")";
        logger.info("start:{};执行方法:{};方法参数:{}",format.format(new Date()),methodName,sb.toString());

        Object returnObject = (Object) joinPoint.proceed(args);

        logger.info("end:{};执行方法:{};方法返回值:{}",format.format(new Date()),methodName,returnObject.toString());
        return returnObject;
    }

}
