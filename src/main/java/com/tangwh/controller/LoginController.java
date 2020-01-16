package com.tangwh.controller;

import com.tangwh.pojo.RespEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tangweihao
 * @version 1.0
 * @date 2020/1/1 11:07
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    // @CrossOrigin("*") 跨域问题
    public RespEntity login(){
        return RespEntity.error("尚未登录,请登录后再试");
    }
}
