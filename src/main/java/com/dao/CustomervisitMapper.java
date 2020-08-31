package com.dao;

import com.model.Customervisit;

import java.util.List;

public interface CustomervisitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customervisit record);

    int insertSelective(Customervisit record);

    Customervisit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customervisit record);

    int updateByPrimaryKey(Customervisit record);

    List<Customervisit> listCusVisit();

    List<Customervisit> listCusVisitByEmpid(int empid);

    int updateCusVisit(int empid);

}