package com.tangwh.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */
@Data
public class Menu {
    /**
    * 
    */
    private Integer id;

    /**
    * 
    */
    private String url;

    /**
    * 
    */
    private String path;

    /**
    * 
    */
    private String component;

    /**
    * 
    */
    private String name;

    /**
    * 
    */
    private String iconCls;



    /**
    * 
    */
    private Integer parentId;

    /**
    * 
    */
    private Boolean enabled;


    /**
     * 没有的字段 放在这个实体类
     */
    private Meta meta;

    /**
     * 前端把组件放在  router/index.js 的childen组件放着
     */
    private List<Meta> children;

    /**
     * 角色
     */
    private List<Role> roles;

}