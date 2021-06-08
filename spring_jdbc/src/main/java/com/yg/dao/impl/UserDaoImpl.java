package com.yg.dao.impl;

import com.yg.dao.UserDao;
import com.yg.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/4 1:08
 */
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {


    private List<String> list;
    private Map<String, User> map;
    private Properties properties;
    //    @Value("yangguang")
    @Value("${user.username}")
    private String username;
    @Value("${user.age}")
    private int age;
    public UserDaoImpl() {
        System.out.println("UserDaoImpl 无参构造方法被执行");
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void save() {
        System.out.println("list = " + list);
        System.out.println("map = " + map);
        System.out.println("properties = " + properties);
        System.out.println("username = " + username + "; age = " + age);
        System.out.println("UserDaoImpl save--------- over!");
    }

    void init() {
        System.out.println("init over!");
    }

    void destory() {
        System.out.println("destory is over!");
    }
}
