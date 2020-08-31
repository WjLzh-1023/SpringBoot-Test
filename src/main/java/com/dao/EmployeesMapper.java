package com.dao;

import com.model.Employees;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesMapper {
    Employees getByUserName(String userName);

    List<Employees> list();

    List<Employees> listByRoleid();

    void add(Employees employees);

    void del(int empid);

    void update(Employees employees);

    List<Employees> selbynotmyself(int empid);

    void editpassword();

    void editpasswordByempid(Employees employees);

}