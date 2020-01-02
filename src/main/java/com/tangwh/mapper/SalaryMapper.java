package com.tangwh.mapper;

import com.tangwh.pojo.Salary;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:14
 * @version 1.0
 */
public interface SalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);
}