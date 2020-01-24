package com.tangwh.exception;

import com.tangwh.pojo.RespEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     *  获取关于SQL 所有的异常信息 不让在控制台打印
     * @return
     */
    @ExceptionHandler(SQLException.class)
    public RespEntity SQLException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return RespEntity.error("这个数据有关联数据,操作失败");
        }
        return RespEntity.error("数据库异常,操作失败");
    }


}
