package com.yg.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/5 0:06
 */
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String applicationContextXml = servletContext.getInitParameter("contextConfigLocation");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(applicationContextXml);
        servletContext.setAttribute("applicationContext", applicationContext);
        System.out.println("ServletContextListener contextInitialized over!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
