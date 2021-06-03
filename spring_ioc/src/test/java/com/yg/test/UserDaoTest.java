package com.yg.test;

import com.yg.dao.UserDao;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/4 1:10
 */
public class UserDaoTest {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }
}
