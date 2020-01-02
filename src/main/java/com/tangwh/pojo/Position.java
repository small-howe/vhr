package com.tangwh.pojo;

import java.util.Date;
import lombok.Data;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:14
 * @version 1.0
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
    * 
    */
    private Date createDate;

    /**
    * 
    */
    private Boolean enabled;
}