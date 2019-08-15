package com.jnshu.crq.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Component
@Aspect
public class ValidatedAspect {
    private static final Logger logger = LogManager.getLogger(ValidatedAspect.class);

    @Pointcut("execution(public * com.jnshu.crq.action.*.*(..))")
    public void valide(){}


    @Around("valide()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("异常处理校验");

        String uuid = UUID.randomUUID().toString().replace("-", "");
        MDC.put("uuid",uuid);
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        Parameter[] parameters = signature.getMethod().getParameters();
        List<Integer> checkResult = new ArrayList<Integer>();
        for (int i = 0; i < args.length; i++) {
            Parameter parameter = parameters[i];
            if (parameter.isAnnotationPresent(NotNull.class)) {
                System.out.println(args[i]);
                if (args[i] == null) {
                    checkResult.add(i);
                }
                System.out.println("=====+++++-----");
            }
        }

        if (!checkResult.isEmpty()) {
            String result = checkResult.toString();

            logger.error("第{}个参数被注解NotNull.class修饰,不能为Null",result);
//            throw new IllegalArgumentException("第" + result + "个参数被注解NotNull.class修饰，,不能为Null");
        }

        for(Object o : args){
            if(o instanceof BindingResult){
                BindingResult bindingResult = (BindingResult) o;
                if(bindingResult.hasErrors()){
                    String msg = bindingResult.getFieldErrors().get(0).getDefaultMessage();
                    logger.error("存在不合法参数,非法参数信息:{}",msg);
                    return msg;
                }
            }
        }
        Object o = joinPoint.proceed();
//      程序执行完毕后需要调用MDC.clear()把报错到当前线程的MDC数据清空。
        MDC.clear();
        return o;
    }
}
