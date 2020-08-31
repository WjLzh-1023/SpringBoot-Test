package com.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.model.Role;
import com.service.PermService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RoleController {

    @Autowired(required = false)
    PermService permService;

    @ResponseBody
    @RequestMapping("/role/list")
    public Map list(int pageNum, int size) {
        PageInfo<Role> pageInfo = permService.list(pageNum, size);
        Map map = new HashMap();
        map.put("roles", pageInfo.getList());
        map.put("rowCount", pageInfo.getTotal());
        map.put("pageCount", pageInfo.getPages());
        return map;
    }


    @ResponseBody
    @RequestMapping("/role/del")
    public boolean del(int roleid, int permid) {
        Role role = new Role();
        role.setPermid(permid);
        role.setRoleid(roleid);
        permService.del(role);
        return true;
    }


    @ResponseBody
    @RequestMapping("/role/add")
    public boolean add(int roleid, int permid) {
        Role role = new Role();
        role.setPermid(permid);
        role.setRoleid(roleid);
        permService.add(role);
        return true;
    }

}
