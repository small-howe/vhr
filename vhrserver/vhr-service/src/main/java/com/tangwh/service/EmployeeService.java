package com.tangwh.service;

import com.tangwh.mapper.EmployeeMapper;
import com.tangwh.mapper.extmapper.EmployeeExtMapper;
import com.tangwh.pojo.Employee;
import com.tangwh.pojo.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工操作
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmployeeExtMapper employeeExtMapper;

    public RespPageBean getEmployeByPage(Integer page, Integer size,String keyewords) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeExtMapper.getEmployeByPage(page, size,keyewords);
        // 获取总记录数
        Long total = employeeExtMapper.getTotal(keyewords);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(data);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    public Integer addEmp(Employee employee) {
        return employeeMapper.insertSelective(employee);
    }

    /**
     * 查询最大工号
     *
     * @return
     */
    public Integer maxWorkID() {
        return employeeExtMapper.maxWorkID();


    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    public Integer deleteEmpById(Integer id) {
      return   employeeMapper.deleteByPrimaryKey(id);
    }
}
