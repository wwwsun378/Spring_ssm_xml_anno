package com.yg.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/7 16:12
 */
@Component
@Aspect
public class MyAspect {

    @Before(value = "execution(* com.yg.proxy.jdk.*.*(..))")
    public void before() {
        System.out.println("前置增强..........");
    }

    @AfterReturning(value = "pointcut()")
    public void afterReturning() {
        System.out.println("后置增强..........");
    }

    //Proceeding JoinPoint:  正在执行的连接点===切点
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强....");
        Object proceed = pjp.proceed();//切点方法
        System.out.println("环绕后增强....");
        return proceed;
    }

    public void afterThrowing() {
        System.out.println("异常抛出增强..........");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("最终增强..........");
    }

    @Pointcut(value = "execution(* com.yg.proxy..*.*(..))")
    public void pointcut() {
    }

}
