package com.controller;

import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.model.Employees;
import com.service.CustomerService;
import com.service.EmpService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmpController {

    @Autowired(required = false)
    EmpService empService;
    @Autowired(required = false)
    CustomerService customerService;

    @RequestMapping("/subject")
    @ResponseBody
    public Map subject() {
        Map data = new HashMap<>();

        Subject subject = SecurityUtils.getSubject();
        Employees emp = (Employees) subject.getPrincipal();

        data.put("emp", emp);
        return data;
    }


    @ResponseBody
    @RequestMapping("/cushare/not")
    public List<Employees> debynotself(int empid) {
        List<Employees> list = empService.selbynotmyself(empid);
        return list;
    }


    @ResponseBody
    @RequestMapping("/emp/list")
    public Map list(int pageNum, int size, int roleid) {
        if (roleid == 1) {
            PageInfo<Employees> pageInfo = empService.list(pageNum, size);
            Map map = new HashMap();
            map.put("emps", pageInfo.getList());
            map.put("rowCount", pageInfo.getTotal());
            map.put("pageCount", pageInfo.getPages());
            return map;
        } else {
            PageInfo<Employees> pageInfo = empService.listByRoleid(pageNum, size);
            Map map = new HashMap();
            map.put("emps", pageInfo.getList());
            map.put("rowCount", pageInfo.getTotal());
            map.put("pageCount", pageInfo.getPages());
            return map;
        }

    }


    @ResponseBody
    @RequestMapping("/emp/edit")
    public boolean edit(Employees employees, String modify) {
        if ("0".equals(modify)) {
            empService.add(employees);
        } else if ("1".equals(modify)) {
            empService.update(employees);
        }

        return true;
    }

    @ResponseBody
    @RequestMapping("/emp/del")
    public boolean del(int empid) {
        customerService.delemp(empid);
        return true;
    }


    @ResponseBody
    @RequestMapping("/emp/password")
    public void editpassword(){
        empService.editpassword();
    }

    @ResponseBody
    @RequestMapping("/emp/editpassword")
    public void edpas(int empid,String password){
        Employees employees = new Employees();
        employees.setEmpid(empid);
        employees.setPassword(password);
        empService.editpasswordByempid(employees);

    }

}
