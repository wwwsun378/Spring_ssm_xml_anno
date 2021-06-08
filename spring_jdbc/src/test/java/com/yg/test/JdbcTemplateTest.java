package com.yg.test;

import com.yg.config.SpringConfiguration;
import com.yg.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/5 18:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class JdbcTemplateTest {

//    @Autowired
//    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test1() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(dataSource);
        String inset = "insert into user(username,age,email) values('wangkang',11,'wwwsun378@163.com')";
//        int update = jdbcTemplate.update("update user set username='反美' where id = 1");
        int update = jdbcTemplate.update("update user set username=? where id = 1", "我试试是");
        System.out.println("update = " + update);
        int exec = jdbcTemplate.update("insert into user(username,age,email) values (?,?,?)", "wangkang", 11, "wwwsun378@163.com");
        System.out.println("exec = " + exec);

        jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
    }
}
