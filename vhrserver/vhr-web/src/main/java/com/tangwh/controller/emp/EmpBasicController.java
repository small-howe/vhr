package com.tangwh.controller.emp;

import com.tangwh.pojo.RespPageBean;
import com.tangwh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工操作
 */
@RestController
@RequestMapping("/emp/basic")
public class EmpBasicController {

    @Autowired
    EmployeeService employeeService;

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
}
