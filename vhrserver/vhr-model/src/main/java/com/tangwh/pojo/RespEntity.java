package com.tangwh.pojo;

/**
 * @author Tangweihao
 * @version 1.0
 * @date 2019/12/31 21:02
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespEntity {


    public static RespEntity ok(String msg){

        return new RespEntity(200, msg, null);
    }


    public static RespEntity ok(String msg,Object object){

        return new RespEntity(200, msg, object);
    }

    public static RespEntity error(String msg){

        return new RespEntity(500, msg, null);
    }
    public static RespEntity error(String msg,Object object){

        return new RespEntity(200, msg, object);
    }

    private Integer status;

    private String msg;

    private Object object;


}
