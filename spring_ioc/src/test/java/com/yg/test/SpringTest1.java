package com.yg.test;

import com.yg.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/4 1:34
 */
public class SpringTest1 {

    @Test
    public void test() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
    }
}
