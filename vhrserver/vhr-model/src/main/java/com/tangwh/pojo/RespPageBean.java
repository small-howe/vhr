package com.tangwh.pojo;

import lombok.Data;

import java.util.List;

/**
 * 分页的 工具类
 */
@Data
public class RespPageBean {
    // 总记录数
    private Long total;

    private List<?> data;


}
