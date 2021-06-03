package com.yg.controller;

import com.yg.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/4 1:58
 */
public class UserController {

    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\IdeaProjects\\Spring\\spring_ioc\\src\\main\\resources\\applicationContext.xml");
// new AnnotationConfigApplicationContext()
        UserService userService = (UserService) applicationContext.getBean("userService");
//        UserService userService = applicationContext.getBean(UserService.class);

        userService.save();

//        UserService userService = new UserServiceImpl();
//        userService.save();
    }
}
