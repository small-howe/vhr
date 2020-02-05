package com.tangwh.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */
@Data
public class Employee implements  Serializable {
    /**
    * 员工编号
    */
    private Integer id;

    /**
    * 员工姓名
    */
    private String name;

    /**
    * 性别
    */
    private String gender;

    /**
    * 出生日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date birthday;

    /**
    * 身份证号
    */
    private String idCard;

    /**
    * 婚姻状况
    */
    private String wedlock;

    /**
    * 民族
    */
    private Integer nationId;

    /**
    * 籍贯
    */
    private String nativePlace;

    /**
    * 政治面貌
    */
    private Integer politicId;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 电话号码
    */
    private String phone;

    /**
    * 联系地址
    */
    private String address;

    /**
    * 所属部门
    */
    private Integer departmentId;

    /**
    * 职称ID
    */
    private Integer jobLevelId;

    /**
    * 职位ID
    */
    private Integer posId;

    /**
    * 聘用形式
    */
    private String engageForm;

    /**
    * 最高学历
    */
    private String tiptopDegree;

    /**
    * 所属专业
    */
    private String specialty;

    /**
    * 毕业院校
    */
    private String school;

    /**
    * 入职日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date beginDate;

    /**
    * 在职状态
    */
    private String workState;

    /**
    * 工号
    */
    private String workID;

    /**
    * 合同期限
    */
    private Double contractTerm;

    /**
    * 转正日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date conversionTime;

    /**
    * 离职日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date notWorkDate;

    /**
    * 合同起始日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date beginContract;

    /**
    * 合同终止日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date endContract;

    /**
    * 工龄
    */
    private Integer workAge;

    private Nation nation;
    private Politicsstatus politicsstatus;
    private Department department;
    private Joblevel joblevel;
    private Position position;


}