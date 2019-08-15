package com.jnshu.crq.aop;

import com.jnshu.crq.pojo.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
//@Aspect
@Component
public class LogAdvice {
    /*
    * Advice ： Advice 是一个动作, 即一段 Java 代码, 这段 Java 代码是作用于 point cut 所限定的那些 Joint point 上的.
    * */
//   所有的通知都可以使用这种方式，直接把Pointcut跟Advice连接起来，但是为了更好的理解前文的概念以及图片,这边分开定义。
//    @Before("execution(* com.jnshu.crq.ServiceImpl.*.*(..))")
    @Before("com.jnshu.crq.aop.ServiceAspect.addLog()")
    public void before(){
        System.out.println("LogAdvice before advice ");
    }

    @AfterReturning("com.jnshu.crq.aop.ServiceAspect.addLog()")
    public void AfterReturning(){
        System.out.println("LogAdvice after returning advice ");
    }

    @AfterThrowing("com.jnshu.crq.aop.ServiceAspect.addLog()")
    public void AfterThrowing(){
        System.out.println("LogAdvice after throwing advice ");
    }

    @After("com.jnshu.crq.aop.ServiceAspect.addLog()")
    public void after(){
        System.out.println("LogAdvice after advice");
    }

    //除了可以通过名字来指向对应的切入点表达式,还可以可以使用'&&', '||' 和 '!'来合并。
    //切入点表达式的 args(user,..) 表示某个与切入表达式匹配的连接点它把Student对象作为第一个参数,通过这个语法我们可以在通知中访问到这个Student对象。
    @Around("com.jnshu.crq.aop.ServiceAspect.addLog() &&" +"args(student,..)")
    public void around(ProceedingJoinPoint joinPoint, Student student) throws Throwable{
        System.out.println("log begin!");
        System.out.println(student);
        Object result = null;
        result = joinPoint.proceed();//目标方法返回结果
        System.out.println(joinPoint.getSignature());//目标方法
        System.out.println(joinPoint.getSignature().getName());//方法名
        System.out.println(joinPoint.getArgs());//方法参数
        System.out.println(joinPoint.getThis());//代理对象
        System.out.println(joinPoint.getTarget());//目标对象
        System.out.println(result.toString());//目标方法返回结果
        System.out.println("log end");

//        需要在spring配置文件中<aop:aspectj-autoproxy proxy-target-class="true"/>在项目中强制使用cglib就行
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();//获取目标方法参数名称
        String[] names = methodSignature.getParameterNames();

        for (int i=0;i<names.length;i++){
            System.out.println(names[i]);
        }

    }



}
