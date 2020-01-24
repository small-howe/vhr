package com.tangwh.pojo;

import java.util.Date;
import lombok.Data;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */
@Data
public class Employeeremove {
    /**
    * 
    */
    private Integer id;

    /**
    * 
    */
    private Integer eid;

    /**
    * 调动后部门
    */
    private Integer afterDepId;

    /**
    * 调动后职位
    */
    private Integer afterJobId;

    /**
    * 调动日期
    */
    private Date removeDate;

    /**
    * 调动原因
    */
    private String reason;

    /**
    * 
    */
    private String remark;
}