package com.yg.proxy.jdk;

import org.springframework.stereotype.Component;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/7 16:31
 */
@Component
public class TargetImpl implements Target {
    @Override
    public void save() {
       int i = 10/0;
        System.out.println("TargetImpl save .................");
    }

    @Override
    public void get() {
        System.out.println("TargetImpl get .................");
    }
}
