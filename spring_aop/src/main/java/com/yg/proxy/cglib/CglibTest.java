package com.yg.proxy.cglib;

import com.yg.proxy.jdk.Advice;
import com.yg.proxy.jdk.Target;
import com.yg.proxy.jdk.TargetImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/7 17:22
 */
public class CglibTest {
    public static void main(String[] args) {
        Target targetImpl = new TargetImpl();

        Advice advice = new Advice();
        //返回值 就是动态生成的代理对象  基于cglib
        //1、创建增强器
        Enhancer enhancer = new Enhancer();
        //2、设置父类（目标）
        enhancer.setSuperclass(TargetImpl.class);
        //3、设置回调
        enhancer.setCallback(
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                        advice.before(); //执行前置
                        Object invoke = method.invoke(targetImpl, args);//执行目标
                        advice.after(); //执行后置
                        return invoke;
                    }
                });
        //4、创建代理对象
        TargetImpl proxy = (TargetImpl) enhancer.create();
        proxy.save();
    }
}
