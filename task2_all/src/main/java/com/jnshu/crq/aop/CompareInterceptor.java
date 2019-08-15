package com.jnshu.crq.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Title 换绕通知
 * @author crq131290
 * @Description TODO
 * @Date 2019/08/12
 * */
public class CompareInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object result = null;
        String name = methodInvocation.getArguments()[0].toString();
        if(name.equals("王花花")){
            result = methodInvocation.proceed();
            System.out.println(result);
        }else{
            System.out.println("此学生是"+name+"而不是王花花");
        }
        return result;
    }
}
