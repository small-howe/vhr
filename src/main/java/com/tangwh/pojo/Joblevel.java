package com.tangwh.pojo;

import java.util.Date;
import lombok.Data;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
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
    private Date createDate;

    /**
    * 
    */
    private Boolean enabled;
}