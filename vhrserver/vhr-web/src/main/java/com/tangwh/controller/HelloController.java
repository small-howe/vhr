package com.tangwh.controller;

import com.tangwh.mapper.HrMapper;
import com.tangwh.mapper.extmapper.HrExtMapper;
import com.tangwh.pojo.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tangweihao
 * @version 1.0
 * @date 2019/12/29 19:46
 */
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(){

        return "Hello";
    }


    @Autowired
    HrExtMapper hrExtMapper;

    @GetMapping("/employee/basic/hello")
    public String hello2(){

      String hr = hrExtMapper.selectPwd();

        System.out.println(hr);


        return "/employee/basic/hello";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello3(){

        return "/employee/advanced/hello";
    }
}
