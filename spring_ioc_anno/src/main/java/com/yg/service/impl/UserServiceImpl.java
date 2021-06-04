package com.yg.service.impl;

import com.yg.dao.UserDao;
import com.yg.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/4 1:58
 */
@Service(value = "userService")
@Scope
public class UserServiceImpl implements UserService {


    //    @Autowired
//    @Qualifier(value = "userDao")
    @Resource
    UserDao userDao;

    private String str ;

    UserServiceImpl() {
        System.out.println(this.getClass() + "无参构造方法被调用");
    }
//    UserServiceImpl(UserDao userDao,String str) {
//        System.out.println("UserServiceImpl 注入 userDao");
//        this.userDao = userDao;
//        this.str=str;
//    }


    @Override
    public void save() {
        userDao.save();
    }

    @PostConstruct
    public void init() {
        System.out.println(this.getClass() + "初始化");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(this.getClass() + "销毁了");
    }
}
