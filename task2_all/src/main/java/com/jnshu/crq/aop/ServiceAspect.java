package com.jnshu.crq.aop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ServiceAspect {

    //匹配所有ServiceImpl包下面的所有类的所有方法
    /*
    * Pointcut 的作用就是提供一组规则来匹配joinpoint, 给满足规则的 joinpoint 添加 Advice
    * */

    @Pointcut("execution(* com.jnshu.crq.serviceImpl.*.*(..))")//两点代表有参数
    public void addLog(){}
}
