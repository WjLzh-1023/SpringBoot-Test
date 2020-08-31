package com.controller;

import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.model.Customervisit;
import com.service.CuvisitService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CuvisitController {

    @Autowired(required = false)
    CuvisitService cuvisitService;


    @ResponseBody
    @RequestMapping("/cuvisit/add")
    public boolean add(int cusid, int empid, String content, String date) throws ParseException {
        Customervisit customervisit = new Customervisit();
        customervisit.setCusid(cusid);
        customervisit.setEmpid(empid);
        customervisit.setContent(content);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = simpleDateFormat.parse(date);
        customervisit.setDate(d);
        cuvisitService.insert(customervisit);
        return true;
    }

    @ResponseBody
    @RequestMapping("/cuvisit/list")
    public Map list(int pageNum, int size, int roleid, int empid) {
        System.out.println(pageNum+"+"+size+"+"+roleid+"+"+empid);
        Map map = new HashMap();
        if (roleid == 3) {
            PageInfo<Customervisit> pageInfo = cuvisitService.listCusVisitByEmpid(pageNum, size, empid);

            map.put("cuvisits", pageInfo.getList());
            map.put("rowCount", pageInfo.getTotal());
            map.put("pageCount", pageInfo.getPages());

        } else {
            PageInfo<Customervisit> pageInfo = cuvisitService.list(pageNum, size);

            map.put("cuvisits", pageInfo.getList());
            map.put("rowCount", pageInfo.getTotal());
            map.put("pageCount", pageInfo.getPages());

        }
        return map;
    }


    @RequiresPermissions("emp:del")
    @ResponseBody
    @RequestMapping("/cuvisit/del")
    public boolean del(Integer id) {
        cuvisitService.deleteByPrimaryKey(id);
        return true;
    }


    @RequiresPermissions("emp:update")
    @ResponseBody
    @RequestMapping("/cuvisit/updata")
    public boolean updata(String content, String Sdata, int id) throws ParseException {
        Customervisit customervisit = new Customervisit();
        customervisit.setContent(content);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(Sdata);
        customervisit.setDate(date);
        customervisit.setId(id);
        cuvisitService.updateByPrimaryKey(customervisit);
        return true;
    }


}
