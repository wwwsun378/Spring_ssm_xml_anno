package com.yg.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/5 1:08
 */
public class WebApplicationContextUtils {

    public static ApplicationContext getWebApplicationContext(ServletContext sc){
        return (ApplicationContext) sc.getAttribute("applicationContext");
    }
}
