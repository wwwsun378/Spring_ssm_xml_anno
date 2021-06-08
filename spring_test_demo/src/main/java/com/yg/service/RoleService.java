package com.yg.service;


import com.yg.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> list() ;

    void save(Role role);
}
