package com.tangwh.pojo;

import java.util.Date;
import java.util.Objects;

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

    public Position(String name) {
        this.name = name;
    }

    public Position() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()){ return false;}
        Position position = (Position) o;
        return Objects.equals(name, position.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

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