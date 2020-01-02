package com.tangwh.pojo;

import lombok.Data;

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
    private Boolean keepAlive;

    /**
    * 
    */
    private Boolean requireAuth;

    /**
    * 
    */
    private Integer parentId;

    /**
    * 
    */
    private Boolean enabled;
}