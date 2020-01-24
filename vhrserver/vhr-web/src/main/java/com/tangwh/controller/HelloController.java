package com.tangwh.controller;

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

    @GetMapping("/employee/basic/hello")
    public String hello2(){

        return "/employee/basic/hello";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello3(){

        return "/employee/advanced/hello";
    }
}
