package com.tangwh.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */

/**
 * 部门管理表
 */
@Data
public class Department {
    /**
    *  部门id
    */
    private Integer id;

    /**
    * 部门名称
    */
    private String name;

    /**
    *  所在部门父类的id
    */
    private Integer parentId;

    /**
    *  搜索专用
    */
    private String depPath;

    /**
    *  是否启用
    */
    private Boolean enabled;

    /**
    * 
    */
    private Boolean isParent;

    /**
     * 子下的部门
     */
    private List<Department> children = new ArrayList<>();

    /**
     * 返回的结果
     */
    private Integer result;
}