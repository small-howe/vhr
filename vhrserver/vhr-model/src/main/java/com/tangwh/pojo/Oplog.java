package com.tangwh.pojo;

import java.util.Date;
import lombok.Data;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:14
 * @version 1.0
 */
@Data
public class Oplog {
    /**
    * 
    */
    private Integer id;

    /**
    * 添加日期
    */
    private Date addDate;

    /**
    * 操作内容
    */
    private String operate;

    /**
    * 操作员ID
    */
    private Integer hrid;
}