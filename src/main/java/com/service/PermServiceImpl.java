package com.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dao.PermissionMapper;
import com.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Permission;
import com.model.Role;

import java.util.List;

@Service("permService")
public class PermServiceImpl implements com.service.PermService {

    @Autowired(required = false)
    PermissionMapper permissionMapper;
    @Autowired(required = false)
    RoleMapper roleMapper;

    @Override
    public List<Permission> getPermsByRoleid(Integer roleid) {
        return permissionMapper.getPermsByRoleid(roleid);
    }

    @Override
    public PageInfo<Role> list(int pageNum, int size) {
        PageHelper.startPage(pageNum, size);
        List<Role> list =roleMapper.list();
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int del(Role record) {
        return roleMapper.del(record);
    }

    @Override
    public int add(Role record) {
        return roleMapper.add(record);
    }
}
