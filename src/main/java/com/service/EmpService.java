package com.service;

import com.github.pagehelper.PageInfo;
import com.model.Employees;
import java.util.List;

public interface EmpService {
    PageInfo<Employees> list(int pageNum, int size);

    PageInfo<Employees> listByRoleid(int pageNum, int size);

    void add(Employees employees);

    Employees getByUserName(String userName);

    void del(int empid);

    void update(Employees employees);

    List<Employees> selbynotmyself(int empid);

    void editpassword();

    void editpasswordByempid(Employees employees);
}
