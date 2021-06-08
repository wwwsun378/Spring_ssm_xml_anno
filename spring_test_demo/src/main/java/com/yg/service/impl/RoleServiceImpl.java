package com.yg.service.impl;



import com.yg.dao.RoleDao;
import com.yg.domain.Role;
import com.yg.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> list() {
        String str ;
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    public void save(Role role) {
        roleDao.save(role);
    }
}
