package com.jnshu.crq.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @Title 后置通知
 * @author crq131290
 * @Description TODO
 * @Date 2019/08/12
 * */

public class AfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println( " 这是AfterAdvice类的after方法. " );
    }
}
