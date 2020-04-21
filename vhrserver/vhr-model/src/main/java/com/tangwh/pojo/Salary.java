package com.tangwh.pojo;

import java.util.Date;
import lombok.Data;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:14
 * @version 1.0
 *  工资账号表
 */
@Data
public class Salary {
    /**
    * 
    */
    private Integer id;

    /**
    * 基本工资
    */
    private Integer basicSalary;

    /**
    * 奖金
    */
    private Integer bonus;

    /**
    * 午餐补助
    */
    private Integer lunchSalary;

    /**
    * 交通补助
    */
    private Integer trafficSalary;

    /**
    * 应发工资
    */
    private Integer allSalary;

    /**
    * 养老金基数
    */
    private Integer pensionBase;

    /**
    * 养老金比率
    */
    private Float pensionPer;

    /**
    * 启用时间
    */
    private Date createDate;

    /**
    * 医疗基数
    */
    private Integer medicalBase;

    /**
    * 医疗保险比率
    */
    private Float medicalPer;

    /**
    * 公积金基数
    */
    private Integer accumulationFundBase;

    /**
    * 公积金比率
    */
    private Float accumulationFundPer;

    /**
    * 
    */
    private String name;
}