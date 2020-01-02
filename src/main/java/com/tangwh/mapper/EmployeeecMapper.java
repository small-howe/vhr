package com.tangwh.mapper;

import com.tangwh.pojo.Employeeec;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */
public interface EmployeeecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeeec record);

    int insertSelective(Employeeec record);

    Employeeec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeec record);

    int updateByPrimaryKey(Employeeec record);
}