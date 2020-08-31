package com.service;

import com.github.pagehelper.PageInfo;
import com.model.Customervisit;

public interface CuvisitService {
    PageInfo<Customervisit> list(int pageNum, int size);
    int updateByPrimaryKey(Customervisit record);
    int deleteByPrimaryKey(Integer id);
    int insert(Customervisit record);

    PageInfo<Customervisit> listCusVisitByEmpid(int pageNum, int size, int empid);

}
