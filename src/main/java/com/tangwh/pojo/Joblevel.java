package com.tangwh.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */

/**
 * 职称管理表
 */
@Data
public class Joblevel {
    /**
    * 
    */
    private Integer id;

    /**
    * 职称名称
    */
    private String name;

    /**
    * 
    */
    private String titleLevel;

    /**
    * 
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date createDate;

    /**
    * 
    */
    private Boolean enabled;
}