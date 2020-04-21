package com.tangwh.mapper.extmapper;

import com.tangwh.pojo.Salary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalaryExtMapper {



    List<Salary> getAllSalaries();
}
