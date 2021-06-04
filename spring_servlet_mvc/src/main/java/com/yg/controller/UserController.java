package com.yg.controller;

import com.yg.config.SpringConfiguration;
import com.yg.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/4 1:58
 */
public class UserController {

    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\IdeaProjects\\Spring\\spring_ioc\\src\\main\\resources\\applicationContext.xml");
        //加载主要配置为类
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();

        ((AnnotationConfigApplicationContext) applicationContext).close();
    }



}
