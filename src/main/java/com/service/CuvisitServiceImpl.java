package com.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dao.CustomervisitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Customervisit;

import java.util.List;

@Service("cuvisitService")
public class CuvisitServiceImpl implements CuvisitService{

    @Autowired(required = false)
    CustomervisitMapper customervisitMapper;


    @Override
    public PageInfo<Customervisit> list(int pageNum, int size) {
        PageHelper.startPage(pageNum, size);
        List<Customervisit> cus = customervisitMapper.listCusVisit();
        PageInfo<Customervisit> pageInfo = new PageInfo<>(cus);
        return pageInfo;
    }

    @Override
    public int updateByPrimaryKey(Customervisit record) {
        return customervisitMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Customervisit> listCusVisitByEmpid(int pageNum, int size, int empid) {
        PageHelper.startPage(pageNum, size);
        List<Customervisit> cus = customervisitMapper.listCusVisitByEmpid(empid);
        PageInfo<Customervisit> pageInfo = new PageInfo<>(cus);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return customervisitMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Customervisit record) {
        return customervisitMapper.insert(record);
    }


}
