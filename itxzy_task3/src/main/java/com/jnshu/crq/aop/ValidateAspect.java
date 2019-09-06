package com.jnshu.crq.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

@Component
@Aspect //声明切面类
public class ValidateAspect {//切面参数校验
    private static final Logger logger = LogManager.getLogger(ValidateAspect.class);

    @Pointcut("execution(public * com.jnshu.crq.action.*.*(..))")
    public void validate(){}

    @Around("validate()")
    public Object validateAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getTarget().getClass()+"."+joinPoint.getSignature().getName();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Parameter[] parameters = methodSignature.getMethod().getParameters();//主要用于获取参数信息，java8
        String[] argNames = methodSignature.getParameterNames();

        Object[] args = joinPoint.getArgs();
        logger.info("参数校验开始");

        for (Object o:args){
            if(o instanceof BindingResult){
                BindingResult bindingResult = (BindingResult) o;
                if(bindingResult.hasErrors()){
                    String msg = bindingResult.getFieldErrors().get(0).getDefaultMessage();
                    logger.error(msg);
                    return msg;
                }
            }

        }
        Object o = joinPoint.proceed();
        logger.info("参数校验完成,均无非法参数");
        return o;
//   单个参数进行校验
//        Parameter[] parameters = signature.getMethod().getParameters();
//        List<Integer> checkResult = new ArrayList<Integer>();
//        for (int i = 0; i < args.length; i++) {
//            Parameter parameter = parameters[i];
//            if (parameter.isAnnotationPresent(NotNull.class)) {
//                System.out.println(args[i]);
//                if (args[i] == null) {
//                    checkResult.add(i);
//                }
//                System.out.println("=====+++++-----");
//            }
//        }
//
//        if (!checkResult.isEmpty()) {
//            String result = checkResult.toString();
//
//            logger.error("第{}个参数被注解NotNull.class修饰,不能为Null",result);
////            throw new IllegalArgumentException("第" + result + "个参数被注解NotNull.class修饰，,不能为Null");
//        }
    }

}
