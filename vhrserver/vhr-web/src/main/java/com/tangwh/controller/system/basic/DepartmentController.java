package com.tangwh.controller.system.basic;

import com.tangwh.pojo.Department;
import com.tangwh.pojo.RespEntity;
import com.tangwh.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门增删改查
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;

    /**
     * 使用递归的方式查询 部门表
     * @return
     */
    @GetMapping("/")
    public List<Department> getAllDepartments(){

        return departmentService.getAllDepartments();
    }

    /**
     * 添加部门 调用存储过程
     * @param dep
     * @return
     */
    @PostMapping("/")
    public RespEntity addDep(@RequestBody Department dep){
        departmentService.addDep(dep);
        if (dep.getResult()==1){
            return RespEntity.ok("添加成功",dep);
        }
        return RespEntity.error("添加失败");
    }

    /**
     * 删除操作 调用存储过程
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public RespEntity deleteDepById(@PathVariable Integer id) {
        Department dep = new Department();
        dep.setId(id);
        departmentService.deleteDepById(dep);
        if (dep.getResult() == -2) {
            return RespEntity.error("该部门下有子部门,删除失败");
        }else  if(dep.getResult()== -1){
            return RespEntity.error("该部门下有员工,不能删除");
        }else if (dep.getResult()==1){
            return RespEntity.ok("删除失败");
        }
        return RespEntity.error("删除失败");
    }
}
