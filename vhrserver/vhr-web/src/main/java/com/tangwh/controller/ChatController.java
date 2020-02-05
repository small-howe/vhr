package com.tangwh.controller;

import com.tangwh.pojo.Hr;
import com.tangwh.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 聊天Controller 只要登录就能访问到
 */

@RestController
@RequestMapping("/chat")
public class ChatController {


    @Autowired
    HrService hrService;

    /**
     *  查询所有用户 不包含自己
     * @return
     */
    @GetMapping("/hrs")
    public List<Hr> getAllHrs(){
        return  hrService.getAllHrsExceptCurrentHr();

    }
}
