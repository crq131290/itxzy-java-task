package com.jnshu.crq.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Title 前置通知
 * @author crq131290
 * @Date 2019/08/12
 * @Description TODO
 * */
public class BeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println( " 这是BeforeAdvice类的before方法. " );
    }
}
