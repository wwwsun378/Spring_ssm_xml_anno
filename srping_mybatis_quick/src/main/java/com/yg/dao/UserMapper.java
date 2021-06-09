package com.yg.dao;

import com.yg.domain.User;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/8 19:48
 */
public interface UserMapper {
    List<User> findAll();

    User findById(Integer id);


    List<User> findByCondition(User user);

    List<User> findByUserList(List list);

    void save(User user);


}
