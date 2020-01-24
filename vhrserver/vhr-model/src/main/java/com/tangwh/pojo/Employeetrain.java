package com.tangwh.pojo;

import java.util.Date;
import lombok.Data;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */
@Data
public class Employeetrain {
    /**
    * 
    */
    private Integer id;

    /**
    * 员工编号
    */
    private Integer eid;

    /**
    * 培训日期
    */
    private Date trainDate;

    /**
    * 培训内容
    */
    private String trainContent;

    /**
    * 备注
    */
    private String remark;
}