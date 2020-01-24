package com.tangwh.mapper;

import com.tangwh.pojo.Adjustsalary;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:12
 * @version 1.0
 */
public interface AdjustsalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Adjustsalary record);

    int insertSelective(Adjustsalary record);

    Adjustsalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Adjustsalary record);

    int updateByPrimaryKey(Adjustsalary record);
}