package com.tangwh.mapper.extmapper;

import com.tangwh.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeExtMapper {

    List<Employee> getEmployeByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyewords") String keyewords);

    Long getTotal(String keyewords);
}
