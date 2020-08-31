package com.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dao.EmployeesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.model.Employees;

import java.util.List;

@Service("empService")
public class EmpServiceImpl implements EmpService {
/*
    @Autowired
    TransactionTemplate transactionTemplate;*/

    @Autowired(required = false)
    private EmployeesMapper empDao;

    @Transactional
    @Override
    public PageInfo<Employees> list(int pageNum, int size) {
        PageHelper.startPage(pageNum, size);
        List<Employees> emps = empDao.list();
        PageInfo<Employees> pageInfo = new PageInfo<>(emps);
        return pageInfo;
    }

    @Override
    public PageInfo<Employees> listByRoleid(int pageNum, int size) {
        PageHelper.startPage(pageNum, size);
        List<Employees> emps = empDao.listByRoleid();
        PageInfo<Employees> pageInfo = new PageInfo<>(emps);
        return pageInfo;
    }


    @Transactional
    @Override
    public void add(Employees employees) {
        empDao.add(employees);
    }


    @Transactional
    @Override
    public Employees getByUserName(String userName) {
        return empDao.getByUserName(userName);
    }

    @Override
    public void del(int empid) {
        empDao.del(empid);
    }

    @Transactional
    @Override
    public void update(Employees employees) {
        empDao.update(employees);
    }

    @Override
    public List<Employees> selbynotmyself(int empid) {
        return empDao.selbynotmyself(empid);
    }

    @Override
    public void editpassword() {
        empDao.editpassword();
    }

    @Override
    public void editpasswordByempid(Employees employees) {
        empDao.editpasswordByempid(employees);
    }



    /*编程事务
     @Override
    public void add(Emp emp) {
        transactionTemplate.execute(new TransactionCallback<Emp>() {
            @Override
            public Emp doInTransaction(TransactionStatus transactionStatus) {
                empDao.add(emp);
                return null;
            }
        });
    }

    */

}
