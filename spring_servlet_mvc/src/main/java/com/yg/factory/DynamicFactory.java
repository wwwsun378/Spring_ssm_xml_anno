package com.yg.factory;


import com.yg.dao.UserDao;
import com.yg.dao.impl.UserDaoImpl;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/4 1:52
 */
public class DynamicFactory {

    public static UserDao userDao;

    public UserDao getUserDao() {
        if (userDao == null) {
            return new UserDaoImpl();
        }
        return userDao;
    }
}
