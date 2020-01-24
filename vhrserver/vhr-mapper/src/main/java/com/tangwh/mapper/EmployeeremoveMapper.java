package com.tangwh.mapper;

import com.tangwh.pojo.Employeeremove;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */
public interface EmployeeremoveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeeremove record);

    int insertSelective(Employeeremove record);

    Employeeremove selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeremove record);

    int updateByPrimaryKey(Employeeremove record);
}