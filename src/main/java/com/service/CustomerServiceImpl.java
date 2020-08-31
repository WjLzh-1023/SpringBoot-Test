package com.service;

import com.dao.EmployeesMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dao.CustomerMapper;
import com.dao.CustomervisitMapper;
import com.dao.EmployeesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.model.Customer;

import java.util.List;


@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired(required = false)
    CustomerMapper customerMapper;
    @Autowired(required = false)
    CustomervisitMapper customervisitMapper;
    @Autowired(required = false)
    EmployeesMapper empDao;


    //员工删除事务
    @Transactional
    @Override
    public void delemp(int empid){

        customervisitMapper.updateCusVisit(empid);
        customerMapper.updateCusShare(empid);
        customerMapper.updateCus(empid);
        empDao.del(empid);

    }

    //员工转移事务
    @Transactional
    @Override
    public int upcuByemp(Customer record) {
        customerMapper.upcuByemp(record);
        return 0;
    }


    @Override
    public PageInfo<Customer> selectAndempnamebyempid(int pageNum, int size, int empid) {
        PageHelper.startPage(pageNum, size);
        List<Customer> list =customerMapper.selectAndempnamebyempid(empid);
        PageInfo<Customer> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    @Transactional
    @Override
    public PageInfo<Customer> list(int pageNum, int size) {
        PageHelper.startPage(pageNum, size);
        List<Customer> list = customerMapper.selectAndempname();
        PageInfo<Customer> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(int cusid) {
        return customerMapper.deleteByPrimaryKey(cusid);
    }

    @Override
    public int insert(Customer record) {
        return customerMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Customer record) {
        return customerMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Customer> selectAndShare(int pageNum, int size, int empid) {
        PageHelper.startPage(pageNum, size);
        List<Customer> list = customerMapper.selectAndShare(empid);
        PageInfo<Customer> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Customer> all(int pageNum, int size) {
        PageHelper.startPage(pageNum, size);
        List<Customer> list = customerMapper.all();
        PageInfo<Customer> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int delsharebycusid(int cusid) {
        return customerMapper.delsharebycusid(cusid);
    }

    @Override
    public int insertshare(int cusid, int empid) {
        Customer customer = new Customer();
        customer.setCusid(cusid);
        customer.setEmpid(empid);
        return customerMapper.insertshare(customer);
    }
}
