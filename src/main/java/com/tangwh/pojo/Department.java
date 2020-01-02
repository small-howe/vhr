package com.tangwh.pojo;

import lombok.Data;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */
@Data
public class Department {
    /**
    * 
    */
    private Integer id;

    /**
    * 部门名称
    */
    private String name;

    /**
    * 
    */
    private Integer parentId;

    /**
    * 
    */
    private String depPath;

    /**
    * 
    */
    private Boolean enabled;

    /**
    * 
    */
    private Boolean isParent;
}