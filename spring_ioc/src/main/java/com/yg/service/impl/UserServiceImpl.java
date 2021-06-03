package com.yg.service.impl;

import com.yg.dao.UserDao;
import com.yg.service.UserService;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/4 1:58
 */
public class UserServiceImpl implements UserService {

    UserDao userDao;

    UserServiceImpl(UserDao userDao) {
        System.out.println("UserServiceImpl 注入 userDao");
        this.userDao = userDao;
    }

//    public UserDao getUserDao() {
//        return userDao;
//    }
//
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        userDao.save();
    }
}
