package com.yg.proxy.jdk;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/7 16:32
 */
public class Advice {

    public void before(){
        System.out.println("前置增强....");
    }

    public void after(){
        System.out.println("后置增强....");
    }
}
