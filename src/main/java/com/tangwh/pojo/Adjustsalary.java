package com.tangwh.pojo;

import java.util.Date;
import lombok.Data;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:12
 * @version 1.0
 */
@Data
public class Adjustsalary {
    /**
    * 
    */
    private Integer id;

    /**
    * 
    */
    private Integer eid;

    /**
    * 调薪日期
    */
    private Date asDate;

    /**
    * 调前薪资
    */
    private Integer beforeSalary;

    /**
    * 调后薪资
    */
    private Integer afterSalary;

    /**
    * 调薪原因
    */
    private String reason;

    /**
    * 备注
    */
    private String remark;
}