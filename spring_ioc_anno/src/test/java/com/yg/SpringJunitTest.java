package com.yg;

import com.yg.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/4 22:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = SpringConfiguration.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class SpringJunitTest {


    @Autowired
    private UserDao userDao;

    @Autowired
    private DataSource dataSource;

    @Test
    public void test1() throws SQLException {
        userDao.save();
        System.out.println(dataSource.getConnection());
    }
}
