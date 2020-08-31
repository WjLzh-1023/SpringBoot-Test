package com.dao;

import com.model.Customer;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(int cusid);

    int insert(Customer record);

    int updateByPrimaryKey(Customer record);

    List<Customer> selectAndempname();

    List<Customer>  selectAndempnamebyempid(int empid);

    List<Customer> selectAndShare(int empid);

    List<Customer> all();

    int delsharebycusid(int cusid);

    int insertshare(Customer record);

    int updateCus(int empid);

    int updateCusShare(int empid);

    int upcuByemp(Customer record);
}