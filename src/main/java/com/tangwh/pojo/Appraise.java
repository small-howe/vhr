package com.tangwh.pojo;

import java.util.Date;
import lombok.Data;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:12
 * @version 1.0
 */
@Data
public class Appraise {
    /**
    * 
    */
    private Integer id;

    /**
    * 
    */
    private Integer eid;

    /**
    * 考评日期
    */
    private Date appDate;

    /**
    * 考评结果
    */
    private String appResult;

    /**
    * 考评内容
    */
    private String appContent;

    /**
    * 备注
    */
    private String remark;
}