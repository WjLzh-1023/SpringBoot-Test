package com.service;

import com.github.pagehelper.PageInfo;
import com.model.Permission;
import com.model.Role;

import java.util.List;

public interface PermService {
    List<Permission> getPermsByRoleid(Integer roleid);
    PageInfo<Role> list(int pageNum, int size);
    int del(Role record);

    int add(Role record);
}
