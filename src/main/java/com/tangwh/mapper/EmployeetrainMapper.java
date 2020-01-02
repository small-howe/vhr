package com.tangwh.mapper;

import com.tangwh.pojo.Employeetrain;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */
public interface EmployeetrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeetrain record);

    int insertSelective(Employeetrain record);

    Employeetrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeetrain record);

    int updateByPrimaryKey(Employeetrain record);
}