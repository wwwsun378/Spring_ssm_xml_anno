package com.yg.controller;

import com.yg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/4 23:14
 */
public class UserServlet extends HttpServlet {


    @Autowired
    public DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();


        //方法1：更具xml文件获取
        //        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //        UserService bean = classPathXmlApplicationContext.getBean(UserService.class);


        //方法2： 更具自己写的工具获取
//        ApplicationContext applicationContext = (ApplicationContext) servletContext.getAttribute("applicationContext");
//        UserService bean = applicationContext.getBean(UserService.class);

        //方法3：spring 提供的监听器 容器初始化 工具获取
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService bean = webApplicationContext.getBean(UserService.class);

        try {

//            DataSource  dataSource2 = (DataSource) webApplicationContext.getBean("dataSource2");
            DataSource dataSource1 = (DataSource) webApplicationContext.getBean("dataSource");
            System.out.println("测试datasource1 = " + dataSource1.getConnection());


//            System.out.println("测试datasource2 = " + dataSource2.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        bean.save();


    }
}
