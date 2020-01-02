package com.tangwh.mapper;

import com.tangwh.pojo.Empsalary;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */
public interface EmpsalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Empsalary record);

    int insertSelective(Empsalary record);

    Empsalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Empsalary record);

    int updateByPrimaryKey(Empsalary record);
}