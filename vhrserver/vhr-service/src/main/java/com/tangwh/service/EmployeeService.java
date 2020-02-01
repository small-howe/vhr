package com.tangwh.service;

import com.tangwh.mapper.EmployeeMapper;
import com.tangwh.mapper.extmapper.EmployeeExtMapper;
import com.tangwh.pojo.Employee;
import com.tangwh.pojo.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 员工操作
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    // 日期格式化

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    //计算结果保留两位

    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    @Autowired
    EmployeeExtMapper employeeExtMapper;

    public RespPageBean getEmployeByPage(Integer page, Integer size,Employee employee,Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeExtMapper.getEmployeByPage(page, size,employee,beginDateScope);
        // 获取总记录数
        Long total = employeeExtMapper.getTotal(employee,beginDateScope);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(data);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    /**
     * 添加操作
     *
     * @param employee
     * @return
     */
    public Integer addEmp(Employee employee) {
        // 拿到合同起始日期
        Date beginContract = employee.getBeginContract();
        // 拿到 合同终止日期
        Date endContract = employee.getEndContract();
        // (终止的日期年 -  起始日期年)*12 +
     double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract)))*12+
                (Double.parseDouble(monthFormat.format(endContract))-Double.parseDouble(monthFormat.format(beginContract)));

     // 算出来的 合同年限
     employee.setContractTerm(Double.parseDouble(decimalFormat.format(month/12)));
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
        return employeeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改操作
     *
     * @param employee
     * @return
     */
    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    /**
     *  将Excel 解析出来的结果 添加到数据库中
     * @param list
     * @return
     */
    public Integer addEmps(List<Employee> list) {

        return employeeExtMapper.addEmps(list);
    }
}
