package com.controller;

import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.model.Customer;
import com.model.Employees;
import com.service.CustomerService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired(required = false)
    CustomerService customerService;


    @ResponseBody
    @RequestMapping("/cushare/dele")
    public boolean dele(int cusid) {
        customerService.delsharebycusid(cusid);
        return true;
    }

    @ResponseBody
    @RequestMapping("/cushare/reemp")
    public boolean reempbyid(int cusid, int empid) {
        Customer customer = new Customer();
        customer.setCusid(cusid);
        customer.setEmpid(empid);
        customerService.upcuByemp(customer);
        return true;
    }


    @ResponseBody
    @RequestMapping("/cushare/add")
    public boolean insertshare(int cusid, int empid) {
        customerService.insertshare(cusid, empid);
        return true;
    }


    @ResponseBody
    @RequestMapping("/customershare")
    public Map listshare(int pageNum, int size, int empid,int roleid) {
        if (roleid == 3) {
            Subject subject = SecurityUtils.getSubject();
            Employees emp = (Employees) subject.getPrincipal();
            int empid1 = emp.getEmpid();
            PageInfo<Customer> pageInfo = customerService.selectAndShare(pageNum, size, empid1);
            Map map = new HashMap();
            map.put("customers", pageInfo.getList());
            map.put("rowCount", pageInfo.getTotal());
            map.put("pageCount", pageInfo.getPages());
            return map;

        }else{
            PageInfo<Customer> pageInfo = customerService.all(pageNum, size);
            Map map = new HashMap();
            map.put("customers", pageInfo.getList());
            map.put("rowCount", pageInfo.getTotal());
            map.put("pageCount", pageInfo.getPages());
            return map;

        }
    }


    @ResponseBody
    @RequestMapping("/customer/list")
    public Map list(int pageNum, int size, int roleid, int empid) {
        if (roleid == 3) {
            PageInfo<Customer> pageInfo = customerService.selectAndempnamebyempid(pageNum, size, empid);
            Map map = new HashMap();
            map.put("customers", pageInfo.getList());
            map.put("rowCount", pageInfo.getTotal());
            map.put("pageCount", pageInfo.getPages());
            return map;

        } else {
            PageInfo<Customer> pageInfo = customerService.list(pageNum, size);
            Map map = new HashMap();
            map.put("customers", pageInfo.getList());
            map.put("rowCount", pageInfo.getTotal());
            map.put("pageCount", pageInfo.getPages());
            return map;

        }
    }


    @ResponseBody
    @RequestMapping("/customer/del")
    public boolean del(int cusid) {
        customerService.deleteByPrimaryKey(cusid);
        return true;
    }


    @ResponseBody
    @RequestMapping("/customer/edit")
    public boolean edit(Customer customer, String modify) {
        if ("0".equals(modify)) {
            customerService.insert(customer);
        } else if ("1".equals(modify)) {
            customerService.updateByPrimaryKey(customer);
        }
        return true;
    }

}
