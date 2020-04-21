package com.tangwh.service;

import com.tangwh.mapper.SalaryMapper;
import com.tangwh.mapper.extmapper.SalaryExtMapper;
import com.tangwh.pojo.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    @Autowired
    SalaryExtMapper salaryExtMapper;


    /**
     * 查询所有信息
     * @return
     */
    public List<Salary> getAllSalaries() {


        return salaryExtMapper.getAllSalaries();
    }
}
