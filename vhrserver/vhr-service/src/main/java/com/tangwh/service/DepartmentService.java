package com.tangwh.service;

import com.tangwh.mapper.DepartmentMapper;
import com.tangwh.mapper.extmapper.DepartmentExtMapper;
import com.tangwh.pojo.Department;
import com.tangwh.pojo.RespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
public class DepartmentService {


    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    DepartmentExtMapper departmentExtMapper;

    /**
     * 递归的方式查询 部门表
     *
     * @return
     */
    public List<Department> getAllDepartments() {
        return departmentExtMapper.getAllDepartmentsByPrimaryId(-1);
    }

    /**
     * 添加操作 调用存储过程
     *
     * @param dep
     */
    public void addDep(Department dep) {
        dep.setEnabled(true);
        departmentExtMapper.addDep(dep);

    }


    /**
     * 删除操作 调用存储过程
     * @param dep
     */
    public void deleteDepById(Department dep) {
        departmentExtMapper.deleteDepById(dep);
    }

    /**
     * 查询
     * @return
     */
    public List<Department> getAllDepartmentsWithOutChildren() {

        return departmentExtMapper.getAllDepartmentsWithOutChildren();

    }
}
