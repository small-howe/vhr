package com.tangwh.mapper.extmapper;

import com.tangwh.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentExtMapper {
    /**
     * 递归方式查询所有的部门信息
     * @param pid
     * @return
     */
    List<Department> getAllDepartmentsByPrimaryId(Integer pid);

    /**
     * 添加操作
     * @param dep
     */
    void addDep(Department dep);

    /**
     * 删除操作
     * @param dep
     */
    void deleteDepById(Department dep);
}
