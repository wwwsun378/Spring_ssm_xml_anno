package com.yg.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/7 19:06
 */
public class MyAspect {

    public void before() {
        System.out.println("前置增强..........");
    }

    public void afterReturning() {
        System.out.println("后置增强..........");
    }

    //Proceeding JoinPoint:  正在执行的连接点===切点
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强....");
        Object proceed = pjp.proceed();//切点方法
        System.out.println("环绕后增强....");
        return proceed;
    }

    public void afterThrowing(Throwable ex) {

       System.out.println(ex.getMessage());
//        System.out.println(Pjp.getSignature()+";;;"+Pjp.getArgs());
        System.out.println("异常抛出增强..........");
    }

    public void after() {
        System.out.println("最终增强..........");
    }

}
