package com.tangwh.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:14
 * @version 1.0
 */

/**
 * 职位表
 */
@Data
public class Position {
    /**
    * 
    */
    private Integer id;

    /**
    * 职位
    */
    private String name;

    /**
    *  pattern:想要转换的格式    timezone:时区
    */
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date createDate;

    /**
    * 
    */
    private Boolean enabled;
}