package com.tangwh.mapper.extmapper;

import com.tangwh.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


@Mapper
public interface EmployeeExtMapper {

    List<Employee> getEmployeByPage(@Param("page") Integer page, @Param("size") Integer size,
                                    @Param("emp")Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotal(@Param("emp")Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Integer maxWorkID();


    Integer addEmps(@Param("list") List<Employee> list);

    Employee getEmployeById(Integer id);
}
