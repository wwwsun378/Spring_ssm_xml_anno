package com.yg.proxy.jdk;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/7 16:33
 */
public class JdkProxyTest {
    public static void main(String[] args) {

        Target targetImpl = new TargetImpl();

        Advice advice = new Advice();
        //返回值是，动态代理对象
        Target proxyInstance = (Target) Proxy.newProxyInstance(
                targetImpl.getClass().getClassLoader(),  //目标对象的类加载器
                targetImpl.getClass().getInterfaces(), //目标对象相同的接口字节码对象数组
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        advice.before();
                        //  调用代理对象的任何方法，都是执行 代理方法
                        Object invoke = method.invoke(targetImpl, objects);
//                        System.out.println("invoke = " + invoke);
                        advice.after();
                        return invoke;
                    }
                });
//        proxyInstance.save();
        proxyInstance.get();
        if (proxyInstance instanceof Target) {
            System.out.println("o = " + proxyInstance.getClass());
        }

    }
}
