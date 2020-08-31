package com.service;

import com.github.pagehelper.PageInfo;
import com.model.Customer;


public interface CustomerService {
    PageInfo<Customer> list(int pageNum, int size);

    int deleteByPrimaryKey(int cusid);

    int insert(Customer record);

    int updateByPrimaryKey(Customer record);

    PageInfo<Customer> selectAndShare(int pageNum, int size, int empid);

    PageInfo<Customer> all(int pageNum, int size);

    int delsharebycusid(int cusid);

    int insertshare(int cusid, int empid);

    void delemp(int empid);

    int upcuByemp(Customer record);

    PageInfo<Customer> selectAndempnamebyempid(int pageNum, int size, int empid);
}
