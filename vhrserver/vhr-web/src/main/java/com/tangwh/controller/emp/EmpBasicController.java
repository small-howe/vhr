package com.tangwh.controller.emp;

import com.tangwh.pojo.*;
import com.tangwh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工操作
 */
@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {

    @Autowired
    EmployeeService employeeService;
    // 民族
    @Autowired
    NationService nationService;
    // 政治面貌
    @Autowired
    PoliticsstatusService politicsstatusService;

    //  职称管理
    @Autowired
    JoblevelService joblevelService;

    // 职位管理
    @Autowired
    PositionService positionService;

    // 所属部门
    @Autowired
    DepartmentService departmentService;

    /**
     * 分页查询
     *
     * @param page 默认查询第一页
     * @param size 每页查询10个
     * @return
     */
    @GetMapping("/")
    public RespPageBean getEmployeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue =
            "10") Integer size,String keyewords) {

        return employeeService.getEmployeByPage(page, size,keyewords);
    }

    /**
     * 添加员工
     *
     * @param employee
     * @return
     */
    @PostMapping("/")
    public RespEntity addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee) == 1) {
            return RespEntity.ok("添加成功");
        }
        return RespEntity.error("添加失败");

    }


    /**
     * 查询民族  前端下拉显示
     *
     * @return
     */
    @GetMapping("/nations")
    public List<Nation> getAllNations() {
        return nationService.getAllNations();
    }


    /**
     * 政治面貌
     *
     * @return
     */
    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusService.getAllPoliticsstatus();

    }

    /**
     * 职称管理查询
     *
     * @return
     */
    @GetMapping("/joblevel")
    public List<Joblevel> getJoblevels() {
        return joblevelService.getAllJobLevels();
    }

    /**
     * 职位查询
     *
     * @return
     */
    @GetMapping("/position")
    public List<Position> getAllPosition() {

        return positionService.getAllPositions();
    }

    /**
     * 查询最大的工号
     *
     * @return
     */
    @GetMapping("/maxWorkId")
    public RespEntity maxWorkID() {
// 格式化工号
        return RespEntity.ok("", String.format("%08d", employeeService.maxWorkID() + 1));


    }

    /**
     * 获取所有 所属部门
     * @return
     */
    @GetMapping("/deps")
    public List<Department> getAllDepartments() {

        return departmentService.getAllDepartments();
    }


    /**
     * 删除员工信息
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public RespEntity deleteEmpById(@PathVariable Integer id){

        if (employeeService.deleteEmpById(id) == 1){
            return RespEntity.ok("删除成功");
        }
        return RespEntity.error("删除失败");
    }
}
