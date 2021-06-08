package com.yg.service.impl;


import com.yg.dao.AccountDao;
import com.yg.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan, money);
//        int i = 1 / 0;
        accountDao.in(inMan, money);
    }

    //@Transactional(isolation = Isolation.DEFAULT)
    public void xxx(){}
}
