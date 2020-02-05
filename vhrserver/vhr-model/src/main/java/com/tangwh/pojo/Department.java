package com.tangwh.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */

/**
 * 部门管理表
 */
@Data
public class Department implements Serializable {
    /**
    *  部门id
    */
    private Integer id;

    /**
    * 部门名称
    */
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

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